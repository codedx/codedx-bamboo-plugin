package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.GenerateReport;
import com.codedx.client.model.GenerateReportLegacy;
import com.codedx.client.model.Job;
import com.codedx.client.model.ReportType;
import com.codedx.client.model.ValidateReportForm;
import com.codedx.client.model.ValidateReportForm200Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ReportingApi {
  private ApiClient apiClient;

  public ReportingApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ReportingApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API client
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API client
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Generate Report
   * Allows user to queue a job to generate a report. Each report type has a different set of configuration options that can be obtained from the &#x60;Report Types&#x60; endpoint. Each option&#39;s &#x60;id&#x60; and &#x60;type&#x60; correspond to a property-value pair in the &#x60;config&#x60; object in the &#x60;Generate Report&#x60; endpoint. The &#x60;id&#x60; of the option will be a property name and the type of the option affects the value. For example, a config option with an &#x60;id&#x60; of &#x60;includeSource&#x60; has a type of &#x60;checkbox&#x60;. The request&#39;s &#x60;config&#x60; object will contain an &#x60;includeSource&#x60; property with a value of true/false.  The following are the different config option types and their corresponding values:  - &#x60;dropdown&#x60;: The value will be one of the &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;checkbox&#x60;: The value will be true/false - &#x60;checkbox-list&#x60;: The value will be an array of &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;text&#x60;: The value will be a string  After successfully generating a report, a Job Id will be returned. Use the Job Id with the &#x60;Query Job Status&#x60; endpoint until it responds with &#x60;completed&#x60;. Once the Job is complete, use the &#x60;Get Job Result&#x60; endpoint to download the report.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param reportType  (required)
   * @param generateReport  (required)
   * @return Job
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The reporting task has been queued </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or report type not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Job generateReport(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull String reportType, @jakarta.annotation.Nonnull GenerateReport generateReport) throws ApiException {
    return generateReportWithHttpInfo(projectQueryContext, reportType, generateReport).getData();
  }

  /**
   * Generate Report
   * Allows user to queue a job to generate a report. Each report type has a different set of configuration options that can be obtained from the &#x60;Report Types&#x60; endpoint. Each option&#39;s &#x60;id&#x60; and &#x60;type&#x60; correspond to a property-value pair in the &#x60;config&#x60; object in the &#x60;Generate Report&#x60; endpoint. The &#x60;id&#x60; of the option will be a property name and the type of the option affects the value. For example, a config option with an &#x60;id&#x60; of &#x60;includeSource&#x60; has a type of &#x60;checkbox&#x60;. The request&#39;s &#x60;config&#x60; object will contain an &#x60;includeSource&#x60; property with a value of true/false.  The following are the different config option types and their corresponding values:  - &#x60;dropdown&#x60;: The value will be one of the &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;checkbox&#x60;: The value will be true/false - &#x60;checkbox-list&#x60;: The value will be an array of &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;text&#x60;: The value will be a string  After successfully generating a report, a Job Id will be returned. Use the Job Id with the &#x60;Query Job Status&#x60; endpoint until it responds with &#x60;completed&#x60;. Once the Job is complete, use the &#x60;Get Job Result&#x60; endpoint to download the report.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param reportType  (required)
   * @param generateReport  (required)
   * @return ApiResponse&lt;Job&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The reporting task has been queued </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or report type not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Job> generateReportWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull String reportType, @jakarta.annotation.Nonnull GenerateReport generateReport) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling generateReport");
    }
    if (reportType == null) {
      throw new ApiException(400, "Missing the required parameter 'reportType' when calling generateReport");
    }
    if (generateReport == null) {
      throw new ApiException(400, "Missing the required parameter 'generateReport' when calling generateReport");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-query-context}/report/{report-type}"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()))
            .replaceAll("\\{report-type}", apiClient.escapeString(reportType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI("ReportingApi.generateReport", localVarPath, "POST", new ArrayList<>(), generateReport,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate Report Legacy
   * Allows user to queue a job to generate a report. Each report type has a different set of configuration options that can be obtained from the &#x60;Report Types Legacy&#x60; endpoint. Each option&#39;s &#x60;id&#x60; and &#x60;type&#x60; correspond to a property-value pair in the &#x60;config&#x60; object in the &#x60;Generate Report&#x60; endpoint. The &#x60;id&#x60; of the option will be a property name and the type of the option affects the value. For example, a config option with an &#x60;id&#x60; of &#x60;includeSource&#x60; has a type of &#x60;checkbox&#x60;. The request&#39;s &#x60;config&#x60; object will contain an &#x60;includeSource&#x60; property with a value of true/false.  The following are the different config option types and their corresponding values:  - &#x60;dropdown&#x60;: The value will be one of the &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;checkbox&#x60;: The value will be true/false - &#x60;checkbox-list&#x60;: The value will be an array of &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;text&#x60;: The value will be a string  After successfully generating a report, a Job Id will be returned. Use the Job Id with the &#x60;Query Job Status&#x60; endpoint until it responds with &#x60;completed&#x60;. Once the Job is complete, use the &#x60;Get Job Result&#x60; endpoint to download the report.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param reportType  (required)
   * @param generateReportLegacy  (required)
   * @return Job
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The reporting task has been queued </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or report type not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Job generateReportLegacy(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull String reportType, @jakarta.annotation.Nonnull GenerateReportLegacy generateReportLegacy) throws ApiException {
    return generateReportLegacyWithHttpInfo(projectQueryContext, reportType, generateReportLegacy).getData();
  }

  /**
   * Generate Report Legacy
   * Allows user to queue a job to generate a report. Each report type has a different set of configuration options that can be obtained from the &#x60;Report Types Legacy&#x60; endpoint. Each option&#39;s &#x60;id&#x60; and &#x60;type&#x60; correspond to a property-value pair in the &#x60;config&#x60; object in the &#x60;Generate Report&#x60; endpoint. The &#x60;id&#x60; of the option will be a property name and the type of the option affects the value. For example, a config option with an &#x60;id&#x60; of &#x60;includeSource&#x60; has a type of &#x60;checkbox&#x60;. The request&#39;s &#x60;config&#x60; object will contain an &#x60;includeSource&#x60; property with a value of true/false.  The following are the different config option types and their corresponding values:  - &#x60;dropdown&#x60;: The value will be one of the &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;checkbox&#x60;: The value will be true/false - &#x60;checkbox-list&#x60;: The value will be an array of &#x60;id&#x60;s listed under &#x60;options&#x60; - &#x60;text&#x60;: The value will be a string  After successfully generating a report, a Job Id will be returned. Use the Job Id with the &#x60;Query Job Status&#x60; endpoint until it responds with &#x60;completed&#x60;. Once the Job is complete, use the &#x60;Get Job Result&#x60; endpoint to download the report.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param reportType  (required)
   * @param generateReportLegacy  (required)
   * @return ApiResponse&lt;Job&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The reporting task has been queued </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or report type not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Job> generateReportLegacyWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull String reportType, @jakarta.annotation.Nonnull GenerateReportLegacy generateReportLegacy) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling generateReportLegacy");
    }
    if (reportType == null) {
      throw new ApiException(400, "Missing the required parameter 'reportType' when calling generateReportLegacy");
    }
    if (generateReportLegacy == null) {
      throw new ApiException(400, "Missing the required parameter 'generateReportLegacy' when calling generateReportLegacy");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-query-context}/report/{report-type}"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()))
            .replaceAll("\\{report-type}", apiClient.escapeString(reportType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI("ReportingApi.generateReportLegacy", localVarPath, "POST", new ArrayList<>(), generateReportLegacy,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Report Types
   * Provides a list of report types for one or more projects. Each report type (pdf, csv, xml, nessus, and nbe) has a different set of configuration options. These configuration options are important with respect to generating a report. Please see the &#x60;Generate Report&#x60; endpoint for more information on how to use them.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return Map&lt;String, ReportType&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of report types </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, ReportType> getReportTypes(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    return getReportTypesWithHttpInfo(projectQueryContext).getData();
  }

  /**
   * Report Types
   * Provides a list of report types for one or more projects. Each report type (pdf, csv, xml, nessus, and nbe) has a different set of configuration options. These configuration options are important with respect to generating a report. Please see the &#x60;Generate Report&#x60; endpoint for more information on how to use them.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;Map&lt;String, ReportType&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of report types </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, ReportType>> getReportTypesWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling getReportTypes");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-query-context}/report/types"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Map<String, ReportType>> localVarReturnType = new GenericType<Map<String, ReportType>>() {};
    return apiClient.invokeAPI("ReportingApi.getReportTypes", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Report Types Legacy
   * Provides a list of report types for one or more projects. Each report type (pdf, csv, xml, nessus, and nbe) has a different set of configuration options. These configuration options are important with respect to generating a report. Please see the &#x60;Generate Report Legacy&#x60; endpoint for more information on how to use them.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return Map&lt;String, ReportType&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of report types </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, ReportType> getReportTypesLegacy(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    return getReportTypesLegacyWithHttpInfo(projectQueryContext).getData();
  }

  /**
   * Report Types Legacy
   * Provides a list of report types for one or more projects. Each report type (pdf, csv, xml, nessus, and nbe) has a different set of configuration options. These configuration options are important with respect to generating a report. Please see the &#x60;Generate Report Legacy&#x60; endpoint for more information on how to use them.  Requires the \&quot;report:generate\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;Map&lt;String, ReportType&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of report types </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, ReportType>> getReportTypesLegacyWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling getReportTypesLegacy");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-query-context}/report/types"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Map<String, ReportType>> localVarReturnType = new GenericType<Map<String, ReportType>>() {};
    return apiClient.invokeAPI("ReportingApi.getReportTypesLegacy", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Validate Report Form
   * Validates the report form
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param reportType  (required)
   * @param validateReportForm  (required)
   * @return ValidateReportForm200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The reporting task has been queued </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or report type not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ValidateReportForm200Response validateReportForm(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull String reportType, @jakarta.annotation.Nonnull ValidateReportForm validateReportForm) throws ApiException {
    return validateReportFormWithHttpInfo(projectQueryContext, reportType, validateReportForm).getData();
  }

  /**
   * Validate Report Form
   * Validates the report form
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param reportType  (required)
   * @param validateReportForm  (required)
   * @return ApiResponse&lt;ValidateReportForm200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The reporting task has been queued </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have generate-report permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or report type not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ValidateReportForm200Response> validateReportFormWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nonnull String reportType, @jakarta.annotation.Nonnull ValidateReportForm validateReportForm) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling validateReportForm");
    }
    if (reportType == null) {
      throw new ApiException(400, "Missing the required parameter 'reportType' when calling validateReportForm");
    }
    if (validateReportForm == null) {
      throw new ApiException(400, "Missing the required parameter 'validateReportForm' when calling validateReportForm");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-query-context}/report/{report-type}/validate"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()))
            .replaceAll("\\{report-type}", apiClient.escapeString(reportType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ValidateReportForm200Response> localVarReturnType = new GenericType<ValidateReportForm200Response>() {};
    return apiClient.invokeAPI("ReportingApi.validateReportForm", localVarPath, "POST", new ArrayList<>(), validateReportForm,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
