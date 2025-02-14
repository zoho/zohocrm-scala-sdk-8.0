package com.zoho.crm.api.findandmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var merge:ArrayBuffer[Merge] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMerge() :ArrayBuffer[Merge]	={
		return  this.merge
	}

	def setMerge( merge: ArrayBuffer[Merge]) 	={
		 this.merge = merge
		 this.keyModified("merge") = 1
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