package com.zoho.crm.api.relatedrecords

import com.zoho.crm.api.Header
import com.zoho.crm.api.HeaderMap
import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Utility
import java.time.OffsetDateTime
import com.zoho.crm.api.util.Constants

class RelatedRecordsOperations(var relatedListAPIName: String, var moduleAPIName: String)	{

	def getRelatedRecords( recordId: Long,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateRelatedRecords( recordId: Long,  request: BodyWrapper,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def delinkRecords( recordId: Long,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		Utility.getFields( this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getRelatedRecordsUsingExternalId( externalValue: String,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalValue.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateRelatedRecordsUsingExternalId( externalValue: String,  request: BodyWrapper,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalValue.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteRelatedRecordsUsingExternalId( externalValue: String,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalValue.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getRelatedRecord( relatedRecordId: Long,  recordId: Long,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(relatedRecordId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateRelatedRecord( relatedRecordId: Long,  recordId: Long,  request: BodyWrapper,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(relatedRecordId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def delinkRecord( relatedRecordId: Long,  recordId: Long,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(relatedRecordId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setHeader(headerInstance)
		Utility.getFields( this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getRelatedRecordUsingExternalId( externalFieldValue: String,  externalValue: String,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalValue.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalFieldValue.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateRelatedRecordUsingExternalId( externalFieldValue: String,  externalValue: String,  request: BodyWrapper,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalValue.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalFieldValue.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteRelatedRecordUsingExternalId( externalFieldValue: String,  externalValue: String,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalValue.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(externalFieldValue.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setHeader(headerInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getDeletedParentRecordsRelatedRecord( recordId: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleAPIName.toString())
		apiPath = apiPath.concat("/deleted/")
		apiPath = apiPath.concat(recordId.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.relatedListAPIName.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object RelatedRecordsOperations{
class GetRelatedRecordsParam		{
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsParam")
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsParam")
	}


class GetRelatedRecordsHeader		{
		final val IfModifiedSince:Header[OffsetDateTime] = new Header[OffsetDateTime]("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsHeader")
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsHeader")
	}


class UpdateRelatedRecordsHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordsHeader")
	}


class DelinkRecordsParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.RelatedRecords.DelinkRecordsParam")
	}


class DelinkRecordsHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DelinkRecordsHeader")
	}


class GetRelatedRecordsUsingExternalIDParam		{
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDParam")
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDParam")
	}


class GetRelatedRecordsUsingExternalIDHeader		{
		final val IfModifiedSince:Header[OffsetDateTime] = new Header[OffsetDateTime]("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDHeader")
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDHeader")
	}


class UpdateRelatedRecordsUsingExternalIDHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordsUsingExternalIDHeader")
	}


class DeleteRelatedRecordsUsingExternalIDParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.RelatedRecords.DeleteRelatedRecordsUsingExternalIDParam")
	}


class DeleteRelatedRecordsUsingExternalIDHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DeleteRelatedRecordsUsingExternalIDHeader")
	}


class GetRelatedRecordParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordParam")
	}


class GetRelatedRecordHeader		{
		final val IfModifiedSince:Header[OffsetDateTime] = new Header[OffsetDateTime]("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordHeader")
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordHeader")
	}


class UpdateRelatedRecordHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordHeader")
	}


class DelinkRecordHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DelinkRecordHeader")
	}


class GetRelatedRecordUsingExternalIDParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordUsingExternalIDParam")
	}


class GetRelatedRecordUsingExternalIDHeader		{
		final val IfModifiedSince:Header[OffsetDateTime] = new Header[OffsetDateTime]("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordUsingExternalIDHeader")
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordUsingExternalIDHeader")
	}


class UpdateRelatedRecordUsingExternalIDHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordUsingExternalIDHeader")
	}


class DeleteRelatedRecordUsingExternalIDHeader		{
		final val XEXTERNAL:Header[String] = new Header[String]("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DeleteRelatedRecordUsingExternalIDHeader")
	}


class GetDeletedParentRecordsRelatedRecordParam		{
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam")
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam")
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam")
	}
}
