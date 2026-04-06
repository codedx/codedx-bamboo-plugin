package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.CreateProjectOrchestrationSecretRequest;
import com.codedx.client.model.DynamicAddInToolDisplayTag;
import com.codedx.client.model.Error;
import java.io.File;
import com.codedx.client.model.GetProjectAddInToolConfig200Response;
import com.codedx.client.model.GetProjectAddInTools200ResponseInner;
import com.codedx.client.model.GetProjectOrchestrationCertificateNames200ResponseInner;
import com.codedx.client.model.GetProjectOrchestrationSecretBindings200ResponseInner;
import com.codedx.client.model.GetProjectOrchestrationSecrets200ResponseInner;
import com.codedx.client.model.ModifyProjectOrchestrationSecretRequest;
import com.codedx.client.model.UpdateProjectAddInToolConfigRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ToolOrchestrationApi {
  private ApiClient apiClient;

  public ToolOrchestrationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ToolOrchestrationApi(ApiClient apiClient) {
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
   * Create Project Orchestration Secret
   * Creates a secret for use by Add-In Tools during Analyses on a Project.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param createProjectOrchestrationSecretRequest  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The secret was created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON or did not contain the required fields, response contains an error response </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public void createProjectOrchestrationSecret(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull CreateProjectOrchestrationSecretRequest createProjectOrchestrationSecretRequest) throws ApiException {
    createProjectOrchestrationSecretWithHttpInfo(projectId, createProjectOrchestrationSecretRequest);
  }

  /**
   * Create Project Orchestration Secret
   * Creates a secret for use by Add-In Tools during Analyses on a Project.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param createProjectOrchestrationSecretRequest  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The secret was created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not JSON or did not contain the required fields, response contains an error response </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createProjectOrchestrationSecretWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull CreateProjectOrchestrationSecretRequest createProjectOrchestrationSecretRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling createProjectOrchestrationSecret");
    }
    if (createProjectOrchestrationSecretRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'createProjectOrchestrationSecretRequest' when calling createProjectOrchestrationSecret");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/secrets/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolOrchestrationApi.createProjectOrchestrationSecret", localVarPath, "POST", new ArrayList<>(), createProjectOrchestrationSecretRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Project Orchestration Certificate
   * Deletes the specified certificate for this Project.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param certName The case-sensitive name of the certificate (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The certificate was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project does not exist or no certificate exists with a matching name for the Project </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProjectOrchestrationCertificate(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String certName) throws ApiException {
    deleteProjectOrchestrationCertificateWithHttpInfo(projectId, certName);
  }

  /**
   * Delete Project Orchestration Certificate
   * Deletes the specified certificate for this Project.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param certName The case-sensitive name of the certificate (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The certificate was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project does not exist or no certificate exists with a matching name for the Project </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProjectOrchestrationCertificateWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String certName) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteProjectOrchestrationCertificate");
    }
    if (certName == null) {
      throw new ApiException(400, "Missing the required parameter 'certName' when calling deleteProjectOrchestrationCertificate");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/certs/{project-id}/{cert-name}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{cert-name}", apiClient.escapeString(certName.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolOrchestrationApi.deleteProjectOrchestrationCertificate", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Project Orchestration Secret
   * Deletes a project&#39;s secret that matches the specified case-insensitive name.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param secretName The case-insensitive name of a secret. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The secret was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled, the requester does not have access to this endpoint, or the secret is currently being used in an analysis </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProjectOrchestrationSecret(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String secretName) throws ApiException {
    deleteProjectOrchestrationSecretWithHttpInfo(projectId, secretName);
  }

  /**
   * Delete Project Orchestration Secret
   * Deletes a project&#39;s secret that matches the specified case-insensitive name.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param secretName The case-insensitive name of a secret. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The secret was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled, the requester does not have access to this endpoint, or the secret is currently being used in an analysis </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProjectOrchestrationSecretWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String secretName) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteProjectOrchestrationSecret");
    }
    if (secretName == null) {
      throw new ApiException(400, "Missing the required parameter 'secretName' when calling deleteProjectOrchestrationSecret");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/secrets/{project-id}/{secret-name}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{secret-name}", apiClient.escapeString(secretName.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolOrchestrationApi.deleteProjectOrchestrationSecret", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Disable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to disable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In Tools are Add-In Tools that are not associated with any input files. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return List&lt;DynamicAddInToolDisplayTag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public List<DynamicAddInToolDisplayTag> disableAnalysisDynamicAddInTool(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    return disableAnalysisDynamicAddInToolWithHttpInfo(prepId, toolId).getData();
  }

  /**
   * Disable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to disable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In Tools are Add-In Tools that are not associated with any input files. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return ApiResponse&lt;List&lt;DynamicAddInToolDisplayTag&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<DynamicAddInToolDisplayTag>> disableAnalysisDynamicAddInToolWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling disableAnalysisDynamicAddInTool");
    }
    if (toolId == null) {
      throw new ApiException(400, "Missing the required parameter 'toolId' when calling disableAnalysisDynamicAddInTool");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/addin/{tool-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{tool-id}", apiClient.escapeString(toolId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<DynamicAddInToolDisplayTag>> localVarReturnType = new GenericType<List<DynamicAddInToolDisplayTag>>() {};
    return apiClient.invokeAPI("ToolOrchestrationApi.disableAnalysisDynamicAddInTool", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Enable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to enable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In tools are Add-In Tools that are not associated with any input files. Dynamic tools must be enabled for the Project in its Orchestration Config page first. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return List&lt;DynamicAddInToolDisplayTag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public List<DynamicAddInToolDisplayTag> enableAnalysisDynamicAddInTool(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    return enableAnalysisDynamicAddInToolWithHttpInfo(prepId, toolId).getData();
  }

  /**
   * Enable a Dynamic Add-In Tool
   * Note: Only applicable if Tool Orchestration is enabled.  Attempts to enable the specified dynamic Add-In Tool for this Analysis. Dynamic Add-In tools are Add-In Tools that are not associated with any input files. Dynamic tools must be enabled for the Project in its Orchestration Config page first. This endpoint has no effect if the tool is disabled in the Orchestration Config page, indicated by an &#x60;enabledReason&#x60; of &#x60;orchestration-config&#x60; in its analysis-prep entry.  Requires no role, all users have sufficient permissions by default.
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return ApiResponse&lt;List&lt;DynamicAddInToolDisplayTag&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated set of Add-In Tool states </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Contains an error response message </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No such Analysis Prep </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<DynamicAddInToolDisplayTag>> enableAnalysisDynamicAddInToolWithHttpInfo(@jakarta.annotation.Nonnull String prepId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    // Check required parameters
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling enableAnalysisDynamicAddInTool");
    }
    if (toolId == null) {
      throw new ApiException(400, "Missing the required parameter 'toolId' when calling enableAnalysisDynamicAddInTool");
    }

    // Path parameters
    String localVarPath = "/x/analysis-prep/{prep-id}/addin/{tool-id}"
            .replaceAll("\\{prep-id}", apiClient.escapeString(prepId.toString()))
            .replaceAll("\\{tool-id}", apiClient.escapeString(toolId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<DynamicAddInToolDisplayTag>> localVarReturnType = new GenericType<List<DynamicAddInToolDisplayTag>>() {};
    return apiClient.invokeAPI("ToolOrchestrationApi.enableAnalysisDynamicAddInTool", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Add-In Tool Configuration
   * Retrieves the Project-specific configuration for this Add-In Tool, such as customized TOML spec and assigned secrets.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return GetProjectAddInToolConfig200Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the Project-specific configuration of the Add-In Tool </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Add-In Tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public GetProjectAddInToolConfig200Response getProjectAddInToolConfig(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    return getProjectAddInToolConfigWithHttpInfo(projectId, toolId).getData();
  }

  /**
   * Get Project Add-In Tool Configuration
   * Retrieves the Project-specific configuration for this Add-In Tool, such as customized TOML spec and assigned secrets.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @return ApiResponse&lt;GetProjectAddInToolConfig200Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the Project-specific configuration of the Add-In Tool </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Add-In Tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GetProjectAddInToolConfig200Response> getProjectAddInToolConfigWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer toolId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectAddInToolConfig");
    }
    if (toolId == null) {
      throw new ApiException(400, "Missing the required parameter 'toolId' when calling getProjectAddInToolConfig");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/addin-tools/{project-id}/{tool-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{tool-id}", apiClient.escapeString(toolId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<GetProjectAddInToolConfig200Response> localVarReturnType = new GenericType<GetProjectAddInToolConfig200Response>() {};
    return apiClient.invokeAPI("ToolOrchestrationApi.getProjectAddInToolConfig", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Add-In Tools
   * Gets the list of Add-In Tools available to configure for the Project.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;GetProjectAddInTools200ResponseInner&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of Add-In Tool names and IDs </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<GetProjectAddInTools200ResponseInner> getProjectAddInTools(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectAddInToolsWithHttpInfo(projectId).getData();
  }

  /**
   * Get Project Add-In Tools
   * Gets the list of Add-In Tools available to configure for the Project.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;GetProjectAddInTools200ResponseInner&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of Add-In Tool names and IDs </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<GetProjectAddInTools200ResponseInner>> getProjectAddInToolsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectAddInTools");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/addin-tools/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<GetProjectAddInTools200ResponseInner>> localVarReturnType = new GenericType<List<GetProjectAddInTools200ResponseInner>>() {};
    return apiClient.invokeAPI("ToolOrchestrationApi.getProjectAddInTools", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get All Orchestration Certificates for Project
   * Provides a list of certificates that have been upload for this Project, which may be used by tools or the Tool Service during Tool Orchestration.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;GetProjectOrchestrationCertificateNames200ResponseInner&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of certificates </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public List<GetProjectOrchestrationCertificateNames200ResponseInner> getProjectOrchestrationCertificateNames(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectOrchestrationCertificateNamesWithHttpInfo(projectId).getData();
  }

  /**
   * Get All Orchestration Certificates for Project
   * Provides a list of certificates that have been upload for this Project, which may be used by tools or the Tool Service during Tool Orchestration.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;GetProjectOrchestrationCertificateNames200ResponseInner&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of certificates </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<GetProjectOrchestrationCertificateNames200ResponseInner>> getProjectOrchestrationCertificateNamesWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectOrchestrationCertificateNames");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/certs/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<GetProjectOrchestrationCertificateNames200ResponseInner>> localVarReturnType = new GenericType<List<GetProjectOrchestrationCertificateNames200ResponseInner>>() {};
    return apiClient.invokeAPI("ToolOrchestrationApi.getProjectOrchestrationCertificateNames", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Secret Add-In Tool Bindings
   * Returns a list of Add-In Tools and the names of secrets that are currently bound to them.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;GetProjectOrchestrationSecretBindings200ResponseInner&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of Add-In Tools and the names of their assigned secrets </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from Software Risk Manager, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public List<GetProjectOrchestrationSecretBindings200ResponseInner> getProjectOrchestrationSecretBindings(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectOrchestrationSecretBindingsWithHttpInfo(projectId).getData();
  }

  /**
   * Get Secret Add-In Tool Bindings
   * Returns a list of Add-In Tools and the names of secrets that are currently bound to them.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;GetProjectOrchestrationSecretBindings200ResponseInner&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of Add-In Tools and the names of their assigned secrets </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from Software Risk Manager, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<GetProjectOrchestrationSecretBindings200ResponseInner>> getProjectOrchestrationSecretBindingsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectOrchestrationSecretBindings");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/secrets/{project-id}/in-use"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<GetProjectOrchestrationSecretBindings200ResponseInner>> localVarReturnType = new GenericType<List<GetProjectOrchestrationSecretBindings200ResponseInner>>() {};
    return apiClient.invokeAPI("ToolOrchestrationApi.getProjectOrchestrationSecretBindings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Project Orchestration Secrets
   * Gets the list of secrets that were created for this project. Secrets are arbitrary configuration data for use by add-in tools, such as user credentials and licenses.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return List&lt;GetProjectOrchestrationSecrets200ResponseInner&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of secrets stored for the project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester does not have access to this endpoint, or tool orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public List<GetProjectOrchestrationSecrets200ResponseInner> getProjectOrchestrationSecrets(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getProjectOrchestrationSecretsWithHttpInfo(projectId).getData();
  }

  /**
   * Get Project Orchestration Secrets
   * Gets the list of secrets that were created for this project. Secrets are arbitrary configuration data for use by add-in tools, such as user credentials and licenses.  Requires the \&quot;project:read-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;GetProjectOrchestrationSecrets200ResponseInner&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the list of secrets stored for the project </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester does not have access to this endpoint, or tool orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - the project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<GetProjectOrchestrationSecrets200ResponseInner>> getProjectOrchestrationSecretsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProjectOrchestrationSecrets");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/secrets/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<GetProjectOrchestrationSecrets200ResponseInner>> localVarReturnType = new GenericType<List<GetProjectOrchestrationSecrets200ResponseInner>>() {};
    return apiClient.invokeAPI("ToolOrchestrationApi.getProjectOrchestrationSecrets", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Modify Project Orchestration Secret
   * Modifies one or more fields of a Project&#39;s secret. Fields that are not listed in the request are left unmodified.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param secretName The case-insensitive name of a secret. (required)
   * @param modifyProjectOrchestrationSecretRequest An object containing an updated set of secret fields to apply.  Field names are case-sensitive and must match the name of an existing field in the secret. The &#x60;isSensitive&#x60; property of a field must be specified, though its value is ignored. Whether or not a field is sensitive cannot be changed after the secret is created. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The update was successfully applied </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not in the expected format, contains an error response </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The requester does not have access to this endpoint, or Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unrecognized secret or field name, or an unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public void modifyProjectOrchestrationSecret(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String secretName, @jakarta.annotation.Nullable ModifyProjectOrchestrationSecretRequest modifyProjectOrchestrationSecretRequest) throws ApiException {
    modifyProjectOrchestrationSecretWithHttpInfo(projectId, secretName, modifyProjectOrchestrationSecretRequest);
  }

  /**
   * Modify Project Orchestration Secret
   * Modifies one or more fields of a Project&#39;s secret. Fields that are not listed in the request are left unmodified.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param secretName The case-insensitive name of a secret. (required)
   * @param modifyProjectOrchestrationSecretRequest An object containing an updated set of secret fields to apply.  Field names are case-sensitive and must match the name of an existing field in the secret. The &#x60;isSensitive&#x60; property of a field must be specified, though its value is ignored. Whether or not a field is sensitive cannot be changed after the secret is created. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The update was successfully applied </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request body was not in the expected format, contains an error response </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - The requester does not have access to this endpoint, or Tool Orchestration is disabled </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unrecognized secret or field name, or an unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> modifyProjectOrchestrationSecretWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull String secretName, @jakarta.annotation.Nullable ModifyProjectOrchestrationSecretRequest modifyProjectOrchestrationSecretRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling modifyProjectOrchestrationSecret");
    }
    if (secretName == null) {
      throw new ApiException(400, "Missing the required parameter 'secretName' when calling modifyProjectOrchestrationSecret");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/secrets/{project-id}/{secret-name}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{secret-name}", apiClient.escapeString(secretName.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolOrchestrationApi.modifyProjectOrchestrationSecret", localVarPath, "PUT", new ArrayList<>(), modifyProjectOrchestrationSecretRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update Project Add-In Tool Configuration
   * Updates one or more Project-specific configuration properties of an Add-In Tool.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @param updateProjectAddInToolConfigRequest One or more configuration properties to modify. &#x60;null&#x60; or missing properties will be left unmodified (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The changes were accepted and successfully saved </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The TOML provided in &#x60;newContent&#x60; is badly formed, response contains an error response </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Add-In Tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure, may contain an error response </td><td>  -  </td></tr>
     </table>
   */
  public void updateProjectAddInToolConfig(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer toolId, @jakarta.annotation.Nullable UpdateProjectAddInToolConfigRequest updateProjectAddInToolConfigRequest) throws ApiException {
    updateProjectAddInToolConfigWithHttpInfo(projectId, toolId, updateProjectAddInToolConfigRequest);
  }

  /**
   * Update Project Add-In Tool Configuration
   * Updates one or more Project-specific configuration properties of an Add-In Tool.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param toolId The ID of the dynamic Add-In Tool. This should come from the Create Analysis Prep response (required)
   * @param updateProjectAddInToolConfigRequest One or more configuration properties to modify. &#x60;null&#x60; or missing properties will be left unmodified (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The changes were accepted and successfully saved </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The TOML provided in &#x60;newContent&#x60; is badly formed, response contains an error response </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Either the Project or Add-In Tool does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure, may contain an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateProjectAddInToolConfigWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer toolId, @jakarta.annotation.Nullable UpdateProjectAddInToolConfigRequest updateProjectAddInToolConfigRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateProjectAddInToolConfig");
    }
    if (toolId == null) {
      throw new ApiException(400, "Missing the required parameter 'toolId' when calling updateProjectAddInToolConfig");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/addin-tools/{project-id}/{tool-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{tool-id}", apiClient.escapeString(toolId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolOrchestrationApi.updateProjectAddInToolConfig", localVarPath, "POST", new ArrayList<>(), updateProjectAddInToolConfigRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Upload Certificate for Project Orchestration
   * Allows the user to upload a certificate which may be used by tools or the Tool Service during Tool Orchestration. If a certificate was already uploaded with the same (case-sensitive) name, the old certificate is overwritten.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param _file The certificate to be uploaded (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The certificate was uploaded and accepted by the remote Tool Service </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - More than one file was uploaded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public void uploadProjectOrchestrationCertificate(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull File _file) throws ApiException {
    uploadProjectOrchestrationCertificateWithHttpInfo(projectId, _file);
  }

  /**
   * Upload Certificate for Project Orchestration
   * Allows the user to upload a certificate which may be used by tools or the Tool Service during Tool Orchestration. If a certificate was already uploaded with the same (case-sensitive) name, the old certificate is overwritten.  Requires the \&quot;project:manage-tool-service-config\&quot; permission which is provided by the \&quot;Manager\&quot; role.
   * @param projectId The ID of the project. (required)
   * @param _file The certificate to be uploaded (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - The certificate was uploaded and accepted by the remote Tool Service </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - More than one file was uploaded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - Tool Orchestration is disabled or the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The project does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected error from either Software Risk Manager or the remote Tool Service, contains an error response </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> uploadProjectOrchestrationCertificateWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull File _file) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling uploadProjectOrchestrationCertificate");
    }
    if (_file == null) {
      throw new ApiException(400, "Missing the required parameter '_file' when calling uploadProjectOrchestrationCertificate");
    }

    // Path parameters
    String localVarPath = "/x/toolservice/certs/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("file", _file);

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("ToolOrchestrationApi.uploadProjectOrchestrationCertificate", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
