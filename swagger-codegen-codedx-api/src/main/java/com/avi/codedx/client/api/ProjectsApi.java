package com.avi.codedx.client.api;

import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.Configuration;
import com.avi.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.avi.codedx.client.api.FileMapping;
import com.avi.codedx.client.api.MappingsRequest;
import com.avi.codedx.client.api.Project;
import com.avi.codedx.client.api.ProjectFile;
import com.avi.codedx.client.api.ProjectQuery;
import com.avi.codedx.client.api.ProjectQueryResponse;
import com.avi.codedx.client.api.Projects;
import com.avi.codedx.client.api.Roles;
import com.avi.codedx.client.api.Status;
import com.avi.codedx.client.api.UpdateProject;
import com.avi.codedx.client.api.UserRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-27T11:18:43.181-05:00")
public class ProjectsApi {
  private ApiClient apiClient;

  public ProjectsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProjectsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create Project
   * Create a new project. 
   * @param project Project to add, omit id. (required)
   * @throws ApiException if fails to make API call
   */
  public void createProject(Project project) throws ApiException {
    Object localVarPostBody = project;
    
    // verify the required parameter 'project' is set
    if (project == null) {
      throw new ApiException(400, "Missing the required parameter 'project' when calling createProject");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Delete Project
   * Delete a project. 
   * @param projectId The ID of the project. (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteProject(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteProject");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * User Roles
   * Provides a list of all User roles. 
   * @param projectId The ID of the project. (required)
   * @return List&lt;UserRole&gt;
   * @throws ApiException if fails to make API call
   */
  public List<UserRole> getAllUserRoles(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAllUserRoles");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/user-roles"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<List<UserRole>> localVarReturnType = new GenericType<List<UserRole>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * File Mappings
   * Provides source path mappings for a project. 
   * @param projectId The ID of the project. (required)
   * @param request  (required)
   * @return Map&lt;String, FileMapping&gt;
   * @throws ApiException if fails to make API call
   */
  public Map<String, FileMapping> getMappings(Integer projectId, MappingsRequest request) throws ApiException {
    Object localVarPostBody = request;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getMappings");
    }
    
    // verify the required parameter 'request' is set
    if (request == null) {
      throw new ApiException(400, "Missing the required parameter 'request' when calling getMappings");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/files/mappings"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Map<String, FileMapping>> localVarReturnType = new GenericType<Map<String, FileMapping>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Project Files
   * Provides a list of files for a project. 
   * @param projectId The ID of the project. (required)
   * @return List&lt;ProjectFile&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProjectFile> getProjectFiles(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectFiles");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/files"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<List<ProjectFile>> localVarReturnType = new GenericType<List<ProjectFile>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List Projects
   * Lists all projects. 
   * @return Projects
   * @throws ApiException if fails to make API call
   */
  public Projects getProjects() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/projects";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Projects> localVarReturnType = new GenericType<Projects>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Project Statuses
   * Provides information on all valid triage statuses for a project. 
   * @param projectId The ID of the project. (required)
   * @return Map&lt;String, Status&gt;
   * @throws ApiException if fails to make API call
   */
  public Map<String, Status> getStatuses(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getStatuses");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/statuses"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Map<String, Status>> localVarReturnType = new GenericType<Map<String, Status>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * User Role
   * Provides a User Role for a given user. 
   * @param projectId The ID of the project. (required)
   * @param userId The user ID. (required)
   * @return UserRole
   * @throws ApiException if fails to make API call
   */
  public UserRole getUserRole(Integer projectId, Integer userId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getUserRole");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling getUserRole");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/user-roles/user/{user-id}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()))
      .replaceAll("\\{" + "user-id" + "\\}", apiClient.escapeString(userId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<UserRole> localVarReturnType = new GenericType<UserRole>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Query Projects
   * Get a list of projects which match some filter/query criteria, and which you are allowed to view. 
   * @param query Should be a JSON object with a \&quot;filter\&quot; field, which is an object with the following fields&amp;#58; - &#x60;name&#x60; - an optional String. If given, specifies that each matching project should contain the given text in their name (case-insensitive) - &#x60;metadata&#x60; - an optional Object. If given, specifies that each matching project&#39;s metadata should match the criteria given in the metadata object. - &#x60;parentId&#x60; - an optional Integer or &#x60;null&#x60;. If given, specifies that each matching project should be a direct child of the parent project, or if &#x60;parentId&#x60; is &#x60;null&#x60;, each matching project should be a top-level project.  Each of the fields in the filter object are optional, but the filter object itself is mandatory. A blank &#x60;filter&#x60; object matches all projects. The &#x60;filter.metadata&#x60; Object&#39;s keys and values should be the names of Project Metadata Fields and their respective search criteria. The value for each field will be interpreted according to that field&#39;s type&amp;#58; - **Text** and **Multiline** fields will check if the value is present in the project&#39;s value for that field (case-insensitive) - **Tags** fields will interpret the value as a set of tags, and will check if the project&#39;s tags contains at least one of them (case-insensitive) - **Dropdown** fields will check if the project&#39;s selected value is equal to the criteria value (case-insensitive)  Note that in some cases, you may need to specify the metadata field by its ID (e.g. if two different fields have the same name, or if you simply would prefer to use ID instead of name). In these cases, you can use a string in the format &#x60;id:&lt;ID&gt;&#x60; (e.g. &#x60;id:3&#x60;) in place of the field name as a key in the metadata criteria object.  This endpoint also supports pagination via the optional &#x60;offset&#x60; and &#x60;limit&#x60; fields, which may be specified in the body alongside the &#x60;filter&#x60;. Specifying an &#x60;offset&#x60; without also specifying a &#x60;limit&#x60; is an error.  (required)
   * @return List&lt;ProjectQueryResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProjectQueryResponse> queryProjects(ProjectQuery query) throws ApiException {
    Object localVarPostBody = query;
    
    // verify the required parameter 'query' is set
    if (query == null) {
      throw new ApiException(400, "Missing the required parameter 'query' when calling queryProjects");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/query";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<List<ProjectQueryResponse>> localVarReturnType = new GenericType<List<ProjectQueryResponse>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Get the number of projects which match some filter/query criteria, and which you are allowed to view. 
   * @param query Should be a JSON object with a \&quot;filter\&quot; field. See the \&quot;Query Projects\&quot; endpoint (above) for details. Note that while the model for this request body is the same as with \&quot;Query Projects\&quot;, the &#x60;offset&#x60; and &#x60;limit&#x60; fields will be ignored.  (required)
   * @throws ApiException if fails to make API call
   */
  public void queryProjectsCount(ProjectQuery query) throws ApiException {
    Object localVarPostBody = query;
    
    // verify the required parameter 'query' is set
    if (query == null) {
      throw new ApiException(400, "Missing the required parameter 'query' when calling queryProjectsCount");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/query/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Update Project
   * Update a project by changing its name or parent 
   * @param projectId The ID of the project. (required)
   * @param body Request Body should be a JSON object with the following fields#58; - &#x60;name&#x60; (String) if provided, specifies the new name for the project - &#x60;parentId&#x60; (Number | null) if provided, specifies the ID of the project&#39;s parent (for project grouping)  (required)
   * @throws ApiException if fails to make API call
   */
  public void updateProject(Integer projectId, UpdateProject body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateProject");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling updateProject");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Update User Role
   * Allows changing user roles. Note that you must specify the entire set of roles each time; if you fail to include a role when using this method, the user will lose that role. 
   * @param projectId The ID of the project. (required)
   * @param userId The user ID. (required)
   * @param request  (required)
   * @throws ApiException if fails to make API call
   */
  public void updateUserRole(Integer projectId, Integer userId, Roles request) throws ApiException {
    Object localVarPostBody = request;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateUserRole");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling updateUserRole");
    }
    
    // verify the required parameter 'request' is set
    if (request == null) {
      throw new ApiException(400, "Missing the required parameter 'request' when calling updateUserRole");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/user-roles/user/{user-id}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()))
      .replaceAll("\\{" + "user-id" + "\\}", apiClient.escapeString(userId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
