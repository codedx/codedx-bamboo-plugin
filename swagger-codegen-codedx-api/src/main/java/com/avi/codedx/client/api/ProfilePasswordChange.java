/*
 * Code Dx API
 * Code Dx provides a variety of REST APIs, allowing external applications and scripts to interface with core functionality. This guide documents the various REST resources provided by Code Dx.  ## Authentication  Authentication is a requirement when accessing API endpoints. There are two methods by which authentication may be performed.  ### API Keys  The primary method for authentication is passing an `API-Key` header containing a valid API key with all requests.  For example&#58;  `API-Key: 550e8400-e29b-41d4-a716-44665544000`  API keys may be generated by Code Dx admins. Once they are generated, in most cases, they behave like regular users. They will need to be assigned user roles for any projects they will be used with. Although it is possible to assign the *admin* [role](../html/UserGuide.html#UserRolesConfiguration) to an API key, the recommendation is to avoid doing so unless absolutely necessary.  See the user guide for an overview about how to create and manage [API keys](../html/UserGuide.html#APIKeysAdministration).  ### HTTP Basic Authentication  HTTP Basic authentication may be used to authenticate with the API as a regular user. This is accomplished by including an `Authorization` header containing a typical authorization credential.  ## Error Handling  ### Bad Requests  For API calls that accept input, invalid values will trigger an HTTP 400 Bad Request status code.  ### Server Errors  For any API call, if an unexpected error occurs, an HTTP 500 Internal Server Error status code will be returned. If an error message is available, the response will include a basic message body describing the error&#58;  ` {   \"error\": \"error message\" } `  The error property will contain a string message indicating the nature of the error.  ### Errors with Third-Party Applications  Sometimes Code Dx must communicate with third-party applications like JIRA, Git, and certain enterprise tools. Some users may have in-house versions of these with self-signed certificates which may not be \"trusted\". In these cases, the API will respond with an HTTP 502 BAD GATEWAY status. If this happens, refer to [Trusting Self-Signed Certificates](../html/InstallGuide.html#TrustingSelfSignedCertificates) in the install guide.  ### API Unavailable  In special circumstances, particularly during the installation and update phases, the API will be unavailable. When the API is unavailable, all calls will return an HTTP 503 Service Unavailable status, and no actions or side effects will occur as a result of the calls.  ## Examples  Code Dx's API uses REST over HTTP. As such, you can use any language/utility that supports making HTTP requests to interact with the API. The examples below use <a href=\"https://curl.haxx.se/\" target=\"_blank\">curl</a>, a popular command-line utility, to do so.  First, you'll need to [generate an API Key](../html/UserGuide.html#APIKeysAdministration). Second, while you can create projects through the API, these examples will assume that you've already created one. You'll need to know its project id number, which you can find by looking at the URL for the [Findings Page](../html/UserGuide.html#Findings), which will end in a number.  **Note:** Many API endpoints require a JSON body in the request. Most JSON will contain double-quotes (`\"`) and spaces, which have special meaning when used on the command line. In order to ensure your JSON body is interpreted as a single argument, you must <a href=\"https://en.wikipedia.org/wiki/Escape_character\" target=\"_blank\">escape</a> it properly. For example, if you wanted to `POST` the following JSON body&#58;  ``` { \"name\": \"John Doe\" } ```  You would put a backslash (`\\`) before each double-quote (`\"`), and surround the whole thing with double-quotes&#58;  ``` \"{ \\\"name\\\": \\\"John Doe\\\" }\" ```  The outermost double-quotes tell the command-line interpreter that everything within them is to be treated as a single argument (as opposed to the usual space-separated behavior). The backslash before each inner double-quote tells the command-line interpreter that you mean the literal double-quote character, and not the end of the quoted argument.  In many *non-Windows* operating systems, you can also use a single-quote (`'`) to surround the argument, and skip the backslashes&#58;  ``` '{ \"name\": \"John Doe\" }' ```  The examples below will use the double-quotes and backslashes style, as it works on most (if not all) operating systems.  ### Running an Analysis  To start an analysis, you can run  ``` curl -F file1=@src.zip -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/projects/<project id>/analysis ```  Make sure you use your own values for the `src.zip` file, the API Key, the hostname for your Code Dx server, and the project id.  **Note:** This endpoint is not listed below due to a swagger limitation.  ### Retrieving Finding Data  There is a wide variety of data available for the findings of a project after running an analysis. Two examples are provided here.  ### Findings Table Data  You can retrieve the data that's used to populate the [findings table](../html/UserGuide.html#FindingsTable)&#58;  ``` curl -H \"Content-Type: application/json\" -X POST -d \"{\\\"filter\\\":{},\\\"sort\\\":{\\\"by\\\":\\\"id\\\",\\\"direction\\\":\\\"ascending\\\"},\\\"pagination\\\":{\\\"page\\\":1,\\\"perPage\\\":10}}\" -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/projects/<project id>/findings/table ```  Additional information about how to construct more useful filter and sort requests can be found in the documentation.  ### Finding Metadata  You can retrieve metadata for a finding, if you know the finding id. You can take the ID for a finding from the Findings Table&#58;  ``` curl -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/findings/<finding id> ```  ### Generating a Report  You can use the API to generate a PDF [report](../html/UserGuide.html#GenerateReport).  ``` curl -H \"Content-Type: application/json\" -X POST -d \"{\\\"filter\\\":{},\\\"config\\\":{\\\"summaryMode\\\":\\\"simple\\\",\\\"detailsMode\\\":\\\"simple\\\",\\\"includeToolDetails\\\":true,\\\"includeComments\\\":false}}\" -H \"API-Key: 942d16d4-fb3f-4653-9cb3-a9da2e28e574\" https://<yourcodedxserver>/codedx/api/projects/<project id>/report/pdf ```  ## Generating a Client SDK  If you require a client SDK for Code Dx, you can generate one using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen). Detailed instructions are available on the github page and our swagger spec can be found [here](swagger/swagger.json). 
 *
 * OpenAPI spec version: 3.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.avi.codedx.client.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ProfilePasswordChange
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-20T12:12:25.399-04:00")
public class ProfilePasswordChange {
  @JsonProperty("currentPassword")
  private String currentPassword = null;

  @JsonProperty("newPassword")
  private String newPassword = null;

  public ProfilePasswordChange currentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
    return this;
  }

   /**
   * Get currentPassword
   * @return currentPassword
  **/
  @ApiModelProperty(value = "")
  public String getCurrentPassword() {
    return currentPassword;
  }

  public void setCurrentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
  }

  public ProfilePasswordChange newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

   /**
   * Get newPassword
   * @return newPassword
  **/
  @ApiModelProperty(value = "")
  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfilePasswordChange profilePasswordChange = (ProfilePasswordChange) o;
    return Objects.equals(this.currentPassword, profilePasswordChange.currentPassword) &&
        Objects.equals(this.newPassword, profilePasswordChange.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPassword, newPassword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfilePasswordChange {\n");
    
    sb.append("    currentPassword: ").append(toIndentedString(currentPassword)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
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

