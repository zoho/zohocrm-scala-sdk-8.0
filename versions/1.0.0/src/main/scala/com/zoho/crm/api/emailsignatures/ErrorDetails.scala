package com.zoho.crm.api.emailsignatures

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ErrorDetails extends Model	{
	private var apiName:Option[String] = None
	private var jsonPath:Option[String] = None
	private var supportedValues:ArrayBuffer[Any] = _
	private var range:Option[RangeStructure] = None
	private var paramName:Option[String] = None
	private var regex:Option[String] = None
	private var expectedDataType:Option[String] = None
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

	def getSupportedValues() :ArrayBuffer[Any]	={
		return  this.supportedValues
	}

	def setSupportedValues( supportedValues: ArrayBuffer[Any]) 	={
		 this.supportedValues = supportedValues
		 this.keyModified("supported_values") = 1
	}

	def getRange() :Option[RangeStructure]	={
		return  this.range
	}

	def setRange( range: Option[RangeStructure]) 	={
		 this.range = range
		 this.keyModified("range") = 1
	}

	def getParamName() :Option[String]	={
		return  this.paramName
	}

	def setParamName( paramName: Option[String]) 	={
		 this.paramName = paramName
		 this.keyModified("param_name") = 1
	}

	def getRegex() :Option[String]	={
		return  this.regex
	}

	def setRegex( regex: Option[String]) 	={
		 this.regex = regex
		 this.keyModified("regex") = 1
	}

	def getExpectedDataType() :Option[String]	={
		return  this.expectedDataType
	}

	def setExpectedDataType( expectedDataType: Option[String]) 	={
		 this.expectedDataType = expectedDataType
		 this.keyModified("expected_data_type") = 1
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