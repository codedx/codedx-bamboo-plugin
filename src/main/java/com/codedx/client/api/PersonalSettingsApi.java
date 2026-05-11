package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.UserNotificationPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class PersonalSettingsApi {
  private ApiClient apiClient;

  public PersonalSettingsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PersonalSettingsApi(ApiClient apiClient) {
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
   * Edit Notification Preferences
   * Set your notification preferences.
   * @param userNotificationPreferences  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Successfully updated your notification preferences </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was missing or incorrect </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setNotificationPreferences(@jakarta.annotation.Nonnull UserNotificationPreferences userNotificationPreferences) throws ApiException {
    setNotificationPreferencesWithHttpInfo(userNotificationPreferences);
  }

  /**
   * Edit Notification Preferences
   * Set your notification preferences.
   * @param userNotificationPreferences  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Successfully updated your notification preferences </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was missing or incorrect </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setNotificationPreferencesWithHttpInfo(@jakarta.annotation.Nonnull UserNotificationPreferences userNotificationPreferences) throws ApiException {
    // Check required parameters
    if (userNotificationPreferences == null) {
      throw new ApiException(400, "Missing the required parameter 'userNotificationPreferences' when calling setNotificationPreferences");
    }

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("PersonalSettingsApi.setNotificationPreferences", "/x/me/notification-preferences", "PUT", new ArrayList<>(), userNotificationPreferences,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
