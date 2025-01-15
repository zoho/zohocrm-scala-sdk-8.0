package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ConnectedDetails extends Model	{
	private var module:Option[LinkingModule] = None
	private var field:Option[LookupField] = None
	private var layouts:ArrayBuffer[LookupLayout] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[LinkingModule]	={
		return  this.module
	}

	def setModule( module: Option[LinkingModule]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getField() :Option[LookupField]	={
		return  this.field
	}

	def setField( field: Option[LookupField]) 	={
		 this.field = field
		 this.keyModified("field") = 1
	}

	def getLayouts() :ArrayBuffer[LookupLayout]	={
		return  this.layouts
	}

	def setLayouts( layouts: ArrayBuffer[LookupLayout]) 	={
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