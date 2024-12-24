package com.zoho.crm.api.functions

import com.zoho.crm.api.Header
import com.zoho.crm.api.HeaderMap
import com.zoho.crm.api.Param
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import scala.collection.mutable.HashMap
import com.zoho.crm.api.util.Constants

class FunctionsOperations(var functionName: String, var authType: Option[String]=None, var arguments: Option[HashMap[String, Any]]=None)	{

	def executeFunctionUsingRequestBody( request: BodyWrapper,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseWrapper]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/functions/")
		apiPath = apiPath.concat( this.functionName.toString())
		apiPath = apiPath.concat("/actions/execute")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("auth_type", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyParam"),  this.authType)
		handlerInstance.addParam(new Param[HashMap[String, Any]]("arguments", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyParam"),  this.arguments)
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		return handlerInstance.apiCall(classOf[ResponseWrapper], "application/json")
	}

	def executeFunctionUsingParameters( paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseWrapper]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/functions/")
		apiPath = apiPath.concat( this.functionName.toString())
		apiPath = apiPath.concat("/actions/execute")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[String]("auth_type", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersParam"),  this.authType)
		handlerInstance.addParam(new Param[HashMap[String, Any]]("arguments", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersParam"),  this.arguments)
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		return handlerInstance.apiCall(classOf[ResponseWrapper], "application/json")
	}

	def executeFunctionUsingFile( request: FileBodyWrapper,  paramInstance: Option[ParameterMap]=None,  headerInstance: Option[HeaderMap]=None) :Option[APIResponse[ResponseWrapper]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/functions/")
		apiPath = apiPath.concat( this.functionName.toString())
		apiPath = apiPath.concat("/actions/execute")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("multipart/form-data")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[String]("auth_type", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileParam"),  this.authType)
		handlerInstance.addParam(new Param[HashMap[String, Any]]("arguments", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileParam"),  this.arguments)
		handlerInstance.setParam(paramInstance)
		handlerInstance.setHeader(headerInstance)
		return handlerInstance.apiCall(classOf[ResponseWrapper], "application/json")
	}}
 object FunctionsOperations{
class ExecuteFunctionUsingRequestBodyParam		{
		final val customFunctionsParam:Param[HashMap[String, Any]] = new Param[HashMap[String, Any]]("custom_functions_param", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyParam")
	}


class ExecuteFunctionUsingRequestBodyHeader		{
		final val customFunctionsHeader:Header[HashMap[String, Any]] = new Header[HashMap[String, Any]]("custom_functions_header", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyHeader")
	}


class ExecuteFunctionUsingParametersParam		{
		final val getCustomFunctionsParam:Param[HashMap[String, Any]] = new Param[HashMap[String, Any]]("get_custom_functions_param", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersParam")
	}


class ExecuteFunctionUsingParametersHeader		{
		final val getCustomFunctionsHeader:Header[HashMap[String, Any]] = new Header[HashMap[String, Any]]("get_custom_functions_header", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersHeader")
	}


class ExecuteFunctionUsingFileParam		{
		final val uploadFileParam:Param[HashMap[String, Any]] = new Param[HashMap[String, Any]]("upload_file_param", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileParam")
	}


class ExecuteFunctionUsingFileHeader		{
		final val uploadFileHeader:Header[HashMap[String, Any]] = new Header[HashMap[String, Any]]("upload_file_header", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileHeader")
	}
}
