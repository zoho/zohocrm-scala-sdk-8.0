package com.zoho.crm.api.recordlocking

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Utility
import com.zoho.crm.api.util.Constants

class RecordLockingOperations(var recordId: Long, var moduleName: String)	{

	def getRecordLockingInformations( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/Locking_Information__s")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		handlerInstance.setModuleAPIName("Locking_Information__s")
		Utility.getFields("Locking_Information__s", handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def lockRecords( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/Locking_Information__s")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setModuleAPIName("Locking_Information__s")
		Utility.getFields("Locking_Information__s", handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getRecordLockingInformation( lockId: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/Locking_Information__s/")
		apiPath = apiPath.concat(lockId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		handlerInstance.setModuleAPIName("Locking_Information__s")
		Utility.getFields("Locking_Information__s", handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateRecordLockingInformation( lockId: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/Locking_Information__s/")
		apiPath = apiPath.concat(lockId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setModuleAPIName("Locking_Information__s")
		Utility.getFields("Locking_Information__s", handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def unlockRecord( lockId: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/Locking_Information__s/")
		apiPath = apiPath.concat(lockId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setModuleAPIName("Locking_Information__s")
		Utility.getFields("Locking_Information__s", handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object RecordLockingOperations{
class GetRecordLockingInformationsParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam")
		final val pageToken:Param[String] = new Param[String]("page_token", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam")
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam")
	}


class GetRecordLockingInformationParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationParam")
	}
}
