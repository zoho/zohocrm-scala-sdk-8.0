package com.zoho.crm.api.templates

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Wrapper extends Model	{
	private var templates:ArrayBuffer[Templates] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTemplates() :ArrayBuffer[Templates]	={
		return  this.templates
	}

	def setTemplates( templates: ArrayBuffer[Templates]) 	={
		 this.templates = templates
		 this.keyModified("templates") = 1
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