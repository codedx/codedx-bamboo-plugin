package com.codedx.bambooplugin;

import com.atlassian.bamboo.collections.ActionParametersMap;
import com.atlassian.bamboo.task.AbstractTaskConfigurator;
import com.atlassian.bamboo.task.TaskDefinition;
import com.atlassian.bamboo.utils.error.ErrorCollection;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiException;
import com.codedx.client.api.Project;
import com.codedx.client.api.ProjectsApi;
import org.apache.commons.lang.StringUtils;

import javax.ws.rs.ProcessingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodeDxScanTaskConfigurator extends AbstractTaskConfigurator {

    // Since much work was done surrounding saving invalid configs, lets keep the code and toggle it with a flag.
    private static final boolean ALLOW_SAVE_INVALID_CONFIG = true;

    private static final Severity[] severities = Severity.all;

    // Tracks if we are going into an edit after a failed save attempt and remembers the credentials the user put in
    private FailedCredentials failedSave = null;

    private static class FailedCredentials {
        private String useDefaults;
        private String url;
        private String apiKey;
        private String fingerprint;

        public boolean missingSelectedProject;

        public FailedCredentials(final ActionParametersMap params) {
            useDefaults = params.getString("useDefaults");
            url = params.getString("url");
            apiKey = params.getString("apiKey");
            fingerprint = params.getString("fingerprint");

            missingSelectedProject = StringUtils.isEmpty(params.getString("selectedProjectId"));

            if (url == null && Boolean.parseBoolean(useDefaults)) {
                url = emptyIfNull(ServerConfigManager.getUrl());
                apiKey = emptyIfNull(ServerConfigManager.getApiKey());
                fingerprint = emptyIfNull(ServerConfigManager.getFingerprint());
            }
        }

        public void setContext(Map<String, Object> context) {
            context.put("useDefaults", useDefaults);
            context.put("url", url);
            context.put("apiKey", apiKey);
            context.put("fingerprint", fingerprint);
        }
    }

    @java.lang.Override
    public Map<String, String> generateTaskConfigMap(final ActionParametersMap params, final TaskDefinition previousTaskDefinition) {

        final Map<String, String> config = super.generateTaskConfigMap(params, previousTaskDefinition);

        // Save succeeded.  Set this back to false.
        this.failedSave = null;

        config.put("useDefaults", params.getString("useDefaults"));
        config.put("url", params.getString("url"));
        config.put("apiKey", params.getString("apiKey"));
        config.put("fingerprint", params.getString("fingerprint"));
        config.put("analysisName", params.getString("analysisName"));
        config.put("selectedProjectId", params.getString("selectedProjectId"));
        config.put("includePaths", params.getString("includePaths"));
        config.put("excludePaths", params.getString("excludePaths"));
        config.put("toolOutputFiles", params.getString("toolOutputFiles"));
        config.put("reportArchiveName", params.getString("reportArchiveName"));
        config.put("waitForResults", params.getString("waitForResults"));
        config.put("selectedFailureSeverity", params.getString("selectedFailureSeverity"));
        config.put("onlyConsiderNewFindings", params.getString("onlyConsiderNewFindings"));

        return config;
    }

    public void validate(final ActionParametersMap params, final ErrorCollection errorCollection) {

        super.validate(params, errorCollection);

        if (ALLOW_SAVE_INVALID_CONFIG) {
            return;
        }

        // Will be set back to false in generateTaskConfigMap(...) if save succeeds
        this.failedSave = new FailedCredentials(params);

        final String analysisName = params.getString("analysisName");
        if (StringUtils.isEmpty(analysisName)) {
            errorCollection.addError("analysisName", "Missing Code Dx Analysis Name.");
        }

        final String selectedProjectId = params.getString("selectedProjectId");
        if (StringUtils.isEmpty(selectedProjectId)) {
            errorCollection.addError("selectedProjectId", "Missing Selected Project.");
        }

        final String includePaths = params.getString("includePaths");
        if (StringUtils.isEmpty(includePaths)) {
            errorCollection.addError("includePaths", "Missing source and binary files.");
        }

        final String useDefaults = params.getString("useDefaults");
        if (!Boolean.parseBoolean(useDefaults)) {

            final String url = params.getString("url");
            if (url != null && !url.isEmpty()) {
                // Make sure the URL is valid
                try {
                    new URL(url);
                } catch (MalformedURLException e) {
                    errorCollection.addError("url", "Invalid URL");
                }
            } else {
                errorCollection.addError("url", "Missing Code Dx URL.");
            }

            final String apiKey = params.getString("apiKey");
            if (StringUtils.isEmpty(apiKey)) {
                errorCollection.addError("apiKey", "Missing Code Dx Api Key.");
            }
        }
    }

    private static List<Project> getProjectList(Map<String, Object> context) {

        String url = null;
        String apiKey = null;
        String fingerprint = null;

        // We check defaultsSet in case the defaults were erased.  We have what they used to be in the task configuration.
        if (context.get("useDefaults").equals("true") && ServerConfigManager.getDefaultsSet()) {
            url = ServerConfigManager.getUrl();
            apiKey = ServerConfigManager.getApiKey();
            fingerprint = ServerConfigManager.getFingerprint();
        } else {
            url = context.get("url").toString();
            apiKey = context.get("apiKey").toString();
            fingerprint = context.get("fingerprint").toString();
        }

        if (url == null || apiKey == null || url.isEmpty() || apiKey.isEmpty()) {
            context.put("reachabilityMessage", "CodeDx URL and API key are not configured");
            return new ArrayList<Project>();
        }

        ApiClient cdxApiClient = ServerConfigManager.getConfiguredClient(url, apiKey, fingerprint);

        ProjectsApi projectsApi = new ProjectsApi();
        projectsApi.setApiClient(cdxApiClient);

        try {
            return projectsApi.getProjects().getProjects();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ProcessingException e) {
            context.put("reachabilityMessage", "CodeDx is unreachable");
        }

        return new ArrayList<Project>();
    }

    @Override
    public void populateContextForCreate(final Map<String, Object> context) {

        super.populateContextForCreate(context);

        boolean defaultsSet = ServerConfigManager.getDefaultsSet();
        context.put("defaultsSet", String.valueOf(defaultsSet));
        context.put("failedSave", String.valueOf(failedSave));

        String defaultUrl = emptyIfNull(ServerConfigManager.getUrl());
        String defaultApiKey = emptyIfNull(ServerConfigManager.getApiKey());
        String defaultFingerprint = emptyIfNull(ServerConfigManager.getFingerprint());

        context.put("useDefaults", String.valueOf(defaultsSet));
        if (defaultsSet) {
            context.put("url", defaultUrl);
            context.put("apiKey", defaultApiKey);
            context.put("fingerprint", defaultFingerprint);
        } else {
            context.put("url", "");
            context.put("apiKey", "");
            context.put("fingerprint", "");
        }
        context.put("defaultUrl", defaultUrl);
        context.put("defaultApiKey", defaultApiKey);
        context.put("defaultFingerprint", defaultFingerprint);

        context.put("analysisName", "Bamboo Analysis");
        context.put("reachabilityMessage", "");

        List<Project> projectList = getProjectList(context);
        context.put("projectList", projectList);

        if (projectList.size() > 0) {
            context.put("selectedProjectId", projectList.get(0).getId().toString());
        }

        context.put("includePaths", "**");
        context.put("excludePaths", "");
        context.put("toolOutputFiles", "");
        context.put("reportArchiveName", "");
        context.put("waitForResults", false);
        context.put("severities", severities);
        context.put("selectedFailureSeverity", severities[0]);
        context.put("onlyConsiderNewFindings", false);
    }

    @Override
    public void populateContextForEdit(Map<String, Object> context, TaskDefinition taskDefinition) {

        super.populateContextForEdit(context, taskDefinition);

        // Get saved user config
        Map<String, String> config = taskDefinition.getConfiguration();

        // Keep track of weather or not we got here after failing to save a configuration
        context.put("failedSave", String.valueOf(failedSave));

        // To populate the dropdown of severity thresholds
        context.put("severities", severities);

        // Boolean to denote weather or not the user set up default Code Dx server credentials on the admin page
        boolean defaultsSet = ServerConfigManager.getDefaultsSet();
        context.put("defaultsSet", String.valueOf(defaultsSet));

        // The default Code Dx server credentials - if they were set up by the user on the admin page
        String defaultUrl = emptyIfNull(ServerConfigManager.getUrl());
        String defaultApiKey = emptyIfNull(ServerConfigManager.getApiKey());
        String defaultFingerprint = emptyIfNull(ServerConfigManager.getFingerprint());
        context.put("defaultUrl", defaultUrl);
        context.put("defaultApiKey", defaultApiKey);
        context.put("defaultFingerprint", defaultFingerprint);

        // Populate context from saved task config
        context.put("analysisName", config.get("analysisName"));
        context.put("includePaths", config.get("includePaths"));
        context.put("excludePaths", config.get("excludePaths"));
        context.put("toolOutputFiles", config.get("toolOutputFiles"));
        context.put("reportArchiveName", config.get("reportArchiveName"));
        context.put("waitForResults", config.get("waitForResults"));
        context.put("selectedFailureSeverity", config.get("selectedFailureSeverity"));
        context.put("onlyConsiderNewFindings", config.get("onlyConsiderNewFindings"));

        if (failedSave != null) {

            failedSave.setContext(context);

        } else {

            // Weather or not the task is using the default Code Dx server credentials from the admin page.
            boolean useDefaults = Boolean.parseBoolean(config.get("useDefaults"));

            context.put("useDefaults", String.valueOf(useDefaults));

            // We check defaultsSet in case the defaults were erased.  In that case we have what they used to be in the task configuration.
            if (useDefaults && defaultsSet) {
                context.put("url", defaultUrl);
                context.put("apiKey", defaultApiKey);
                context.put("fingerprint", defaultFingerprint);
            } else {
                context.put("url", config.get("url"));
                context.put("apiKey", config.get("apiKey"));
                context.put("fingerprint", config.get("fingerprint"));
            }
        }

        List<Project> projectList = getProjectList(context);

        String selectedProjectId = config.get("selectedProjectId");
        context.put("selectedProjectId", selectedProjectId);

        if (selectedProjectId != null && !selectedProjectId.isEmpty() && projectList.size() == 0 && (failedSave == null || !failedSave.missingSelectedProject)) {
            // Case where user already selected a project, but we can't communicate with CodeDx for the name.  Just use a generic "name".
            Project p = new Project();
            p.setId(Integer.parseInt(selectedProjectId));
            p.setName("Project Id: " + selectedProjectId);
            projectList.add(p);

            // We get here if the previously selected project is not found
            if (context.get("reachabilityMessage") == null) {
                context.put("reachabilityMessage", "Unable to access previously selected project from Code Dx");
            }
        }

        context.put("projectList", projectList);

        if (context.get("reachabilityMessage") == null) {
            context.put("reachabilityMessage", "");
        }

        // Reset this in case they cancel out of the page
        failedSave = null;
    }

    // Helper
    private static String emptyIfNull(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
