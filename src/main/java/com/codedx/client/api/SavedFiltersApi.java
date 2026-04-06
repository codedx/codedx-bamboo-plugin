package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Error;
import java.io.File;
import com.codedx.client.model.IdentifiedSavedFilter;
import com.codedx.client.model.SavedFilter;
import com.codedx.client.model.SavedFilterUpdate;
import com.codedx.client.model.SharingRole;
import com.codedx.client.model.UserSharingRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class SavedFiltersApi {
  private ApiClient apiClient;

  public SavedFiltersApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SavedFiltersApi(ApiClient apiClient) {
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
   * Create a Saved Filter
   * Create a Saved Filter
   * @param savedFilter The saved filter to create (required)
   * @return SavedFilter
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Saved Filter created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or was not a valid Saved Filter </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public SavedFilter createSavedFilter(@jakarta.annotation.Nonnull SavedFilter savedFilter) throws ApiException {
    return createSavedFilterWithHttpInfo(savedFilter).getData();
  }

  /**
   * Create a Saved Filter
   * Create a Saved Filter
   * @param savedFilter The saved filter to create (required)
   * @return ApiResponse&lt;SavedFilter&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created - Saved Filter created </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or was not a valid Saved Filter </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SavedFilter> createSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull SavedFilter savedFilter) throws ApiException {
    // Check required parameters
    if (savedFilter == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilter' when calling createSavedFilter");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<SavedFilter> localVarReturnType = new GenericType<SavedFilter>() {};
    return apiClient.invokeAPI("SavedFiltersApi.createSavedFilter", "/x/filters", "POST", new ArrayList<>(), savedFilter,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a Saved Filter
   * Delete a Saved Filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Saved Filter was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Saved Filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteSavedFilter(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    deleteSavedFilterWithHttpInfo(savedFilterId);
  }

  /**
   * Delete a Saved Filter
   * Delete a Saved Filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Saved Filter was deleted </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Saved Filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    // Check required parameters
    if (savedFilterId == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilterId' when calling deleteSavedFilter");
    }

    // Path parameters
    String localVarPath = "/x/filters/{saved-filter-id}"
            .replaceAll("\\{saved-filter-id}", apiClient.escapeString(savedFilterId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("SavedFiltersApi.deleteSavedFilter", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Edit a Saved Filter
   * Edit a Saved Filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @param savedFilterUpdate  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Saved Filter was edited </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, neither the &#39;name&#39; field nor the &#39;selections&#39; field were present, or an invalid value was provided to one of the fields. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Saved Filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void editSavedFilter(@jakarta.annotation.Nonnull Integer savedFilterId, @jakarta.annotation.Nullable SavedFilterUpdate savedFilterUpdate) throws ApiException {
    editSavedFilterWithHttpInfo(savedFilterId, savedFilterUpdate);
  }

  /**
   * Edit a Saved Filter
   * Edit a Saved Filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @param savedFilterUpdate  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Saved Filter was edited </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, neither the &#39;name&#39; field nor the &#39;selections&#39; field were present, or an invalid value was provided to one of the fields. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Saved Filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> editSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer savedFilterId, @jakarta.annotation.Nullable SavedFilterUpdate savedFilterUpdate) throws ApiException {
    // Check required parameters
    if (savedFilterId == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilterId' when calling editSavedFilter");
    }

    // Path parameters
    String localVarPath = "/x/filters/{saved-filter-id}"
            .replaceAll("\\{saved-filter-id}", apiClient.escapeString(savedFilterId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("SavedFiltersApi.editSavedFilter", localVarPath, "PUT", new ArrayList<>(), savedFilterUpdate,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Export a saved filter
   * Export a saved filter. Requires at least the \&quot;view\&quot; SharingRole for that filter
   * @param savedFilterId  (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response contains the saved filter </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Saved Filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public File exportSavedFilter(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    return exportSavedFilterWithHttpInfo(savedFilterId).getData();
  }

  /**
   * Export a saved filter
   * Export a saved filter. Requires at least the \&quot;view\&quot; SharingRole for that filter
   * @param savedFilterId  (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response contains the saved filter </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The Saved Filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    // Check required parameters
    if (savedFilterId == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilterId' when calling exportSavedFilter");
    }

    // Path parameters
    String localVarPath = "/x/filters/{saved-filter-id}/export"
            .replaceAll("\\{saved-filter-id}", apiClient.escapeString(savedFilterId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/octet-stream", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("SavedFiltersApi.exportSavedFilter", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Import a saved filter
   * Create a new filter by uploading a filter file (which would be obtained via the &#39;Export a saved filter&#39; endpoint). Does not require any specific role, but *does* require valid authentication.
   * @param filter  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Saved Filter was successfully imported </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Expected a JSON file to be uploaded </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void importSavedFilter(@jakarta.annotation.Nullable File filter) throws ApiException {
    importSavedFilterWithHttpInfo(filter);
  }

  /**
   * Import a saved filter
   * Create a new filter by uploading a filter file (which would be obtained via the &#39;Export a saved filter&#39; endpoint). Does not require any specific role, but *does* require valid authentication.
   * @param filter  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Saved Filter was successfully imported </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - Expected a JSON file to be uploaded </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> importSavedFilterWithHttpInfo(@jakarta.annotation.Nullable File filter) throws ApiException {
    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    if (filter != null) {
      localVarFormParams.put("filter", filter);
    }

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("SavedFiltersApi.importSavedFilter", "/x/filters/import", "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * List Saved Filters
   * List Saved Filters for which you have at least the \&quot;view\&quot; SharingRole.
   * @return List&lt;IdentifiedSavedFilter&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of Saved Filters </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<IdentifiedSavedFilter> listSavedFilters() throws ApiException {
    return listSavedFiltersWithHttpInfo().getData();
  }

  /**
   * List Saved Filters
   * List Saved Filters for which you have at least the \&quot;view\&quot; SharingRole.
   * @return ApiResponse&lt;List&lt;IdentifiedSavedFilter&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response body will be an array of Saved Filters </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<IdentifiedSavedFilter>> listSavedFiltersWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<IdentifiedSavedFilter>> localVarReturnType = new GenericType<List<IdentifiedSavedFilter>>() {};
    return apiClient.invokeAPI("SavedFiltersApi.listSavedFilters", "/x/filters", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Gets the filter roles for all user groups for a saved filter
   * Gets the filter roles for all user groups for a saved filter. Requires at least the \&quot;view\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @return List&lt;UserSharingRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response contains an array of objects representing each user group and their respective roles for the requested filter. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; SharingRole for the requested filter </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserSharingRole> listUserGroupRolesForSavedFilter(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    return listUserGroupRolesForSavedFilterWithHttpInfo(savedFilterId).getData();
  }

  /**
   * Gets the filter roles for all user groups for a saved filter
   * Gets the filter roles for all user groups for a saved filter. Requires at least the \&quot;view\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @return ApiResponse&lt;List&lt;UserSharingRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response contains an array of objects representing each user group and their respective roles for the requested filter. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; SharingRole for the requested filter </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserSharingRole>> listUserGroupRolesForSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    // Check required parameters
    if (savedFilterId == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilterId' when calling listUserGroupRolesForSavedFilter");
    }

    // Path parameters
    String localVarPath = "/x/filters/{saved-filter-id}/roles/user-groups"
            .replaceAll("\\{saved-filter-id}", apiClient.escapeString(savedFilterId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserSharingRole>> localVarReturnType = new GenericType<List<UserSharingRole>>() {};
    return apiClient.invokeAPI("SavedFiltersApi.listUserGroupRolesForSavedFilter", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Gets the filter roles for all users for a saved filter
   * Gets the filter roles for all users for a saved filter. Requires at least the \&quot;view\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @return List&lt;UserSharingRole&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response contains an array of objects representing each user and their respective roles for the requested filter. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; SharingRole for the requested filter </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<UserSharingRole> listUserRolesForSavedFilter(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    return listUserRolesForSavedFilterWithHttpInfo(savedFilterId).getData();
  }

  /**
   * Gets the filter roles for all users for a saved filter
   * Gets the filter roles for all users for a saved filter. Requires at least the \&quot;view\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @return ApiResponse&lt;List&lt;UserSharingRole&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Response contains an array of objects representing each user and their respective roles for the requested filter. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;view\&quot; SharingRole for the requested filter </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserSharingRole>> listUserRolesForSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer savedFilterId) throws ApiException {
    // Check required parameters
    if (savedFilterId == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilterId' when calling listUserRolesForSavedFilter");
    }

    // Path parameters
    String localVarPath = "/x/filters/{saved-filter-id}/roles/users"
            .replaceAll("\\{saved-filter-id}", apiClient.escapeString(savedFilterId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<UserSharingRole>> localVarReturnType = new GenericType<List<UserSharingRole>>() {};
    return apiClient.invokeAPI("SavedFiltersApi.listUserRolesForSavedFilter", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Sets the filter roles for multiple user groups for a saved filter
   * Sets the filter roles for multiple user groups for a saved filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @param requestBody An object describing the requested new role for each user group to be changed. Note that there is no need to include user groups that you don&#39;t want to change. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Filter roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole for the requested filter </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter or one of the specified user groups does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserGroupRolesForSavedFilter(@jakarta.annotation.Nonnull Integer savedFilterId, @jakarta.annotation.Nonnull Map<String, SharingRole> requestBody) throws ApiException {
    updateUserGroupRolesForSavedFilterWithHttpInfo(savedFilterId, requestBody);
  }

  /**
   * Sets the filter roles for multiple user groups for a saved filter
   * Sets the filter roles for multiple user groups for a saved filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @param requestBody An object describing the requested new role for each user group to be changed. Note that there is no need to include user groups that you don&#39;t want to change. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Filter roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole for the requested filter </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter or one of the specified user groups does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserGroupRolesForSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer savedFilterId, @jakarta.annotation.Nonnull Map<String, SharingRole> requestBody) throws ApiException {
    // Check required parameters
    if (savedFilterId == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilterId' when calling updateUserGroupRolesForSavedFilter");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling updateUserGroupRolesForSavedFilter");
    }

    // Path parameters
    String localVarPath = "/x/filters/{saved-filter-id}/roles/user-groups"
            .replaceAll("\\{saved-filter-id}", apiClient.escapeString(savedFilterId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("SavedFiltersApi.updateUserGroupRolesForSavedFilter", localVarPath, "PUT", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Sets the filter roles for multiple users for a saved filter
   * Sets the filter roles for multiple users for a saved filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @param requestBody An object describing the requested new role for each user to be changed. Note that there is no need to include users that you don&#39;t want to change. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Filter roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter or one of the specified users does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void updateUserRolesForSavedFilter(@jakarta.annotation.Nonnull Integer savedFilterId, @jakarta.annotation.Nonnull Map<String, SharingRole> requestBody) throws ApiException {
    updateUserRolesForSavedFilterWithHttpInfo(savedFilterId, requestBody);
  }

  /**
   * Sets the filter roles for multiple users for a saved filter
   * Sets the filter roles for multiple users for a saved filter. Requires the \&quot;edit\&quot; SharingRole for that filter.
   * @param savedFilterId  (required)
   * @param requestBody An object describing the requested new role for each user to be changed. Note that there is no need to include users that you don&#39;t want to change. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Filter roles were set </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request - If the request body was not JSON, or if one of the roles included in the request body was invalid. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack the \&quot;edit\&quot; SharingRole </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - The saved filter or one of the specified users does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateUserRolesForSavedFilterWithHttpInfo(@jakarta.annotation.Nonnull Integer savedFilterId, @jakarta.annotation.Nonnull Map<String, SharingRole> requestBody) throws ApiException {
    // Check required parameters
    if (savedFilterId == null) {
      throw new ApiException(400, "Missing the required parameter 'savedFilterId' when calling updateUserRolesForSavedFilter");
    }
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling updateUserRolesForSavedFilter");
    }

    // Path parameters
    String localVarPath = "/x/filters/{saved-filter-id}/roles/users"
            .replaceAll("\\{saved-filter-id}", apiClient.escapeString(savedFilterId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("SavedFiltersApi.updateUserRolesForSavedFilter", localVarPath, "PUT", new ArrayList<>(), requestBody,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
