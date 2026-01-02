package com.zoho.crm.api.timelines

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class TimelinesOperations	{
	def getTimelines( module: String,  recordId: String,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat(module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/__timeline")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object TimelinesOperations{
class GetTimelinesParam		{
		final val includeInnerDetails:Param[Choice[String]] = new Param[Choice[String]]("include_inner_details", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val sortBy:Param[String] = new Param[String]("sort_by", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val sortOrder:Param[Choice[String]] = new Param[Choice[String]]("sort_order", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val includeTimelineType:Param[String] = new Param[String]("include_timeline_type", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val include:Param[Choice[String]] = new Param[Choice[String]]("include", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val filters:Param[String] = new Param[String]("filters", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val perPage:Param[String] = new Param[String]("per_page", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val page:Param[String] = new Param[String]("page", "com.zoho.crm.api.Timelines.GetTimelinesParam")
		final val pageToken:Param[String] = new Param[String]("page_token", "com.zoho.crm.api.Timelines.GetTimelinesParam")
	}
}
