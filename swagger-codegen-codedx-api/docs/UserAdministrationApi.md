# UserAdministrationApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changeUserPassword**](UserAdministrationApi.md#changeUserPassword) | **POST** /api/admin/users/local/{user-id}/password | Change Password
[**createExternalUser**](UserAdministrationApi.md#createExternalUser) | **POST** /api/admin/users/external | Create External User
[**createKeyUser**](UserAdministrationApi.md#createKeyUser) | **POST** /api/admin/users/key | Create API Key User
[**createLdapUser**](UserAdministrationApi.md#createLdapUser) | **POST** /api/admin/users/ldap | Create LDAP User
[**createLocalUser**](UserAdministrationApi.md#createLocalUser) | **POST** /api/admin/users/local | Create Local User
[**deleteUser**](UserAdministrationApi.md#deleteUser) | **DELETE** /api/admin/users/{user-id} | Delete User
[**getAllUsers**](UserAdministrationApi.md#getAllUsers) | **GET** /api/admin/users | List All Users
[**getExternalUsers**](UserAdministrationApi.md#getExternalUsers) | **GET** /api/admin/users/external | List External Users
[**getKeyUsers**](UserAdministrationApi.md#getKeyUsers) | **GET** /api/admin/users/key | List API Key Users
[**getLdapUsers**](UserAdministrationApi.md#getLdapUsers) | **GET** /api/admin/users/ldap | List LDAP Users
[**getLocalUsers**](UserAdministrationApi.md#getLocalUsers) | **GET** /api/admin/users/local | List Local Users
[**modifyUser**](UserAdministrationApi.md#modifyUser) | **PUT** /api/admin/users/{user-id} | Disable User or Add/Remove Admin
[**regenerateApiKey**](UserAdministrationApi.md#regenerateApiKey) | **POST** /api/admin/users/key/{user-id}/regenerate | Regenerate API Key


<a name="changeUserPassword"></a>
# **changeUserPassword**
> changeUserPassword(userId, password)

Change Password

Local users&#39; passwords may be changed by administrators. Other user types don&#39;t have passwords. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
Integer userId = 56; // Integer | The user ID.
Password password = new Password(); // Password | 
try {
    apiInstance.changeUserPassword(userId, password);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#changeUserPassword");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user ID. |
 **password** | [**Password**](Password.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createExternalUser"></a>
# **createExternalUser**
> User createExternalUser(user)

Create External User

Creates an External user. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
CreateUser user = new CreateUser(); // CreateUser | 
try {
    User result = apiInstance.createExternalUser(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#createExternalUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**CreateUser**](CreateUser.md)|  | [optional]

### Return type

[**User**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createKeyUser"></a>
# **createKeyUser**
> User createKeyUser(user)

Create API Key User

Creates a API key user 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
CreateUser user = new CreateUser(); // CreateUser | 
try {
    User result = apiInstance.createKeyUser(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#createKeyUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**CreateUser**](CreateUser.md)|  | [optional]

### Return type

[**User**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createLdapUser"></a>
# **createLdapUser**
> User createLdapUser(user)

Create LDAP User

Creates a LDAP user. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
CreateUser user = new CreateUser(); // CreateUser | 
try {
    User result = apiInstance.createLdapUser(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#createLdapUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**CreateUser**](CreateUser.md)|  | [optional]

### Return type

[**User**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createLocalUser"></a>
# **createLocalUser**
> User createLocalUser(user)

Create Local User

Creates a local user. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
CreateUser user = new CreateUser(); // CreateUser | 
try {
    User result = apiInstance.createLocalUser(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#createLocalUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**CreateUser**](CreateUser.md)|  | [optional]

### Return type

[**User**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(userId)

Delete User

To delete a user, you must know its id (found from its corresponding user object). 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
Integer userId = 56; // Integer | The user ID.
try {
    apiInstance.deleteUser(userId);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user ID. |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllUsers"></a>
# **getAllUsers**
> List&lt;User&gt; getAllUsers()

List All Users

Returns a list of all users. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
try {
    List<User> result = apiInstance.getAllUsers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#getAllUsers");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getExternalUsers"></a>
# **getExternalUsers**
> List&lt;User&gt; getExternalUsers()

List External Users

Returns a list of external users. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
try {
    List<User> result = apiInstance.getExternalUsers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#getExternalUsers");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getKeyUsers"></a>
# **getKeyUsers**
> List&lt;User&gt; getKeyUsers()

List API Key Users

Returns a list of API key users. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
try {
    List<User> result = apiInstance.getKeyUsers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#getKeyUsers");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLdapUsers"></a>
# **getLdapUsers**
> List&lt;User&gt; getLdapUsers()

List LDAP Users

Returns a list of LDAP users. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
try {
    List<User> result = apiInstance.getLdapUsers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#getLdapUsers");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLocalUsers"></a>
# **getLocalUsers**
> List&lt;User&gt; getLocalUsers()

List Local Users

Returns a list of local users. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
try {
    List<User> result = apiInstance.getLocalUsers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#getLocalUsers");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="modifyUser"></a>
# **modifyUser**
> User modifyUser(userId, disableUser)

Disable User or Add/Remove Admin

A single endpoint is shared by the \&quot;enable/disable user\&quot; and \&quot;add/remove admin role\&quot; functionality. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
Integer userId = 56; // Integer | The user ID.
DisableUser disableUser = new DisableUser(); // DisableUser | 
try {
    User result = apiInstance.modifyUser(userId, disableUser);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#modifyUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user ID. |
 **disableUser** | [**DisableUser**](DisableUser.md)|  | [optional]

### Return type

[**User**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="regenerateApiKey"></a>
# **regenerateApiKey**
> User regenerateApiKey(userId)

Regenerate API Key

API Keys are represented with the key user type. Their principal represents the actual key, and can be randomly regenerated by this endpoint. No request body is required. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.UserAdministrationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

UserAdministrationApi apiInstance = new UserAdministrationApi();
Integer userId = 56; // Integer | The user ID.
try {
    User result = apiInstance.regenerateApiKey(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserAdministrationApi#regenerateApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user ID. |

### Return type

[**User**](User.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

