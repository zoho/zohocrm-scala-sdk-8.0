package com.zoho.crm.api.fromaddresses

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var fromAddresses:ArrayBuffer[Address] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFromAddresses() :ArrayBuffer[Address]	={
		return  this.fromAddresses
	}

	def setFromAddresses( fromAddresses: ArrayBuffer[Address]) 	={
		 this.fromAddresses = fromAddresses
		 this.keyModified("from_addresses") = 1
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