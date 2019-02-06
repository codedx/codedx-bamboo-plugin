package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.codedx.client.api.ProfilePasswordChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-02T17:17:22.434-05:00")
public class ProfileApi {
  private ApiClient apiClient;

  public ProfileApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProfileApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Change your password
   * Change the password of the currently logged-in user, i.e. your password. Requires you to enter your current password.
   * @param passwordChangeBody  (optional)
   * @throws ApiException if fails to make API call
   */
  public void profileChangePassword(ProfilePasswordChange passwordChangeBody) throws ApiException {
    Object localVarPostBody = passwordChangeBody;
    
    // create path and map variables
    String localVarPath = "/api/profile/password";

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
