package com.zoho.crm.api.modules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var modules:ArrayBuffer[Modules] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModules() :ArrayBuffer[Modules]	={
		return  this.modules
	}

	def setModules( modules: ArrayBuffer[Modules]) 	={
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