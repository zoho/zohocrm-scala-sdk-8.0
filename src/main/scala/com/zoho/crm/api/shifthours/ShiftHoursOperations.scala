package com.zoho.crm.api.shifthours

import com.zoho.crm.api.Header
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class ShiftHoursOperations(var xCrmOrg: Option[String]=None)	{

	def getShiftHours() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.GetShiftHoursHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createShiftsHours( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.CreateShiftsHoursHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateShiftHours( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.UpdateShiftHoursHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getShiftHour( shiftId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours/")
		apiPath = apiPath.concat(shiftId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.GetShiftHourHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateShiftHour( shiftId: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours/")
		apiPath = apiPath.concat(shiftId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.UpdateShiftHourHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteShiftHour( shiftId: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours/")
		apiPath = apiPath.concat(shiftId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.DeleteShiftHourHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object ShiftHoursOperations{
class GetShiftHoursHeader		{
	}


class CreateShiftsHoursHeader		{
	}


class UpdateShiftHoursHeader		{
	}


class GetShiftHourHeader		{
	}


class UpdateShiftHourHeader		{
	}


class DeleteShiftHourHeader		{
	}
}
