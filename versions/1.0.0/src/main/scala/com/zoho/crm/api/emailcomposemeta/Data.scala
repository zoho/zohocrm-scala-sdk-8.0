package com.zoho.crm.api.emailcomposemeta

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Data extends Model	{
	private var data:ArrayBuffer[DataMap] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getData() :ArrayBuffer[DataMap]	={
		return  this.data
	}

	def setData( data: ArrayBuffer[DataMap]) 	={
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