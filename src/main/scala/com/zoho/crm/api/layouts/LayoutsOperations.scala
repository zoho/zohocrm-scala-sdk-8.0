package com.zoho.crm.api.layouts

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class LayoutsOperations	{
	def getLayouts( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getLayout( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateCustomLayout( id: Long,  request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod("PATCH")
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteCustomLayout( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def activateCustomLayout( id: Long,  request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/activate")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deactivateCustomLayout( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/activate")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object LayoutsOperations{
class GetLayoutsParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Layouts.GetLayoutsParam")
	}


class GetLayoutsHeader		{
	}


class GetLayoutParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Layouts.GetLayoutParam")
	}


class GetLayoutHeader		{
	}


class UpdateCustomLayoutParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Layouts.UpdateCustomLayoutParam")
	}


class DeleteCustomLayoutParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Layouts.DeleteCustomLayoutParam")
		final val transferTo:Param[String] = new Param[String]("transfer_to", "com.zoho.crm.api.Layouts.DeleteCustomLayoutParam")
	}


class ActivateCustomLayoutParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Layouts.ActivateCustomLayoutParam")
	}


class DeactivateCustomLayoutParam		{
		final val transferTo:Param[String] = new Param[String]("transfer_to", "com.zoho.crm.api.Layouts.DeactivateCustomLayoutParam")
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Layouts.DeactivateCustomLayoutParam")
	}
}
