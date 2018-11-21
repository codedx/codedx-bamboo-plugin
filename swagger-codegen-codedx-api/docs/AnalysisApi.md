# AnalysisApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAnalysisPrep**](AnalysisApi.md#createAnalysisPrep) | **POST** /api/analysis-prep | Create Analysis Prep
[**deleteInput**](AnalysisApi.md#deleteInput) | **DELETE** /api/analysis-prep/{prep-id}/{input-id} | Delete Input
[**deletePendingInput**](AnalysisApi.md#deletePendingInput) | **DELETE** /api/analysis-prep/{prep-id}/pending | Delete Input (pending)
[**getAllAnalysisDetails**](AnalysisApi.md#getAllAnalysisDetails) | **GET** /api/projects/{project-id}/analyses | Get All Analysis Details
[**getAnalysisDetails**](AnalysisApi.md#getAnalysisDetails) | **GET** /api/projects/{project-id}/analyses/{analysis-id} | Get Analysis Details
[**getInputMetadata**](AnalysisApi.md#getInputMetadata) | **GET** /api/analysis-prep/{prep-id}/{input-id} | Get Input Metadata
[**queryAnalysisPrepState**](AnalysisApi.md#queryAnalysisPrepState) | **GET** /api/analysis-prep/{prep-id} | Query Analysis Prep State
[**runPreparedAnalysis**](AnalysisApi.md#runPreparedAnalysis) | **POST** /api/analysis-prep/{prep-id}/analyze | Run Prepared Analysis
[**setAnalysisName**](AnalysisApi.md#setAnalysisName) | **PUT** /api/projects/{project-id}/analyses/{analysis-id} | Name Analysis
[**setDisplayTag**](AnalysisApi.md#setDisplayTag) | **PUT** /api/analysis-prep/{prep-id}/{input-id}/tag/{tag-id} | Enable/Disable Display Tag
[**uploadFile**](AnalysisApi.md#uploadFile) | **POST** /api/analysis-prep/{prep-id}/upload | Upload File to Analysis Prep


<a name="createAnalysisPrep"></a>
# **createAnalysisPrep**
> AnalysisPrepResponse createAnalysisPrep(projectId)

Create Analysis Prep

Create a new Analysis Prep associated with a particular project. If Git is configured on that project, the new Analysis Prep will automatically initialize an input corresponding to that configuration. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
ProjectId projectId = new ProjectId(); // ProjectId | 
try {
    AnalysisPrepResponse result = apiInstance.createAnalysisPrep(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#createAnalysisPrep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | [**ProjectId**](ProjectId.md)|  |

### Return type

[**AnalysisPrepResponse**](AnalysisPrepResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteInput"></a>
# **deleteInput**
> deleteInput(prepId, inputId)

Delete Input

Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that includes an input-id parameter. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
String prepId = "prepId_example"; // String | The ID of the Analysis Prep. This should come from the Create Analysis Prep response.
String inputId = "inputId_example"; // String | The ID of the prep input.
try {
    apiInstance.deleteInput(prepId, inputId);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#deleteInput");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prepId** | **String**| The ID of the Analysis Prep. This should come from the Create Analysis Prep response. |
 **inputId** | **String**| The ID of the prep input. |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deletePendingInput"></a>
# **deletePendingInput**
> deletePendingInput(prepId, xClientRequestId)

Delete Input (pending)

Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that include an input-id parameter. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
String prepId = "prepId_example"; // String | The ID of the Analysis Prep. This should come from the Create Analysis Prep response.
String xClientRequestId = "xClientRequestId_example"; // String | If the input-id is not known, and the \"pending\" URL is being used, this header should be set to the value used by the requrest which initiated the input file upload.
try {
    apiInstance.deletePendingInput(prepId, xClientRequestId);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#deletePendingInput");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prepId** | **String**| The ID of the Analysis Prep. This should come from the Create Analysis Prep response. |
 **xClientRequestId** | **String**| If the input-id is not known, and the \&quot;pending\&quot; URL is being used, this header should be set to the value used by the requrest which initiated the input file upload. |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllAnalysisDetails"></a>
# **getAllAnalysisDetails**
> List&lt;AnalysisDetails&gt; getAllAnalysisDetails(projectId)

Get All Analysis Details

Obtain analysis details for a project, such as start and finish times

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    List<AnalysisDetails> result = apiInstance.getAllAnalysisDetails(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#getAllAnalysisDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

[**List&lt;AnalysisDetails&gt;**](AnalysisDetails.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAnalysisDetails"></a>
# **getAnalysisDetails**
> AnalysisDetails getAnalysisDetails(projectId, analysisId)

Get Analysis Details

Obtain analysis details, such as start and finish times

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
Integer projectId = 56; // Integer | The ID of the project.
Integer analysisId = 56; // Integer | The ID of the analysis
try {
    AnalysisDetails result = apiInstance.getAnalysisDetails(projectId, analysisId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#getAnalysisDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **analysisId** | **Integer**| The ID of the analysis |

### Return type

[**AnalysisDetails**](AnalysisDetails.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getInputMetadata"></a>
# **getInputMetadata**
> InputDisplayInfo getInputMetadata(prepId, inputId)

Get Input Metadata

Get metadata for a particular input associated with an Analysis Prep. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
String prepId = "prepId_example"; // String | The ID of the Analysis Prep. This should come from the Create Analysis Prep response.
String inputId = "inputId_example"; // String | The ID of the prep input.
try {
    InputDisplayInfo result = apiInstance.getInputMetadata(prepId, inputId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#getInputMetadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prepId** | **String**| The ID of the Analysis Prep. This should come from the Create Analysis Prep response. |
 **inputId** | **String**| The ID of the prep input. |

### Return type

[**InputDisplayInfo**](InputDisplayInfo.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="queryAnalysisPrepState"></a>
# **queryAnalysisPrepState**
> AnalysisQueryResponse queryAnalysisPrepState(prepId)

Query Analysis Prep State

Get a list of Input IDs and Verification Errors for an Analysis Prep. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
String prepId = "prepId_example"; // String | The ID of the Analysis Prep. This should come from the Create Analysis Prep response.
try {
    AnalysisQueryResponse result = apiInstance.queryAnalysisPrepState(prepId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#queryAnalysisPrepState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prepId** | **String**| The ID of the Analysis Prep. This should come from the Create Analysis Prep response. |

### Return type

[**AnalysisQueryResponse**](AnalysisQueryResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="runPreparedAnalysis"></a>
# **runPreparedAnalysis**
> Analysis runPreparedAnalysis(prepId)

Run Prepared Analysis

Once all of the verificationErrors in an Analysis Prep are addressed, an analysis can be started. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
String prepId = "prepId_example"; // String | The ID of the Analysis Prep. This should come from the Create Analysis Prep response.
try {
    Analysis result = apiInstance.runPreparedAnalysis(prepId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#runPreparedAnalysis");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prepId** | **String**| The ID of the Analysis Prep. This should come from the Create Analysis Prep response. |

### Return type

[**Analysis**](Analysis.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="setAnalysisName"></a>
# **setAnalysisName**
> setAnalysisName(projectId, analysisId, analysisName)

Name Analysis

Set a name for a specific analysis

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
Integer projectId = 56; // Integer | The ID of the project.
Integer analysisId = 56; // Integer | The ID of the analysis
AnalysisName analysisName = new AnalysisName(); // AnalysisName | An object containing the name of the analysis
try {
    apiInstance.setAnalysisName(projectId, analysisId, analysisName);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#setAnalysisName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **analysisId** | **Integer**| The ID of the analysis |
 **analysisName** | [**AnalysisName**](AnalysisName.md)| An object containing the name of the analysis | [optional]

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="setDisplayTag"></a>
# **setDisplayTag**
> InputDisplayInfo setDisplayTag(prepId, inputId, tagId, enabled)

Enable/Disable Display Tag

Enable and disable individual display tags on individual prop inputs. Disabled tags will cause a file to be treated as if that tag were not there, for analysis purposes. For example, if the &#x60;{ \&quot;source\&quot;&amp;#58; \&quot;Java\&quot; } tag was disabled for a file when the analysis was started, that file would be treated as if there were no Java sources at all. This could mean that certain tools would not be run on that file. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
String prepId = "prepId_example"; // String | The ID of the Analysis Prep. This should come from the Create Analysis Prep response.
String inputId = "inputId_example"; // String | The ID of the prep input.
String tagId = "tagId_example"; // String | The ID of a Display Tag State object which would have been returned by the Get Input Metadata endpoint
Enabled enabled = new Enabled(); // Enabled | A boolean indicating whether the tag should be enabled or disabled
try {
    InputDisplayInfo result = apiInstance.setDisplayTag(prepId, inputId, tagId, enabled);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#setDisplayTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prepId** | **String**| The ID of the Analysis Prep. This should come from the Create Analysis Prep response. |
 **inputId** | **String**| The ID of the prep input. |
 **tagId** | **String**| The ID of a Display Tag State object which would have been returned by the Get Input Metadata endpoint |
 **enabled** | [**Enabled**](Enabled.md)| A boolean indicating whether the tag should be enabled or disabled | [optional]

### Return type

[**InputDisplayInfo**](InputDisplayInfo.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="uploadFile"></a>
# **uploadFile**
> FileUploadResponse uploadFile(prepId, file, xClientRequestId)

Upload File to Analysis Prep

Analysis Preps should be populated by uploading files to Code Dx (or by configuring Git on a project, causing the source to be automatically added to the prep). 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.AnalysisApi;

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

AnalysisApi apiInstance = new AnalysisApi();
String prepId = "prepId_example"; // String | The ID of the Analysis Prep. This should come from the Create Analysis Prep response.
File file = new File("/path/to/file.txt"); // File | The file to be uploaded
String xClientRequestId = "xClientRequestId_example"; // String | Clients may choose an arbitrary identifier (a random string will suffice) to associate with the upload. This is done to enable deletion of an input before its file upload is fully complete. For more info, see Delete Input.
try {
    FileUploadResponse result = apiInstance.uploadFile(prepId, file, xClientRequestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnalysisApi#uploadFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prepId** | **String**| The ID of the Analysis Prep. This should come from the Create Analysis Prep response. |
 **file** | **File**| The file to be uploaded |
 **xClientRequestId** | **String**| Clients may choose an arbitrary identifier (a random string will suffice) to associate with the upload. This is done to enable deletion of an input before its file upload is fully complete. For more info, see Delete Input. | [optional]

### Return type

[**FileUploadResponse**](FileUploadResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

