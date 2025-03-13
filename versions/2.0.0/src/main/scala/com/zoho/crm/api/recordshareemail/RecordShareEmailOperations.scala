package com.zoho.crm.api.recordshareemail

import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class RecordShareEmailOperations(var moduleAPIName: String)	{

	def shareEmails( id: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/share_emails")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def unshareEmails( id: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/unshare_emails")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def shareBulkEmails( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/actions/share_emails")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def unshareBulkEmails( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/actions/unshare_emails")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}