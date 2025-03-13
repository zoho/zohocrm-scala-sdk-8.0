package com.zoho.crm.api.portalinvite

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class PortalInviteOperations(var module: String)	{

	def inviteUsers( record: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/")
		apiPath = apiPath.concat( this.module.toString())
		apiPath = apiPath.concat("/")
		apiPath = apiPath.concat(record.toString())
		apiPath = apiPath.concat("/actions/portal_invite")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object PortalInviteOperations{
class InviteUsersParam		{
		final val userTypeId:Param[Long] = new Param[Long]("user_type_id", "com.zoho.crm.api.PortalInvite.InviteUsersParam")
		final val type1:Param[Choice[String]] = new Param[Choice[String]]("type", "com.zoho.crm.api.PortalInvite.InviteUsersParam")
		final val language:Param[Choice[String]] = new Param[Choice[String]]("language", "com.zoho.crm.api.PortalInvite.InviteUsersParam")
	}
}
