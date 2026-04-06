package com.codedx.client.api;

import com.codedx.client.ApiException;
import com.codedx.client.ApiClient;
import com.codedx.client.ApiResponse;
import com.codedx.client.Configuration;
import com.codedx.client.Pair;

import jakarta.ws.rs.core.GenericType;

import com.codedx.client.model.Error;
import com.codedx.client.model.Webhook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-02T11:55:06.722228-04:00[America/New_York]", comments = "Generator version: 7.21.0")
public class WebhooksApi {
  private ApiClient apiClient;

  public WebhooksApi() {
    this(Configuration.getDefaultApiClient());
  }

  public WebhooksApi(ApiClient apiClient) {
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
   * Create Webhook
   * Create a webhook - Requires Admin role
   * @param webhook  (optional)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> OK - Created Webhook </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Webhook createWebhook(@jakarta.annotation.Nullable Webhook webhook) throws ApiException {
    return createWebhookWithHttpInfo(webhook).getData();
  }

  /**
   * Create Webhook
   * Create a webhook - Requires Admin role
   * @param webhook  (optional)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> OK - Created Webhook </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> createWebhookWithHttpInfo(@jakarta.annotation.Nullable Webhook webhook) throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("WebhooksApi.createWebhook", "/x/webhooks", "POST", new ArrayList<>(), webhook,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Webhook
   * Delete a webhook - Requires Admin role
   * @param webhookId The id of a webhook (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Deleted webhook </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Webhook does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public void deleteWebhook(@jakarta.annotation.Nonnull Integer webhookId) throws ApiException {
    deleteWebhookWithHttpInfo(webhookId);
  }

  /**
   * Delete Webhook
   * Delete a webhook - Requires Admin role
   * @param webhookId The id of a webhook (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content - Deleted webhook </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Webhook does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteWebhookWithHttpInfo(@jakarta.annotation.Nonnull Integer webhookId) throws ApiException {
    // Check required parameters
    if (webhookId == null) {
      throw new ApiException(400, "Missing the required parameter 'webhookId' when calling deleteWebhook");
    }

    // Path parameters
    String localVarPath = "/x/webhooks/{webhook-id}"
            .replaceAll("\\{webhook-id}", apiClient.escapeString(webhookId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    return apiClient.invokeAPI("WebhooksApi.deleteWebhook", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Webhook
   * Get a webhook - Requires Admin role
   * @param webhookId The id of a webhook (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a webhook </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Webhook does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Webhook getWebhook(@jakarta.annotation.Nonnull Integer webhookId) throws ApiException {
    return getWebhookWithHttpInfo(webhookId).getData();
  }

  /**
   * Get Webhook
   * Get a webhook - Requires Admin role
   * @param webhookId The id of a webhook (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a webhook </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Webhook does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> getWebhookWithHttpInfo(@jakarta.annotation.Nonnull Integer webhookId) throws ApiException {
    // Check required parameters
    if (webhookId == null) {
      throw new ApiException(400, "Missing the required parameter 'webhookId' when calling getWebhook");
    }

    // Path parameters
    String localVarPath = "/x/webhooks/{webhook-id}"
            .replaceAll("\\{webhook-id}", apiClient.escapeString(webhookId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("WebhooksApi.getWebhook", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List Webhooks
   * List all webhooks - Requires Admin role
   * @return List&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of webhooks </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public List<Webhook> listWebhook() throws ApiException {
    return listWebhookWithHttpInfo().getData();
  }

  /**
   * List Webhooks
   * List all webhooks - Requires Admin role
   * @return ApiResponse&lt;List&lt;Webhook&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK - Returns a list of webhooks </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Webhook>> listWebhookWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<List<Webhook>> localVarReturnType = new GenericType<List<Webhook>>() {};
    return apiClient.invokeAPI("WebhooksApi.listWebhook", "/x/webhooks", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update Webhook
   * Update a webhook - Requires Admin role
   * @param webhookId The id of a webhook (required)
   * @param webhook  (optional)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Returns the webhook </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Webhook does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public Webhook updateWebhook(@jakarta.annotation.Nonnull Integer webhookId, @jakarta.annotation.Nullable Webhook webhook) throws ApiException {
    return updateWebhookWithHttpInfo(webhookId, webhook).getData();
  }

  /**
   * Update Webhook
   * Update a webhook - Requires Admin role
   * @param webhookId The id of a webhook (required)
   * @param webhook  (optional)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 202 </td><td> Accepted - Returns the webhook </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found - Webhook does not exist </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server Error - Unexpected failure </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> updateWebhookWithHttpInfo(@jakarta.annotation.Nonnull Integer webhookId, @jakarta.annotation.Nullable Webhook webhook) throws ApiException {
    // Check required parameters
    if (webhookId == null) {
      throw new ApiException(400, "Missing the required parameter 'webhookId' when calling updateWebhook");
    }

    // Path parameters
    String localVarPath = "/x/webhooks/{webhook-id}"
            .replaceAll("\\{webhook-id}", apiClient.escapeString(webhookId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "*/*");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"APIKeyHeader", "basicAuth", "bearerAuth"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("WebhooksApi.updateWebhook", localVarPath, "PUT", new ArrayList<>(), webhook,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
