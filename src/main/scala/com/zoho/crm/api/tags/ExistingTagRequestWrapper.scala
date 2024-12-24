package com.zoho.crm.api.tags

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ExistingTagRequestWrapper extends Model	{
	private var tags:ArrayBuffer[ExistingTag] = _
	private var ids:ArrayBuffer[Long] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTags() :ArrayBuffer[ExistingTag]	={
		return  this.tags
	}

	def setTags( tags: ArrayBuffer[ExistingTag]) 	={
		 this.tags = tags
		 this.keyModified("tags") = 1
	}

	def getIds() :ArrayBuffer[Long]	={
		return  this.ids
	}

	def setIds( ids: ArrayBuffer[Long]) 	={
		 this.ids = ids
		 this.keyModified("ids") = 1
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