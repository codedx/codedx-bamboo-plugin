package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import java.io.File;
import com.codedx.client.model.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class JobsApi {
  private ApiClient apiClient;

  public JobsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public JobsApi(ApiClient apiClient) {
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
   * Get Job Result
   * Fetches the result from a job.  The permissions required for this endpoint are dependent on the type of job being run. For example, a report job requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param jobId The ID of the job to check (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Job result is returned - the response headers and body will match the job result </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - User/key does not have permission to view the job result </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Job doesn&#39;t exist, does not have result, has not finished yet, or has expired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public File getJobResult(@jakarta.annotation.Nonnull String jobId) throws ApiException {
    return getJobResultWithHttpInfo(jobId).getData();
  }

  /**
   * Get Job Result
   * Fetches the result from a job.  The permissions required for this endpoint are dependent on the type of job being run. For example, a report job requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param jobId The ID of the job to check (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Job result is returned - the response headers and body will match the job result </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - User/key does not have permission to view the job result </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Job doesn&#39;t exist, does not have result, has not finished yet, or has expired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getJobResultWithHttpInfo(@jakarta.annotation.Nonnull String jobId) throws ApiException {
    // Check required parameters
    if (jobId == null) {
      throw new ApiException(400, "Missing the required parameter 'jobId' when calling getJobResult");
    }

    // Path parameters
    String localVarPath = "/api/jobs/{job-id}/result"
            .replaceAll("\\{job-id}", apiClient.escapeString(jobId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/pdf", "text/csv");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("JobsApi.getJobResult", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Query Job Status
   * Queries the status of a running job.  Requires the \&quot;job:view\&quot; permission, users have this permission by default.
   * @param jobId The ID of the job to check (required)
   * @return Job
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the job status </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have job view permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Job does not exist or has expired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Job getJobStatus(@jakarta.annotation.Nonnull String jobId) throws ApiException {
    return getJobStatusWithHttpInfo(jobId).getData();
  }

  /**
   * Query Job Status
   * Queries the status of a running job.  Requires the \&quot;job:view\&quot; permission, users have this permission by default.
   * @param jobId The ID of the job to check (required)
   * @return ApiResponse&lt;Job&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the job status </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have job view permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Job does not exist or has expired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Job> getJobStatusWithHttpInfo(@jakarta.annotation.Nonnull String jobId) throws ApiException {
    // Check required parameters
    if (jobId == null) {
      throw new ApiException(400, "Missing the required parameter 'jobId' when calling getJobStatus");
    }

    // Path parameters
    String localVarPath = "/api/jobs/{job-id}"
            .replaceAll("\\{job-id}", apiClient.escapeString(jobId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI("JobsApi.getJobStatus", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
