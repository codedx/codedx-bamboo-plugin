
# GroupedCountsRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filter** | [**Filter**](Filter.md) |  |  [optional]
**countBy** | **String** | &#x60;countBy&#x60; may be one of the following&amp;#58; - path - file - descriptor - resultDescriptor - detectionMethod - severity - status - toolOverlap - traceSession - issueTrackerAssociationStatus - sourceMethodAndHybridness&amp;#58;finding-id (replace &#39;finding-id&#39; with an actual finding id) - standard&amp;#58;(cwe | standard-id) (The \&quot;Get Standards\&quot; endpoint will return usable countBy values for standard-id) - age&amp;#58;[age bucket specifiers]  The general format of an *age bucket specifier* is &#x60;&lt;bucket1&gt;&#x3D;&lt;title1&gt;;...;&lt;bucketN&gt;&#x3D;&lt;titleN&gt;&#x60; for N buckets.  Each \&quot;bucket\&quot; is a concatenation of age specifiers&amp;#58; - &#x60;today&#x60; includes findings that were first seen today - &#x60;&lt;number&gt;d&#x60; includes findings that were seen at most *number* days ago, e.g. &#x60;7d&#x60; means findings that were seen at *most* 7 days ago. &#x60;h&#x60;, &#x60;m&#x60;, or &#x60;s&#x60; can be used instead of &#x60;d&#x60; to indicate hours, minutes, or seconds, respectively. - &#x60;-&lt;specifier&gt;&#x60; negates a specifier, e.g. &#x60;-7d&#x60; means findings that were seen at *least* 7 days ago - &#x60;&lt;sepcifier1&gt;&lt;specifier2&gt;&#x60; creates an and relationship between the two (or more) specifiers, e.g. &#x60;7d-3d&#x60; mean \&quot;at most 7 days old, *and* at least 3 days old\&quot;.  The countBy used in Code Dx&#39;s UI to populate the Age Filter is&amp;#58; &#x60;&#x60;&#x60; age:today&#x3D;First seen today;7d-today&#x3D;Less than 7 days old;30d-7d&#x3D;7 - 30 days old;90d-30d&#x3D;30 - 90 days old;180d-90d&#x3D;90 - 180 days old;-180d&#x3D;More than 180 days old &#x60;&#x60;&#x60; Note that because each bucket/title specification is joined with a semicolon (;), semicolons in a title must be prefixed with a backslash (\\) to distinguish between textual semicolons and formatting semicolons. E.g. age:today&#x3D;hello\\; world.  |  [optional]



