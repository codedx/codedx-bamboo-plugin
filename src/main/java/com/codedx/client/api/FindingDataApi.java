package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.ActivityEvent;
import com.codedx.client.model.Count;
import com.codedx.client.model.Finding;
import com.codedx.client.model.FindingDescription;
import com.codedx.client.model.GroupedCount;
import com.codedx.client.model.GroupedCountsRequest;
import com.codedx.client.model.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class FindingDataApi {
  private ApiClient apiClient;

  public FindingDataApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FindingDataApi(ApiClient apiClient) {
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
   * Finding Count
   * Returns the count of all findings in the project(s) matching the given filter.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param query  (optional)
   * @return Count
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested count </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission of the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Count filterFindingsCount(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable Query query) throws ApiException {
    return filterFindingsCountWithHttpInfo(projectQueryContext, query).getData();
  }

  /**
   * Finding Count
   * Returns the count of all findings in the project(s) matching the given filter.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param query  (optional)
   * @return ApiResponse&lt;Count&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested count </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission of the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Count> filterFindingsCountWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable Query query) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling filterFindingsCount");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-query-context}/findings/count"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Count> localVarReturnType = new GenericType<Count>() {};
    return apiClient.invokeAPI("FindingDataApi.filterFindingsCount", localVarPath, "POST", new ArrayList<>(), query,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Finding Data
   * Returns metadata for the given finding.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param findingId The finding ID. (required)
   * @param expand The expand parameter is a comma-separated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are as follows: - &#x60;comment-count&#x60; - Adds the &#x60;commentCount&#x60; field to the Finding objects. Its value is a number indicating how many Comments the Finding has. - &#x60;descriptions&#x60; - Adds the &#x60;descriptions&#x60; field to the Finding objects. Its value is an object which contains the general and contextual descriptions for the finding. - &#x60;descriptor&#x60; - Adds the &#x60;hierarchy&#x60; field to each Finding&#39;s &#x60;descriptor&#x60; object. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code. - &#x60;issue&#x60; - Adds the &#x60;issue&#x60; field to the Finding objects. Its value is an Issue object. - &#x60;host&#x60; Adds the &#x60;host&#x60; field to the Finding objects. Its value is an object representing the common information about the Host (i.e. a machine on a network) for which the Finding was discovered. - &#x60;last-comment-action&#x60; Adds the &#x60;lastCommentAction&#x60; field to the Finding objects. Its value is a DateTime String indicating when the latest comment was made on the Finding (or &#x60;null&#x60; if the Finding has no comments). - &#x60;metadata&#x60; - Adds the &#x60;metadata&#x60; field to the Finding objects. Its value is an object that contains key value pairs. - &#x60;results&#x60; - Adds the &#x60;results&#x60; field to the Finding objects. Its value is an array of Result objects, each relating to the Finding. Each of these result objects may be expanded further by including any of the &#x60;results.&lt;sub-key&gt;&#x60; keys mentioned below.   - &#x60;results.active&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;active&#x60; field to each Result object. Its value is a Boolean indicating whether the Result is active. (Results become inactive when their originating Analysis Input is archived; inactive Results may be kept for historical purposes.)  - &#x60;results.component-details&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;component&#x60; field to each Result object. Its values contains detailed information about the component.   - &#x60;results.container-image&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;containerImage&#x60; field to each Result object. Its value is an object representing the Container Image from which a Container-scanning tool discovered the Result.   - &#x60;results.cves&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;cves&#x60; field to each Result object. Its value is an Array of CVE strings.   - &#x60;results.data-flows&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;dataFlows&#x60; field to the Result objects. Its value is an Array of data-flow paths that the SAST tool followed to identify the underlying issue.   - &#x60;results.descriptions&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;descriptions&#x60; field to the Result objects. Its value is an object which contains the general and contextual descriptions for the result.   - &#x60;results.descriptor&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hierarchy&#x60; field to each Result&#39;s &#x60;descriptor&#x60; objects. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code.   - &#x60;results.host&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hostValues&#x60; field to the Result objects. Its value is an object representing the Host on which the Result was discovered (i.e. a machine on a network).   - &#x60;results.metadata&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;metadata&#x60; field to the Result objects. &#x60;metadata&#x60; is an object that contains key value pairs, i.e. additional information reported by a tool which didn&#39;t fit into Software Risk Manager&#39;s Result data model.   - &#x60;results.resolved-locations&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally causes each Result&#39;s &#x60;location&#x60; object to contain additional information.   - &#x60;results.variants&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects. &#x60;variants&#x60; is an array of Variant objects. A Variant contains http/https request and response information.     - &#x60;results.variants.with-body&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects as described above, but with additional properties in each Variant object to represent the request and response body&#39;s HTTP Data. - &#x60;source-snippet&#x60; Adds the &#x60;sourceSnippet&#x60; field to the Finding objects. Its value is an object containing a snippet of the source code at the location of the Finding. - &#x60;standards&#x60; Adds the &#x60;standards&#x60; field to the Finding objects. Its value is an Array of Standard objects, indicating which Standards (e.g. OWASP Top 10) the Finding violates. - &#x60;tags&#x60; Adds the &#x60;tags&#x60; field to the Finding objects. Its value is an Array of Tag objects. - &#x60;triage-time&#x60; - Adds the &#x60;triageTime&#x60; field to the Finding objects. Its value is a DateTime String indicating the most recent time the status of the finding was updated. (optional)
   * @return Finding
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the finding data as JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Finding getFindingData(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nullable List<String> expand) throws ApiException {
    return getFindingDataWithHttpInfo(projectVersionContext, findingId, expand).getData();
  }

  /**
   * Finding Data
   * Returns metadata for the given finding.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param findingId The finding ID. (required)
   * @param expand The expand parameter is a comma-separated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are as follows: - &#x60;comment-count&#x60; - Adds the &#x60;commentCount&#x60; field to the Finding objects. Its value is a number indicating how many Comments the Finding has. - &#x60;descriptions&#x60; - Adds the &#x60;descriptions&#x60; field to the Finding objects. Its value is an object which contains the general and contextual descriptions for the finding. - &#x60;descriptor&#x60; - Adds the &#x60;hierarchy&#x60; field to each Finding&#39;s &#x60;descriptor&#x60; object. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code. - &#x60;issue&#x60; - Adds the &#x60;issue&#x60; field to the Finding objects. Its value is an Issue object. - &#x60;host&#x60; Adds the &#x60;host&#x60; field to the Finding objects. Its value is an object representing the common information about the Host (i.e. a machine on a network) for which the Finding was discovered. - &#x60;last-comment-action&#x60; Adds the &#x60;lastCommentAction&#x60; field to the Finding objects. Its value is a DateTime String indicating when the latest comment was made on the Finding (or &#x60;null&#x60; if the Finding has no comments). - &#x60;metadata&#x60; - Adds the &#x60;metadata&#x60; field to the Finding objects. Its value is an object that contains key value pairs. - &#x60;results&#x60; - Adds the &#x60;results&#x60; field to the Finding objects. Its value is an array of Result objects, each relating to the Finding. Each of these result objects may be expanded further by including any of the &#x60;results.&lt;sub-key&gt;&#x60; keys mentioned below.   - &#x60;results.active&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;active&#x60; field to each Result object. Its value is a Boolean indicating whether the Result is active. (Results become inactive when their originating Analysis Input is archived; inactive Results may be kept for historical purposes.)  - &#x60;results.component-details&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;component&#x60; field to each Result object. Its values contains detailed information about the component.   - &#x60;results.container-image&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;containerImage&#x60; field to each Result object. Its value is an object representing the Container Image from which a Container-scanning tool discovered the Result.   - &#x60;results.cves&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;cves&#x60; field to each Result object. Its value is an Array of CVE strings.   - &#x60;results.data-flows&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;dataFlows&#x60; field to the Result objects. Its value is an Array of data-flow paths that the SAST tool followed to identify the underlying issue.   - &#x60;results.descriptions&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;descriptions&#x60; field to the Result objects. Its value is an object which contains the general and contextual descriptions for the result.   - &#x60;results.descriptor&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hierarchy&#x60; field to each Result&#39;s &#x60;descriptor&#x60; objects. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code.   - &#x60;results.host&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hostValues&#x60; field to the Result objects. Its value is an object representing the Host on which the Result was discovered (i.e. a machine on a network).   - &#x60;results.metadata&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;metadata&#x60; field to the Result objects. &#x60;metadata&#x60; is an object that contains key value pairs, i.e. additional information reported by a tool which didn&#39;t fit into Software Risk Manager&#39;s Result data model.   - &#x60;results.resolved-locations&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally causes each Result&#39;s &#x60;location&#x60; object to contain additional information.   - &#x60;results.variants&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects. &#x60;variants&#x60; is an array of Variant objects. A Variant contains http/https request and response information.     - &#x60;results.variants.with-body&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects as described above, but with additional properties in each Variant object to represent the request and response body&#39;s HTTP Data. - &#x60;source-snippet&#x60; Adds the &#x60;sourceSnippet&#x60; field to the Finding objects. Its value is an object containing a snippet of the source code at the location of the Finding. - &#x60;standards&#x60; Adds the &#x60;standards&#x60; field to the Finding objects. Its value is an Array of Standard objects, indicating which Standards (e.g. OWASP Top 10) the Finding violates. - &#x60;tags&#x60; Adds the &#x60;tags&#x60; field to the Finding objects. Its value is an Array of Tag objects. - &#x60;triage-time&#x60; - Adds the &#x60;triageTime&#x60; field to the Finding objects. Its value is a DateTime String indicating the most recent time the status of the finding was updated. (optional)
   * @return ApiResponse&lt;Finding&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the finding data as JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Finding> getFindingDataWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nullable List<String> expand) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getFindingData");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling getFindingData");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/{finding-id}"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("csv", "expand", expand)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Finding> localVarReturnType = new GenericType<Finding>() {};
    return apiClient.invokeAPI("FindingDataApi.getFindingData", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Finding Descriptions
   * Returns the descriptions for the given finding from all available sources.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return FindingDescription
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the description(s) for the finding </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have read permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public FindingDescription getFindingDescription(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    return getFindingDescriptionWithHttpInfo(findingId, projectVersionContext).getData();
  }

  /**
   * Finding Descriptions
   * Returns the descriptions for the given finding from all available sources.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;FindingDescription&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the description(s) for the finding </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have read permission for the finding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such finding </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<FindingDescription> getFindingDescriptionWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling getFindingDescription");
    }
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getFindingDescription");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/{finding-id}/description"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<FindingDescription> localVarReturnType = new GenericType<FindingDescription>() {};
    return apiClient.invokeAPI("FindingDataApi.getFindingDescription", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Finding History
   * Responds with an array of \&quot;activity event\&quot; objects in JSON.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return List&lt;ActivityEvent&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an array of \&quot;activity event\&quot; objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ActivityEvent> getFindingHistory(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    return getFindingHistoryWithHttpInfo(findingId, projectVersionContext).getData();
  }

  /**
   * Finding History
   * Responds with an array of \&quot;activity event\&quot; objects in JSON.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param findingId The finding ID. (required)
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;List&lt;ActivityEvent&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an array of \&quot;activity event\&quot; objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The finding does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ActivityEvent>> getFindingHistoryWithHttpInfo(@jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    // Check required parameters
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling getFindingHistory");
    }
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getFindingHistory");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/findings/{finding-id}/history"
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()))
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ActivityEvent>> localVarReturnType = new GenericType<List<ActivityEvent>>() {};
    return apiClient.invokeAPI("FindingDataApi.getFindingHistory", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Finding Count
   * Returns the count of all findings in the project(s).  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return Count
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested count </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission of the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Count getFindingsCount(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    return getFindingsCountWithHttpInfo(projectQueryContext).getData();
  }

  /**
   * Finding Count
   * Returns the count of all findings in the project(s).  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;Count&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested count </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission of the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Count> getFindingsCountWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling getFindingsCount");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-query-context}/findings/count"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Count> localVarReturnType = new GenericType<Count>() {};
    return apiClient.invokeAPI("FindingDataApi.getFindingsCount", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Findings Grouped Count
   * Returns filtered finding counts, grouped by the specified field.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param groupedCountsRequest  (optional)
   * @return List&lt;GroupedCount&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested grouped counts </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<GroupedCount> getFindingsGroupCount(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable GroupedCountsRequest groupedCountsRequest) throws ApiException {
    return getFindingsGroupCountWithHttpInfo(projectQueryContext, groupedCountsRequest).getData();
  }

  /**
   * Findings Grouped Count
   * Returns filtered finding counts, grouped by the specified field.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param groupedCountsRequest  (optional)
   * @return ApiResponse&lt;List&lt;GroupedCount&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested grouped counts </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<GroupedCount>> getFindingsGroupCountWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable GroupedCountsRequest groupedCountsRequest) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling getFindingsGroupCount");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-query-context}/findings/grouped-counts"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<GroupedCount>> localVarReturnType = new GenericType<List<GroupedCount>>() {};
    return apiClient.invokeAPI("FindingDataApi.getFindingsGroupCount", localVarPath, "POST", new ArrayList<>(), groupedCountsRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Finding Table Data
   * Returns filtered finding table data. This endpoint is a candidate to become a more generic querying API; presently it just returns the data required for the findings table as it exists today.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param expand The expand parameter is a comma-separated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are as follows: - &#x60;comment-count&#x60; - Adds the &#x60;commentCount&#x60; field to the Finding objects. Its value is a number indicating how many Comments the Finding has. - &#x60;descriptions&#x60; - Adds the &#x60;descriptions&#x60; field to the Finding objects. Its value is an object which contains the general and contextual descriptions for the finding. - &#x60;descriptor&#x60; - Adds the &#x60;hierarchy&#x60; field to each Finding&#39;s &#x60;descriptor&#x60; object. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code. - &#x60;issue&#x60; - Adds the &#x60;issue&#x60; field to the Finding objects. Its value is an Issue object. - &#x60;host&#x60; Adds the &#x60;host&#x60; field to the Finding objects. Its value is an object representing the common information about the Host (i.e. a machine on a network) for which the Finding was discovered. - &#x60;last-comment-action&#x60; Adds the &#x60;lastCommentAction&#x60; field to the Finding objects. Its value is a DateTime String indicating when the latest comment was made on the Finding (or &#x60;null&#x60; if the Finding has no comments). - &#x60;metadata&#x60; - Adds the &#x60;metadata&#x60; field to the Finding objects. Its value is an object that contains key value pairs. - &#x60;results&#x60; - Adds the &#x60;results&#x60; field to the Finding objects. Its value is an array of Result objects, each relating to the Finding. Each of these result objects may be expanded further by including any of the &#x60;results.&lt;sub-key&gt;&#x60; keys mentioned below.   - &#x60;results.active&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;active&#x60; field to each Result object. Its value is a Boolean indicating whether the Result is active. (Results become inactive when their originating Analysis Input is archived; inactive Results may be kept for historical purposes.)  - &#x60;results.component-details&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;component&#x60; field to each Result object. Its values contains detailed information about the component.   - &#x60;results.container-image&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;containerImage&#x60; field to each Result object. Its value is an object representing the Container Image from which a Container-scanning tool discovered the Result.   - &#x60;results.cves&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;cves&#x60; field to each Result object. Its value is an Array of CVE strings.   - &#x60;results.data-flows&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;dataFlows&#x60; field to the Result objects. Its value is an Array of data-flow paths that the SAST tool followed to identify the underlying issue.   - &#x60;results.descriptions&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;descriptions&#x60; field to the Result objects. Its value is an object which contains the general and contextual descriptions for the result.   - &#x60;results.descriptor&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hierarchy&#x60; field to each Result&#39;s &#x60;descriptor&#x60; objects. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code.   - &#x60;results.host&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hostValues&#x60; field to the Result objects. Its value is an object representing the Host on which the Result was discovered (i.e. a machine on a network).   - &#x60;results.metadata&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;metadata&#x60; field to the Result objects. &#x60;metadata&#x60; is an object that contains key value pairs, i.e. additional information reported by a tool which didn&#39;t fit into Software Risk Manager&#39;s Result data model.   - &#x60;results.resolved-locations&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally causes each Result&#39;s &#x60;location&#x60; object to contain additional information.   - &#x60;results.variants&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects. &#x60;variants&#x60; is an array of Variant objects. A Variant contains http/https request and response information.     - &#x60;results.variants.with-body&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects as described above, but with additional properties in each Variant object to represent the request and response body&#39;s HTTP Data. - &#x60;source-snippet&#x60; Adds the &#x60;sourceSnippet&#x60; field to the Finding objects. Its value is an object containing a snippet of the source code at the location of the Finding. - &#x60;standards&#x60; Adds the &#x60;standards&#x60; field to the Finding objects. Its value is an Array of Standard objects, indicating which Standards (e.g. OWASP Top 10) the Finding violates. - &#x60;tags&#x60; Adds the &#x60;tags&#x60; field to the Finding objects. Its value is an Array of Tag objects. - &#x60;triage-time&#x60; - Adds the &#x60;triageTime&#x60; field to the Finding objects. Its value is a DateTime String indicating the most recent time the status of the finding was updated. (optional)
   * @param query  (optional)
   * @return List&lt;Finding&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK -  Contains the filtered table data </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Finding> getFindingsTable(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable List<String> expand, @jakarta.annotation.Nullable Query query) throws ApiException {
    return getFindingsTableWithHttpInfo(projectQueryContext, expand, query).getData();
  }

  /**
   * Finding Table Data
   * Returns filtered finding table data. This endpoint is a candidate to become a more generic querying API; presently it just returns the data required for the findings table as it exists today.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectQueryContext A &#x60;ProjectContext&#x60; capable of specifying multiple projects.  Multiple projects can be specified by: - Separating project ids with an underscore (&#x60;1_2_3&#x60;)  - Prefixing a project id with a &#39;d&#39; to include its descendants (&#x60;d12&#x60;)  - Using the value &#x60;all&#x60; to include all projects  When specifying multiple projects, the branch is not configurable and a project&#39;s default branch will be used. A single project can be specified with its project id and optionally include a branch id or branch name. If only the project id is included, then the project&#39;s default branch will be used. (required)
   * @param expand The expand parameter is a comma-separated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are as follows: - &#x60;comment-count&#x60; - Adds the &#x60;commentCount&#x60; field to the Finding objects. Its value is a number indicating how many Comments the Finding has. - &#x60;descriptions&#x60; - Adds the &#x60;descriptions&#x60; field to the Finding objects. Its value is an object which contains the general and contextual descriptions for the finding. - &#x60;descriptor&#x60; - Adds the &#x60;hierarchy&#x60; field to each Finding&#39;s &#x60;descriptor&#x60; object. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code. - &#x60;issue&#x60; - Adds the &#x60;issue&#x60; field to the Finding objects. Its value is an Issue object. - &#x60;host&#x60; Adds the &#x60;host&#x60; field to the Finding objects. Its value is an object representing the common information about the Host (i.e. a machine on a network) for which the Finding was discovered. - &#x60;last-comment-action&#x60; Adds the &#x60;lastCommentAction&#x60; field to the Finding objects. Its value is a DateTime String indicating when the latest comment was made on the Finding (or &#x60;null&#x60; if the Finding has no comments). - &#x60;metadata&#x60; - Adds the &#x60;metadata&#x60; field to the Finding objects. Its value is an object that contains key value pairs. - &#x60;results&#x60; - Adds the &#x60;results&#x60; field to the Finding objects. Its value is an array of Result objects, each relating to the Finding. Each of these result objects may be expanded further by including any of the &#x60;results.&lt;sub-key&gt;&#x60; keys mentioned below.   - &#x60;results.active&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;active&#x60; field to each Result object. Its value is a Boolean indicating whether the Result is active. (Results become inactive when their originating Analysis Input is archived; inactive Results may be kept for historical purposes.)  - &#x60;results.component-details&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;component&#x60; field to each Result object. Its values contains detailed information about the component.   - &#x60;results.container-image&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;containerImage&#x60; field to each Result object. Its value is an object representing the Container Image from which a Container-scanning tool discovered the Result.   - &#x60;results.cves&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;cves&#x60; field to each Result object. Its value is an Array of CVE strings.   - &#x60;results.data-flows&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;dataFlows&#x60; field to the Result objects. Its value is an Array of data-flow paths that the SAST tool followed to identify the underlying issue.   - &#x60;results.descriptions&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;descriptions&#x60; field to the Result objects. Its value is an object which contains the general and contextual descriptions for the result.   - &#x60;results.descriptor&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hierarchy&#x60; field to each Result&#39;s &#x60;descriptor&#x60; objects. The &#x60;hierarchy&#x60; is an Array (of Strings) representing the descriptor hierarchy, with grouping(s) first, followed by the descriptor code.   - &#x60;results.host&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;hostValues&#x60; field to the Result objects. Its value is an object representing the Host on which the Result was discovered (i.e. a machine on a network).   - &#x60;results.metadata&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;metadata&#x60; field to the Result objects. &#x60;metadata&#x60; is an object that contains key value pairs, i.e. additional information reported by a tool which didn&#39;t fit into Software Risk Manager&#39;s Result data model.   - &#x60;results.resolved-locations&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally causes each Result&#39;s &#x60;location&#x60; object to contain additional information.   - &#x60;results.variants&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects. &#x60;variants&#x60; is an array of Variant objects. A Variant contains http/https request and response information.     - &#x60;results.variants.with-body&#x60; - Adds the &#x60;results&#x60; field to each Finding. Its value is an array of Result objects. Additionally adds the &#x60;variants&#x60; field to the Result objects as described above, but with additional properties in each Variant object to represent the request and response body&#39;s HTTP Data. - &#x60;source-snippet&#x60; Adds the &#x60;sourceSnippet&#x60; field to the Finding objects. Its value is an object containing a snippet of the source code at the location of the Finding. - &#x60;standards&#x60; Adds the &#x60;standards&#x60; field to the Finding objects. Its value is an Array of Standard objects, indicating which Standards (e.g. OWASP Top 10) the Finding violates. - &#x60;tags&#x60; Adds the &#x60;tags&#x60; field to the Finding objects. Its value is an Array of Tag objects. - &#x60;triage-time&#x60; - Adds the &#x60;triageTime&#x60; field to the Finding objects. Its value is a DateTime String indicating the most recent time the status of the finding was updated. (optional)
   * @param query  (optional)
   * @return ApiResponse&lt;List&lt;Finding&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK -  Contains the filtered table data </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body is missing or invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Finding>> getFindingsTableWithHttpInfo(@jakarta.annotation.Nonnull String projectQueryContext, @jakarta.annotation.Nullable List<String> expand, @jakarta.annotation.Nullable Query query) throws ApiException {
    // Check required parameters
    if (projectQueryContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectQueryContext' when calling getFindingsTable");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-query-context}/findings/table"
            .replaceAll("\\{project-query-context}", apiClient.escapeString(projectQueryContext.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("csv", "expand", expand)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Finding>> localVarReturnType = new GenericType<List<Finding>>() {};
    return apiClient.invokeAPI("FindingDataApi.getFindingsTable", localVarPath, "POST", localVarQueryParams, query,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Source File Contents
   * Returns the contents of a given file, as long as it is a text file.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param pathId The ID of the path (required)
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested file&#39;s content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or file does not exist </td><td>  -  </td></tr>
       <tr><td> 415 </td><td> Unsupported Media Type - file was not able to be interpreted as a text file </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public String getSourceFileContents(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer pathId) throws ApiException {
    return getSourceFileContentsWithHttpInfo(projectVersionContext, pathId).getData();
  }

  /**
   * Source File Contents
   * Returns the contents of a given file, as long as it is a text file.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param pathId The ID of the path (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested file&#39;s content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or file does not exist </td><td>  -  </td></tr>
       <tr><td> 415 </td><td> Unsupported Media Type - file was not able to be interpreted as a text file </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> getSourceFileContentsWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer pathId) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getSourceFileContents");
    }
    if (pathId == null) {
      throw new ApiException(400, "Missing the required parameter 'pathId' when calling getSourceFileContents");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/files/{path-id}"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{path-id}", apiClient.escapeString(pathId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI("FindingDataApi.getSourceFileContents", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Source File Contents (tree)
   * Returns the contents of a given file, as long as it is a text file.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param path The literal path to the file (e.g., \&quot;com/foo/bar/Baz.java\&quot;) (required)
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested file&#39;s content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or file does not exist </td><td>  -  </td></tr>
       <tr><td> 415 </td><td> Unsupported Media Type - file was not able to be interpreted as a text file </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public String getSourceFileContentsFromPath(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull String path) throws ApiException {
    return getSourceFileContentsFromPathWithHttpInfo(projectVersionContext, path).getData();
  }

  /**
   * Source File Contents (tree)
   * Returns the contents of a given file, as long as it is a text file.  Requires the \&quot;project:view\&quot; permission which is provided by the \&quot;Reader\&quot; role.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param path The literal path to the file (e.g., \&quot;com/foo/bar/Baz.java\&quot;) (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the requested file&#39;s content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project or file does not exist </td><td>  -  </td></tr>
       <tr><td> 415 </td><td> Unsupported Media Type - file was not able to be interpreted as a text file </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> getSourceFileContentsFromPathWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull String path) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getSourceFileContentsFromPath");
    }
    if (path == null) {
      throw new ApiException(400, "Missing the required parameter 'path' when calling getSourceFileContentsFromPath");
    }

    // Path parameters
    String localVarPath = "/api/projects/{project-version-context}/files/tree/{path}"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{path}", apiClient.escapeString(path.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI("FindingDataApi.getSourceFileContentsFromPath", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
