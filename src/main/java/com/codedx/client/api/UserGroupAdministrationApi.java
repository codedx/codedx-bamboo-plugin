package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.AddUserGroupMemberRequest;
import com.codedx.client.model.CreateUserGroup;
import com.codedx.client.model.EditUserGroup;
import com.codedx.client.model.Error;
import com.codedx.client.model.GetBulkUserGroupProjectRolesForProjectRequest;
import com.codedx.client.model.Roles;
import com.codedx.client.model.UpdateUserGroupMembersRequest;
import com.codedx.client.model.UserGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class UserGroupAdministrationApi {
  private ApiClient apiClient;

  public UserGroupAdministrationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UserGroupAdministrationApi(ApiClient apiClient) {
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
   * Add User Group Member
   * Add a user to a user group.  Requires the \&quot;user-group:members:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param addUserGroupMemberRequest  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group member successfully added </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group or user does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void addUserGroupMember(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull AddUserGroupMemberRequest addUserGroupMemberRequest) throws ApiException {
    addUserGroupMemberWithHttpInfo(userGroupId, addUserGroupMemberRequest);
  }

  /**
   * Add User Group Member
   * Add a user to a user group.  Requires the \&quot;user-group:members:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param addUserGroupMemberRequest  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group member successfully added </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group or user does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> addUserGroupMemberWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull AddUserGroupMemberRequest addUserGroupMemberRequest) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling addUserGroupMember");
    }
    if (addUserGroupMemberRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'addUserGroupMemberRequest' when calling addUserGroupMember");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}/member"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserGroupAdministrationApi.addUserGroupMember", localVarPath, "PUT", new ArrayList<>(), addUserGroupMemberRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create User Group
   * Allows creation of a user group.  Requires the \&quot;user-group:create\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param createUserGroup  (required)
   * @return UserGroup
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - User group successfully created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public UserGroup createUserGroup(@jakarta.annotation.Nonnull CreateUserGroup createUserGroup) throws ApiException {
    return createUserGroupWithHttpInfo(createUserGroup).getData();
  }

  /**
   * Create User Group
   * Allows creation of a user group.  Requires the \&quot;user-group:create\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param createUserGroup  (required)
   * @return ApiResponse&lt;UserGroup&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - User group successfully created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<UserGroup> createUserGroupWithHttpInfo(@jakarta.annotation.Nonnull CreateUserGroup createUserGroup) throws ApiException {
    // Check required parameters
    if (createUserGroup == null) {
      throw new ApiException(400, "Missing the required parameter 'createUserGroup' when calling createUserGroup");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<UserGroup> localVarReturnType = new GenericType<UserGroup>() {};
    return apiClient.invokeAPI("UserGroupAdministrationApi.createUserGroup", "/api/admin/user-group", "POST", new ArrayList<>(), createUserGroup,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete User Group
   * Allows admin to delete a user group (and optionally all children of the user group).  Requires the \&quot;user-group:delete\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param recursive Use &#39;true&#39; if you want to also delete all children of the user group (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group successfully deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteUserGroup(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nullable Boolean recursive) throws ApiException {
    deleteUserGroupWithHttpInfo(userGroupId, recursive);
  }

  /**
   * Delete User Group
   * Allows admin to delete a user group (and optionally all children of the user group).  Requires the \&quot;user-group:delete\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param recursive Use &#39;true&#39; if you want to also delete all children of the user group (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group successfully deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteUserGroupWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nullable Boolean recursive) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling deleteUserGroup");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "recursive", recursive)
    );

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserGroupAdministrationApi.deleteUserGroup", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Edit User Group
   * Allows admin to change the name or parent user group of a user group.  Requires the \&quot;user-group:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param editUserGroup  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group successfully edited </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void editUserGroup(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull EditUserGroup editUserGroup) throws ApiException {
    editUserGroupWithHttpInfo(userGroupId, editUserGroup);
  }

  /**
   * Edit User Group
   * Allows admin to change the name or parent user group of a user group.  Requires the \&quot;user-group:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param editUserGroup  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group successfully edited </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> editUserGroupWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull EditUserGroup editUserGroup) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling editUserGroup");
    }
    if (editUserGroup == null) {
      throw new ApiException(400, "Missing the required parameter 'editUserGroup' when calling editUserGroup");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserGroupAdministrationApi.editUserGroup", localVarPath, "PUT", new ArrayList<>(), editUserGroup,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Bulk User Group Project Roles for Project
   * For a given project, get the UserGroup-Project roles for all user groups (whose IDs are provided in the request body) for that project.  Requires the \&quot;user-group:roles:view\&quot; permission which is available to all users regardless of role.
   * @param projectId The ID of the project. (required)
   * @param getBulkUserGroupProjectRolesForProjectRequest  (required)
   * @return Map&lt;String, Roles&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains an object that acts as a UserGroupId &#x3D;&gt; Roles lookup table </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - indicates the response body was not a valid JSON body with an array of integers </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if no UserGroup was found with the specified ID </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected error </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, Roles> getBulkUserGroupProjectRolesForProject(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull GetBulkUserGroupProjectRolesForProjectRequest getBulkUserGroupProjectRolesForProjectRequest) throws ApiException {
    return getBulkUserGroupProjectRolesForProjectWithHttpInfo(projectId, getBulkUserGroupProjectRolesForProjectRequest).getData();
  }

  /**
   * Get Bulk User Group Project Roles for Project
   * For a given project, get the UserGroup-Project roles for all user groups (whose IDs are provided in the request body) for that project.  Requires the \&quot;user-group:roles:view\&quot; permission which is available to all users regardless of role.
   * @param projectId The ID of the project. (required)
   * @param getBulkUserGroupProjectRolesForProjectRequest  (required)
   * @return ApiResponse&lt;Map&lt;String, Roles&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains an object that acts as a UserGroupId &#x3D;&gt; Roles lookup table </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - indicates the response body was not a valid JSON body with an array of integers </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if no UserGroup was found with the specified ID </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, Roles>> getBulkUserGroupProjectRolesForProjectWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull GetBulkUserGroupProjectRolesForProjectRequest getBulkUserGroupProjectRolesForProjectRequest) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getBulkUserGroupProjectRolesForProject");
    }
    if (getBulkUserGroupProjectRolesForProjectRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'getBulkUserGroupProjectRolesForProjectRequest' when calling getBulkUserGroupProjectRolesForProject");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/project-roles/project/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Map<String, Roles>> localVarReturnType = new GenericType<Map<String, Roles>>() {};
    return apiClient.invokeAPI("UserGroupAdministrationApi.getBulkUserGroupProjectRolesForProject", localVarPath, "POST", new ArrayList<>(), getBulkUserGroupProjectRolesForProjectRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Bulk User Group Project Roles for User Group
   * Get a user group&#39;s roles for all projects whose IDs are provided in the request body.  Requires the \&quot;user-group:roles:view\&quot; permission which is available to all users regardless of role.
   * @param userGroupId  (required)
   * @param requestBody  (required)
   * @return Map&lt;String, Roles&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains an object that acts as a ProjectId &#x3D;&gt; Roles lookup table </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - indicates the response body was not a valid JSON body with an array of integers </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if no UserGroup was found with the specified ID </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected error </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, Roles> getBulkUserGroupProjectRolesForUserGroup(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull List<Integer> requestBody) throws ApiException {
    return getBulkUserGroupProjectRolesForUserGroupWithHttpInfo(userGroupId, requestBody).getData();
  }

  /**
   * Get Bulk User Group Project Roles for User Group
   * Get a user group&#39;s roles for all projects whose IDs are provided in the request body.  Requires the \&quot;user-group:roles:view\&quot; permission which is available to all users regardless of role.
   * @param userGroupId  (required)
   * @param requestBody  (required)
   * @return ApiResponse&lt;Map&lt;String, Roles&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains an object that acts as a ProjectId &#x3D;&gt; Roles lookup table </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - indicates the response body was not a valid JSON body with an array of integers </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - if the requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - if no UserGroup was found with the specified ID </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, Roles>> getBulkUserGroupProjectRolesForUserGroupWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull List<Integer> requestBody) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling getBulkUserGroupProjectRolesForUserGroup");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling getBulkUserGroupProjectRolesForUserGroup");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}/project/roles"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Map<String, Roles>> localVarReturnType = new GenericType<Map<String, Roles>>() {};
    return apiClient.invokeAPI("UserGroupAdministrationApi.getBulkUserGroupProjectRolesForUserGroup", localVarPath, "POST", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get User Group Project Roles
   * Get a user group&#39;s roles for a specific project.  Requires the \&quot;user-group:roles:view\&quot; permission which is available to all users regardless of role.
   * @param userGroupId  (required)
   * @param projectId The ID of the project. (required)
   * @return Roles
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains the roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Roles getUserGroupProjectRoles(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return getUserGroupProjectRolesWithHttpInfo(userGroupId, projectId).getData();
  }

  /**
   * Get User Group Project Roles
   * Get a user group&#39;s roles for a specific project.  Requires the \&quot;user-group:roles:view\&quot; permission which is available to all users regardless of role.
   * @param userGroupId  (required)
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;Roles&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - contains the roles </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - requester does not have access to this endpoint </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Roles> getUserGroupProjectRolesWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling getUserGroupProjectRoles");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getUserGroupProjectRoles");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}/project/{project-id}/roles"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Roles> localVarReturnType = new GenericType<Roles>() {};
    return apiClient.invokeAPI("UserGroupAdministrationApi.getUserGroupProjectRoles", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get All User Groups
   * Get all user groups.  Requires the \&quot;user-group:view\&quot; permission which is available to all users regardless of role.
   * @return List&lt;UserGroup&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list off all user groups </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserGroup> getUserGroups() throws ApiException {
    return getUserGroupsWithHttpInfo().getData();
  }

  /**
   * Get All User Groups
   * Get all user groups.  Requires the \&quot;user-group:view\&quot; permission which is available to all users regardless of role.
   * @return ApiResponse&lt;List&lt;UserGroup&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list off all user groups </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserGroup>> getUserGroupsWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserGroup>> localVarReturnType = new GenericType<List<UserGroup>>() {};
    return apiClient.invokeAPI("UserGroupAdministrationApi.getUserGroups", "/api/admin/user-group", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Remove User Group Member
   * Remove a user from a user group.  Requires the \&quot;user-group:members:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param userId The user ID. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group member successfully removed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group or user does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void removeUserGroupMember(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Integer userId) throws ApiException {
    removeUserGroupMemberWithHttpInfo(userGroupId, userId);
  }

  /**
   * Remove User Group Member
   * Remove a user from a user group.  Requires the \&quot;user-group:members:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param userId The user ID. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group member successfully removed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group or user does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> removeUserGroupMemberWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Integer userId) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling removeUserGroupMember");
    }
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling removeUserGroupMember");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}/member/{user-id}"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()))
            .replaceAll("\\{user-id}", apiClient.escapeString(userId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserGroupAdministrationApi.removeUserGroupMember", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set User Group Project Roles
   * Set a user group&#39;s roles for a specific project.  Requires the \&quot;user-group:roles:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param projectId The ID of the project. (required)
   * @param roles  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group roles set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setUserGroupProjectRoles(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Roles roles) throws ApiException {
    setUserGroupProjectRolesWithHttpInfo(userGroupId, projectId, roles);
  }

  /**
   * Set User Group Project Roles
   * Set a user group&#39;s roles for a specific project.  Requires the \&quot;user-group:roles:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param projectId The ID of the project. (required)
   * @param roles  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group roles set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setUserGroupProjectRolesWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Roles roles) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling setUserGroupProjectRoles");
    }
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setUserGroupProjectRoles");
    }
    if (roles == null) {
      throw new ApiException(400, "Missing the required parameter 'roles' when calling setUserGroupProjectRoles");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}/project/{project-id}/roles"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()))
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserGroupAdministrationApi.setUserGroupProjectRoles", localVarPath, "PUT", new ArrayList<>(), roles,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set User Group Roles.
   * Set a user group&#39;s roles.  Requires the \&quot;user-group:roles:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param roles  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group roles set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void setUserGroupRoles(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Roles roles) throws ApiException {
    setUserGroupRolesWithHttpInfo(userGroupId, roles);
  }

  /**
   * Set User Group Roles.
   * Set a user group&#39;s roles.  Requires the \&quot;user-group:roles:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param roles  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group roles set </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setUserGroupRolesWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull Roles roles) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling setUserGroupRoles");
    }
    if (roles == null) {
      throw new ApiException(400, "Missing the required parameter 'roles' when calling setUserGroupRoles");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}/roles"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserGroupAdministrationApi.setUserGroupRoles", localVarPath, "PUT", new ArrayList<>(), roles,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update User Group Members
   * Update multiple memberships for a user group. This endpoint allows you to add and remove multiple users simultaneously.  Requires the \&quot;user-group:members:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param updateUserGroupMembersRequest  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group members successfully updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserGroupMembers(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull UpdateUserGroupMembersRequest updateUserGroupMembersRequest) throws ApiException {
    updateUserGroupMembersWithHttpInfo(userGroupId, updateUserGroupMembersRequest);
  }

  /**
   * Update User Group Members
   * Update multiple memberships for a user group. This endpoint allows you to add and remove multiple users simultaneously.  Requires the \&quot;user-group:members:update\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param userGroupId  (required)
   * @param updateUserGroupMembersRequest  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - User group members successfully updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - User group does not exist </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - The request object is malformed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserGroupMembersWithHttpInfo(@jakarta.annotation.Nonnull Integer userGroupId, @jakarta.annotation.Nonnull UpdateUserGroupMembersRequest updateUserGroupMembersRequest) throws ApiException {
    // Check required parameters
    if (userGroupId == null) {
      throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling updateUserGroupMembers");
    }
    if (updateUserGroupMembersRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'updateUserGroupMembersRequest' when calling updateUserGroupMembers");
    }

    // Path parameters
    String localVarPath = "/api/admin/user-group/{user-group-id}/members"
            .replaceAll("\\{user-group-id}", apiClient.escapeString(userGroupId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("UserGroupAdministrationApi.updateUserGroupMembers", localVarPath, "PATCH", new ArrayList<>(), updateUserGroupMembersRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
