package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.AssociationSummary;
import com.codedx.client.model.BasicJobResponse;
import com.codedx.client.model.DeleteIssuesForFilterRequest;
import com.codedx.client.model.Error;
import com.codedx.client.model.ExistingIssuesForFilterRequest;
import com.codedx.client.model.ExistingIssuesForFindingsRequest;
import com.codedx.client.model.IssueTrackerConfigurationGet;
import com.codedx.client.model.IssueTrackerConfigurationPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class IssueTrackerApi {
  private ApiClient apiClient;

  public IssueTrackerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public IssueTrackerApi(ApiClient apiClient) {
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
   * Associate Filtered Findings
   * Allows user to associate findings that match the filter with an issue.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param existingIssuesForFilterRequest  (required)
   * @return AssociationSummary
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the association summary </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AssociationSummary associateIssueForFilter(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull ExistingIssuesForFilterRequest existingIssuesForFilterRequest) throws ApiException {
    return associateIssueForFilterWithHttpInfo(projectVersionContext, trackerType, existingIssuesForFilterRequest).getData();
  }

  /**
   * Associate Filtered Findings
   * Allows user to associate findings that match the filter with an issue.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param existingIssuesForFilterRequest  (required)
   * @return ApiResponse&lt;AssociationSummary&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the association summary </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AssociationSummary> associateIssueForFilterWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull ExistingIssuesForFilterRequest existingIssuesForFilterRequest) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling associateIssueForFilter");
    }
    if (trackerType == null) {
      throw new ApiException(400, "Missing the required parameter 'trackerType' when calling associateIssueForFilter");
    }
    if (existingIssuesForFilterRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'existingIssuesForFilterRequest' when calling associateIssueForFilter");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{tracker-type}/{project-version-context}/existingIssueForFilter"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{tracker-type}", apiClient.escapeString(trackerType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AssociationSummary> localVarReturnType = new GenericType<AssociationSummary>() {};
    return apiClient.invokeAPI("IssueTrackerApi.associateIssueForFilter", localVarPath, "POST", new ArrayList<>(), existingIssuesForFilterRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Associate Findings
   * Allows user to associate a list of findings with an issue.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param existingIssuesForFindingsRequest  (required)
   * @return AssociationSummary
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the association summary </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AssociationSummary associateIssueForFindings(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull ExistingIssuesForFindingsRequest existingIssuesForFindingsRequest) throws ApiException {
    return associateIssueForFindingsWithHttpInfo(projectVersionContext, trackerType, existingIssuesForFindingsRequest).getData();
  }

  /**
   * Associate Findings
   * Allows user to associate a list of findings with an issue.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param existingIssuesForFindingsRequest  (required)
   * @return ApiResponse&lt;AssociationSummary&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the association summary </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AssociationSummary> associateIssueForFindingsWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull ExistingIssuesForFindingsRequest existingIssuesForFindingsRequest) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling associateIssueForFindings");
    }
    if (trackerType == null) {
      throw new ApiException(400, "Missing the required parameter 'trackerType' when calling associateIssueForFindings");
    }
    if (existingIssuesForFindingsRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'existingIssuesForFindingsRequest' when calling associateIssueForFindings");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{tracker-type}/{project-version-context}/existingIssueForFindings"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{tracker-type}", apiClient.escapeString(trackerType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AssociationSummary> localVarReturnType = new GenericType<AssociationSummary>() {};
    return apiClient.invokeAPI("IssueTrackerApi.associateIssueForFindings", localVarPath, "POST", new ArrayList<>(), existingIssuesForFindingsRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Configure Issue Tracker
   * Allows user to configure an Issue Tracker for a Project. Note: We strongly recommend users configure Jira integration using the UI due to how complicated the configuration can get. This endpoint should only be used to configure custom issue trackers. Please follow the example provided. Users should only change the &#x60;url&#x60; field when configuring a custom issue tracker.  Requires the \&quot;project:manage-issue-tracker-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param issueTrackerConfigurationPost  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Issue Tracker integration successfully configured </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void createIssueTrackerConfiguration(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull IssueTrackerConfigurationPost issueTrackerConfigurationPost) throws ApiException {
    createIssueTrackerConfigurationWithHttpInfo(projectId, trackerType, issueTrackerConfigurationPost);
  }

  /**
   * Configure Issue Tracker
   * Allows user to configure an Issue Tracker for a Project. Note: We strongly recommend users configure Jira integration using the UI due to how complicated the configuration can get. This endpoint should only be used to configure custom issue trackers. Please follow the example provided. Users should only change the &#x60;url&#x60; field when configuring a custom issue tracker.  Requires the \&quot;project:manage-issue-tracker-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param issueTrackerConfigurationPost  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Issue Tracker integration successfully configured </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createIssueTrackerConfigurationWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull IssueTrackerConfigurationPost issueTrackerConfigurationPost) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling createIssueTrackerConfiguration");
    }
    if (trackerType == null) {
      throw new ApiException(400, "Missing the required parameter 'trackerType' when calling createIssueTrackerConfiguration");
    }
    if (issueTrackerConfigurationPost == null) {
      throw new ApiException(400, "Missing the required parameter 'issueTrackerConfigurationPost' when calling createIssueTrackerConfiguration");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{tracker-type}/{project-id}/config"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{tracker-type}", apiClient.escapeString(trackerType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*", "application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("IssueTrackerApi.createIssueTrackerConfiguration", localVarPath, "POST", new ArrayList<>(), issueTrackerConfigurationPost,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Issue Associations
   * Allows user to delete issue associations for findings that match a filter.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param deleteIssuesForFilterRequest  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Association deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteAssociationForFilter(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull DeleteIssuesForFilterRequest deleteIssuesForFilterRequest) throws ApiException {
    deleteAssociationForFilterWithHttpInfo(projectId, deleteIssuesForFilterRequest);
  }

  /**
   * Delete Issue Associations
   * Allows user to delete issue associations for findings that match a filter.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param deleteIssuesForFilterRequest  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Association deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteAssociationForFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull DeleteIssuesForFilterRequest deleteIssuesForFilterRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteAssociationForFilter");
    }
    if (deleteIssuesForFilterRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'deleteIssuesForFilterRequest' when calling deleteAssociationForFilter");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{project-id}/deleteIssueForFilter"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("IssueTrackerApi.deleteAssociationForFilter", localVarPath, "POST", new ArrayList<>(), deleteIssuesForFilterRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Issue Association
   * Allows user to delete an issue association for a finding.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Association deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteAssociationForFinding(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    deleteAssociationForFindingWithHttpInfo(projectId, findingId);
  }

  /**
   * Delete Issue Association
   * Allows user to delete an issue association for a finding.  Requires the \&quot;project:update-issue-tracker-associations\&quot; permission which is provided by the \&quot;Updater\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Association deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteAssociationForFindingWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteAssociationForFinding");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling deleteAssociationForFinding");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{project-id}/issueForFinding/{finding-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("IssueTrackerApi.deleteAssociationForFinding", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Issue Tracker Configuration
   * Allows user to delete a project&#39;s issue tracker configuration.  Requires the \&quot;project:manage-issue-tracker-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Issue Tracker configuration successfully deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteIssueTrackerConfiguration(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    deleteIssueTrackerConfigurationWithHttpInfo(projectId);
  }

  /**
   * Delete Issue Tracker Configuration
   * Allows user to delete a project&#39;s issue tracker configuration.  Requires the \&quot;project:manage-issue-tracker-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Issue Tracker configuration successfully deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteIssueTrackerConfigurationWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteIssueTrackerConfiguration");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{project-id}/config"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("IssueTrackerApi.deleteIssueTrackerConfiguration", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Issue Tracker Config
   * Returns the issue tracker configuration information for the project specified by {project-id}. The {tracker-type} parameter does not affect the output of this endpoint, it&#39;s an artifact of the API. Any of the existing tracker types can be used.  Requires the \&quot;project:manage-issue-tracker-config\&quot; permission which is part of the \&quot;Manager\&quot; role.
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param projectId The ID of the project. (required)
   * @return IssueTrackerConfigurationGet
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an object containing the Issue Tracker Configuration for the project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public IssueTrackerConfigurationGet getIssueTrackerConfiguration(@jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getIssueTrackerConfigurationWithHttpInfo(trackerType, projectId).getData();
  }

  /**
   * Get Issue Tracker Config
   * Returns the issue tracker configuration information for the project specified by {project-id}. The {tracker-type} parameter does not affect the output of this endpoint, it&#39;s an artifact of the API. Any of the existing tracker types can be used.  Requires the \&quot;project:manage-issue-tracker-config\&quot; permission which is part of the \&quot;Manager\&quot; role.
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;IssueTrackerConfigurationGet&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an object containing the Issue Tracker Configuration for the project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - the requester does not have sufficient permission to access this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<IssueTrackerConfigurationGet> getIssueTrackerConfigurationWithHttpInfo(@jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (trackerType == null) {
      throw new ApiException(400, "Missing the required parameter 'trackerType' when calling getIssueTrackerConfiguration");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getIssueTrackerConfiguration");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{tracker-type}/{project-id}/config"
            .replaceAll("\\{tracker-type}", apiClient.escapeString(trackerType.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<IssueTrackerConfigurationGet> localVarReturnType = new GenericType<IssueTrackerConfigurationGet>() {};
    return apiClient.invokeAPI("IssueTrackerApi.getIssueTrackerConfiguration", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Refresh Issue Statuses
   * Allows user to refresh issue status for a finding.  Requires the \&quot;project:read-issue-tracker-config\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return BasicJobResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a jobId for the refresh status job </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public BasicJobResponse refreshStatusForFinding(@jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    return refreshStatusForFindingWithHttpInfo(trackerType, projectId, findingId).getData();
  }

  /**
   * Refresh Issue Statuses
   * Allows user to refresh issue status for a finding.  Requires the \&quot;project:read-issue-tracker-config\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return ApiResponse&lt;BasicJobResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a jobId for the refresh status job </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BasicJobResponse> refreshStatusForFindingWithHttpInfo(@jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    // Check required parameters
    if (trackerType == null) {
      throw new ApiException(400, "Missing the required parameter 'trackerType' when calling refreshStatusForFinding");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling refreshStatusForFinding");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling refreshStatusForFinding");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{tracker-type}/{project-id}/refreshStatusForFinding/{finding-id}"
            .replaceAll("\\{tracker-type}", apiClient.escapeString(trackerType.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<BasicJobResponse> localVarReturnType = new GenericType<BasicJobResponse>() {};
    return apiClient.invokeAPI("IssueTrackerApi.refreshStatusForFinding", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Refresh Project&#39;s Issues
   * Allows user to refresh issues for a project.  Requires the \&quot;project:read-issue-tracker-config\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param projectId The ID of the project. (required)
   * @return BasicJobResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a jobId for the refresh status job </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public BasicJobResponse sync(@jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return syncWithHttpInfo(trackerType, projectId).getData();
  }

  /**
   * Refresh Project&#39;s Issues
   * Allows user to refresh issues for a project.  Requires the \&quot;project:read-issue-tracker-config\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param trackerType The Issue Tracker type - either \&quot;jira\&quot;, \&quot;azure\&quot;, \&quot;gitlab\&quot;, or \&quot;servicenow\&quot; (required)
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;BasicJobResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a jobId for the refresh status job </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BasicJobResponse> syncWithHttpInfo(@jakarta.annotation.Nonnull String trackerType, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (trackerType == null) {
      throw new ApiException(400, "Missing the required parameter 'trackerType' when calling sync");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling sync");
    }

    // Path parameters
    String localVarPath = "/x/issueTracker/{tracker-type}/{project-id}/sync"
            .replaceAll("\\{tracker-type}", apiClient.escapeString(trackerType.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<BasicJobResponse> localVarReturnType = new GenericType<BasicJobResponse>() {};
    return apiClient.invokeAPI("IssueTrackerApi.sync", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
