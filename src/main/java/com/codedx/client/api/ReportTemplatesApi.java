package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.BasicJobResponse;
import com.codedx.client.model.CreateReportTemplateRequest;
import com.codedx.client.model.ReportTemplate;
import com.codedx.client.model.ReportTemplateListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ReportTemplatesApi {
  private ApiClient apiClient;

  public ReportTemplatesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ReportTemplatesApi(ApiClient apiClient) {
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
   * Create Report Template
   * Create a new report template
   * @param createReportTemplateRequest  (required)
   * @param force If set to &#x60;true&#x60;, saved filters shared with the user may be used, but will be copied to a new private filter. Defaults to &#x60;false&#x60;. (optional)
   * @return ReportTemplate
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Report Template Created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Specified projects may not exist, the user does not have permissions to view one or more of the projects, or the saved filter does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission to create report templates </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ReportTemplate createReportTemplate(@jakarta.annotation.Nonnull CreateReportTemplateRequest createReportTemplateRequest, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    return createReportTemplateWithHttpInfo(createReportTemplateRequest, force).getData();
  }

  /**
   * Create Report Template
   * Create a new report template
   * @param createReportTemplateRequest  (required)
   * @param force If set to &#x60;true&#x60;, saved filters shared with the user may be used, but will be copied to a new private filter. Defaults to &#x60;false&#x60;. (optional)
   * @return ApiResponse&lt;ReportTemplate&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Report Template Created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Specified projects may not exist, the user does not have permissions to view one or more of the projects, or the saved filter does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission to create report templates </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ReportTemplate> createReportTemplateWithHttpInfo(@jakarta.annotation.Nonnull CreateReportTemplateRequest createReportTemplateRequest, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (createReportTemplateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'createReportTemplateRequest' when calling createReportTemplate");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ReportTemplate> localVarReturnType = new GenericType<ReportTemplate>() {};
    return apiClient.invokeAPI("ReportTemplatesApi.createReportTemplate", "/x/report/templates", "POST", localVarQueryParams, createReportTemplateRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Report Template
   * Delete a report template
   * @param reportTemplateId The report template ID. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Report template deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to delete the report template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteReportTemplate(@jakarta.annotation.Nonnull Integer reportTemplateId) throws ApiException {
    deleteReportTemplateWithHttpInfo(reportTemplateId);
  }

  /**
   * Delete Report Template
   * Delete a report template
   * @param reportTemplateId The report template ID. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Report template deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to delete the report template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteReportTemplateWithHttpInfo(@jakarta.annotation.Nonnull Integer reportTemplateId) throws ApiException {
    // Check required parameters
    if (reportTemplateId == null) {
      throw new ApiException(400, "Missing the required parameter 'reportTemplateId' when calling deleteReportTemplate");
    }

    // Path parameters
    String localVarPath = "/x/report/templates/{report-template-id}"
            .replaceAll("\\{report-template-id}", apiClient.escapeString(reportTemplateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ReportTemplatesApi.deleteReportTemplate", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Report Template
   * Get a report template
   * @param reportTemplateId The report template ID. (required)
   * @return ReportTemplate
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Got report template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ReportTemplate getReportTemplate(@jakarta.annotation.Nonnull Integer reportTemplateId) throws ApiException {
    return getReportTemplateWithHttpInfo(reportTemplateId).getData();
  }

  /**
   * Get Report Template
   * Get a report template
   * @param reportTemplateId The report template ID. (required)
   * @return ApiResponse&lt;ReportTemplate&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Got report template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ReportTemplate> getReportTemplateWithHttpInfo(@jakarta.annotation.Nonnull Integer reportTemplateId) throws ApiException {
    // Check required parameters
    if (reportTemplateId == null) {
      throw new ApiException(400, "Missing the required parameter 'reportTemplateId' when calling getReportTemplate");
    }

    // Path parameters
    String localVarPath = "/x/report/templates/{report-template-id}"
            .replaceAll("\\{report-template-id}", apiClient.escapeString(reportTemplateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ReportTemplate> localVarReturnType = new GenericType<ReportTemplate>() {};
    return apiClient.invokeAPI("ReportTemplatesApi.getReportTemplate", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Report Templates
   * Get a list of report templates the user is allowed to view
   * @return List&lt;ReportTemplateListItem&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Got Report Templates </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ReportTemplateListItem> listReportTemplate() throws ApiException {
    return listReportTemplateWithHttpInfo().getData();
  }

  /**
   * List Report Templates
   * Get a list of report templates the user is allowed to view
   * @return ApiResponse&lt;List&lt;ReportTemplateListItem&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Got Report Templates </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ReportTemplateListItem>> listReportTemplateWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ReportTemplateListItem>> localVarReturnType = new GenericType<List<ReportTemplateListItem>>() {};
    return apiClient.invokeAPI("ReportTemplatesApi.listReportTemplate", "/x/report/templates/list", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Send Report Now
   * Start a job to send a report using a template
   * @param reportTemplateId The report template ID. (required)
   * @return BasicJobResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Send report job was submitted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public BasicJobResponse sendReportNow(@jakarta.annotation.Nonnull Integer reportTemplateId) throws ApiException {
    return sendReportNowWithHttpInfo(reportTemplateId).getData();
  }

  /**
   * Send Report Now
   * Start a job to send a report using a template
   * @param reportTemplateId The report template ID. (required)
   * @return ApiResponse&lt;BasicJobResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Send report job was submitted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BasicJobResponse> sendReportNowWithHttpInfo(@jakarta.annotation.Nonnull Integer reportTemplateId) throws ApiException {
    // Check required parameters
    if (reportTemplateId == null) {
      throw new ApiException(400, "Missing the required parameter 'reportTemplateId' when calling sendReportNow");
    }

    // Path parameters
    String localVarPath = "/x/report/templates/{report-template-id}/send-now"
            .replaceAll("\\{report-template-id}", apiClient.escapeString(reportTemplateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<BasicJobResponse> localVarReturnType = new GenericType<BasicJobResponse>() {};
    return apiClient.invokeAPI("ReportTemplatesApi.sendReportNow", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update Report Template
   * Update a new report template
   * @param reportTemplateId The report template ID. (required)
   * @param createReportTemplateRequest  (required)
   * @param force If set to &#x60;true&#x60;, saved filters shared with the user may be used, but will be copied to a new private filter. Defaults to &#x60;false&#x60;. (optional)
   * @return ReportTemplate
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Report template updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request -  Specified projects may not exist, the user does not have permissions to view one or more of the projects, or the saved filter does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to edit the report template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ReportTemplate updateReportTemplate(@jakarta.annotation.Nonnull Integer reportTemplateId, @jakarta.annotation.Nonnull CreateReportTemplateRequest createReportTemplateRequest, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    return updateReportTemplateWithHttpInfo(reportTemplateId, createReportTemplateRequest, force).getData();
  }

  /**
   * Update Report Template
   * Update a new report template
   * @param reportTemplateId The report template ID. (required)
   * @param createReportTemplateRequest  (required)
   * @param force If set to &#x60;true&#x60;, saved filters shared with the user may be used, but will be copied to a new private filter. Defaults to &#x60;false&#x60;. (optional)
   * @return ApiResponse&lt;ReportTemplate&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Report template updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request -  Specified projects may not exist, the user does not have permissions to view one or more of the projects, or the saved filter does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User is not allowed to edit the report template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Report template not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ReportTemplate> updateReportTemplateWithHttpInfo(@jakarta.annotation.Nonnull Integer reportTemplateId, @jakarta.annotation.Nonnull CreateReportTemplateRequest createReportTemplateRequest, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (reportTemplateId == null) {
      throw new ApiException(400, "Missing the required parameter 'reportTemplateId' when calling updateReportTemplate");
    }
    if (createReportTemplateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'createReportTemplateRequest' when calling updateReportTemplate");
    }

    // Path parameters
    String localVarPath = "/x/report/templates/{report-template-id}"
            .replaceAll("\\{report-template-id}", apiClient.escapeString(reportTemplateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ReportTemplate> localVarReturnType = new GenericType<ReportTemplate>() {};
    return apiClient.invokeAPI("ReportTemplatesApi.updateReportTemplate", localVarPath, "PUT", localVarQueryParams, createReportTemplateRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
