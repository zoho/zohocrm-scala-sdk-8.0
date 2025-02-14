package com.zoho.crm.api.picklistvalues

import com.zoho.crm.api.Param
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class PickListValuesOperations(var fieldId: Long, var module: Option[String]=None)	{

	def getPickListValues() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/fields/")
		apiPath = apiPath.concat( this.fieldId.toString())
		apiPath = apiPath.concat("/pick_list_values")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.PickListValues.GetPickListValuesParam"),  this.module)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object PickListValuesOperations{
class GetPickListValuesParam		{
	}
}
