package com.zoho.crm.api.digest

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var digest:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDigest() :ArrayBuffer[ActionResponse]	={
		return  this.digest
	}

	def setDigest( digest: ArrayBuffer[ActionResponse]) 	={
		 this.digest = digest
		 this.keyModified("__digest") = 1
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