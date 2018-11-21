package com.avi.codedx.client.api;

import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.Configuration;
import com.avi.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.avi.codedx.client.api.CreateRule;
import java.io.File;
import com.avi.codedx.client.api.ModifyRuleResponse;
import com.avi.codedx.client.api.Rule;
import com.avi.codedx.client.api.RuleCriteria;
import com.avi.codedx.client.api.RuleSet;
import com.avi.codedx.client.api.RuleSetContents;
import com.avi.codedx.client.api.RuleSetDeleteError;
import com.avi.codedx.client.api.RuleSetDeleteResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-20T12:12:25.399-04:00")
public class RuleSetsApi {
  private ApiClient apiClient;

  public RuleSetsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RuleSetsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Add Rule Criteria
   * Allows user to add rule criteria
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @param ruleCriteria  (required)
   * @throws ApiException if fails to make API call
   */
  public void addRuleCriteria(Integer rulesetId, Integer ruleId, RuleCriteria ruleCriteria) throws ApiException {
    Object localVarPostBody = ruleCriteria;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling addRuleCriteria");
    }
    
    // verify the required parameter 'ruleId' is set
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling addRuleCriteria");
    }
    
    // verify the required parameter 'ruleCriteria' is set
    if (ruleCriteria == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleCriteria' when calling addRuleCriteria");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}/criteria"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()))
      .replaceAll("\\{" + "rule-id" + "\\}", apiClient.escapeString(ruleId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Clone Rule Set
   * Allows user to clone a rule set
   * @param rulesetId  (required)
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   */
  public RuleSet cloneRuleSet(Integer rulesetId, RuleSet ruleSet) throws ApiException {
    Object localVarPostBody = ruleSet;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling cloneRuleSet");
    }
    
    // verify the required parameter 'ruleSet' is set
    if (ruleSet == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSet' when calling cloneRuleSet");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/clone"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create Rule
   * Allows user to create a Rule
   * @param rulesetId  (required)
   * @param rule  (required)
   * @return Rule
   * @throws ApiException if fails to make API call
   */
  public Rule createRule(Integer rulesetId, CreateRule rule) throws ApiException {
    Object localVarPostBody = rule;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling createRule");
    }
    
    // verify the required parameter 'rule' is set
    if (rule == null) {
      throw new ApiException(400, "Missing the required parameter 'rule' when calling createRule");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/rule"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Rule> localVarReturnType = new GenericType<Rule>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create Rule Set
   * Creates a rule set
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   */
  public RuleSet createRuleSet(RuleSet ruleSet) throws ApiException {
    Object localVarPostBody = ruleSet;
    
    // verify the required parameter 'ruleSet' is set
    if (ruleSet == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSet' when calling createRuleSet");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset";

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

    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete Rule
   * Allows user to delete a rule
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteRule(Integer rulesetId, Integer ruleId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling deleteRule");
    }
    
    // verify the required parameter 'ruleId' is set
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling deleteRule");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()))
      .replaceAll("\\{" + "rule-id" + "\\}", apiClient.escapeString(ruleId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Delete Rule Criteria
   * Allows user to delete rule criteria
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @param ruleCriteria  (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteRuleCriteria(Integer rulesetId, Integer ruleId, RuleCriteria ruleCriteria) throws ApiException {
    Object localVarPostBody = ruleCriteria;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling deleteRuleCriteria");
    }
    
    // verify the required parameter 'ruleId' is set
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling deleteRuleCriteria");
    }
    
    // verify the required parameter 'ruleCriteria' is set
    if (ruleCriteria == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleCriteria' when calling deleteRuleCriteria");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}/criteria"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()))
      .replaceAll("\\{" + "rule-id" + "\\}", apiClient.escapeString(ruleId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Delete Rule Set
   * Allows user to delete a rule set
   * @param rulesetId  (required)
   * @param force Set to true to force delete the rule set (optional)
   * @return RuleSetDeleteResponse
   * @throws ApiException if fails to make API call
   */
  public RuleSetDeleteResponse deleteRuleSet(Integer rulesetId, Boolean force) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling deleteRuleSet");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "force", force));

    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<RuleSetDeleteResponse> localVarReturnType = new GenericType<RuleSetDeleteResponse>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Export Rule Set
   * Allows user to export a rule set as an XML file
   * @param rulesetId  (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File exportRuleSet(Integer rulesetId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling exportRuleSet");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/export"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "text/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Rule Sets
   * Provides a list of rule sets
   * @return List&lt;RuleSet&gt;
   * @throws ApiException if fails to make API call
   */
  public List<RuleSet> getAllRuleSets() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/ruleset/all";

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

    GenericType<List<RuleSet>> localVarReturnType = new GenericType<List<RuleSet>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Rule Data
   * Allows user to view a specific rule&#39;s data
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @return Rule
   * @throws ApiException if fails to make API call
   */
  public Rule getRuleData(Integer rulesetId, Integer ruleId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling getRuleData");
    }
    
    // verify the required parameter 'ruleId' is set
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling getRuleData");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()))
      .replaceAll("\\{" + "rule-id" + "\\}", apiClient.escapeString(ruleId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Rule> localVarReturnType = new GenericType<Rule>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Rule Set Contents
   * Returns an object representing the contents of a rule set
   * @param rulesetId  (required)
   * @return RuleSetContents
   * @throws ApiException if fails to make API call
   */
  public RuleSetContents getRuleSetContents(Integer rulesetId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling getRuleSetContents");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<RuleSetContents> localVarReturnType = new GenericType<RuleSetContents>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Modify Rule Descriptor
   * Allows user to modify a specific rule&#39;s data
   * @param rulesetId  (required)
   * @param ruleId  (required)
   * @param rule  (required)
   * @return ModifyRuleResponse
   * @throws ApiException if fails to make API call
   */
  public ModifyRuleResponse modifyRuleData(Integer rulesetId, Integer ruleId, CreateRule rule) throws ApiException {
    Object localVarPostBody = rule;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling modifyRuleData");
    }
    
    // verify the required parameter 'ruleId' is set
    if (ruleId == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleId' when calling modifyRuleData");
    }
    
    // verify the required parameter 'rule' is set
    if (rule == null) {
      throw new ApiException(400, "Missing the required parameter 'rule' when calling modifyRuleData");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/rule/{rule-id}"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()))
      .replaceAll("\\{" + "rule-id" + "\\}", apiClient.escapeString(ruleId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<ModifyRuleResponse> localVarReturnType = new GenericType<ModifyRuleResponse>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Rename Rule Set
   * Allows user to rename a rule set
   * @param rulesetId  (required)
   * @param ruleSet The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   */
  public RuleSet renameRuleSet(Integer rulesetId, RuleSet ruleSet) throws ApiException {
    Object localVarPostBody = ruleSet;
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling renameRuleSet");
    }
    
    // verify the required parameter 'ruleSet' is set
    if (ruleSet == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSet' when calling renameRuleSet");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update Rule Set
   * Update rule set using an XML file
   * @param ruleSetXml The xml file to be uploaded (required)
   * @param rulesetId  (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   */
  public RuleSet updateRuleSet(File ruleSetXml, Integer rulesetId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'ruleSetXml' is set
    if (ruleSetXml == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSetXml' when calling updateRuleSet");
    }
    
    // verify the required parameter 'rulesetId' is set
    if (rulesetId == null) {
      throw new ApiException(400, "Missing the required parameter 'rulesetId' when calling updateRuleSet");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/{ruleset-id}/update"
      .replaceAll("\\{" + "ruleset-id" + "\\}", apiClient.escapeString(rulesetId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    if (ruleSetXml != null)
      localVarFormParams.put("ruleSetXml", ruleSetXml);

    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Import Rule Set
   * Import rule set using an XML file
   * @param ruleSetXml The xml file to be uploaded (required)
   * @return RuleSet
   * @throws ApiException if fails to make API call
   */
  public RuleSet uploadRuleSet(File ruleSetXml) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'ruleSetXml' is set
    if (ruleSetXml == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSetXml' when calling uploadRuleSet");
    }
    
    // create path and map variables
    String localVarPath = "/api/ruleset/import";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    if (ruleSetXml != null)
      localVarFormParams.put("ruleSetXml", ruleSetXml);

    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<RuleSet> localVarReturnType = new GenericType<RuleSet>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
