package com.zoho.crm.api.businesshours

import com.zoho.crm.api.Header
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class BusinessHoursOperations(var xCrmOrg: Option[String]=None)	{

	def createBusinessHours( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.BusinessHours.CreateBusinessHoursHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateBusinessHours( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.BusinessHours.UpdateBusinessHoursHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getBusinessHours() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.BusinessHours.GetBusinessHoursHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object BusinessHoursOperations{
class CreateBusinessHoursHeader		{
	}


class UpdateBusinessHoursHeader		{
	}


class GetBusinessHoursHeader		{
	}
}
