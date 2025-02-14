package com.zoho.crm.api.entityscores

import com.zoho.crm.api.Header
import com.zoho.crm.api.HeaderMap
import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import java.time.OffsetDateTime
import com.zoho.crm.api.util.Constants

class EntityScoresOperations(var fields: Option[String]=None, var cvid: Option[String]=None)	{

	def getEntityScore( recordId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Entity_Scores__s/")
		apiPath = apiPath.concat(recordId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("fields", "com.zoho.crm.api.EntityScores.GetEntityScoreParam"),  this.fields)
		handlerInstance.addParam(new Param[String]("cvid", "com.zoho.crm.api.EntityScores.GetEntityScoreParam"),  this.cvid)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getEntityScores( paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Entity_Scores__s")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("fields", "com.zoho.crm.api.EntityScores.GetEntityScoresParam"),  this.fields)
		handlerInstance.addParam(new Param[String]("cvid", "com.zoho.crm.api.EntityScores.GetEntityScoresParam"),  this.cvid)
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object EntityScoresOperations{
class GetEntityScoreParam		{
	}


class GetEntityScoresParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.EntityScores.GetEntityScoresParam")
		final val sortBy:Param[String] = new Param[String]("sort_by", "com.zoho.crm.api.EntityScores.GetEntityScoresParam")
		final val sortOrder:Param[String] = new Param[String]("sort_order", "com.zoho.crm.api.EntityScores.GetEntityScoresParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.EntityScores.GetEntityScoresParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.EntityScores.GetEntityScoresParam")
		final val pageToken:Param[String] = new Param[String]("page_token", "com.zoho.crm.api.EntityScores.GetEntityScoresParam")
	}


class GetEntityScoresHeader		{
		final val IfModifiedSince:Header[OffsetDateTime] = new Header[OffsetDateTime]("If-Modified-Since", "com.zoho.crm.api.EntityScores.GetEntityScoresHeader")
	}
}
