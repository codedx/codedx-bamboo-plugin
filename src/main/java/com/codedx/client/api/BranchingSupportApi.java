package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Branch;
import com.codedx.client.model.BranchHierarchy;
import com.codedx.client.model.BranchName;
import com.codedx.client.model.DefaultBranchName;
import com.codedx.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class BranchingSupportApi {
  private ApiClient apiClient;

  public BranchingSupportApi() {
    this(Configuration.getDefaultApiClient());
  }

  public BranchingSupportApi(ApiClient apiClient) {
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
   * Query branch count on project
   * Query the number of branches associated with a project.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the number of branches on the specified project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer branchCount(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return branchCountWithHttpInfo(projectId).getData();
  }

  /**
   * Query branch count on project
   * Query the number of branches associated with a project.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the number of branches on the specified project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> branchCountWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling branchCount");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/count"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("BranchingSupportApi.branchCount", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Query branch count for finding in project
   * Query the number of branches associated with a finding in a project.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the number of branches on the specified project that the specified finding appears in </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer branchCountForFinding(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    return branchCountForFindingWithHttpInfo(projectId, findingId).getData();
  }

  /**
   * Query branch count for finding in project
   * Query the number of branches associated with a finding in a project.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the number of branches on the specified project that the specified finding appears in </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> branchCountForFindingWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling branchCountForFinding");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling branchCountForFinding");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/branches/count"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("BranchingSupportApi.branchCountForFinding", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get the list of branch hierarchies for a project
   * Get the list of branch hierarchies for a project.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;BranchHierarchy&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of branch hierarchies for a project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<BranchHierarchy> branchHierarchy(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return branchHierarchyWithHttpInfo(projectId).getData();
  }

  /**
   * Get the list of branch hierarchies for a project
   * Get the list of branch hierarchies for a project.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;BranchHierarchy&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of branch hierarchies for a project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<BranchHierarchy>> branchHierarchyWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling branchHierarchy");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/hierarchy"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<BranchHierarchy>> localVarReturnType = new GenericType<List<BranchHierarchy>>() {};
    return apiClient.invokeAPI("BranchingSupportApi.branchHierarchy", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get the default branch for a project
   * Get the default branch for a projet.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return Branch
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of this project&#39;s branches. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Branch defaultBranch(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return defaultBranchWithHttpInfo(projectId).getData();
  }

  /**
   * Get the default branch for a project
   * Get the default branch for a projet.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Branch&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of this project&#39;s branches. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Branch> defaultBranchWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling defaultBranch");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/default"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Branch> localVarReturnType = new GenericType<Branch>() {};
    return apiClient.invokeAPI("BranchingSupportApi.defaultBranch", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a branch on a project
   * Delete a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchId The branch ID (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteBranchById(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer branchId) throws ApiException {
    deleteBranchByIdWithHttpInfo(projectId, branchId);
  }

  /**
   * Delete a branch on a project
   * Delete a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchId The branch ID (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteBranchByIdWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer branchId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteBranchById");
    }
    if (branchId == null) {
      throw new ApiException(400, "Missing the required parameter 'branchId' when calling deleteBranchById");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/{branch-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{branch-id}", apiClient.escapeString(branchId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("BranchingSupportApi.deleteBranchById", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a branch on a project
   * Delete a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchName The branch name (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The default branch for a project cannot be deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteBranchByName(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String branchName) throws ApiException {
    deleteBranchByNameWithHttpInfo(projectId, branchName);
  }

  /**
   * Delete a branch on a project
   * Delete a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchName The branch name (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The default branch for a project cannot be deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteBranchByNameWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String branchName) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteBranchByName");
    }
    if (branchName == null) {
      throw new ApiException(400, "Missing the required parameter 'branchName' when calling deleteBranchByName");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/by-name/{branch-name}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{branch-name}", apiClient.escapeString(branchName.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("BranchingSupportApi.deleteBranchByName", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * List a project&#39;s branches
   * Lists a project&#39;s branches.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;Branch&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of this project&#39;s branches. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Branch> listBranches(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return listBranchesWithHttpInfo(projectId).getData();
  }

  /**
   * List a project&#39;s branches
   * Lists a project&#39;s branches.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;Branch&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of this project&#39;s branches. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Branch>> listBranchesWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling listBranches");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Branch>> localVarReturnType = new GenericType<List<Branch>>() {};
    return apiClient.invokeAPI("BranchingSupportApi.listBranches", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List the branches on a project in which a finding appears
   * List the branches on a project which a finding appears.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return List&lt;Branch&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of this project&#39;s branches. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Branch> listBranchesForFinding(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    return listBranchesForFindingWithHttpInfo(projectId, findingId).getData();
  }

  /**
   * List the branches on a project in which a finding appears
   * List the branches on a project which a finding appears.  Requires the \&quot;project:view\&quot; permission, which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return ApiResponse&lt;List&lt;Branch&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of this project&#39;s branches. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Branch>> listBranchesForFindingWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling listBranchesForFinding");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling listBranchesForFinding");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/branches"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Branch>> localVarReturnType = new GenericType<List<Branch>>() {};
    return apiClient.invokeAPI("BranchingSupportApi.listBranchesForFinding", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Rename a branch on a project
   * Rename a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchId The branch ID (required)
   * @param branchName  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Branch name already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void renameBranchById(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer branchId, @jakarta.annotation.Nonnull BranchName branchName) throws ApiException {
    renameBranchByIdWithHttpInfo(projectId, branchId, branchName);
  }

  /**
   * Rename a branch on a project
   * Rename a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchId The branch ID (required)
   * @param branchName  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Branch name already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> renameBranchByIdWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer branchId, @jakarta.annotation.Nonnull BranchName branchName) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling renameBranchById");
    }
    if (branchId == null) {
      throw new ApiException(400, "Missing the required parameter 'branchId' when calling renameBranchById");
    }
    if (branchName == null) {
      throw new ApiException(400, "Missing the required parameter 'branchName' when calling renameBranchById");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/{branch-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{branch-id}", apiClient.escapeString(branchId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("BranchingSupportApi.renameBranchById", localVarPath, "PUT", new ArrayList<>(), branchName,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Rename a branch on a project
   * Rename a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchName The branch name (required)
   * @param branchName2  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The default branch for a project cannot be deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Branch name already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void renameBranchByName(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String branchName, @jakarta.annotation.Nonnull BranchName branchName2) throws ApiException {
    renameBranchByNameWithHttpInfo(projectId, branchName, branchName2);
  }

  /**
   * Rename a branch on a project
   * Rename a branch on a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param branchName The branch name (required)
   * @param branchName2  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The default branch for a project cannot be deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Branch name already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> renameBranchByNameWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String branchName, @jakarta.annotation.Nonnull BranchName branchName2) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling renameBranchByName");
    }
    if (branchName == null) {
      throw new ApiException(400, "Missing the required parameter 'branchName' when calling renameBranchByName");
    }
    if (branchName2 == null) {
      throw new ApiException(400, "Missing the required parameter 'branchName2' when calling renameBranchByName");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/by-name/{branch-name}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{branch-name}", apiClient.escapeString(branchName.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("BranchingSupportApi.renameBranchByName", localVarPath, "PUT", new ArrayList<>(), branchName2,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set the default branch for a project
   * Set the default branch for a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param defaultBranchName  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully renamed. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setDefaultBranch(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull DefaultBranchName defaultBranchName) throws ApiException {
    setDefaultBranchWithHttpInfo(projectId, defaultBranchName);
  }

  /**
   * Set the default branch for a project
   * Set the default branch for a project.  Requires the \&quot;branch:manage\&quot; permission, which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param defaultBranchName  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Branch was successfully renamed. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or Branch does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setDefaultBranchWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull DefaultBranchName defaultBranchName) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setDefaultBranch");
    }
    if (defaultBranchName == null) {
      throw new ApiException(400, "Missing the required parameter 'defaultBranchName' when calling setDefaultBranch");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/branches/default"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("BranchingSupportApi.setDefaultBranch", localVarPath, "PUT", new ArrayList<>(), defaultBranchName,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
