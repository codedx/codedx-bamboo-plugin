
# FileUploadResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**jobId** | **String** | the ID of the content identification task. The task may be monitored via the Job System. |  [optional]
**inputId** | **String** | the ID of the input created by uploading the file. This ID should be used when constructing URLs for interacting with the input. |  [optional]
**size** | **Integer** | The size (in bytes) of the uploaded file. Note that this may differ from the original size of the file, as Code Dx performs some internal cleanup of zip-like files. |  [optional]



