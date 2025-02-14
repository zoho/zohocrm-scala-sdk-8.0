package com.zoho.crm.api.unblockemail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var ids:ArrayBuffer[String] = _
	private var unblockFields:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getIds() :ArrayBuffer[String]	={
		return  this.ids
	}

	def setIds( ids: ArrayBuffer[String]) 	={
		 this.ids = ids
		 this.keyModified("ids") = 1
	}

	def getUnblockFields() :ArrayBuffer[String]	={
		return  this.unblockFields
	}

	def setUnblockFields( unblockFields: ArrayBuffer[String]) 	={
		 this.unblockFields = unblockFields
		 this.keyModified("unblock_fields") = 1
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