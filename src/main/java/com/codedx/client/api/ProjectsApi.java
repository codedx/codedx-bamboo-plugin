package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.AnalysisConfiguration;
import com.codedx.client.model.BuildBrokenPolicySpecifierParameter;
import com.codedx.client.model.CreateProjectRequest;
import com.codedx.client.model.Error;
import com.codedx.client.model.FileMapping;
import com.codedx.client.model.GetPolicyAssociations200Response;
import com.codedx.client.model.GetToolConnectorConfigFormToolParameter;
import com.codedx.client.model.IncompleteWork;
import com.codedx.client.model.MappingsRequest;
import com.codedx.client.model.Project;
import com.codedx.client.model.ProjectDetails;
import com.codedx.client.model.ProjectFile;
import com.codedx.client.model.ProjectQuery;
import com.codedx.client.model.ProjectQueryResponse;
import com.codedx.client.model.Projects;
import com.codedx.client.model.Roles;
import com.codedx.client.model.SetPolicyAssociationsRequest;
import com.codedx.client.model.Status;
import com.codedx.client.model.UpdateProject;
import com.codedx.client.model.UserRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ProjectsApi {
  private ApiClient apiClient;

  public ProjectsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProjectsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API client
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API client
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Checks if a project is in violation with a specified policy such that a build should be broken.
   * Checks if a project is in violation with a specified policy such that a build should be broken.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param policySpecifier A specifier for a policy. It can denote a single policy, or all policies (&#x60;any&#x60;). (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Build should break flag was successfully retrieved </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Policy was provided, but no Policy with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Boolean buildBroken(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull BuildBrokenPolicySpecifierParameter policySpecifier) throws ApiException {
    return buildBrokenWithHttpInfo(projectVersionContext, policySpecifier).getData();
  }

  /**
   * Checks if a project is in violation with a specified policy such that a build should be broken.
   * Checks if a project is in violation with a specified policy such that a build should be broken.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param policySpecifier A specifier for a policy. It can denote a single policy, or all policies (&#x60;any&#x60;). (required)
   * @return ApiResponse&lt;Boolean&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Build should break flag was successfully retrieved </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Policy was provided, but no Policy with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Boolean> buildBrokenWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull BuildBrokenPolicySpecifierParameter policySpecifier) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling buildBroken");
    }
    if (policySpecifier == null) {
      throw new ApiException(400, "Missing the required parameter 'policySpecifier' when calling buildBroken");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/policies/{policy-specifier}/build-broken"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{policy-specifier}", apiClient.escapeString(policySpecifier.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI("ProjectsApi.buildBroken", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create Project
   * Create a new project.  Requires the \&quot;project:create\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param createProjectRequest Project to add, omit id. (required)
   * @return Project
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Project created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have site read permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Project createProject(@jakarta.annotation.Nonnull CreateProjectRequest createProjectRequest) throws ApiException {
    return createProjectWithHttpInfo(createProjectRequest).getData();
  }

  /**
   * Create Project
   * Create a new project.  Requires the \&quot;project:create\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param createProjectRequest Project to add, omit id. (required)
   * @return ApiResponse&lt;Project&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Project created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have site read permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Project> createProjectWithHttpInfo(@jakarta.annotation.Nonnull CreateProjectRequest createProjectRequest) throws ApiException {
    // Check required parameters
    if (createProjectRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'createProjectRequest' when calling createProject");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Project> localVarReturnType = new GenericType<Project>() {};
    return apiClient.invokeAPI("ProjectsApi.createProject", "/api/projects", "POST", new ArrayList<>(), createProjectRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Project
   * Delete a project.  Requires the \&quot;project:delete\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param projectId The ID of the project. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The project was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have site read permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Project cannot be deleted due to a queued or running analysis </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProject(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    deleteProjectWithHttpInfo(projectId);
  }

  /**
   * Delete Project
   * Delete a project.  Requires the \&quot;project:delete\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The project was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have site read permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Project cannot be deleted due to a queued or running analysis </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProjectWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteProject");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ProjectsApi.deleteProject", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Edit Project Analysis Configuration
   * Allows user to edit the analysis configuration for one or more projects.  Requires the \&quot;project:manage-analysis-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectSpecifier A project ID or a special string representation of a set of projects:  - To represent a single project, use that project&#39;s ID number, e.g. &#x60;12&#x60; - To represent all projects, use &#x60;all&#x60; - To represent an arbitrary set of projects, join the IDs of each project with an underscore, e.g. &#x60;12_42_123_124&#x60; - To include &#39;descendant&#39; projects, add a &#x60;d&#x60; before the IDs of the main projects, e.g. &#x60;d12&#x60; or &#x60;d12_42_123_124&#x60; (note that there is only one &#x60;d&#x60; needed; it applies to each of the specified projects) (required)
   * @param analysisConfiguration  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Analysis Configuration successfully edited </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project or rule set matches the provided id(s) </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void editProjectAnalysisConfig(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter projectSpecifier, @jakarta.annotation.Nonnull AnalysisConfiguration analysisConfiguration) throws ApiException {
    editProjectAnalysisConfigWithHttpInfo(projectSpecifier, analysisConfiguration);
  }

  /**
   * Edit Project Analysis Configuration
   * Allows user to edit the analysis configuration for one or more projects.  Requires the \&quot;project:manage-analysis-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectSpecifier A project ID or a special string representation of a set of projects:  - To represent a single project, use that project&#39;s ID number, e.g. &#x60;12&#x60; - To represent all projects, use &#x60;all&#x60; - To represent an arbitrary set of projects, join the IDs of each project with an underscore, e.g. &#x60;12_42_123_124&#x60; - To include &#39;descendant&#39; projects, add a &#x60;d&#x60; before the IDs of the main projects, e.g. &#x60;d12&#x60; or &#x60;d12_42_123_124&#x60; (note that there is only one &#x60;d&#x60; needed; it applies to each of the specified projects) (required)
   * @param analysisConfiguration  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Analysis Configuration successfully edited </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project or rule set matches the provided id(s) </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> editProjectAnalysisConfigWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter projectSpecifier, @jakarta.annotation.Nonnull AnalysisConfiguration analysisConfiguration) throws ApiException {
    // Check required parameters
    if (projectSpecifier == null) {
      throw new ApiException(400, "Missing the required parameter 'projectSpecifier' when calling editProjectAnalysisConfig");
    }
    if (analysisConfiguration == null) {
      throw new ApiException(400, "Missing the required parameter 'analysisConfiguration' when calling editProjectAnalysisConfig");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-specifier}/analysis-config"
            .replaceAll("\\{project-specifier}", apiClient.escapeString(projectSpecifier.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ProjectsApi.editProjectAnalysisConfig", localVarPath, "PATCH", new ArrayList<>(), analysisConfiguration,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get All Projects Details
   * Allows user to get details for all projects.  This endpoint will only return results for projects the user has the \&quot;project:view\&quot; permission, which is included by default on the \&quot;Reader\&quot; role.
   * @param expand Whether or not to include additional data for the projects. When &#x60;false&#x60;, the output contains only the project name and ID as returned by the &#x60;/api/projects&#x60; endpoint.  The default value is &#x60;true&#x60;. (optional)
   * @return List&lt;ProjectDetails&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of ProjectDetails objects </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ProjectDetails> getAllProjectsDetails(@jakarta.annotation.Nullable Boolean expand) throws ApiException {
    return getAllProjectsDetailsWithHttpInfo(expand).getData();
  }

  /**
   * Get All Projects Details
   * Allows user to get details for all projects.  This endpoint will only return results for projects the user has the \&quot;project:view\&quot; permission, which is included by default on the \&quot;Reader\&quot; role.
   * @param expand Whether or not to include additional data for the projects. When &#x60;false&#x60;, the output contains only the project name and ID as returned by the &#x60;/api/projects&#x60; endpoint.  The default value is &#x60;true&#x60;. (optional)
   * @return ApiResponse&lt;List&lt;ProjectDetails&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of ProjectDetails objects </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ProjectDetails>> getAllProjectsDetailsWithHttpInfo(@jakarta.annotation.Nullable Boolean expand) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "expand", expand)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ProjectDetails>> localVarReturnType = new GenericType<List<ProjectDetails>>() {};
    return apiClient.invokeAPI("ProjectsApi.getAllProjectsDetails", "/x/projects", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * User Roles
   * Provides a list of all User roles.  Requires the \&quot;project:manage-permissions\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;UserRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of user roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You do not have the Manager role for the given project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project with the specified id, or no user with the specified id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserRole> getAllUserRoles(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getAllUserRolesWithHttpInfo(projectId).getData();
  }

  /**
   * User Roles
   * Provides a list of all User roles.  Requires the \&quot;project:manage-permissions\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;UserRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of user roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You do not have the Manager role for the given project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project with the specified id, or no user with the specified id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserRole>> getAllUserRolesWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAllUserRoles");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/user-roles"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserRole>> localVarReturnType = new GenericType<List<UserRole>>() {};
    return apiClient.invokeAPI("ProjectsApi.getAllUserRoles", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * File Mappings
   * Provides source path mappings for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param mappingsRequest  (required)
   * @return Map&lt;String, FileMapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the set of file path mappings </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Bad request body </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permissions for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, FileMapping> getMappings(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull MappingsRequest mappingsRequest) throws ApiException {
    return getMappingsWithHttpInfo(projectVersionContext, mappingsRequest).getData();
  }

  /**
   * File Mappings
   * Provides source path mappings for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param mappingsRequest  (required)
   * @return ApiResponse&lt;Map&lt;String, FileMapping&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the set of file path mappings </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Bad request body </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permissions for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, FileMapping>> getMappingsWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull MappingsRequest mappingsRequest) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getMappings");
    }
    if (mappingsRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'mappingsRequest' when calling getMappings");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/files/mappings"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Map<String, FileMapping>> localVarReturnType = new GenericType<Map<String, FileMapping>>() {};
    return apiClient.invokeAPI("ProjectsApi.getMappings", localVarPath, "POST", new ArrayList<>(), mappingsRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List associated policies.
   * Lists all policies that are associated with a project.
   * @param projectId The ID of the project. (required)
   * @return GetPolicyAssociations200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Contains a list of associated policies </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Project was provided, but no Project with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetPolicyAssociations200Response getPolicyAssociations(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getPolicyAssociationsWithHttpInfo(projectId).getData();
  }

  /**
   * List associated policies.
   * Lists all policies that are associated with a project.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;GetPolicyAssociations200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Contains a list of associated policies </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Project was provided, but no Project with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetPolicyAssociations200Response> getPolicyAssociationsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getPolicyAssociations");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/policies"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetPolicyAssociations200Response> localVarReturnType = new GenericType<GetPolicyAssociations200Response>() {};
    return apiClient.invokeAPI("ProjectsApi.getPolicyAssociations", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Details
   * Allows user to get details for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ProjectDetails
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a ProjectDetails objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ProjectDetails getProjectDetails(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectDetailsWithHttpInfo(projectId).getData();
  }

  /**
   * Get Project Details
   * Allows user to get details for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;ProjectDetails&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a ProjectDetails objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProjectDetails> getProjectDetailsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectDetails");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ProjectDetails> localVarReturnType = new GenericType<ProjectDetails>() {};
    return apiClient.invokeAPI("ProjectsApi.getProjectDetails", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Project Files
   * Provides a list of files for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;ProjectFile&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of files </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ProjectFile> getProjectFiles(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectFilesWithHttpInfo(projectId).getData();
  }

  /**
   * Project Files
   * Provides a list of files for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;ProjectFile&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of files </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ProjectFile>> getProjectFilesWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectFiles");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/files"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ProjectFile>> localVarReturnType = new GenericType<List<ProjectFile>>() {};
    return apiClient.invokeAPI("ProjectsApi.getProjectFiles", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Incomplete Work
   * Allows user to get incomplete work for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;IncompleteWork&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of IncompleteWork objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<IncompleteWork> getProjectIncompleteWork(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectIncompleteWorkWithHttpInfo(projectId).getData();
  }

  /**
   * Get Project Incomplete Work
   * Allows user to get incomplete work for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;IncompleteWork&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of IncompleteWork objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<IncompleteWork>> getProjectIncompleteWorkWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectIncompleteWork");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/incomplete-work"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<IncompleteWork>> localVarReturnType = new GenericType<List<IncompleteWork>>() {};
    return apiClient.invokeAPI("ProjectsApi.getProjectIncompleteWork", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Projects
   * Lists all projects.  This endpoint will list projects for which the user has the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param expand Whether or not to include additional data for the projects. When &#x60;true&#x60;, the output contains the same information as the &#x60;/x/projects&#x60; endpoint.  The default value is &#x60;false&#x60;. (optional)
   * @return Projects
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of projects </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have site read permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Projects getProjects(@jakarta.annotation.Nullable Boolean expand) throws ApiException {
    return getProjectsWithHttpInfo(expand).getData();
  }

  /**
   * List Projects
   * Lists all projects.  This endpoint will list projects for which the user has the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param expand Whether or not to include additional data for the projects. When &#x60;true&#x60;, the output contains the same information as the &#x60;/x/projects&#x60; endpoint.  The default value is &#x60;false&#x60;. (optional)
   * @return ApiResponse&lt;Projects&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of projects </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have site read permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Projects> getProjectsWithHttpInfo(@jakarta.annotation.Nullable Boolean expand) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "expand", expand)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Projects> localVarReturnType = new GenericType<Projects>() {};
    return apiClient.invokeAPI("ProjectsApi.getProjects", "/api/projects", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Project Statuses
   * Provides information on all valid triage statuses for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return Map&lt;String, Status&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the project status information </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, Status> getStatuses(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    return getStatusesWithHttpInfo(projectQueryContext).getData();
  }

  /**
   * Project Statuses
   * Provides information on all valid triage statuses for a project.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;Map&lt;String, Status&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the project status information </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, Status>> getStatusesWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling getStatuses");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-query-context}/statuses"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Map<String, Status>> localVarReturnType = new GenericType<Map<String, Status>>() {};
    return apiClient.invokeAPI("ProjectsApi.getStatuses", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * User Role
   * Provides a User Role for a given user.  Requires the \&quot;project:manage-permissions\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param userId The user ID. (required)
   * @return UserRole
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the user role for the given user </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You do not have the Manager role for the given project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project with the specified id, or no user with the specified id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public UserRole getUserRole(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer userId) throws ApiException {
    return getUserRoleWithHttpInfo(projectId, userId).getData();
  }

  /**
   * User Role
   * Provides a User Role for a given user.  Requires the \&quot;project:manage-permissions\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param userId The user ID. (required)
   * @return ApiResponse&lt;UserRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the user role for the given user </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You do not have the Manager role for the given project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project with the specified id, or no user with the specified id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<UserRole> getUserRoleWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer userId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getUserRole");
    }
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling getUserRole");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/user-roles/user/{user-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{user-id}", apiClient.escapeString(userId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<UserRole> localVarReturnType = new GenericType<UserRole>() {};
    return apiClient.invokeAPI("ProjectsApi.getUserRole", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Query Projects
   * Get a list of projects which match some filter/query criteria, and which you are allowed to view.  This endpoint will list projects for which the user has the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQuery Should be a JSON object with a \&quot;filter\&quot; field, which is an object with the following fields: - &#x60;name&#x60; - an optional String. If given, specifies that each matching project should contain the given text in their name (case-insensitive) - &#x60;metadata&#x60; - an optional Object. If given, specifies that each matching project&#39;s metadata should match the criteria given in the metadata object. - &#x60;parentId&#x60; - an optional Integer or &#x60;null&#x60;. If given, specifies that each matching project should be a direct child of the parent project, or if &#x60;parentId&#x60; is &#x60;null&#x60;, each matching project should be a top-level project. - &#x60;ancestorId&#x60; - an optional Integer or &#x60;null&#x60;. If given, specifies that each matching project should be a descendant of the ancestor project, or if &#x60;ancestorId&#x60; is &#x60;null&#x60;, each matching project should be a root level project.  Each of the fields in the filter object are optional, but the filter object itself is mandatory. A blank &#x60;filter&#x60; object matches all projects. The &#x60;filter.metadata&#x60; Object&#39;s keys and values should be the names of Project Metadata Fields and their respective search criteria. The value for each field will be interpreted according to that field&#39;s type: - **Text** and **Multiline** fields will check if the value is present in the project&#39;s value for that field (case-insensitive) - **Tags** fields will interpret the value as a set of tags, and will check if the project&#39;s tags contains at least one of them (case-insensitive) - **Dropdown** fields will check if the project&#39;s selected value is equal to the criteria value (case-insensitive)  Note that in some cases, you may need to specify the metadata field by its ID (e.g. if two different fields have the same name, or if you simply would prefer to use ID instead of name). In these cases, you can use a string in the format &#x60;id:&lt;ID&gt;&#x60; (e.g. &#x60;id:3&#x60;) in place of the field name as a key in the metadata criteria object.  This endpoint also supports pagination via the optional &#x60;offset&#x60; and &#x60;limit&#x60; fields, which may be specified in the body alongside the &#x60;filter&#x60;. Specifying an &#x60;offset&#x60; without also specifying a &#x60;limit&#x60; is an error.  (required)
   * @return List&lt;ProjectQueryResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of projects matching the query </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was invalid due to format, referring to nonexistent metadata fields, or referring to ambiguous metadata fields </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ProjectQueryResponse> queryProjects(@jakarta.annotation.Nonnull ProjectQuery projectQuery) throws ApiException {
    return queryProjectsWithHttpInfo(projectQuery).getData();
  }

  /**
   * Query Projects
   * Get a list of projects which match some filter/query criteria, and which you are allowed to view.  This endpoint will list projects for which the user has the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQuery Should be a JSON object with a \&quot;filter\&quot; field, which is an object with the following fields: - &#x60;name&#x60; - an optional String. If given, specifies that each matching project should contain the given text in their name (case-insensitive) - &#x60;metadata&#x60; - an optional Object. If given, specifies that each matching project&#39;s metadata should match the criteria given in the metadata object. - &#x60;parentId&#x60; - an optional Integer or &#x60;null&#x60;. If given, specifies that each matching project should be a direct child of the parent project, or if &#x60;parentId&#x60; is &#x60;null&#x60;, each matching project should be a top-level project. - &#x60;ancestorId&#x60; - an optional Integer or &#x60;null&#x60;. If given, specifies that each matching project should be a descendant of the ancestor project, or if &#x60;ancestorId&#x60; is &#x60;null&#x60;, each matching project should be a root level project.  Each of the fields in the filter object are optional, but the filter object itself is mandatory. A blank &#x60;filter&#x60; object matches all projects. The &#x60;filter.metadata&#x60; Object&#39;s keys and values should be the names of Project Metadata Fields and their respective search criteria. The value for each field will be interpreted according to that field&#39;s type: - **Text** and **Multiline** fields will check if the value is present in the project&#39;s value for that field (case-insensitive) - **Tags** fields will interpret the value as a set of tags, and will check if the project&#39;s tags contains at least one of them (case-insensitive) - **Dropdown** fields will check if the project&#39;s selected value is equal to the criteria value (case-insensitive)  Note that in some cases, you may need to specify the metadata field by its ID (e.g. if two different fields have the same name, or if you simply would prefer to use ID instead of name). In these cases, you can use a string in the format &#x60;id:&lt;ID&gt;&#x60; (e.g. &#x60;id:3&#x60;) in place of the field name as a key in the metadata criteria object.  This endpoint also supports pagination via the optional &#x60;offset&#x60; and &#x60;limit&#x60; fields, which may be specified in the body alongside the &#x60;filter&#x60;. Specifying an &#x60;offset&#x60; without also specifying a &#x60;limit&#x60; is an error.  (required)
   * @return ApiResponse&lt;List&lt;ProjectQueryResponse&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of projects matching the query </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was invalid due to format, referring to nonexistent metadata fields, or referring to ambiguous metadata fields </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ProjectQueryResponse>> queryProjectsWithHttpInfo(@jakarta.annotation.Nonnull ProjectQuery projectQuery) throws ApiException {
    // Check required parameters
    if (projectQuery == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQuery' when calling queryProjects");
    }

    String localVarAccept = apiClient.selectHeaderAccept("*/*", "application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ProjectQueryResponse>> localVarReturnType = new GenericType<List<ProjectQueryResponse>>() {};
    return apiClient.invokeAPI("ProjectsApi.queryProjects", "/api/projects/query", "POST", new ArrayList<>(), projectQuery,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Query Projects Count
   * Get the number of projects which match some filter/query criteria, and which you are allowed to view.  This endpoint will list projects for which the user has the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQuery Should be a JSON object with a \&quot;filter\&quot; field. See the \&quot;Query Projects\&quot; endpoint (above) for details. Note that while the model for this request body is the same as with \&quot;Query Projects\&quot;, the &#x60;offset&#x60; and &#x60;limit&#x60; fields will be ignored.  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the number of projects matching the query </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was invalid due to format, referring to nonexistent metadata fields, or referring to ambiguous metadata fields </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void queryProjectsCount(@jakarta.annotation.Nonnull ProjectQuery projectQuery) throws ApiException {
    queryProjectsCountWithHttpInfo(projectQuery);
  }

  /**
   * Query Projects Count
   * Get the number of projects which match some filter/query criteria, and which you are allowed to view.  This endpoint will list projects for which the user has the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQuery Should be a JSON object with a \&quot;filter\&quot; field. See the \&quot;Query Projects\&quot; endpoint (above) for details. Note that while the model for this request body is the same as with \&quot;Query Projects\&quot;, the &#x60;offset&#x60; and &#x60;limit&#x60; fields will be ignored.  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the number of projects matching the query </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was invalid due to format, referring to nonexistent metadata fields, or referring to ambiguous metadata fields </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> queryProjectsCountWithHttpInfo(@jakarta.annotation.Nonnull ProjectQuery projectQuery) throws ApiException {
    // Check required parameters
    if (projectQuery == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQuery' when calling queryProjectsCount");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ProjectsApi.queryProjectsCount", "/api/projects/query/count", "POST", new ArrayList<>(), projectQuery,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Associates a project with a list of policies.
   * Associates a project with a list of policies.
   * @param projectId The ID of the project. (required)
   * @param setPolicyAssociationsRequest  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Policy associations were successfully set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Project was provided, but no Project with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setPolicyAssociations(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable SetPolicyAssociationsRequest setPolicyAssociationsRequest) throws ApiException {
    setPolicyAssociationsWithHttpInfo(projectId, setPolicyAssociationsRequest);
  }

  /**
   * Associates a project with a list of policies.
   * Associates a project with a list of policies.
   * @param projectId The ID of the project. (required)
   * @param setPolicyAssociationsRequest  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Policy associations were successfully set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Project was provided, but no Project with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setPolicyAssociationsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable SetPolicyAssociationsRequest setPolicyAssociationsRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setPolicyAssociations");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/policies"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ProjectsApi.setPolicyAssociations", localVarPath, "PUT", new ArrayList<>(), setPolicyAssociationsRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update Project
   * Update a project by changing its name or parent.  Requires the \&quot;project:rename\&quot; and \&quot;project:manage-hierarchy\&quot; permissions which are provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param updateProject Request Body should be a JSON object with the following fields: - &#x60;name&#x60; (String) if provided, specifies the new name for the project - &#x60;parentId&#x60; (Number | null) if provided, specifies the ID of the project&#39;s parent (for project grouping)  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The project was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not a JSON object with either a &#x60;name&#x60; or &#x60;parentId&#x60; field, or if either of those two fields was in an incorrect format </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - If the requester does not have the permission to rename or manage hierarchy for that project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project corresponding to &#x60;project-id&#x60; </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateProject(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull UpdateProject updateProject) throws ApiException {
    updateProjectWithHttpInfo(projectId, updateProject);
  }

  /**
   * Update Project
   * Update a project by changing its name or parent.  Requires the \&quot;project:rename\&quot; and \&quot;project:manage-hierarchy\&quot; permissions which are provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param updateProject Request Body should be a JSON object with the following fields: - &#x60;name&#x60; (String) if provided, specifies the new name for the project - &#x60;parentId&#x60; (Number | null) if provided, specifies the ID of the project&#39;s parent (for project grouping)  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The project was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not a JSON object with either a &#x60;name&#x60; or &#x60;parentId&#x60; field, or if either of those two fields was in an incorrect format </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - If the requester does not have the permission to rename or manage hierarchy for that project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project corresponding to &#x60;project-id&#x60; </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateProjectWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull UpdateProject updateProject) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateProject");
    }
    if (updateProject == null) {
      throw new ApiException(400, "Missing the required parameter 'updateProject' when calling updateProject");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ProjectsApi.updateProject", localVarPath, "PUT", new ArrayList<>(), updateProject,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update User Role
   * Allows changing user roles. Note that you must specify the entire set of roles each time; if you fail to include a role when using this method, the user will lose that role.  Requires the \&quot;project:manage-permissions\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param userId The user ID. (required)
   * @param roles  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Indicates a successful update </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body was in the wrong format, or specified a role that does not exist </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You do not have the Manager role for the given project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project with the specified id, or no user with the specified id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserRole(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nonnull Roles roles) throws ApiException {
    updateUserRoleWithHttpInfo(projectId, userId, roles);
  }

  /**
   * Update User Role
   * Allows changing user roles. Note that you must specify the entire set of roles each time; if you fail to include a role when using this method, the user will lose that role.  Requires the \&quot;project:manage-permissions\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param userId The user ID. (required)
   * @param roles  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Indicates a successful update </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body was in the wrong format, or specified a role that does not exist </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You do not have the Manager role for the given project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No project with the specified id, or no user with the specified id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserRoleWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nonnull Roles roles) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateUserRole");
    }
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling updateUserRole");
    }
    if (roles == null) {
      throw new ApiException(400, "Missing the required parameter 'roles' when calling updateUserRole");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/user-roles/user/{user-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{user-id}", apiClient.escapeString(userId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ProjectsApi.updateUserRole", localVarPath, "PUT", new ArrayList<>(), roles,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
