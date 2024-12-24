package com.zoho.crm.api.emailrelatedrecords

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class EmailRelatedRecordsOperations(var recordId: Long, var moduleName: String, var type1: Option[String]=None, var ownerId: Option[Long]=None)	{

	def getEmailsRelatedRecords( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/Emails")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("type", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam"),  this.type1)
		handlerInstance.addParam(new Param[Long]("owner_id", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam"),  this.ownerId)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getEmailsRelatedRecord( messageId: String) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.moduleName.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat( this.recordId.toString())
		apiPath = apiPath.concat("/Emails/")
		apiPath = apiPath.concat(messageId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("type", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordParam"),  this.type1)
		handlerInstance.addParam(new Param[Long]("owner_id", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordParam"),  this.ownerId)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object EmailRelatedRecordsOperations{
class GetEmailsRelatedRecordsParam		{
		final val filter:Param[Criteria] = new Param[Criteria]("filter", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam")
		final val index:Param[String] = new Param[String]("index", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam")
	}


class GetEmailsRelatedRecordParam		{
	}
}
