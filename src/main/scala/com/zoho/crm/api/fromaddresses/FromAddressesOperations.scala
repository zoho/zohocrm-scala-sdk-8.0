package com.zoho.crm.api.fromaddresses

import com.zoho.crm.api.Param
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class FromAddressesOperations(var userId: Option[String]=None)	{

	def getFromAddresses() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/emails/actions/from_addresses")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("user_id", "com.zoho.crm.api.FromAddresses.GetFromAddressesParam"),  this.userId)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object FromAddressesOperations{
class GetFromAddressesParam		{
	}
}
