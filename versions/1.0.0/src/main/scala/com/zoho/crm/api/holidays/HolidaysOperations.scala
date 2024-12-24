package com.zoho.crm.api.holidays

import com.zoho.crm.api.Header
import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class HolidaysOperations(var xCrmOrg: Option[String]=None)	{

	def getHolidays( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/holidays")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.Holidays.GetHolidaysHeader"),  this.xCrmOrg)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createHolidays( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/holidays")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.Holidays.CreateHolidaysHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateHolidays( request: Holidays) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/holidays")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.Holidays.UpdateHolidaysHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateHoliday( holidayId: Long,  request: Holidays) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/holidays/")
		apiPath = apiPath.concat(holidayId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.Holidays.UpdateHolidayHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getHoliday( holidayId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/holidays/")
		apiPath = apiPath.concat(holidayId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.Holidays.GetHolidayHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deleteHoliday( holidayId: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/holidays/")
		apiPath = apiPath.concat(holidayId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.addHeader(new Header[String]("X-CRM-ORG", "com.zoho.crm.api.Holidays.DeleteHolidayHeader"),  this.xCrmOrg)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object HolidaysOperations{
class GetHolidaysHeader		{
	}


class GetHolidaysParam		{
		final val year:Param[Int] = new Param[Int]("year", "com.zoho.crm.api.Holidays.GetHolidaysParam")
		final val type1:Param[Choice[String]] = new Param[Choice[String]]("type", "com.zoho.crm.api.Holidays.GetHolidaysParam")
		final val shiftId:Param[Long] = new Param[Long]("shift_id", "com.zoho.crm.api.Holidays.GetHolidaysParam")
	}


class CreateHolidaysHeader		{
	}


class UpdateHolidaysHeader		{
	}


class UpdateHolidayHeader		{
	}


class GetHolidayHeader		{
	}


class DeleteHolidayHeader		{
	}
}
