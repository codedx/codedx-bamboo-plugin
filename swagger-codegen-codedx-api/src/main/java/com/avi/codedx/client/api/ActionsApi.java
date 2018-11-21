package com.avi.codedx.client.api;

import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.Configuration;
import com.avi.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.avi.codedx.client.api.Job;
import com.avi.codedx.client.api.PostComment;
import com.avi.codedx.client.api.SetStatus;
import com.avi.codedx.client.api.SetStatusBulk;
import com.avi.codedx.client.api.SeverityOverride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-20T12:12:25.399-04:00")
public class ActionsApi {
  private ApiClient apiClient;

  public ActionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ActionsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Severity Override [Clear]
   * Allows severity overrides for findings to be cleared. 
   * @param findingId The finding ID. (required)
   * @throws ApiException if fails to make API call
   */
  public void clearSeverityOverride(Integer findingId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'findingId' is set
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling clearSeverityOverride");
    }
    
    // create path and map variables
    String localVarPath = "/api/findings/{finding-id}/severity-override"
      .replaceAll("\\{" + "finding-id" + "\\}", apiClient.escapeString(findingId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Severity Override [Set]
   * Allows severities for findings to be overridden. 
   * @param findingId The finding ID. (required)
   * @param severity  (optional)
   * @throws ApiException if fails to make API call
   */
  public void overrideSeverity(Integer findingId, SeverityOverride severity) throws ApiException {
    Object localVarPostBody = severity;
    
    // verify the required parameter 'findingId' is set
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling overrideSeverity");
    }
    
    // create path and map variables
    String localVarPath = "/api/findings/{finding-id}/severity-override"
      .replaceAll("\\{" + "finding-id" + "\\}", apiClient.escapeString(findingId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Post Comment
   * Post a new comment on a finding
   * @param findingId The finding ID. (required)
   * @param content &#x60;content&#x60; should be a string containing the raw markdown content of the new comment (required)
   * @throws ApiException if fails to make API call
   */
  public void postComment(Integer findingId, PostComment content) throws ApiException {
    Object localVarPostBody = content;
    
    // verify the required parameter 'findingId' is set
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling postComment");
    }
    
    // verify the required parameter 'content' is set
    if (content == null) {
      throw new ApiException(400, "Missing the required parameter 'content' when calling postComment");
    }
    
    // create path and map variables
    String localVarPath = "/api/findings/{finding-id}/comment"
      .replaceAll("\\{" + "finding-id" + "\\}", apiClient.escapeString(findingId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Bulk Status Update
   * Allows bulk updating of triage statuses of multiple findings, controlled by a filter. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint. 
   * @param projectId The ID of the project. (required)
   * @param bulkStatusUpdate  (optional)
   * @return Job
   * @throws ApiException if fails to make API call
   */
  public Job setBulkStatus(Integer projectId, SetStatusBulk bulkStatusUpdate) throws ApiException {
    Object localVarPostBody = bulkStatusUpdate;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setBulkStatus");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/bulk-status-update"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Job> localVarReturnType = new GenericType<Job>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Status Update
   * Allows changing of the triage status of a single finding. Detailed information regarding statuses can be obtained from the [Project Statuses](#/Projects/getStatuses) endpoint. 
   * @param findingId The finding ID. (required)
   * @param status &#x60;status&#x60; should be a valid status ID  (required)
   * @throws ApiException if fails to make API call
   */
  public void setStatus(Integer findingId, SetStatus status) throws ApiException {
    Object localVarPostBody = status;
    
    // verify the required parameter 'findingId' is set
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling setStatus");
    }
    
    // verify the required parameter 'status' is set
    if (status == null) {
      throw new ApiException(400, "Missing the required parameter 'status' when calling setStatus");
    }
    
    // create path and map variables
    String localVarPath = "/api/findings/{finding-id}/status"
      .replaceAll("\\{" + "finding-id" + "\\}", apiClient.escapeString(findingId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
