package com.zoho.crm.api.emailconfigurationoptions

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PropertyDetails extends Model	{
	private var name:Option[String] = None
	private var values:ArrayBuffer[ValueDetails] = _
	private var dataType:Option[String] = None
	private var properties:ArrayBuffer[PropertyDetails] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getValues() :ArrayBuffer[ValueDetails]	={
		return  this.values
	}

	def setValues( values: ArrayBuffer[ValueDetails]) 	={
		 this.values = values
		 this.keyModified("values") = 1
	}

	def getDataType() :Option[String]	={
		return  this.dataType
	}

	def setDataType( dataType: Option[String]) 	={
		 this.dataType = dataType
		 this.keyModified("data_type") = 1
	}

	def getProperties() :ArrayBuffer[PropertyDetails]	={
		return  this.properties
	}

	def setProperties( properties: ArrayBuffer[PropertyDetails]) 	={
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