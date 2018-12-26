package com.avi.codedx.client.api;

import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.Configuration;
import com.avi.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.avi.codedx.client.api.DetectionMethod;
import com.avi.codedx.client.api.Error;
import com.avi.codedx.client.api.ManualResultRequest;
import com.avi.codedx.client.api.ManualResultResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-27T11:18:43.181-05:00")
public class ResultsApi {
  private ApiClient apiClient;

  public ResultsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ResultsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create Detection Method
   * Create a new detection method with a name specified in the request body. 
   * @param detectionMethod Only the name property needs to be provided. (required)
   * @return DetectionMethod
   * @throws ApiException if fails to make API call
   */
  public DetectionMethod createDetectionMethod(DetectionMethod detectionMethod) throws ApiException {
    Object localVarPostBody = detectionMethod;
    
    // verify the required parameter 'detectionMethod' is set
    if (detectionMethod == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethod' when calling createDetectionMethod");
    }
    
    // create path and map variables
    String localVarPath = "/api/detection-methods";

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

    GenericType<DetectionMethod> localVarReturnType = new GenericType<DetectionMethod>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create Manual Result
   * Allows creation of a manual result
   * @param manualResultRequest  (required)
   * @return ManualResultResponse
   * @throws ApiException if fails to make API call
   */
  public ManualResultResponse createManualResult(ManualResultRequest manualResultRequest) throws ApiException {
    Object localVarPostBody = manualResultRequest;
    
    // verify the required parameter 'manualResultRequest' is set
    if (manualResultRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'manualResultRequest' when calling createManualResult");
    }
    
    // create path and map variables
    String localVarPath = "/api/manual-results";

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

    GenericType<ManualResultResponse> localVarReturnType = new GenericType<ManualResultResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete Detection Method.
   * Delete a detection method. Use the replacement parameter to replace any references to the deleted method with a different method. 
   * @param detectionMethodId  (required)
   * @param replacement The ID of the replacment detection method. (optional)
   * @throws ApiException if fails to make API call
   */
  public void deleteDetectionMethod(Integer detectionMethodId, Integer replacement) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'detectionMethodId' is set
    if (detectionMethodId == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethodId' when calling deleteDetectionMethod");
    }
    
    // create path and map variables
    String localVarPath = "/api/detection-methods/{detection-method-id}"
      .replaceAll("\\{" + "detection-method-id" + "\\}", apiClient.escapeString(detectionMethodId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "replacement", replacement));

    
    
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
   * Delete Manual Result
   * Allows deletion of a manual result
   * @param resultId  (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteManualResult(Integer resultId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'resultId' is set
    if (resultId == null) {
      throw new ApiException(400, "Missing the required parameter 'resultId' when calling deleteManualResult");
    }
    
    // create path and map variables
    String localVarPath = "/api/manual-results/{result-id}"
      .replaceAll("\\{" + "result-id" + "\\}", apiClient.escapeString(resultId.toString()));

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
   * List Detection Methods
   * Returns a list of all detection methods. 
   * @return List&lt;DetectionMethod&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DetectionMethod> getAllDetectionMethods() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/detection-methods";

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

    GenericType<List<DetectionMethod>> localVarReturnType = new GenericType<List<DetectionMethod>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Allowed Manaul Result Tools
   * Returns a set of allowed tool names for use when creating a manual result
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> getManualResultAllowedTools() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/manual-results/allowed-tools";

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

    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Modify Allowed Manual Result Tool
   * Allows user to enable/disabled allowed tools
   * @param tool The name of the tool to modify (optional)
   * @param allowed Boolean value representing tool state - enabled/disabled (true/false) (optional)
   * @throws ApiException if fails to make API call
   */
  public void modifyManualResultAllowedTool(String tool, Boolean allowed) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/manual-results/allowed-tools";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tool", tool));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "allowed", allowed));

    
    
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
   * Rename Detection Method
   * Rename an existing detection method with a new name specified in the request body. 
   * @param detectionMethodId  (required)
   * @param detectionMethod  (required)
   * @return DetectionMethod
   * @throws ApiException if fails to make API call
   */
  public DetectionMethod renameDetectionMethod(Integer detectionMethodId, DetectionMethod detectionMethod) throws ApiException {
    Object localVarPostBody = detectionMethod;
    
    // verify the required parameter 'detectionMethodId' is set
    if (detectionMethodId == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethodId' when calling renameDetectionMethod");
    }
    
    // verify the required parameter 'detectionMethod' is set
    if (detectionMethod == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethod' when calling renameDetectionMethod");
    }
    
    // create path and map variables
    String localVarPath = "/api/detection-methods/{detection-method-id}"
      .replaceAll("\\{" + "detection-method-id" + "\\}", apiClient.escapeString(detectionMethodId.toString()));

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

    GenericType<DetectionMethod> localVarReturnType = new GenericType<DetectionMethod>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Replace Manual Result
   * Allows a manual result to be replaced with another
   * @param resultId  (required)
   * @param manualResultRequest  (required)
   * @return ManualResultResponse
   * @throws ApiException if fails to make API call
   */
  public ManualResultResponse replaceManualResult(Integer resultId, ManualResultRequest manualResultRequest) throws ApiException {
    Object localVarPostBody = manualResultRequest;
    
    // verify the required parameter 'resultId' is set
    if (resultId == null) {
      throw new ApiException(400, "Missing the required parameter 'resultId' when calling replaceManualResult");
    }
    
    // verify the required parameter 'manualResultRequest' is set
    if (manualResultRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'manualResultRequest' when calling replaceManualResult");
    }
    
    // create path and map variables
    String localVarPath = "/api/manual-results/{result-id}/replace"
      .replaceAll("\\{" + "result-id" + "\\}", apiClient.escapeString(resultId.toString()));

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

    GenericType<ManualResultResponse> localVarReturnType = new GenericType<ManualResultResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
