package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.DashboardData;
import com.codedx.client.model.DashboardQueryFields;
import com.codedx.client.model.JobIdResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class DashboardApi {
  private ApiClient apiClient;

  public DashboardApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DashboardApi(ApiClient apiClient) {
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
   * Force dashboard update
   * Force a global update of the dashboard for all projects.  Requires the \&quot;Admin\&quot; role.
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Global update of the dashboard has been successfully queued </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void forceGlobalUpdate() throws ApiException {
    forceGlobalUpdateWithHttpInfo();
  }

  /**
   * Force dashboard update
   * Force a global update of the dashboard for all projects.  Requires the \&quot;Admin\&quot; role.
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Global update of the dashboard has been successfully queued </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> forceGlobalUpdateWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("DashboardApi.forceGlobalUpdate", "/api/dashboard/force-update", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Force dashboard update for project
   * Force a dashboard update for project with ID {project-id}.  Requires the \&quot;project:updateDashboardData\&quot; permission which is given by the \&quot;Updater\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return JobIdResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job has been created to update the project&#39;s dashboard </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission to update dashboard data for project </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public JobIdResponse forceUpdate(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return forceUpdateWithHttpInfo(projectId).getData();
  }

  /**
   * Force dashboard update for project
   * Force a dashboard update for project with ID {project-id}.  Requires the \&quot;project:updateDashboardData\&quot; permission which is given by the \&quot;Updater\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;JobIdResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - A job has been created to update the project&#39;s dashboard </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission to update dashboard data for project </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<JobIdResponse> forceUpdateWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling forceUpdate");
    }

    // Path parameters
    String localVarPath = "/api/dashboard/force-update/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<JobIdResponse> localVarReturnType = new GenericType<JobIdResponse>() {};
    return apiClient.invokeAPI("DashboardApi.forceUpdate", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Query dashboard data for project
   * Query dashboard data for project.  Requires the \&quot;project:view\&quot; permission which is given by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param dashboardQueryFields  (optional)
   * @return DashboardData
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Dashboard data successfully queried for </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission to view project dashboard data </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public DashboardData queryDashboardData(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable DashboardQueryFields dashboardQueryFields) throws ApiException {
    return queryDashboardDataWithHttpInfo(projectQueryContext, dashboardQueryFields).getData();
  }

  /**
   * Query dashboard data for project
   * Query dashboard data for project.  Requires the \&quot;project:view\&quot; permission which is given by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param dashboardQueryFields  (optional)
   * @return ApiResponse&lt;DashboardData&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Dashboard data successfully queried for </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission to view project dashboard data </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DashboardData> queryDashboardDataWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable DashboardQueryFields dashboardQueryFields) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling queryDashboardData");
    }

    // Path parameters
    String localVarPath = "/api/dashboard/{project-query-context}"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<DashboardData> localVarReturnType = new GenericType<DashboardData>() {};
    return apiClient.invokeAPI("DashboardApi.queryDashboardData", localVarPath, "POST", new ArrayList<>(), dashboardQueryFields,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
