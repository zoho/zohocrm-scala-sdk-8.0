package com.zoho.crm.api.masschangeowner

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class MassChangeOwnerOperations(var module: String)	{

	def changeOwner( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.module.toString())
		apiPath = apiPath.concat("/actions/mass_change_owner")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def checkStatus( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.module.toString())
		apiPath = apiPath.concat("/actions/mass_change_owner")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object MassChangeOwnerOperations{
class CheckStatusParam		{
		final val jobId:Param[Long] = new Param[Long]("job_id", "com.zoho.crm.api.MassChangeOwner.CheckStatusParam")
	}
}
