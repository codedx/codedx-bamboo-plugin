package com.avi.codedx.bambooplugin;

import com.atlassian.bamboo.collections.ActionParametersMap;
import com.atlassian.bamboo.task.AbstractTaskConfigurator;
import com.atlassian.bamboo.task.TaskDefinition;
import com.atlassian.bamboo.utils.error.ErrorCollection;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.api.Project;
import com.avi.codedx.client.api.ProjectsApi;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodeDXScanTaskConfigurator extends AbstractTaskConfigurator {

    @java.lang.Override
    public Map<String, String> generateTaskConfigMap(final ActionParametersMap params, final TaskDefinition previousTaskDefinition) {

        final Map<String, String> config = super.generateTaskConfigMap(params, previousTaskDefinition);

        config.put("analysisName", params.getString("analysisName"));
        config.put("selectedProjectId", params.getString("selectedProjectId"));
        return config;
    }

    public void validate(final ActionParametersMap params, final ErrorCollection errorCollection) {

        super.validate(params, errorCollection);

        final String analysisName = params.getString("analysisName");
        if (StringUtils.isEmpty(analysisName))
        {
            errorCollection.addError("analysisName", "Missing Code DX Analysis Name.");
        }
    }

    private static List<Project> getProjectList() {

        ApiClient cdxApiClient = new ApiClient();
        cdxApiClient.setBasePath(ServerConfigManager.getUrl());
        cdxApiClient.setApiKey(ServerConfigManager.getApiKey());

        ProjectsApi projectsApi = new ProjectsApi();
        projectsApi.setApiClient(cdxApiClient);

        // TODO: Fix hang on connection refused
        try {
            return projectsApi.getProjects().getProjects();
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return new ArrayList<Project>();
    }

    @Override
    public void populateContextForCreate(final Map<String, Object> context) {

        super.populateContextForCreate(context);

        context.put("url", "http://localhost:8080");
        context.put("apiKey", "api-key-goes-here");
        context.put("analysisName", "Bamboo Analysis");

        List<Project> projectList = getProjectList();
        context.put("projectList", projectList);

        if (projectList.size() > 0) {
            context.put("selectedProjectId", projectList.get(0).getId().toString());
        }
    }

    @Override
    public void populateContextForEdit(Map<String, Object> context, TaskDefinition taskDefinition) {

        super.populateContextForEdit(context, taskDefinition);

        context.put("url", taskDefinition.getConfiguration().get("url"));
        context.put("apiKey", taskDefinition.getConfiguration().get("apiKey"));
        context.put("analysisName", taskDefinition.getConfiguration().get("analysisName"));
        context.put("projectList", getProjectList());
        context.put("selectedProjectId", taskDefinition.getConfiguration().get("selectedProjectId"));
    }
}
