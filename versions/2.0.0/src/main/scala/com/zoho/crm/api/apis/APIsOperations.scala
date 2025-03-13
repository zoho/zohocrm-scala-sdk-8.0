package com.zoho.crm.api.apis

import com.zoho.crm.api.Param
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class APIsOperations(var filters: Option[String]=None)	{

	def getSupportedAPI() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/__apis")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("filters", "com.zoho.crm.api.Apis.GetSupportedAPIParam"),  this.filters)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object APIsOperations{
class GetSupportedAPIParam		{
	}
}
