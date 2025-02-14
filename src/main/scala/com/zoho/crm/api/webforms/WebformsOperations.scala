package com.zoho.crm.api.webforms

import com.zoho.crm.api.Param
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class WebformsOperations(var module: Option[String]=None)	{

	def getWebForms() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/webforms")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.Webforms.GetWebFormsParam"),  this.module)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createWebForms( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/webforms")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.Webforms.CreateWebFormsParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateWebForms( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/webforms")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.Webforms.UpdateWebFormsParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getWebForm( formId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/webforms/")
		apiPath = apiPath.concat(formId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.Webforms.GetWebFormParam"),  this.module)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateWebForm( formId: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/webforms/")
		apiPath = apiPath.concat(formId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.Webforms.UpdateWebFormParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteWebForms( formId: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/webforms/")
		apiPath = apiPath.concat(formId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.Webforms.DeleteWebFormsParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getWebformsPreview( formId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/webforms/")
		apiPath = apiPath.concat(formId.toString())
		apiPath = apiPath.concat("/actions/preview")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.Webforms.GetWebformsPreviewParam"),  this.module)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object WebformsOperations{
class GetWebFormsParam		{
	}


class CreateWebFormsParam		{
	}


class UpdateWebFormsParam		{
	}


class GetWebFormParam		{
	}


class UpdateWebFormParam		{
	}


class DeleteWebFormsParam		{
	}


class GetWebformsPreviewParam		{
	}
}
