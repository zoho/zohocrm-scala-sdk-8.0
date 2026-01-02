package com.zoho.crm.api.duplicatecheckpreference

import com.zoho.crm.api.Param
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class DuplicateCheckPreferenceOperations(var module: Option[String]=None)	{

	def getDuplicateCheckPreference() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.DuplicateCheckPreference.GetDuplicateCheckPreferenceParam"),  this.module)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createDuplicateCheckPreference( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.DuplicateCheckPreference.CreateDuplicateCheckPreferenceParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateDuplicateCheckPreference( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.DuplicateCheckPreference.UpdateDuplicateCheckPreferenceParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteDuplicateCheckPreference() :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.DuplicateCheckPreference.DeleteDuplicateCheckPreferenceParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object DuplicateCheckPreferenceOperations{
class GetDuplicateCheckPreferenceParam		{
	}


class CreateDuplicateCheckPreferenceParam		{
	}


class UpdateDuplicateCheckPreferenceParam		{
	}


class DeleteDuplicateCheckPreferenceParam		{
	}
}
