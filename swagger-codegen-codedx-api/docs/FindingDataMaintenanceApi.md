# FindingDataMaintenanceApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDisabledToolResultCount**](FindingDataMaintenanceApi.md#getDisabledToolResultCount) | **GET** /api/projects/{project-id}/disabled-tool-result-count | Disabled Tool Result Count Query
[**purgeDisabledToolResults**](FindingDataMaintenanceApi.md#purgeDisabledToolResults) | **POST** /api/projects/{project-id}/purge-disabled-tool-results | Purge Disabled Tool Results


<a name="getDisabledToolResultCount"></a>
# **getDisabledToolResultCount**
> DisabledToolResultsCount getDisabledToolResultCount(projectId)

Disabled Tool Result Count Query

Returns a count of disabled findings present within a project. These are findings that match rules that are currently disabled, will not be ingested in new analyses, and would be removed by a purge task. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataMaintenanceApi;

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

FindingDataMaintenanceApi apiInstance = new FindingDataMaintenanceApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    DisabledToolResultsCount result = apiInstance.getDisabledToolResultCount(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataMaintenanceApi#getDisabledToolResultCount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

[**DisabledToolResultsCount**](DisabledToolResultsCount.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="purgeDisabledToolResults"></a>
# **purgeDisabledToolResults**
> purgeDisabledToolResults(projectId)

Purge Disabled Tool Results

Executes a purge/cleanup operation on the finding data for the project. Any findings that match disabled rules will immediately be marked for removal, and, at some future point, be actually removed from the database by an automatic garbage collection task. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataMaintenanceApi;

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

FindingDataMaintenanceApi apiInstance = new FindingDataMaintenanceApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    apiInstance.purgeDisabledToolResults(projectId);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataMaintenanceApi#purgeDisabledToolResults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

