# ReportingApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**generateReport**](ReportingApi.md#generateReport) | **POST** /api/projects/{project-id}/report/{report-type} | Generate Report
[**getReportTypes**](ReportingApi.md#getReportTypes) | **GET** /api/projects/{project-id}/report/types | Report Types


<a name="generateReport"></a>
# **generateReport**
> Job generateReport(projectId, reportType, body)

Generate Report

Allows user to queue a job to generate a report. Each report type has a different set of configuration options that can be obtained from the &#x60;Report Types&#x60; endpoint. Each option&#39;s &#x60;id&#x60; and &#x60;type&#x60; correspond to a property-value pair in the &#x60;config&#x60; object in the &#x60;Generate Report&#x60; endpoint. The &#x60;id&#x60; of the option will be a property name and the type of the option affects the value. For example, a config option with an &#x60;id&#x60; of &#x60;includeSource&#x60; has a type of &#x60;checkbox&#x60;. The request&#39;s &#x60;config&#x60; object will contain an &#x60;includeSource&#x60; property with a value of true/false.  The following are the different config option types and their corresponding values:  - &#x60;dropdown&#x60;: The value will be one of the &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;checkbox&#x60;: The value will be true/false - &#x60;checkbox-list&#x60;: The value will be an array of &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;text&#x60;: The value will be a string  After successfully generating a report, a Job Id will be returned. Use the Job Id with the &#x60;Query Job Status&#x60; endpoint until it responds with &#x60;completed&#x60;. Once the Job is complete, use the &#x60;Get Job Result&#x60; endpoint to download the report.

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ReportingApi;

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

ReportingApi apiInstance = new ReportingApi();
Integer projectId = 56; // Integer | The ID of the project.
String reportType = "reportType_example"; // String | 
GenerateReport body = new GenerateReport(); // GenerateReport | 
try {
    Job result = apiInstance.generateReport(projectId, reportType, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingApi#generateReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **reportType** | **String**|  | [enum: csv, pdf, xml, nessus, nbe]
 **body** | [**GenerateReport**](GenerateReport.md)|  |

### Return type

[**Job**](Job.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getReportTypes"></a>
# **getReportTypes**
> Map&lt;String, ReportType&gt; getReportTypes(projectId)

Report Types

Provides a list of report types for a project. Each report type (pdf, csv, xml, nessus, and nbe) has a different set of configuration options. These configuration options are important with respect to generating a report. Please see the &#x60;Generate Report&#x60; endpoint for more information on how to use them.

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ReportingApi;

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

ReportingApi apiInstance = new ReportingApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    Map<String, ReportType> result = apiInstance.getReportTypes(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingApi#getReportTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

[**Map&lt;String, ReportType&gt;**](ReportType.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

