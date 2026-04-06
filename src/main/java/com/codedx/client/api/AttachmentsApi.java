package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.AttachmentMetadata;
import com.codedx.client.model.Error;
import java.io.File;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class AttachmentsApi {
  private ApiClient apiClient;

  public AttachmentsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AttachmentsApi(ApiClient apiClient) {
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
   * Delete an attachment.
   * Delete the attachment corresponding to the given uuid.
   * @param attachmentUuid The attachment UUID (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> OK - Attachment successfully deleted. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to delete this attachment. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An attachment uuid was provided, but it doesn&#39;t correspond to an existing attachment. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteAttachment(@jakarta.annotation.Nonnull UUID attachmentUuid) throws ApiException {
    deleteAttachmentWithHttpInfo(attachmentUuid);
  }

  /**
   * Delete an attachment.
   * Delete the attachment corresponding to the given uuid.
   * @param attachmentUuid The attachment UUID (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> OK - Attachment successfully deleted. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to delete this attachment. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An attachment uuid was provided, but it doesn&#39;t correspond to an existing attachment. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteAttachmentWithHttpInfo(@jakarta.annotation.Nonnull UUID attachmentUuid) throws ApiException {
    // Check required parameters
    if (attachmentUuid == null) {
      throw new ApiException(400, "Missing the required parameter 'attachmentUuid' when calling deleteAttachment");
    }

    // Path parameters
    String localVarPath = "/x/attachments/{attachment-uuid}"
            .replaceAll("\\{attachment-uuid}", apiClient.escapeString(attachmentUuid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("AttachmentsApi.deleteAttachment", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Download an attachment.
   * Download the attachment corresponding to the given uuid.
   * @param attachmentUuid The attachment UUID (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachment successfully downloaded. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to download this attachment. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An attachment uuid was provided, but it doesn&#39;t correspond to an existing attachment. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public File downloadAttachment(@jakarta.annotation.Nonnull UUID attachmentUuid) throws ApiException {
    return downloadAttachmentWithHttpInfo(attachmentUuid).getData();
  }

  /**
   * Download an attachment.
   * Download the attachment corresponding to the given uuid.
   * @param attachmentUuid The attachment UUID (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachment successfully downloaded. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to download this attachment. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An attachment uuid was provided, but it doesn&#39;t correspond to an existing attachment. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> downloadAttachmentWithHttpInfo(@jakarta.annotation.Nonnull UUID attachmentUuid) throws ApiException {
    // Check required parameters
    if (attachmentUuid == null) {
      throw new ApiException(400, "Missing the required parameter 'attachmentUuid' when calling downloadAttachment");
    }

    // Path parameters
    String localVarPath = "/x/attachments/{attachment-uuid}/download"
            .replaceAll("\\{attachment-uuid}", apiClient.escapeString(attachmentUuid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("AttachmentsApi.downloadAttachment", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Download attachments in bulk.
   * Download all attachments corresponding to the provided attachment uuids.
   * @param UUID Request Body should be a JSON Array of attachment UUIDs (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachments were successfully successfully download. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to download these attachments. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An attachment uuid was provided, but it doesn&#39;t correspond to an existing attachment. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public File downloadAttachments(@jakarta.annotation.Nonnull List<UUID> UUID) throws ApiException {
    return downloadAttachmentsWithHttpInfo(UUID).getData();
  }

  /**
   * Download attachments in bulk.
   * Download all attachments corresponding to the provided attachment uuids.
   * @param UUID Request Body should be a JSON Array of attachment UUIDs (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachments were successfully successfully download. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to download these attachments. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An attachment uuid was provided, but it doesn&#39;t correspond to an existing attachment. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> downloadAttachmentsWithHttpInfo(@jakarta.annotation.Nonnull List<UUID> UUID) throws ApiException {
    // Check required parameters
    if (UUID == null) {
      throw new ApiException(400, "Missing the required parameter 'UUID' when calling downloadAttachments");
    }

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("AttachmentsApi.downloadAttachments", "/x/attachments/bulk/download", "POST", new ArrayList<>(), UUID,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List attachment metadata for finding attachments.
   * List all attachment metadata for attachments associated with the relevant finding.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return List&lt;AttachmentMetadata&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an array of attachment metadata. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view this finding&#39;s attachments. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A project or finding id was provided, but it doesn&#39;t correspond to an existing project or finding. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<AttachmentMetadata> listFindingAttachments(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    return listFindingAttachmentsWithHttpInfo(projectId, findingId).getData();
  }

  /**
   * List attachment metadata for finding attachments.
   * List all attachment metadata for attachments associated with the relevant finding.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @return ApiResponse&lt;List&lt;AttachmentMetadata&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an array of attachment metadata. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view this finding&#39;s attachments. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A project or finding id was provided, but it doesn&#39;t correspond to an existing project or finding. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<AttachmentMetadata>> listFindingAttachmentsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling listFindingAttachments");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling listFindingAttachments");
    }

    // Path parameters
    String localVarPath = "/x/attachments/projects/{project-id}/findings/{finding-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<AttachmentMetadata>> localVarReturnType = new GenericType<List<AttachmentMetadata>>() {};
    return apiClient.invokeAPI("AttachmentsApi.listFindingAttachments", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List attachment metadata for project attachments.
   * List all attachment metadata for attachments associated with the relevant project.
   * @param projectId The ID of the project. (required)
   * @return List&lt;AttachmentMetadata&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an array of attachment metadata. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view this project&#39;s attachments. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A project id was provided, but it doesn&#39;t correspond to an existing project. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<AttachmentMetadata> listProjectAttachments(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    return listProjectAttachmentsWithHttpInfo(projectId).getData();
  }

  /**
   * List attachment metadata for project attachments.
   * List all attachment metadata for attachments associated with the relevant project.
   * @param projectId The ID of the project. (required)
   * @return ApiResponse&lt;List&lt;AttachmentMetadata&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns an array of attachment metadata. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to view this project&#39;s attachments. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A project id was provided, but it doesn&#39;t correspond to an existing project. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<AttachmentMetadata>> listProjectAttachmentsWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling listProjectAttachments");
    }

    // Path parameters
    String localVarPath = "/x/attachments/projects/{project-id}"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<AttachmentMetadata>> localVarReturnType = new GenericType<List<AttachmentMetadata>>() {};
    return apiClient.invokeAPI("AttachmentsApi.listProjectAttachments", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Upload finding attachment.
   * Upload a single attachment to the specified finding.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @param _file  (optional)
   * @return AttachmentMetadata
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachment was successfully uploaded. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to upload attachments to this finding. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A project or finding id was provided, but it doesn&#39;t correspond to an existing project or finding. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AttachmentMetadata uploadFindingAttachment(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nullable File _file) throws ApiException {
    return uploadFindingAttachmentWithHttpInfo(projectId, findingId, _file).getData();
  }

  /**
   * Upload finding attachment.
   * Upload a single attachment to the specified finding.
   * @param projectId The ID of the project. (required)
   * @param findingId The finding ID. (required)
   * @param _file  (optional)
   * @return ApiResponse&lt;AttachmentMetadata&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachment was successfully uploaded. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to upload attachments to this finding. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - A project or finding id was provided, but it doesn&#39;t correspond to an existing project or finding. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AttachmentMetadata> uploadFindingAttachmentWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nonnull Integer findingId, @jakarta.annotation.Nullable File _file) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling uploadFindingAttachment");
    }
    if (findingId == null) {
      throw new ApiException(400, "Missing the required parameter 'findingId' when calling uploadFindingAttachment");
    }

    // Path parameters
    String localVarPath = "/x/attachments/projects/{project-id}/findings/{finding-id}/upload"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()))
            .replaceAll("\\{finding-id}", apiClient.escapeString(findingId.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    if (_file != null) {
      localVarFormParams.put("file", _file);
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AttachmentMetadata> localVarReturnType = new GenericType<AttachmentMetadata>() {};
    return apiClient.invokeAPI("AttachmentsApi.uploadFindingAttachment", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Upload project attachment.
   * Upload a single attachment to the specified project.
   * @param projectId The ID of the project. (required)
   * @param _file  (optional)
   * @return AttachmentMetadata
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachment was successfully uploaded. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to upload attachments to this project. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An project id was provided, but it doesn&#39;t correspond to an existing project. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public AttachmentMetadata uploadProjectAttachment(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable File _file) throws ApiException {
    return uploadProjectAttachmentWithHttpInfo(projectId, _file).getData();
  }

  /**
   * Upload project attachment.
   * Upload a single attachment to the specified project.
   * @param projectId The ID of the project. (required)
   * @param _file  (optional)
   * @return ApiResponse&lt;AttachmentMetadata&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Attachment was successfully uploaded. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Forbidden - User/key does not have read permission for the project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden - You lack sufficient permission to upload attachments to this project. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - An project id was provided, but it doesn&#39;t correspond to an existing project. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AttachmentMetadata> uploadProjectAttachmentWithHttpInfo(@jakarta.annotation.Nonnull Integer projectId, @jakarta.annotation.Nullable File _file) throws ApiException {
    // Check required parameters
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling uploadProjectAttachment");
    }

    // Path parameters
    String localVarPath = "/x/attachments/projects/{project-id}/upload"
            .replaceAll("\\{project-id}", apiClient.escapeString(projectId.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    if (_file != null) {
      localVarFormParams.put("file", _file);
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<AttachmentMetadata> localVarReturnType = new GenericType<AttachmentMetadata>() {};
    return apiClient.invokeAPI("AttachmentsApi.uploadProjectAttachment", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
