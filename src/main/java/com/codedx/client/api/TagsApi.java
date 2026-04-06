package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.CreateTagRequest;
import com.codedx.client.model.RenameTagRequest;
import com.codedx.client.model.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class TagsApi {
  private ApiClient apiClient;

  public TagsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TagsApi(ApiClient apiClient) {
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
   * Create a tag
   * Create a tag in {scope}.  Requires the \&quot;tagging:create\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param scope The scope of tags (required)
   * @param createTagRequest A json object containing the name of the tag to be created (required)
   * @return List&lt;Tag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag already exists </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> OK - Tag was successfully created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to create tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Tag> createTag(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nonnull CreateTagRequest createTagRequest) throws ApiException {
    return createTagWithHttpInfo(scope, createTagRequest).getData();
  }

  /**
   * Create a tag
   * Create a tag in {scope}.  Requires the \&quot;tagging:create\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param scope The scope of tags (required)
   * @param createTagRequest A json object containing the name of the tag to be created (required)
   * @return ApiResponse&lt;List&lt;Tag&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag already exists </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> OK - Tag was successfully created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to create tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Tag>> createTagWithHttpInfo(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nonnull CreateTagRequest createTagRequest) throws ApiException {
    // Check required parameters
    if (scope == null) {
      throw new ApiException(400, "Missing the required parameter 'scope' when calling createTag");
    }
    if (createTagRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'createTagRequest' when calling createTag");
    }

    // Path parameters
    String localVarPath = "/x/tags/{scope}"
            .replaceAll("\\{scope}", apiClient.escapeString(scope.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Tag>> localVarReturnType = new GenericType<List<Tag>>() {};
    return apiClient.invokeAPI("TagsApi.createTag", localVarPath, "POST", new ArrayList<>(), createTagRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a tag
   * Delete a tag, deleting tag associations if necessary and permitted.  Requires the \&quot;tagging:delete\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param scope The scope of tags (required)
   * @param tagId The id of the tag (required)
   * @param force Use &#39;true&#39; if you want to delete a tag and all of its associations (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to delete tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No tag exists with id: {tag-id} in scope: {scope} </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Tag with id: {tag-id} has associations with entities in scope: {scope} and cannot be deleted </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteTag(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nonnull String tagId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    deleteTagWithHttpInfo(scope, tagId, force);
  }

  /**
   * Delete a tag
   * Delete a tag, deleting tag associations if necessary and permitted.  Requires the \&quot;tagging:delete\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param scope The scope of tags (required)
   * @param tagId The id of the tag (required)
   * @param force Use &#39;true&#39; if you want to delete a tag and all of its associations (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag was successfully deleted </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to delete tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No tag exists with id: {tag-id} in scope: {scope} </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - Tag with id: {tag-id} has associations with entities in scope: {scope} and cannot be deleted </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteTagWithHttpInfo(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nonnull String tagId, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (scope == null) {
      throw new ApiException(400, "Missing the required parameter 'scope' when calling deleteTag");
    }
    if (tagId == null) {
      throw new ApiException(400, "Missing the required parameter 'tagId' when calling deleteTag");
    }

    // Path parameters
    String localVarPath = "/x/tags/{scope}/{tag-id}"
            .replaceAll("\\{scope}", apiClient.escapeString(scope.toString()))
            .replaceAll("\\{tag-id}", apiClient.escapeString(tagId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("TagsApi.deleteTag", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * List tags
   * List all tags in {scope}.  Requires no role, all users have sufficient permissions by default.
   * @param scope The scope of tags (required)
   * @return List&lt;Tag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tags were successfully listed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Tag> listTags(@jakarta.annotation.Nonnull String scope) throws ApiException {
    return listTagsWithHttpInfo(scope).getData();
  }

  /**
   * List tags
   * List all tags in {scope}.  Requires no role, all users have sufficient permissions by default.
   * @param scope The scope of tags (required)
   * @return ApiResponse&lt;List&lt;Tag&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tags were successfully listed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to view tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Tag>> listTagsWithHttpInfo(@jakarta.annotation.Nonnull String scope) throws ApiException {
    // Check required parameters
    if (scope == null) {
      throw new ApiException(400, "Missing the required parameter 'scope' when calling listTags");
    }

    // Path parameters
    String localVarPath = "/x/tags/{scope}"
            .replaceAll("\\{scope}", apiClient.escapeString(scope.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Tag>> localVarReturnType = new GenericType<List<Tag>>() {};
    return apiClient.invokeAPI("TagsApi.listTags", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Lookup a tag
   * Lookup a tag&#39;s details.  Requires no role, all users have sufficient permissions by default.
   * @param scope The scope of tags (required)
   * @param name The tag name for lookup (optional)
   * @return Tag
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag was successfully looked up </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No tag exists with name: {name} in scope: {scope} </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Tag lookupTag(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nullable String name) throws ApiException {
    return lookupTagWithHttpInfo(scope, name).getData();
  }

  /**
   * Lookup a tag
   * Lookup a tag&#39;s details.  Requires no role, all users have sufficient permissions by default.
   * @param scope The scope of tags (required)
   * @param name The tag name for lookup (optional)
   * @return ApiResponse&lt;Tag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag was successfully looked up </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No tag exists with name: {name} in scope: {scope} </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Tag> lookupTagWithHttpInfo(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nullable String name) throws ApiException {
    // Check required parameters
    if (scope == null) {
      throw new ApiException(400, "Missing the required parameter 'scope' when calling lookupTag");
    }

    // Path parameters
    String localVarPath = "/x/tags/{scope}/find"
            .replaceAll("\\{scope}", apiClient.escapeString(scope.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "name", name)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Tag> localVarReturnType = new GenericType<Tag>() {};
    return apiClient.invokeAPI("TagsApi.lookupTag", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Rename a tag
   * Rename a tag, merging tag associations if necessary and permitted.  Requires the \&quot;tagging:rename\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param scope The scope of tags (required)
   * @param tagId The id of the tag (required)
   * @param renameTagRequest A json object containing the name to which the tag with id {tag-name} will be renamed (required)
   * @param force Use &#39;true&#39; if you want to reassociate all entities that are associated with {tag-name} to the target tag upon successful rename. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag was successfully renamed </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to rename tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No tag exists with id: {tag-id} in scope: {scope} </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A tag with name: {name} in scope: {scope} already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void renameTag(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nonnull Integer tagId, @jakarta.annotation.Nonnull RenameTagRequest renameTagRequest, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    renameTagWithHttpInfo(scope, tagId, renameTagRequest, force);
  }

  /**
   * Rename a tag
   * Rename a tag, merging tag associations if necessary and permitted.  Requires the \&quot;tagging:rename\&quot; permission which is provided by the \&quot;Admin\&quot; role.
   * @param scope The scope of tags (required)
   * @param tagId The id of the tag (required)
   * @param renameTagRequest A json object containing the name to which the tag with id {tag-name} will be renamed (required)
   * @param force Use &#39;true&#39; if you want to reassociate all entities that are associated with {tag-name} to the target tag upon successful rename. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Tag was successfully renamed </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Tag names may not have more than 32 characters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the permission to rename tags in {scope} </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - No tag exists with id: {tag-id} in scope: {scope} </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict - A tag with name: {name} in scope: {scope} already exists </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> renameTagWithHttpInfo(@jakarta.annotation.Nonnull String scope, @jakarta.annotation.Nonnull Integer tagId, @jakarta.annotation.Nonnull RenameTagRequest renameTagRequest, @jakarta.annotation.Nullable Boolean force) throws ApiException {
    // Check required parameters
    if (scope == null) {
      throw new ApiException(400, "Missing the required parameter 'scope' when calling renameTag");
    }
    if (tagId == null) {
      throw new ApiException(400, "Missing the required parameter 'tagId' when calling renameTag");
    }
    if (renameTagRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'renameTagRequest' when calling renameTag");
    }

    // Path parameters
    String localVarPath = "/x/tags/{scope}/{tag-id}"
            .replaceAll("\\{scope}", apiClient.escapeString(scope.toString()))
            .replaceAll("\\{tag-id}", apiClient.escapeString(tagId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "force", force)
    );

    String localVarAccept = apiClient.selectHeaderAccept();
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("TagsApi.renameTag", localVarPath, "PUT", localVarQueryParams, renameTagRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
