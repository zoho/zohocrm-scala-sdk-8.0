package com.zoho.crm.api.massconvert

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ErrorDetails extends Model	{
	private var apiName:Option[String] = None
	private var jsonPath:Option[String] = None
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