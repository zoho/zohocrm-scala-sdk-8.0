package com.zoho.crm.api.relatedlists

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class RelatedListsOperations(var layoutId: Option[Long]=None)	{

	def getRelatedLists( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/related_lists")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.RelatedLists.GetRelatedListsParam"),  this.layoutId)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getRelatedList( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/related_lists/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.RelatedLists.GetRelatedListParam"),  this.layoutId)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object RelatedListsOperations{
class GetRelatedListsParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.RelatedLists.GetRelatedListsParam")
	}


class GetRelatedListParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.RelatedLists.GetRelatedListParam")
	}
}
