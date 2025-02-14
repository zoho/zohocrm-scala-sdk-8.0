package com.zoho.crm.api.massdeletetags

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MassDelete extends Model	{
	private var module:Option[Module] = None
	private var tags:ArrayBuffer[Tag] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getTags() :ArrayBuffer[Tag]	={
		return  this.tags
	}

	def setTags( tags: ArrayBuffer[Tag]) 	={
		 this.tags = tags
		 this.keyModified("tags") = 1
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