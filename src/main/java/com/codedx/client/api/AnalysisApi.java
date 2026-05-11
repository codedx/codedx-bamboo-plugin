package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Analysis;
import com.codedx.client.model.AnalysisDetails;
import com.codedx.client.model.AnalysisName;
import com.codedx.client.model.AnalysisPrepResponse;
import com.codedx.client.model.AnalysisPrepToolConnectorsResponse;
import com.codedx.client.model.AnalysisQueryResponse;
import com.codedx.client.model.CreateAnalysisPrepRequest;
import com.codedx.client.model.DynamicAddInToolDisplayTag;
import com.codedx.client.model.Error;
import java.io.File;
import com.codedx.client.model.FileUploadResponse;
import com.codedx.client.model.GitAnalysis;
import com.codedx.client.model.ImportSource202Response;
import com.codedx.client.model.InputDisplayInfo;
import com.codedx.client.model.SetAnalysisPrepBranchRequest;
import com.codedx.client.model.SetDisplayTagRequest;
import com.codedx.client.model.SetTargetBranchResponse;
import com.codedx.client.model.SetToolRunnerIntentRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class AnalysisApi {
  private ApiClient apiClient;

  public AnalysisApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AnalysisApi(ApiClient apiClient) {
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
   * Create Analysis Prep
   * Create a new Analysis Prep associated with a particular project. If Git is configured on that project, the new Analysis Prep will automatically initialize an input corresponding to that configuration.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param createAnalysisPrepRequest  (required)
   * @return AnalysisPrepResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - If creation was successful, the server will reply with information about the new Analysis Prep as JSON.  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or was missing the projectId field </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - If the requesting user does not have the permission to create analyses in the specified project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - If no project with the specified ID exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AnalysisPrepResponse createAnalysisPrep(@jakarta.annotation.Nonnull CreateAnalysisPrepRequest createAnalysisPrepRequest) throws ApiException {
    return createAnalysisPrepWithHttpInfo(createAnalysisPrepRequest).getData();
  }

  /**
   * Create Analysis Prep
   * Create a new Analysis Prep associated with a particular project. If Git is configured on that project, the new Analysis Prep will automatically initialize an input corresponding to that configuration.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param createAnalysisPrepRequest  (required)
   * @return ApiResponse&lt;AnalysisPrepResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - If creation was successful, the server will reply with information about the new Analysis Prep as JSON.  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or was missing the projectId field </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - If the requesting user does not have the permission to create analyses in the specified project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - If no project with the specified ID exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AnalysisPrepResponse> createAnalysisPrepWithHttpInfo(@jakarta.annotation.Nonnull CreateAnalysisPrepRequest createAnalysisPrepRequest) throws ApiException {
    // Check required parameters
    if (createAnalysisPrepRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'createAnalysisPrepRequest' when calling createAnalysisPrep");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AnalysisPrepResponse> localVarReturnType = new GenericType<AnalysisPrepResponse>() {};
    return apiClient.invokeAPI("AnalysisApi.createAnalysisPrep", "/api/analysis-prep", "POST", new ArrayList<>(), createAnalysisPrepRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Input
   * Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that includes an input-id parameter.  Requires the \&quot;analysis:delete\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - If the input was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to delete analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - If there was no such Analysis Prep or no such input </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteInput(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId) throws ApiException {
    deleteInputWithHttpInfo(prepId, inputId);
  }

  /**
   * Delete Input
   * Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that includes an input-id parameter.  Requires the \&quot;analysis:delete\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - If the input was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to delete analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - If there was no such Analysis Prep or no such input </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteInputWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling deleteInput");
    }
    if (inputId == null) {
      throw new ApiException(400, "Missing the required parameter 'inputId' when calling deleteInput");
    }

    // Path parameters
    String localVarPath = "/api/analysis-prep/{prep-id}/{input-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{input-id}", apiClient.escapeString(inputId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("AnalysisApi.deleteInput", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Input (pending)
   * Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that includes an input-id parameter.  Requires the \&quot;analysis:delete\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param xClientRequestId If the input-id is not known, and the \&quot;pending\&quot; URL is being used, this header should be set to the value used by the request which initiated the input file upload. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - If the input was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to delete analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - If there was no such Analysis Prep, no such input, or no input whose X-Client-Request-Id matched the one specified in the header </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deletePendingInput(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String xClientRequestId) throws ApiException {
    deletePendingInputWithHttpInfo(prepId, xClientRequestId);
  }

  /**
   * Delete Input (pending)
   * Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that includes an input-id parameter.  Requires the \&quot;analysis:delete\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param xClientRequestId If the input-id is not known, and the \&quot;pending\&quot; URL is being used, this header should be set to the value used by the request which initiated the input file upload. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - If the input was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to delete analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - If there was no such Analysis Prep, no such input, or no input whose X-Client-Request-Id matched the one specified in the header </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deletePendingInputWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String xClientRequestId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling deletePendingInput");
    }
    if (xClientRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'xClientRequestId' when calling deletePendingInput");
    }

    // Path parameters
    String localVarPath = "/api/analysis-prep/{prep-id}/pending"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()));

    // Header parameters
    Map<String, String> localVarHeaderParams = new LinkedHashMap<>();
    localVarHeaderParams.put("X-Client-Request-Id", apiClient.parameterToString(xClientRequestId));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("AnalysisApi.deletePendingInput", localVarPath, "DELETE", new ArrayList<>(), null,
                               localVarHeaderParams, new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Disable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to disable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In Tools are Add-In Tools that are not associated with any input files. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return List&lt;DynamicAddInToolDisplayTag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public List<DynamicAddInToolDisplayTag> disableAnalysisDynamicAddInTool(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    return disableAnalysisDynamicAddInToolWithHttpInfo(prepId, toolId).getData();
  }

  /**
   * Disable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to disable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In Tools are Add-In Tools that are not associated with any input files. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return ApiResponse&lt;List&lt;DynamicAddInToolDisplayTag&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<DynamicAddInToolDisplayTag>> disableAnalysisDynamicAddInToolWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling disableAnalysisDynamicAddInTool");
    }
    if (toolId == null) {
      throw new ApiException(400, "Missing the required parameter 'toolId' when calling disableAnalysisDynamicAddInTool");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/addin/{tool-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{tool-id}", apiClient.escapeString(toolId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<DynamicAddInToolDisplayTag>> localVarReturnType = new GenericType<List<DynamicAddInToolDisplayTag>>() {};
    return apiClient.invokeAPI("AnalysisApi.disableAnalysisDynamicAddInTool", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Disable a tool connector so it won&#39;t run during the prepared analysis
   * See the corresponding Enable endpoint for more details. This endpoint corresponds to unchecking the checkbox for a tool connector in the &#39;Tool Connectors&#39; section of the analysis page.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param connectorId The ID of the tool connector to toggle. This should come from one of the objects in the &#39;toolConnectors&#39; array from the Create Analysis Prep response (required)
   * @return AnalysisPrepToolConnectorsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an updated summary of the tool connectors for the analysis prep </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to delete analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public AnalysisPrepToolConnectorsResponse disableToolConnectorInAnalysisPrep(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer connectorId) throws ApiException {
    return disableToolConnectorInAnalysisPrepWithHttpInfo(prepId, connectorId).getData();
  }

  /**
   * Disable a tool connector so it won&#39;t run during the prepared analysis
   * See the corresponding Enable endpoint for more details. This endpoint corresponds to unchecking the checkbox for a tool connector in the &#39;Tool Connectors&#39; section of the analysis page.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param connectorId The ID of the tool connector to toggle. This should come from one of the objects in the &#39;toolConnectors&#39; array from the Create Analysis Prep response (required)
   * @return ApiResponse&lt;AnalysisPrepToolConnectorsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an updated summary of the tool connectors for the analysis prep </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to delete analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AnalysisPrepToolConnectorsResponse> disableToolConnectorInAnalysisPrepWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer connectorId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling disableToolConnectorInAnalysisPrep");
    }
    if (connectorId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectorId' when calling disableToolConnectorInAnalysisPrep");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/connector/{connector-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{connector-id}", apiClient.escapeString(connectorId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AnalysisPrepToolConnectorsResponse> localVarReturnType = new GenericType<AnalysisPrepToolConnectorsResponse>() {};
    return apiClient.invokeAPI("AnalysisApi.disableToolConnectorInAnalysisPrep", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Enable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to enable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In tools are Add-In Tools that are not associated with any input files. Dynamic tools must be enabled for the Project in its Orchestration Config page first. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return List&lt;DynamicAddInToolDisplayTag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public List<DynamicAddInToolDisplayTag> enableAnalysisDynamicAddInTool(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    return enableAnalysisDynamicAddInToolWithHttpInfo(prepId, toolId).getData();
  }

  /**
   * Enable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to enable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In tools are Add-In Tools that are not associated with any input files. Dynamic tools must be enabled for the Project in its Orchestration Config page first. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return ApiResponse&lt;List&lt;DynamicAddInToolDisplayTag&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<DynamicAddInToolDisplayTag>> enableAnalysisDynamicAddInToolWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling enableAnalysisDynamicAddInTool");
    }
    if (toolId == null) {
      throw new ApiException(400, "Missing the required parameter 'toolId' when calling enableAnalysisDynamicAddInTool");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/addin/{tool-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{tool-id}", apiClient.escapeString(toolId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<DynamicAddInToolDisplayTag>> localVarReturnType = new GenericType<List<DynamicAddInToolDisplayTag>>() {};
    return apiClient.invokeAPI("AnalysisApi.enableAnalysisDynamicAddInTool", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Enable a tool connector to run during the prepared analysis
   * Note that the connector&#39;s configuration must have marked the &#39;available during analyses&#39; checkbox before this method can be any use. As long as that configuration is enabled, the enabled connectors will automatically be added and enabled to new analysis preps in that project. This endpoint corresponds to the turning on the checkmark for a tool connector on the analysis page UI.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param connectorId The ID of the tool connector to toggle. This should come from one of the objects in the &#39;toolConnectors&#39; array from the Create Analysis Prep response (required)
   * @return AnalysisPrepToolConnectorsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an updated summary of the tool connectors for the analysis prep </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public AnalysisPrepToolConnectorsResponse enableToolConnectorInAnalysisPrep(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer connectorId) throws ApiException {
    return enableToolConnectorInAnalysisPrepWithHttpInfo(prepId, connectorId).getData();
  }

  /**
   * Enable a tool connector to run during the prepared analysis
   * Note that the connector&#39;s configuration must have marked the &#39;available during analyses&#39; checkbox before this method can be any use. As long as that configuration is enabled, the enabled connectors will automatically be added and enabled to new analysis preps in that project. This endpoint corresponds to the turning on the checkmark for a tool connector on the analysis page UI.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param connectorId The ID of the tool connector to toggle. This should come from one of the objects in the &#39;toolConnectors&#39; array from the Create Analysis Prep response (required)
   * @return ApiResponse&lt;AnalysisPrepToolConnectorsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an updated summary of the tool connectors for the analysis prep </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AnalysisPrepToolConnectorsResponse> enableToolConnectorInAnalysisPrepWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer connectorId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling enableToolConnectorInAnalysisPrep");
    }
    if (connectorId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectorId' when calling enableToolConnectorInAnalysisPrep");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/connector/{connector-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{connector-id}", apiClient.escapeString(connectorId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AnalysisPrepToolConnectorsResponse> localVarReturnType = new GenericType<AnalysisPrepToolConnectorsResponse>() {};
    return apiClient.invokeAPI("AnalysisApi.enableToolConnectorInAnalysisPrep", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get All Analysis Details
   * Obtain analysis details for a project, such as start and finish times.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return List&lt;AnalysisDetails&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of Analysis Details </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user does not have permission to access analysis details </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<AnalysisDetails> getAllAnalysisDetails(@jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    return getAllAnalysisDetailsWithHttpInfo(projectVersionContext).getData();
  }

  /**
   * Get All Analysis Details
   * Obtain analysis details for a project, such as start and finish times.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;List&lt;AnalysisDetails&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of Analysis Details </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user does not have permission to access analysis details </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<AnalysisDetails>> getAllAnalysisDetailsWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getAllAnalysisDetails");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/analyses"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<AnalysisDetails>> localVarReturnType = new GenericType<List<AnalysisDetails>>() {};
    return apiClient.invokeAPI("AnalysisApi.getAllAnalysisDetails", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Analysis Details
   * Obtain analysis details, such as start and finish times.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param analysisId The ID of the analysis (required)
   * @return AnalysisDetails
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of Analysis Details </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user does not have permission to access analysis details </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AnalysisDetails getAnalysisDetails(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer analysisId) throws ApiException {
    return getAnalysisDetailsWithHttpInfo(projectId, analysisId).getData();
  }

  /**
   * Get Analysis Details
   * Obtain analysis details, such as start and finish times.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param analysisId The ID of the analysis (required)
   * @return ApiResponse&lt;AnalysisDetails&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of Analysis Details </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user does not have permission to access analysis details </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AnalysisDetails> getAnalysisDetailsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer analysisId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAnalysisDetails");
    }
    if (analysisId == null) {
      throw new ApiException(400, "Missing the required parameter 'analysisId' when calling getAnalysisDetails");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/analyses/{analysis-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{analysis-id}", apiClient.escapeString(analysisId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AnalysisDetails> localVarReturnType = new GenericType<AnalysisDetails>() {};
    return apiClient.invokeAPI("AnalysisApi.getAnalysisDetails", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Input Metadata
   * Get metadata for a particular input associated with an Analysis Prep.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @return InputDisplayInfo
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Includes the input metadata in the response body, as JSON </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, or no such input </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public InputDisplayInfo getInputMetadata(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId) throws ApiException {
    return getInputMetadataWithHttpInfo(prepId, inputId).getData();
  }

  /**
   * Get Input Metadata
   * Get metadata for a particular input associated with an Analysis Prep.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @return ApiResponse&lt;InputDisplayInfo&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Includes the input metadata in the response body, as JSON </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, or no such input </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InputDisplayInfo> getInputMetadataWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling getInputMetadata");
    }
    if (inputId == null) {
      throw new ApiException(400, "Missing the required parameter 'inputId' when calling getInputMetadata");
    }

    // Path parameters
    String localVarPath = "/api/analysis-prep/{prep-id}/{input-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{input-id}", apiClient.escapeString(inputId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<InputDisplayInfo> localVarReturnType = new GenericType<InputDisplayInfo>() {};
    return apiClient.invokeAPI("AnalysisApi.getInputMetadata", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Import Source
   * Create a new input using source extracted from the given input. Only supported for inputs that return for &#x60;sourceAvailable: true&#x60; from the &#x60;Get Input Metadata&#x60; endpoint.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @return ImportSource202Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - A job will begin to extract the source from the input and determine the contents of the file. The response body will include information about the created input and the job ID </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The input given does not have source available </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, or prep input </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ImportSource202Response importSource(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId) throws ApiException {
    return importSourceWithHttpInfo(prepId, inputId).getData();
  }

  /**
   * Import Source
   * Create a new input using source extracted from the given input. Only supported for inputs that return for &#x60;sourceAvailable: true&#x60; from the &#x60;Get Input Metadata&#x60; endpoint.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @return ApiResponse&lt;ImportSource202Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - A job will begin to extract the source from the input and determine the contents of the file. The response body will include information about the created input and the job ID </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The input given does not have source available </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, or prep input </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ImportSource202Response> importSourceWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling importSource");
    }
    if (inputId == null) {
      throw new ApiException(400, "Missing the required parameter 'inputId' when calling importSource");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/{input-id}/import-source"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{input-id}", apiClient.escapeString(inputId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ImportSource202Response> localVarReturnType = new GenericType<ImportSource202Response>() {};
    return apiClient.invokeAPI("AnalysisApi.importSource", localVarPath, "PUT", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Query Analysis Prep State
   * Get a list of Input IDs and Verification Errors for an Analysis Prep.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @return AnalysisQueryResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Includes a JSON object as the body </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AnalysisQueryResponse queryAnalysisPrepState(@jakarta.annotation.Nonnull String prepId) throws ApiException {
    return queryAnalysisPrepStateWithHttpInfo(prepId).getData();
  }

  /**
   * Query Analysis Prep State
   * Get a list of Input IDs and Verification Errors for an Analysis Prep.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @return ApiResponse&lt;AnalysisQueryResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Includes a JSON object as the body </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AnalysisQueryResponse> queryAnalysisPrepStateWithHttpInfo(@jakarta.annotation.Nonnull String prepId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling queryAnalysisPrepState");
    }

    // Path parameters
    String localVarPath = "/api/analysis-prep/{prep-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AnalysisQueryResponse> localVarReturnType = new GenericType<AnalysisQueryResponse>() {};
    return apiClient.invokeAPI("AnalysisApi.queryAnalysisPrepState", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Run Prepared Analysis
   * Once all of the verificationErrors in an Analysis Prep are addressed, an analysis can be started.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @return Analysis
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - The analysis was successfully started </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The Analysis Prep still had verification errors </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, or the prep belonged to a different user </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Analysis runPreparedAnalysis(@jakarta.annotation.Nonnull String prepId) throws ApiException {
    return runPreparedAnalysisWithHttpInfo(prepId).getData();
  }

  /**
   * Run Prepared Analysis
   * Once all of the verificationErrors in an Analysis Prep are addressed, an analysis can be started.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @return ApiResponse&lt;Analysis&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - The analysis was successfully started </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The Analysis Prep still had verification errors </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, or the prep belonged to a different user </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Analysis> runPreparedAnalysisWithHttpInfo(@jakarta.annotation.Nonnull String prepId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling runPreparedAnalysis");
    }

    // Path parameters
    String localVarPath = "/api/analysis-prep/{prep-id}/analyze"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Analysis> localVarReturnType = new GenericType<Analysis>() {};
    return apiClient.invokeAPI("AnalysisApi.runPreparedAnalysis", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Name Analysis
   * Set a name for a specific analysis.  Requires the \&quot;analysis:rename\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param analysisId The ID of the analysis (required)
   * @param analysisName An object containing the name of the analysis. If the name is set to &#x60;null&#x60; then it will clear the analysis name. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Name has been set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user does not have permission to name analyses </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setAnalysisName(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer analysisId, @jakarta.annotation.Nullable AnalysisName analysisName) throws ApiException {
    setAnalysisNameWithHttpInfo(projectId, analysisId, analysisName);
  }

  /**
   * Name Analysis
   * Set a name for a specific analysis.  Requires the \&quot;analysis:rename\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param analysisId The ID of the analysis (required)
   * @param analysisName An object containing the name of the analysis. If the name is set to &#x60;null&#x60; then it will clear the analysis name. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Name has been set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user does not have permission to name analyses </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setAnalysisNameWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer analysisId, @jakarta.annotation.Nullable AnalysisName analysisName) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setAnalysisName");
    }
    if (analysisId == null) {
      throw new ApiException(400, "Missing the required parameter 'analysisId' when calling setAnalysisName");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-id}/analyses/{analysis-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{analysis-id}", apiClient.escapeString(analysisId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("AnalysisApi.setAnalysisName", localVarPath, "PUT", new ArrayList<>(), analysisName,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Analysis Prep Branch
   * Set the target branch for an analysis prep.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param setAnalysisPrepBranchRequest  (optional)
   * @return SetTargetBranchResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Includes a JSON object as the body </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public SetTargetBranchResponse setAnalysisPrepBranch(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nullable SetAnalysisPrepBranchRequest setAnalysisPrepBranchRequest) throws ApiException {
    return setAnalysisPrepBranchWithHttpInfo(prepId, setAnalysisPrepBranchRequest).getData();
  }

  /**
   * Set Analysis Prep Branch
   * Set the target branch for an analysis prep.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param setAnalysisPrepBranchRequest  (optional)
   * @return ApiResponse&lt;SetTargetBranchResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Includes a JSON object as the body </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SetTargetBranchResponse> setAnalysisPrepBranchWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nullable SetAnalysisPrepBranchRequest setAnalysisPrepBranchRequest) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling setAnalysisPrepBranch");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/branch"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<SetTargetBranchResponse> localVarReturnType = new GenericType<SetTargetBranchResponse>() {};
    return apiClient.invokeAPI("AnalysisApi.setAnalysisPrepBranch", localVarPath, "PUT", new ArrayList<>(), setAnalysisPrepBranchRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Enable/Disable Display Tag
   * Enable and disable individual display tags on individual prop inputs. Disabled tags will cause a file to be treated as if that tag were not there, for analysis purposes. For example, if the &#x60;{ \&quot;source\&quot;: \&quot;Java\&quot; } tag was disabled for a file when the analysis was started, that file would be treated as if there were no Java sources at all. This could mean that certain tools would not be run on that file.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @param tagId The ID of a Display Tag State object which would have been returned by the Get Input Metadata endpoint (required)
   * @param setDisplayTagRequest A boolean indicating whether the tag should be enabled or disabled (optional)
   * @return InputDisplayInfo
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The tag&#39;s enabled status was successfully set. A successful response will include an Input Display Info object as JSON, representing the new state of the input </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, prep input, or tag </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public InputDisplayInfo setDisplayTag(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId, @jakarta.annotation.Nonnull String tagId, @jakarta.annotation.Nullable SetDisplayTagRequest setDisplayTagRequest) throws ApiException {
    return setDisplayTagWithHttpInfo(prepId, inputId, tagId, setDisplayTagRequest).getData();
  }

  /**
   * Enable/Disable Display Tag
   * Enable and disable individual display tags on individual prop inputs. Disabled tags will cause a file to be treated as if that tag were not there, for analysis purposes. For example, if the &#x60;{ \&quot;source\&quot;: \&quot;Java\&quot; } tag was disabled for a file when the analysis was started, that file would be treated as if there were no Java sources at all. This could mean that certain tools would not be run on that file.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @param tagId The ID of a Display Tag State object which would have been returned by the Get Input Metadata endpoint (required)
   * @param setDisplayTagRequest A boolean indicating whether the tag should be enabled or disabled (optional)
   * @return ApiResponse&lt;InputDisplayInfo&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The tag&#39;s enabled status was successfully set. A successful response will include an Input Display Info object as JSON, representing the new state of the input </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep, prep input, or tag </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InputDisplayInfo> setDisplayTagWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull String inputId, @jakarta.annotation.Nonnull String tagId, @jakarta.annotation.Nullable SetDisplayTagRequest setDisplayTagRequest) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling setDisplayTag");
    }
    if (inputId == null) {
      throw new ApiException(400, "Missing the required parameter 'inputId' when calling setDisplayTag");
    }
    if (tagId == null) {
      throw new ApiException(400, "Missing the required parameter 'tagId' when calling setDisplayTag");
    }

    // Path parameters
    String localVarPath = "/api/analysis-prep/{prep-id}/{input-id}/tag/{tag-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{input-id}", apiClient.escapeString(inputId.toString()))
            .replaceAll("\\{tag-id}", apiClient.escapeString(tagId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<InputDisplayInfo> localVarReturnType = new GenericType<InputDisplayInfo>() {};
    return apiClient.invokeAPI("AnalysisApi.setDisplayTag", localVarPath, "PUT", new ArrayList<>(), setDisplayTagRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Set Tool Runner Intent
   * Set a &#39;Tool Runner Intent&#39; on an Analysis Prep, so that when the Analysis begins, the requested tool will run with the given options. The specific format of the &#39;options&#39; depends on the requested tool.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param setToolRunnerIntentRequest  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The analysis prep was successfully updated. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, or a required field was missing/invalid. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The authenticated user did not have permission to interact with the Analysis Prep. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The requested &#x60;prepId&#x60; did not exist, or the requested &#x60;tool&#x60; is not supported by this endpoint. </td><td>  -  </td></tr>
     </table>
   */
  public void setToolRunnerIntent(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull SetToolRunnerIntentRequest setToolRunnerIntentRequest) throws ApiException {
    setToolRunnerIntentWithHttpInfo(prepId, setToolRunnerIntentRequest);
  }

  /**
   * Set Tool Runner Intent
   * Set a &#39;Tool Runner Intent&#39; on an Analysis Prep, so that when the Analysis begins, the requested tool will run with the given options. The specific format of the &#39;options&#39; depends on the requested tool.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param setToolRunnerIntentRequest  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The analysis prep was successfully updated. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, or a required field was missing/invalid. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The authenticated user did not have permission to interact with the Analysis Prep. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The requested &#x60;prepId&#x60; did not exist, or the requested &#x60;tool&#x60; is not supported by this endpoint. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setToolRunnerIntentWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull SetToolRunnerIntentRequest setToolRunnerIntentRequest) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling setToolRunnerIntent");
    }
    if (setToolRunnerIntentRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'setToolRunnerIntentRequest' when calling setToolRunnerIntent");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/tool"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("AnalysisApi.setToolRunnerIntent", localVarPath, "POST", new ArrayList<>(), setToolRunnerIntentRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Upload File to Analysis Prep
   * Analysis Preps should be populated by uploading files to Software Risk Manager (or by configuring Git on a project, causing the source to be automatically added to the prep).  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.  Note: The \&quot;Try it out\&quot; functionality is currently unavailable for this endpoint.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param _file The file to be uploaded (required)
   * @param xClientRequestId Clients may choose an arbitrary identifier (a random string will suffice) to associate with the upload. This is done to enable deletion of an input before its file upload is fully complete. For more info, see Delete Input. (optional)
   * @return FileUploadResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - If the file was successfully uploaded, a job will begin to determine the contents of the file. The response body will include information about the created input and the job ID </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
       <tr><td> 410 </td><td> Gone - If the analysis Prep had been marked for deletion while the file was still uploading </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public FileUploadResponse uploadFile(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull File _file, @jakarta.annotation.Nullable String xClientRequestId) throws ApiException {
    return uploadFileWithHttpInfo(prepId, _file, xClientRequestId).getData();
  }

  /**
   * Upload File to Analysis Prep
   * Analysis Preps should be populated by uploading files to Software Risk Manager (or by configuring Git on a project, causing the source to be automatically added to the prep).  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.  Note: The \&quot;Try it out\&quot; functionality is currently unavailable for this endpoint.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param _file The file to be uploaded (required)
   * @param xClientRequestId Clients may choose an arbitrary identifier (a random string will suffice) to associate with the upload. This is done to enable deletion of an input before its file upload is fully complete. For more info, see Delete Input. (optional)
   * @return ApiResponse&lt;FileUploadResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - If the file was successfully uploaded, a job will begin to determine the contents of the file. The response body will include information about the created input and the job ID </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The current user is not allowed to create analyses on this Analysis Prep&#39;s project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
       <tr><td> 410 </td><td> Gone - If the analysis Prep had been marked for deletion while the file was still uploading </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<FileUploadResponse> uploadFileWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull File _file, @jakarta.annotation.Nullable String xClientRequestId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling uploadFile");
    }
    if (_file == null) {
      throw new ApiException(400, "Missing the required parameter '_file' when calling uploadFile");
    }

    // Path parameters
    String localVarPath = "/api/analysis-prep/{prep-id}/upload"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()));

    // Header parameters
    Map<String, String> localVarHeaderParams = new LinkedHashMap<>();
    if (xClientRequestId != null) {
      localVarHeaderParams.put("X-Client-Request-Id", apiClient.parameterToString(xClientRequestId));
    }

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("file", _file);

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<FileUploadResponse> localVarReturnType = new GenericType<FileUploadResponse>() {};
    return apiClient.invokeAPI("AnalysisApi.uploadFile", localVarPath, "POST", new ArrayList<>(), null,
                               localVarHeaderParams, new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Upload Files and Run Analysis
   * Allows a user to upload files and run an analysis without using the analysis prep endpoints. Optionally, you may include the project&#39;s git source as an analysis input.  Note that an analysis includes running tools if an input contains source code or tool connectors have been configured to run during analyses.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.   If you are using curl, here are some example commands for interacting with this endpoint:  * Running an analysis on a tool output file without a Git source  &#x60;curl -F file1&#x3D;@\&quot;webgoat.fpr\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  * Analysis including Git source  &#x60;curl -F file1&#x3D;@\&quot;webgoat.zip\&quot; -F \&quot;includeGitSource&#x3D;true\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  * Analysis with an explicit branch to pull from the Git source  &#x60;curl -F \&quot;includeGitSource&#x3D;true\&quot; -F \&quot;gitBranchName&#x3D;feature/example\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  * Analysis with results stored under the Software Risk Manager branch &#39;dev&#39;  &#x60;curl -F file1&#x3D;@\&quot;webgoat.zip\&quot; -F \&quot;branchName&#x3D;dev\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param filenames The file inputs to include for this analysis (optional)
   * @param includeGitSource Controls if Software Risk Manager adds the project&#39;s configured Git source to the analysis. By default, this is &#x60;false&#x60;. (optional)
   * @param gitBranchName The branch to fetch from the project&#39;s associated Git repository if &#x60;includeGitSource&#x60; is &#x60;true&#x60;. By default, this is the branch specified by the project&#39;s git configuration.  By default the checkout process is given a maximum of an hour to complete. If more time is needed, use the \\\&quot;codedx.basic-analysis.git-clone-duration\\\&quot; prop (e.g., \\\&quot;2 hours\\\&quot; or \\\&quot;30 minutes\\\&quot;). (optional)
   * @param branchName The Software Risk Manager branch used to store the analysis results. If not specified, the project&#39;s default branch will be used.  Note that the Software Risk Manager branch name does not necessarily match the *Git* branch name. (optional)
   * @return GitAnalysis
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - The files were uploaded successfully and the analysis has begun.  Note that if &#x60;includeGitSource&#x60; was &#x60;true&#x60;, then &#x60;analysisId&#x60; will be &#x60;null&#x60; and the given &#x60;jobId&#x60; can be used to get the job output containing the &#x60;analysisId&#x60; and analysis &#x60;jobId&#x60;. All users have sufficient permissions by default to get this job output and can be done so via the &#x60;/api/jobs/{job-id}/result&#x60; endpoint. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Something went wrong while handling file uploads </td><td>  -  </td></tr>
       <tr><td> 415 </td><td> Unsupported Media Type - One or more files is not supported </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GitAnalysis uploadFilesAndAnalyze(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable List<File> filenames, @jakarta.annotation.Nullable Boolean includeGitSource, @jakarta.annotation.Nullable String gitBranchName, @jakarta.annotation.Nullable String branchName) throws ApiException {
    return uploadFilesAndAnalyzeWithHttpInfo(projectVersionContext, filenames, includeGitSource, gitBranchName, branchName).getData();
  }

  /**
   * Upload Files and Run Analysis
   * Allows a user to upload files and run an analysis without using the analysis prep endpoints. Optionally, you may include the project&#39;s git source as an analysis input.  Note that an analysis includes running tools if an input contains source code or tool connectors have been configured to run during analyses.  Requires the \&quot;analysis:create\&quot; permission which is provided by the \&quot;Creator\&quot; role.   If you are using curl, here are some example commands for interacting with this endpoint:  * Running an analysis on a tool output file without a Git source  &#x60;curl -F file1&#x3D;@\&quot;webgoat.fpr\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  * Analysis including Git source  &#x60;curl -F file1&#x3D;@\&quot;webgoat.zip\&quot; -F \&quot;includeGitSource&#x3D;true\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  * Analysis with an explicit branch to pull from the Git source  &#x60;curl -F \&quot;includeGitSource&#x3D;true\&quot; -F \&quot;gitBranchName&#x3D;feature/example\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  * Analysis with results stored under the Software Risk Manager branch &#39;dev&#39;  &#x60;curl -F file1&#x3D;@\&quot;webgoat.zip\&quot; -F \&quot;branchName&#x3D;dev\&quot; -H \&quot;API-Key: &lt;key&gt;\&quot; &lt;endpoint&gt;&#x60;  
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param filenames The file inputs to include for this analysis (optional)
   * @param includeGitSource Controls if Software Risk Manager adds the project&#39;s configured Git source to the analysis. By default, this is &#x60;false&#x60;. (optional)
   * @param gitBranchName The branch to fetch from the project&#39;s associated Git repository if &#x60;includeGitSource&#x60; is &#x60;true&#x60;. By default, this is the branch specified by the project&#39;s git configuration.  By default the checkout process is given a maximum of an hour to complete. If more time is needed, use the \\\&quot;codedx.basic-analysis.git-clone-duration\\\&quot; prop (e.g., \\\&quot;2 hours\\\&quot; or \\\&quot;30 minutes\\\&quot;). (optional)
   * @param branchName The Software Risk Manager branch used to store the analysis results. If not specified, the project&#39;s default branch will be used.  Note that the Software Risk Manager branch name does not necessarily match the *Git* branch name. (optional)
   * @return ApiResponse&lt;GitAnalysis&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - The files were uploaded successfully and the analysis has begun.  Note that if &#x60;includeGitSource&#x60; was &#x60;true&#x60;, then &#x60;analysisId&#x60; will be &#x60;null&#x60; and the given &#x60;jobId&#x60; can be used to get the job output containing the &#x60;analysisId&#x60; and analysis &#x60;jobId&#x60;. All users have sufficient permissions by default to get this job output and can be done so via the &#x60;/api/jobs/{job-id}/result&#x60; endpoint. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Something went wrong while handling file uploads </td><td>  -  </td></tr>
       <tr><td> 415 </td><td> Unsupported Media Type - One or more files is not supported </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GitAnalysis> uploadFilesAndAnalyzeWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nullable List<File> filenames, @jakarta.annotation.Nullable Boolean includeGitSource, @jakarta.annotation.Nullable String gitBranchName, @jakarta.annotation.Nullable String branchName) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling uploadFilesAndAnalyze");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/analysis"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    if (filenames != null) {
      localVarFormParams.put("filenames", filenames);
    }
    if (includeGitSource != null) {
      localVarFormParams.put("includeGitSource", includeGitSource);
    }
    if (gitBranchName != null) {
      localVarFormParams.put("gitBranchName", gitBranchName);
    }
    if (branchName != null) {
      localVarFormParams.put("branchName", branchName);
    }

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GitAnalysis> localVarReturnType = new GenericType<GitAnalysis>() {};
    return apiClient.invokeAPI("AnalysisApi.uploadFilesAndAnalyze", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
