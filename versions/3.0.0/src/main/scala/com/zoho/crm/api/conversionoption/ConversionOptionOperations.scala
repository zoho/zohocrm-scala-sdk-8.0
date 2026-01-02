package com.zoho.crm.api.conversionoption

import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Utility
import com.zoho.crm.api.util.Constants

class ConversionOptionOperations(var leadId: Long)	{

	def leadConversionOptions() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Leads/")
		apiPath = apiPath.concat( this.leadId.toString())
		apiPath = apiPath.concat("/__conversion_options")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setModuleAPIName("Leads")
		Utility.getFields("Leads,Contacts,Deals,Accounts", handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}