package com.zoho.crm.api.customviews

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class CustomViewsOperations	{
	def getCustomViews( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/custom_views")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getCustomView( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/custom_views/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def changeSortOrderOfCustomViews( request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/custom_views/actions/change_sort")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def changeSortOrderOfCustomView( id: Long,  request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/custom_views/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/change_sort")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object CustomViewsOperations{
class GetCustomViewsParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.CustomViews.GetCustomViewsParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.CustomViews.GetCustomViewsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.CustomViews.GetCustomViewsParam")
	}


class GetCustomViewParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.CustomViews.GetCustomViewParam")
	}


class ChangeSortOrderOfCustomViewsParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.CustomViews.ChangeSortOrderOfCustomViewsParam")
	}


class ChangeSortOrderOfCustomViewParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.CustomViews.ChangeSortOrderOfCustomViewParam")
	}
}
