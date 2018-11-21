# ProjectsApi

All URIs are relative to *http://localhost/codedx*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProject**](ProjectsApi.md#createProject) | **PUT** /api/projects | Create Project
[**deleteProject**](ProjectsApi.md#deleteProject) | **DELETE** /api/projects/{project-id} | Delete Project
[**getAllUserRoles**](ProjectsApi.md#getAllUserRoles) | **GET** /api/projects/{project-id}/user-roles | User Roles
[**getMappings**](ProjectsApi.md#getMappings) | **POST** /api/projects/{project-id}/files/mappings | File Mappings
[**getProjectFiles**](ProjectsApi.md#getProjectFiles) | **GET** /api/projects/{project-id}/files | Project Files
[**getProjects**](ProjectsApi.md#getProjects) | **GET** /api/projects | List Projects
[**getStatuses**](ProjectsApi.md#getStatuses) | **GET** /api/projects/{project-id}/statuses | Project Statuses
[**getUserRole**](ProjectsApi.md#getUserRole) | **GET** /api/projects/{project-id}/user-roles/user/{user-id} | User Role
[**queryProjects**](ProjectsApi.md#queryProjects) | **POST** /api/projects/query | Query Projects
[**updateProject**](ProjectsApi.md#updateProject) | **PUT** /api/projects/{project-id} | Update Project
[**updateUserRole**](ProjectsApi.md#updateUserRole) | **PUT** /api/projects/{project-id}/user-roles/user/{user-id} | Update User Role


<a name="createProject"></a>
# **createProject**
> createProject(project)

Create Project

Create a new project. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Project project = new Project(); // Project | Project to add, omit id.
try {
    apiInstance.createProject(project);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#createProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project** | [**Project**](Project.md)| Project to add, omit id. |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteProject"></a>
# **deleteProject**
> deleteProject(projectId)

Delete Project

Delete a project. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    apiInstance.deleteProject(projectId);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllUserRoles"></a>
# **getAllUserRoles**
> List&lt;UserRole&gt; getAllUserRoles(projectId)

User Roles

Provides a list of all User roles. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    List<UserRole> result = apiInstance.getAllUserRoles(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getAllUserRoles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

[**List&lt;UserRole&gt;**](UserRole.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMappings"></a>
# **getMappings**
> Map&lt;String, FileMapping&gt; getMappings(projectId, request)

File Mappings

Provides source path mappings for a project. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
MappingsRequest request = new MappingsRequest(); // MappingsRequest | 
try {
    Map<String, FileMapping> result = apiInstance.getMappings(projectId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **request** | [**MappingsRequest**](MappingsRequest.md)|  |

### Return type

[**Map&lt;String, FileMapping&gt;**](FileMapping.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProjectFiles"></a>
# **getProjectFiles**
> List&lt;ProjectFile&gt; getProjectFiles(projectId)

Project Files

Provides a list of files for a project. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    List<ProjectFile> result = apiInstance.getProjectFiles(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getProjectFiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

[**List&lt;ProjectFile&gt;**](ProjectFile.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getProjects"></a>
# **getProjects**
> Projects getProjects()

List Projects

Lists all projects. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
try {
    Projects result = apiInstance.getProjects();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getProjects");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Projects**](Projects.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getStatuses"></a>
# **getStatuses**
> Map&lt;String, Status&gt; getStatuses(projectId)

Project Statuses

Provides information on all valid triage statuses for a project. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
try {
    Map<String, Status> result = apiInstance.getStatuses(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getStatuses");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |

### Return type

[**Map&lt;String, Status&gt;**](Status.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUserRole"></a>
# **getUserRole**
> UserRole getUserRole(projectId, userId)

User Role

Provides a User Role for a given user. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
Integer userId = 56; // Integer | The user ID.
try {
    UserRole result = apiInstance.getUserRole(projectId, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getUserRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **userId** | **Integer**| The user ID. |

### Return type

[**UserRole**](UserRole.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="queryProjects"></a>
# **queryProjects**
> List&lt;ProjectQueryResponse&gt; queryProjects(query)

Query Projects

Get a list of projects which match some filter/query criteria, and which you are allowed to view. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
ProjectQuery query = new ProjectQuery(); // ProjectQuery | Should be a JSON object with a \"filter\" field, which is an object with the following fields&#58; - `name` - an optional String. If given, specifies that each matching project should contain the given text in their name (case-insensitive) - `metadata` - an optional Object. If given, specifies that each matching project's metadata should match the criteria given in the metadata object  Both `name` and `metadata` are optional in the filter object, but the filter object is mandatory. A blank `filter` object matches all projects. The `filter.metadata` Object's keys and values should be the names of Project Metadata Fields and their respective search criteria. The value for each field will be interpreted according to that field's type&#58; - **Text** and **Multiline** fields will check if the value is present in the project's value for that field (case-insensitive) - **Tags** fields will interpret the value as a set of tags, and will check if the project's tags contains at least one of them (case-insensitive) - **Dropdown** fields will check if the project's selected value is equal to the criteria value (case-insensitive)  Note that in some cases, you may need to specify the metadata field by its ID (e.g. if two different fields have the same name, or if you simply would prefer to use ID instead of name). In these cases, you can use a string in the format `id:<ID>` (e.g. `id:3`) in place of the field name as a key in the metadata criteria object. 
try {
    List<ProjectQueryResponse> result = apiInstance.queryProjects(query);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#queryProjects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | [**ProjectQuery**](ProjectQuery.md)| Should be a JSON object with a \&quot;filter\&quot; field, which is an object with the following fields&amp;#58; - &#x60;name&#x60; - an optional String. If given, specifies that each matching project should contain the given text in their name (case-insensitive) - &#x60;metadata&#x60; - an optional Object. If given, specifies that each matching project&#39;s metadata should match the criteria given in the metadata object  Both &#x60;name&#x60; and &#x60;metadata&#x60; are optional in the filter object, but the filter object is mandatory. A blank &#x60;filter&#x60; object matches all projects. The &#x60;filter.metadata&#x60; Object&#39;s keys and values should be the names of Project Metadata Fields and their respective search criteria. The value for each field will be interpreted according to that field&#39;s type&amp;#58; - **Text** and **Multiline** fields will check if the value is present in the project&#39;s value for that field (case-insensitive) - **Tags** fields will interpret the value as a set of tags, and will check if the project&#39;s tags contains at least one of them (case-insensitive) - **Dropdown** fields will check if the project&#39;s selected value is equal to the criteria value (case-insensitive)  Note that in some cases, you may need to specify the metadata field by its ID (e.g. if two different fields have the same name, or if you simply would prefer to use ID instead of name). In these cases, you can use a string in the format &#x60;id:&lt;ID&gt;&#x60; (e.g. &#x60;id:3&#x60;) in place of the field name as a key in the metadata criteria object.  |

### Return type

[**List&lt;ProjectQueryResponse&gt;**](ProjectQueryResponse.md)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateProject"></a>
# **updateProject**
> updateProject(projectId, body)

Update Project

Update a project by changing its name or parent 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
UpdateProject body = new UpdateProject(); // UpdateProject | Request Body should be a JSON object with the following fields#58; - `name` (String) if provided, specifies the new name for the project - `parentId` (Number | null) if provided, specifies the ID of the project's parent (for project grouping) 
try {
    apiInstance.updateProject(projectId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updateProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **body** | [**UpdateProject**](UpdateProject.md)| Request Body should be a JSON object with the following fields#58; - &#x60;name&#x60; (String) if provided, specifies the new name for the project - &#x60;parentId&#x60; (Number | null) if provided, specifies the ID of the project&#39;s parent (for project grouping)  |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateUserRole"></a>
# **updateUserRole**
> updateUserRole(projectId, userId, request)

Update User Role

Allows changing user roles. Note that you must specify the entire set of roles each time; if you fail to include a role when using this method, the user will lose that role. 

### Example
```java
// Import classes:
//import com.avi.codedx.client.ApiClient;
//import com.avi.codedx.client.ApiException;
//import com.avi.codedx.client.Configuration;
//import com.avi.codedx.client.auth.*;
//import com.avi.codedx.client.api.ProjectsApi;

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

ProjectsApi apiInstance = new ProjectsApi();
Integer projectId = 56; // Integer | The ID of the project.
Integer userId = 56; // Integer | The user ID.
Roles request = new Roles(); // Roles | 
try {
    apiInstance.updateUserRole(projectId, userId, request);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updateUserRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Integer**| The ID of the project. |
 **userId** | **Integer**| The user ID. |
 **request** | [**Roles**](Roles.md)|  |

### Return type

null (empty response body)

### Authorization

[APIKeyHeader](../README.md#APIKeyHeader), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

