package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.BulkComment;
import com.codedx.client.model.BulkDueDateOverride;
import com.codedx.client.model.BulkSeverityOverride;
import com.codedx.client.model.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ActionsApi {
  private ApiClient apiClient;

  public ActionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ActionsApi(ApiClient apiClient) {
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
   * Bulk Comment
   * Allows bulk comments on multiple findings, controlled by a filter.  Requires the \&quot;finding:comment-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param bulkComment  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was accepted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to comment </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void bulkComment(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable BulkComment bulkComment) throws ApiException {
    bulkCommentWithHttpInfo(projectVersionContext, bulkComment);
  }

  /**
   * Bulk Comment
   * Allows bulk comments on multiple findings, controlled by a filter.  Requires the \&quot;finding:comment-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param bulkComment  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Comment was accepted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have permission to comment </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> bulkCommentWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable BulkComment bulkComment) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling bulkComment");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/bulk-comment"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ActionsApi.bulkComment", localVarPath, "POST", new ArrayList<>(), bulkComment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Bulk Due Date Override
   * Allows bulk due date override of multiple findings, controlled by a filter.  Requires the \&quot;finding:override-due-date-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param bulkDueDateOverride  (optional)
   * @return Job
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job was started for performing the bulk due date override </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Job overrideBulkDueDate(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable BulkDueDateOverride bulkDueDateOverride) throws ApiException {
    return overrideBulkDueDateWithHttpInfo(projectVersionContext, bulkDueDateOverride).getData();
  }

  /**
   * Bulk Due Date Override
   * Allows bulk due date override of multiple findings, controlled by a filter.  Requires the \&quot;finding:override-due-date-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param bulkDueDateOverride  (optional)
   * @return ApiResponse&lt;Job&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job was started for performing the bulk due date override </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Job> overrideBulkDueDateWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable BulkDueDateOverride bulkDueDateOverride) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling overrideBulkDueDate");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/bulk/due-date-override"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI("ActionsApi.overrideBulkDueDate", localVarPath, "POST", new ArrayList<>(), bulkDueDateOverride,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Bulk Severity Override
   * Allows bulk severity override of multiple findings, controlled by a filter.  Requires the \&quot;finding:override-severity-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param bulkSeverityOverride  (optional)
   * @return Job
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job was started for performing the bulk severity override </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid or severity is invalid or unassignable </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Job overrideBulkSeverities(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable BulkSeverityOverride bulkSeverityOverride) throws ApiException {
    return overrideBulkSeveritiesWithHttpInfo(projectVersionContext, bulkSeverityOverride).getData();
  }

  /**
   * Bulk Severity Override
   * Allows bulk severity override of multiple findings, controlled by a filter.  Requires the \&quot;finding:override-severity-bulk\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param bulkSeverityOverride  (optional)
   * @return ApiResponse&lt;Job&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job was started for performing the bulk severity override </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing, invalid or severity is invalid or unassignable </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have update permission for the finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Job> overrideBulkSeveritiesWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable BulkSeverityOverride bulkSeverityOverride) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling overrideBulkSeverities");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/bulk-severity-override"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI("ActionsApi.overrideBulkSeverities", localVarPath, "POST", new ArrayList<>(), bulkSeverityOverride,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
