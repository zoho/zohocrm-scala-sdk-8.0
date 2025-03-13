package com.zoho.crm.api.findandmerge

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class FindAndMergeOperations(var module: String, var masterrecordid: Long)	{

	def getRecordMerge( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.masterrecordid.toString())
		apiPath = apiPath.concat("/actions/merge")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def mergeRecords( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.masterrecordid.toString())
		apiPath = apiPath.concat("/actions/merge")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object FindAndMergeOperations{
class GetRecordMergeParam		{
		final val jobId:Param[Long] = new Param[Long]("job_id", "com.zoho.crm.api.FindAndMerge.GetRecordMergeParam")
	}
}
