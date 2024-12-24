package com.zoho.crm.api.fieldattachments

import com.zoho.crm.api.Param
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class FieldAttachmentsOperations(var moduleAPIName: String, var recordId: Long, var fieldsAttachmentId: Option[Long]=None)	{

	def getFieldAttachments() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/actions/download_fields_attachment")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[Long]("fields_attachment_id", "com.zoho.crm.api.FieldAttachments.GetFieldAttachmentsParam"),  this.fieldsAttachmentId)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/x-download")
	}}
 object FieldAttachmentsOperations{
class GetFieldAttachmentsParam		{
	}
}
