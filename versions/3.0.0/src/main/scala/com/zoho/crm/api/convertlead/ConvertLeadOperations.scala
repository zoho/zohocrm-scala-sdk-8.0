package com.zoho.crm.api.convertlead

import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Utility
import com.zoho.crm.api.util.Constants

class ConvertLeadOperations(var leadId: Long)	{

	def convertLead( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Leads/")
		apiPath = apiPath.concat( this.leadId.toString())
		apiPath = apiPath.concat("/actions/convert")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setModuleAPIName("Deals")
		Utility.getFields("Deals", handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}