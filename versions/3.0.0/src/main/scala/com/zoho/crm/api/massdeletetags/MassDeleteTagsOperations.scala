package com.zoho.crm.api.massdeletetags

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class MassDeleteTagsOperations	{
	def massDeleteTags( request: BodyWrapper) :Option[APIResponse[ActionResponse]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/tags/actions/mass_delete")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		return handlerInstance.apiCall(classOf[ActionResponse], "application/json")
	}

	def getStatus( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[StatusResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/tags/actions/mass_delete")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[StatusResponseHandler], "application/json")
	}}
 object MassDeleteTagsOperations{
class GetStatusParam		{
		final val jobId:Param[String] = new Param[String]("job_id", "com.zoho.crm.api.MassDeleteTags.GetStatusParam")
	}
}
