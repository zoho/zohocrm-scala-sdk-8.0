package com.zoho.crm.api.dealcontactroles

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Utility
import com.zoho.crm.api.util.Constants

class DealContactRolesOperations	{
	def getAssociatedContactRoles( deal: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Deals/")
		apiPath = apiPath.concat(deal.toString())
		apiPath = apiPath.concat("/Contact_Roles")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		handlerInstance.setModuleAPIName("Contacts")
		Utility.getFields("Contacts", handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deleteAssociatedContactRoles( deal: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Deals/")
		apiPath = apiPath.concat(deal.toString())
		apiPath = apiPath.concat("/Contact_Roles")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getAssociatedContactRolesSpecificToContact( contact: Long,  deal: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Deals/")
		apiPath = apiPath.concat(deal.toString())
		apiPath = apiPath.concat("/Contact_Roles/")
		apiPath = apiPath.concat(contact.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setModuleAPIName("Contacts")
		Utility.getFields("Contacts", handlerInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def associateContactRoleToDeal( contact: Long,  deal: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Deals/")
		apiPath = apiPath.concat(deal.toString())
		apiPath = apiPath.concat("/Contact_Roles/")
		apiPath = apiPath.concat(contact.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteContactRoleRelation( contact: Long,  deal: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/Deals/")
		apiPath = apiPath.concat(deal.toString())
		apiPath = apiPath.concat("/Contact_Roles/")
		apiPath = apiPath.concat(contact.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object DealContactRolesOperations{
class GetAssociatedContactRolesParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.DealContactRoles.GetAssociatedContactRolesParam")
		final val fields:Param[String] = new Param[String]("fields", "com.zoho.crm.api.DealContactRoles.GetAssociatedContactRolesParam")
	}


class DeleteAssociatedContactRolesParam		{
		final val ids:Param[String] = new Param[String]("ids", "com.zoho.crm.api.DealContactRoles.DeleteAssociatedContactRolesParam")
	}
}
