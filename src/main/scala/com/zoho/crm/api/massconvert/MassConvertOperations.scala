package com.zoho.crm.api.massconvert

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Utility
import com.zoho.crm.api.util.Constants

class MassConvertOperations	{
	def massConvert( request: BodyWrapper) :Option[APIResponse[ActionResponse]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Leads/actions/mass_convert")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setModuleAPIName("Deals")
		Utility.getFields("Deals", handlerInstance)
		return handlerInstance.apiCall(classOf[ActionResponse], "application/json")
	}

	def getJobStatus( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Leads/actions/mass_convert")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object MassConvertOperations{
class GetJobStatusParam		{
		final val jobId:Param[Long] = new Param[Long]("job_id", "com.zoho.crm.api.MassConvert.GetJobStatusParam")
	}
}
