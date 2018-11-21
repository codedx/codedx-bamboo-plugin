
# Metadata

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | A number which can be used to identify the field when using the API |  [optional]
**name** | **String** | The user-facing name of the field |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | - &#x60;\&quot;text\&quot;&#x60; for fields where users may enter plain-text values - &#x60;\&quot;multiline-text\&quot;&#x60; for fields where users may enter long-form text, e.g. paragraphs - &#x60;\&quot;tags\&quot;&#x60; for fields where users may enter a collection of single-word items - &#x60;\&quot;enum\&quot;&#x60; for fields where users must select a choice from a dropdown menu  |  [optional]
**value** | **String** |  |  [optional]
**values** | [**List&lt;MetadataValue&gt;**](MetadataValue.md) |  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
TEXT | &quot;text&quot;
ENUM | &quot;enum&quot;
MULTILINE_TEXT | &quot;multiline-text&quot;
TAGS | &quot;tags&quot;



