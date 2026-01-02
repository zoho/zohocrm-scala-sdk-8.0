package com.zoho.crm.api.usertypeusers

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class UserTypeUsersOperations(var userTypeId: Long, var portalName: String)	{

	def getUsersOfUserType( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/portals/")
		apiPath = apiPath.concat( this.portalName.toString())
		apiPath = apiPath.concat("/user_type/")
		apiPath = apiPath.concat( this.userTypeId.toString())
		apiPath = apiPath.concat("/users")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deleteUserFromThePortal( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/portals/")
		apiPath = apiPath.concat( this.portalName.toString())
		apiPath = apiPath.concat("/user_type/")
		apiPath = apiPath.concat( this.userTypeId.toString())
		apiPath = apiPath.concat("/users")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def transferUsersOfAUserType( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/portals/")
		apiPath = apiPath.concat( this.portalName.toString())
		apiPath = apiPath.concat("/user_type/")
		apiPath = apiPath.concat( this.userTypeId.toString())
		apiPath = apiPath.concat("/users/action/transfer")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def changeUsersStatus( userId: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[StatusActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/portals/")
		apiPath = apiPath.concat( this.portalName.toString())
		apiPath = apiPath.concat("/user_type/")
		apiPath = apiPath.concat( this.userTypeId.toString())
		apiPath = apiPath.concat("/users/")
		apiPath = apiPath.concat(userId.toString())
		apiPath = apiPath.concat("/actions/change_status")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[StatusActionHandler], "application/json")
	}}
 object UserTypeUsersOperations{
class GetUsersOfUserTypeParam		{
		final val filters:Param[String] = new Param[String]("filters", "com.zoho.crm.api.UserTypeUsers.GetUsersOfUserTypeParam")
		final val type1:Param[String] = new Param[String]("type", "com.zoho.crm.api.UserTypeUsers.GetUsersOfUserTypeParam")
	}


class DeleteUserFromThePortalParam		{
		final val personalityIds:Param[String] = new Param[String]("personality_ids", "com.zoho.crm.api.UserTypeUsers.DeleteUserFromThePortalParam")
	}


class TransferUsersOfAUserTypeParam		{
		final val personalityIds:Param[String] = new Param[String]("personality_ids", "com.zoho.crm.api.UserTypeUsers.TransferUsersOfAUserTypeParam")
		final val transferTo:Param[String] = new Param[String]("transfer_To", "com.zoho.crm.api.UserTypeUsers.TransferUsersOfAUserTypeParam")
	}


class ChangeUsersStatusParam		{
		final val active:Param[Boolean] = new Param[Boolean]("active", "com.zoho.crm.api.UserTypeUsers.ChangeUsersStatusParam")
	}
}
