package com.zoho.crm.api.emailsharingdetails

import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class EmailSharingDetailsOperations(var recordId: Long, var module: String)	{

	def getEmailSharingDetails() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/__emails_sharing_details")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}