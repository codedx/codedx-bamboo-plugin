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

    private static final Severity[] severities = Severity.all;

    @java.lang.Override
    public Map<String, String> generateTaskConfigMap(final ActionParametersMap params, final TaskDefinition previousTaskDefinition) {

        final Map<String, String> config = super.generateTaskConfigMap(params, previousTaskDefinition);

        config.put("useDefaults", params.getBoolean("useDefaults") ? "true" : "false");
        config.put("url", params.getString("url"));
        config.put("apiKey", params.getString("apiKey"));
        config.put("fingerprint", params.getString("fingerprint"));
        config.put("analysisName", params.getString("analysisName"));
        config.put("selectedProjectId", params.getString("selectedProjectId"));
        config.put("includePaths", params.getString("includePaths"));
        config.put("excludePaths", params.getString("excludePaths"));
        config.put("toolOutputFiles", params.getString("toolOutputFiles"));
        config.put("reportArchiveName", params.getString("reportArchiveName"));
        config.put("waitForResults", params.getBoolean("waitForResults") ? "true" : "false");
        config.put("selectedFailureSeverity", params.getString("selectedFailureSeverity"));
        config.put("onlyConsiderNewFindings", params.getString("onlyConsiderNewFindings"));
        return config;
    }

    public void validate(final ActionParametersMap params, final ErrorCollection errorCollection) {

        super.validate(params, errorCollection);

        final String analysisName = params.getString("analysisName");
        if (StringUtils.isEmpty(analysisName)) {
            errorCollection.addError("analysisName", "Missing Code Dx Analysis Name.");
        }

        final String selectedProjectId = params.getString("selectedProjectId");
        if (StringUtils.isEmpty(selectedProjectId)) {
            errorCollection.addError("selectedProjectId", "Missing Selected Project.");
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

        if ((Boolean)context.get("useDefaults")) {
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
        context.put("defaultsSet", defaultsSet);

        String defaultUrl = emptyIfNull(ServerConfigManager.getUrl());
        String defaultApiKey = emptyIfNull(ServerConfigManager.getApiKey());
        String defaultFingerprint = emptyIfNull(ServerConfigManager.getFingerprint());

        context.put("useDefaults", defaultsSet);
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

        boolean defaultsSet = ServerConfigManager.getDefaultsSet();
        context.put("defaultsSet", defaultsSet);

        String defaultUrl = emptyIfNull(ServerConfigManager.getUrl());
        String defaultApiKey = emptyIfNull(ServerConfigManager.getApiKey());
        String defaultFingerprint = emptyIfNull(ServerConfigManager.getFingerprint());

        boolean useDefaults = Boolean.parseBoolean(taskDefinition.getConfiguration().get("useDefaults"));
        context.put("useDefaults", useDefaults);
        if (defaultsSet && useDefaults) {
            context.put("url", defaultUrl);
            context.put("apiKey", defaultApiKey);
            context.put("fingerprint", defaultFingerprint);
        } else {
            context.put("url", taskDefinition.getConfiguration().get("url"));
            context.put("apiKey", taskDefinition.getConfiguration().get("apiKey"));
            context.put("fingerprint", taskDefinition.getConfiguration().get("fingerprint"));
        }
        context.put("defaultUrl", defaultUrl);
        context.put("defaultApiKey", defaultApiKey);
        context.put("defaultFingerprint", defaultFingerprint);

        context.put("analysisName", taskDefinition.getConfiguration().get("analysisName"));
        context.put("reachabilityMessage", "");

        List<Project> projects = getProjectList(context);
        String selectedProjectId = taskDefinition.getConfiguration().get("selectedProjectId");
        if (selectedProjectId != null && !selectedProjectId.isEmpty() && projects.size() == 0) {
            // Case where user already selected a project, but we can't communicate with CodeDx for the name.  Just use a generic "name".
            Project p = new Project();
            p.setId(Integer.parseInt(selectedProjectId));
            p.setName("Project Id: " + selectedProjectId);
            projects.add(p);
        }

        context.put("projectList", projects);
        context.put("selectedProjectId", selectedProjectId);
        context.put("includePaths", taskDefinition.getConfiguration().get("includePaths"));
        context.put("excludePaths", taskDefinition.getConfiguration().get("excludePaths"));
        context.put("toolOutputFiles", taskDefinition.getConfiguration().get("toolOutputFiles"));
        context.put("reportArchiveName", taskDefinition.getConfiguration().get("reportArchiveName"));
        context.put("waitForResults", taskDefinition.getConfiguration().get("waitForResults"));
        context.put("severities", severities);
        context.put("selectedFailureSeverity", taskDefinition.getConfiguration().get("selectedFailureSeverity"));
        context.put("onlyConsiderNewFindings", taskDefinition.getConfiguration().get("onlyConsiderNewFindings"));
    }

    // Helper
    private static String emptyIfNull(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
