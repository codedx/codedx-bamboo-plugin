
# User

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | The user&#39;s unique ID |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**name** | **String** | The user&#39;s display name |  [optional]
**principal** | **String** | The user&#39;s principal. For &#x60;local&#x60; and &#x60;ldap&#x60; users, this will be the same as the name. For &#x60;key&#x60; users, this will be the API Key |  [optional]
**isEnabled** | **Boolean** | Flag that states whether the user is \&quot;enabled\&quot; (disabled users may not log in, and don&#39;t count against your license) |  [optional]
**isSystem** | **Boolean** | Flag indicating whether the user is the Code Dx \&quot;system\&quot; user. This will only be true for the user you set up during installation |  [optional]
**isAdmin** | **Boolean** | Flag indicating whether the user has the &#x60;admin&#x60; role. |  [optional]
**isCurrent** | **Boolean** | Flag indicating whether the user is the same as the one currently logged-in to make the request. In other words, this user is \&quot;you\&quot;. |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
LOCAL | &quot;local&quot;
LDAP | &quot;ldap&quot;
KEY | &quot;key&quot;



