package com.zoho.crm.api.definition

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MinifiedProperty extends Model	{
	private var readOnly:Option[Boolean] = None
	private var apiName:Option[String] = None
	private var dataType:Option[String] = None
	private var length:Option[Int] = None
	private var required:Option[Boolean] = None
	private var properties:ArrayBuffer[MinifiedProperty] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getReadOnly() :Option[Boolean]	={
		return  this.readOnly
	}

	def setReadOnly( readOnly: Option[Boolean]) 	={
		 this.readOnly = readOnly
		 this.keyModified("read_only") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getDataType() :Option[String]	={
		return  this.dataType
	}

	def setDataType( dataType: Option[String]) 	={
		 this.dataType = dataType
		 this.keyModified("data_type") = 1
	}

	def getLength() :Option[Int]	={
		return  this.length
	}

	def setLength( length: Option[Int]) 	={
		 this.length = length
		 this.keyModified("length") = 1
	}

	def getRequired() :Option[Boolean]	={
		return  this.required
	}

	def setRequired( required: Option[Boolean]) 	={
		 this.required = required
		 this.keyModified("required") = 1
	}

	def getProperties() :ArrayBuffer[MinifiedProperty]	={
		return  this.properties
	}

	def setProperties( properties: ArrayBuffer[MinifiedProperty]) 	={
		 this.properties = properties
		 this.keyModified("properties") = 1
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