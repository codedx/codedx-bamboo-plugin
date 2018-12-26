package com.avi.codedx.client.api;

import com.avi.codedx.client.ApiException;
import com.avi.codedx.client.ApiClient;
import com.avi.codedx.client.Configuration;
import com.avi.codedx.client.Pair;

import javax.ws.rs.core.GenericType;

import com.avi.codedx.client.api.Analysis;
import com.avi.codedx.client.api.AnalysisDetails;
import com.avi.codedx.client.api.AnalysisName;
import com.avi.codedx.client.api.AnalysisPrepResponse;
import com.avi.codedx.client.api.AnalysisQueryResponse;
import com.avi.codedx.client.api.Enabled;
import java.io.File;
import com.avi.codedx.client.api.FileUploadResponse;
import com.avi.codedx.client.api.InputDisplayInfo;
import com.avi.codedx.client.api.ProjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-27T11:18:43.181-05:00")
public class AnalysisApi {
  private ApiClient apiClient;

  public AnalysisApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AnalysisApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create Analysis Prep
   * Create a new Analysis Prep associated with a particular project. If Git is configured on that project, the new Analysis Prep will automatically initialize an input corresponding to that configuration. 
   * @param projectId  (required)
   * @return AnalysisPrepResponse
   * @throws ApiException if fails to make API call
   */
  public AnalysisPrepResponse createAnalysisPrep(ProjectId projectId) throws ApiException {
    Object localVarPostBody = projectId;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling createAnalysisPrep");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep";

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

    GenericType<AnalysisPrepResponse> localVarReturnType = new GenericType<AnalysisPrepResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete Input
   * Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that includes an input-id parameter. 
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteInput(String prepId, String inputId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'prepId' is set
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling deleteInput");
    }
    
    // verify the required parameter 'inputId' is set
    if (inputId == null) {
      throw new ApiException(400, "Missing the required parameter 'inputId' when calling deleteInput");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep/{prep-id}/{input-id}"
      .replaceAll("\\{" + "prep-id" + "\\}", apiClient.escapeString(prepId.toString()))
      .replaceAll("\\{" + "input-id" + "\\}", apiClient.escapeString(inputId.toString()));

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
   * Delete Input (pending)
   * Note that depending on the timing of the deletion, one of two different endpoints should be used. If an input file has just begun to upload, but that request has not completed and returned an inputId, use the \&quot;pending\&quot; URL (this requires the input upload request to have specified a X-Client-Request-Id header). If the inputId is known (this will be the case most of the time), use the URL that include an input-id parameter. 
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param xClientRequestId If the input-id is not known, and the \&quot;pending\&quot; URL is being used, this header should be set to the value used by the requrest which initiated the input file upload. (required)
   * @throws ApiException if fails to make API call
   */
  public void deletePendingInput(String prepId, String xClientRequestId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'prepId' is set
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling deletePendingInput");
    }
    
    // verify the required parameter 'xClientRequestId' is set
    if (xClientRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'xClientRequestId' when calling deletePendingInput");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep/{prep-id}/pending"
      .replaceAll("\\{" + "prep-id" + "\\}", apiClient.escapeString(prepId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (xClientRequestId != null)
      localVarHeaderParams.put("X-Client-Request-Id", apiClient.parameterToString(xClientRequestId));

    
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
   * Get All Analysis Details
   * Obtain analysis details for a project, such as start and finish times
   * @param projectId The ID of the project. (required)
   * @return List&lt;AnalysisDetails&gt;
   * @throws ApiException if fails to make API call
   */
  public List<AnalysisDetails> getAllAnalysisDetails(Integer projectId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAllAnalysisDetails");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/analyses"
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

    GenericType<List<AnalysisDetails>> localVarReturnType = new GenericType<List<AnalysisDetails>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Analysis Details
   * Obtain analysis details, such as start and finish times
   * @param projectId The ID of the project. (required)
   * @param analysisId The ID of the analysis (required)
   * @return AnalysisDetails
   * @throws ApiException if fails to make API call
   */
  public AnalysisDetails getAnalysisDetails(Integer projectId, Integer analysisId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAnalysisDetails");
    }
    
    // verify the required parameter 'analysisId' is set
    if (analysisId == null) {
      throw new ApiException(400, "Missing the required parameter 'analysisId' when calling getAnalysisDetails");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/analyses/{analysis-id}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()))
      .replaceAll("\\{" + "analysis-id" + "\\}", apiClient.escapeString(analysisId.toString()));

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

    GenericType<AnalysisDetails> localVarReturnType = new GenericType<AnalysisDetails>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get Input Metadata
   * Get metadata for a particular input associated with an Analysis Prep. 
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @return InputDisplayInfo
   * @throws ApiException if fails to make API call
   */
  public InputDisplayInfo getInputMetadata(String prepId, String inputId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'prepId' is set
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling getInputMetadata");
    }
    
    // verify the required parameter 'inputId' is set
    if (inputId == null) {
      throw new ApiException(400, "Missing the required parameter 'inputId' when calling getInputMetadata");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep/{prep-id}/{input-id}"
      .replaceAll("\\{" + "prep-id" + "\\}", apiClient.escapeString(prepId.toString()))
      .replaceAll("\\{" + "input-id" + "\\}", apiClient.escapeString(inputId.toString()));

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

    GenericType<InputDisplayInfo> localVarReturnType = new GenericType<InputDisplayInfo>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Query Analysis Prep State
   * Get a list of Input IDs and Verification Errors for an Analysis Prep. 
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @return AnalysisQueryResponse
   * @throws ApiException if fails to make API call
   */
  public AnalysisQueryResponse queryAnalysisPrepState(String prepId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'prepId' is set
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling queryAnalysisPrepState");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep/{prep-id}"
      .replaceAll("\\{" + "prep-id" + "\\}", apiClient.escapeString(prepId.toString()));

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

    GenericType<AnalysisQueryResponse> localVarReturnType = new GenericType<AnalysisQueryResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Run Prepared Analysis
   * Once all of the verificationErrors in an Analysis Prep are addressed, an analysis can be started. 
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @return Analysis
   * @throws ApiException if fails to make API call
   */
  public Analysis runPreparedAnalysis(String prepId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'prepId' is set
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling runPreparedAnalysis");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep/{prep-id}/analyze"
      .replaceAll("\\{" + "prep-id" + "\\}", apiClient.escapeString(prepId.toString()));

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

    GenericType<Analysis> localVarReturnType = new GenericType<Analysis>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Name Analysis
   * Set a name for a specific analysis
   * @param projectId The ID of the project. (required)
   * @param analysisId The ID of the analysis (required)
   * @param analysisName An object containing the name of the analysis (optional)
   * @throws ApiException if fails to make API call
   */
  public void setAnalysisName(Integer projectId, Integer analysisId, AnalysisName analysisName) throws ApiException {
    Object localVarPostBody = analysisName;
    
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(400, "Missing the required parameter 'projectId' when calling setAnalysisName");
    }
    
    // verify the required parameter 'analysisId' is set
    if (analysisId == null) {
      throw new ApiException(400, "Missing the required parameter 'analysisId' when calling setAnalysisName");
    }
    
    // create path and map variables
    String localVarPath = "/api/projects/{project-id}/analyses/{analysis-id}"
      .replaceAll("\\{" + "project-id" + "\\}", apiClient.escapeString(projectId.toString()))
      .replaceAll("\\{" + "analysis-id" + "\\}", apiClient.escapeString(analysisId.toString()));

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


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Enable/Disable Display Tag
   * Enable and disable individual display tags on individual prop inputs. Disabled tags will cause a file to be treated as if that tag were not there, for analysis purposes. For example, if the &#x60;{ \&quot;source\&quot;&amp;#58; \&quot;Java\&quot; } tag was disabled for a file when the analysis was started, that file would be treated as if there were no Java sources at all. This could mean that certain tools would not be run on that file. 
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param inputId The ID of the prep input. (required)
   * @param tagId The ID of a Display Tag State object which would have been returned by the Get Input Metadata endpoint (required)
   * @param enabled A boolean indicating whether the tag should be enabled or disabled (optional)
   * @return InputDisplayInfo
   * @throws ApiException if fails to make API call
   */
  public InputDisplayInfo setDisplayTag(String prepId, String inputId, String tagId, Enabled enabled) throws ApiException {
    Object localVarPostBody = enabled;
    
    // verify the required parameter 'prepId' is set
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling setDisplayTag");
    }
    
    // verify the required parameter 'inputId' is set
    if (inputId == null) {
      throw new ApiException(400, "Missing the required parameter 'inputId' when calling setDisplayTag");
    }
    
    // verify the required parameter 'tagId' is set
    if (tagId == null) {
      throw new ApiException(400, "Missing the required parameter 'tagId' when calling setDisplayTag");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep/{prep-id}/{input-id}/tag/{tag-id}"
      .replaceAll("\\{" + "prep-id" + "\\}", apiClient.escapeString(prepId.toString()))
      .replaceAll("\\{" + "input-id" + "\\}", apiClient.escapeString(inputId.toString()))
      .replaceAll("\\{" + "tag-id" + "\\}", apiClient.escapeString(tagId.toString()));

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

    GenericType<InputDisplayInfo> localVarReturnType = new GenericType<InputDisplayInfo>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Upload File to Analysis Prep
   * Analysis Preps should be populated by uploading files to Code Dx (or by configuring Git on a project, causing the source to be automatically added to the prep). 
   * @param prepId The ID of the Analysis Prep. This should come from the Create Analysis Prep response. (required)
   * @param file The file to be uploaded (required)
   * @param xClientRequestId Clients may choose an arbitrary identifier (a random string will suffice) to associate with the upload. This is done to enable deletion of an input before its file upload is fully complete. For more info, see Delete Input. (optional)
   * @return FileUploadResponse
   * @throws ApiException if fails to make API call
   */
  public FileUploadResponse uploadFile(String prepId, File file, String xClientRequestId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'prepId' is set
    if (prepId == null) {
      throw new ApiException(400, "Missing the required parameter 'prepId' when calling uploadFile");
    }
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling uploadFile");
    }
    
    // create path and map variables
    String localVarPath = "/api/analysis-prep/{prep-id}/upload"
      .replaceAll("\\{" + "prep-id" + "\\}", apiClient.escapeString(prepId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (xClientRequestId != null)
      localVarHeaderParams.put("X-Client-Request-Id", apiClient.parameterToString(xClientRequestId));

    if (file != null)
      localVarFormParams.put("file", file);

    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "APIKeyHeader", "basicAuth" };

    GenericType<FileUploadResponse> localVarReturnType = new GenericType<FileUploadResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
