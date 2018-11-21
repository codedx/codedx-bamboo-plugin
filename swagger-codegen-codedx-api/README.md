# swagger-codegen-codedx-api-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.avi.codedx</groupId>
    <artifactId>swagger-codegen-codedx-api-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.avi.codedx:swagger-codegen-codedx-api-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-codegen-codedx-api-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.avi.codedx.client.*;
import com.avi.codedx.client.auth.*;
import com.avi.codedx.client.api.*;
import com.avi.codedx.client.api.ActionsApi;

import java.io.File;
import java.util.*;

public class ActionsApiExample {

    public static void main(String[] args) {
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

        ActionsApi apiInstance = new ActionsApi();
        Integer findingId = 56; // Integer | The finding ID.
        try {
            apiInstance.clearSeverityOverride(findingId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActionsApi#clearSeverityOverride");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost/codedx*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ActionsApi* | [**clearSeverityOverride**](docs/ActionsApi.md#clearSeverityOverride) | **DELETE** /api/findings/{finding-id}/severity-override | Severity Override [Clear]
*ActionsApi* | [**overrideSeverity**](docs/ActionsApi.md#overrideSeverity) | **PUT** /api/findings/{finding-id}/severity-override | Severity Override [Set]
*ActionsApi* | [**postComment**](docs/ActionsApi.md#postComment) | **POST** /api/findings/{finding-id}/comment | Post Comment
*ActionsApi* | [**setBulkStatus**](docs/ActionsApi.md#setBulkStatus) | **POST** /api/projects/{project-id}/bulk-status-update | Bulk Status Update
*ActionsApi* | [**setStatus**](docs/ActionsApi.md#setStatus) | **PUT** /api/findings/{finding-id}/status | Status Update
*AnalysisApi* | [**createAnalysisPrep**](docs/AnalysisApi.md#createAnalysisPrep) | **POST** /api/analysis-prep | Create Analysis Prep
*AnalysisApi* | [**deleteInput**](docs/AnalysisApi.md#deleteInput) | **DELETE** /api/analysis-prep/{prep-id}/{input-id} | Delete Input
*AnalysisApi* | [**deletePendingInput**](docs/AnalysisApi.md#deletePendingInput) | **DELETE** /api/analysis-prep/{prep-id}/pending | Delete Input (pending)
*AnalysisApi* | [**getAllAnalysisDetails**](docs/AnalysisApi.md#getAllAnalysisDetails) | **GET** /api/projects/{project-id}/analyses | Get All Analysis Details
*AnalysisApi* | [**getAnalysisDetails**](docs/AnalysisApi.md#getAnalysisDetails) | **GET** /api/projects/{project-id}/analyses/{analysis-id} | Get Analysis Details
*AnalysisApi* | [**getInputMetadata**](docs/AnalysisApi.md#getInputMetadata) | **GET** /api/analysis-prep/{prep-id}/{input-id} | Get Input Metadata
*AnalysisApi* | [**queryAnalysisPrepState**](docs/AnalysisApi.md#queryAnalysisPrepState) | **GET** /api/analysis-prep/{prep-id} | Query Analysis Prep State
*AnalysisApi* | [**runPreparedAnalysis**](docs/AnalysisApi.md#runPreparedAnalysis) | **POST** /api/analysis-prep/{prep-id}/analyze | Run Prepared Analysis
*AnalysisApi* | [**setAnalysisName**](docs/AnalysisApi.md#setAnalysisName) | **PUT** /api/projects/{project-id}/analyses/{analysis-id} | Name Analysis
*AnalysisApi* | [**setDisplayTag**](docs/AnalysisApi.md#setDisplayTag) | **PUT** /api/analysis-prep/{prep-id}/{input-id}/tag/{tag-id} | Enable/Disable Display Tag
*AnalysisApi* | [**uploadFile**](docs/AnalysisApi.md#uploadFile) | **POST** /api/analysis-prep/{prep-id}/upload | Upload File to Analysis Prep
*FindingDataApi* | [**getFindingData**](docs/FindingDataApi.md#getFindingData) | **GET** /api/findings/{finding-id} | Finding Data
*FindingDataApi* | [**getFindingDescription**](docs/FindingDataApi.md#getFindingDescription) | **GET** /api/findings/{finding-id}/description | Finding Descriptions
*FindingDataApi* | [**getFindingFlow**](docs/FindingDataApi.md#getFindingFlow) | **POST** /api/projects/{project-id}/findings/flow | Finding Flow Data
*FindingDataApi* | [**getFindingHistory**](docs/FindingDataApi.md#getFindingHistory) | **GET** /api/findings/{finding-id}/history | Finding History
*FindingDataApi* | [**getFindingsCount**](docs/FindingDataApi.md#getFindingsCount) | **POST** /api/projects/{project-id}/findings/count | Finding Count
*FindingDataApi* | [**getFindingsGroupCount**](docs/FindingDataApi.md#getFindingsGroupCount) | **POST** /api/projects/{project-id}/findings/grouped-counts | Findings Grouped Count
*FindingDataApi* | [**getFindingsTable**](docs/FindingDataApi.md#getFindingsTable) | **POST** /api/projects/{project-id}/findings/table | Finding Table Data
*FindingDataApi* | [**getSourceFileContents**](docs/FindingDataApi.md#getSourceFileContents) | **GET** /api/projects/{project-id}/files/{path-id} | Source File Contents
*FindingDataApi* | [**getSourceFileContentsFromPath**](docs/FindingDataApi.md#getSourceFileContentsFromPath) | **GET** /api/projects/{project-id}/files/tree/{path} | Source File Contents (tree)
*FindingDataMaintenanceApi* | [**getDisabledToolResultCount**](docs/FindingDataMaintenanceApi.md#getDisabledToolResultCount) | **GET** /api/projects/{project-id}/disabled-tool-result-count | Disabled Tool Result Count Query
*FindingDataMaintenanceApi* | [**purgeDisabledToolResults**](docs/FindingDataMaintenanceApi.md#purgeDisabledToolResults) | **POST** /api/projects/{project-id}/purge-disabled-tool-results | Purge Disabled Tool Results
*JobsApi* | [**getJobResult**](docs/JobsApi.md#getJobResult) | **GET** /api/jobs/{job-id}/result | Get Job Result
*JobsApi* | [**getJobStatus**](docs/JobsApi.md#getJobStatus) | **GET** /api/jobs/{job-id} | Query Job Status
*MetadataApi* | [**createMetadataField**](docs/MetadataApi.md#createMetadataField) | **POST** /api/project-fields | Create Project Metadata Field
*MetadataApi* | [**deleteMetadata**](docs/MetadataApi.md#deleteMetadata) | **DELETE** /api/project-fields/{field-id} | Delete Project Metadata Field
*MetadataApi* | [**getAllMetadata**](docs/MetadataApi.md#getAllMetadata) | **GET** /api/project-fields | Get Project Metadata Fields (list)
*MetadataApi* | [**getMetadata**](docs/MetadataApi.md#getMetadata) | **GET** /api/project-fields/{field-id} | Get Project Metadata Fields (single)
*MetadataApi* | [**getMetadataValue**](docs/MetadataApi.md#getMetadataValue) | **GET** /api/projects/{project-id}/metadata | Get Project Metadata Field Values
*MetadataApi* | [**modifyMetadata**](docs/MetadataApi.md#modifyMetadata) | **PUT** /api/project-fields/{field-id} | Modify Project Metadata Field
*MetadataApi* | [**updateMetadataValue**](docs/MetadataApi.md#updateMetadataValue) | **PUT** /api/projects/{project-id}/metadata | Update Project Metadata Field Values
*ProfileApi* | [**profileChangePassword**](docs/ProfileApi.md#profileChangePassword) | **POST** /api/profile/password | Change your password
*ProjectsApi* | [**createProject**](docs/ProjectsApi.md#createProject) | **PUT** /api/projects | Create Project
*ProjectsApi* | [**deleteProject**](docs/ProjectsApi.md#deleteProject) | **DELETE** /api/projects/{project-id} | Delete Project
*ProjectsApi* | [**getAllUserRoles**](docs/ProjectsApi.md#getAllUserRoles) | **GET** /api/projects/{project-id}/user-roles | User Roles
*ProjectsApi* | [**getMappings**](docs/ProjectsApi.md#getMappings) | **POST** /api/projects/{project-id}/files/mappings | File Mappings
*ProjectsApi* | [**getProjectFiles**](docs/ProjectsApi.md#getProjectFiles) | **GET** /api/projects/{project-id}/files | Project Files
*ProjectsApi* | [**getProjects**](docs/ProjectsApi.md#getProjects) | **GET** /api/projects | List Projects
*ProjectsApi* | [**getStatuses**](docs/ProjectsApi.md#getStatuses) | **GET** /api/projects/{project-id}/statuses | Project Statuses
*ProjectsApi* | [**getUserRole**](docs/ProjectsApi.md#getUserRole) | **GET** /api/projects/{project-id}/user-roles/user/{user-id} | User Role
*ProjectsApi* | [**queryProjects**](docs/ProjectsApi.md#queryProjects) | **POST** /api/projects/query | Query Projects
*ProjectsApi* | [**updateProject**](docs/ProjectsApi.md#updateProject) | **PUT** /api/projects/{project-id} | Update Project
*ProjectsApi* | [**updateUserRole**](docs/ProjectsApi.md#updateUserRole) | **PUT** /api/projects/{project-id}/user-roles/user/{user-id} | Update User Role
*ReportingApi* | [**generateReport**](docs/ReportingApi.md#generateReport) | **POST** /api/projects/{project-id}/report/{report-type} | Generate Report
*ReportingApi* | [**getReportTypes**](docs/ReportingApi.md#getReportTypes) | **GET** /api/projects/{project-id}/report/types | Report Types
*ResultsApi* | [**createDetectionMethod**](docs/ResultsApi.md#createDetectionMethod) | **POST** /api/detection-methods | Create Detection Method
*ResultsApi* | [**createManualResult**](docs/ResultsApi.md#createManualResult) | **POST** /api/manual-results | Create Manual Result
*ResultsApi* | [**deleteDetectionMethod**](docs/ResultsApi.md#deleteDetectionMethod) | **DELETE** /api/detection-methods/{detection-method-id} | Delete Detection Method.
*ResultsApi* | [**deleteManualResult**](docs/ResultsApi.md#deleteManualResult) | **DELETE** /api/manual-results/{result-id} | Delete Manual Result
*ResultsApi* | [**getAllDetectionMethods**](docs/ResultsApi.md#getAllDetectionMethods) | **GET** /api/detection-methods | List Detection Methods
*ResultsApi* | [**getManualResultAllowedTools**](docs/ResultsApi.md#getManualResultAllowedTools) | **GET** /api/manual-results/allowed-tools | Get Allowed Manaul Result Tools
*ResultsApi* | [**modifyManualResultAllowedTool**](docs/ResultsApi.md#modifyManualResultAllowedTool) | **POST** /api/manual-results/allowed-tools | Modify Allowed Manual Result Tool
*ResultsApi* | [**renameDetectionMethod**](docs/ResultsApi.md#renameDetectionMethod) | **PUT** /api/detection-methods/{detection-method-id} | Rename Detection Method
*ResultsApi* | [**replaceManualResult**](docs/ResultsApi.md#replaceManualResult) | **POST** /api/manual-results/{result-id}/replace | Replace Manual Result
*RuleSetsApi* | [**addRuleCriteria**](docs/RuleSetsApi.md#addRuleCriteria) | **POST** /api/ruleset/{ruleset-id}/rule/{rule-id}/criteria | Add Rule Criteria
*RuleSetsApi* | [**cloneRuleSet**](docs/RuleSetsApi.md#cloneRuleSet) | **POST** /api/ruleset/{ruleset-id}/clone | Clone Rule Set
*RuleSetsApi* | [**createRule**](docs/RuleSetsApi.md#createRule) | **POST** /api/ruleset/{ruleset-id}/rule | Create Rule
*RuleSetsApi* | [**createRuleSet**](docs/RuleSetsApi.md#createRuleSet) | **POST** /api/ruleset | Create Rule Set
*RuleSetsApi* | [**deleteRule**](docs/RuleSetsApi.md#deleteRule) | **DELETE** /api/ruleset/{ruleset-id}/rule/{rule-id} | Delete Rule
*RuleSetsApi* | [**deleteRuleCriteria**](docs/RuleSetsApi.md#deleteRuleCriteria) | **DELETE** /api/ruleset/{ruleset-id}/rule/{rule-id}/criteria | Delete Rule Criteria
*RuleSetsApi* | [**deleteRuleSet**](docs/RuleSetsApi.md#deleteRuleSet) | **DELETE** /api/ruleset/{ruleset-id} | Delete Rule Set
*RuleSetsApi* | [**exportRuleSet**](docs/RuleSetsApi.md#exportRuleSet) | **GET** /api/ruleset/{ruleset-id}/export | Export Rule Set
*RuleSetsApi* | [**getAllRuleSets**](docs/RuleSetsApi.md#getAllRuleSets) | **GET** /api/ruleset/all | Get Rule Sets
*RuleSetsApi* | [**getRuleData**](docs/RuleSetsApi.md#getRuleData) | **GET** /api/ruleset/{ruleset-id}/rule/{rule-id} | Get Rule Data
*RuleSetsApi* | [**getRuleSetContents**](docs/RuleSetsApi.md#getRuleSetContents) | **GET** /api/ruleset/{ruleset-id} | Get Rule Set Contents
*RuleSetsApi* | [**modifyRuleData**](docs/RuleSetsApi.md#modifyRuleData) | **PUT** /api/ruleset/{ruleset-id}/rule/{rule-id} | Modify Rule Descriptor
*RuleSetsApi* | [**renameRuleSet**](docs/RuleSetsApi.md#renameRuleSet) | **PUT** /api/ruleset/{ruleset-id} | Rename Rule Set
*RuleSetsApi* | [**updateRuleSet**](docs/RuleSetsApi.md#updateRuleSet) | **POST** /api/ruleset/{ruleset-id}/update | Update Rule Set
*RuleSetsApi* | [**uploadRuleSet**](docs/RuleSetsApi.md#uploadRuleSet) | **POST** /api/ruleset/import | Import Rule Set
*StandardsApi* | [**getStandards**](docs/StandardsApi.md#getStandards) | **GET** /api/standards/filter-views | Get Standards
*SystemApi* | [**getSystemInfo**](docs/SystemApi.md#getSystemInfo) | **GET** /api/system-info | System Information
*UserAdministrationApi* | [**changeUserPassword**](docs/UserAdministrationApi.md#changeUserPassword) | **POST** /api/admin/users/local/{user-id}/password | Change Password
*UserAdministrationApi* | [**createKeyUser**](docs/UserAdministrationApi.md#createKeyUser) | **POST** /api/admin/users/key | Create API Key User
*UserAdministrationApi* | [**createLdapUser**](docs/UserAdministrationApi.md#createLdapUser) | **POST** /api/admin/users/ldap | Create LDAP User
*UserAdministrationApi* | [**createLocalUser**](docs/UserAdministrationApi.md#createLocalUser) | **POST** /api/admin/users/local | Create Local User
*UserAdministrationApi* | [**deleteUser**](docs/UserAdministrationApi.md#deleteUser) | **DELETE** /api/admin/users/{user-id} | Delete User
*UserAdministrationApi* | [**getAllUsers**](docs/UserAdministrationApi.md#getAllUsers) | **GET** /api/admin/users/ | List All Users
*UserAdministrationApi* | [**getKeyUsers**](docs/UserAdministrationApi.md#getKeyUsers) | **GET** /api/admin/users/key | List API Key Users
*UserAdministrationApi* | [**getLdapUsers**](docs/UserAdministrationApi.md#getLdapUsers) | **GET** /api/admin/users/ldap | List LDAP Users
*UserAdministrationApi* | [**getLocalUsers**](docs/UserAdministrationApi.md#getLocalUsers) | **GET** /api/admin/users/local | List Local Users
*UserAdministrationApi* | [**modifyUser**](docs/UserAdministrationApi.md#modifyUser) | **PUT** /api/admin/users/{user-id} | Disable User or Add/Remove Admin
*UserAdministrationApi* | [**regenerateApiKey**](docs/UserAdministrationApi.md#regenerateApiKey) | **POST** /api/admin/users/key/{user-id}/regenerate | Regenerate API Key


## Documentation for Models

 - [ActivityEvent](docs/ActivityEvent.md)
 - [Analysis](docs/Analysis.md)
 - [AnalysisDetails](docs/AnalysisDetails.md)
 - [AnalysisName](docs/AnalysisName.md)
 - [AnalysisPrepResponse](docs/AnalysisPrepResponse.md)
 - [AnalysisQueryResponse](docs/AnalysisQueryResponse.md)
 - [AnalysisRecord](docs/AnalysisRecord.md)
 - [Cookie](docs/Cookie.md)
 - [Count](docs/Count.md)
 - [CreateRule](docs/CreateRule.md)
 - [CreateUser](docs/CreateUser.md)
 - [CreatedBy](docs/CreatedBy.md)
 - [Cwe](docs/Cwe.md)
 - [DateRange](docs/DateRange.md)
 - [Description](docs/Description.md)
 - [DescriptionFormat](docs/DescriptionFormat.md)
 - [Descriptions](docs/Descriptions.md)
 - [DetectionMethod](docs/DetectionMethod.md)
 - [DisableUser](docs/DisableUser.md)
 - [DisabledToolResultsCount](docs/DisabledToolResultsCount.md)
 - [DisplayTagState](docs/DisplayTagState.md)
 - [Element](docs/Element.md)
 - [ElementType](docs/ElementType.md)
 - [Enabled](docs/Enabled.md)
 - [Error](docs/Error.md)
 - [FileMapping](docs/FileMapping.md)
 - [FileUploadResponse](docs/FileUploadResponse.md)
 - [Filter](docs/Filter.md)
 - [Finding](docs/Finding.md)
 - [FindingDescription](docs/FindingDescription.md)
 - [FindingDescriptor](docs/FindingDescriptor.md)
 - [FlowData](docs/FlowData.md)
 - [FlowRequest](docs/FlowRequest.md)
 - [GenerateReport](docs/GenerateReport.md)
 - [GroupedCount](docs/GroupedCount.md)
 - [GroupedCountsRequest](docs/GroupedCountsRequest.md)
 - [Header](docs/Header.md)
 - [InputDisplayInfo](docs/InputDisplayInfo.md)
 - [Issue](docs/Issue.md)
 - [Job](docs/Job.md)
 - [JobStatus](docs/JobStatus.md)
 - [Location](docs/Location.md)
 - [LocationRange](docs/LocationRange.md)
 - [ManualResultRequest](docs/ManualResultRequest.md)
 - [ManualResultResponse](docs/ManualResultResponse.md)
 - [MappingsRequest](docs/MappingsRequest.md)
 - [Metadata](docs/Metadata.md)
 - [MetadataUpdate](docs/MetadataUpdate.md)
 - [MetadataValue](docs/MetadataValue.md)
 - [ModifyRuleResponse](docs/ModifyRuleResponse.md)
 - [Option](docs/Option.md)
 - [Pagination](docs/Pagination.md)
 - [Password](docs/Password.md)
 - [Path](docs/Path.md)
 - [PathType](docs/PathType.md)
 - [PostComment](docs/PostComment.md)
 - [ProfilePasswordChange](docs/ProfilePasswordChange.md)
 - [Project](docs/Project.md)
 - [ProjectFile](docs/ProjectFile.md)
 - [ProjectId](docs/ProjectId.md)
 - [ProjectQuery](docs/ProjectQuery.md)
 - [ProjectQueryFilter](docs/ProjectQueryFilter.md)
 - [ProjectQueryResponse](docs/ProjectQueryResponse.md)
 - [Projects](docs/Projects.md)
 - [Query](docs/Query.md)
 - [ReportConfigOption](docs/ReportConfigOption.md)
 - [ReportConfigOptionType](docs/ReportConfigOptionType.md)
 - [ReportConfigRegex](docs/ReportConfigRegex.md)
 - [ReportConfigRequired](docs/ReportConfigRequired.md)
 - [ReportType](docs/ReportType.md)
 - [RequestResponse](docs/RequestResponse.md)
 - [ResultDescription](docs/ResultDescription.md)
 - [Rev](docs/Rev.md)
 - [Roles](docs/Roles.md)
 - [Rule](docs/Rule.md)
 - [RuleCriteria](docs/RuleCriteria.md)
 - [RuleCriteriaType](docs/RuleCriteriaType.md)
 - [RuleDescriptor](docs/RuleDescriptor.md)
 - [RuleGroup](docs/RuleGroup.md)
 - [RuleSet](docs/RuleSet.md)
 - [RuleSetContents](docs/RuleSetContents.md)
 - [RuleSetDeleteError](docs/RuleSetDeleteError.md)
 - [RuleSetDeleteResponse](docs/RuleSetDeleteResponse.md)
 - [ScmInfo](docs/ScmInfo.md)
 - [ScmSetup](docs/ScmSetup.md)
 - [SetStatus](docs/SetStatus.md)
 - [SetStatusBulk](docs/SetStatusBulk.md)
 - [Severity](docs/Severity.md)
 - [SeverityKey](docs/SeverityKey.md)
 - [SeverityOverride](docs/SeverityOverride.md)
 - [SeverityValue](docs/SeverityValue.md)
 - [Sort](docs/Sort.md)
 - [SortDescriptor](docs/SortDescriptor.md)
 - [SortDirection](docs/SortDirection.md)
 - [Standard](docs/Standard.md)
 - [Status](docs/Status.md)
 - [SystemInfo](docs/SystemInfo.md)
 - [ToolResult](docs/ToolResult.md)
 - [ToolResultLocation](docs/ToolResultLocation.md)
 - [ToolResultPath](docs/ToolResultPath.md)
 - [UpdateProject](docs/UpdateProject.md)
 - [User](docs/User.md)
 - [UserRole](docs/UserRole.md)
 - [Variant](docs/Variant.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### APIKeyHeader

- **Type**: API key
- **API key parameter name**: API-Key
- **Location**: HTTP header

### basicAuth

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



