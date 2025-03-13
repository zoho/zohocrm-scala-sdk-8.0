package com.zoho.crm.api.definition

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Definition extends Model	{
	private var rootElementName:Option[String] = None
	private var extradetails:Option[HashMap[String, Any]] = _
	private var properties:ArrayBuffer[Property] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRootElementName() :Option[String]	={
		return  this.rootElementName
	}

	def setRootElementName( rootElementName: Option[String]) 	={
		 this.rootElementName = rootElementName
		 this.keyModified("root_element_name") = 1
	}

	def getExtradetails() :Option[HashMap[String, Any]]	={
		return  this.extradetails
	}

	def setExtradetails( extradetails: Option[HashMap[String, Any]]) 	={
		 this.extradetails = extradetails
		 this.keyModified("extraDetails") = 1
	}

	def getProperties() :ArrayBuffer[Property]	={
		return  this.properties
	}

	def setProperties( properties: ArrayBuffer[Property]) 	={
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