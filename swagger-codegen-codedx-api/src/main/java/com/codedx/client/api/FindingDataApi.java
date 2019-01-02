package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.codedx.client.api.ActivityEvent;
import com.codedx.client.api.Count;
import com.codedx.client.api.Finding;
import com.codedx.client.api.FindingDescription;
import com.codedx.client.api.FlowData;
import com.codedx.client.api.FlowRequest;
import com.codedx.client.api.GroupedCount;
import com.codedx.client.api.GroupedCountsRequest;
import com.codedx.client.api.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-02T17:17:22.434-05:00")
public class FindingDataApi {
  private ApiClient apiClient;

  public FindingDataApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FindingDataApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Finding Data
   * Returns metadata for the given finding 
   * @param findingId The finding ID. (required)
   * @param expand The expand parameter is a comma seperated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are&amp;#58; - &#x60;descriptions&#x60; - an additional property named &#x60;descriptions&#x60; is added to the Finding objects. It is a Description object that contains the tool/rule description for the finding - &#x60;descriptor&#x60; - adds additional content to the &#x60;descriptor&#x60; property of the Finding object. - &#x60;issue&#x60; - an additional property named &#x60;issue&#x60; is added to the Finding objects. &#x60;issue&#x60; will be an Issue object. - &#x60;triage-time&#x60; - an additional property named &#x60;triageTime&#x60; is added to the Finding objects. It is a date time that corresponds to the most recent time the status of the finding was updated. - &#x60;results&#x60; - an additional property named &#x60;results&#x60; is added to the Finding objects. It is an array of ToolResult objects that relate to the finding. - &#x60;results.descriptions&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property named &#x60;descriptions&#x60; to the ToolResult objects. This property is a Description object and will contain the tool and contextual descriptions for the result. - &#x60;results.descriptor&#x60; - does the same thing as &#x60;results&#x60; as well as adds additional properties to the ToolResults&#39; &#x60;descriptor&#x60; properties. - &#x60;results.metadata&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the ToolResult object named &#x60;metadata&#x60;. &#x60;metadata&#x60; is an object that contains key values pairs, usually some additional information reported by a tool. - &#x60;results.variants&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the the ToolResult object named &#x60;variants&#x60;. &#x60;variants&#x60; is an array of Variant objects. A Variant typically contains http/https request and response information.  (optional)
   * @return Finding
   * @throws ApiException if fails to make API call
   */
  public Finding getFindingData(Integer findingId, List<String> expand) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'findingId' is set
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling getFindingData");
    }
    
    // create path and map variables
    String localVarPath = "/api/findings/{finding-id}"
      .replaceAll("\\{" + "finding-id" + "\\}", apiClient.escapeString(findingId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "expand", expand));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Finding> localVarReturnType = new GenericType<Finding>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Finding Descriptions
   * Returns the descriptions for the given finding from all available sources. 
   * @param findingId The finding ID. (required)
   * @return FindingDescription
   * @throws ApiException if fails to make API call
   */
  public FindingDescription getFindingDescription(Integer findingId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'findingId' is set
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling getFindingDescription");
    }
    
    // create path and map variables
    String localVarPath = "/api/findings/{finding-id}/description"
      .replaceAll("\\{" + "finding-id" + "\\}", apiClient.escapeString(findingId.toString()));

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

    GenericType<FindingDescription> localVarReturnType = new GenericType<FindingDescription>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Finding Flow Data
   * Returns filtered finding flow data. This endpoint is a candidate to be absorbed by a more generic querying API; presently it just returns the data required for the finding flow as it exists today. 
   * @param projectId The ID of the project. (required)
   * @param flowRequest  (optional)
   * @return List&lt;FlowData&gt;
   * @throws ApiException if fails to make API call
   */
  public List<FlowData> getFindingFlow(Integer projectId, FlowRequest flowRequest) throws ApiException {
    Object localVarPostBody = flowRequest;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFindingFlow");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/findings/flow"
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

    GenericType<List<FlowData>> localVarReturnType = new GenericType<List<FlowData>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Finding History
   * Responds with an array of \&quot;activity event\&quot; objects in JSON. 
   * @param findingId The finding ID. (required)
   * @return List&lt;ActivityEvent&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ActivityEvent> getFindingHistory(Integer findingId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'findingId' is set
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling getFindingHistory");
    }
    
    // create path and map variables
    String localVarPath = "/api/findings/{finding-id}/history"
      .replaceAll("\\{" + "finding-id" + "\\}", apiClient.escapeString(findingId.toString()));

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

    GenericType<List<ActivityEvent>> localVarReturnType = new GenericType<List<ActivityEvent>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Finding Count
   * Returns the count of all findings in the project matching the given filter. 
   * @param projectId The ID of the project. (required)
   * @param query  (optional)
   * @return Count
   * @throws ApiException if fails to make API call
   */
  public Count getFindingsCount(Integer projectId, Query query) throws ApiException {
    Object localVarPostBody = query;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFindingsCount");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/findings/count"
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

    GenericType<Count> localVarReturnType = new GenericType<Count>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Findings Grouped Count
   * Returns filtered finding counts, grouped by the specified field. 
   * @param projectId The ID of the project. (required)
   * @param groupedCountRequest  (optional)
   * @return List&lt;GroupedCount&gt;
   * @throws ApiException if fails to make API call
   */
  public List<GroupedCount> getFindingsGroupCount(Integer projectId, GroupedCountsRequest groupedCountRequest) throws ApiException {
    Object localVarPostBody = groupedCountRequest;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFindingsGroupCount");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/findings/grouped-counts"
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

    GenericType<List<GroupedCount>> localVarReturnType = new GenericType<List<GroupedCount>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Finding Table Data
   * Returns filtered finding table data. This endpoint is a candidate to become a more generic querying API; presently it just returns the data required for the findings table as it exists today. 
   * @param projectId The ID of the project. (required)
   * @param query  (optional)
   * @param expand The expand parameter is a comma seperated list. Each value included in the list has the potential to modify the response&#39;s Finding objects. The available values and their effects are&amp;#58; - &#x60;descriptions&#x60; - an additional property named &#x60;descriptions&#x60; is added to the Finding objects. It is a Description object that contains the tool/rule description for the finding - &#x60;descriptor&#x60; - adds additional content to the &#x60;descriptor&#x60; property of the Finding object. - &#x60;issue&#x60; - an additional property named &#x60;issue&#x60; is added to the Finding objects. &#x60;issue&#x60; will be an Issue object. - &#x60;triage-time&#x60; - an additional property named &#x60;triageTime&#x60; is added to the Finding objects. It is a date time that corresponds to the most recent time the status of the finding was updated. - &#x60;results&#x60; - an additional property named &#x60;results&#x60; is added to the Finding objects. It is an array of ToolResult objects that relate to the finding. - &#x60;results.descriptions&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property named &#x60;descriptions&#x60; to the ToolResult objects. This property is a Description object and will contain the tool and contextual descriptions for the result. - &#x60;results.descriptor&#x60; - does the same thing as &#x60;results&#x60; as well as adds additional properties to the ToolResults&#39; &#x60;descriptor&#x60; properties. - &#x60;results.metadata&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the ToolResult object named &#x60;metadata&#x60;. &#x60;metadata&#x60; is an object that contains key values pairs, usually some additional information reported by a tool. - &#x60;results.variants&#x60; - does the same thing as &#x60;results&#x60; as well as adds an additional property to the the ToolResult object named &#x60;variants&#x60;. &#x60;variants&#x60; is an array of Variant objects. A Variant typically contains http/https request and response information.  (optional)
   * @return List&lt;Finding&gt;
   * @throws ApiException if fails to make API call
   */
  public List<Finding> getFindingsTable(Integer projectId, Query query, List<String> expand) throws ApiException {
    Object localVarPostBody = query;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFindingsTable");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/findings/table"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "expand", expand));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<List<Finding>> localVarReturnType = new GenericType<List<Finding>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Source File Contents
   * Returns the contents of a given file, as long as it is a text file. 
   * @param projectId The ID of the project. (required)
   * @param pathId The ID of the path (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String getSourceFileContents(Integer projectId, Integer pathId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getSourceFileContents");
    }
    
    // verify the required parameter 'pathId' is set
    if (pathId == null) {
      throw new ApiException(400, "Missing the required parameter 'pathId' when calling getSourceFileContents");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/files/{path-id}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()))
      .replaceAll("\\{" + "path-id" + "\\}", apiClient.escapeString(pathId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "text/plain"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Source File Contents (tree)
   * Returns the contents of a given file, as long as it is a text file. 
   * @param projectId The ID of the project. (required)
   * @param path The literal path to the file (e.g., \&quot;com/foo/bar/Baz.java\&quot;) (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String getSourceFileContentsFromPath(Integer projectId, String path) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getSourceFileContentsFromPath");
    }
    
    // verify the required parameter 'path' is set
    if (path == null) {
      throw new ApiException(400, "Missing the required parameter 'path' when calling getSourceFileContentsFromPath");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/files/tree/{path}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()))
      .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(path.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "text/plain"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
