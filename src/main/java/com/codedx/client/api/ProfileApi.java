package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.ProfilePasswordChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ProfileApi {
  private ApiClient apiClient;

  public ProfileApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProfileApi(ApiClient apiClient) {
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
   * Change your password
   * Change the password of the currently logged-in user, i.e. your password. Requires you to enter your current password.  Requires no role, all users have sufficient permissions by default.
   * @param profilePasswordChange  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Password was successfully changed. No further response required. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Missing the request body, or one of the required fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You aren&#39;t logged in as any user </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - You are logged in as a user type whose password is not managed by Software Risk Manager, and therefore cannot be changed within Software Risk Manager </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void profileChangePassword(@jakarta.annotation.Nullable ProfilePasswordChange profilePasswordChange) throws ApiException {
    profileChangePasswordWithHttpInfo(profilePasswordChange);
  }

  /**
   * Change your password
   * Change the password of the currently logged-in user, i.e. your password. Requires you to enter your current password.  Requires no role, all users have sufficient permissions by default.
   * @param profilePasswordChange  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Password was successfully changed. No further response required. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Missing the request body, or one of the required fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You aren&#39;t logged in as any user </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - You are logged in as a user type whose password is not managed by Software Risk Manager, and therefore cannot be changed within Software Risk Manager </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> profileChangePasswordWithHttpInfo(@jakarta.annotation.Nullable ProfilePasswordChange profilePasswordChange) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ProfileApi.profileChangePassword", "/api/profile/password", "POST", new ArrayList<>(), profilePasswordChange,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
