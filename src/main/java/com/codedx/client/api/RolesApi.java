package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Error;
import com.codedx.client.model.FullRole;
import com.codedx.client.model.Permission;
import com.codedx.client.model.Role;
import com.codedx.client.model.SimpleRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class RolesApi {
  private ApiClient apiClient;

  public RolesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RolesApi(ApiClient apiClient) {
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
   * Create a role
   * Create a role with the given name and permission set
   * @param roleScope The scope of a permission (required)
   * @param role Role to create (required)
   * @return List&lt;FullRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> OK - Response body will be a complete view of the created role </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - A role already exists with the provided role name or an unknown permission was provided </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:create permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<FullRole> createRole(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Role role) throws ApiException {
    return createRoleWithHttpInfo(roleScope, role).getData();
  }

  /**
   * Create a role
   * Create a role with the given name and permission set
   * @param roleScope The scope of a permission (required)
   * @param role Role to create (required)
   * @return ApiResponse&lt;List&lt;FullRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> OK - Response body will be a complete view of the created role </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - A role already exists with the provided role name or an unknown permission was provided </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:create permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<FullRole>> createRoleWithHttpInfo(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Role role) throws ApiException {
    // Check required parameters
    if (roleScope == null) {
      throw new ApiException(400, "Missing the required parameter 'roleScope' when calling createRole");
    }
    if (role == null) {
      throw new ApiException(400, "Missing the required parameter 'role' when calling createRole");
    }

    // Path parameters
    String localVarPath = "/x/roles/{role-scope}"
            .replaceAll("\\{role-scope}", apiClient.escapeString(roleScope.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<FullRole>> localVarReturnType = new GenericType<List<FullRole>>() {};
    return apiClient.invokeAPI("RolesApi.createRole", localVarPath, "PUT", new ArrayList<>(), role,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a tag
   * Delete a role, deleting role assignments if necessary and permitted.
   * @param roleScope The scope of a permission (required)
   * @param roleId The id of a role (required)
   * @param force Use &#39;true&#39; if you want to delete a role and all of its assignments (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Role was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:delete permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteRole(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Integer roleId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    deleteRoleWithHttpInfo(roleScope, roleId, force);
  }

  /**
   * Delete a tag
   * Delete a role, deleting role assignments if necessary and permitted.
   * @param roleScope The scope of a permission (required)
   * @param roleId The id of a role (required)
   * @param force Use &#39;true&#39; if you want to delete a role and all of its assignments (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Role was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:delete permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteRoleWithHttpInfo(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Integer roleId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (roleScope == null) {
      throw new ApiException(400, "Missing the required parameter 'roleScope' when calling deleteRole");
    }
    if (roleId == null) {
      throw new ApiException(400, "Missing the required parameter 'roleId' when calling deleteRole");
    }

    // Path parameters
    String localVarPath = "/x/roles/{role-scope}/{role-id}"
            .replaceAll("\\{role-scope}", apiClient.escapeString(roleScope.toString()))
            .replaceAll("\\{role-id}", apiClient.escapeString(roleId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("RolesApi.deleteRole", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * List permissions
   * Lists all permissions in the given role scope, or all permissions across all role scopes if &#39;all&#39; is provided
   * @param permissionScope The scope of a permission (required)
   * @return List&lt;Permission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of permissions in the given permission scope. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:view permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid permission scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Permission> listPermissions(@jakarta.annotation.Nonnull String permissionScope) throws ApiException {
    return listPermissionsWithHttpInfo(permissionScope).getData();
  }

  /**
   * List permissions
   * Lists all permissions in the given role scope, or all permissions across all role scopes if &#39;all&#39; is provided
   * @param permissionScope The scope of a permission (required)
   * @return ApiResponse&lt;List&lt;Permission&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of permissions in the given permission scope. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:view permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid permission scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Permission>> listPermissionsWithHttpInfo(@jakarta.annotation.Nonnull String permissionScope) throws ApiException {
    // Check required parameters
    if (permissionScope == null) {
      throw new ApiException(400, "Missing the required parameter 'permissionScope' when calling listPermissions");
    }

    // Path parameters
    String localVarPath = "/x/roles/{permission-scope}/permissions"
            .replaceAll("\\{permission-scope}", apiClient.escapeString(permissionScope.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Permission>> localVarReturnType = new GenericType<List<Permission>>() {};
    return apiClient.invokeAPI("RolesApi.listPermissions", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List roles
   * Lists all roles in the given role scope
   * @param roleScope The scope of a permission (required)
   * @return List&lt;SimpleRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a simple view of each role in the given scope. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:view permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<SimpleRole> listRoles(@jakarta.annotation.Nonnull String roleScope) throws ApiException {
    return listRolesWithHttpInfo(roleScope).getData();
  }

  /**
   * List roles
   * Lists all roles in the given role scope
   * @param roleScope The scope of a permission (required)
   * @return ApiResponse&lt;List&lt;SimpleRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a simple view of each role in the given scope. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:view permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<SimpleRole>> listRolesWithHttpInfo(@jakarta.annotation.Nonnull String roleScope) throws ApiException {
    // Check required parameters
    if (roleScope == null) {
      throw new ApiException(400, "Missing the required parameter 'roleScope' when calling listRoles");
    }

    // Path parameters
    String localVarPath = "/x/roles/{role-scope}"
            .replaceAll("\\{role-scope}", apiClient.escapeString(roleScope.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<SimpleRole>> localVarReturnType = new GenericType<List<SimpleRole>>() {};
    return apiClient.invokeAPI("RolesApi.listRoles", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Lookup role
   * Lookup a role by name in the given role scope
   * @param roleScope The scope of a permission (required)
   * @param roleId The id of a role (required)
   * @return List&lt;FullRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a complete view of the role </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:create permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<FullRole> lookupRole(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Integer roleId) throws ApiException {
    return lookupRoleWithHttpInfo(roleScope, roleId).getData();
  }

  /**
   * Lookup role
   * Lookup a role by name in the given role scope
   * @param roleScope The scope of a permission (required)
   * @param roleId The id of a role (required)
   * @return ApiResponse&lt;List&lt;FullRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be a complete view of the role </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:create permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<FullRole>> lookupRoleWithHttpInfo(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Integer roleId) throws ApiException {
    // Check required parameters
    if (roleScope == null) {
      throw new ApiException(400, "Missing the required parameter 'roleScope' when calling lookupRole");
    }
    if (roleId == null) {
      throw new ApiException(400, "Missing the required parameter 'roleId' when calling lookupRole");
    }

    // Path parameters
    String localVarPath = "/x/roles/{role-scope}/{role-id}"
            .replaceAll("\\{role-scope}", apiClient.escapeString(roleScope.toString()))
            .replaceAll("\\{role-id}", apiClient.escapeString(roleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<FullRole>> localVarReturnType = new GenericType<List<FullRole>>() {};
    return apiClient.invokeAPI("RolesApi.lookupRole", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a role
   * Update a role&#39;s name or permission set
   * @param roleScope The scope of a permission (required)
   * @param roleId The id of a role (required)
   * @param role Updates to make (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Role was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - A role already exists with the provided role name or an unknown permission was provided </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:delete permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateRole(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Integer roleId, @jakarta.annotation.Nullable Role role) throws ApiException {
    updateRoleWithHttpInfo(roleScope, roleId, role);
  }

  /**
   * Update a role
   * Update a role&#39;s name or permission set
   * @param roleScope The scope of a permission (required)
   * @param roleId The id of a role (required)
   * @param role Updates to make (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Role was successfully updated </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - A role already exists with the provided role name or an unknown permission was provided </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have the role:delete permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An invalid role scope was provided </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateRoleWithHttpInfo(@jakarta.annotation.Nonnull String roleScope, @jakarta.annotation.Nonnull Integer roleId, @jakarta.annotation.Nullable Role role) throws ApiException {
    // Check required parameters
    if (roleScope == null) {
      throw new ApiException(400, "Missing the required parameter 'roleScope' when calling updateRole");
    }
    if (roleId == null) {
      throw new ApiException(400, "Missing the required parameter 'roleId' when calling updateRole");
    }

    // Path parameters
    String localVarPath = "/x/roles/{role-scope}/{role-id}"
            .replaceAll("\\{role-scope}", apiClient.escapeString(roleScope.toString()))
            .replaceAll("\\{role-id}", apiClient.escapeString(roleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("RolesApi.updateRole", localVarPath, "PATCH", new ArrayList<>(), role,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
