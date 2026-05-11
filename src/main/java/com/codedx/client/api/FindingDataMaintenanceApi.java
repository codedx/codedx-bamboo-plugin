package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.DisabledToolResultsCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class FindingDataMaintenanceApi {
  private ApiClient apiClient;

  public FindingDataMaintenanceApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FindingDataMaintenanceApi(ApiClient apiClient) {
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
   * Disabled Tool Result Count Query
   * Returns a count of tool results that are associated with disabled tools or tool codes across all branches in the project. These are results that are from tools or tool codes that are currently disabled, that will not be ingested in new analyses, and that would be removed by a purge task.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return DisabledToolResultsCount
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the count of findings matching disabled rules </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public DisabledToolResultsCount getDisabledToolResultCount(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getDisabledToolResultCountWithHttpInfo(projectId).getData();
  }

  /**
   * Disabled Tool Result Count Query
   * Returns a count of tool results that are associated with disabled tools or tool codes across all branches in the project. These are results that are from tools or tool codes that are currently disabled, that will not be ingested in new analyses, and that would be removed by a purge task.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;DisabledToolResultsCount&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the count of findings matching disabled rules </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DisabledToolResultsCount> getDisabledToolResultCountWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDisabledToolResultCount");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/disabled-tool-result-count"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<DisabledToolResultsCount> localVarReturnType = new GenericType<DisabledToolResultsCount>() {};
    return apiClient.invokeAPI("FindingDataMaintenanceApi.getDisabledToolResultCount", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Purge Disabled Tool Results
   * Executes a purge/cleanup operation on the finding data for the project. Any tool results associated with disabled tools/tool codes and any corresponding findings with only disabled results will immediately be removed from all branches of the project.  Requires the \&quot;project:purge-disabled-tool-results\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - The purge has been accepted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have purge permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void purgeDisabledToolResults(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    purgeDisabledToolResultsWithHttpInfo(projectId);
  }

  /**
   * Purge Disabled Tool Results
   * Executes a purge/cleanup operation on the finding data for the project. Any tool results associated with disabled tools/tool codes and any corresponding findings with only disabled results will immediately be removed from all branches of the project.  Requires the \&quot;project:purge-disabled-tool-results\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - The purge has been accepted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have purge permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> purgeDisabledToolResultsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling purgeDisabledToolResults");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/purge-disabled-tool-results"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("FindingDataMaintenanceApi.purgeDisabledToolResults", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
