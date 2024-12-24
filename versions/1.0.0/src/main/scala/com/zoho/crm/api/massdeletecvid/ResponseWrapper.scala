package com.zoho.crm.api.massdeletecvid

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var data:ArrayBuffer[Status] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getData() :ArrayBuffer[Status]	={
		return  this.data
	}

	def setData( data: ArrayBuffer[Status]) 	={
		 this.data = data
		 this.keyModified("data") = 1
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