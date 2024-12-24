package com.zoho.crm.api.emailtemplates

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class EmailTemplatesOperations	{
	def getEmailTemplates( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/email_templates")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getEmailTemplate( template: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/email_templates/")
		apiPath = apiPath.concat(template.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object EmailTemplatesOperations{
class GetEmailTemplatesParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam")
		final val category:Param[String] = new Param[String]("category", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam")
		final val sortBy:Param[String] = new Param[String]("sort_by", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam")
		final val sortOrder:Param[String] = new Param[String]("sort_order", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam")
		final val filters:Param[String] = new Param[String]("filters", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam")
	}
}
