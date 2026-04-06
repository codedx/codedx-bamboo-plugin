package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.DetectionMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class DetectionMethodsApi {
  private ApiClient apiClient;

  public DetectionMethodsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DetectionMethodsApi(ApiClient apiClient) {
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
   * Create Detection Method
   * Create a new detection method with a name specified in the request body.  Requires the \&quot;detection-methods:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param detectionMethod Only the name property needs to be provided. (required)
   * @return DetectionMethod
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Body contains a Detection Method object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The parameter \&quot;name\&quot; was missing from the request body, was not a String, or was too long </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to manage detection methods </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Another detection method with the same name already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public DetectionMethod createDetectionMethod(@jakarta.annotation.Nonnull DetectionMethod detectionMethod) throws ApiException {
    return createDetectionMethodWithHttpInfo(detectionMethod).getData();
  }

  /**
   * Create Detection Method
   * Create a new detection method with a name specified in the request body.  Requires the \&quot;detection-methods:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param detectionMethod Only the name property needs to be provided. (required)
   * @return ApiResponse&lt;DetectionMethod&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Body contains a Detection Method object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The parameter \&quot;name\&quot; was missing from the request body, was not a String, or was too long </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to manage detection methods </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Another detection method with the same name already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DetectionMethod> createDetectionMethodWithHttpInfo(@jakarta.annotation.Nonnull DetectionMethod detectionMethod) throws ApiException {
    // Check required parameters
    if (detectionMethod == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethod' when calling createDetectionMethod");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<DetectionMethod> localVarReturnType = new GenericType<DetectionMethod>() {};
    return apiClient.invokeAPI("DetectionMethodsApi.createDetectionMethod", "/api/detection-methods", "POST", new ArrayList<>(), detectionMethod,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Detection Method.
   * Delete a detection method. Use the replacement parameter to replace any references to the deleted method with a different method.  Requires the \&quot;detection-methods:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param detectionMethodId  (required)
   * @param replacement The ID of the replacement detection method. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Successful deletion </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Replacement-id param is not an integer, or is equal to id, or the detection method is readOnly </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to manage detection methods </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No detection method exists with the given id, or no detection method exists with an id equal to replacement id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteDetectionMethod(@jakarta.annotation.Nonnull Integer detectionMethodId, @jakarta.annotation.Nullable Integer replacement) throws ApiException {
    deleteDetectionMethodWithHttpInfo(detectionMethodId, replacement);
  }

  /**
   * Delete Detection Method.
   * Delete a detection method. Use the replacement parameter to replace any references to the deleted method with a different method.  Requires the \&quot;detection-methods:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param detectionMethodId  (required)
   * @param replacement The ID of the replacement detection method. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Successful deletion </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Replacement-id param is not an integer, or is equal to id, or the detection method is readOnly </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to manage detection methods </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No detection method exists with the given id, or no detection method exists with an id equal to replacement id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteDetectionMethodWithHttpInfo(@jakarta.annotation.Nonnull Integer detectionMethodId, @jakarta.annotation.Nullable Integer replacement) throws ApiException {
    // Check required parameters
    if (detectionMethodId == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethodId' when calling deleteDetectionMethod");
    }

    // Path parameters
    String localVarPath = "/api/detection-methods/{detection-method-id}"
            .replaceAll("\\{detection-method-id}", apiClient.escapeString(detectionMethodId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "replacement", replacement)
    );

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("DetectionMethodsApi.deleteDetectionMethod", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * List Detection Methods
   * Returns a list of all detection methods.  Requires no role, all users have sufficient permissions by default.
   * @return List&lt;DetectionMethod&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an array of detection method objects. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<DetectionMethod> getAllDetectionMethods() throws ApiException {
    return getAllDetectionMethodsWithHttpInfo().getData();
  }

  /**
   * List Detection Methods
   * Returns a list of all detection methods.  Requires no role, all users have sufficient permissions by default.
   * @return ApiResponse&lt;List&lt;DetectionMethod&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an array of detection method objects. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<DetectionMethod>> getAllDetectionMethodsWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<DetectionMethod>> localVarReturnType = new GenericType<List<DetectionMethod>>() {};
    return apiClient.invokeAPI("DetectionMethodsApi.getAllDetectionMethods", "/api/detection-methods", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Rename Detection Method
   * Rename an existing detection method with a new name specified in the request body.  Requires the \&quot;detection-methods:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param detectionMethodId  (required)
   * @param detectionMethod  (required)
   * @return DetectionMethod
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Successful rename; body contains a Detection Method object with the latest data for the modified detection method </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The \&quot;name\&quot; parameter was missing from the request body, was not a string. was too long, or the detection method is readyOnly </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to manage detection methods </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No detection method exists with the given id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public DetectionMethod renameDetectionMethod(@jakarta.annotation.Nonnull Integer detectionMethodId, @jakarta.annotation.Nonnull DetectionMethod detectionMethod) throws ApiException {
    return renameDetectionMethodWithHttpInfo(detectionMethodId, detectionMethod).getData();
  }

  /**
   * Rename Detection Method
   * Rename an existing detection method with a new name specified in the request body.  Requires the \&quot;detection-methods:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param detectionMethodId  (required)
   * @param detectionMethod  (required)
   * @return ApiResponse&lt;DetectionMethod&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Successful rename; body contains a Detection Method object with the latest data for the modified detection method </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The \&quot;name\&quot; parameter was missing from the request body, was not a string. was too long, or the detection method is readyOnly </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to manage detection methods </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No detection method exists with the given id </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DetectionMethod> renameDetectionMethodWithHttpInfo(@jakarta.annotation.Nonnull Integer detectionMethodId, @jakarta.annotation.Nonnull DetectionMethod detectionMethod) throws ApiException {
    // Check required parameters
    if (detectionMethodId == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethodId' when calling renameDetectionMethod");
    }
    if (detectionMethod == null) {
      throw new ApiException(400, "Missing the required parameter 'detectionMethod' when calling renameDetectionMethod");
    }

    // Path parameters
    String localVarPath = "/api/detection-methods/{detection-method-id}"
            .replaceAll("\\{detection-method-id}", apiClient.escapeString(detectionMethodId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<DetectionMethod> localVarReturnType = new GenericType<DetectionMethod>() {};
    return apiClient.invokeAPI("DetectionMethodsApi.renameDetectionMethod", localVarPath, "PUT", new ArrayList<>(), detectionMethod,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
