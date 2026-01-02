package com.zoho.crm.api.org

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class APIException extends Model with ActionResponse with ResponseHandler with ActionHandler	{
	private var status:Choice[String] = _
	private var code:Choice[String] = _
	private var message:Choice[String] = _
	private var details:Option[HashMap[String, Any]] = _
	private var keyModified:HashMap[String, Int] = HashMap()
	private var apiName:Option[String] = None
	private var jsonPath:Option[String] = None
	private var features:ArrayBuffer[Feature] = _

	def getStatus() :Choice[String]	={
		return  this.status
	}

	def setStatus( status: Choice[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getCode() :Choice[String]	={
		return  this.code
	}

	def setCode( code: Choice[String]) 	={
		 this.code = code
		 this.keyModified("code") = 1
	}

	def getMessage() :Choice[String]	={
		return  this.message
	}

	def setMessage( message: Choice[String]) 	={
		 this.message = message
		 this.keyModified("message") = 1
	}

	def getDetails() :Option[HashMap[String, Any]]	={
		return  this.details
	}

	def setDetails( details: Option[HashMap[String, Any]]) 	={
		 this.details = details
		 this.keyModified("details") = 1
	}

	def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getJsonPath() :Option[String]	={
		return  this.jsonPath
	}

	def setJsonPath( jsonPath: Option[String]) 	={
		 this.jsonPath = jsonPath
		 this.keyModified("json_path") = 1
	}

	def getFeatures() :ArrayBuffer[Feature]	={
		return  this.features
	}

	def setFeatures( features: ArrayBuffer[Feature]) 	={
		 this.features = features
		 this.keyModified("features") = 1
	}}