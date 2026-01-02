package com.zoho.crm.api.pipeline

import com.zoho.crm.api.Param
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.CommonAPIHandler
import com.zoho.crm.api.util.Constants

class PipelineOperations(var layoutId: Option[Long]=None)	{

	def getPipelines() :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/pipeline")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.Pipeline.GetPipelinesParam"),  this.layoutId)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def createPipeline( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/pipeline")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("CREATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.Pipeline.CreatePipelineParam"),  this.layoutId)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def updatePipelines( request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/pipeline")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.setMandatoryChecker(true)
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.Pipeline.UpdatePipelinesParam"),  this.layoutId)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def getPipeline( id: Long) :Option[APIResponse[ResponseHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/pipeline/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
		handlerInstance.setCategoryMethod("READ")
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.Pipeline.GetPipelineParam"),  this.layoutId)
		return handlerInstance.apiCall(classOf[ResponseHandler], "application/json")
	}

	def updatePipeline( id: Long,  request: BodyWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/pipeline/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT)
		handlerInstance.setCategoryMethod("UPDATE")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.Pipeline.UpdatePipelineParam"),  this.layoutId)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def deletePipeline( id: Long,  request: DPipelineWrapper) :Option[APIResponse[ActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/pipeline/")
		apiPath = apiPath.concat(id.toString())
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod("PATCH")
		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE)
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.Pipeline.DeletePipelineParam"),  this.layoutId)
		return handlerInstance.apiCall(classOf[ActionHandler], "application/json")
	}

	def transferPipelines( request: TransferPipelineWrapper) :Option[APIResponse[TransferPipelineActionHandler]]	={
		var handlerInstance :CommonAPIHandler = new CommonAPIHandler()
		var apiPath :String = new String()
		apiPath = apiPath.concat("/crm/v8/settings/pipeline/actions/transfer")
		handlerInstance.setAPIPath(apiPath)
		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST)
		handlerInstance.setCategoryMethod("ACTION")
		handlerInstance.setContentType("application/json")
		handlerInstance.setRequest(request)
		handlerInstance.addParam(new Param[Long]("layout_id", "com.zoho.crm.api.Pipeline.TransferPipelinesParam"),  this.layoutId)
		return handlerInstance.apiCall(classOf[TransferPipelineActionHandler], "application/json")
	}}
 object PipelineOperations{
class GetPipelinesParam		{
	}


class CreatePipelineParam		{
	}


class UpdatePipelinesParam		{
	}


class GetPipelineParam		{
	}


class UpdatePipelineParam		{
	}


class DeletePipelineParam		{
	}


class TransferPipelinesParam		{
	}
}
