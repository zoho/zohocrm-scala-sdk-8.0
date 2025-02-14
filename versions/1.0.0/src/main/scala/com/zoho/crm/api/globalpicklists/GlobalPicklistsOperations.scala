package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class GlobalPicklistsOperations	{
	def getGlobalPicklists( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createGlobalPicklist( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateGlobalPicklists( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod("PATCH")
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteGlobalPicklists( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getGlobalPicklist( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateGlobalPicklist( id: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod("PATCH")
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteGlobalPicklist( id: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def replacePicklistValues( id: Long,  request: ReplaceBodyWrapper) :Option[APIResponse[ReplaceActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/replace_picklist_values")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		return handlerInstance.apiCall(classOf[ReplaceActionHandler], "application/json")
	}

	def getReplaceValues( id: Long) :Option[APIResponse[ReplacedResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/replaced_values")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		return handlerInstance.apiCall(classOf[ReplacedResponseHandler], "application/json")
	}

	def getAssociations( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[AssociationsResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/associations")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[AssociationsResponseHandler], "application/json")
	}

	def getPickListValueAssociations( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[PickListValuesAssociationsResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/pick_list_values_associations")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[PickListValuesAssociationsResponseHandler], "application/json")
	}}
 object GlobalPicklistsOperations{
class GetGlobalPicklistsParam		{
		final val include:Param[String] = new Param[String]("include", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistsParam")
		final val includeInnerDetails:Param[String] = new Param[String]("include_inner_details", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistsParam")
	}


class DeleteGlobalPicklistsParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.GlobalPicklists.DeleteGlobalPicklistsParam")
	}


class GetGlobalPicklistParam		{
		final val include:Param[String] = new Param[String]("include", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistParam")
		final val includeInnerDetails:Param[String] = new Param[String]("include_inner_details", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistParam")
	}


class GetAssociationsParam		{
		final val includeInnerDetails:Param[String] = new Param[String]("include_inner_details", "com.zoho.crm.api.GlobalPicklists.GetAssociationsParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.GlobalPicklists.GetAssociationsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.GlobalPicklists.GetAssociationsParam")
	}


class GetPickListValueAssociationsParam		{
		final val picklistValueId:Param[Long] = new Param[Long]("picklist_value_id", "com.zoho.crm.api.GlobalPicklists.GetPickListValueAssociationsParam")
	}
}
