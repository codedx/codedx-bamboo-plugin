package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.CreateRule;
import java.io.File;
import com.codedx.client.model.ModifyRuleResponse;
import com.codedx.client.model.Rule;
import com.codedx.client.model.RuleCriteria;
import com.codedx.client.model.RuleSet;
import com.codedx.client.model.RuleSetContents;
import com.codedx.client.model.RuleSetDeleteError;
import com.codedx.client.model.RuleSetDeleteResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class RuleSetsApi {
  private ApiClient apiClient;

  public RuleSetsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RuleSetsApi(ApiClient apiClient) {
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
   * Add Rule Criteria
   * Allows user to add rule criteria.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @param ruleCriteria  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Criteria was successfully created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void addRuleCriteria(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId, @jakarta.annotation.Nonnull RuleCriteria ruleCriteria) throws ApiException {
    addRuleCriteriaWithHttpInfo(rulesetId, ruleId, ruleCriteria);
  }

  /**
   * Add Rule Criteria
   * Allows user to add rule criteria.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @param ruleCriteria  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Criteria was successfully created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> addRuleCriteriaWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId, @jakarta.annotation.Nonnull RuleCriteria ruleCriteria) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling addRuleCriteria");
    }
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling addRuleCriteria");
    }
    if (ruleCriteria == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleCriteria' when calling addRuleCriteria");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}/criteria"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()))
            .replaceAll("\\{rule-id}", apiClient.escapeString(ruleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("RuleSetsApi.addRuleCriteria", localVarPath, "POST", new ArrayList<>(), ruleCriteria,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Clone Rule Set
   * Allows user to clone a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSet object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public RuleSet cloneRuleSet(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull RuleSet ruleSet) throws ApiException {
    return cloneRuleSetWithHttpInfo(rulesetId, ruleSet).getData();
  }

  /**
   * Clone Rule Set
   * Allows user to clone a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required (required)
   * @return ApiResponse&lt;RuleSet&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSet object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RuleSet> cloneRuleSetWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull RuleSet ruleSet) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling cloneRuleSet");
    }
    if (ruleSet == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSet' when calling cloneRuleSet");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/clone"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI("RuleSetsApi.cloneRuleSet", localVarPath, "POST", new ArrayList<>(), ruleSet,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create Rule
   * Allows user to create a Rule.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param createRule  (required)
   * @return Rule
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the created Rule </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Rule createRule(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull CreateRule createRule) throws ApiException {
    return createRuleWithHttpInfo(rulesetId, createRule).getData();
  }

  /**
   * Create Rule
   * Allows user to create a Rule.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param createRule  (required)
   * @return ApiResponse&lt;Rule&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the created Rule </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Rule> createRuleWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull CreateRule createRule) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling createRule");
    }
    if (createRule == null) {
      throw new ApiException(400, "Missing the required parameter 'createRule' when calling createRule");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/rule"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Rule> localVarReturnType = new GenericType<Rule>() {};
    return apiClient.invokeAPI("RuleSetsApi.createRule", localVarPath, "POST", new ArrayList<>(), createRule,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create Rule Set
   * Creates a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required. (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSet object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public RuleSet createRuleSet(@jakarta.annotation.Nonnull RuleSet ruleSet) throws ApiException {
    return createRuleSetWithHttpInfo(ruleSet).getData();
  }

  /**
   * Create Rule Set
   * Creates a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required. (required)
   * @return ApiResponse&lt;RuleSet&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSet object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RuleSet> createRuleSetWithHttpInfo(@jakarta.annotation.Nonnull RuleSet ruleSet) throws ApiException {
    // Check required parameters
    if (ruleSet == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSet' when calling createRuleSet");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI("RuleSetsApi.createRuleSet", "/api/ruleset", "POST", new ArrayList<>(), ruleSet,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Rule
   * Allows user to delete a rule.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Rule was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteRule(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId) throws ApiException {
    deleteRuleWithHttpInfo(rulesetId, ruleId);
  }

  /**
   * Delete Rule
   * Allows user to delete a rule.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Rule was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteRuleWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling deleteRule");
    }
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling deleteRule");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()))
            .replaceAll("\\{rule-id}", apiClient.escapeString(ruleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("RuleSetsApi.deleteRule", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Rule Criteria
   * Allows user to delete rule criteria.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Criteria was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteRuleCriteria(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId) throws ApiException {
    deleteRuleCriteriaWithHttpInfo(rulesetId, ruleId);
  }

  /**
   * Delete Rule Criteria
   * Allows user to delete rule criteria.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Criteria was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteRuleCriteriaWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling deleteRuleCriteria");
    }
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling deleteRuleCriteria");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}/criteria"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()))
            .replaceAll("\\{rule-id}", apiClient.escapeString(ruleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("RuleSetsApi.deleteRuleCriteria", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Rule Set
   * Allows user to delete a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @return RuleSetDeleteResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSetDeleteResponse object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - One or more projects are configured to use the &#39;i renamed this using swagger&#39; Rule Set. Use &#x60;force&#x3D;true&#x60; in the query string to automatically reconfigure each of them to use the default Rule Set instead. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public RuleSetDeleteResponse deleteRuleSet(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    return deleteRuleSetWithHttpInfo(rulesetId, force).getData();
  }

  /**
   * Delete Rule Set
   * Allows user to delete a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param force If set to &#x60;true&#x60;, this will force the operation. Defaults to &#x60;false&#x60;. (optional)
   * @return ApiResponse&lt;RuleSetDeleteResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSetDeleteResponse object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - One or more projects are configured to use the &#39;i renamed this using swagger&#39; Rule Set. Use &#x60;force&#x3D;true&#x60; in the query string to automatically reconfigure each of them to use the default Rule Set instead. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RuleSetDeleteResponse> deleteRuleSetWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling deleteRuleSet");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<RuleSetDeleteResponse> localVarReturnType = new GenericType<RuleSetDeleteResponse>() {};
    return apiClient.invokeAPI("RuleSetsApi.deleteRuleSet", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Export Rule Set
   * Allows user to export a rule set as an XML file.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an XML file representing the Rule Set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public File exportRuleSet(@jakarta.annotation.Nonnull Integer rulesetId) throws ApiException {
    return exportRuleSetWithHttpInfo(rulesetId).getData();
  }

  /**
   * Export Rule Set
   * Allows user to export a rule set as an XML file.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains an XML file representing the Rule Set </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportRuleSetWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling exportRuleSet");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/export"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("text/xml");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("RuleSetsApi.exportRuleSet", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Rule Sets
   * Provides a list of rule sets.  Requires no role, all users have sufficient permissions by default.
   * @return List&lt;RuleSet&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of rule sets </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<RuleSet> getAllRuleSets() throws ApiException {
    return getAllRuleSetsWithHttpInfo().getData();
  }

  /**
   * Get Rule Sets
   * Provides a list of rule sets.  Requires no role, all users have sufficient permissions by default.
   * @return ApiResponse&lt;List&lt;RuleSet&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a list of rule sets </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<RuleSet>> getAllRuleSetsWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<RuleSet>> localVarReturnType = new GenericType<List<RuleSet>>() {};
    return apiClient.invokeAPI("RuleSetsApi.getAllRuleSets", "/api/ruleset/all", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Rule Data
   * Allows user to view a specific rule&#39;s data.  Requires no role, all users have sufficient permissions by default.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @return Rule
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the Rule </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Rule getRuleData(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId) throws ApiException {
    return getRuleDataWithHttpInfo(rulesetId, ruleId).getData();
  }

  /**
   * Get Rule Data
   * Allows user to view a specific rule&#39;s data.  Requires no role, all users have sufficient permissions by default.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @return ApiResponse&lt;Rule&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the Rule </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Rule> getRuleDataWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling getRuleData");
    }
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling getRuleData");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()))
            .replaceAll("\\{rule-id}", apiClient.escapeString(ruleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Rule> localVarReturnType = new GenericType<Rule>() {};
    return apiClient.invokeAPI("RuleSetsApi.getRuleData", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Rule Set Contents
   * Returns an object representing the contents of a rule set.  Requires no role, all users have sufficient permissions by default.
   * @param rulesetId  (required)
   * @return RuleSetContents
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSetContents object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public RuleSetContents getRuleSetContents(@jakarta.annotation.Nonnull Integer rulesetId) throws ApiException {
    return getRuleSetContentsWithHttpInfo(rulesetId).getData();
  }

  /**
   * Get Rule Set Contents
   * Returns an object representing the contents of a rule set.  Requires no role, all users have sufficient permissions by default.
   * @param rulesetId  (required)
   * @return ApiResponse&lt;RuleSetContents&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSetContents object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RuleSetContents> getRuleSetContentsWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling getRuleSetContents");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<RuleSetContents> localVarReturnType = new GenericType<RuleSetContents>() {};
    return apiClient.invokeAPI("RuleSetsApi.getRuleSetContents", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Modify Rule Descriptor
   * Allows user to modify a specific rule&#39;s data.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @param createRule  (required)
   * @return ModifyRuleResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains information about the modified rule </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ModifyRuleResponse modifyRuleData(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId, @jakarta.annotation.Nonnull CreateRule createRule) throws ApiException {
    return modifyRuleDataWithHttpInfo(rulesetId, ruleId, createRule).getData();
  }

  /**
   * Modify Rule Descriptor
   * Allows user to modify a specific rule&#39;s data.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @param createRule  (required)
   * @return ApiResponse&lt;ModifyRuleResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains information about the modified rule </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Specified Rule Set or Rule does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ModifyRuleResponse> modifyRuleDataWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull Integer ruleId, @jakarta.annotation.Nonnull CreateRule createRule) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling modifyRuleData");
    }
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling modifyRuleData");
    }
    if (createRule == null) {
      throw new ApiException(400, "Missing the required parameter 'createRule' when calling modifyRuleData");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()))
            .replaceAll("\\{rule-id}", apiClient.escapeString(ruleId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<ModifyRuleResponse> localVarReturnType = new GenericType<ModifyRuleResponse>() {};
    return apiClient.invokeAPI("RuleSetsApi.modifyRuleData", localVarPath, "PUT", new ArrayList<>(), createRule,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Rename Rule Set
   * Allows user to rename a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSet object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public RuleSet renameRuleSet(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull RuleSet ruleSet) throws ApiException {
    return renameRuleSetWithHttpInfo(rulesetId, ruleSet).getData();
  }

  /**
   * Rename Rule Set
   * Allows user to rename a rule set.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required (required)
   * @return ApiResponse&lt;RuleSet&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains a RuleSet object </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Rule Set with specified ID does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RuleSet> renameRuleSetWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull RuleSet ruleSet) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling renameRuleSet");
    }
    if (ruleSet == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSet' when calling renameRuleSet");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI("RuleSetsApi.renameRuleSet", localVarPath, "PUT", new ArrayList<>(), ruleSet,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update Rule Set
   * Update rule set using an XML file.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleSetXml The xml file to be uploaded (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated Rule Set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Incorrect file format </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public RuleSet updateRuleSet(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull File ruleSetXml) throws ApiException {
    return updateRuleSetWithHttpInfo(rulesetId, ruleSetXml).getData();
  }

  /**
   * Update Rule Set
   * Update rule set using an XML file.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param rulesetId  (required)
   * @param ruleSetXml The xml file to be uploaded (required)
   * @return ApiResponse&lt;RuleSet&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the updated Rule Set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Incorrect file format </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RuleSet> updateRuleSetWithHttpInfo(@jakarta.annotation.Nonnull Integer rulesetId, @jakarta.annotation.Nonnull File ruleSetXml) throws ApiException {
    // Check required parameters
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling updateRuleSet");
    }
    if (ruleSetXml == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSetXml' when calling updateRuleSet");
    }

    // Path parameters
    String localVarPath = "/api/ruleset/{ruleset-id}/update"
            .replaceAll("\\{ruleset-id}", apiClient.escapeString(rulesetId.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("ruleSetXml", ruleSetXml);

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI("RuleSetsApi.updateRuleSet", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Import Rule Set
   * Import rule set using an XML file.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param ruleSetXml The xml file to be uploaded (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the newly created Rule Set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Incorrect file format </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public RuleSet uploadRuleSet(@jakarta.annotation.Nonnull File ruleSetXml) throws ApiException {
    return uploadRuleSetWithHttpInfo(ruleSetXml).getData();
  }

  /**
   * Import Rule Set
   * Import rule set using an XML file.  Requires the \&quot;rule-set:manage\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param ruleSetXml The xml file to be uploaded (required)
   * @return ApiResponse&lt;RuleSet&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Contains the newly created Rule Set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Incorrect file format </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - User does not have permission </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RuleSet> uploadRuleSetWithHttpInfo(@jakarta.annotation.Nonnull File ruleSetXml) throws ApiException {
    // Check required parameters
    if (ruleSetXml == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSetXml' when calling uploadRuleSet");
    }

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("ruleSetXml", ruleSetXml);

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI("RuleSetsApi.uploadRuleSet", "/api/ruleset/import", "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
