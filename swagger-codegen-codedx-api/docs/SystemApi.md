# SystemApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getSystemInfo**](SystemApi.md#getSystemInfo) | **GET** /api/system-info | System Information


<a name="getSystemInfo"></a>
# **getSystemInfo**
> SystemInfo getSystemInfo()

System Information

Returns basic system information. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.SystemApi;

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

SystemApi apiInstance = new SystemApi();
try {
    SystemInfo result = apiInstance.getSystemInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemApi#getSystemInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SystemInfo**](SystemInfo.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/josn

