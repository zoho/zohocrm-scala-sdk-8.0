package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class ZiaOrgEnrichmentOperations	{
	def getZiaOrgEnrichments( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/__zia_org_enrichment")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createZiaOrgEnrichment( request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/__zia_org_enrichment")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getZiaOrgEnrichment( ziaOrgEnrichmentId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/__zia_org_enrichment/")
		apiPath = apiPath.concat(ziaOrgEnrichmentId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object ZiaOrgEnrichmentOperations{
class GetZiaOrgEnrichmentsParam		{
		final val status:Param[Choice[String]] = new Param[Choice[String]]("status", "com.zoho.crm.api.ZiaOrgEnrichment.GetZiaOrgEnrichmentsParam")
		final val sortOrder:Param[String] = new Param[String]("sort_order", "com.zoho.crm.api.ZiaOrgEnrichment.GetZiaOrgEnrichmentsParam")
		final val sortBy:Param[String] = new Param[String]("sort_by", "com.zoho.crm.api.ZiaOrgEnrichment.GetZiaOrgEnrichmentsParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.ZiaOrgEnrichment.GetZiaOrgEnrichmentsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.ZiaOrgEnrichment.GetZiaOrgEnrichmentsParam")
	}


class CreateZiaOrgEnrichmentParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.ZiaOrgEnrichment.CreateZiaOrgEnrichmentParam")
		final val recordId:Param[Long] = new Param[Long]("record_id", "com.zoho.crm.api.ZiaOrgEnrichment.CreateZiaOrgEnrichmentParam")
	}
}
