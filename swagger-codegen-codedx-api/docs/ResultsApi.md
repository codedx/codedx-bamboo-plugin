# ResultsApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDetectionMethod**](ResultsApi.md#createDetectionMethod) | **POST** /api/detection-methods | Create Detection Method
[**createManualResult**](ResultsApi.md#createManualResult) | **POST** /api/manual-results | Create Manual Result
[**deleteDetectionMethod**](ResultsApi.md#deleteDetectionMethod) | **DELETE** /api/detection-methods/{detection-method-id} | Delete Detection Method.
[**deleteManualResult**](ResultsApi.md#deleteManualResult) | **DELETE** /api/manual-results/{result-id} | Delete Manual Result
[**getAllDetectionMethods**](ResultsApi.md#getAllDetectionMethods) | **GET** /api/detection-methods | List Detection Methods
[**getManualResultAllowedTools**](ResultsApi.md#getManualResultAllowedTools) | **GET** /api/manual-results/allowed-tools | Get Allowed Manaul Result Tools
[**modifyManualResultAllowedTool**](ResultsApi.md#modifyManualResultAllowedTool) | **POST** /api/manual-results/allowed-tools | Modify Allowed Manual Result Tool
[**renameDetectionMethod**](ResultsApi.md#renameDetectionMethod) | **PUT** /api/detection-methods/{detection-method-id} | Rename Detection Method
[**replaceManualResult**](ResultsApi.md#replaceManualResult) | **POST** /api/manual-results/{result-id}/replace | Replace Manual Result


<a name="createDetectionMethod"></a>
# **createDetectionMethod**
> DetectionMethod createDetectionMethod(detectionMethod)

Create Detection Method

Create a new detection method with a name specified in the request body. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
DetectionMethod detectionMethod = new DetectionMethod(); // DetectionMethod | Only the name property needs to be provided.
try {
    DetectionMethod result = apiInstance.createDetectionMethod(detectionMethod);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#createDetectionMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **detectionMethod** | [**DetectionMethod**](DetectionMethod.md)| Only the name property needs to be provided. |

### Return type

[**DetectionMethod**](DetectionMethod.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createManualResult"></a>
# **createManualResult**
> ManualResultResponse createManualResult(manualResultRequest)

Create Manual Result

Allows creation of a manual result

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
ManualResultRequest manualResultRequest = new ManualResultRequest(); // ManualResultRequest | 
try {
    ManualResultResponse result = apiInstance.createManualResult(manualResultRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#createManualResult");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **manualResultRequest** | [**ManualResultRequest**](ManualResultRequest.md)|  |

### Return type

[**ManualResultResponse**](ManualResultResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteDetectionMethod"></a>
# **deleteDetectionMethod**
> deleteDetectionMethod(detectionMethodId, replacement)

Delete Detection Method.

Delete a detection method. Use the replacement parameter to replace any references to the deleted method with a different method. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
Integer detectionMethodId = 56; // Integer | 
Integer replacement = 56; // Integer | The ID of the replacment detection method.
try {
    apiInstance.deleteDetectionMethod(detectionMethodId, replacement);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#deleteDetectionMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **detectionMethodId** | **Integer**|  |
 **replacement** | **Integer**| The ID of the replacment detection method. | [optional]

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteManualResult"></a>
# **deleteManualResult**
> deleteManualResult(resultId)

Delete Manual Result

Allows deletion of a manual result

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
Integer resultId = 56; // Integer | 
try {
    apiInstance.deleteManualResult(resultId);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#deleteManualResult");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resultId** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllDetectionMethods"></a>
# **getAllDetectionMethods**
> List&lt;DetectionMethod&gt; getAllDetectionMethods()

List Detection Methods

Returns a list of all detection methods. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
try {
    List<DetectionMethod> result = apiInstance.getAllDetectionMethods();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#getAllDetectionMethods");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;DetectionMethod&gt;**](DetectionMethod.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getManualResultAllowedTools"></a>
# **getManualResultAllowedTools**
> List&lt;String&gt; getManualResultAllowedTools()

Get Allowed Manaul Result Tools

Returns a set of allowed tool names for use when creating a manual result

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
try {
    List<String> result = apiInstance.getManualResultAllowedTools();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#getManualResultAllowedTools");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="modifyManualResultAllowedTool"></a>
# **modifyManualResultAllowedTool**
> modifyManualResultAllowedTool(tool, allowed)

Modify Allowed Manual Result Tool

Allows user to enable/disabled allowed tools

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
String tool = "tool_example"; // String | The name of the tool to modify
Boolean allowed = true; // Boolean | Boolean value representing tool state - enabled/disabled (true/false)
try {
    apiInstance.modifyManualResultAllowedTool(tool, allowed);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#modifyManualResultAllowedTool");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tool** | **String**| The name of the tool to modify | [optional]
 **allowed** | **Boolean**| Boolean value representing tool state - enabled/disabled (true/false) | [optional]

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="renameDetectionMethod"></a>
# **renameDetectionMethod**
> DetectionMethod renameDetectionMethod(detectionMethodId, detectionMethod)

Rename Detection Method

Rename an existing detection method with a new name specified in the request body. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
Integer detectionMethodId = 56; // Integer | 
DetectionMethod detectionMethod = new DetectionMethod(); // DetectionMethod | 
try {
    DetectionMethod result = apiInstance.renameDetectionMethod(detectionMethodId, detectionMethod);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#renameDetectionMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **detectionMethodId** | **Integer**|  |
 **detectionMethod** | [**DetectionMethod**](DetectionMethod.md)|  |

### Return type

[**DetectionMethod**](DetectionMethod.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="replaceManualResult"></a>
# **replaceManualResult**
> ManualResultResponse replaceManualResult(resultId, manualResultRequest)

Replace Manual Result

Allows a manual result to be replaced with another

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ResultsApi;

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

ResultsApi apiInstance = new ResultsApi();
Integer resultId = 56; // Integer | 
ManualResultRequest manualResultRequest = new ManualResultRequest(); // ManualResultRequest | 
try {
    ManualResultResponse result = apiInstance.replaceManualResult(resultId, manualResultRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResultsApi#replaceManualResult");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resultId** | **Integer**|  |
 **manualResultRequest** | [**ManualResultRequest**](ManualResultRequest.md)|  |

### Return type

[**ManualResultResponse**](ManualResultResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

