package com.avi.codedx.client.api;

import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.Configuration;
import com.avi.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.avi.codedx.client.api.Metadata;
import com.avi.codedx.client.api.MetadataUpdate;
import com.avi.codedx.client.api.MetadataValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-27T11:18:43.181-05:00")
public class MetadataApi {
  private ApiClient apiClient;

  public MetadataApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MetadataApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create Project Metadata Field
   * Creates a project metadata field. The request body should contain a Project Metadata Field object, excluding anys ids that should be generated by the API itself.  
   * @param metadata  (required)
   * @return Metadata
   * @throws ApiException if fails to make API call
   */
  public Metadata createMetadataField(Metadata metadata) throws ApiException {
    Object localVarPostBody = metadata;
    
    // verify the required parameter 'metadata' is set
    if (metadata == null) {
      throw new ApiException(400, "Missing the required parameter 'metadata' when calling createMetadataField");
    }
    
    // create path and map variables
    String localVarPath = "/api/project-fields";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Metadata> localVarReturnType = new GenericType<Metadata>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete Project Metadata Field
   * 
   * @param fieldId The ID of the metadata field. (required)
   * @param force If set to &#x60;true&#x60;, this method will delete the field even if one or more projects had a value configured for that field. Defaults to &#x60;false&#x60;. (optional)
   * @throws ApiException if fails to make API call
   */
  public void deleteMetadata(Integer fieldId, Boolean force) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'fieldId' is set
    if (fieldId == null) {
      throw new ApiException(400, "Missing the required parameter 'fieldId' when calling deleteMetadata");
    }
    
    // create path and map variables
    String localVarPath = "/api/project-fields/{field-id}"
      .replaceAll("\\{" + "field-id" + "\\}", apiClient.escapeString(fieldId.toString()));

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


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Get Project Metadata Fields (list)
   * Returns a list of metadata fields 
   * @return List&lt;Metadata&gt;
   * @throws ApiException if fails to make API call
   */
  public List<Metadata> getAllMetadata() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/project-fields";

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

    GenericType<List<Metadata>> localVarReturnType = new GenericType<List<Metadata>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Project Metadata Fields (single)
   * Returns a single Project Metadata Field 
   * @param fieldId The ID of the metadata field. (required)
   * @return Metadata
   * @throws ApiException if fails to make API call
   */
  public Metadata getMetadata(Integer fieldId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'fieldId' is set
    if (fieldId == null) {
      throw new ApiException(400, "Missing the required parameter 'fieldId' when calling getMetadata");
    }
    
    // create path and map variables
    String localVarPath = "/api/project-fields/{field-id}"
      .replaceAll("\\{" + "field-id" + "\\}", apiClient.escapeString(fieldId.toString()));

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

    GenericType<Metadata> localVarReturnType = new GenericType<Metadata>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Project Metadata Field Values
   * Load the Metadata Field values for a given project 
   * @param projectId The ID of the project. (required)
   * @return List&lt;MetadataValue&gt;
   * @throws ApiException if fails to make API call
   */
  public List<MetadataValue> getMetadataValue(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getMetadataValue");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/metadata"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

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

    GenericType<List<MetadataValue>> localVarReturnType = new GenericType<List<MetadataValue>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Modify Project Metadata Field
   * Update the name, type, and/or values to match the value specified in the request body. When adding values to the values array, be sure to include all existing values. With this method, you may omit fields that you wish to leave unchanged. 
   * @param fieldId The ID of the metadata field. (required)
   * @param metadata  (required)
   * @return Metadata
   * @throws ApiException if fails to make API call
   */
  public Metadata modifyMetadata(Integer fieldId, Metadata metadata) throws ApiException {
    Object localVarPostBody = metadata;
    
    // verify the required parameter 'fieldId' is set
    if (fieldId == null) {
      throw new ApiException(400, "Missing the required parameter 'fieldId' when calling modifyMetadata");
    }
    
    // verify the required parameter 'metadata' is set
    if (metadata == null) {
      throw new ApiException(400, "Missing the required parameter 'metadata' when calling modifyMetadata");
    }
    
    // create path and map variables
    String localVarPath = "/api/project-fields/{field-id}"
      .replaceAll("\\{" + "field-id" + "\\}", apiClient.escapeString(fieldId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<Metadata> localVarReturnType = new GenericType<Metadata>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update Project Metadata Field Values
   * Update the project metadata values for a given project. Values are given for fields which have been previously defined as Project Metadata Fields. 
   * @param projectId The ID of the project. (required)
   * @param metadata  (required)
   * @return List&lt;MetadataValue&gt;
   * @throws ApiException if fails to make API call
   */
  public List<MetadataValue> updateMetadataValue(Integer projectId, List<MetadataUpdate> metadata) throws ApiException {
    Object localVarPostBody = metadata;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateMetadataValue");
    }
    
    // verify the required parameter 'metadata' is set
    if (metadata == null) {
      throw new ApiException(400, "Missing the required parameter 'metadata' when calling updateMetadataValue");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/metadata"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()));

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

    GenericType<List<MetadataValue>> localVarReturnType = new GenericType<List<MetadataValue>>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
