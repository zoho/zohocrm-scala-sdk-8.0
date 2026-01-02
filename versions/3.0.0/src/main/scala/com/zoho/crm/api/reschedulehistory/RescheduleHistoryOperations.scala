package com.zoho.crm.api.reschedulehistory

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class RescheduleHistoryOperations	{
	def addAppointmentsRescheduledHistory( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Appointments_Rescheduled_History__s")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateAppointmentsRescheduledHistory( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Appointments_Rescheduled_History__s")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getAppointmentsRescheduledHistory( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Appointments_Rescheduled_History__s")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateAppointmentRescheduledHistory( id: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Appointments_Rescheduled_History__s/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getAppointmentRescheduledHistory( id: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Appointments_Rescheduled_History__s/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deleteAppointmentsRescheduledHistory( id: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Appointments_Rescheduled_History__s/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object RescheduleHistoryOperations{
class GetAppointmentsRescheduledHistoryParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RescheduleHistory.GetAppointmentsRescheduledHistoryParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.RescheduleHistory.GetAppointmentsRescheduledHistoryParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.RescheduleHistory.GetAppointmentsRescheduledHistoryParam")
		final val sortOrder:Param[String] = new Param[String]("sort_order", "com.zoho.crm.api.RescheduleHistory.GetAppointmentsRescheduledHistoryParam")
		final val sortBy:Param[String] = new Param[String]("sort_by", "com.zoho.crm.api.RescheduleHistory.GetAppointmentsRescheduledHistoryParam")
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.RescheduleHistory.GetAppointmentsRescheduledHistoryParam")
	}


class GetAppointmentRescheduledHistoryParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RescheduleHistory.GetAppointmentRescheduledHistoryParam")
	}
}
