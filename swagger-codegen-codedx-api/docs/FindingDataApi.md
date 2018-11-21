# FindingDataApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getFindingData**](FindingDataApi.md#getFindingData) | **GET** /api/findings/{finding-id} | Finding Data
[**getFindingDescription**](FindingDataApi.md#getFindingDescription) | **GET** /api/findings/{finding-id}/description | Finding Descriptions
[**getFindingFlow**](FindingDataApi.md#getFindingFlow) | **POST** /api/projects/{project-id}/findings/flow | Finding Flow Data
[**getFindingHistory**](FindingDataApi.md#getFindingHistory) | **GET** /api/findings/{finding-id}/history | Finding History
[**getFindingsCount**](FindingDataApi.md#getFindingsCount) | **POST** /api/projects/{project-id}/findings/count | Finding Count
[**getFindingsGroupCount**](FindingDataApi.md#getFindingsGroupCount) | **POST** /api/projects/{project-id}/findings/grouped-counts | Findings Grouped Count
[**getFindingsTable**](FindingDataApi.md#getFindingsTable) | **POST** /api/projects/{project-id}/findings/table | Finding Table Data
[**getSourceFileContents**](FindingDataApi.md#getSourceFileContents) | **GET** /api/projects/{project-id}/files/{path-id} | Source File Contents
[**getSourceFileContentsFromPath**](FindingDataApi.md#getSourceFileContentsFromPath) | **GET** /api/projects/{project-id}/files/tree/{path} | Source File Contents (tree)


<a name="getFindingData"></a>
# **getFindingData**
> Finding getFindingData(findingId, expand)

Finding Data

Returns metadata for the given finding 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer findingId = 56; // Integer | The finding ID.
List<String> expand = Arrays.asList("expand_example"); // List<String> | The expand parameter is a comma seperated list. Each value included in the list has the potential to modify the response's Finding objects. The available values and their effects are&#58; - `descriptions` - an additional property named `descriptions` is added to the Finding objects. It is a Description object that contains the tool/rule description for the finding - `descriptor` - adds additional content to the `descriptor` property of the Finding object. - `issue` - an additional property named `issue` is added to the Finding objects. `issue` will be an Issue object. - `triage-time` - an additional property named `triageTime` is added to the Finding objects. It is a date time that corresponds to the most recent time the status of the finding was updated. - `results` - an additional property named `results` is added to the Finding objects. It is an array of ToolResult objects that relate to the finding. - `results.descriptions` - does the same thing as `results` as well as adds an additional property named `descriptions` to the ToolResult objects. This property is a Description object and will contain the tool and contextual descriptions for the result. - `results.descriptor` - does the same thing as `results` as well as adds additional properties to the ToolResults' `descriptor` properties. - `results.metadata` - does the same thing as `results` as well as adds an additional property to the ToolResult object named `metadata`. `metadata` is an object that contains key values pairs, usually some additional information reported by a tool. - `results.variants` - does the same thing as `results` as well as adds an additional property to the the ToolResult object named `variants`. `variants` is an array of Variant objects. A Variant typically contains http/https request and response information. 
try {
    Finding result = apiInstance.getFindingData(findingId, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getFindingData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **findingId** | **Integer**| The finding ID. |
 **expand** | [**List&lt;String&gt;**](String.md)| The expand parameter is a comma seperated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are&amp;#58; - &#x60;descriptions&#x60; - an additional property named &#x60;descriptions&#x60; is added to the Finding objects. It is a Description object that contains the tool/rule description for the finding - &#x60;descriptor&#x60; - adds additional content to the &#x60;descriptor&#x60; property of the Finding object. - &#x60;issue&#x60; - an additional property named &#x60;issue&#x60; is added to the Finding objects. &#x60;issue&#x60; will be an Issue object. - &#x60;triage-time&#x60; - an additional property named &#x60;triageTime&#x60; is added to the Finding objects. It is a date time that corresponds to the most recent time the status of the finding was updated. - &#x60;results&#x60; - an additional property named &#x60;results&#x60; is added to the Finding objects. It is an array of ToolResult objects that relate to the finding. - &#x60;results.descriptions&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property named &#x60;descriptions&#x60; to the ToolResult objects. This property is a Description object and will contain the tool and contextual descriptions for the result. - &#x60;results.descriptor&#x60; - does the same thing as &#x60;results&#x60; as well as adds additional properties to the ToolResults&#39; &#x60;descriptor&#x60; properties. - &#x60;results.metadata&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the ToolResult object named &#x60;metadata&#x60;. &#x60;metadata&#x60; is an object that contains key values pairs, usually some additional information reported by a tool. - &#x60;results.variants&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the the ToolResult object named &#x60;variants&#x60;. &#x60;variants&#x60; is an array of Variant objects. A Variant typically contains http/https request and response information.  | [optional] [enum: descriptions, descriptor, issue, triage-time, results, results.descriptions, results.descriptor, results.metadata, results.variants]

### Return type

[**Finding**](Finding.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFindingDescription"></a>
# **getFindingDescription**
> FindingDescription getFindingDescription(findingId)

Finding Descriptions

Returns the descriptions for the given finding from all available sources. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer findingId = 56; // Integer | The finding ID.
try {
    FindingDescription result = apiInstance.getFindingDescription(findingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getFindingDescription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **findingId** | **Integer**| The finding ID. |

### Return type

[**FindingDescription**](FindingDescription.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFindingFlow"></a>
# **getFindingFlow**
> List&lt;FlowData&gt; getFindingFlow(projectId, flowRequest)

Finding Flow Data

Returns filtered finding flow data. This endpoint is a candidate to be absorbed by a more generic querying API; presently it just returns the data required for the finding flow as it exists today. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer projectId = 56; // Integer | The ID of the project.
FlowRequest flowRequest = new FlowRequest(); // FlowRequest | 
try {
    List<FlowData> result = apiInstance.getFindingFlow(projectId, flowRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getFindingFlow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **flowRequest** | [**FlowRequest**](FlowRequest.md)|  | [optional]

### Return type

[**List&lt;FlowData&gt;**](FlowData.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFindingHistory"></a>
# **getFindingHistory**
> List&lt;ActivityEvent&gt; getFindingHistory(findingId)

Finding History

Responds with an array of \&quot;activity event\&quot; objects in JSON. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer findingId = 56; // Integer | The finding ID.
try {
    List<ActivityEvent> result = apiInstance.getFindingHistory(findingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getFindingHistory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **findingId** | **Integer**| The finding ID. |

### Return type

[**List&lt;ActivityEvent&gt;**](ActivityEvent.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFindingsCount"></a>
# **getFindingsCount**
> Count getFindingsCount(projectId, query)

Finding Count

Returns the count of all findings in the project matching the given filter. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer projectId = 56; // Integer | The ID of the project.
Query query = new Query(); // Query | 
try {
    Count result = apiInstance.getFindingsCount(projectId, query);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getFindingsCount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **query** | [**Query**](Query.md)|  | [optional]

### Return type

[**Count**](Count.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFindingsGroupCount"></a>
# **getFindingsGroupCount**
> List&lt;GroupedCount&gt; getFindingsGroupCount(projectId, groupedCountRequest)

Findings Grouped Count

Returns filtered finding counts, grouped by the specified field. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer projectId = 56; // Integer | The ID of the project.
GroupedCountsRequest groupedCountRequest = new GroupedCountsRequest(); // GroupedCountsRequest | 
try {
    List<GroupedCount> result = apiInstance.getFindingsGroupCount(projectId, groupedCountRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getFindingsGroupCount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **groupedCountRequest** | [**GroupedCountsRequest**](GroupedCountsRequest.md)|  | [optional]

### Return type

[**List&lt;GroupedCount&gt;**](GroupedCount.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFindingsTable"></a>
# **getFindingsTable**
> List&lt;Finding&gt; getFindingsTable(projectId, query, expand)

Finding Table Data

Returns filtered finding table data. This endpoint is a candidate to become a more generic querying API; presently it just returns the data required for the findings table as it exists today. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer projectId = 56; // Integer | The ID of the project.
Query query = new Query(); // Query | 
List<String> expand = Arrays.asList("expand_example"); // List<String> | The expand parameter is a comma seperated list. Each value included in the list has the potential to modify the response's Finding objects. The available values and their effects are&#58; - `descriptions` - an additional property named `descriptions` is added to the Finding objects. It is a Description object that contains the tool/rule description for the finding - `descriptor` - adds additional content to the `descriptor` property of the Finding object. - `issue` - an additional property named `issue` is added to the Finding objects. `issue` will be an Issue object. - `triage-time` - an additional property named `triageTime` is added to the Finding objects. It is a date time that corresponds to the most recent time the status of the finding was updated. - `results` - an additional property named `results` is added to the Finding objects. It is an array of ToolResult objects that relate to the finding. - `results.descriptions` - does the same thing as `results` as well as adds an additional property named `descriptions` to the ToolResult objects. This property is a Description object and will contain the tool and contextual descriptions for the result. - `results.descriptor` - does the same thing as `results` as well as adds additional properties to the ToolResults' `descriptor` properties. - `results.metadata` - does the same thing as `results` as well as adds an additional property to the ToolResult object named `metadata`. `metadata` is an object that contains key values pairs, usually some additional information reported by a tool. - `results.variants` - does the same thing as `results` as well as adds an additional property to the the ToolResult object named `variants`. `variants` is an array of Variant objects. A Variant typically contains http/https request and response information. 
try {
    List<Finding> result = apiInstance.getFindingsTable(projectId, query, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getFindingsTable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **query** | [**Query**](Query.md)|  | [optional]
 **expand** | [**List&lt;String&gt;**](String.md)| The expand parameter is a comma seperated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are&amp;#58; - &#x60;descriptions&#x60; - an additional property named &#x60;descriptions&#x60; is added to the Finding objects. It is a Description object that contains the tool/rule description for the finding - &#x60;descriptor&#x60; - adds additional content to the &#x60;descriptor&#x60; property of the Finding object. - &#x60;issue&#x60; - an additional property named &#x60;issue&#x60; is added to the Finding objects. &#x60;issue&#x60; will be an Issue object. - &#x60;triage-time&#x60; - an additional property named &#x60;triageTime&#x60; is added to the Finding objects. It is a date time that corresponds to the most recent time the status of the finding was updated. - &#x60;results&#x60; - an additional property named &#x60;results&#x60; is added to the Finding objects. It is an array of ToolResult objects that relate to the finding. - &#x60;results.descriptions&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property named &#x60;descriptions&#x60; to the ToolResult objects. This property is a Description object and will contain the tool and contextual descriptions for the result. - &#x60;results.descriptor&#x60; - does the same thing as &#x60;results&#x60; as well as adds additional properties to the ToolResults&#39; &#x60;descriptor&#x60; properties. - &#x60;results.metadata&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the ToolResult object named &#x60;metadata&#x60;. &#x60;metadata&#x60; is an object that contains key values pairs, usually some additional information reported by a tool. - &#x60;results.variants&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the the ToolResult object named &#x60;variants&#x60;. &#x60;variants&#x60; is an array of Variant objects. A Variant typically contains http/https request and response information.  | [optional] [enum: descriptions, descriptor, issue, triage-time, results, results.descriptions, results.descriptor, results.metadata, results.variants]

### Return type

[**List&lt;Finding&gt;**](Finding.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSourceFileContents"></a>
# **getSourceFileContents**
> String getSourceFileContents(projectId, pathId)

Source File Contents

Returns the contents of a given file, as long as it is a text file. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer projectId = 56; // Integer | The ID of the project.
Integer pathId = 56; // Integer | The ID of the path
try {
    String result = apiInstance.getSourceFileContents(projectId, pathId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getSourceFileContents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **pathId** | **Integer**| The ID of the path |

### Return type

**String**

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="getSourceFileContentsFromPath"></a>
# **getSourceFileContentsFromPath**
> String getSourceFileContentsFromPath(projectId, path)

Source File Contents (tree)

Returns the contents of a given file, as long as it is a text file. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.FindingDataApi;

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

FindingDataApi apiInstance = new FindingDataApi();
Integer projectId = 56; // Integer | The ID of the project.
String path = "path_example"; // String | The literal path to the file (e.g., \"com/foo/bar/Baz.java\")
try {
    String result = apiInstance.getSourceFileContentsFromPath(projectId, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FindingDataApi#getSourceFileContentsFromPath");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **path** | **String**| The literal path to the file (e.g., \&quot;com/foo/bar/Baz.java\&quot;) |

### Return type

**String**

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

