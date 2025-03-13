package com.zoho.crm.api.emailconfigurationoptions

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ErrorDetails extends Model	{
	private var apiName:Option[String] = None
	private var jsonPath:Option[String] = None
	private var range:Option[RangeStructure] = None
	private var supportedValues:ArrayBuffer[Any] = _
	private var keyModified:HashMap[String, Int] = HashMap()

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

	def getRange() :Option[RangeStructure]	={
		return  this.range
	}

	def setRange( range: Option[RangeStructure]) 	={
		 this.range = range
		 this.keyModified("range") = 1
	}

	def getSupportedValues() :ArrayBuffer[Any]	={
		return  this.supportedValues
	}

	def setSupportedValues( supportedValues: ArrayBuffer[Any]) 	={
		 this.supportedValues = supportedValues
		 this.keyModified("supported_values") = 1
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
	}}