package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Error;
import com.codedx.client.model.ManualResultRequest;
import com.codedx.client.model.ManualResultResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ResultsApi {
  private ApiClient apiClient;

  public ResultsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ResultsApi(ApiClient apiClient) {
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
   * Create Manual Result
   * Allows creation of a manual result.  Requires the \&quot;manual-result:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param manualResultRequest  (required)
   * @return ManualResultResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an object representing the result and finding that are created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ManualResultResponse createManualResult(@jakarta.annotation.Nonnull ManualResultRequest manualResultRequest) throws ApiException {
    return createManualResultWithHttpInfo(manualResultRequest).getData();
  }

  /**
   * Create Manual Result
   * Allows creation of a manual result.  Requires the \&quot;manual-result:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param manualResultRequest  (required)
   * @return ApiResponse&lt;ManualResultResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an object representing the result and finding that are created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ManualResultResponse> createManualResultWithHttpInfo(@jakarta.annotation.Nonnull ManualResultRequest manualResultRequest) throws ApiException {
    // Check required parameters
    if (manualResultRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'manualResultRequest' when calling createManualResult");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ManualResultResponse> localVarReturnType = new GenericType<ManualResultResponse>() {};
    return apiClient.invokeAPI("ResultsApi.createManualResult", "/api/manual-results", "POST", new ArrayList<>(), manualResultRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Manual Result
   * Allows deletion of a manual result.  Requires the \&quot;manual-result:delete\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param resultId  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Successfully deleted manual result </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such result </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteManualResult(@jakarta.annotation.Nonnull Integer resultId) throws ApiException {
    deleteManualResultWithHttpInfo(resultId);
  }

  /**
   * Delete Manual Result
   * Allows deletion of a manual result.  Requires the \&quot;manual-result:delete\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param resultId  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Successfully deleted manual result </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such result </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteManualResultWithHttpInfo(@jakarta.annotation.Nonnull Integer resultId) throws ApiException {
    // Check required parameters
    if (resultId == null) {
      throw new ApiException(400, "Missing the required parameter 'resultId' when calling deleteManualResult");
    }

    // Path parameters
    String localVarPath = "/api/manual-results/{result-id}"
            .replaceAll("\\{result-id}", apiClient.escapeString(resultId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ResultsApi.deleteManualResult", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Allowed Manual Result Tools
   * Returns a set of allowed tool names for use when creating a manual result.  Requires no role, all users have sufficient permissions by default.
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of tool names </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<String> getManualResultAllowedTools() throws ApiException {
    return getManualResultAllowedToolsWithHttpInfo().getData();
  }

  /**
   * Get Allowed Manual Result Tools
   * Returns a set of allowed tool names for use when creating a manual result.  Requires no role, all users have sufficient permissions by default.
   * @return ApiResponse&lt;List&lt;String&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of tool names </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<String>> getManualResultAllowedToolsWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI("ResultsApi.getManualResultAllowedTools", "/api/manual-results/allowed-tools", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Modify Allowed Manual Result Tool
   * Allows user to enable/disabled allowed tools.  Requires the \&quot;manual-result:edit\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param tool The name of the tool to modify (optional)
   * @param allowed Boolean value representing tool state - enabled/disabled (true/false) (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Tool was successfully modified </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void modifyManualResultAllowedTool(@jakarta.annotation.Nullable String tool, @jakarta.annotation.Nullable Boolean allowed) throws ApiException {
    modifyManualResultAllowedToolWithHttpInfo(tool, allowed);
  }

  /**
   * Modify Allowed Manual Result Tool
   * Allows user to enable/disabled allowed tools.  Requires the \&quot;manual-result:edit\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param tool The name of the tool to modify (optional)
   * @param allowed Boolean value representing tool state - enabled/disabled (true/false) (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Tool was successfully modified </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> modifyManualResultAllowedToolWithHttpInfo(@jakarta.annotation.Nullable String tool, @jakarta.annotation.Nullable Boolean allowed) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "tool", tool)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "allowed", allowed));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ResultsApi.modifyManualResultAllowedTool", "/api/manual-results/allowed-tools", "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Replace Manual Result
   * Allows a manual result to be replaced with another.  Requires the \&quot;manual-result:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param resultId  (required)
   * @param manualResultRequest  (required)
   * @return ManualResultResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains information about the new manual result </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such result </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ManualResultResponse replaceManualResult(@jakarta.annotation.Nonnull Integer resultId, @jakarta.annotation.Nonnull ManualResultRequest manualResultRequest) throws ApiException {
    return replaceManualResultWithHttpInfo(resultId, manualResultRequest).getData();
  }

  /**
   * Replace Manual Result
   * Allows a manual result to be replaced with another.  Requires the \&quot;manual-result:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param resultId  (required)
   * @param manualResultRequest  (required)
   * @return ApiResponse&lt;ManualResultResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains information about the new manual result </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such result </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ManualResultResponse> replaceManualResultWithHttpInfo(@jakarta.annotation.Nonnull Integer resultId, @jakarta.annotation.Nonnull ManualResultRequest manualResultRequest) throws ApiException {
    // Check required parameters
    if (resultId == null) {
      throw new ApiException(400, "Missing the required parameter 'resultId' when calling replaceManualResult");
    }
    if (manualResultRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'manualResultRequest' when calling replaceManualResult");
    }

    // Path parameters
    String localVarPath = "/api/manual-results/{result-id}/replace"
            .replaceAll("\\{result-id}", apiClient.escapeString(resultId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ManualResultResponse> localVarReturnType = new GenericType<ManualResultResponse>() {};
    return apiClient.invokeAPI("ResultsApi.replaceManualResult", localVarPath, "POST", new ArrayList<>(), manualResultRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
