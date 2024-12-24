package com.zoho.crm.api.recyclebin

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class RecycleBinOperations	{
	def getRecyclebinRecords( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deleteRecyclebinRecords( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getRecyclebinRecord( recordId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin/")
		apiPath = apiPath.concat(recordId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deleteRecyclebinRecord( recordId: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin/")
		apiPath = apiPath.concat(recordId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object RecycleBinOperations{
class GetRecycleBinRecordsParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam")
		final val sortBy:Param[String] = new Param[String]("sort_by", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam")
		final val sortOrder:Param[String] = new Param[String]("sort_order", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam")
		final val filters:Param[String] = new Param[String]("filters", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam")
	}


class DeleteRecycleBinRecordsParam		{
		final val filters:Param[String] = new Param[String]("filters", "com.zoho.crm.api.RecycleBin.DeleteRecycleBinRecordsParam")
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.RecycleBin.DeleteRecycleBinRecordsParam")
	}
}
