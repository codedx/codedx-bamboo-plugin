# ProfileApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**profileChangePassword**](ProfileApi.md#profileChangePassword) | **POST** /api/profile/password | Change your password


<a name="profileChangePassword"></a>
# **profileChangePassword**
> profileChangePassword(passwordChangeBody)

Change your password

Change the password of the currently logged-in user, i.e. your password. Requires you to enter your current password.

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProfileApi;

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

ProfileApi apiInstance = new ProfileApi();
ProfilePasswordChange passwordChangeBody = new ProfilePasswordChange(); // ProfilePasswordChange | 
try {
    apiInstance.profileChangePassword(passwordChangeBody);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfileApi#profileChangePassword");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **passwordChangeBody** | [**ProfilePasswordChange**](ProfilePasswordChange.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

