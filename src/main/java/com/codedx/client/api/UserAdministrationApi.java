package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.ChangeUserPasswordRequest;
import com.codedx.client.model.CreateUser;
import com.codedx.client.model.DisableUser;
import com.codedx.client.model.RegenerateApiKeyRequest;
import com.codedx.client.model.User;
import com.codedx.client.model.UserNotificationPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class UserAdministrationApi {
  private ApiClient apiClient;

  public UserAdministrationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UserAdministrationApi(ApiClient apiClient) {
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
   * Change Password
   * Local users&#39; passwords may be changed by administrators. Other user types don&#39;t have passwords.  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @param changeUserPasswordRequest  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The password was changed successfully </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, or the \&quot;password\&quot; field was missing or blank </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role or you are not the user being updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void changeUserPassword(@jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nullable ChangeUserPasswordRequest changeUserPasswordRequest) throws ApiException {
    changeUserPasswordWithHttpInfo(userId, changeUserPasswordRequest);
  }

  /**
   * Change Password
   * Local users&#39; passwords may be changed by administrators. Other user types don&#39;t have passwords.  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @param changeUserPasswordRequest  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The password was changed successfully </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, or the \&quot;password\&quot; field was missing or blank </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role or you are not the user being updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> changeUserPasswordWithHttpInfo(@jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nullable ChangeUserPasswordRequest changeUserPasswordRequest) throws ApiException {
    // Check required parameters
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling changeUserPassword");
    }

    // Path parameters
    String localVarPath = "/api/admin/users/local/{user-id}/password"
            .replaceAll("\\{user-id}", apiClient.escapeString(userId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserAdministrationApi.changeUserPassword", localVarPath, "POST", new ArrayList<>(), changeUserPasswordRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create External User
   * Creates an External user. This endpoint can be used to create SAML, OAuth, and Kerberos users.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return User
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user exceeds the license&#39;s user limit, or a user with the given name already exists. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public User createExternalUser(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    return createExternalUserWithHttpInfo(createUser).getData();
  }

  /**
   * Create External User
   * Creates an External user. This endpoint can be used to create SAML, OAuth, and Kerberos users.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user exceeds the license&#39;s user limit, or a user with the given name already exists. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<User> createExternalUserWithHttpInfo(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI("UserAdministrationApi.createExternalUser", "/api/admin/users/external", "POST", new ArrayList<>(), createUser,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create API Key User
   * Creates a API key user.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return User
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user exceeds the license&#39;s user limit, or if a user with the given name already exists or existed. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public User createKeyUser(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    return createKeyUserWithHttpInfo(createUser).getData();
  }

  /**
   * Create API Key User
   * Creates a API key user.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user exceeds the license&#39;s user limit, or if a user with the given name already exists or existed. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<User> createKeyUserWithHttpInfo(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI("UserAdministrationApi.createKeyUser", "/api/admin/users/key", "POST", new ArrayList<>(), createUser,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create LDAP User
   * Creates a LDAP user.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return User
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user would exceed the license&#39;s user limit, or if a user with the given name already existed. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public User createLdapUser(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    return createLdapUserWithHttpInfo(createUser).getData();
  }

  /**
   * Create LDAP User
   * Creates a LDAP user.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user would exceed the license&#39;s user limit, or if a user with the given name already existed. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<User> createLdapUserWithHttpInfo(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI("UserAdministrationApi.createLdapUser", "/api/admin/users/ldap", "POST", new ArrayList<>(), createUser,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create Local User
   * Creates a local user.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return User
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user exceeds the license&#39;s user limit, or if a user with the given name already existed. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public User createLocalUser(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    return createLocalUserWithHttpInfo(createUser).getData();
  }

  /**
   * Create Local User
   * Creates a local user.  Requires the \&quot;Admin\&quot; role.
   * @param createUser  (optional)
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON, was missing a required field, or had an improper value for one of the fields </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Creating the user exceeds the license&#39;s user limit, or if a user with the given name already existed. The response body will contain a message explaining the conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<User> createLocalUserWithHttpInfo(@jakarta.annotation.Nullable CreateUser createUser) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI("UserAdministrationApi.createLocalUser", "/api/admin/users/local", "POST", new ArrayList<>(), createUser,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete User
   * To delete a user, you must know its id (found from its corresponding user object).  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The operation was successful </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role, or you attempted to delete yourself </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteUser(@jakarta.annotation.Nonnull Integer userId) throws ApiException {
    deleteUserWithHttpInfo(userId);
  }

  /**
   * Delete User
   * To delete a user, you must know its id (found from its corresponding user object).  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - The operation was successful </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role, or you attempted to delete yourself </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteUserWithHttpInfo(@jakarta.annotation.Nonnull Integer userId) throws ApiException {
    // Check required parameters
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling deleteUser");
    }

    // Path parameters
    String localVarPath = "/api/admin/users/{user-id}"
            .replaceAll("\\{user-id}", apiClient.escapeString(userId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserAdministrationApi.deleteUser", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * List All Users
   * Returns a list of all users.  Requires the \&quot;Admin\&quot; role.
   * @return List&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<User> getAllUsers() throws ApiException {
    return getAllUsersWithHttpInfo().getData();
  }

  /**
   * List All Users
   * Returns a list of all users.  Requires the \&quot;Admin\&quot; role.
   * @return ApiResponse&lt;List&lt;User&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<User>> getAllUsersWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<User>> localVarReturnType = new GenericType<List<User>>() {};
    return apiClient.invokeAPI("UserAdministrationApi.getAllUsers", "/api/admin/users", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List External Users
   * Returns a list of external users.  Requires the \&quot;Admin\&quot; role.
   * @return List&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<User> getExternalUsers() throws ApiException {
    return getExternalUsersWithHttpInfo().getData();
  }

  /**
   * List External Users
   * Returns a list of external users.  Requires the \&quot;Admin\&quot; role.
   * @return ApiResponse&lt;List&lt;User&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<User>> getExternalUsersWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<User>> localVarReturnType = new GenericType<List<User>>() {};
    return apiClient.invokeAPI("UserAdministrationApi.getExternalUsers", "/api/admin/users/external", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List API Key Users
   * Returns a list of API key users.  Requires the \&quot;Admin\&quot; role.
   * @return List&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<User> getKeyUsers() throws ApiException {
    return getKeyUsersWithHttpInfo().getData();
  }

  /**
   * List API Key Users
   * Returns a list of API key users.  Requires the \&quot;Admin\&quot; role.
   * @return ApiResponse&lt;List&lt;User&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<User>> getKeyUsersWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<User>> localVarReturnType = new GenericType<List<User>>() {};
    return apiClient.invokeAPI("UserAdministrationApi.getKeyUsers", "/api/admin/users/key", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List LDAP Users
   * Returns a list of LDAP users.  Requires the \&quot;Admin\&quot; role.
   * @return List&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<User> getLdapUsers() throws ApiException {
    return getLdapUsersWithHttpInfo().getData();
  }

  /**
   * List LDAP Users
   * Returns a list of LDAP users.  Requires the \&quot;Admin\&quot; role.
   * @return ApiResponse&lt;List&lt;User&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<User>> getLdapUsersWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<User>> localVarReturnType = new GenericType<List<User>>() {};
    return apiClient.invokeAPI("UserAdministrationApi.getLdapUsers", "/api/admin/users/ldap", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Local Users
   * Returns a list of local users.  Requires the \&quot;Admin\&quot; role.
   * @return List&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - If you lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<User> getLocalUsers() throws ApiException {
    return getLocalUsersWithHttpInfo().getData();
  }

  /**
   * List Local Users
   * Returns a list of local users.  Requires the \&quot;Admin\&quot; role.
   * @return ApiResponse&lt;List&lt;User&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of user object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - If you lack the admin role </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<User>> getLocalUsersWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<User>> localVarReturnType = new GenericType<List<User>>() {};
    return apiClient.invokeAPI("UserAdministrationApi.getLocalUsers", "/api/admin/users/local", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Notification Preferences
   * Returns your notification preferences.
   * @return UserNotificationPreferences
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be your notification preferences </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role, or are not the specified user </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public UserNotificationPreferences getNotificationPreferences() throws ApiException {
    return getNotificationPreferencesWithHttpInfo().getData();
  }

  /**
   * Get Notification Preferences
   * Returns your notification preferences.
   * @return ApiResponse&lt;UserNotificationPreferences&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be your notification preferences </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role, or are not the specified user </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<UserNotificationPreferences> getNotificationPreferencesWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<UserNotificationPreferences> localVarReturnType = new GenericType<UserNotificationPreferences>() {};
    return apiClient.invokeAPI("UserAdministrationApi.getNotificationPreferences", "/x/me/notification-preferences", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Disable User or Add/Remove Admin
   * A single endpoint is shared by the \&quot;enable/disable user\&quot; and \&quot;add/remove admin role\&quot; functionality.  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @param disableUser  (optional)
   * @return User
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object representing the new state of the user </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was missing or incorrect </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Enabling the user exceeds the user limit on your license </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public User modifyUser(@jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nullable DisableUser disableUser) throws ApiException {
    return modifyUserWithHttpInfo(userId, disableUser).getData();
  }

  /**
   * Disable User or Add/Remove Admin
   * A single endpoint is shared by the \&quot;enable/disable user\&quot; and \&quot;add/remove admin role\&quot; functionality.  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @param disableUser  (optional)
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object representing the new state of the user </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was missing or incorrect </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The user does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Enabling the user exceeds the user limit on your license </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<User> modifyUserWithHttpInfo(@jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nullable DisableUser disableUser) throws ApiException {
    // Check required parameters
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling modifyUser");
    }

    // Path parameters
    String localVarPath = "/api/admin/users/{user-id}"
            .replaceAll("\\{user-id}", apiClient.escapeString(userId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI("UserAdministrationApi.modifyUser", localVarPath, "PUT", new ArrayList<>(), disableUser,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Regenerate API Key
   * API Keys are represented with the key user type. Their principal represents the actual key, and can be randomly regenerated by this endpoint. No request body is required.  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @param regenerateApiKeyRequest  (optional)
   * @return User
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object representing the updated API key user. The principal field will contain the new API key </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role, or are connected via the API Key that is being regenerated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The API Key does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public User regenerateApiKey(@jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nullable RegenerateApiKeyRequest regenerateApiKeyRequest) throws ApiException {
    return regenerateApiKeyWithHttpInfo(userId, regenerateApiKeyRequest).getData();
  }

  /**
   * Regenerate API Key
   * API Keys are represented with the key user type. Their principal represents the actual key, and can be randomly regenerated by this endpoint. No request body is required.  Requires the \&quot;Admin\&quot; role.
   * @param userId The user ID. (required)
   * @param regenerateApiKeyRequest  (optional)
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a user object representing the updated API key user. The principal field will contain the new API key </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the admin role, or are connected via the API Key that is being regenerated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The API Key does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<User> regenerateApiKeyWithHttpInfo(@jakarta.annotation.Nonnull Integer userId, @jakarta.annotation.Nullable RegenerateApiKeyRequest regenerateApiKeyRequest) throws ApiException {
    // Check required parameters
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling regenerateApiKey");
    }

    // Path parameters
    String localVarPath = "/api/admin/users/key/{user-id}/regenerate"
            .replaceAll("\\{user-id}", apiClient.escapeString(userId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI("UserAdministrationApi.regenerateApiKey", localVarPath, "POST", new ArrayList<>(), regenerateApiKeyRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
