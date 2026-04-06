package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.CreatePersonalAccessToken200Response;
import com.codedx.client.model.CreatePersonalAccessTokenRequest;
import com.codedx.client.model.Error;
import com.codedx.client.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class PersonalAccessTokensApi {
  private ApiClient apiClient;

  public PersonalAccessTokensApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PersonalAccessTokensApi(ApiClient apiClient) {
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
   * Create a new personal access token
   * Create a new personal access token, belonging to whichever user you are authenticated as when making this request. The token string in the response can be used as a bearer token to authenticate with other endpoints in the Software Risk Manager REST API. Note that you may not use a personal access token to access this endpoint.  Requires no role, all users have sufficient permissions by default.
   * @param createPersonalAccessTokenRequest  (optional)
   * @return CreatePersonalAccessToken200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - provides a common representation of the new &#39;user&#39; that represents the new token, as well as the raw &#39;token&#39; value that acts as the bearer token for authentication purposes </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - if you didn&#39;t provide a request body, the request body wasn&#39;t JSON, or if the JSON request body didn&#39;t match the expected schema </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if you didn&#39;t provide credentials, or if you tried to access this endpoint via a personal access token </td><td>  -  </td></tr>
     </table>
   */
  public CreatePersonalAccessToken200Response createPersonalAccessToken(@jakarta.annotation.Nullable CreatePersonalAccessTokenRequest createPersonalAccessTokenRequest) throws ApiException {
    return createPersonalAccessTokenWithHttpInfo(createPersonalAccessTokenRequest).getData();
  }

  /**
   * Create a new personal access token
   * Create a new personal access token, belonging to whichever user you are authenticated as when making this request. The token string in the response can be used as a bearer token to authenticate with other endpoints in the Software Risk Manager REST API. Note that you may not use a personal access token to access this endpoint.  Requires no role, all users have sufficient permissions by default.
   * @param createPersonalAccessTokenRequest  (optional)
   * @return ApiResponse&lt;CreatePersonalAccessToken200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - provides a common representation of the new &#39;user&#39; that represents the new token, as well as the raw &#39;token&#39; value that acts as the bearer token for authentication purposes </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - if you didn&#39;t provide a request body, the request body wasn&#39;t JSON, or if the JSON request body didn&#39;t match the expected schema </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if you didn&#39;t provide credentials, or if you tried to access this endpoint via a personal access token </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CreatePersonalAccessToken200Response> createPersonalAccessTokenWithHttpInfo(@jakarta.annotation.Nullable CreatePersonalAccessTokenRequest createPersonalAccessTokenRequest) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth"};
    GenericType<CreatePersonalAccessToken200Response> localVarReturnType = new GenericType<CreatePersonalAccessToken200Response>() {};
    return apiClient.invokeAPI("PersonalAccessTokensApi.createPersonalAccessToken", "/x/me/personal-access-tokens", "POST", new ArrayList<>(), createPersonalAccessTokenRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete (revoke) one of your personal access tokens
   * Deletes a personal access token, identified by its &#39;user id&#39; as a URL parameter, as long as it exists and belongs to you. History / activity associated with this token, such as triggered analyses and comments, will be preserved. Note that you may not use a personal access token to access this endpoint.  Requires no role, all users have sufficient permissions by default.
   * @param tokenUserId The &#39;id&#39; of the user that represents the personal access token to be deleted. This value can be found in the &#39;user.id&#39; field of the createPersonalAccessToken response, or in the &#39;id&#39; of the appropriate object in the getPersonalAccessTokens response (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - indicates a successful deletion </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if you didn&#39;t provide credentials, or if you tried to access this endpoint via a personal access token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - no token belonging to you matches the given &#x60;token-user-id&#x60; parameter. Note that this response makes no distinction between &#39;no such token&#39; and &#39;that token does not belong to you&#39; </td><td>  -  </td></tr>
     </table>
   */
  public void deletePersonalAccessToken(@jakarta.annotation.Nonnull Integer tokenUserId) throws ApiException {
    deletePersonalAccessTokenWithHttpInfo(tokenUserId);
  }

  /**
   * Delete (revoke) one of your personal access tokens
   * Deletes a personal access token, identified by its &#39;user id&#39; as a URL parameter, as long as it exists and belongs to you. History / activity associated with this token, such as triggered analyses and comments, will be preserved. Note that you may not use a personal access token to access this endpoint.  Requires no role, all users have sufficient permissions by default.
   * @param tokenUserId The &#39;id&#39; of the user that represents the personal access token to be deleted. This value can be found in the &#39;user.id&#39; field of the createPersonalAccessToken response, or in the &#39;id&#39; of the appropriate object in the getPersonalAccessTokens response (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - indicates a successful deletion </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if you didn&#39;t provide credentials, or if you tried to access this endpoint via a personal access token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - no token belonging to you matches the given &#x60;token-user-id&#x60; parameter. Note that this response makes no distinction between &#39;no such token&#39; and &#39;that token does not belong to you&#39; </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deletePersonalAccessTokenWithHttpInfo(@jakarta.annotation.Nonnull Integer tokenUserId) throws ApiException {
    // Check required parameters
    if (tokenUserId == null) {
      throw new ApiException(400, "Missing the required parameter 'tokenUserId' when calling deletePersonalAccessToken");
    }

    // Path parameters
    String localVarPath = "/x/me/personal-access-tokens/{token-user-id}"
            .replaceAll("\\{token-user-id}", apiClient.escapeString(tokenUserId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth"};
    return apiClient.invokeAPI("PersonalAccessTokensApi.deletePersonalAccessToken", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get a list of your personal access tokens
   * Responds with a list of your own personal access tokens. Note that this endpoint will never show you the actual token credential string, only a summary of the &#39;user&#39; that the token represents. Also note that you may not use a personal access token to access this endpoint.  Requires no role, all users have sufficient permissions by default.
   * @return List&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body contains a list of tokens represented as &#39;Users&#39; </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if you didn&#39;t provide credentials, or if you tried to access this endpoint via a personal access token </td><td>  -  </td></tr>
     </table>
   */
  public List<User> getPersonalAccessTokens() throws ApiException {
    return getPersonalAccessTokensWithHttpInfo().getData();
  }

  /**
   * Get a list of your personal access tokens
   * Responds with a list of your own personal access tokens. Note that this endpoint will never show you the actual token credential string, only a summary of the &#39;user&#39; that the token represents. Also note that you may not use a personal access token to access this endpoint.  Requires no role, all users have sufficient permissions by default.
   * @return ApiResponse&lt;List&lt;User&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body contains a list of tokens represented as &#39;Users&#39; </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if you didn&#39;t provide credentials, or if you tried to access this endpoint via a personal access token </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<User>> getPersonalAccessTokensWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth"};
    GenericType<List<User>> localVarReturnType = new GenericType<List<User>>() {};
    return apiClient.invokeAPI("PersonalAccessTokensApi.getPersonalAccessTokens", "/x/me/personal-access-tokens", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
