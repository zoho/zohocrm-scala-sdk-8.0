package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class ZiaPeopleEnrichmentOperations	{
	def getZiaPeopleEnrichments( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/__zia_people_enrichment")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createZiaPeopleEnrichment( request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/__zia_people_enrichment")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getZiaPeopleEnrichment( ziaPeopleEnrichmentId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/__zia_people_enrichment/")
		apiPath = apiPath.concat(ziaPeopleEnrichmentId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object ZiaPeopleEnrichmentOperations{
class GetZiaPeopleEnrichmentsParam		{
		final val status:Param[Choice[String]] = new Param[Choice[String]]("status", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam")
		final val sortOrder:Param[String] = new Param[String]("sort_order", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam")
		final val sortBy:Param[String] = new Param[String]("sort_by", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam")
		final val count:Param[Int] = new Param[Int]("count", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam")
	}


class CreateZiaPeopleEnrichmentParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.ZiaPeopleEnrichment.CreateZiaPeopleEnrichmentParam")
		final val recordId:Param[Long] = new Param[Long]("record_id", "com.zoho.crm.api.ZiaPeopleEnrichment.CreateZiaPeopleEnrichmentParam")
	}
}
