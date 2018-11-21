
# DisplayTagState

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**source** | **String** | if the file appears to be a zip file that includes source files, the value of this field will be the name of the language of that source (e.g. \&quot;C#\&quot;) |  [optional]
**binary** | **String** | if the file appears to be a zip file that includes compiled \&quot;binary\&quot; files, the value of this field will be the name of the platform on which they run (e.g. \&quot;CLR\&quot;) |  [optional]
**buildMeta** | **String** | if the file appears to be a zip file that includes some kind of build metadata (e.g. an npm package.json file), the value of this field will be a string describing what type of file was found |  [optional]
**toolOutput** | **String** | if the file appears to be an output of a tool (i.e. a file containing Findings), the value of this field will be the name of that tool. |  [optional]
**toolInput** | **String** | if the file appears to be usable as an input to a tool that Code Dx can automatically run, the value of this field will be that tool. |  [optional]
**id** | **String** | a semi-random identifier which can be assumed to be unique within the context of an Analysis Prep. This identifier can be used when constructing URLs to interact with a specific Display Tag State. |  [optional]
**enabled** | **Boolean** | a boolean, indicating whether the tag is enabled. If not enabled, the content described by the tag will be treated as if it wasn&#39;t there. In the case of toolInput, that could mean that the particular tool would not be run. |  [optional]
**enabledReason** | **String** | a string, either \&quot;user\&quot;, or \&quot;rule-config\&quot;. If the associated project has disabled a particular tool by configuration, toolInput tags for that tool will be disabled by \&quot;rule-config\&quot;. If the API is used to enable or disable a tag, it will be disabled by \&quot;user\&quot;. |  [optional]



