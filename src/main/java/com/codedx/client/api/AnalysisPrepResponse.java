/*
 * Code Dx API
 * Code Dx provides a variety of REST APIs, allowing external applications and scripts to interface with core functionality. This guide documents the various REST resources provided by Code Dx.  ## Authentication  Authentication is a requirement when accessing API endpoints. There are two methods by which authentication may be performed.  ### API Keys  The primary method for authentication is passing an `API-Key` header containing a valid API key with all requests.  For example&#58;  `API-Key: 550e8400-e29b-41d4-a716-44665544000`  API keys may be generated by Code Dx admins. Once they are generated, in most cases, they behave like regular users. They will need to be assigned user roles for any projects they will be used with. Although it is possible to assign the *admin* [role](UserGuide.html#UserRolesConfiguration) to an API key, the recommendation is to avoid doing so unless absolutely necessary.  See the user guide for an overview about how to create and manage [API keys](UserGuide.html#APIKeysAdministration).  ### HTTP Basic Authentication  HTTP Basic authentication may be used to authenticate with the API as a regular user. This is accomplished by including an `Authorization` header containing a typical authorization credential.  ## Error Handling  ### Bad Requests  For API calls that accept input, invalid values will trigger an HTTP 400 Bad Request status code.  ### Server Errors  For any API call, if an unexpected error occurs, an HTTP 500 Internal Server Error status code will be returned. If an error message is available, the response will include a basic message body describing the error&#58;  ` {   \"error\": \"error message\" } `  The error property will contain a string message indicating the nature of the error.  ### Errors with Third-Party Applications  Sometimes Code Dx must communicate with third-party applications like JIRA, Git, and certain enterprise tools. Some users may have in-house versions of these with self-signed certificates which may not be \"trusted\". In these cases, the API will respond with an HTTP 502 BAD GATEWAY status. If this happens, refer to [Trusting Self-Signed Certificates](InstallGuide.html#TrustingSelfSignedCertificates) in the install guide.  ### API Unavailable  In special circumstances, particularly during the installation and update phases, the API will be unavailable. When the API is unavailable, all calls will return an HTTP 503 Service Unavailable status, and no actions or side effects will occur as a result of the calls.  ## Examples  Code Dx's API uses REST over HTTP. As such, you can use any language/utility that supports making HTTP requests to interact with the API. The examples below use <a href=\"https://curl.haxx.se/\" target=\"_blank\">curl</a>, a popular command-line utility, to do so.  First, you'll need to [generate an API Key](UserGuide.html#APIKeysAdministration). Second, while you can create projects through the API, these examples will assume that you've already created one. You'll need to know its project id number, which you can find by looking at the URL for the [Findings Page](UserGuide.html#Findings), which will end in a number.  **Note:** Many API endpoints require a JSON body in the request. Most JSON will contain double-quotes (`\"`) and spaces, which have special meaning when used on the command line. In order to ensure your JSON body is interpreted as a single argument, you must <a href=\"https://en.wikipedia.org/wiki/Escape_character\" target=\"_blank\">escape</a> it properly. For example, if you wanted to `POST` the following JSON body&#58;  ``` { \"name\": \"John Doe\" } ```  You would put a backslash (`\\`) before each double-quote (`\"`), and surround the whole thing with double-quotes&#58;  ``` \"{ \\\"name\\\": \\\"John Doe\\\" }\" ```  The outermost double-quotes tell the command-line interpreter that everything within them is to be treated as a single argument (as opposed to the usual space-separated behavior). The backslash before each inner double-quote tells the command-line interpreter that you mean the literal double-quote character, and not the end of the quoted argument.  In many *non-Windows* operating systems, you can also use a single-quote (`'`) to surround the argument, and skip the backslashes&#58;  ``` '{ \"name\": \"John Doe\" }' ```  The examples below will use the double-quotes and backslashes style, as it works on most (if not all) operating systems.  ### Running an Analysis  To start an analysis, you can run  ``` curl -F file1=@src.zip -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/projects/<project id>/analysis ```  Make sure you use your own values for the `src.zip` file, the API Key, the hostname for your Code Dx server, and the project id.  **Note:** This endpoint is not listed below due to a swagger limitation.  ### Retrieving Finding Data  There is a wide variety of data available for the findings of a project after running an analysis. Two examples are provided here.  ### Findings Table Data  You can retrieve the data that's used to populate the [findings table](UserGuide.html#FindingsTable)&#58;  ``` curl -H \"Content-Type: application/json\" -X POST -d \"{\\\"filter\\\":{},\\\"sort\\\":{\\\"by\\\":\\\"id\\\",\\\"direction\\\":\\\"ascending\\\"},\\\"pagination\\\":{\\\"page\\\":1,\\\"perPage\\\":10}}\" -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/projects/<project id>/findings/table ```  Additional information about how to construct more useful filter and sort requests can be found in the documentation.  ### Finding Metadata  You can retrieve metadata for a finding, if you know the finding id. You can take the ID for a finding from the Findings Table&#58;  ``` curl -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/findings/<finding id> ```  ### Generating a Report  You can use the API to generate a PDF [report](UserGuide.html#GenerateReport).  ``` curl -H \"Content-Type: application/json\" -X POST -d \"{\\\"filter\\\":{},\\\"config\\\":{\\\"summaryMode\\\":\\\"simple\\\",\\\"detailsMode\\\":\\\"simple\\\",\\\"includeResultDetails\\\":true,\\\"includeComments\\\":false}}\" -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/projects/<project id>/report/pdf ```  ## Generating a Client SDK  If you require a client SDK for Code Dx, you can generate one using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen). Detailed instructions are available on the github page and our swagger spec can be found [here](swagger/swagger.json). 
 *
 * OpenAPI spec version: 3.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.codedx.client.api;

import java.util.Objects;
import com.codedx.client.api.ScmSetup;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * AnalysisPrepResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-02T17:17:22.434-05:00")
public class AnalysisPrepResponse {
  @JsonProperty("prepId")
  private String prepId = null;

  @JsonProperty("verificationErrors")
  private List<String> verificationErrors = null;

  @JsonProperty("scmSetup")
  private ScmSetup scmSetup = null;

  public AnalysisPrepResponse prepId(String prepId) {
    this.prepId = prepId;
    return this;
  }

   /**
   * A string identifier for the newly-created Analysis Prep. This ID should be used when constructing URLs for interacting with that Prep
   * @return prepId
  **/
  @ApiModelProperty(value = "A string identifier for the newly-created Analysis Prep. This ID should be used when constructing URLs for interacting with that Prep")
  public String getPrepId() {
    return prepId;
  }

  public void setPrepId(String prepId) {
    this.prepId = prepId;
  }

  public AnalysisPrepResponse verificationErrors(List<String> verificationErrors) {
    this.verificationErrors = verificationErrors;
    return this;
  }

  public AnalysisPrepResponse addVerificationErrorsItem(String verificationErrorsItem) {
    if (this.verificationErrors == null) {
      this.verificationErrors = new ArrayList<String>();
    }
    this.verificationErrors.add(verificationErrorsItem);
    return this;
  }

   /**
   * an array of user-facing messages that describe possible problems that will prevent the Analysis Prep from being run
   * @return verificationErrors
  **/
  @ApiModelProperty(value = "an array of user-facing messages that describe possible problems that will prevent the Analysis Prep from being run")
  public List<String> getVerificationErrors() {
    return verificationErrors;
  }

  public void setVerificationErrors(List<String> verificationErrors) {
    this.verificationErrors = verificationErrors;
  }

  public AnalysisPrepResponse scmSetup(ScmSetup scmSetup) {
    this.scmSetup = scmSetup;
    return this;
  }

   /**
   * Get scmSetup
   * @return scmSetup
  **/
  @ApiModelProperty(value = "")
  public ScmSetup getScmSetup() {
    return scmSetup;
  }

  public void setScmSetup(ScmSetup scmSetup) {
    this.scmSetup = scmSetup;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalysisPrepResponse analysisPrepResponse = (AnalysisPrepResponse) o;
    return Objects.equals(this.prepId, analysisPrepResponse.prepId) &&
        Objects.equals(this.verificationErrors, analysisPrepResponse.verificationErrors) &&
        Objects.equals(this.scmSetup, analysisPrepResponse.scmSetup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prepId, verificationErrors, scmSetup);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalysisPrepResponse {\n");
    
    sb.append("    prepId: ").append(toIndentedString(prepId)).append("\n");
    sb.append("    verificationErrors: ").append(toIndentedString(verificationErrors)).append("\n");
    sb.append("    scmSetup: ").append(toIndentedString(scmSetup)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
