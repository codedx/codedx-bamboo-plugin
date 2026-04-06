package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.AllIntegrations;
import com.codedx.client.model.ApiConfigValues;
import com.codedx.client.model.AutoVersionBindingCreateRef;
import com.codedx.client.model.AutoVersionConnector;
import com.codedx.client.model.BulkSetDefaultScheduleRequest;
import com.codedx.client.model.CentrallyConfiguredConnector;
import com.codedx.client.model.ConnectorAnalysisJob;
import com.codedx.client.model.CreateNewEntity;
import com.codedx.client.model.DefaultEntitiesForTool;
import com.codedx.client.model.DefaultSchedulesForTool;
import com.codedx.client.model.DropdownOption;
import com.codedx.client.model.EntityRef;
import com.codedx.client.model.EntityValidationFeedback;
import com.codedx.client.model.Error;
import com.codedx.client.model.FormSpecifierInner;
import com.codedx.client.model.GetAutoVersionConnectorResponse;
import com.codedx.client.model.GetEntityNamesFromTool200Response;
import com.codedx.client.model.GetEntityNamesFromToolRequest;
import com.codedx.client.model.GetProjectEnumerationSupport200Response;
import com.codedx.client.model.GetProjectNameSyncSupport200Response;
import com.codedx.client.model.GetToolConnectorConfigFormToolParameter;
import com.codedx.client.model.GetVersionNameSyncSupport200Response;
import com.codedx.client.model.IdentifiedBinding;
import com.codedx.client.model.ImportProjectsFromIntegration;
import com.codedx.client.model.IntegrationEntity;
import com.codedx.client.model.IntegrationEntityDefinition;
import com.codedx.client.model.IntegrationEntityRole;
import com.codedx.client.model.JobIdResponse;
import com.codedx.client.model.NewImportedBinding;
import com.codedx.client.model.SetBulkDefaultEntity;
import com.codedx.client.model.SetProjectEntityNameOverrideRequest;
import com.codedx.client.model.ToolConfigSchedule;
import com.codedx.client.model.ToolConfigScheduleRef;
import com.codedx.client.model.ToolConnectorBinding;
import com.codedx.client.model.ToolConnectorStaticBinding;
import com.codedx.client.model.ToolConnectorStaticBindingCreateRef;
import com.codedx.client.model.ToolConnectorUrlValidationFeedback;
import com.codedx.client.model.UpdateAutoVersionConnectorRequest;
import com.codedx.client.model.UpdateBulkConnectorBinding;
import com.codedx.client.model.UpdateConnectorBinding;
import com.codedx.client.model.UserIntegrationEntityRole;
import com.codedx.client.model.ValidateToolConnectorUrlRequest;
import com.codedx.client.model.VersionConfigurationEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class CentralConfigurationApi {
  private ApiClient apiClient;

  public CentralConfigurationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CentralConfigurationApi(ApiClient apiClient) {
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
   * Bulk Set Project Default Schedule
   * Set the default schedule for a tool and a set of projects. Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bulkSetDefaultScheduleRequest  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default tool schedules updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User not permitted to update the default schedule for one or more of the specified projects. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either tool or schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void bulkSetDefaultSchedule(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable BulkSetDefaultScheduleRequest bulkSetDefaultScheduleRequest) throws ApiException {
    bulkSetDefaultScheduleWithHttpInfo(tool, bulkSetDefaultScheduleRequest);
  }

  /**
   * Bulk Set Project Default Schedule
   * Set the default schedule for a tool and a set of projects. Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bulkSetDefaultScheduleRequest  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default tool schedules updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User not permitted to update the default schedule for one or more of the specified projects. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either tool or schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> bulkSetDefaultScheduleWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable BulkSetDefaultScheduleRequest bulkSetDefaultScheduleRequest) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling bulkSetDefaultSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/defaults/{tool}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.bulkSetDefaultSchedule", localVarPath, "PUT", new ArrayList<>(), bulkSetDefaultScheduleRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create Auto Version Connector
   * Creates an auto version connector.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param autoVersionBindingCreateRef  (optional)
   * @return AutoVersionConnector
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Auto Version Connector was successfully created </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The project supplied does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Auto Version Connector already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AutoVersionConnector createAutoVersionConnector(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable AutoVersionBindingCreateRef autoVersionBindingCreateRef) throws ApiException {
    return createAutoVersionConnectorWithHttpInfo(tool, autoVersionBindingCreateRef).getData();
  }

  /**
   * Create Auto Version Connector
   * Creates an auto version connector.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param autoVersionBindingCreateRef  (optional)
   * @return ApiResponse&lt;AutoVersionConnector&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Auto Version Connector was successfully created </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The project supplied does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Auto Version Connector already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AutoVersionConnector> createAutoVersionConnectorWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable AutoVersionBindingCreateRef autoVersionBindingCreateRef) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling createAutoVersionConnector");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/auto-version-connector"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AutoVersionConnector> localVarReturnType = new GenericType<AutoVersionConnector>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.createAutoVersionConnector", localVarPath, "POST", new ArrayList<>(), autoVersionBindingCreateRef,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Creates Integration Entity
   * Creates an integration entity.  Requires the \&quot;integrations:tool-configuration:create\&quot; permission which is provided by the \&quot;Integrations Admin\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param integrationEntityDefinition  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully created </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for an integration was provided, but no integration with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void createEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable IntegrationEntityDefinition integrationEntityDefinition) throws ApiException {
    createEntityTypeWithHttpInfo(tool, entityType, integrationEntityDefinition);
  }

  /**
   * Creates Integration Entity
   * Creates an integration entity.  Requires the \&quot;integrations:tool-configuration:create\&quot; permission which is provided by the \&quot;Integrations Admin\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param integrationEntityDefinition  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully created </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for an integration was provided, but no integration with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable IntegrationEntityDefinition integrationEntityDefinition) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling createEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling createEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.createEntityType", localVarPath, "POST", new ArrayList<>(), integrationEntityDefinition,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create Schedule
   * Create a schedule to use with tool configurations. Requires the \&quot;integrations:schedule:create\&quot; permission.
   * @param toolConfigSchedule  (optional)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body was malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer createSchedule(@jakarta.annotation.Nullable ToolConfigSchedule toolConfigSchedule) throws ApiException {
    return createScheduleWithHttpInfo(toolConfigSchedule).getData();
  }

  /**
   * Create Schedule
   * Create a schedule to use with tool configurations. Requires the \&quot;integrations:schedule:create\&quot; permission.
   * @param toolConfigSchedule  (optional)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Request body was malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> createScheduleWithHttpInfo(@jakarta.annotation.Nullable ToolConfigSchedule toolConfigSchedule) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.createSchedule", "/x/integrations/schedule", "POST", new ArrayList<>(), toolConfigSchedule,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create Tool Connector Binding
   * Creates a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param toolConnectorStaticBindingCreateRef An object describing the tool connector binding which should be created (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Binding created, returns the id of the binding </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permissions required to create tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - One or more supplied data values do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer createToolConnectorBinding(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull ToolConnectorStaticBindingCreateRef toolConnectorStaticBindingCreateRef) throws ApiException {
    return createToolConnectorBindingWithHttpInfo(tool, toolConnectorStaticBindingCreateRef).getData();
  }

  /**
   * Create Tool Connector Binding
   * Creates a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param toolConnectorStaticBindingCreateRef An object describing the tool connector binding which should be created (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Binding created, returns the id of the binding </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permissions required to create tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - One or more supplied data values do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> createToolConnectorBindingWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull ToolConnectorStaticBindingCreateRef toolConnectorStaticBindingCreateRef) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling createToolConnectorBinding");
    }
    if (toolConnectorStaticBindingCreateRef == null) {
      throw new ApiException(400, "Missing the required parameter 'toolConnectorStaticBindingCreateRef' when calling createToolConnectorBinding");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/binding"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.createToolConnectorBinding", localVarPath, "POST", new ArrayList<>(), toolConnectorStaticBindingCreateRef,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create Version From Integrations
   * Creates tool connector bindings by creating new version entities using  existing connection entities and project entities.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection(s) being used. Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param versionConfigurationEntry  (optional)
   * @return List&lt;IdentifiedBinding&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of newly created tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to create tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and project id were provided but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<IdentifiedBinding> createVersionFromIntegrations(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable List<VersionConfigurationEntry> versionConfigurationEntry) throws ApiException {
    return createVersionFromIntegrationsWithHttpInfo(tool, projectId, connectionEntityId, projectEntityId, versionConfigurationEntry).getData();
  }

  /**
   * Create Version From Integrations
   * Creates tool connector bindings by creating new version entities using  existing connection entities and project entities.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection(s) being used. Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param versionConfigurationEntry  (optional)
   * @return ApiResponse&lt;List&lt;IdentifiedBinding&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of newly created tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to create tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and project id were provided but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<IdentifiedBinding>> createVersionFromIntegrationsWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable List<VersionConfigurationEntry> versionConfigurationEntry) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling createVersionFromIntegrations");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling createVersionFromIntegrations");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/version-import/{project-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "connectionEntityId", connectionEntityId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "projectEntityId", projectEntityId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<IdentifiedBinding>> localVarReturnType = new GenericType<List<IdentifiedBinding>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.createVersionFromIntegrations", localVarPath, "POST", localVarQueryParams, versionConfigurationEntry,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Integration Entity
   * Deletes an integration entity.  Requires the \&quot;integrations:tool-configuration:delete\&quot; permission which is provided by the \&quot;Entity Editor\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration id, integration entity type, and integration entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A project is associated with this integration entity. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    deleteEntityTypeWithHttpInfo(tool, entityType, entityId);
  }

  /**
   * Delete Integration Entity
   * Deletes an integration entity.  Requires the \&quot;integrations:tool-configuration:delete\&quot; permission which is provided by the \&quot;Entity Editor\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration id, integration entity type, and integration entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A project is associated with this integration entity. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling deleteEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling deleteEntityType");
    }
    if (entityId == null) {
      throw new ApiException(400, "Missing the required parameter 'entityId' when calling deleteEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/{entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{entity-id}", apiClient.escapeString(entityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.deleteEntityType", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Project Default Entity
   * Deletes the projects default entity for the specified by entity type.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project default entity was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to delete the default entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and project id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProjectDefaultEntity(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    deleteProjectDefaultEntityWithHttpInfo(tool, entityType, projectId, projectEntityId, connectionEntityId);
  }

  /**
   * Delete Project Default Entity
   * Deletes the projects default entity for the specified by entity type.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project default entity was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to delete the default entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and project id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProjectDefaultEntityWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling deleteProjectDefaultEntity");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling deleteProjectDefaultEntity");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteProjectDefaultEntity");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling deleteProjectDefaultEntity");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling deleteProjectDefaultEntity");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}/default"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.deleteProjectDefaultEntity", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Schedule
   * Delete a specific schedule. Requires the \&quot;integrations:schedule:delete\&quot; permission.
   * @param scheduleId The ID of the schedule. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Schedule delete </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Schedule could not be deleted due to some conflict (something is referencing this schedule) </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteSchedule(@jakarta.annotation.Nonnull Integer scheduleId) throws ApiException {
    deleteScheduleWithHttpInfo(scheduleId);
  }

  /**
   * Delete Schedule
   * Delete a specific schedule. Requires the \&quot;integrations:schedule:delete\&quot; permission.
   * @param scheduleId The ID of the schedule. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Schedule delete </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Schedule could not be deleted due to some conflict (something is referencing this schedule) </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteScheduleWithHttpInfo(@jakarta.annotation.Nonnull Integer scheduleId) throws ApiException {
    // Check required parameters
    if (scheduleId == null) {
      throw new ApiException(400, "Missing the required parameter 'scheduleId' when calling deleteSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/{schedule-id}"
            .replaceAll("\\{schedule-id}", apiClient.escapeString(scheduleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.deleteSchedule", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Tool Connector Binding
   * Deletes a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used by the connector and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tool connector was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to delete this tool connector binding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool or tool connector do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteToolConnectorBinding(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId) throws ApiException {
    deleteToolConnectorBindingWithHttpInfo(tool, bindingId);
  }

  /**
   * Delete Tool Connector Binding
   * Deletes a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used by the connector and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tool connector was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to delete this tool connector binding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool or tool connector do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteToolConnectorBindingWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling deleteToolConnectorBinding");
    }
    if (bindingId == null) {
      throw new ApiException(400, "Missing the required parameter 'bindingId' when calling deleteToolConnectorBinding");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/binding/{binding-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{binding-id}", apiClient.escapeString(bindingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.deleteToolConnectorBinding", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update Tool Connector Binding
   * Updates a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used by the connector and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @param updateConnectorBinding An object describing updates to a connector (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Tool connector was updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to edit this tool connector binding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool or tool connector do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void editToolConnectorBinding(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId, @jakarta.annotation.Nonnull UpdateConnectorBinding updateConnectorBinding) throws ApiException {
    editToolConnectorBindingWithHttpInfo(tool, bindingId, updateConnectorBinding);
  }

  /**
   * Update Tool Connector Binding
   * Updates a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used by the connector and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @param updateConnectorBinding An object describing updates to a connector (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Tool connector was updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to edit this tool connector binding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool or tool connector do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> editToolConnectorBindingWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId, @jakarta.annotation.Nonnull UpdateConnectorBinding updateConnectorBinding) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling editToolConnectorBinding");
    }
    if (bindingId == null) {
      throw new ApiException(400, "Missing the required parameter 'bindingId' when calling editToolConnectorBinding");
    }
    if (updateConnectorBinding == null) {
      throw new ApiException(400, "Missing the required parameter 'updateConnectorBinding' when calling editToolConnectorBinding");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/binding/{binding-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{binding-id}", apiClient.escapeString(bindingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.editToolConnectorBinding", localVarPath, "PATCH", new ArrayList<>(), updateConnectorBinding,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Auto Version Connector
   * Gets an auto version connector.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:view\&quot; permission provided by the Reader role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return GetAutoVersionConnectorResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetAutoVersionConnectorResponse getAutoVersionConnector(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    return getAutoVersionConnectorWithHttpInfo(tool, projectId, projectEntityId, connectionEntityId).getData();
  }

  /**
   * Get Auto Version Connector
   * Gets an auto version connector.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:view\&quot; permission provided by the Reader role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return ApiResponse&lt;GetAutoVersionConnectorResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetAutoVersionConnectorResponse> getAutoVersionConnectorWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getAutoVersionConnector");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAutoVersionConnector");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling getAutoVersionConnector");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling getAutoVersionConnector");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/auto-version-connector/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetAutoVersionConnectorResponse> localVarReturnType = new GenericType<GetAutoVersionConnectorResponse>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getAutoVersionConnector", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
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
    return apiClient.invokeAPI("CentralConfigurationApi.getCentrallyConfiguredToolConnectorConfigurations", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Default Entity
   * Returns the entity default for a tool.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns the id of the default entity </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view default entities </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and integration id were provided, but no data that matches the query exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer getDefaultEntity(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType) throws ApiException {
    return getDefaultEntityWithHttpInfo(tool, entityType).getData();
  }

  /**
   * Get Default Entity
   * Returns the entity default for a tool.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns the id of the default entity </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view default entities </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and integration id were provided, but no data that matches the query exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> getDefaultEntityWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getDefaultEntity");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getDefaultEntity");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/default"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getDefaultEntity", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Entity Defaults For Tool
   * Lists entity defaults for a tool along with the defaults for all projects integrated with this tool.  Requires the \&quot;integrations:schedule:view\&quot; permission. All users have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @return DefaultEntitiesForTool
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an object containing the default entity for the tool and all projects integrated with this tool </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view default entities </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and integration id were provided, but no data that matches the query exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public DefaultEntitiesForTool getEntityDefaultsForTool(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType) throws ApiException {
    return getEntityDefaultsForToolWithHttpInfo(tool, entityType).getData();
  }

  /**
   * Get Entity Defaults For Tool
   * Lists entity defaults for a tool along with the defaults for all projects integrated with this tool.  Requires the \&quot;integrations:schedule:view\&quot; permission. All users have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @return ApiResponse&lt;DefaultEntitiesForTool&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an object containing the default entity for the tool and all projects integrated with this tool </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view default entities </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and integration id were provided, but no data that matches the query exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DefaultEntitiesForTool> getEntityDefaultsForToolWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getEntityDefaultsForTool");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getEntityDefaultsForTool");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/defaults"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<DefaultEntitiesForTool> localVarReturnType = new GenericType<DefaultEntitiesForTool>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getEntityDefaultsForTool", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Integration Entity Dynamic Dropdown Options
   * Get the available options for a new entity.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param fieldName The name of the field (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param apiConfigValues  (optional)
   * @return List&lt;DropdownOption&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of valid options for the entity type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<DropdownOption> getEntityDropdownOptions(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull String fieldName, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    return getEntityDropdownOptionsWithHttpInfo(tool, entityType, fieldName, connectionEntityId, projectEntityId, apiConfigValues).getData();
  }

  /**
   * Get Integration Entity Dynamic Dropdown Options
   * Get the available options for a new entity.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param fieldName The name of the field (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param apiConfigValues  (optional)
   * @return ApiResponse&lt;List&lt;DropdownOption&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of valid options for the entity type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<DropdownOption>> getEntityDropdownOptionsWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull String fieldName, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getEntityDropdownOptions");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getEntityDropdownOptions");
    }
    if (fieldName == null) {
      throw new ApiException(400, "Missing the required parameter 'fieldName' when calling getEntityDropdownOptions");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/form/dropdown-options/{field-name}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{field-name}", apiClient.escapeString(fieldName.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "connectionEntityId", connectionEntityId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "projectEntityId", projectEntityId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<DropdownOption>> localVarReturnType = new GenericType<List<DropdownOption>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getEntityDropdownOptions", localVarPath, "POST", localVarQueryParams, apiConfigValues,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Entity Names From Tool
   * Request the project and/or version names from the tool.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param getEntityNamesFromToolRequest An object containing which names to request, and the connector config to use. (optional)
   * @return GetEntityNamesFromTool200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Entity names </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetEntityNamesFromTool200Response getEntityNamesFromTool(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable GetEntityNamesFromToolRequest getEntityNamesFromToolRequest) throws ApiException {
    return getEntityNamesFromToolWithHttpInfo(tool, getEntityNamesFromToolRequest).getData();
  }

  /**
   * Get Entity Names From Tool
   * Request the project and/or version names from the tool.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param getEntityNamesFromToolRequest An object containing which names to request, and the connector config to use. (optional)
   * @return ApiResponse&lt;GetEntityNamesFromTool200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Entity names </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetEntityNamesFromTool200Response> getEntityNamesFromToolWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable GetEntityNamesFromToolRequest getEntityNamesFromToolRequest) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getEntityNamesFromTool");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/get-names"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetEntityNamesFromTool200Response> localVarReturnType = new GenericType<GetEntityNamesFromTool200Response>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getEntityNamesFromTool", localVarPath, "POST", new ArrayList<>(), getEntityNamesFromToolRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Integration Entity
   * Gets an integration entity.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @return IntegrationEntity
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully looked up </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; IntegrationEntityRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration id, integration entity type, and integration entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public IntegrationEntity getEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    return getEntityTypeWithHttpInfo(tool, entityType, entityId).getData();
  }

  /**
   * Get Integration Entity
   * Gets an integration entity.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @return ApiResponse&lt;IntegrationEntity&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully looked up </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; IntegrationEntityRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration id, integration entity type, and integration entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<IntegrationEntity> getEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getEntityType");
    }
    if (entityId == null) {
      throw new ApiException(400, "Missing the required parameter 'entityId' when calling getEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/{entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{entity-id}", apiClient.escapeString(entityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<IntegrationEntity> localVarReturnType = new GenericType<IntegrationEntity>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getEntityType", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Integration Enabled
   * Allows user to check if a particular integration is enabled.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns true if an integration is enabled or false if the integration is disabled. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the supplied integration does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view integrations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Boolean getIntegrationEnabled(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    return getIntegrationEnabledWithHttpInfo(tool).getData();
  }

  /**
   * Get Integration Enabled
   * Allows user to check if a particular integration is enabled.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return ApiResponse&lt;Boolean&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns true if an integration is enabled or false if the integration is disabled. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the supplied integration does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view integrations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Boolean> getIntegrationEnabledWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getIntegrationEnabled");
    }

    // Path parameters
    String localVarPath = "/x/integrations/{tool}/enabled"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getIntegrationEnabled", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Default Entity
   * Gets the projects default entity for the specified by entity type.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns the projects default entity id </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to access the default entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and project id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer getProjectDefaultEntity(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    return getProjectDefaultEntityWithHttpInfo(tool, entityType, projectId, projectEntityId, connectionEntityId).getData();
  }

  /**
   * Get Project Default Entity
   * Gets the projects default entity for the specified by entity type.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns the projects default entity id </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to access the default entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and project id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> getProjectDefaultEntityWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getProjectDefaultEntity");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getProjectDefaultEntity");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectDefaultEntity");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling getProjectDefaultEntity");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling getProjectDefaultEntity");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}/default"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getProjectDefaultEntity", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check Project Enumeration Support
   * Check to see if a particular tool supports project enumeration.  No special permissions are required.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityIds  (optional)
   * @return GetProjectEnumerationSupport200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns true or false depending on if the tool supports project enumeration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetProjectEnumerationSupport200Response getProjectEnumerationSupport(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> connectionEntityIds) throws ApiException {
    return getProjectEnumerationSupportWithHttpInfo(tool, connectionEntityIds).getData();
  }

  /**
   * Check Project Enumeration Support
   * Check to see if a particular tool supports project enumeration.  No special permissions are required.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityIds  (optional)
   * @return ApiResponse&lt;GetProjectEnumerationSupport200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns true or false depending on if the tool supports project enumeration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetProjectEnumerationSupport200Response> getProjectEnumerationSupportWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> connectionEntityIds) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getProjectEnumerationSupport");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/project-import-support"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("multi", "connectionEntityIds", connectionEntityIds)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetProjectEnumerationSupport200Response> localVarReturnType = new GenericType<GetProjectEnumerationSupport200Response>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getProjectEnumerationSupport", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check Project Name Sync Support
   * Check to see if a particular tool supports project name sync. The request body may be omitted if the tool does not have _conditional_ project name sync support. If the request body is omitted and the tool does have conditional support, the response will omit the &#x60;supported&#x60; field.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used, if any.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param apiConfigValues  (optional)
   * @return GetProjectNameSyncSupport200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project name sync support </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetProjectNameSyncSupport200Response getProjectNameSyncSupport(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    return getProjectNameSyncSupportWithHttpInfo(tool, apiConfigValues).getData();
  }

  /**
   * Check Project Name Sync Support
   * Check to see if a particular tool supports project name sync. The request body may be omitted if the tool does not have _conditional_ project name sync support. If the request body is omitted and the tool does have conditional support, the response will omit the &#x60;supported&#x60; field.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used, if any.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param apiConfigValues  (optional)
   * @return ApiResponse&lt;GetProjectNameSyncSupport200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project name sync support </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetProjectNameSyncSupport200Response> getProjectNameSyncSupportWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getProjectNameSyncSupport");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/project-name-sync-support"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetProjectNameSyncSupport200Response> localVarReturnType = new GenericType<GetProjectNameSyncSupport200Response>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getProjectNameSyncSupport", localVarPath, "POST", new ArrayList<>(), apiConfigValues,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Tool Default Schedule
   * Get the default schedule for a tool and project. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule ID </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool was not found, or their isn&#39;t a default schedule. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer getProjectToolDefaultSchedule(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    return getProjectToolDefaultScheduleWithHttpInfo(tool, projectId, projectEntityId, connectionEntityId).getData();
  }

  /**
   * Get Project Tool Default Schedule
   * Get the default schedule for a tool and project. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule ID </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool was not found, or their isn&#39;t a default schedule. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> getProjectToolDefaultScheduleWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getProjectToolDefaultSchedule");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectToolDefaultSchedule");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling getProjectToolDefaultSchedule");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling getProjectToolDefaultSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/default/{tool}/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getProjectToolDefaultSchedule", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Available Projects From Integrations
   * Enumerates projects from a specific tool connector using a list of connection entity IDs. Defaults to all entity IDs if the &#x60;connectionIds&#x60; query param is not specified or empty.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection(s) being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityIds  (optional)
   * @param parentMapping Whether or not parent project mapping should be enabled. Only supported for some tools. Support can be determined from the &#x60;Check Project Enumeration Support&#x60; response. (optional)
   * @return List&lt;JobIdResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a Job ID for monitoring progress and fetching results. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to import projects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<JobIdResponse> getProjectsFromIntegration(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> connectionEntityIds, @jakarta.annotation.Nullable Boolean parentMapping) throws ApiException {
    return getProjectsFromIntegrationWithHttpInfo(tool, connectionEntityIds, parentMapping).getData();
  }

  /**
   * Get Available Projects From Integrations
   * Enumerates projects from a specific tool connector using a list of connection entity IDs. Defaults to all entity IDs if the &#x60;connectionIds&#x60; query param is not specified or empty.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection(s) being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityIds  (optional)
   * @param parentMapping Whether or not parent project mapping should be enabled. Only supported for some tools. Support can be determined from the &#x60;Check Project Enumeration Support&#x60; response. (optional)
   * @return ApiResponse&lt;List&lt;JobIdResponse&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a Job ID for monitoring progress and fetching results. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to import projects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<JobIdResponse>> getProjectsFromIntegrationWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> connectionEntityIds, @jakarta.annotation.Nullable Boolean parentMapping) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getProjectsFromIntegration");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/project-import"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("multi", "connectionEntityIds", connectionEntityIds)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parentMapping", parentMapping));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<JobIdResponse>> localVarReturnType = new GenericType<List<JobIdResponse>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getProjectsFromIntegration", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Schedule
   * Get a specific schedule. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param scheduleId The ID of the schedule. (required)
   * @param tool The name of a tool, if included the response data will include information about whether a schedule is configured to be the default for a tool (optional)
   * @return List&lt;ToolConfigScheduleRef&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ToolConfigScheduleRef> getSchedule(@jakarta.annotation.Nonnull Integer scheduleId, @jakarta.annotation.Nullable String tool) throws ApiException {
    return getScheduleWithHttpInfo(scheduleId, tool).getData();
  }

  /**
   * Get Schedule
   * Get a specific schedule. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param scheduleId The ID of the schedule. (required)
   * @param tool The name of a tool, if included the response data will include information about whether a schedule is configured to be the default for a tool (optional)
   * @return ApiResponse&lt;List&lt;ToolConfigScheduleRef&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ToolConfigScheduleRef>> getScheduleWithHttpInfo(@jakarta.annotation.Nonnull Integer scheduleId, @jakarta.annotation.Nullable String tool) throws ApiException {
    // Check required parameters
    if (scheduleId == null) {
      throw new ApiException(400, "Missing the required parameter 'scheduleId' when calling getSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/{schedule-id}"
            .replaceAll("\\{schedule-id}", apiClient.escapeString(scheduleId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "tool", tool)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ToolConfigScheduleRef>> localVarReturnType = new GenericType<List<ToolConfigScheduleRef>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getSchedule", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Tool Connector Binding
   * Gets a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used by the connector and the \&quot;project:view\&quot; permission provided by the Reader role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @return ToolConnectorStaticBinding
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns the tool connector binding </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to access this tool connector binding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool or tool connector do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ToolConnectorStaticBinding getToolConnectorBinding(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId) throws ApiException {
    return getToolConnectorBindingWithHttpInfo(tool, bindingId).getData();
  }

  /**
   * Get Tool Connector Binding
   * Gets a tool connector binding.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used by the connector and the \&quot;project:view\&quot; permission provided by the Reader role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @return ApiResponse&lt;ToolConnectorStaticBinding&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns the tool connector binding </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to access this tool connector binding </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool or tool connector do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ToolConnectorStaticBinding> getToolConnectorBindingWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getToolConnectorBinding");
    }
    if (bindingId == null) {
      throw new ApiException(400, "Missing the required parameter 'bindingId' when calling getToolConnectorBinding");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/binding/{binding-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{binding-id}", apiClient.escapeString(bindingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ToolConnectorStaticBinding> localVarReturnType = new GenericType<ToolConnectorStaticBinding>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getToolConnectorBinding", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Tool Connector Config Form
   * Get the configuration for for a specific tool and entity type.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @return List&lt;FormSpecifierInner&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a Form Specifier </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<FormSpecifierInner> getToolConnectorCentralConfigForm(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId) throws ApiException {
    return getToolConnectorCentralConfigFormWithHttpInfo(tool, entityType, connectionEntityId, projectEntityId).getData();
  }

  /**
   * Get Tool Connector Config Form
   * Get the configuration for for a specific tool and entity type.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @return ApiResponse&lt;List&lt;FormSpecifierInner&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a Form Specifier </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<FormSpecifierInner>> getToolConnectorCentralConfigFormWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getToolConnectorCentralConfigForm");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getToolConnectorCentralConfigForm");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/form"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "connectionEntityId", connectionEntityId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "projectEntityId", projectEntityId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<FormSpecifierInner>> localVarReturnType = new GenericType<List<FormSpecifierInner>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getToolConnectorCentralConfigForm", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Tool Default Schedule
   * Get the default schedule for a tool. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool was not found, or the tool does not have a default schedule. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer getToolDefaultSchedule(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    return getToolDefaultScheduleWithHttpInfo(tool).getData();
  }

  /**
   * Get Tool Default Schedule
   * Get the default schedule for a tool. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Schedule </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the tool was not found, or the tool does not have a default schedule. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> getToolDefaultScheduleWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getToolDefaultSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/default/{tool}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getToolDefaultSchedule", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Default Schedules
   * Get the global, tool, and project default schedules for a tool. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return DefaultSchedulesForTool
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Default global, tool, and project schedules </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool not found. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public DefaultSchedulesForTool getToolDefaultSchedules(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    return getToolDefaultSchedulesWithHttpInfo(tool).getData();
  }

  /**
   * Get Default Schedules
   * Get the global, tool, and project default schedules for a tool. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return ApiResponse&lt;DefaultSchedulesForTool&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Default global, tool, and project schedules </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool not found. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DefaultSchedulesForTool> getToolDefaultSchedulesWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getToolDefaultSchedules");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/defaults/{tool}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<DefaultSchedulesForTool> localVarReturnType = new GenericType<DefaultSchedulesForTool>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getToolDefaultSchedules", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List User Group Integration Entity Roles
   * Gets the integration entity roles for multiple user groups for an integration entity.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @return List&lt;UserIntegrationEntityRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserIntegrationEntityRole> getUserGroupRolesForEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    return getUserGroupRolesForEntityTypeWithHttpInfo(tool, entityType, entityId).getData();
  }

  /**
   * List User Group Integration Entity Roles
   * Gets the integration entity roles for multiple user groups for an integration entity.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @return ApiResponse&lt;List&lt;UserIntegrationEntityRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserIntegrationEntityRole>> getUserGroupRolesForEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getUserGroupRolesForEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getUserGroupRolesForEntityType");
    }
    if (entityId == null) {
      throw new ApiException(400, "Missing the required parameter 'entityId' when calling getUserGroupRolesForEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/{entity-id}/roles/user-groups"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{entity-id}", apiClient.escapeString(entityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserIntegrationEntityRole>> localVarReturnType = new GenericType<List<UserIntegrationEntityRole>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getUserGroupRolesForEntityType", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List User Integration Entity Roles
   * Gets the integration entity roles for multiple users for an integration entity.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @return List&lt;UserIntegrationEntityRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserIntegrationEntityRole> getUserRolesForEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    return getUserRolesForEntityTypeWithHttpInfo(tool, entityType, entityId).getData();
  }

  /**
   * List User Integration Entity Roles
   * Gets the integration entity roles for multiple users for an integration entity.  Requires the \&quot;integrations:view\&quot; permission (available on all roles) or \&quot;integrations:tool-configuration:view\&quot; permission (\&quot;Entity Viewer\&quot; role) if looking at non Option entities.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @return ApiResponse&lt;List&lt;UserIntegrationEntityRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserIntegrationEntityRole>> getUserRolesForEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getUserRolesForEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling getUserRolesForEntityType");
    }
    if (entityId == null) {
      throw new ApiException(400, "Missing the required parameter 'entityId' when calling getUserRolesForEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/{entity-id}/roles/users"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{entity-id}", apiClient.escapeString(entityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserIntegrationEntityRole>> localVarReturnType = new GenericType<List<UserIntegrationEntityRole>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getUserRolesForEntityType", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check Version Enumeration Support
   * Check to see if a particular tool supports version enumeration.  No special permissions are required.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityIds  (optional)
   * @return Boolean
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns true or false depending on if the tool supports version enumeration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Boolean getVersionEnumerationSupport(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> connectionEntityIds) throws ApiException {
    return getVersionEnumerationSupportWithHttpInfo(tool, connectionEntityIds).getData();
  }

  /**
   * Check Version Enumeration Support
   * Check to see if a particular tool supports version enumeration.  No special permissions are required.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityIds  (optional)
   * @return ApiResponse&lt;Boolean&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns true or false depending on if the tool supports version enumeration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Boolean> getVersionEnumerationSupportWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> connectionEntityIds) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getVersionEnumerationSupport");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/version-import-support"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("multi", "connectionEntityIds", connectionEntityIds)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getVersionEnumerationSupport", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check Version Name Sync Support
   * Check to see if a particular tool supports version name sync. The request body may be omitted if the tool does not have _conditional_ version name sync support. If the request body is omitted and the tool does have conditional support, the response will omit the &#x60;supported&#x60; field.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used, if any.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param apiConfigValues  (optional)
   * @return GetVersionNameSyncSupport200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Version name sync support </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetVersionNameSyncSupport200Response getVersionNameSyncSupport(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    return getVersionNameSyncSupportWithHttpInfo(tool, apiConfigValues).getData();
  }

  /**
   * Check Version Name Sync Support
   * Check to see if a particular tool supports version name sync. The request body may be omitted if the tool does not have _conditional_ version name sync support. If the request body is omitted and the tool does have conditional support, the response will omit the &#x60;supported&#x60; field.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used, if any.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param apiConfigValues  (optional)
   * @return ApiResponse&lt;GetVersionNameSyncSupport200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Version name sync support </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetVersionNameSyncSupport200Response> getVersionNameSyncSupportWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getVersionNameSyncSupport");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/version-name-sync-support"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetVersionNameSyncSupport200Response> localVarReturnType = new GenericType<GetVersionNameSyncSupport200Response>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getVersionNameSyncSupport", localVarPath, "POST", new ArrayList<>(), apiConfigValues,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Available Version From Integrations
   * Enumerates versions from a specific tool connector using a connection entity ID and project entity ID.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @return List&lt;CreateNewEntity&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of objects that can be used to create new version entities by using the &#39;Import Projects From Integration&#39; or &#39;Create Versions From Integration&#39; endpoints. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to get available versions </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<CreateNewEntity> getVersionsFromIntegration(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId) throws ApiException {
    return getVersionsFromIntegrationWithHttpInfo(tool, connectionEntityId, projectEntityId).getData();
  }

  /**
   * Get Available Version From Integrations
   * Enumerates versions from a specific tool connector using a connection entity ID and project entity ID.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @return ApiResponse&lt;List&lt;CreateNewEntity&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of objects that can be used to create new version entities by using the &#39;Import Projects From Integration&#39; or &#39;Create Versions From Integration&#39; endpoints. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to get available versions </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<CreateNewEntity>> getVersionsFromIntegrationWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling getVersionsFromIntegration");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/version-import"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "connectionEntityId", connectionEntityId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "projectEntityId", projectEntityId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<CreateNewEntity>> localVarReturnType = new GenericType<List<CreateNewEntity>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.getVersionsFromIntegration", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Import Projects From Integration
   * Performs batch-create of projects, integration entities, and tool connectors, based on the provided JSON (which is expected to be built from the output of &#x60;Get Available Projects From Integrations&#x60;, but this isn&#39;t strictly required.) When creating new projects, the default branch will be set to the SRM default unless  all version entities specify the same name. in that case, that common name will be the default branch. Validation tokens for new config entities should be contextualized with the connection entity.  Requires either the \&quot;project:create\&quot; permission provided by the Project Admin role if new projects are to be created.  Requires the \&quot;project:manager-tool-connectors\&quot; permission provided by the Manager role if using existing projects.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection(s) being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param importProjectsFromIntegration  (optional)
   * @return List&lt;NewImportedBinding&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Projects have been imported and bindings have been created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to import projects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<NewImportedBinding> importProjectsFromIntegration(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<ImportProjectsFromIntegration> importProjectsFromIntegration) throws ApiException {
    return importProjectsFromIntegrationWithHttpInfo(tool, importProjectsFromIntegration).getData();
  }

  /**
   * Import Projects From Integration
   * Performs batch-create of projects, integration entities, and tool connectors, based on the provided JSON (which is expected to be built from the output of &#x60;Get Available Projects From Integrations&#x60;, but this isn&#39;t strictly required.) When creating new projects, the default branch will be set to the SRM default unless  all version entities specify the same name. in that case, that common name will be the default branch. Validation tokens for new config entities should be contextualized with the connection entity.  Requires either the \&quot;project:create\&quot; permission provided by the Project Admin role if new projects are to be created.  Requires the \&quot;project:manager-tool-connectors\&quot; permission provided by the Manager role if using existing projects.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection(s) being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param importProjectsFromIntegration  (optional)
   * @return ApiResponse&lt;List&lt;NewImportedBinding&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Projects have been imported and bindings have been created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to import projects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration was provided but it does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<NewImportedBinding>> importProjectsFromIntegrationWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<ImportProjectsFromIntegration> importProjectsFromIntegration) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling importProjectsFromIntegration");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/project-import"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<NewImportedBinding>> localVarReturnType = new GenericType<List<NewImportedBinding>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.importProjectsFromIntegration", localVarPath, "POST", new ArrayList<>(), importProjectsFromIntegration,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Integration Entities
   * List an integration&#39;s entities.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @return List&lt;EntityRef&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of entities </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for an integration was provided, but no integration with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<EntityRef> listEntities(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType) throws ApiException {
    return listEntitiesWithHttpInfo(tool, entityType).getData();
  }

  /**
   * List Integration Entities
   * List an integration&#39;s entities.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @return ApiResponse&lt;List&lt;EntityRef&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of entities </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for an integration was provided, but no integration with that id exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<EntityRef>> listEntitiesWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling listEntities");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling listEntities");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<EntityRef>> localVarReturnType = new GenericType<List<EntityRef>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.listEntities", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Integrations
   * List all available integrations.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @return AllIntegrations
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an object where each property is a list of a specific type of integration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view integrations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AllIntegrations listIntegrations() throws ApiException {
    return listIntegrationsWithHttpInfo().getData();
  }

  /**
   * List Integrations
   * List all available integrations.  Requires the \&quot;integrations:view\&quot; permission, all roles have this permission.
   * @return ApiResponse&lt;AllIntegrations&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an object where each property is a list of a specific type of integration </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view integrations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AllIntegrations> listIntegrationsWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AllIntegrations> localVarReturnType = new GenericType<AllIntegrations>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.listIntegrations", "/x/integrations", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Schedules
   * Lists all schedule available for central configuration. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The name of a tool, if included the response data will include information about whether a schedule is configured to be the default for a tool (optional)
   * @return List&lt;ToolConfigScheduleRef&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - List of schedules </td><td>  -  </td></tr>
     </table>
   */
  public List<ToolConfigScheduleRef> listSchedules(@jakarta.annotation.Nullable String tool) throws ApiException {
    return listSchedulesWithHttpInfo(tool).getData();
  }

  /**
   * List Schedules
   * Lists all schedule available for central configuration. Requires the \&quot;integrations:schedule:view\&quot; permission.
   * @param tool The name of a tool, if included the response data will include information about whether a schedule is configured to be the default for a tool (optional)
   * @return ApiResponse&lt;List&lt;ToolConfigScheduleRef&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - List of schedules </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ToolConfigScheduleRef>> listSchedulesWithHttpInfo(@jakarta.annotation.Nullable String tool) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "tool", tool)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ToolConfigScheduleRef>> localVarReturnType = new GenericType<List<ToolConfigScheduleRef>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.listSchedules", "/x/integrations/schedule", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Tool Connector Bindings
   * Lists tool connector bindings for a given tool.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission on some Connections and the \&quot;project:view\&quot; permission provided by the Reader role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return List&lt;ToolConnectorBinding&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ToolConnectorBinding> listToolConnectorBindings(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    return listToolConnectorBindingsWithHttpInfo(tool).getData();
  }

  /**
   * List Tool Connector Bindings
   * Lists tool connector bindings for a given tool.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission on some Connections and the \&quot;project:view\&quot; permission provided by the Reader role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return ApiResponse&lt;List&lt;ToolConnectorBinding&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of tool connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ToolConnectorBinding>> listToolConnectorBindingsWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling listToolConnectorBindings");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/binding"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ToolConnectorBinding>> localVarReturnType = new GenericType<List<ToolConnectorBinding>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.listToolConnectorBindings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Remove Project Tool Default Schedule
   * Removes the default schedule for a tool and project. Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default schedule removed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool not found or there isn&#39;t a default schedule. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void removeProjectToolDefaultSchedule(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    removeProjectToolDefaultScheduleWithHttpInfo(tool, projectId, projectEntityId, connectionEntityId);
  }

  /**
   * Remove Project Tool Default Schedule
   * Removes the default schedule for a tool and project. Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default schedule removed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool not found or there isn&#39;t a default schedule. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> removeProjectToolDefaultScheduleWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling removeProjectToolDefaultSchedule");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling removeProjectToolDefaultSchedule");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling removeProjectToolDefaultSchedule");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling removeProjectToolDefaultSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/default/{tool}/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.removeProjectToolDefaultSchedule", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Remove Tool Default Schedule
   * Removes the default schedule for a tool. Requires the \&quot;integrations:schedule:delete\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default schedule removed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool not found or tool does not have a default schedule </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void removeToolDefaultSchedule(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    removeToolDefaultScheduleWithHttpInfo(tool);
  }

  /**
   * Remove Tool Default Schedule
   * Removes the default schedule for a tool. Requires the \&quot;integrations:schedule:delete\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default schedule removed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Tool not found or tool does not have a default schedule </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> removeToolDefaultScheduleWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling removeToolDefaultSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/default/{tool}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.removeToolDefaultSchedule", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Bulk Entity Defaults
   * Sets default entities for projects in bulk.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param setBulkDefaultEntity  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project default entity was set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to set the default entities for one or more projects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setBulkEntityDefaults(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable SetBulkDefaultEntity setBulkDefaultEntity) throws ApiException {
    setBulkEntityDefaultsWithHttpInfo(tool, entityType, setBulkDefaultEntity);
  }

  /**
   * Set Bulk Entity Defaults
   * Sets default entities for projects in bulk.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param setBulkDefaultEntity  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project default entity was set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to set the default entities for one or more projects </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setBulkEntityDefaultsWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable SetBulkDefaultEntity setBulkDefaultEntity) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling setBulkEntityDefaults");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling setBulkEntityDefaults");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/defaults"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setBulkEntityDefaults", localVarPath, "PUT", new ArrayList<>(), setBulkDefaultEntity,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Default Entity
   * Sets default entity for a tool.  Requires the \&quot;integrations:tool-configuration:edit\&quot; permission provided by the Entity Editor role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Default entity was set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to set the default entity for this integration </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setDefaultEntity(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable Integer body) throws ApiException {
    setDefaultEntityWithHttpInfo(tool, entityType, body);
  }

  /**
   * Set Default Entity
   * Sets default entity for a tool.  Requires the \&quot;integrations:tool-configuration:edit\&quot; permission provided by the Entity Editor role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param body  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Default entity was set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to set the default entity for this integration </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setDefaultEntityWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable Integer body) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling setDefaultEntity");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling setDefaultEntity");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/default"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setDefaultEntity", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Global Default Schedule
   * Sets a schedule as the global default schedule. Requires the \&quot;integrations:schedule:edit\&quot; permission.
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Global default schedule set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setGlobalDefaultSchedule(@jakarta.annotation.Nullable Integer body) throws ApiException {
    setGlobalDefaultScheduleWithHttpInfo(body);
  }

  /**
   * Set Global Default Schedule
   * Sets a schedule as the global default schedule. Requires the \&quot;integrations:schedule:edit\&quot; permission.
   * @param body  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Global default schedule set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setGlobalDefaultScheduleWithHttpInfo(@jakarta.annotation.Nullable Integer body) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setGlobalDefaultSchedule", "/x/integrations/schedule/default", "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Integration Enabled
   * Allows user to enable or disable an integration.  Requires the \&quot;integrations:set-enabled\&quot; permission which is provided by the \&quot;Integrations Admin\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The integration&#39;s enabled state has been set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the supplied integration does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to enabled or disable integrations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setIntegrationEnabled(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable Boolean body) throws ApiException {
    setIntegrationEnabledWithHttpInfo(tool, body);
  }

  /**
   * Set Integration Enabled
   * Allows user to enable or disable an integration.  Requires the \&quot;integrations:set-enabled\&quot; permission which is provided by the \&quot;Integrations Admin\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param body  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The integration&#39;s enabled state has been set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the supplied integration does not exist. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to enabled or disable integrations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setIntegrationEnabledWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable Boolean body) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling setIntegrationEnabled");
    }

    // Path parameters
    String localVarPath = "/x/integrations/{tool}/enabled"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setIntegrationEnabled", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Project Default Entity
   * Sets the projects default entity for the specified by entity type.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project default entity was set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to set the default entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and project id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setProjectDefaultEntity(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nullable Integer body) throws ApiException {
    setProjectDefaultEntityWithHttpInfo(tool, entityType, projectId, projectEntityId, connectionEntityId, body);
  }

  /**
   * Set Project Default Entity
   * Sets the projects default entity for the specified by entity type.  Requires the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param body  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Project default entity was set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to set the default entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration entity type, and project id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setProjectDefaultEntityWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nullable Integer body) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling setProjectDefaultEntity");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling setProjectDefaultEntity");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setProjectDefaultEntity");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling setProjectDefaultEntity");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling setProjectDefaultEntity");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}/default"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setProjectDefaultEntity", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Project Entity Name Override
   * Sets name override or sync setting for bindings with the given project, project entity, and connection entity.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection and project entities being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param setProjectEntityNameOverrideRequest An object describing how to update the project entity name settings. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - project entity name override set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setProjectEntityNameOverride(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nonnull SetProjectEntityNameOverrideRequest setProjectEntityNameOverrideRequest) throws ApiException {
    setProjectEntityNameOverrideWithHttpInfo(tool, projectId, projectEntityId, connectionEntityId, setProjectEntityNameOverrideRequest);
  }

  /**
   * Set Project Entity Name Override
   * Sets name override or sync setting for bindings with the given project, project entity, and connection entity.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection and project entities being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param setProjectEntityNameOverrideRequest An object describing how to update the project entity name settings. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - project entity name override set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view configurations </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setProjectEntityNameOverrideWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nonnull SetProjectEntityNameOverrideRequest setProjectEntityNameOverrideRequest) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling setProjectEntityNameOverride");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setProjectEntityNameOverride");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling setProjectEntityNameOverride");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling setProjectEntityNameOverride");
    }
    if (setProjectEntityNameOverrideRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'setProjectEntityNameOverrideRequest' when calling setProjectEntityNameOverride");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}/project-entity-name"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setProjectEntityNameOverride", localVarPath, "PUT", new ArrayList<>(), setProjectEntityNameOverrideRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Project Tool Default Schedule
   * Set the default schedule for a tool and project. Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default tool schedule updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either project, tool, or schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setProjectToolDefaultSchedule(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nullable Integer body) throws ApiException {
    setProjectToolDefaultScheduleWithHttpInfo(tool, projectId, projectEntityId, connectionEntityId, body);
  }

  /**
   * Set Project Tool Default Schedule
   * Set the default schedule for a tool and project. Requires the \&quot;project:manage-tool-connectors\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param body  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default tool schedule updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either project, tool, or schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setProjectToolDefaultScheduleWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nullable Integer body) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling setProjectToolDefaultSchedule");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setProjectToolDefaultSchedule");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling setProjectToolDefaultSchedule");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling setProjectToolDefaultSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/default/{tool}/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setProjectToolDefaultSchedule", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set Tool Default Schedule
   * Set the default schedule for a tool. Requires the \&quot;integrations:schedule:edit\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default tool schedule updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either tool or schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setToolDefaultSchedule(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable Integer body) throws ApiException {
    setToolDefaultScheduleWithHttpInfo(tool, body);
  }

  /**
   * Set Tool Default Schedule
   * Set the default schedule for a tool. Requires the \&quot;integrations:schedule:edit\&quot; permission.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param body  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Default tool schedule updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either tool or schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setToolDefaultScheduleWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable Integer body) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling setToolDefaultSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/default/{tool}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.setToolDefaultSchedule", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Run Bulk Connectors
   * Run multiple integration connector analyses.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connections being used by the connectors and the \&quot;analysis:create\&quot; permission provided by the Creator role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param requestBody  (optional)
   * @return List&lt;ConnectorAnalysisJob&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Analyses have been queued. The response objects is a list of Analysis IDs and Job IDs </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to run these connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and bindings were provided, but either the integration or the bindings do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<ConnectorAnalysisJob> startBulkConnectors(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> requestBody) throws ApiException {
    return startBulkConnectorsWithHttpInfo(tool, requestBody).getData();
  }

  /**
   * Run Bulk Connectors
   * Run multiple integration connector analyses.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connections being used by the connectors and the \&quot;analysis:create\&quot; permission provided by the Creator role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param requestBody  (optional)
   * @return ApiResponse&lt;List&lt;ConnectorAnalysisJob&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Analyses have been queued. The response objects is a list of Analysis IDs and Job IDs </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to run these connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and bindings were provided, but either the integration or the bindings do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ConnectorAnalysisJob>> startBulkConnectorsWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nullable List<Integer> requestBody) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling startBulkConnectors");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/analysis"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<ConnectorAnalysisJob>> localVarReturnType = new GenericType<List<ConnectorAnalysisJob>>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.startBulkConnectors", localVarPath, "POST", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Run Connector Analysis
   * Run integration connector analysis.  Requires the \&quot;analysis:create\&quot; permission (provided by the Creator role) for the associated project.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @return ConnectorAnalysisJob
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Analyses have been queued. The response objects is a list of Analysis IDs and Job IDs </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to run this connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and bindings were provided, but either the integration or the binding do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ConnectorAnalysisJob startConnector(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId) throws ApiException {
    return startConnectorWithHttpInfo(tool, bindingId).getData();
  }

  /**
   * Run Connector Analysis
   * Run integration connector analysis.  Requires the \&quot;analysis:create\&quot; permission (provided by the Creator role) for the associated project.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param bindingId The id of a tool connector binding (required)
   * @return ApiResponse&lt;ConnectorAnalysisJob&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Analyses have been queued. The response objects is a list of Analysis IDs and Job IDs </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to run this connector bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and bindings were provided, but either the integration or the binding do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ConnectorAnalysisJob> startConnectorWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer bindingId) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling startConnector");
    }
    if (bindingId == null) {
      throw new ApiException(400, "Missing the required parameter 'bindingId' when calling startConnector");
    }

    // Path parameters
    String localVarPath = "/api/integrations/tool-connector/{tool}/binding/{binding-id}/analysis"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{binding-id}", apiClient.escapeString(bindingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ConnectorAnalysisJob> localVarReturnType = new GenericType<ConnectorAnalysisJob>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.startConnector", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update Auto Version Connector
   * Updates an auto version connector.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param updateAutoVersionConnectorRequest An object describing how to update the settings of the auto version connector. (required)
   * @return GetAutoVersionConnectorResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Auto version connector does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetAutoVersionConnectorResponse updateAutoVersionConnector(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nonnull UpdateAutoVersionConnectorRequest updateAutoVersionConnectorRequest) throws ApiException {
    return updateAutoVersionConnectorWithHttpInfo(tool, projectId, projectEntityId, connectionEntityId, updateAutoVersionConnectorRequest).getData();
  }

  /**
   * Update Auto Version Connector
   * Updates an auto version connector.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connection being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param projectId The ID of the project. (required)
   * @param projectEntityId The ID of the project integration entity (required)
   * @param connectionEntityId The ID of the connection integration entity (required)
   * @param updateAutoVersionConnectorRequest An object describing how to update the settings of the auto version connector. (required)
   * @return ApiResponse&lt;GetAutoVersionConnectorResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Auto version connector does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetAutoVersionConnectorResponse> updateAutoVersionConnectorWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer projectEntityId, @jakarta.annotation.Nonnull Integer connectionEntityId, @jakarta.annotation.Nonnull UpdateAutoVersionConnectorRequest updateAutoVersionConnectorRequest) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling updateAutoVersionConnector");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateAutoVersionConnector");
    }
    if (projectEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectEntityId' when calling updateAutoVersionConnector");
    }
    if (connectionEntityId == null) {
      throw new ApiException(400, "Missing the required parameter 'connectionEntityId' when calling updateAutoVersionConnector");
    }
    if (updateAutoVersionConnectorRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'updateAutoVersionConnectorRequest' when calling updateAutoVersionConnector");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/auto-version-connector/project/{project-id}/project-entity/{project-entity-id}/connection-entity/{connection-entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{project-entity-id}", apiClient.escapeString(projectEntityId.toString()))
            .replaceAll("\\{connection-entity-id}", apiClient.escapeString(connectionEntityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetAutoVersionConnectorResponse> localVarReturnType = new GenericType<GetAutoVersionConnectorResponse>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.updateAutoVersionConnector", localVarPath, "PUT", new ArrayList<>(), updateAutoVersionConnectorRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update Bulk Connector Bindings
   * Updates connector bindings in bulk.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connections being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role on all projects being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param updateBulkConnectorBinding An object describing which connectors to update and how they should be updated (required)
   * @return Integer
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Bindings were successfully updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to update one or more of the provided bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - One or more supplied data values do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Integer updateBulkConnectorBindings(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull UpdateBulkConnectorBinding updateBulkConnectorBinding) throws ApiException {
    return updateBulkConnectorBindingsWithHttpInfo(tool, updateBulkConnectorBinding).getData();
  }

  /**
   * Update Bulk Connector Bindings
   * Updates connector bindings in bulk.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instanced to the connections being used and the \&quot;project:manage-tool-connectors\&quot; permission provided by the Manager role on all projects being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param updateBulkConnectorBinding An object describing which connectors to update and how they should be updated (required)
   * @return ApiResponse&lt;Integer&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Bindings were successfully updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to update one or more of the provided bindings </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - One or more supplied data values do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Integer> updateBulkConnectorBindingsWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull UpdateBulkConnectorBinding updateBulkConnectorBinding) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling updateBulkConnectorBindings");
    }
    if (updateBulkConnectorBinding == null) {
      throw new ApiException(400, "Missing the required parameter 'updateBulkConnectorBinding' when calling updateBulkConnectorBindings");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/bindings"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.updateBulkConnectorBindings", localVarPath, "PATCH", new ArrayList<>(), updateBulkConnectorBinding,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update Integration Entity
   * Updates an integration entity.  Requires the \&quot;integrations:tool-configuration:edit\&quot; permission which is provided by the \&quot;Entity Editor\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @param integrationEntityDefinition  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration id, integration entity type, and integration entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId, @jakarta.annotation.Nullable IntegrationEntityDefinition integrationEntityDefinition) throws ApiException {
    updateEntityTypeWithHttpInfo(tool, entityType, entityId, integrationEntityDefinition);
  }

  /**
   * Update Integration Entity
   * Updates an integration entity.  Requires the \&quot;integrations:tool-configuration:edit\&quot; permission which is provided by the \&quot;Entity Editor\&quot; role.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @param integrationEntityDefinition  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration entity was successfully updated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration id, integration entity type, and integration entity id for an integration entity were provided, but no integration entity with that data exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId, @jakarta.annotation.Nullable IntegrationEntityDefinition integrationEntityDefinition) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling updateEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling updateEntityType");
    }
    if (entityId == null) {
      throw new ApiException(400, "Missing the required parameter 'entityId' when calling updateEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/{entity-id}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{entity-id}", apiClient.escapeString(entityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.updateEntityType", localVarPath, "PUT", new ArrayList<>(), integrationEntityDefinition,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update Schedule
   * Update a specific schedule. Requires the \&quot;integrations:schedule:edit\&quot; permission.
   * @param scheduleId The ID of the schedule. (required)
   * @param toolConfigSchedule  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Schedule updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Expected at least one of &#39;name&#39;, &#39;interval&#39;, or &#39;runDuringAnalysis&#39; in the request body </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateSchedule(@jakarta.annotation.Nonnull Integer scheduleId, @jakarta.annotation.Nullable ToolConfigSchedule toolConfigSchedule) throws ApiException {
    updateScheduleWithHttpInfo(scheduleId, toolConfigSchedule);
  }

  /**
   * Update Schedule
   * Update a specific schedule. Requires the \&quot;integrations:schedule:edit\&quot; permission.
   * @param scheduleId The ID of the schedule. (required)
   * @param toolConfigSchedule  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No content - Schedule updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Expected at least one of &#39;name&#39;, &#39;interval&#39;, or &#39;runDuringAnalysis&#39; in the request body </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Schedule not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateScheduleWithHttpInfo(@jakarta.annotation.Nonnull Integer scheduleId, @jakarta.annotation.Nullable ToolConfigSchedule toolConfigSchedule) throws ApiException {
    // Check required parameters
    if (scheduleId == null) {
      throw new ApiException(400, "Missing the required parameter 'scheduleId' when calling updateSchedule");
    }

    // Path parameters
    String localVarPath = "/x/integrations/schedule/{schedule-id}"
            .replaceAll("\\{schedule-id}", apiClient.escapeString(scheduleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.updateSchedule", localVarPath, "PUT", new ArrayList<>(), toolConfigSchedule,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set User Group Integration Entity Roles
   * Sets the integration entity roles for multiple user groups for an integration entity.  Requires the \&quot;edit\&quot; IntegrationEntityRole for that integration entity.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @param requestBody An object describing the requested new role for each user group to be changed. Note that there is no need to include user groups that you don&#39;t want to change. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration Entity roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole for the requested integration entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity or one of the specified user groups does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserGroupRolesForEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId, @jakarta.annotation.Nonnull Map<String, IntegrationEntityRole> requestBody) throws ApiException {
    updateUserGroupRolesForEntityTypeWithHttpInfo(tool, entityType, entityId, requestBody);
  }

  /**
   * Set User Group Integration Entity Roles
   * Sets the integration entity roles for multiple user groups for an integration entity.  Requires the \&quot;edit\&quot; IntegrationEntityRole for that integration entity.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @param requestBody An object describing the requested new role for each user group to be changed. Note that there is no need to include user groups that you don&#39;t want to change. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration Entity roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole for the requested integration entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity or one of the specified user groups does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserGroupRolesForEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId, @jakarta.annotation.Nonnull Map<String, IntegrationEntityRole> requestBody) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling updateUserGroupRolesForEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling updateUserGroupRolesForEntityType");
    }
    if (entityId == null) {
      throw new ApiException(400, "Missing the required parameter 'entityId' when calling updateUserGroupRolesForEntityType");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling updateUserGroupRolesForEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/{entity-id}/roles/user-groups"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{entity-id}", apiClient.escapeString(entityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.updateUserGroupRolesForEntityType", localVarPath, "PATCH", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set User Integration Entity Roles
   * Sets the integration entity roles for multiple users for an integration entity.  Requires the \&quot;edit\&quot; IntegrationEntityRole for that integration entity.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @param requestBody An object describing the requested new role for each user to be changed. Note that there is no need to include users that you don&#39;t want to change. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration Entity roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole for the requested integration entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity or one of the specified users does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserRolesForEntityType(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId, @jakarta.annotation.Nonnull Map<String, IntegrationEntityRole> requestBody) throws ApiException {
    updateUserRolesForEntityTypeWithHttpInfo(tool, entityType, entityId, requestBody);
  }

  /**
   * Set User Integration Entity Roles
   * Sets the integration entity roles for multiple users for an integration entity.  Requires the \&quot;edit\&quot; IntegrationEntityRole for that integration entity.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param entityId The ID of the integration entity (required)
   * @param requestBody An object describing the requested new role for each user to be changed. Note that there is no need to include users that you don&#39;t want to change. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Integration Entity roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; IntegrationEntityRole for the requested integration entity </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The integration entity or one of the specified users does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserRolesForEntityTypeWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull Integer entityId, @jakarta.annotation.Nonnull Map<String, IntegrationEntityRole> requestBody) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling updateUserRolesForEntityType");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling updateUserRolesForEntityType");
    }
    if (entityId == null) {
      throw new ApiException(400, "Missing the required parameter 'entityId' when calling updateUserRolesForEntityType");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling updateUserRolesForEntityType");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/{entity-id}/roles/users"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{entity-id}", apiClient.escapeString(entityId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("CentralConfigurationApi.updateUserRolesForEntityType", localVarPath, "PATCH", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Validate Integration Entity Form
   * Validates the integration entity form.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param apiConfigValues  (optional)
   * @return EntityValidationFeedback
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns feedback regarding the state of the entity form </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public EntityValidationFeedback validateIntegrationEntityForm(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    return validateIntegrationEntityFormWithHttpInfo(tool, entityType, connectionEntityId, projectEntityId, apiConfigValues).getData();
  }

  /**
   * Validate Integration Entity Form
   * Validates the integration entity form.  Requires the \&quot;integrations:tool-configuration:view\&quot; permission instance to whatever entities are being used.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param apiConfigValues  (optional)
   * @return ApiResponse&lt;EntityValidationFeedback&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns feedback regarding the state of the entity form </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<EntityValidationFeedback> validateIntegrationEntityFormWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable ApiConfigValues apiConfigValues) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling validateIntegrationEntityForm");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling validateIntegrationEntityForm");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/form/validate"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "connectionEntityId", connectionEntityId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "projectEntityId", projectEntityId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<EntityValidationFeedback> localVarReturnType = new GenericType<EntityValidationFeedback>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.validateIntegrationEntityForm", localVarPath, "POST", localVarQueryParams, apiConfigValues,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Validate Tool Connector URL
   * Validates the tool connector URL.  No special permissions are required.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param fieldName The name of the field (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param validateToolConnectorUrlRequest  (optional)
   * @return ToolConnectorUrlValidationFeedback
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Validates the URLs being used for tool connectors </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ToolConnectorUrlValidationFeedback validateToolConnectorUrl(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull String fieldName, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable ValidateToolConnectorUrlRequest validateToolConnectorUrlRequest) throws ApiException {
    return validateToolConnectorUrlWithHttpInfo(tool, entityType, fieldName, connectionEntityId, projectEntityId, validateToolConnectorUrlRequest).getData();
  }

  /**
   * Validate Tool Connector URL
   * Validates the tool connector URL.  No special permissions are required.
   * @param tool The id or name of a tool. The names of tools can be obtained using the List Integrations endpoint. (required)
   * @param entityType The type of integration entity (required)
   * @param fieldName The name of the field (required)
   * @param connectionEntityId  (optional)
   * @param projectEntityId  (optional)
   * @param validateToolConnectorUrlRequest  (optional)
   * @return ApiResponse&lt;ToolConnectorUrlValidationFeedback&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Validates the URLs being used for tool connectors </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the configuration form </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An integration and entity type were provided, but one or both do not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ToolConnectorUrlValidationFeedback> validateToolConnectorUrlWithHttpInfo(@jakarta.annotation.Nonnull GetToolConnectorConfigFormToolParameter tool, @jakarta.annotation.Nonnull String entityType, @jakarta.annotation.Nonnull String fieldName, @jakarta.annotation.Nullable Integer connectionEntityId, @jakarta.annotation.Nullable Integer projectEntityId, @jakarta.annotation.Nullable ValidateToolConnectorUrlRequest validateToolConnectorUrlRequest) throws ApiException {
    // Check required parameters
    if (tool == null) {
      throw new ApiException(400, "Missing the required parameter 'tool' when calling validateToolConnectorUrl");
    }
    if (entityType == null) {
      throw new ApiException(400, "Missing the required parameter 'entityType' when calling validateToolConnectorUrl");
    }
    if (fieldName == null) {
      throw new ApiException(400, "Missing the required parameter 'fieldName' when calling validateToolConnectorUrl");
    }

    // Path parameters
    String localVarPath = "/x/integrations/tool-connector/{tool}/{entity-type}/form/validate-url/{field-name}"
            .replaceAll("\\{tool}", apiClient.escapeString(tool.toString()))
            .replaceAll("\\{entity-type}", apiClient.escapeString(entityType.toString()))
            .replaceAll("\\{field-name}", apiClient.escapeString(fieldName.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "connectionEntityId", connectionEntityId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "projectEntityId", projectEntityId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ToolConnectorUrlValidationFeedback> localVarReturnType = new GenericType<ToolConnectorUrlValidationFeedback>() {};
    return apiClient.invokeAPI("CentralConfigurationApi.validateToolConnectorUrl", localVarPath, "POST", localVarQueryParams, validateToolConnectorUrlRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
