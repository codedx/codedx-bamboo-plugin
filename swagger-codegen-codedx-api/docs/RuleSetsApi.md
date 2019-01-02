# RuleSetsApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRuleCriteria**](RuleSetsApi.md#addRuleCriteria) | **POST** /api/ruleset/{ruleset-id}/rule/{rule-id}/criteria | Add Rule Criteria
[**cloneRuleSet**](RuleSetsApi.md#cloneRuleSet) | **POST** /api/ruleset/{ruleset-id}/clone | Clone Rule Set
[**createRule**](RuleSetsApi.md#createRule) | **POST** /api/ruleset/{ruleset-id}/rule | Create Rule
[**createRuleSet**](RuleSetsApi.md#createRuleSet) | **POST** /api/ruleset | Create Rule Set
[**deleteRule**](RuleSetsApi.md#deleteRule) | **DELETE** /api/ruleset/{ruleset-id}/rule/{rule-id} | Delete Rule
[**deleteRuleCriteria**](RuleSetsApi.md#deleteRuleCriteria) | **DELETE** /api/ruleset/{ruleset-id}/rule/{rule-id}/criteria | Delete Rule Criteria
[**deleteRuleSet**](RuleSetsApi.md#deleteRuleSet) | **DELETE** /api/ruleset/{ruleset-id} | Delete Rule Set
[**exportRuleSet**](RuleSetsApi.md#exportRuleSet) | **GET** /api/ruleset/{ruleset-id}/export | Export Rule Set
[**getAllRuleSets**](RuleSetsApi.md#getAllRuleSets) | **GET** /api/ruleset/all | Get Rule Sets
[**getRuleData**](RuleSetsApi.md#getRuleData) | **GET** /api/ruleset/{ruleset-id}/rule/{rule-id} | Get Rule Data
[**getRuleSetContents**](RuleSetsApi.md#getRuleSetContents) | **GET** /api/ruleset/{ruleset-id} | Get Rule Set Contents
[**modifyRuleData**](RuleSetsApi.md#modifyRuleData) | **PUT** /api/ruleset/{ruleset-id}/rule/{rule-id} | Modify Rule Descriptor
[**renameRuleSet**](RuleSetsApi.md#renameRuleSet) | **PUT** /api/ruleset/{ruleset-id} | Rename Rule Set
[**updateRuleSet**](RuleSetsApi.md#updateRuleSet) | **POST** /api/ruleset/{ruleset-id}/update | Update Rule Set
[**uploadRuleSet**](RuleSetsApi.md#uploadRuleSet) | **POST** /api/ruleset/import | Import Rule Set


<a name="addRuleCriteria"></a>
# **addRuleCriteria**
> addRuleCriteria(rulesetId, ruleId, ruleCriteria)

Add Rule Criteria

Allows user to add rule criteria

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
Integer ruleId = 56; // Integer | 
RuleCriteria ruleCriteria = new RuleCriteria(); // RuleCriteria | 
try {
    apiInstance.addRuleCriteria(rulesetId, ruleId, ruleCriteria);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#addRuleCriteria");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **ruleId** | **Integer**|  |
 **ruleCriteria** | [**RuleCriteria**](RuleCriteria.md)|  |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="cloneRuleSet"></a>
# **cloneRuleSet**
> RuleSet cloneRuleSet(rulesetId, ruleSet)

Clone Rule Set

Allows user to clone a rule set

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
RuleSet ruleSet = new RuleSet(); // RuleSet | The values for `id` and `canEdit` will be ignored, only `name` is required
try {
    RuleSet result = apiInstance.cloneRuleSet(rulesetId, ruleSet);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#cloneRuleSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **ruleSet** | [**RuleSet**](RuleSet.md)| The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required |

### Return type

[**RuleSet**](RuleSet.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createRule"></a>
# **createRule**
> Rule createRule(rulesetId, rule)

Create Rule

Allows user to create a Rule

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
CreateRule rule = new CreateRule(); // CreateRule | 
try {
    Rule result = apiInstance.createRule(rulesetId, rule);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#createRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **rule** | [**CreateRule**](CreateRule.md)|  |

### Return type

[**Rule**](Rule.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createRuleSet"></a>
# **createRuleSet**
> RuleSet createRuleSet(ruleSet)

Create Rule Set

Creates a rule set

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
RuleSet ruleSet = new RuleSet(); // RuleSet | The values for `id` and `canEdit` will be ignored, only `name` is required
try {
    RuleSet result = apiInstance.createRuleSet(ruleSet);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#createRuleSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleSet** | [**RuleSet**](RuleSet.md)| The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required |

### Return type

[**RuleSet**](RuleSet.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteRule"></a>
# **deleteRule**
> deleteRule(rulesetId, ruleId)

Delete Rule

Allows user to delete a rule

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
Integer ruleId = 56; // Integer | 
try {
    apiInstance.deleteRule(rulesetId, ruleId);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#deleteRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **ruleId** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteRuleCriteria"></a>
# **deleteRuleCriteria**
> deleteRuleCriteria(rulesetId, ruleId, ruleCriteria)

Delete Rule Criteria

Allows user to delete rule criteria

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
Integer ruleId = 56; // Integer | 
RuleCriteria ruleCriteria = new RuleCriteria(); // RuleCriteria | 
try {
    apiInstance.deleteRuleCriteria(rulesetId, ruleId, ruleCriteria);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#deleteRuleCriteria");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **ruleId** | **Integer**|  |
 **ruleCriteria** | [**RuleCriteria**](RuleCriteria.md)|  |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteRuleSet"></a>
# **deleteRuleSet**
> RuleSetDeleteResponse deleteRuleSet(rulesetId, force)

Delete Rule Set

Allows user to delete a rule set

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
Boolean force = true; // Boolean | Set to true to force delete the rule set
try {
    RuleSetDeleteResponse result = apiInstance.deleteRuleSet(rulesetId, force);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#deleteRuleSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **force** | **Boolean**| Set to true to force delete the rule set | [optional]

### Return type

[**RuleSetDeleteResponse**](RuleSetDeleteResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="exportRuleSet"></a>
# **exportRuleSet**
> File exportRuleSet(rulesetId)

Export Rule Set

Allows user to export a rule set as an XML file

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
try {
    File result = apiInstance.exportRuleSet(rulesetId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#exportRuleSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |

### Return type

[**File**](File.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/xml

<a name="getAllRuleSets"></a>
# **getAllRuleSets**
> List&lt;RuleSet&gt; getAllRuleSets()

Get Rule Sets

Provides a list of rule sets

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
try {
    List<RuleSet> result = apiInstance.getAllRuleSets();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#getAllRuleSets");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;RuleSet&gt;**](RuleSet.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRuleData"></a>
# **getRuleData**
> Rule getRuleData(rulesetId, ruleId)

Get Rule Data

Allows user to view a specific rule&#39;s data

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
Integer ruleId = 56; // Integer | 
try {
    Rule result = apiInstance.getRuleData(rulesetId, ruleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#getRuleData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **ruleId** | **Integer**|  |

### Return type

[**Rule**](Rule.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getRuleSetContents"></a>
# **getRuleSetContents**
> RuleSetContents getRuleSetContents(rulesetId)

Get Rule Set Contents

Returns an object representing the contents of a rule set

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
try {
    RuleSetContents result = apiInstance.getRuleSetContents(rulesetId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#getRuleSetContents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |

### Return type

[**RuleSetContents**](RuleSetContents.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="modifyRuleData"></a>
# **modifyRuleData**
> ModifyRuleResponse modifyRuleData(rulesetId, ruleId, rule)

Modify Rule Descriptor

Allows user to modify a specific rule&#39;s data

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
Integer ruleId = 56; // Integer | 
CreateRule rule = new CreateRule(); // CreateRule | 
try {
    ModifyRuleResponse result = apiInstance.modifyRuleData(rulesetId, ruleId, rule);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#modifyRuleData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **ruleId** | **Integer**|  |
 **rule** | [**CreateRule**](CreateRule.md)|  |

### Return type

[**ModifyRuleResponse**](ModifyRuleResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="renameRuleSet"></a>
# **renameRuleSet**
> RuleSet renameRuleSet(rulesetId, ruleSet)

Rename Rule Set

Allows user to rename a rule set

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
Integer rulesetId = 56; // Integer | 
RuleSet ruleSet = new RuleSet(); // RuleSet | The values for `id` and `canEdit` will be ignored, only `name` is required
try {
    RuleSet result = apiInstance.renameRuleSet(rulesetId, ruleSet);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#renameRuleSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rulesetId** | **Integer**|  |
 **ruleSet** | [**RuleSet**](RuleSet.md)| The values for &#x60;id&#x60; and &#x60;canEdit&#x60; will be ignored, only &#x60;name&#x60; is required |

### Return type

[**RuleSet**](RuleSet.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateRuleSet"></a>
# **updateRuleSet**
> RuleSet updateRuleSet(ruleSetXml, rulesetId)

Update Rule Set

Update rule set using an XML file

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
File ruleSetXml = new File("/path/to/file.txt"); // File | The xml file to be uploaded
Integer rulesetId = 56; // Integer | 
try {
    RuleSet result = apiInstance.updateRuleSet(ruleSetXml, rulesetId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#updateRuleSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleSetXml** | **File**| The xml file to be uploaded |
 **rulesetId** | **Integer**|  |

### Return type

[**RuleSet**](RuleSet.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="uploadRuleSet"></a>
# **uploadRuleSet**
> RuleSet uploadRuleSet(ruleSetXml)

Import Rule Set

Import rule set using an XML file

### Example
```java
// Import classes:
//import com.codedx.client.ApiClient;
//import com.codedx.client.ApiException;
//import com.codedx.client.Configuration;
//import com.codedx.client.auth.*;
//import com.codedx.client.api.RuleSetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: APIKeyHeader
ApiKeyAuth APIKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("APIKeyHeader");
APIKeyHeader.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//APIKeyHeader.setApiKeyPrefix("Token");

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RuleSetsApi apiInstance = new RuleSetsApi();
File ruleSetXml = new File("/path/to/file.txt"); // File | The xml file to be uploaded
try {
    RuleSet result = apiInstance.uploadRuleSet(ruleSetXml);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleSetsApi#uploadRuleSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleSetXml** | **File**| The xml file to be uploaded |

### Return type

[**RuleSet**](RuleSet.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

