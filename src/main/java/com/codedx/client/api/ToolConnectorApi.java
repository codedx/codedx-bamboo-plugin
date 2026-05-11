package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.CentrallyConfiguredConnector;
import com.codedx.client.model.ConnectorConfigurationRequest;
import com.codedx.client.model.ConnectorConfigurationResponse;
import com.codedx.client.model.ConnectorFieldValue;
import com.codedx.client.model.ConnectorJob;
import com.codedx.client.model.Error;
import com.codedx.client.model.GetToolConnectorConfigFormToolParameter;
import com.codedx.client.model.RunConnectorAnalysis409Response;
import com.codedx.client.model.SetAnalysisPrepBranchRequest;
import com.codedx.client.model.ToolConnectorFormsResponse;
import com.codedx.client.model.UpdateProjectScopedToolConnectorCOnfigEntityRequest;
import com.codedx.client.model.ValidateToolConnectorSection200Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ToolConnectorApi {
  private ApiClient apiClient;

  public ToolConnectorApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ToolConnectorApi(ApiClient apiClient) {
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
   * Check Connector Status
   * Allows user to check if a tool connector is \&quot;ready\&quot; for analysis.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param projectId The ID of the project. (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - \&quot;true\&quot; if connector is ready to run, \&quot;false\&quot; if connector is not ready. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Boolean checkConnectorStatus(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return checkConnectorStatusWithHttpInfo(entryId, projectId).getData();
  }

  /**
   * Check Connector Status
   * Allows user to check if a tool connector is \&quot;ready\&quot; for analysis.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Boolean&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - \&quot;true\&quot; if connector is ready to run, \&quot;false\&quot; if connector is not ready. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Boolean> checkConnectorStatusWithHttpInfo(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling checkConnectorStatus");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling checkConnectorStatus");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/entries/{project-id}/{entry-id}/analysis-ready"
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI("ToolConnectorApi.checkConnectorStatus", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create Tool Connector Configuration
   * Allows user to create a tool connector configuration.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param connectorConfigurationRequest An object representing the connector configuration. When specifying &#x60;values&#x60; in the request body, you must also specify &#x60;validation&#x60;, with tokens corresponding to the form sections whose values will be changed. An exception to this is if &#x60;useDynamicVersion&#x60; is true; in this case, &#x60;validation.version&#x60; may be omitted. (required)
   * @return ConnectorConfigurationResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the configuration object for the connector </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ConnectorConfigurationResponse createBlankConfig(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull ConnectorConfigurationRequest connectorConfigurationRequest) throws ApiException {
    return createBlankConfigWithHttpInfo(projectId, connectorConfigurationRequest).getData();
  }

  /**
   * Create Tool Connector Configuration
   * Allows user to create a tool connector configuration.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param connectorConfigurationRequest An object representing the connector configuration. When specifying &#x60;values&#x60; in the request body, you must also specify &#x60;validation&#x60;, with tokens corresponding to the form sections whose values will be changed. An exception to this is if &#x60;useDynamicVersion&#x60; is true; in this case, &#x60;validation.version&#x60; may be omitted. (required)
   * @return ApiResponse&lt;ConnectorConfigurationResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the configuration object for the connector </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ConnectorConfigurationResponse> createBlankConfigWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull ConnectorConfigurationRequest connectorConfigurationRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling createBlankConfig");
    }
    if (connectorConfigurationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'connectorConfigurationRequest' when calling createBlankConfig");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/entries/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ConnectorConfigurationResponse> localVarReturnType = new GenericType<ConnectorConfigurationResponse>() {};
    return apiClient.invokeAPI("ToolConnectorApi.createBlankConfig", localVarPath, "POST", new ArrayList<>(), connectorConfigurationRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Configuration
   * Allows user to delete a tool connector configuration.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param projectId The ID of the project. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Connector configuration deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteConfig(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    deleteConfigWithHttpInfo(entryId, projectId);
  }

  /**
   * Delete Configuration
   * Allows user to delete a tool connector configuration.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Connector configuration deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteConfigWithHttpInfo(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling deleteConfig");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteConfig");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/entries/{project-id}/{entry-id}"
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolConnectorApi.deleteConfig", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Edit Tool Connector Configuration Values (Legacy)
   * Allows user to edit a tool connector configuration&#39;s values.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  **Legacy Notice:** Aspects of the tool connector config system have changed since this endpoint was introduced, primarily related to the new fields on the config entity such as &#x60;useDynamicVersion&#x60; and &#x60;branchSyncTarget&#x60;. This endpoint strives to maintain backwards-compatibility, translating the semantics of the old system into the current one, but 100% compatibility is not guaranteed. Use the more general-purpose endpoint instead.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param requestBody  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Connector configuration was edited </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void editConfig(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Map<String, Object> requestBody) throws ApiException {
    editConfigWithHttpInfo(entryId, requestBody);
  }

  /**
   * Edit Tool Connector Configuration Values (Legacy)
   * Allows user to edit a tool connector configuration&#39;s values.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  **Legacy Notice:** Aspects of the tool connector config system have changed since this endpoint was introduced, primarily related to the new fields on the config entity such as &#x60;useDynamicVersion&#x60; and &#x60;branchSyncTarget&#x60;. This endpoint strives to maintain backwards-compatibility, translating the semantics of the old system into the current one, but 100% compatibility is not guaranteed. Use the more general-purpose endpoint instead.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param requestBody  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Connector configuration was edited </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> editConfigWithHttpInfo(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Map<String, Object> requestBody) throws ApiException {
    // Check required parameters
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling editConfig");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling editConfig");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/values/{entry-id}"
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolConnectorApi.editConfig", localVarPath, "PUT", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Centrally Configured Tool Connector Configurations
   * Allows user to get centrally configured tool connector configurations for a project.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;CentrallyConfiguredConnector&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of ConnectorConfigurationResponse objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<CentrallyConfiguredConnector> getCentrallyConfiguredToolConnectorConfigurations(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getCentrallyConfiguredToolConnectorConfigurationsWithHttpInfo(projectId).getData();
  }

  /**
   * Get Centrally Configured Tool Connector Configurations
   * Allows user to get centrally configured tool connector configurations for a project.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;CentrallyConfiguredConnector&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of ConnectorConfigurationResponse objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<CentrallyConfiguredConnector>> getCentrallyConfiguredToolConnectorConfigurationsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getCentrallyConfiguredToolConnectorConfigurations");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/centrally-configured/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<CentrallyConfiguredConnector>> localVarReturnType = new GenericType<List<CentrallyConfiguredConnector>>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getCentrallyConfiguredToolConnectorConfigurations", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Configuration
   * Gets the details of a specific tool connector configuration entry.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param entryId The entry id of a tool connector configuration (required)
   * @return ConnectorConfigurationResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the tool connector configuration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - you lack the permission to view the configuration </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ConnectorConfigurationResponse getConnectorConfig(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer entryId) throws ApiException {
    return getConnectorConfigWithHttpInfo(projectId, entryId).getData();
  }

  /**
   * Get Configuration
   * Gets the details of a specific tool connector configuration entry.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param entryId The entry id of a tool connector configuration (required)
   * @return ApiResponse&lt;ConnectorConfigurationResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the tool connector configuration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - you lack the permission to view the configuration </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ConnectorConfigurationResponse> getConnectorConfigWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer entryId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getConnectorConfig");
    }
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling getConnectorConfig");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/entries/{project-id}/{entry-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ConnectorConfigurationResponse> localVarReturnType = new GenericType<ConnectorConfigurationResponse>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getConnectorConfig", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Connectors
   * Allows user to obtain a list of configured connectors for a project.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;ConnectorConfigurationResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains a list of ConnectorConfigurationResponse objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ConnectorConfigurationResponse> getProjectConnectors(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectConnectorsWithHttpInfo(projectId).getData();
  }

  /**
   * Get Project Connectors
   * Allows user to obtain a list of configured connectors for a project.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;ConnectorConfigurationResponse&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains a list of ConnectorConfigurationResponse objects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ConnectorConfigurationResponse>> getProjectConnectorsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectConnectors");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/entries/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ConnectorConfigurationResponse>> localVarReturnType = new GenericType<List<ConnectorConfigurationResponse>>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getProjectConnectors", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get tool connector config values
   * Load the saved values for a tool connector configuration entity.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  Note that for any \&quot;credential\&quot; fields, this endpoint will report a &#x60;{ \&quot;placeholder\&quot;: true }&#x60; value in place of any actual stored credential.
   * @param entryId The entry id of a tool connector configuration (required)
   * @return Map&lt;String, Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - an object containing &#x60;&lt;field&gt;: &lt;value&gt;&#x60; entries representing the saved configuration. Any sensitive fields&#39; values will be represented with &#x60;{ \&quot;placeholder\&quot;: true }&#x60; instead of their actual values. The specific set of keys in the response will depend on the tool associated with the requested configuration entity. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester lacks the permission to view the configuration </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if the given &#x60;entry-id&#x60; does not correspond to any existing entity </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, Object> getProjectScopedToolConnectorConfigValues(@jakarta.annotation.Nonnull Integer entryId) throws ApiException {
    return getProjectScopedToolConnectorConfigValuesWithHttpInfo(entryId).getData();
  }

  /**
   * Get tool connector config values
   * Load the saved values for a tool connector configuration entity.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  Note that for any \&quot;credential\&quot; fields, this endpoint will report a &#x60;{ \&quot;placeholder\&quot;: true }&#x60; value in place of any actual stored credential.
   * @param entryId The entry id of a tool connector configuration (required)
   * @return ApiResponse&lt;Map&lt;String, Object&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - an object containing &#x60;&lt;field&gt;: &lt;value&gt;&#x60; entries representing the saved configuration. Any sensitive fields&#39; values will be represented with &#x60;{ \&quot;placeholder\&quot;: true }&#x60; instead of their actual values. The specific set of keys in the response will depend on the tool associated with the requested configuration entity. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester lacks the permission to view the configuration </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if the given &#x60;entry-id&#x60; does not correspond to any existing entity </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, Object>> getProjectScopedToolConnectorConfigValuesWithHttpInfo(@jakarta.annotation.Nonnull Integer entryId) throws ApiException {
    // Check required parameters
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling getProjectScopedToolConnectorConfigValues");
    }

    // Path parameters
    String localVarPath = "/x/tool-connector-config/values/{entry-id}"
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Map<String, Object>> localVarReturnType = new GenericType<Map<String, Object>>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getProjectScopedToolConnectorConfigValues", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Field Values (Legacy)
   * List the values for a tool connector configuration field.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  **Legacy Notice:** This endpoint requires an existing &#x60;entry-id&#x60;, which is inconvenient when attempting to create a new tool connector. Use the new endpoint which takes a &#x60;tool&#x60; path parameter and an optional &#x60;entityId&#x60; query parameter, instead.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param fieldId The ID of the connector configuration field. (required)
   * @param requestBody  (required)
   * @return List&lt;ConnectorFieldValue&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of ConnectorFieldValues </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ConnectorFieldValue> getToolConnectorConfigFieldValues(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull String fieldId, @jakarta.annotation.Nonnull Map<String, Object> requestBody) throws ApiException {
    return getToolConnectorConfigFieldValuesWithHttpInfo(entryId, fieldId, requestBody).getData();
  }

  /**
   * Get Field Values (Legacy)
   * List the values for a tool connector configuration field.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  **Legacy Notice:** This endpoint requires an existing &#x60;entry-id&#x60;, which is inconvenient when attempting to create a new tool connector. Use the new endpoint which takes a &#x60;tool&#x60; path parameter and an optional &#x60;entityId&#x60; query parameter, instead.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param fieldId The ID of the connector configuration field. (required)
   * @param requestBody  (required)
   * @return ApiResponse&lt;List&lt;ConnectorFieldValue&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of ConnectorFieldValues </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ConnectorFieldValue>> getToolConnectorConfigFieldValuesWithHttpInfo(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull String fieldId, @jakarta.annotation.Nonnull Map<String, Object> requestBody) throws ApiException {
    // Check required parameters
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling getToolConnectorConfigFieldValues");
    }
    if (fieldId == null) {
      throw new ApiException(400, "Missing the required parameter 'fieldId' when calling getToolConnectorConfigFieldValues");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling getToolConnectorConfigFieldValues");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/values/{entry-id}/populate/{field-id}"
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()))
            .replaceAll("\\{field-id}", apiClient.escapeString(fieldId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ConnectorFieldValue>> localVarReturnType = new GenericType<List<ConnectorFieldValue>>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getToolConnectorConfigFieldValues", localVarPath, "POST", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Tool Connector Configuration Form
   * Gets a FormSpecifier for each of the tool connector&#39;s forms, for the integration associated with the given &#x60;tool&#x60;.  Requires the \&quot;site:read\&quot; permission, which is provided by default to all users.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return ToolConnectorFormsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - describes each of the tool connector&#39;s configuration forms </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> NOT FOUND - if the given &#x60;tool&#x60; does not correspond to a tool with a ToolConnector integration </td><td>  -  </td></tr>
     </table>
   */
  public ToolConnectorFormsResponse getToolConnectorConfigForm(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    return getToolConnectorConfigFormWithHttpInfo(tool).getData();
  }

  /**
   * Get Tool Connector Configuration Form
   * Gets a FormSpecifier for each of the tool connector&#39;s forms, for the integration associated with the given &#x60;tool&#x60;.  Requires the \&quot;site:read\&quot; permission, which is provided by default to all users.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return ApiResponse&lt;ToolConnectorFormsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - describes each of the tool connector&#39;s configuration forms </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> NOT FOUND - if the given &#x60;tool&#x60; does not correspond to a tool with a ToolConnector integration </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ToolConnectorFormsResponse> getToolConnectorConfigFormWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getToolConnectorConfigForm");
    }

    // Path parameters
    String localVarPath = "/x/tool-connector-config/form/{tool}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ToolConnectorFormsResponse> localVarReturnType = new GenericType<ToolConnectorFormsResponse>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getToolConnectorConfigForm", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Configuration Form (Legacy)
   * Gets a FormSpecifier for each of the tool connector&#39;s forms. List configuration fields for a tool connector.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  **Legacy Notice:** This path should no longer be used; it is possible to obtain the same information without the use of an existing &#x60;entry-id&#x60;. Use the path that includes a &#x60;tool-specifier&#x60; parameter instead.
   * @param entryId The entry id of a tool connector configuration (required)
   * @return ToolConnectorFormsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - describes each of the tool connector&#39;s configuration forms </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ToolConnectorFormsResponse getToolConnectorConfigFormLegacy(@jakarta.annotation.Nonnull Integer entryId) throws ApiException {
    return getToolConnectorConfigFormLegacyWithHttpInfo(entryId).getData();
  }

  /**
   * Get Configuration Form (Legacy)
   * Gets a FormSpecifier for each of the tool connector&#39;s forms. List configuration fields for a tool connector.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.  **Legacy Notice:** This path should no longer be used; it is possible to obtain the same information without the use of an existing &#x60;entry-id&#x60;. Use the path that includes a &#x60;tool-specifier&#x60; parameter instead.
   * @param entryId The entry id of a tool connector configuration (required)
   * @return ApiResponse&lt;ToolConnectorFormsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - describes each of the tool connector&#39;s configuration forms </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ToolConnectorFormsResponse> getToolConnectorConfigFormLegacyWithHttpInfo(@jakarta.annotation.Nonnull Integer entryId) throws ApiException {
    // Check required parameters
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling getToolConnectorConfigFormLegacy");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/values/{entry-id}/form"
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ToolConnectorFormsResponse> localVarReturnType = new GenericType<ToolConnectorFormsResponse>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getToolConnectorConfigFormLegacy", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Dropdown Options for Tool Connector Config Field
   * Load a list of dropdown options for a Tool Connector config field that uses one of the &#39;dropdown&#39; or &#39;multiselect&#39; field types, and has a &#39;dynamic&#39; options provider. Request body must provide values for the options provider&#39;s required fields.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param fieldId The ID of the connector configuration field. (required)
   * @param requestBody  (required)
   * @param entityId ID of an existing tool connector configuration entity, used to resolve placeholders in the submitted request body (optional)
   * @return List&lt;ConnectorFieldValue&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of dropdown options </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - something was wrong with the submitted values, so the options provider&#39;s requirements could not be fulfilled </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - an &#x60;entityId&#x60; was given, but the requester did not have access </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the given tool does not have a supported connector integration, or an invalid &#x60;entityId&#x60; was given </td><td>  -  </td></tr>
     </table>
   */
  public List<ConnectorFieldValue> getToolConnectorConfigPopulatedValue(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String fieldId, @jakarta.annotation.Nonnull Map<String, Object> requestBody, @jakarta.annotation.Nullable Integer entityId) throws ApiException {
    return getToolConnectorConfigPopulatedValueWithHttpInfo(tool, fieldId, requestBody, entityId).getData();
  }

  /**
   * Get Dropdown Options for Tool Connector Config Field
   * Load a list of dropdown options for a Tool Connector config field that uses one of the &#39;dropdown&#39; or &#39;multiselect&#39; field types, and has a &#39;dynamic&#39; options provider. Request body must provide values for the options provider&#39;s required fields.  Requires the \&quot;project:manage-tool-connectors\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param fieldId The ID of the connector configuration field. (required)
   * @param requestBody  (required)
   * @param entityId ID of an existing tool connector configuration entity, used to resolve placeholders in the submitted request body (optional)
   * @return ApiResponse&lt;List&lt;ConnectorFieldValue&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of dropdown options </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - something was wrong with the submitted values, so the options provider&#39;s requirements could not be fulfilled </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - an &#x60;entityId&#x60; was given, but the requester did not have access </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the given tool does not have a supported connector integration, or an invalid &#x60;entityId&#x60; was given </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ConnectorFieldValue>> getToolConnectorConfigPopulatedValueWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String fieldId, @jakarta.annotation.Nonnull Map<String, Object> requestBody, @jakarta.annotation.Nullable Integer entityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getToolConnectorConfigPopulatedValue");
    }
    if (fieldId == null) {
      throw new ApiException(400, "Missing the required parameter 'fieldId' when calling getToolConnectorConfigPopulatedValue");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling getToolConnectorConfigPopulatedValue");
    }

    // Path parameters
    String localVarPath = "/x/tool-connector-config/form/{tool}/populate/{field-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{field-id}", apiClient.escapeString(fieldId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "entityId", entityId)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ConnectorFieldValue>> localVarReturnType = new GenericType<List<ConnectorFieldValue>>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getToolConnectorConfigPopulatedValue", localVarPath, "POST", localVarQueryParams, requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Tools
   * List tools available for tool connector configuration.  Requires no role, all users have sufficient permissions by default.
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of tool names </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<String> getToolConnectorTools() throws ApiException {
    return getToolConnectorToolsWithHttpInfo().getData();
  }

  /**
   * List Tools
   * List tools available for tool connector configuration.  Requires no role, all users have sufficient permissions by default.
   * @return ApiResponse&lt;List&lt;String&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of tool names </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<String>> getToolConnectorToolsWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI("ToolConnectorApi.getToolConnectorTools", "/api/tool-connector-config/available-tools", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Run Connector Analysis
   * Allows user to run a tool connector analysis.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param projectId The ID of the project. (required)
   * @param setAnalysisPrepBranchRequest Optional request body may be used to specify a specific branch on which to run the analysis (optional)
   * @return ConnectorJob
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Analysis started </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - request body was not JSON, or the &#39;branch&#39; field was not in the expected format </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist, or the specified &#39;branch&#39; from the request body did not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - the Tool Connector&#39;s was configured to sync to a nonexistent branch, or conflicting branches. This can be circumvented by specifying an explicit &#39;branch&#39; field in the request body. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ConnectorJob runConnectorAnalysis(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable SetAnalysisPrepBranchRequest setAnalysisPrepBranchRequest) throws ApiException {
    return runConnectorAnalysisWithHttpInfo(entryId, projectId, setAnalysisPrepBranchRequest).getData();
  }

  /**
   * Run Connector Analysis
   * Allows user to run a tool connector analysis.  Requires the \&quot;project:view-tool-connectors\&quot; permission which is provided by the \&quot;Creator\&quot; role.
   * @param entryId The entry id of a tool connector configuration (required)
   * @param projectId The ID of the project. (required)
   * @param setAnalysisPrepBranchRequest Optional request body may be used to specify a specific branch on which to run the analysis (optional)
   * @return ApiResponse&lt;ConnectorJob&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Analysis started </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - request body was not JSON, or the &#39;branch&#39; field was not in the expected format </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Tool Connector entry does not exist, or the specified &#39;branch&#39; from the request body did not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - the Tool Connector&#39;s was configured to sync to a nonexistent branch, or conflicting branches. This can be circumvented by specifying an explicit &#39;branch&#39; field in the request body. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ConnectorJob> runConnectorAnalysisWithHttpInfo(@jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable SetAnalysisPrepBranchRequest setAnalysisPrepBranchRequest) throws ApiException {
    // Check required parameters
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling runConnectorAnalysis");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling runConnectorAnalysis");
    }

    // Path parameters
    String localVarPath = "/api/tool-connector-config/entries/{project-id}/{entry-id}/analysis"
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ConnectorJob> localVarReturnType = new GenericType<ConnectorJob>() {};
    return apiClient.invokeAPI("ToolConnectorApi.runConnectorAnalysis", localVarPath, "POST", new ArrayList<>(), setAnalysisPrepBranchRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Edit Tool Connector Configuration
   * Allows user to edit a tool connector configuration. When specifying &#x60;values&#x60; in the request body, you must also provide &#x60;validation&#x60; tokens corresponding to the changed form sections.  Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param projectId The ID of the project. (required)
   * @param entryId The entry id of a tool connector configuration (required)
   * @param updateProjectScopedToolConnectorCOnfigEntityRequest  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - entity was updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - one or more aspects of the request body was incorrect or missing </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - attempted to modify an entity that the requester cannot access </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - no such project, or no such entity </td><td>  -  </td></tr>
     </table>
   */
  public void updateProjectScopedToolConnectorCOnfigEntity(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull UpdateProjectScopedToolConnectorCOnfigEntityRequest updateProjectScopedToolConnectorCOnfigEntityRequest) throws ApiException {
    updateProjectScopedToolConnectorCOnfigEntityWithHttpInfo(projectId, entryId, updateProjectScopedToolConnectorCOnfigEntityRequest);
  }

  /**
   * Edit Tool Connector Configuration
   * Allows user to edit a tool connector configuration. When specifying &#x60;values&#x60; in the request body, you must also provide &#x60;validation&#x60; tokens corresponding to the changed form sections.  Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param projectId The ID of the project. (required)
   * @param entryId The entry id of a tool connector configuration (required)
   * @param updateProjectScopedToolConnectorCOnfigEntityRequest  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - entity was updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - one or more aspects of the request body was incorrect or missing </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - attempted to modify an entity that the requester cannot access </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - no such project, or no such entity </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateProjectScopedToolConnectorCOnfigEntityWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer entryId, @jakarta.annotation.Nonnull UpdateProjectScopedToolConnectorCOnfigEntityRequest updateProjectScopedToolConnectorCOnfigEntityRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateProjectScopedToolConnectorCOnfigEntity");
    }
    if (entryId == null) {
      throw new ApiException(400, "Missing the required parameter 'entryId' when calling updateProjectScopedToolConnectorCOnfigEntity");
    }
    if (updateProjectScopedToolConnectorCOnfigEntityRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'updateProjectScopedToolConnectorCOnfigEntityRequest' when calling updateProjectScopedToolConnectorCOnfigEntity");
    }

    // Path parameters
    String localVarPath = "/x/tool-connector-config/entries/{project-id}/{entry-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{entry-id}", apiClient.escapeString(entryId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolConnectorApi.updateProjectScopedToolConnectorCOnfigEntity", localVarPath, "PUT", new ArrayList<>(), updateProjectScopedToolConnectorCOnfigEntityRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Validate Tool Connector Values
   * Validate the values in a section of a tool connector&#39;s configuration form, returning feedback messages, and a validation token on success
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param requestBody  (required)
   * @param entityId ID of an existing tool connector configuration entity, used to resolve placeholders in the submitted request body (optional)
   * @return ValidateToolConnectorSection200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - provides feedback and possibly a validation token </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - if something was wrong with the submitted values, prior to validation </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if an &#x60;entityId&#x60; was given, but the requester does not have access to it </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if an &#x60;entityId&#x60; was given, but no such entity exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure, typically during communication with the third-party tool </td><td>  -  </td></tr>
     </table>
   */
  public ValidateToolConnectorSection200Response validateToolConnectorSection(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Map<String, Object> requestBody, @jakarta.annotation.Nullable Integer entityId) throws ApiException {
    return validateToolConnectorSectionWithHttpInfo(tool, entityType, requestBody, entityId).getData();
  }

  /**
   * Validate Tool Connector Values
   * Validate the values in a section of a tool connector&#39;s configuration form, returning feedback messages, and a validation token on success
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param requestBody  (required)
   * @param entityId ID of an existing tool connector configuration entity, used to resolve placeholders in the submitted request body (optional)
   * @return ApiResponse&lt;ValidateToolConnectorSection200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - provides feedback and possibly a validation token </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - if something was wrong with the submitted values, prior to validation </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if an &#x60;entityId&#x60; was given, but the requester does not have access to it </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if an &#x60;entityId&#x60; was given, but no such entity exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure, typically during communication with the third-party tool </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ValidateToolConnectorSection200Response> validateToolConnectorSectionWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Map<String, Object> requestBody, @jakarta.annotation.Nullable Integer entityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling validateToolConnectorSection");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling validateToolConnectorSection");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling validateToolConnectorSection");
    }

    // Path parameters
    String localVarPath = "/x/tool-connector-config/form/{tool}/validate/{entity-type}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "entityId", entityId)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ValidateToolConnectorSection200Response> localVarReturnType = new GenericType<ValidateToolConnectorSection200Response>() {};
    return apiClient.invokeAPI("ToolConnectorApi.validateToolConnectorSection", localVarPath, "POST", localVarQueryParams, requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
