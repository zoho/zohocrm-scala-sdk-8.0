package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class SharingRulesOperations(var module: Option[String]=None)	{

	def getSharingRules( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.GetSharingRulesParam"),  this.module)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createSharingRules( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.CreateSharingRulesParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateSharingRules( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.UpdateSharingRulesParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getSharingRule( id: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.GetSharingRuleParam"),  this.module)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateSharingRule( id: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.UpdateSharingRuleParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteSharingRule( id: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.DeleteSharingRuleParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def searchSharingRules( request: FiltersBody,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/search")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.SearchSharingRulesParam"),  this.module)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deactivateSharingRule( id: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/activate")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.DeactivateSharingRuleParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def activateSharingRule( id: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/")
		apiPath = apiPath.concat(id.toString())
		apiPath = apiPath.concat("/actions/activate")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.ActivateSharingRuleParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getSharingRuleSummary() :Option[APIResponse[SummaryResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/actions/summary")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.GetSharingRuleSummaryParam"),  this.module)
		return handlerInstance.apiCall(classOf[SummaryResponseHandler], "application/json")
	}

	def searchSharingRulesSummary( request: FiltersBody) :Option[APIResponse[SummaryResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/actions/summary")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.SearchSharingRulesSummaryParam"),  this.module)
		return handlerInstance.apiCall(classOf[SummaryResponseHandler], "application/json")
	}

	def rerunSharingRules() :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/actions/run")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.SharingRules.RerunSharingRulesParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object SharingRulesOperations{
class GetSharingRulesParam		{
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.SharingRules.GetSharingRulesParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.SharingRules.GetSharingRulesParam")
	}


class CreateSharingRulesParam		{
	}


class UpdateSharingRulesParam		{
	}


class GetSharingRuleParam		{
	}


class UpdateSharingRuleParam		{
	}


class DeleteSharingRuleParam		{
	}


class SearchSharingRulesParam		{
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.SharingRules.SearchSharingRulesParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.SharingRules.SearchSharingRulesParam")
	}


class DeactivateSharingRuleParam		{
	}


class ActivateSharingRuleParam		{
	}


class GetSharingRuleSummaryParam		{
	}


class SearchSharingRulesSummaryParam		{
	}


class RerunSharingRulesParam		{
	}
}
