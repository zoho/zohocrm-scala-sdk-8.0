package com.zoho.crm.api.recyclebin

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var recycleBin:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRecycleBin() :ArrayBuffer[ActionResponse]	={
		return  this.recycleBin
	}

	def setRecycleBin( recycleBin: ArrayBuffer[ActionResponse]) 	={
		 this.recycleBin = recycleBin
		 this.keyModified("recycle_bin") = 1
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