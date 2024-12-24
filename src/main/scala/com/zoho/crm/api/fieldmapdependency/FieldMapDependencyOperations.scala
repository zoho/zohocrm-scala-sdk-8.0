package com.zoho.crm.api.fieldmapdependency

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class FieldMapDependencyOperations(var layoutId: Long, var module: Option[String]=None)	{

	def createMapDependency( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat( this.layoutId.toString())
		apiPath = apiPath.concat("/map_dependency")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.FieldMapDependency.CreateMapDependencyParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getMapDependencies( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat( this.layoutId.toString())
		apiPath = apiPath.concat("/map_dependency")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam"),  this.module)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateMapDependency( dependencyId: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat( this.layoutId.toString())
		apiPath = apiPath.concat("/map_dependency/")
		apiPath = apiPath.concat(dependencyId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.FieldMapDependency.UpdateMapDependencyParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getMapDependency( dependencyId: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat( this.layoutId.toString())
		apiPath = apiPath.concat("/map_dependency/")
		apiPath = apiPath.concat(dependencyId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.FieldMapDependency.GetMapDependencyParam"),  this.module)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def deleteMapDependency( dependencyId: Long) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/layouts/")
		apiPath = apiPath.concat( this.layoutId.toString())
		apiPath = apiPath.concat("/map_dependency/")
		apiPath = apiPath.concat(dependencyId.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.addParam(new Param[String]("module", "com.zoho.crm.api.FieldMapDependency.DeleteMapDependencyParam"),  this.module)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object FieldMapDependencyOperations{
class CreateMapDependencyParam		{
	}


class CreateMapDependencyHeader		{
	}


class GetMapDependenciesParam		{
		final val page:Param[Int] = new Param[Int]("page", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam")
		final val perPage:Param[Int] = new Param[Int]("per_page", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam")
		final val filters:Param[String] = new Param[String]("filters", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam")
	}


class UpdateMapDependencyParam		{
	}


class GetMapDependencyParam		{
	}


class DeleteMapDependencyParam		{
	}
}
