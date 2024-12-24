package com.zoho.crm.api.customviews

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PinUnpinFields extends Model	{
	private var fields:ArrayBuffer[PinFields] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFields() :ArrayBuffer[PinFields]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[PinFields]) 	={
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