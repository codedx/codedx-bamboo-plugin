package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.AssignFindingRequest;
import com.codedx.client.model.AssignFindingsBulkRequest;
import com.codedx.client.model.DueDateOverride;
import com.codedx.client.model.FindingMetadata;
import com.codedx.client.model.Job;
import com.codedx.client.model.JobIdResponse;
import com.codedx.client.model.PostComment;
import com.codedx.client.model.SetStatus;
import com.codedx.client.model.SetStatusBulk;
import com.codedx.client.model.SeverityOverride;
import com.codedx.client.model.UpdateFindingTagsRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class FindingActionsApi {
  private ApiClient apiClient;

  public FindingActionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FindingActionsApi(ApiClient apiClient) {
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
   * Add Finding Metadata
   * Allows user to add metadata to a finding. If the finding already has metadata with a key that is identical to one provided, that metadata&#39;s value will be updated.  Requires the \&quot;finding:set-metadata\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param findingMetadata List of FindingMetadata objects (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Metadata was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have set-metadata permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void addFindingMetadata(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull List<FindingMetadata> findingMetadata) throws ApiException {
    addFindingMetadataWithHttpInfo(findingId, projectId, findingMetadata);
  }

  /**
   * Add Finding Metadata
   * Allows user to add metadata to a finding. If the finding already has metadata with a key that is identical to one provided, that metadata&#39;s value will be updated.  Requires the \&quot;finding:set-metadata\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param findingMetadata List of FindingMetadata objects (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Metadata was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have set-metadata permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> addFindingMetadataWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull List<FindingMetadata> findingMetadata) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling addFindingMetadata");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling addFindingMetadata");
    }
    if (findingMetadata == null) {
      throw new ApiException(400, "Missing the required parameter 'findingMetadata' when calling addFindingMetadata");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/metadata"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.addFindingMetadata", localVarPath, "POST", new ArrayList<>(), findingMetadata,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Assign Finding
   * Assign a finding to a user.  Requires the \&quot;finding:assign-single\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param assignFindingRequest  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Finding successfully assigned </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to assign the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding or assignee does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void assignFinding(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable AssignFindingRequest assignFindingRequest) throws ApiException {
    assignFindingWithHttpInfo(findingId, projectId, assignFindingRequest);
  }

  /**
   * Assign Finding
   * Assign a finding to a user.  Requires the \&quot;finding:assign-single\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param assignFindingRequest  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Finding successfully assigned </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to assign the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding or assignee does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> assignFindingWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable AssignFindingRequest assignFindingRequest) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling assignFinding");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling assignFinding");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/assign"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.assignFinding", localVarPath, "PUT", new ArrayList<>(), assignFindingRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Bulk Assign Findings
   * Assign findings matching a filter to a user.  Requires the \&quot;finding:assign-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param assignFindingsBulkRequest  (optional)
   * @return JobIdResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job has been created to assign findings </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid, or the user cannot be assigned to some findings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to assign the findings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Assignee does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public JobIdResponse assignFindingsBulk(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable AssignFindingsBulkRequest assignFindingsBulkRequest) throws ApiException {
    return assignFindingsBulkWithHttpInfo(projectQueryContext, assignFindingsBulkRequest).getData();
  }

  /**
   * Bulk Assign Findings
   * Assign findings matching a filter to a user.  Requires the \&quot;finding:assign-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param assignFindingsBulkRequest  (optional)
   * @return ApiResponse&lt;JobIdResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job has been created to assign findings </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid, or the user cannot be assigned to some findings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to assign the findings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Assignee does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<JobIdResponse> assignFindingsBulkWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable AssignFindingsBulkRequest assignFindingsBulkRequest) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling assignFindingsBulk");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-query-context}/findings/bulk/assign"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<JobIdResponse> localVarReturnType = new GenericType<JobIdResponse>() {};
    return apiClient.invokeAPI("FindingActionsApi.assignFindingsBulk", localVarPath, "PUT", new ArrayList<>(), assignFindingsBulkRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Severity Override [Clear]
   * Allows severity overrides for findings to be cleared.  Requires the \&quot;finding:override-severity\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param findingId The finding ID. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Severity override was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid, or severity specified is invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have severity-override permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void clearSeverityOverride(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    clearSeverityOverrideWithHttpInfo(projectVersionContext, findingId);
  }

  /**
   * Severity Override [Clear]
   * Allows severity overrides for findings to be cleared.  Requires the \&quot;finding:override-severity\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param findingId The finding ID. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Severity override was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid, or severity specified is invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have severity-override permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> clearSeverityOverrideWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling clearSeverityOverride");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling clearSeverityOverride");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/{finding-id}/severity-override"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.clearSeverityOverride", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Comment
   * Delete a comment on a finding.   Requires the \&quot;finding:edit-any-comment\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @param commentId The comment ID (required)
   * @param applyInBulk Whether or not the action should be applied to all findings associated with the comment if it is a bulk comment. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to delete this comment on the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding or Comment does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Bulk comments may only be deleted if query parameter &#39;applyInBulk&#39; is set to true </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteComment(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer commentId, @jakarta.annotation.Nullable Boolean applyInBulk) throws ApiException {
    deleteCommentWithHttpInfo(projectId, findingId, commentId, applyInBulk);
  }

  /**
   * Delete Comment
   * Delete a comment on a finding.   Requires the \&quot;finding:edit-any-comment\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @param commentId The comment ID (required)
   * @param applyInBulk Whether or not the action should be applied to all findings associated with the comment if it is a bulk comment. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to delete this comment on the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding or Comment does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Bulk comments may only be deleted if query parameter &#39;applyInBulk&#39; is set to true </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteCommentWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer commentId, @jakarta.annotation.Nullable Boolean applyInBulk) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteComment");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling deleteComment");
    }
    if (commentId == null) {
      throw new ApiException(400, "Missing the required parameter 'commentId' when calling deleteComment");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/comments/{comment-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{comment-id}", apiClient.escapeString(commentId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "applyInBulk", applyInBulk)
    );

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.deleteComment", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Finding Metadata
   * Allows user to delete metadata from a finding.  Requires the \&quot;finding:set-metadata\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param requestBody List of metadata keys (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Metadata was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have set-metadata permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteFindingMetadata(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull List<String> requestBody) throws ApiException {
    deleteFindingMetadataWithHttpInfo(findingId, projectId, requestBody);
  }

  /**
   * Delete Finding Metadata
   * Allows user to delete metadata from a finding.  Requires the \&quot;finding:set-metadata\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param requestBody List of metadata keys (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Metadata was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have set-metadata permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteFindingMetadataWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull List<String> requestBody) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling deleteFindingMetadata");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteFindingMetadata");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling deleteFindingMetadata");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/delete-metadata"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.deleteFindingMetadata", localVarPath, "PUT", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Edit Comment
   * Edit a comment on a finding.  Requires the \&quot;finding:edit-any-comment\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @param commentId The comment ID (required)
   * @param postComment &#x60;content&#x60; should be a string containing the raw markdown content of the new comment (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was successfully edited </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid, or &#x60;content&#x60; is blank or missing </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to comment on the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding or Comment does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Bulk comments may only be edited if query parameter &#39;applyInBulk&#39; is set to true </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void editComment(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer commentId, @jakarta.annotation.Nonnull PostComment postComment) throws ApiException {
    editCommentWithHttpInfo(projectId, findingId, commentId, postComment);
  }

  /**
   * Edit Comment
   * Edit a comment on a finding.  Requires the \&quot;finding:edit-any-comment\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @param commentId The comment ID (required)
   * @param postComment &#x60;content&#x60; should be a string containing the raw markdown content of the new comment (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was successfully edited </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid, or &#x60;content&#x60; is blank or missing </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to comment on the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding or Comment does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Bulk comments may only be edited if query parameter &#39;applyInBulk&#39; is set to true </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> editCommentWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer commentId, @jakarta.annotation.Nonnull PostComment postComment) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling editComment");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling editComment");
    }
    if (commentId == null) {
      throw new ApiException(400, "Missing the required parameter 'commentId' when calling editComment");
    }
    if (postComment == null) {
      throw new ApiException(400, "Missing the required parameter 'postComment' when calling editComment");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/comments/{comment-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{comment-id}", apiClient.escapeString(commentId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.editComment", localVarPath, "PUT", new ArrayList<>(), postComment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update Due Date Override
   * Allows the due date for findings to be overridden.  Requires the \&quot;finding:override-due-date\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param dueDateOverride  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Due Date override was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have due-date-override permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void overrideDueDate(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable DueDateOverride dueDateOverride) throws ApiException {
    overrideDueDateWithHttpInfo(findingId, projectVersionContext, dueDateOverride);
  }

  /**
   * Update Due Date Override
   * Allows the due date for findings to be overridden.  Requires the \&quot;finding:override-due-date\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param dueDateOverride  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Due Date override was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have due-date-override permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> overrideDueDateWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable DueDateOverride dueDateOverride) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling overrideDueDate");
    }
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling overrideDueDate");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/{finding-id}/due-date-override"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.overrideDueDate", localVarPath, "PUT", new ArrayList<>(), dueDateOverride,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Severity Override [Set]
   * Allows severities for findings to be overridden.  Requires the \&quot;finding:override-severity\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param severityOverride  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Severity override was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid, or severity specified is invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have severity-override permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void overrideSeverity(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable SeverityOverride severityOverride) throws ApiException {
    overrideSeverityWithHttpInfo(findingId, projectVersionContext, severityOverride);
  }

  /**
   * Severity Override [Set]
   * Allows severities for findings to be overridden.  Requires the \&quot;finding:override-severity\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param severityOverride  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Severity override was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid, or severity specified is invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have severity-override permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> overrideSeverityWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable SeverityOverride severityOverride) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling overrideSeverity");
    }
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling overrideSeverity");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/{finding-id}/severity-override"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.overrideSeverity", localVarPath, "PUT", new ArrayList<>(), severityOverride,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Post Comment
   * Post a new comment on a finding.  Requires the \&quot;finding:comment\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param postComment &#x60;content&#x60; should be a string containing the raw markdown content of the new comment (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was successfully posted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid, or &#x60;content&#x60; is blank or missing </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to comment on the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void postComment(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull PostComment postComment) throws ApiException {
    postCommentWithHttpInfo(findingId, projectId, postComment);
  }

  /**
   * Post Comment
   * Post a new comment on a finding.  Requires the \&quot;finding:comment\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param postComment &#x60;content&#x60; should be a string containing the raw markdown content of the new comment (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was successfully posted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid, or &#x60;content&#x60; is blank or missing </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to comment on the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> postCommentWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull PostComment postComment) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling postComment");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling postComment");
    }
    if (postComment == null) {
      throw new ApiException(400, "Missing the required parameter 'postComment' when calling postComment");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/comment"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.postComment", localVarPath, "POST", new ArrayList<>(), postComment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Bulk Update Triage Status
   * Allows bulk updating of triage statuses of multiple findings, controlled by a filter. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint.  Requires the \&quot;finding:triage-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param setStatusBulk  (optional)
   * @return Job
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job was started for performing the bulk status update </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid or status ID is invalid or unassignable </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Job setBulkStatus(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable SetStatusBulk setStatusBulk) throws ApiException {
    return setBulkStatusWithHttpInfo(projectVersionContext, setStatusBulk).getData();
  }

  /**
   * Bulk Update Triage Status
   * Allows bulk updating of triage statuses of multiple findings, controlled by a filter. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint.  Requires the \&quot;finding:triage-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param setStatusBulk  (optional)
   * @return ApiResponse&lt;Job&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job was started for performing the bulk status update </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid or status ID is invalid or unassignable </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Job> setBulkStatusWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable SetStatusBulk setStatusBulk) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling setBulkStatus");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/bulk-status-update"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI("FindingActionsApi.setBulkStatus", localVarPath, "POST", new ArrayList<>(), setStatusBulk,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Set Finding Metadata
   * Allows user to override a finding&#39;s metadata.  Requires the \&quot;finding:set-metadata\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param findingMetadata List of FindingMetadata objects (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Metadata was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have set-metadata permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setFindingMetadata(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull List<FindingMetadata> findingMetadata) throws ApiException {
    setFindingMetadataWithHttpInfo(findingId, projectId, findingMetadata);
  }

  /**
   * Set Finding Metadata
   * Allows user to override a finding&#39;s metadata.  Requires the \&quot;finding:set-metadata\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectId The ID of the project. (required)
   * @param findingMetadata List of FindingMetadata objects (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Metadata was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have set-metadata permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setFindingMetadataWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull List<FindingMetadata> findingMetadata) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling setFindingMetadata");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setFindingMetadata");
    }
    if (findingMetadata == null) {
      throw new ApiException(400, "Missing the required parameter 'findingMetadata' when calling setFindingMetadata");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-id}/findings/{finding-id}/set-metadata"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.setFindingMetadata", localVarPath, "PUT", new ArrayList<>(), findingMetadata,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update Triage Status
   * Allows changing of the triage status of a single finding. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint.  Requires the \&quot;finding:triage-single\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param setStatus &#x60;status&#x60; should be a valid status ID  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Status was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid, or status ID is invalid or unassignable </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setStatus(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull SetStatus setStatus) throws ApiException {
    setStatusWithHttpInfo(findingId, projectVersionContext, setStatus);
  }

  /**
   * Update Triage Status
   * Allows changing of the triage status of a single finding. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint.  Requires the \&quot;finding:triage-single\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param setStatus &#x60;status&#x60; should be a valid status ID  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Status was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid, or status ID is invalid or unassignable </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setStatusWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull SetStatus setStatus) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling setStatus");
    }
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling setStatus");
    }
    if (setStatus == null) {
      throw new ApiException(400, "Missing the required parameter 'setStatus' when calling setStatus");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/{finding-id}/status"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.setStatus", localVarPath, "PUT", new ArrayList<>(), setStatus,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update finding tags
   * Add or remove tags from finding(s).  Requires the \&quot;tagging:assing\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param updateFindingTagsRequest A json object containing a finding filter, the names of tags to add to those findings, and the names of tags to remove from those findings. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Finding tag update succeeded </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - A tag name was provided that is greater than 32 characters in length </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to update finding tags in this project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A tag name was provided for removal that does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A tag name was provided for addition that does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateFindingTags(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull UpdateFindingTagsRequest updateFindingTagsRequest) throws ApiException {
    updateFindingTagsWithHttpInfo(projectQueryContext, updateFindingTagsRequest);
  }

  /**
   * Update finding tags
   * Add or remove tags from finding(s).  Requires the \&quot;tagging:assing\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param updateFindingTagsRequest A json object containing a finding filter, the names of tags to add to those findings, and the names of tags to remove from those findings. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Finding tag update succeeded </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - A tag name was provided that is greater than 32 characters in length </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to update finding tags in this project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A tag name was provided for removal that does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A tag name was provided for addition that does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateFindingTagsWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull UpdateFindingTagsRequest updateFindingTagsRequest) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling updateFindingTags");
    }
    if (updateFindingTagsRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'updateFindingTagsRequest' when calling updateFindingTags");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-query-context}/finding-tags"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingActionsApi.updateFindingTags", localVarPath, "PUT", new ArrayList<>(), updateFindingTagsRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
