package com.zoho.crm.api.fields

import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class FieldsOperations	{
	def getFields( paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/fields")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createField( request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/fields")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updateFields( request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/fields")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod("PATCH")
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getField( field: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/fields/")
		apiPath = apiPath.concat(field.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updateField( field: Long,  request: BodyWrapper,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/fields/")
		apiPath = apiPath.concat(field.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod("PATCH")
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deleteField( field: Long,  paramInstance: Option[ParameterMap]=None) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/fields/")
		apiPath = apiPath.concat(field.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setParam(paramInstance)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}}
 object FieldsOperations{
class GetFieldsParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Fields.GetFieldsParam")
		final val dataType:Param[String] = new Param[String]("data_type", "com.zoho.crm.api.Fields.GetFieldsParam")
		final val type1:Param[Choice[String]] = new Param[Choice[String]]("type", "com.zoho.crm.api.Fields.GetFieldsParam")
		final val include:Param[String] = new Param[String]("include", "com.zoho.crm.api.Fields.GetFieldsParam")
		final val featureName:Param[String] = new Param[String]("feature_name", "com.zoho.crm.api.Fields.GetFieldsParam")
		final val component:Param[String] = new Param[String]("component", "com.zoho.crm.api.Fields.GetFieldsParam")
		final val layoutId:Param[Long] = new Param[Long]("layout_id", "com.zoho.crm.api.Fields.GetFieldsParam")
	}


class GetFieldsHeader		{
	}


class CreateFieldParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Fields.CreateFieldParam")
	}


class UpdateFieldsParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Fields.UpdateFieldsParam")
	}


class GetFieldParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Fields.GetFieldParam")
		final val include:Param[String] = new Param[String]("include", "com.zoho.crm.api.Fields.GetFieldParam")
	}


class GetFieldHeader		{
	}


class UpdateFieldParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Fields.UpdateFieldParam")
	}


class DeleteFieldParam		{
		final val module:Param[String] = new Param[String]("module", "com.zoho.crm.api.Fields.DeleteFieldParam")
	}
}
