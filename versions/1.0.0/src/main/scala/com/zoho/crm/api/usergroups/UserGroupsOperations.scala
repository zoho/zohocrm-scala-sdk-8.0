package com.zoho.crm.api.usergroups

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class UserGroupsOperations	{
	def getGroups( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createGroups( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateGroups( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getGroup( group: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/")
		apiPath = apiPath.concat(group.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateGroup( group: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/")
		apiPath = apiPath.concat(group.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteGroup( group: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/")
		apiPath = apiPath.concat(group.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getSources( group: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/")
		apiPath = apiPath.concat(group.toString())
		apiPath = apiPath.concat("/sources")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getSourcesCount( group: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/")
		apiPath = apiPath.concat(group.toString())
		apiPath = apiPath.concat("/actions/sources_count")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getAssociations( group: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/")
		apiPath = apiPath.concat(group.toString())
		apiPath = apiPath.concat("/actions/associations")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getAssociatedUsersCount( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/actions/associated_users_count")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getAssociateGroupsOfUser( user: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/users/")
		apiPath = apiPath.concat(user.toString())
		apiPath = apiPath.concat("/actions/associated_groups")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def getGroupedCounts( group: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/user_groups/")
		apiPath = apiPath.concat(group.toString())
		apiPath = apiPath.concat("/associated_users/actions/grouped_counts")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}}
 object UserGroupsOperations{
class GetGroupsParam		{
		final val include:Param[String] = new Param[String]("include", "com.zoho.crm.api.UserGroups.GetGroupsParam")
		final val name:Param[String] = new Param[String]("name", "com.zoho.crm.api.UserGroups.GetGroupsParam")
		final val page:Param[String] = new Param[String]("page", "com.zoho.crm.api.UserGroups.GetGroupsParam")
		final val perPage:Param[String] = new Param[String]("per_page", "com.zoho.crm.api.UserGroups.GetGroupsParam")
		final val filters:Param[Criteria] = new Param[Criteria]("filters", "com.zoho.crm.api.UserGroups.GetGroupsParam")
	}


class GetSourcesParam		{
		final val type1:Param[String] = new Param[String]("type", "com.zoho.crm.api.UserGroups.GetSourcesParam")
		final val userType:Param[String] = new Param[String]("user_type", "com.zoho.crm.api.UserGroups.GetSourcesParam")
		final val page:Param[String] = new Param[String]("page", "com.zoho.crm.api.UserGroups.GetSourcesParam")
		final val perPage:Param[String] = new Param[String]("per_page", "com.zoho.crm.api.UserGroups.GetSourcesParam")
	}


class GetAssociatedUsersCountParam		{
		final val page:Param[String] = new Param[String]("page", "com.zoho.crm.api.UserGroups.GetAssociatedUsersCountParam")
		final val perPage:Param[String] = new Param[String]("per_page", "com.zoho.crm.api.UserGroups.GetAssociatedUsersCountParam")
		final val filters:Param[Criteria] = new Param[Criteria]("filters", "com.zoho.crm.api.UserGroups.GetAssociatedUsersCountParam")
	}


class GetAssociateGroupsOfUserParam		{
		final val include:Param[String] = new Param[String]("include", "com.zoho.crm.api.UserGroups.GetAssociateGroupsOfUserParam")
		final val page:Param[String] = new Param[String]("page", "com.zoho.crm.api.UserGroups.GetAssociateGroupsOfUserParam")
		final val perPage:Param[String] = new Param[String]("per_page", "com.zoho.crm.api.UserGroups.GetAssociateGroupsOfUserParam")
	}


class GetGroupedCountsParam		{
		final val groupBy:Param[String] = new Param[String]("group_by", "com.zoho.crm.api.UserGroups.GetGroupedCountsParam")
	}
}
