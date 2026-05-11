package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Error;
import com.codedx.client.model.Policy;
import com.codedx.client.model.PolicyListItem;
import com.codedx.client.model.PolicyRole;
import com.codedx.client.model.PolicyUpdate;
import com.codedx.client.model.UserPolicyRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class PoliciesApi {
  private ApiClient apiClient;

  public PoliciesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PoliciesApi(ApiClient apiClient) {
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
   * Creates a policy
   * Creates a policy.
   * @param policy An object containing the necessary information to define a policy. (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @return Policy
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Policy created </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Saved Filter was provided, but no Saved Filter with that id exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A policy name was provided that already exists, or a private saved filter was provided for a rule </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Policy createPolicy(@jakarta.annotation.Nonnull Policy policy, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    return createPolicyWithHttpInfo(policy, force).getData();
  }

  /**
   * Creates a policy
   * Creates a policy.
   * @param policy An object containing the necessary information to define a policy. (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @return ApiResponse&lt;Policy&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Policy created </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Saved Filter was provided, but no Saved Filter with that id exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A policy name was provided that already exists, or a private saved filter was provided for a rule </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Policy> createPolicyWithHttpInfo(@jakarta.annotation.Nonnull Policy policy, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (policy == null) {
      throw new ApiException(400, "Missing the required parameter 'policy' when calling createPolicy");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Policy> localVarReturnType = new GenericType<Policy>() {};
    return apiClient.invokeAPI("PoliciesApi.createPolicy", "/x/policies", "POST", localVarQueryParams, policy,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Deletes a policy
   * Deletes a policy.
   * @param policyId  (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Policy was successfully updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Policy was provided, but no Policy with that id exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Attempted to delete a policy that is still associated with project(s) </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deletePolicy(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    deletePolicyWithHttpInfo(policyId, force);
  }

  /**
   * Deletes a policy
   * Deletes a policy.
   * @param policyId  (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Policy was successfully updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Policy was provided, but no Policy with that id exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Attempted to delete a policy that is still associated with project(s) </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deletePolicyWithHttpInfo(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (policyId == null) {
      throw new ApiException(400, "Missing the required parameter 'policyId' when calling deletePolicy");
    }

    // Path parameters
    String localVarPath = "/x/policies/{policy-id}"
            .replaceAll("\\{policy-id}", apiClient.escapeString(policyId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("PoliciesApi.deletePolicy", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get all policies
   * Get all policies. The fields present on each policy object in the response depends on how the &#39;fields&#39; query parameter is used. If &#39;fields&#39; is not provided, only the &#39;id&#39; and &#39;name&#39; will be present. If &#39;fields&#39; is provided, only the specified fields will be present.
   * @param fields The fields parameter is a comma separated list. If not used, only &#39;id&#39; and &#39;name&#39; will be returned. If used, only the fields provided will be returned. (optional)
   * @return List&lt;PolicyListItem&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - List of policies </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - field query parameter included an unsupported value </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<PolicyListItem> getAllPolicies(@jakarta.annotation.Nullable List<String> fields) throws ApiException {
    return getAllPoliciesWithHttpInfo(fields).getData();
  }

  /**
   * Get all policies
   * Get all policies. The fields present on each policy object in the response depends on how the &#39;fields&#39; query parameter is used. If &#39;fields&#39; is not provided, only the &#39;id&#39; and &#39;name&#39; will be present. If &#39;fields&#39; is provided, only the specified fields will be present.
   * @param fields The fields parameter is a comma separated list. If not used, only &#39;id&#39; and &#39;name&#39; will be returned. If used, only the fields provided will be returned. (optional)
   * @return ApiResponse&lt;List&lt;PolicyListItem&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - List of policies </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - field query parameter included an unsupported value </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<PolicyListItem>> getAllPoliciesWithHttpInfo(@jakarta.annotation.Nullable List<String> fields) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("csv", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<PolicyListItem>> localVarReturnType = new GenericType<List<PolicyListItem>>() {};
    return apiClient.invokeAPI("PoliciesApi.getAllPolicies", "/x/policies", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List User Group Policy Roles
   * Gets the policy roles for multiple user groups for a policy.  Requires the \&quot;policy:view\&quot; permission.
   * @param policyId  (required)
   * @return List&lt;UserPolicyRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserPolicyRole> getUserGroupRolesForPolicy(@jakarta.annotation.Nonnull Integer policyId) throws ApiException {
    return getUserGroupRolesForPolicyWithHttpInfo(policyId).getData();
  }

  /**
   * List User Group Policy Roles
   * Gets the policy roles for multiple user groups for a policy.  Requires the \&quot;policy:view\&quot; permission.
   * @param policyId  (required)
   * @return ApiResponse&lt;List&lt;UserPolicyRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserPolicyRole>> getUserGroupRolesForPolicyWithHttpInfo(@jakarta.annotation.Nonnull Integer policyId) throws ApiException {
    // Check required parameters
    if (policyId == null) {
      throw new ApiException(400, "Missing the required parameter 'policyId' when calling getUserGroupRolesForPolicy");
    }

    // Path parameters
    String localVarPath = "/x/policies/{policy-id}/roles/user-groups"
            .replaceAll("\\{policy-id}", apiClient.escapeString(policyId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserPolicyRole>> localVarReturnType = new GenericType<List<UserPolicyRole>>() {};
    return apiClient.invokeAPI("PoliciesApi.getUserGroupRolesForPolicy", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List User Policy Roles
   * Gets the policy roles for multiple users for a policy.  Requires the \&quot;policy:view\&quot; permission.
   * @param policyId  (required)
   * @return List&lt;UserPolicyRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserPolicyRole> getUserRolesForPolicy(@jakarta.annotation.Nonnull Integer policyId) throws ApiException {
    return getUserRolesForPolicyWithHttpInfo(policyId).getData();
  }

  /**
   * List User Policy Roles
   * Gets the policy roles for multiple users for a policy.  Requires the \&quot;policy:view\&quot; permission.
   * @param policyId  (required)
   * @return ApiResponse&lt;List&lt;UserPolicyRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of users and their roles </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view these roles </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserPolicyRole>> getUserRolesForPolicyWithHttpInfo(@jakarta.annotation.Nonnull Integer policyId) throws ApiException {
    // Check required parameters
    if (policyId == null) {
      throw new ApiException(400, "Missing the required parameter 'policyId' when calling getUserRolesForPolicy");
    }

    // Path parameters
    String localVarPath = "/x/policies/{policy-id}/roles/users"
            .replaceAll("\\{policy-id}", apiClient.escapeString(policyId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserPolicyRole>> localVarReturnType = new GenericType<List<UserPolicyRole>>() {};
    return apiClient.invokeAPI("PoliciesApi.getUserRolesForPolicy", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update Policy
   * Updates a policy by replacing its information with the given updates.
   * @param policyId  (required)
   * @param policyUpdate An object containing the necessary information to define a policy. (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Policy was successfully updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Saved Filter and/or Policy was provided, but no SavedFilter (or Policy) with that id exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A policy name was provided that already exists, or a private saved filter was provided for a rule </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updatePolicy(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nonnull PolicyUpdate policyUpdate, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    updatePolicyWithHttpInfo(policyId, policyUpdate, force);
  }

  /**
   * Update Policy
   * Updates a policy by replacing its information with the given updates.
   * @param policyId  (required)
   * @param policyUpdate An object containing the necessary information to define a policy. (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK- Policy was successfully updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An id for a Saved Filter and/or Policy was provided, but no SavedFilter (or Policy) with that id exists </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A policy name was provided that already exists, or a private saved filter was provided for a rule </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updatePolicyWithHttpInfo(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nonnull PolicyUpdate policyUpdate, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (policyId == null) {
      throw new ApiException(400, "Missing the required parameter 'policyId' when calling updatePolicy");
    }
    if (policyUpdate == null) {
      throw new ApiException(400, "Missing the required parameter 'policyUpdate' when calling updatePolicy");
    }

    // Path parameters
    String localVarPath = "/x/policies/{policy-id}"
            .replaceAll("\\{policy-id}", apiClient.escapeString(policyId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("PoliciesApi.updatePolicy", localVarPath, "PUT", localVarQueryParams, policyUpdate,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set User Group Policy Roles
   * Sets the policy roles for multiple user groups for a policy.  Requires the \&quot;policies:edit\&quot; permission granted by the \&quot;edit\&quot; PolicyRole for that policy.
   * @param policyId  (required)
   * @param requestBody An object describing the requested new role for each user group to be changed. Note that there is no need to include user groups that you don&#39;t want to change. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Policy roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;policies:edit\&quot; permission for the requested policy </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy or one of the specified user groups does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserGroupRolesForPolicy(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nonnull Map<String, PolicyRole> requestBody) throws ApiException {
    updateUserGroupRolesForPolicyWithHttpInfo(policyId, requestBody);
  }

  /**
   * Set User Group Policy Roles
   * Sets the policy roles for multiple user groups for a policy.  Requires the \&quot;policies:edit\&quot; permission granted by the \&quot;edit\&quot; PolicyRole for that policy.
   * @param policyId  (required)
   * @param requestBody An object describing the requested new role for each user group to be changed. Note that there is no need to include user groups that you don&#39;t want to change. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Policy roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;policies:edit\&quot; permission for the requested policy </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy or one of the specified user groups does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserGroupRolesForPolicyWithHttpInfo(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nonnull Map<String, PolicyRole> requestBody) throws ApiException {
    // Check required parameters
    if (policyId == null) {
      throw new ApiException(400, "Missing the required parameter 'policyId' when calling updateUserGroupRolesForPolicy");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling updateUserGroupRolesForPolicy");
    }

    // Path parameters
    String localVarPath = "/x/policies/{policy-id}/roles/user-groups"
            .replaceAll("\\{policy-id}", apiClient.escapeString(policyId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("PoliciesApi.updateUserGroupRolesForPolicy", localVarPath, "PATCH", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Set User Policy Roles
   * Sets the policy roles for multiple users for a policy.  Requires the \&quot;policies:edit\&quot; permission granted by the \&quot;edit\&quot; PolicyRole for that policy.
   * @param policyId  (required)
   * @param requestBody An object describing the requested new role for each user to be changed. Note that there is no need to include users that you don&#39;t want to change. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Policy roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;policies:edit\&quot; permission for the requested policy </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy or one of the specified users does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserRolesForPolicy(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nonnull Map<String, PolicyRole> requestBody) throws ApiException {
    updateUserRolesForPolicyWithHttpInfo(policyId, requestBody);
  }

  /**
   * Set User Policy Roles
   * Sets the policy roles for multiple users for a policy.  Requires the \&quot;policies:edit\&quot; permission granted by the \&quot;edit\&quot; PolicyRole for that policy.
   * @param policyId  (required)
   * @param requestBody An object describing the requested new role for each user to be changed. Note that there is no need to include users that you don&#39;t want to change. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Policy roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;policies:edit\&quot; permission for the requested policy </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The policy or one of the specified users does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserRolesForPolicyWithHttpInfo(@jakarta.annotation.Nonnull Integer policyId, @jakarta.annotation.Nonnull Map<String, PolicyRole> requestBody) throws ApiException {
    // Check required parameters
    if (policyId == null) {
      throw new ApiException(400, "Missing the required parameter 'policyId' when calling updateUserRolesForPolicy");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling updateUserRolesForPolicy");
    }

    // Path parameters
    String localVarPath = "/x/policies/{policy-id}/roles/users"
            .replaceAll("\\{policy-id}", apiClient.escapeString(policyId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("PoliciesApi.updateUserRolesForPolicy", localVarPath, "PATCH", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
