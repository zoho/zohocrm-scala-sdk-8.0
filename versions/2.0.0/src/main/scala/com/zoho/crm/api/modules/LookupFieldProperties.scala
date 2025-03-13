package com.zoho.crm.api.modules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class LookupFieldProperties extends Model	{
	private var fields:ArrayBuffer[LookupField] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFields() :ArrayBuffer[LookupField]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[LookupField]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
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