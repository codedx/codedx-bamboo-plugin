package com.avi.codedx.bambooplugin;

import com.atlassian.bamboo.build.logger.BuildLogger;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.task.TaskType;
import com.atlassian.spring.container.ContainerManager;
import com.atlassian.util.concurrent.NotNull;
import com.avi.codedx.bambooplugin.utils.Archiver;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.api.*;
import org.apache.commons.lang.exception.ExceptionUtils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodeDXScanTask implements TaskType{

    @NotNull
    @java.lang.Override
    public TaskResult execute(final TaskContext taskContext) throws TaskException
    {
        final BuildLogger buildLogger = taskContext.getBuildLogger();

        ServerConfigManager serverConfigManager = ServerConfigManager.getInstance();

        final String apiKey = serverConfigManager.getApikey();
        final String apiUrl = serverConfigManager.getUrl();
        final String analysisNameString = taskContext.getConfigurationMap().get("analysisname");
        buildLogger.addBuildLogEntry("Running Code DX at " + apiUrl);

        ApiClient cdxApiClient = new ApiClient();
        cdxApiClient.setBasePath(apiUrl);
        cdxApiClient.setApiKey(apiKey);

        AnalysisApi analysisApi = new AnalysisApi();
        analysisApi.setApiClient(cdxApiClient);

        FindingDataApi findingDataApi = new FindingDataApi();
        findingDataApi.setApiClient(cdxApiClient);

        int projectId; // TODO: acquire project ID by interacting with the API before even running the task
        String projectName; // TODO: acquire project name by interacting with the API before running the task
        ProjectsApi projectsApi = new ProjectsApi();
        projectsApi.setApiClient(cdxApiClient);
        try {
            Projects projects = projectsApi.getProjects();
            if(projects.getProjects().size() > 0)
            {
                Project firstProject = projects.getProjects().get(0);
                projectId = firstProject.getId();
                projectName = firstProject.getName();
                buildLogger.addBuildLogEntry("Running Code DX Scan on the project \"" + firstProject.getName() + "\"");

                List<File> filesToUpload = new ArrayList<>();
                filesToUpload.add(Archiver.archive(taskContext.getRootDirectory(), "", "", "files_to_scan"));
                // TODO: add tool file outputs

                String analysisPrepId = uploadFiles(filesToUpload, projectId, analysisApi, buildLogger);

                boolean readyToRunAnalysis = false;
                while(!readyToRunAnalysis) {
                    Thread.sleep(1000);

                    AnalysisQueryResponse response = analysisApi.queryAnalysisPrepState(analysisPrepId);
                    List<String> inputIds = response.getInputIds();
                    List<String> verificationErrors = response.getVerificationErrors();

                    if(inputIds.size() == filesToUpload.size() && verificationErrors.isEmpty()) {
                        readyToRunAnalysis = true;
                    } else if (inputIds.size() == filesToUpload.size() && !verificationErrors.isEmpty()) {
                        String errorMessage = getVerificationErrorMessage(verificationErrors);
                        buildLogger.addBuildLogEntry(errorMessage);
                        return TaskResultBuilder.newBuilder(taskContext).failed().build();
                    }
                }

                String jobId = runAnalysis(analysisPrepId, projectId, projectName, analysisNameString,
                        analysisApi, buildLogger);
                return getAnalysisResults(jobId, true, cdxApiClient, taskContext, buildLogger);
            }
            else {
                buildLogger.addBuildLogEntry("No projects available in Code DX to scan.");
                return TaskResultBuilder.newBuilder(taskContext).success().failed().build();
            }
        } catch (ApiException|IOException|InterruptedException e) {
            buildLogger.addBuildLogEntry("ERROR:\n" + ExceptionUtils.getFullStackTrace(e));
            return TaskResultBuilder.newBuilder(taskContext).failed().build();
        }
    }

    private String uploadFiles(List<File> files, int projectId, AnalysisApi analysisApi, BuildLogger buildLogger) throws ApiException, IOException {
        ProjectId project = new ProjectId();
        project.setProjectId(projectId);

        AnalysisPrepResponse analysisPrep = analysisApi.createAnalysisPrep(project);
        String analysisPrepId = analysisPrep.getPrepId();

        for (File file : files) {
            buildLogger.addBuildLogEntry("Uploading file: " + file.getCanonicalPath());
            analysisApi.uploadFile(analysisPrepId, file, null);
        }

        return analysisPrepId;
    }

    @org.jetbrains.annotations.NotNull
    private String getVerificationErrorMessage(List<String> verificationErrors) {
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("Code Dx reported verification errors for attempted analysis: \n");

        for(String error : verificationErrors) {
            errorMessage.append(error).append("\n");
        }
        return errorMessage.toString();
    }

    private String runAnalysis(String analysisPrepId, int projectId, String projectName, String analysisNameString,
                               AnalysisApi analysisApi, BuildLogger buildLogger) throws ApiException, InterruptedException {
        buildLogger.addBuildLogEntry("Running Code Dx analysis");
        Analysis analysis = analysisApi.runPreparedAnalysis(analysisPrepId);

        if (!projectName.isEmpty()) {
            int analysisId = analysis.getAnalysisId();
            AnalysisName analysisName = new AnalysisName();
            analysisName.setName(analysisNameString);

            analysisApi.setAnalysisName(projectId, analysisId, analysisName);
        }
        return analysis.getJobId();
    }

    private TaskResult getAnalysisResults(String jobId, boolean waitForAnalysisResults, ApiClient apiClient, TaskContext taskContext, BuildLogger buildLogger) throws ApiException, InterruptedException, IOException {

        if (!waitForAnalysisResults) {
            return TaskResultBuilder.newBuilder(taskContext).success().build();
        }

        buildLogger.addBuildLogEntry("Waiting for Code Dx analysis results");

        boolean isAnalysisFinished = false;
        JobsApi jobsApi = new JobsApi();
        jobsApi.setApiClient(apiClient);

        while(!isAnalysisFinished) {
            Thread.sleep(5000);

            Job job = jobsApi.getJobStatus(jobId);
            JobStatus status = job.getStatus();
            if(status == null)
                buildLogger.addBuildLogEntry("Job status is null for job " +  jobId);
            else
                buildLogger.addBuildLogEntry(status.getValue());

            if (status == JobStatus.COMPLETED) {
                isAnalysisFinished = true;
            } else if(status == JobStatus.FAILED) {
                buildLogger.addBuildLogEntry("The Code Dx analysis has reported a failure");
                return TaskResultBuilder.newBuilder(taskContext).failed().build();
            }
        }

        // TODO: report code DX results back to the user

        return TaskResultBuilder.newBuilder(taskContext).success().build();
    }
}
