package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Association extends Model	{
	private var field:Option[Field] = None
	private var module:Option[Module] = None
	private var layouts:ArrayBuffer[Layout] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getField() :Option[Field]	={
		return  this.field
	}

	def setField( field: Option[Field]) 	={
		 this.field = field
		 this.keyModified("field") = 1
	}

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getLayouts() :ArrayBuffer[Layout]	={
		return  this.layouts
	}

	def setLayouts( layouts: ArrayBuffer[Layout]) 	={
		 this.layouts = layouts
		 this.keyModified("layouts") = 1
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