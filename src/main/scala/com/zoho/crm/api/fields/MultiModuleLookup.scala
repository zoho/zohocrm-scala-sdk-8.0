package com.zoho.crm.api.fields

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MultiModuleLookup extends Model	{
	private var displayLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var modules:ArrayBuffer[MinifiedModule] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getModules() :ArrayBuffer[MinifiedModule]	={
		return  this.modules
	}

	def setModules( modules: ArrayBuffer[MinifiedModule]) 	={
		 this.modules = modules
		 this.keyModified("modules") = 1
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