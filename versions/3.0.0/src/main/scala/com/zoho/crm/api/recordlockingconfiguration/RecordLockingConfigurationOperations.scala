package com.zoho.crm.api.recordlockingconfiguration

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class RecordLockingConfigurationOperations(var module: Option[String]=None)	{

	def getRecordLockingConfigurations( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.RecordLockingConfiguration.GetRecordLockingConfigurationsParam"),  this.module)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def addRecordLockingConfiguration( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.RecordLockingConfiguration.AddRecordLockingConfigurationParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateRecordLockingConfigurations( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.RecordLockingConfiguration.UpdateRecordLockingConfigurationsParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateRecordLockingConfiguration( recordLockingConfigId: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations/")
		apiPath = apiPath.concat(recordLockingConfigId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.RecordLockingConfiguration.UpdateRecordLockingConfigurationParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteRecordLockingConfiguration( recordLockingConfigId: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations/")
		apiPath = apiPath.concat(recordLockingConfigId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.RecordLockingConfiguration.DeleteRecordLockingConfigurationParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object RecordLockingConfigurationOperations{
class GetRecordLockingConfigurationsParam		{
		final val featureType:Param[String] = new Param[String]("feature_type", "com.zoho.crm.api.RecordLockingConfiguration.GetRecordLockingConfigurationsParam")
	}


class AddRecordLockingConfigurationParam		{
	}


class UpdateRecordLockingConfigurationsParam		{
	}


class UpdateRecordLockingConfigurationParam		{
	}


class DeleteRecordLockingConfigurationParam		{
	}
}
