package com.zoho.crm.api.attachments

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class AttachmentsOperations	{
	def uploadAttachments( recordId: Long,  module: String,  request: FileBodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/Attachments")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("multipart/form-data")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getAttachments( recordId: Long,  module: String,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/Attachments")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def uploadUrlAttachments( recordId: Long,  module: String,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/Attachments")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteAttachments( recordId: Long,  module: String,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/Attachments")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getAttachment( id: Long,  recordId: Long,  module: String) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/Attachments/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		return handlerInstance.apiCall(classOf[ResponseHandler], "image/png")
	}

	def deleteAttachment( id: Long,  recordId: Long,  module: String) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/Attachments/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object AttachmentsOperations{
class GetAttachmentsParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.Attachments.GetAttachmentsParam")
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.Attachments.GetAttachmentsParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.Attachments.GetAttachmentsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.Attachments.GetAttachmentsParam")
		final val pageToken:Param[String] = new Param[String]("page_token", "com.zoho.crm.api.Attachments.GetAttachmentsParam")
	}


class UploadUrlAttachmentsParam		{
		final val attachmentUrl:Param[String] = new Param[String]("attachmentUrl", "com.zoho.crm.api.Attachments.UploadUrlAttachmentsParam")
		final val title:Param[String] = new Param[String]("title", "com.zoho.crm.api.Attachments.UploadUrlAttachmentsParam")
	}


class DeleteAttachmentsParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.Attachments.DeleteAttachmentsParam")
	}
}
