package com.zoho.crm.api.downloadattachments

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class DownloadAttachmentsOperations	{
	def getDownloadAttachmentsDetails( recordId: Long,  module: String,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/Emails/actions/download_attachments")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "multipart/form-data")
	}}
 object DownloadAttachmentsOperations{
class GetDownloadAttachmentsDetailsParam		{
		final val userId:Param[Long] = new Param[Long]("user_id", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam")
		final val messageId:Param[String] = new Param[String]("message_id", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam")
		final val id:Param[String] = new Param[String]("id", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam")
		final val name:Param[String] = new Param[String]("name", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam")
	}
}
