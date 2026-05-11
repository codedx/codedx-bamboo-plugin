package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.BasicJobResponse;
import com.codedx.client.model.Error;
import com.codedx.client.model.MlTriageServerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class MachineLearningTriageApi {
  private ApiClient apiClient;

  public MachineLearningTriageApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MachineLearningTriageApi(ApiClient apiClient) {
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
   * Get Machine Learning related metadata
   * Get Machine Learning related metadata.  Requires no role, all users have sufficient permissions by default.
   * @return MlTriageServerStatus
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Metadata was successfully retrieved </td><td>  -  </td></tr>
     </table>
   */
  public MlTriageServerStatus getMlTriageMetadata() throws ApiException {
    return getMlTriageMetadataWithHttpInfo().getData();
  }

  /**
   * Get Machine Learning related metadata
   * Get Machine Learning related metadata.  Requires no role, all users have sufficient permissions by default.
   * @return ApiResponse&lt;MlTriageServerStatus&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Metadata was successfully retrieved </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<MlTriageServerStatus> getMlTriageMetadataWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<MlTriageServerStatus> localVarReturnType = new GenericType<MlTriageServerStatus>() {};
    return apiClient.invokeAPI("MachineLearningTriageApi.getMlTriageMetadata", "/x/mltriage/metadata", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check if Machine Learning capabilities are enabled
   * Check if Machine Learning capabilities are enabled.  Requires no role, all users have sufficient permissions by default.
   * @return Boolean
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Feature is/is not Enabled </td><td>  -  </td></tr>
     </table>
   */
  public Boolean getMltriageEnabled() throws ApiException {
    return getMltriageEnabledWithHttpInfo().getData();
  }

  /**
   * Check if Machine Learning capabilities are enabled
   * Check if Machine Learning capabilities are enabled.  Requires no role, all users have sufficient permissions by default.
   * @return ApiResponse&lt;Boolean&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Feature is/is not Enabled </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Boolean> getMltriageEnabledWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI("MachineLearningTriageApi.getMltriageEnabled", "/x/mltriage/enabled", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Trigger a (re)train job
   * Trigger (re)training of the Machine Learning Prediction model.  Requires the \&quot;Admin\&quot; role.
   * @return BasicJobResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Training job was submitted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The requester is not an admin </td><td>  -  </td></tr>
     </table>
   */
  public BasicJobResponse postMlTriageTrain() throws ApiException {
    return postMlTriageTrainWithHttpInfo().getData();
  }

  /**
   * Trigger a (re)train job
   * Trigger (re)training of the Machine Learning Prediction model.  Requires the \&quot;Admin\&quot; role.
   * @return ApiResponse&lt;BasicJobResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Training job was submitted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The requester is not an admin </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BasicJobResponse> postMlTriageTrainWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<BasicJobResponse> localVarReturnType = new GenericType<BasicJobResponse>() {};
    return apiClient.invokeAPI("MachineLearningTriageApi.postMlTriageTrain", "/x/mltriage/train", "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Enable/Disable Machine Learning capabilities
   * Enable/Disable Machine Learning capabilities.  Requires the \&quot;Admin\&quot; role.
   * @param body The body should consist of a single boolean value.  Provide a value of &#x60;true&#x60; to enable the feature, and provide a value of &#x60;false&#x60; to disable it. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> OK - Machine Learning capabilities were enabled/disabled </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body should either be &#39;true&#39; or &#39;false&#39; </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The requester is not an admin </td><td>  -  </td></tr>
     </table>
   */
  public void putMlTriageEnabled(@jakarta.annotation.Nonnull Boolean body) throws ApiException {
    putMlTriageEnabledWithHttpInfo(body);
  }

  /**
   * Enable/Disable Machine Learning capabilities
   * Enable/Disable Machine Learning capabilities.  Requires the \&quot;Admin\&quot; role.
   * @param body The body should consist of a single boolean value.  Provide a value of &#x60;true&#x60; to enable the feature, and provide a value of &#x60;false&#x60; to disable it. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> OK - Machine Learning capabilities were enabled/disabled </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body should either be &#39;true&#39; or &#39;false&#39; </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The requester is not an admin </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> putMlTriageEnabledWithHttpInfo(@jakarta.annotation.Nonnull Boolean body) throws ApiException {
    // Check required parameters
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling putMlTriageEnabled");
    }

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("MachineLearningTriageApi.putMlTriageEnabled", "/x/mltriage/enabled", "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
