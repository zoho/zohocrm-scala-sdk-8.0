package com.zoho.crm.api.datasharing

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var dataSharing:ArrayBuffer[DataSharing] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDataSharing() :ArrayBuffer[DataSharing]	={
		return  this.dataSharing
	}

	def setDataSharing( dataSharing: ArrayBuffer[DataSharing]) 	={
		 this.dataSharing = dataSharing
		 this.keyModified("data_sharing") = 1
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