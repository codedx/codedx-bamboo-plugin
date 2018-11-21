package com.avi.codedx.client.api;

import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.Configuration;
import com.avi.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.avi.codedx.client.api.GenerateReport;
import com.avi.codedx.client.api.Job;
import com.avi.codedx.client.api.ReportType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-20T12:12:25.399-04:00")
public class ReportingApi {
  private ApiClient apiClient;

  public ReportingApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ReportingApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Generate Report
   * Allows user to queue a job to generate a report. Each report type has a different set of configuration options that can be obtained from the &#x60;Report Types&#x60; endpoint. Each option&#39;s &#x60;id&#x60; and &#x60;type&#x60; correspond to a property-value pair in the &#x60;config&#x60; object in the &#x60;Generate Report&#x60; endpoint. The &#x60;id&#x60; of the option will be a property name and the type of the option affects the value. For example, a config option with an &#x60;id&#x60; of &#x60;includeSource&#x60; has a type of &#x60;checkbox&#x60;. The request&#39;s &#x60;config&#x60; object will contain an &#x60;includeSource&#x60; property with a value of true/false.  The following are the different config option types and their corresponding values:  - &#x60;dropdown&#x60;: The value will be one of the &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;checkbox&#x60;: The value will be true/false - &#x60;checkbox-list&#x60;: The value will be an array of &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;text&#x60;: The value will be a string  After successfully generating a report, a Job Id will be returned. Use the Job Id with the &#x60;Query Job Status&#x60; endpoint until it responds with &#x60;completed&#x60;. Once the Job is complete, use the &#x60;Get Job Result&#x60; endpoint to download the report.
   * @param projectId The ID of the project. (required)
   * @param reportType  (required)
   * @param body  (required)
   * @return Job
   * @throws ApiException if fails to make API call
   */
  public Job generateReport(Integer projectId, String reportType, GenerateReport body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling generateReport");
    }
    
    // verify the required parameter 'reportType' is set
    if (reportType == null) {
      throw new ApiException(400, "Missing the required parameter 'reportType' when calling generateReport");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling generateReport");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/report/{report-type}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()))
      .replaceAll("\\{" + "report-type" + "\\}", apiClient.escapeString(reportType.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Report Types
   * Provides a list of report types for a project. Each report type (pdf, csv, xml, nessus, and nbe) has a different set of configuration options. These configuration options are important with respect to generating a report. Please see the &#x60;Generate Report&#x60; endpoint for more information on how to use them.
   * @param projectId The ID of the project. (required)
   * @return Map&lt;String, ReportType&gt;
   * @throws ApiException if fails to make API call
   */
  public Map<String, ReportType> getReportTypes(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getReportTypes");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/report/types"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Map<String, ReportType>> localVarReturnType = new GenericType<Map<String, ReportType>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
