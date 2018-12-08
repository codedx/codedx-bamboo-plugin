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
    public Map<String, String> generateTaskConfigMap(final ActionParametersMap params,
                                                     final TaskDefinition previousTaskDefinition)
    {
        final Map<String, String> config = super.generateTaskConfigMap(params, previousTaskDefinition);

        config.put("analysisname", params.getString("analysisname"));
        return config;
    }

    public void validate(final ActionParametersMap params, final ErrorCollection errorCollection)
    {
        super.validate(params, errorCollection);

        final String apiKey = params.getString("apikey");
        if (StringUtils.isEmpty(apiKey))
        {
            errorCollection.addError("apikey", "Missing Code DX API key.");
        }

        final String urlString = params.getString("url");
        if (StringUtils.isEmpty(urlString))
        {
            errorCollection.addError("url", "Missing Code DX API URL.");
        }

        final String analysisName = params.getString("analysisname");
        if (StringUtils.isEmpty(analysisName))
        {
            errorCollection.addError("analysisname", "Missing Code DX Analysis Name.");
        }
    }

    private static List<Project> getProjectList() {

        ServerConfigManager serverConfigManager = ServerConfigManager.getInstance();

        // TODO: Put this back in and remove hardcoded values after getting persistence working
        /*
        final String apiKey = serverConfigManager.getApikey();
        final String apiUrl = serverConfigManager.getUrl();
        */

        final String apiKey = "f9a03424-d304-46a9-8ed6-03886ca20b85";
        final String apiUrl = "http://localhost:8080";

        ApiClient cdxApiClient = new ApiClient();
        cdxApiClient.setBasePath(apiUrl);
        cdxApiClient.setApiKey(apiKey);

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
    public void populateContextForCreate(final Map<String, Object> context)
    {
        super.populateContextForCreate(context);

        context.put("url", "http://localhost:8080");
        context.put("apikey", "api-key-goes-here");
        context.put("analysisname", "Bamboo Analysis");
        context.put("projectList", getProjectList());
    }

    @Override
    public void populateContextForEdit(Map<String, Object> context, TaskDefinition taskDefinition)
    {
        super.populateContextForEdit(context, taskDefinition);

        context.put("url", taskDefinition.getConfiguration().get("url"));
        context.put("apikey", taskDefinition.getConfiguration().get("apikey"));
        context.put("analysisname", taskDefinition.getConfiguration().get("analysisname"));

        // TODO: Save and load plan config
        //context.put("projectlist",taskDefinition.getConfiguration().get("projectlist"));
    }
}
