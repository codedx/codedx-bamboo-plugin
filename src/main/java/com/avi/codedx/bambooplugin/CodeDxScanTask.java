package com.avi.codedx.bambooplugin;

import com.atlassian.bamboo.build.logger.BuildLogger;
import com.atlassian.bamboo.configuration.ConfigurationMap;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.task.TaskType;
import com.atlassian.util.concurrent.NotNull;
import com.avi.codedx.bambooplugin.utils.Archiver;
import com.avi.codedx.bambooplugin.utils.CodeDxBuildStatistics;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CodeDxScanTask implements TaskType {

    // Keeps track of everything we need to know during a single scan.
    private static class ScanTaskState {

        // Task specific
        TaskContext taskContext;
        BuildLogger buildLogger;

        // User settings
        public String apiKey;
        String apiUrl;
        String analysisName;
        int projectId;
        String includePaths;
        String excludePaths;
        String toolOutputFiles;
        boolean waitForResults;
        String failureSeverity;
        boolean onlyConsiderNewFindings;

        // Api related
        ApiClient apiClient;
        AnalysisApi analysisApi;
        FindingDataApi findingDataApi;
        JobsApi jobsApi;

        // Other
        List<File> filesToUpload;
        String analysisPrepId;
        String analysisJobId;
        CodeDxBuildStatistics buildStats;
        List<GroupedCount> groupedCounts;
    }

    @NotNull
    @java.lang.Override
    public TaskResult execute(final TaskContext taskContext) throws TaskException
    {
        ScanTaskState state = new ScanTaskState();

        state.taskContext = taskContext;
        state.buildLogger = taskContext.getBuildLogger();

        log(state, "Starting Code Dx Task.");

        // Split up the work and into "states" for readability and order
        List<Function<ScanTaskState, Boolean>> stateMachine = new ArrayList<Function<ScanTaskState, Boolean>>();

        stateMachine.add(CodeDxScanTask::loadUserPreferences);
        stateMachine.add(CodeDxScanTask::setupApiClient);
        stateMachine.add(CodeDxScanTask::collectFilesToUpload);
        stateMachine.add(CodeDxScanTask::uploadFiles);
        stateMachine.add(CodeDxScanTask::waitForCodeDxToBeReadyForAnalysis);
        stateMachine.add(CodeDxScanTask::startAnalysis);
        stateMachine.add(CodeDxScanTask::handleAnalysisResults);

        boolean success = runStateMachine(stateMachine, state);
        if (success) {
            log(state, "Code Dx Scan Task completed successfully!");
            return TaskResultBuilder.newBuilder(taskContext).success().build();
        } else {
            log(state, "Code Dx Scan Task failed to complete.");
            return TaskResultBuilder.newBuilder(taskContext).failed().build();
        }
    }

    // Runs one state at a time until one fails or we finish
    private static Boolean runStateMachine(List<Function<ScanTaskState, Boolean>> stateMachine, ScanTaskState state) {
        for (Function<ScanTaskState, Boolean> toRun : stateMachine) {
            boolean success = toRun.apply(state);
            if (!success) {
                return false;
            }
        }
        return true;
    }

    // States - Discrete pieces of work to be done.  Returns true for success, false for failure.

    private static Boolean loadUserPreferences(ScanTaskState state) {

        // Load global settings
        log(state, "Loading Code Dx plug-in global settings.");
        state.apiKey = ServerConfigManager.getApiKey();
        state.apiUrl = ServerConfigManager.getUrl();

        if (state.apiUrl == null || state.apiKey == null || state.apiUrl.isEmpty() || state.apiKey.isEmpty()) {
            logError(state, "Code Dx url and api key are not properly configured.  Please configure them on the plug-in settings page.");
            return false;
        }
        log(state, "Code Dx url set to %s", state.apiUrl);

        // Load task specific settings
        log(state, "Loading Task settings.");
        ConfigurationMap config = state.taskContext.getConfigurationMap();
        state.analysisName = config.get("analysisName");
        state.includePaths = config.get("includePaths");
        state.excludePaths = config.get("excludePaths");
        state.projectId = Integer.parseInt(config.get("selectedProjectId"));
        state.toolOutputFiles = config.get("toolOutputFiles");
        state.waitForResults = config.getAsBoolean("waitForResults");
        state.failureSeverity = config.get("selectedFailureSeverity");
        state.onlyConsiderNewFindings = config.getAsBoolean("onlyConsiderNewFindings");

        return true;
    }

    private static Boolean setupApiClient(ScanTaskState state) {
        log(state, "Setting up Code Dx Api Client.");

        state.apiClient = ServerConfigManager.getConfiguredClient();

        state.analysisApi = new AnalysisApi();
        state.analysisApi.setApiClient(state.apiClient);

        state.findingDataApi = new FindingDataApi();
        state.findingDataApi.setApiClient(state.apiClient);

        state.jobsApi = new JobsApi();
        state.jobsApi.setApiClient(state.apiClient);

        return true;
    }

    private static Boolean collectFilesToUpload(ScanTaskState state) {
        log(state, "Archiving source files to upload to Code Dx.");

        state.filesToUpload = new ArrayList<>();
        try {
            state.filesToUpload.add(Archiver.archive(state.taskContext.getRootDirectory(), state.includePaths, state.excludePaths, "files_to_scan"));
        } catch (IOException e) {
            logError(state, "An error occurred when trying to archive source files.");
            return false;
        }

        // Add tool output files
        if (state.toolOutputFiles != null && !state.toolOutputFiles.isEmpty()) {
            log(state, "Collecting tool output files.");
            for (String fileName : state.toolOutputFiles.split(",")) {
                fileName = fileName.trim();
                Path path = Paths.get(fileName);
                File file = path.isAbsolute() ? path.toFile() : new File(state.taskContext.getRootDirectory(), fileName);
                if (file.exists()) {
                    state.filesToUpload.add(file);
                } else {
                    try {
                        log(state, "File: %s does not exist. Skipping...", file.getCanonicalPath());
                    } catch (IOException e) {
                        log(state, "FileName: %s does not exist. Skipping...", fileName);
                    }
                }
            }
        }

        return true;
    }

    private static Boolean uploadFiles(ScanTaskState state) {
        log(state, "Uploading files to Code Dx.");

        ProjectId project = new ProjectId();
        project.setProjectId(state.projectId);

        try {
            AnalysisPrepResponse analysisPrep = state.analysisApi.createAnalysisPrep(project);
            state.analysisPrepId = analysisPrep.getPrepId();

            for (File file : state.filesToUpload) {
                log(state, "Uploading file: %s", file.getCanonicalPath());
                state.analysisApi.uploadFile(state.analysisPrepId, file, null);
            }

        } catch (ApiException e) {
            logApiException(state);
            return false;
        } catch (IOException e) {
            logError(state, "An error occurred when trying to archive source files.");
            return false;
        }

        return true;
    }

    private static Boolean waitForCodeDxToBeReadyForAnalysis(ScanTaskState state) {
        log(state, "Waiting for Code Dx to be ready to start analysis...");

        boolean readyToRunAnalysis = false;
        while(!readyToRunAnalysis) {

            try {
                Thread.sleep(1000); // Consider adding maximum wait time
            } catch (InterruptedException e) {
                logError(state, "An unexpected threading issue occurred.  This could occur if the build is manually cancelled.");
                return false;
            }

            AnalysisQueryResponse response = null;
            try {
                response = state.analysisApi.queryAnalysisPrepState(state.analysisPrepId);
            } catch (ApiException e) {
                logApiException(state);
                return false;
            }

            List<String> inputIds = response.getInputIds();
            List<String> verificationErrors = response.getVerificationErrors();

            if (!verificationErrors.isEmpty()) {

                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Code Dx reported verification errors for attempted analysis: \n");

                for(String error : verificationErrors) {
                    errorMessage.append(error).append("\n");
                }
                logError(state, errorMessage.toString());

                return false;
            }

            if(inputIds.size() == state.filesToUpload.size()) {
                readyToRunAnalysis = true;
            }
        }
        return true;
    }

    private static Boolean startAnalysis(ScanTaskState state) {
        log(state, "Querying Code Dx to start analysis.");

        try {
            Analysis analysis = state.analysisApi.runPreparedAnalysis(state.analysisPrepId);

            if (state.analysisName != null && !state.analysisName.isEmpty()) {
                int analysisId = analysis.getAnalysisId();
                AnalysisName analysisName = new AnalysisName();
                analysisName.setName(state.analysisName);

                state.analysisApi.setAnalysisName(state.projectId, analysisId, analysisName);
            } else {
                logError(state, "An unexpected issue arose regarding the analysis name.  Please double check it in the task configuration page.");
                return false;
            }
            state.analysisJobId = analysis.getJobId();
        } catch (ApiException e) {
            logApiException(state);
            return false;
        }

        return true;
    }

    private static Boolean handleAnalysisResults(ScanTaskState state) {

        if (!state.waitForResults) {
            log(state, "Analysis queued to run in Code Dx.  Task is not configured to wait for results.");
            return true;
        }

        List<Function<ScanTaskState, Boolean>> stateMachine = new ArrayList<Function<ScanTaskState, Boolean>>();

        stateMachine.add(CodeDxScanTask::waitForAnalysisToFinish);
        stateMachine.add(CodeDxScanTask::getBuildStats);
        stateMachine.add(CodeDxScanTask::getGroupedCounts);
        stateMachine.add(CodeDxScanTask::checkFailureSeverity);

        return runStateMachine(stateMachine, state);
    }

    private static Boolean waitForAnalysisToFinish(ScanTaskState state) {
        log(state, "Waiting for Code Dx analysis results...");

        boolean isAnalysisFinished = false;
        String lastStatusValue = null;
        while(!isAnalysisFinished) {

            try {
                Thread.sleep(5000); // Consider adding maximum wait time
            } catch (InterruptedException e) {
                logError(state, "An unexpected threading issue occurred.  This could occur if the build is manually cancelled.");
                return false;
            }

            Job job = null;
            try {
                job = state.jobsApi.getJobStatus(state.analysisJobId);
            } catch (ApiException e) {
                logApiException(state);
                return false;
            }

            JobStatus status = job.getStatus();
            if(status == null) {
                logError(state, "Job status is null for job %s.", state.analysisJobId);
                return false;
            }

            String statusValue = status.getValue();
            if (!statusValue.equals(lastStatusValue)){
                lastStatusValue = statusValue;
                log(state, "Job status: %s", statusValue);
            }

            if (status == JobStatus.COMPLETED) {
                isAnalysisFinished = true;
            } else if(status == JobStatus.FAILED) {
                logError(state, "The Code Dx analysis has reported a failure.");
                return false;
            }
        }

        return true;
    }

    private static Boolean getBuildStats(ScanTaskState state) {
        log(state, "Querying Code Dx for analysis statistics.");

        Filter filter = new Filter();
        filter.put("~status", "gone");

        GroupedCountsRequest bySeverity = new GroupedCountsRequest();
        bySeverity.setFilter(filter);
        bySeverity.setCountBy("severity");

        GroupedCountsRequest byStatus =  new GroupedCountsRequest();
        byStatus.setFilter(filter);
        byStatus.setCountBy("status");

        CodeDxBuildStatistics stats = null;
        try {
            List<GroupedCount> severityGroupedCounts = state.findingDataApi.getFindingsGroupCount(state.projectId, bySeverity);
            List<GroupedCount> statusGroupedCounts = state.findingDataApi.getFindingsGroupCount(state.projectId, byStatus);
            stats = new CodeDxBuildStatistics(severityGroupedCounts, statusGroupedCounts);
        } catch (ApiException e) {
            logApiException(state);
            return false;
        }

        state.buildStats = stats;

        return true;
    }

    private static Boolean getGroupedCounts(ScanTaskState state) {

        if (state.onlyConsiderNewFindings) {

            log(state, "Task configured to only consider new findings.  Querying Code Dx for statistics on new findings.");
            GroupedCountsRequest request = new GroupedCountsRequest();
            Filter filter = new Filter();

            filter.put("status", "new");
            request.setCountBy("severity");
            request.setFilter(filter);

            try {
                state.groupedCounts = state.findingDataApi.getFindingsGroupCount(state.projectId, request);
            } catch (ApiException e) {
                logApiException(state);
                return false;
            }
        } else {
            state.groupedCounts = state.buildStats.getGroupedSeverityCounts();
        }

        return true;
    }

    private static Boolean checkFailureSeverity(ScanTaskState state) {

        if (Severity.isNone(state.failureSeverity)) {
            return true;
        }

        log(state, "Checking%s findings against build failure threshold.", state.onlyConsiderNewFindings ? " new" : "");

        for(int i = Severity.all.length - 1; i >= Severity.indexOf(state.failureSeverity); i--) {
            String severityName = Severity.all[i].name;
            int numberOfFindingsForSeverity = CodeDxBuildStatistics.getNumberOfFindingsForGroupAndName(state.groupedCounts, severityName);
            if (numberOfFindingsForSeverity > 0) {
                logError(state, "Code Dx has reported findings that fail against the configured build failure threshold.  CONFIGURED: %s, FOUND: %s", Severity.nameToDisplayName(state.failureSeverity), severityName);
                return false;
            }
        }

        return true;
    }

    // Helper methods
    private static void log(ScanTaskState state, String format, Object... args) {
        state.buildLogger.addBuildLogEntry(String.format(format, args));
    }

    private static void logError(ScanTaskState state, String format, Object... args) {
        state.buildLogger.addErrorLogEntry(String.format(format, args));
    }

    private static void logApiException(ScanTaskState state) {
        logError(state, "An error occurred while trying to communicate with Code Dx's API.");
    }
}
