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

import javax.ws.rs.ProcessingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodeDXScanTaskConfigurator extends AbstractTaskConfigurator {

    private static final Severity[] severities = Severity.all;

    @java.lang.Override
    public Map<String, String> generateTaskConfigMap(final ActionParametersMap params, final TaskDefinition previousTaskDefinition) {

        final Map<String, String> config = super.generateTaskConfigMap(params, previousTaskDefinition);

        config.put("analysisName", params.getString("analysisName"));
        config.put("selectedProjectId", params.getString("selectedProjectId"));
        config.put("includePaths", params.getString("includePaths"));
        config.put("excludePaths", params.getString("excludePaths"));
        config.put("toolOutputFiles", params.getString("toolOutputFiles"));
        config.put("waitForResults", params.getString("waitForResults"));
        config.put("selectedFailureSeverity", params.getString("selectedFailureSeverity"));
        config.put("onlyConsiderNewFindings", params.getString("onlyConsiderNewFindings"));
        return config;
    }

    public void validate(final ActionParametersMap params, final ErrorCollection errorCollection) {

        super.validate(params, errorCollection);

        final String analysisName = params.getString("analysisName");
        final String selectedProjectId = params.getString("selectedProjectId");
        if (StringUtils.isEmpty(analysisName))
        {
            errorCollection.addError("analysisName", "Missing Code DX Analysis Name.");
        }
        if (StringUtils.isEmpty(selectedProjectId))
        {
            errorCollection.addError("selectedProjectId", "Missing Selected Project.");
        }
    }

    private List<Project> getProjectList(Map<String, Object> context) {

        String url = ServerConfigManager.getUrl();
        String apiKey = ServerConfigManager.getApiKey();
        if (url == null || apiKey == null || url.isEmpty() || apiKey.isEmpty()) {
            context.put("reachabilityMessage", "CodeDx URL and API key are not configured");
            return new ArrayList<Project>();
        }

        ApiClient cdxApiClient = ServerConfigManager.getConfiguredClient();

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
            e.printStackTrace();
        }

        return new ArrayList<Project>();
    }

    @Override
    public void populateContextForCreate(final Map<String, Object> context) {

        super.populateContextForCreate(context);

        context.put("analysisName", "Bamboo Analysis");
        context.put("reachabilityMessage", "");

        List<Project> projectList = getProjectList(context);
        context.put("projectList", projectList);

        if (projectList.size() > 0) {
            context.put("selectedProjectId", projectList.get(0).getId().toString());
        }

        context.put("includePaths", "");
        context.put("excludePaths", "");
        context.put("toolOutputFiles", "");
        context.put("waitForResults", false);
        context.put("severities", severities);
        context.put("selectedFailureSeverity", severities[0]);
        context.put("onlyConsiderNewFindings", false);
    }

    @Override
    public void populateContextForEdit(Map<String, Object> context, TaskDefinition taskDefinition) {

        super.populateContextForEdit(context, taskDefinition);

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
        context.put("waitForResults", taskDefinition.getConfiguration().get("waitForResults"));
        context.put("severities", severities);
        context.put("selectedFailureSeverity", taskDefinition.getConfiguration().get("selectedFailureSeverity"));
        context.put("onlyConsiderNewFindings", taskDefinition.getConfiguration().get("onlyConsiderNewFindings"));
    }
}
