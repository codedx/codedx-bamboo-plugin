# ActionsApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clearSeverityOverride**](ActionsApi.md#clearSeverityOverride) | **DELETE** /api/findings/{finding-id}/severity-override | Severity Override [Clear]
[**overrideSeverity**](ActionsApi.md#overrideSeverity) | **PUT** /api/findings/{finding-id}/severity-override | Severity Override [Set]
[**postComment**](ActionsApi.md#postComment) | **POST** /api/findings/{finding-id}/comment | Post Comment
[**setBulkStatus**](ActionsApi.md#setBulkStatus) | **POST** /api/projects/{project-id}/bulk-status-update | Bulk Status Update
[**setStatus**](ActionsApi.md#setStatus) | **PUT** /api/findings/{finding-id}/status | Status Update


<a name="clearSeverityOverride"></a>
# **clearSeverityOverride**
> clearSeverityOverride(findingId)

Severity Override [Clear]

Allows severity overrides for findings to be cleared. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.ActionsApi;

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

ActionsApi apiInstance = new ActionsApi();
Integer findingId = 56; // Integer | The finding ID.
try {
    apiInstance.clearSeverityOverride(findingId);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#clearSeverityOverride");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **findingId** | **Integer**| The finding ID. |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="overrideSeverity"></a>
# **overrideSeverity**
> overrideSeverity(findingId, severity)

Severity Override [Set]

Allows severities for findings to be overridden. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.ActionsApi;

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

ActionsApi apiInstance = new ActionsApi();
Integer findingId = 56; // Integer | The finding ID.
SeverityOverride severity = new SeverityOverride(); // SeverityOverride | 
try {
    apiInstance.overrideSeverity(findingId, severity);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#overrideSeverity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **findingId** | **Integer**| The finding ID. |
 **severity** | [**SeverityOverride**](SeverityOverride.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postComment"></a>
# **postComment**
> postComment(findingId, content)

Post Comment

Post a new comment on a finding

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.ActionsApi;

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

ActionsApi apiInstance = new ActionsApi();
Integer findingId = 56; // Integer | The finding ID.
PostComment content = new PostComment(); // PostComment | `content` should be a string containing the raw markdown content of the new comment
try {
    apiInstance.postComment(findingId, content);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#postComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **findingId** | **Integer**| The finding ID. |
 **content** | [**PostComment**](PostComment.md)| &#x60;content&#x60; should be a string containing the raw markdown content of the new comment |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="setBulkStatus"></a>
# **setBulkStatus**
> Job setBulkStatus(projectId, bulkStatusUpdate)

Bulk Status Update

Allows bulk updating of triage statuses of multiple findings, controlled by a filter. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.ActionsApi;

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

ActionsApi apiInstance = new ActionsApi();
Integer projectId = 56; // Integer | The ID of the project.
SetStatusBulk bulkStatusUpdate = new SetStatusBulk(); // SetStatusBulk | 
try {
    Job result = apiInstance.setBulkStatus(projectId, bulkStatusUpdate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#setBulkStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **bulkStatusUpdate** | [**SetStatusBulk**](SetStatusBulk.md)|  | [optional]

### Return type

[**Job**](Job.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setStatus"></a>
# **setStatus**
> setStatus(findingId, status)

Status Update

Allows changing of the triage status of a single finding. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint. 

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.ActionsApi;

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

ActionsApi apiInstance = new ActionsApi();
Integer findingId = 56; // Integer | The finding ID.
SetStatus status = new SetStatus(); // SetStatus | `status` should be a valid status ID 
try {
    apiInstance.setStatus(findingId, status);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#setStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **findingId** | **Integer**| The finding ID. |
 **status** | [**SetStatus**](SetStatus.md)| &#x60;status&#x60; should be a valid status ID  |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

