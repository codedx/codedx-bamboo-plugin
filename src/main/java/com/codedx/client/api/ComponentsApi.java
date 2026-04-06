package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Component;
import com.codedx.client.model.ComponentDetails;
import com.codedx.client.model.ComponentSecurityDetails;
import com.codedx.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class ComponentsApi {
  private ApiClient apiClient;

  public ComponentsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ComponentsApi(ApiClient apiClient) {
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
   * Get component details.
   * Get the details for a given component.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param componentId The ID of the component. (required)
   * @param componentVersionId The ID of the component version. (required)
   * @return ComponentDetails
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Component details successfully retrieved. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the components in this project version context. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Identifiers were provided, but they do not correspond to existing entities. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ComponentDetails getComponentDetails(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer componentId, @jakarta.annotation.Nonnull Integer componentVersionId) throws ApiException {
    return getComponentDetailsWithHttpInfo(projectVersionContext, componentId, componentVersionId).getData();
  }

  /**
   * Get component details.
   * Get the details for a given component.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param componentId The ID of the component. (required)
   * @param componentVersionId The ID of the component version. (required)
   * @return ApiResponse&lt;ComponentDetails&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Component details successfully retrieved. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the components in this project version context. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Identifiers were provided, but they do not correspond to existing entities. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ComponentDetails> getComponentDetailsWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer componentId, @jakarta.annotation.Nonnull Integer componentVersionId) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getComponentDetails");
    }
    if (componentId == null) {
      throw new ApiException(400, "Missing the required parameter 'componentId' when calling getComponentDetails");
    }
    if (componentVersionId == null) {
      throw new ApiException(400, "Missing the required parameter 'componentVersionId' when calling getComponentDetails");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/components/{component-id}/{component-version-id}"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{component-id}", apiClient.escapeString(componentId.toString()))
            .replaceAll("\\{component-version-id}", apiClient.escapeString(componentVersionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ComponentDetails> localVarReturnType = new GenericType<ComponentDetails>() {};
    return apiClient.invokeAPI("ComponentsApi.getComponentDetails", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get component security details.
   * Get the security details for a given component.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param componentId The ID of the component. (required)
   * @param componentVersionId The ID of the component version. (required)
   * @return ComponentSecurityDetails
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Component security details successfully retrieved. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the components in this project version context. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Identifiers were provided, but they do not correspond to existing entities. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ComponentSecurityDetails getComponentSecurityDetails(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer componentId, @jakarta.annotation.Nonnull Integer componentVersionId) throws ApiException {
    return getComponentSecurityDetailsWithHttpInfo(projectVersionContext, componentId, componentVersionId).getData();
  }

  /**
   * Get component security details.
   * Get the security details for a given component.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @param componentId The ID of the component. (required)
   * @param componentVersionId The ID of the component version. (required)
   * @return ApiResponse&lt;ComponentSecurityDetails&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Component security details successfully retrieved. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the components in this project version context. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Identifiers were provided, but they do not correspond to existing entities. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ComponentSecurityDetails> getComponentSecurityDetailsWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext, @jakarta.annotation.Nonnull Integer componentId, @jakarta.annotation.Nonnull Integer componentVersionId) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling getComponentSecurityDetails");
    }
    if (componentId == null) {
      throw new ApiException(400, "Missing the required parameter 'componentId' when calling getComponentSecurityDetails");
    }
    if (componentVersionId == null) {
      throw new ApiException(400, "Missing the required parameter 'componentVersionId' when calling getComponentSecurityDetails");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/components/{component-id}/{component-version-id}/security-details"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()))
            .replaceAll("\\{component-id}", apiClient.escapeString(componentId.toString()))
            .replaceAll("\\{component-version-id}", apiClient.escapeString(componentVersionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ComponentSecurityDetails> localVarReturnType = new GenericType<ComponentSecurityDetails>() {};
    return apiClient.invokeAPI("ComponentsApi.getComponentSecurityDetails", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List components.
   * Lists the components for a given project version context.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return List&lt;Component&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Components were successfully listed. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the components in this project version context. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An project version context was provided, but it doesn&#39;t correspond to an existing project version. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Component> listComponents(@jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    return listComponentsWithHttpInfo(projectVersionContext).getData();
  }

  /**
   * List components.
   * Lists the components for a given project version context.
   * @param projectVersionContext A &#x60;ProjectContext&#x60; only capable of specifying a single project.  A project can be specified with its project id and, optionally, a branch id or branch name. If only the project id is used, then the project&#39;s default branch will be used. (required)
   * @return ApiResponse&lt;List&lt;Component&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Components were successfully listed. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view the components in this project version context. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An project version context was provided, but it doesn&#39;t correspond to an existing project version. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Component>> listComponentsWithHttpInfo(@jakarta.annotation.Nonnull String projectVersionContext) throws ApiException {
    // Check required parameters
    if (projectVersionContext == null) {
      throw new ApiException(400, "Missing the required parameter 'projectVersionContext' when calling listComponents");
    }

    // Path parameters
    String localVarPath = "/x/projects/{project-version-context}/components"
            .replaceAll("\\{project-version-context}", apiClient.escapeString(projectVersionContext.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Component>> localVarReturnType = new GenericType<List<Component>>() {};
    return apiClient.invokeAPI("ComponentsApi.listComponents", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
