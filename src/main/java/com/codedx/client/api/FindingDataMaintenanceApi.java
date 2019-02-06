package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.codedx.client.api.DisabledToolResultsCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-02T17:17:22.434-05:00")
public class FindingDataMaintenanceApi {
  private ApiClient apiClient;

  public FindingDataMaintenanceApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FindingDataMaintenanceApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Disabled Tool Result Count Query
   * Returns a count of disabled findings present within a project. These are findings that match rules that are currently disabled, will not be ingested in new analyses, and would be removed by a purge task. 
   * @param projectId The ID of the project. (required)
   * @return DisabledToolResultsCount
   * @throws ApiException if fails to make API call
   */
  public DisabledToolResultsCount getDisabledToolResultCount(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDisabledToolResultCount");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/disabled-tool-result-count"
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

    GenericType<DisabledToolResultsCount> localVarReturnType = new GenericType<DisabledToolResultsCount>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Purge Disabled Tool Results
   * Executes a purge/cleanup operation on the finding data for the project. Any findings that match disabled rules will immediately be marked for removal, and, at some future point, be actually removed from the database by an automatic garbage collection task. 
   * @param projectId The ID of the project. (required)
   * @throws ApiException if fails to make API call
   */
  public void purgeDisabledToolResults(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling purgeDisabledToolResults");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/purge-disabled-tool-results"
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


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
