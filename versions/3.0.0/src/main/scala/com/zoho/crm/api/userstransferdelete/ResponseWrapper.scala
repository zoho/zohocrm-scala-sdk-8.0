package com.zoho.crm.api.userstransferdelete

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var transferAndDelete:ArrayBuffer[Status] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTransferAndDelete() :ArrayBuffer[Status]	={
		return  this.transferAndDelete
	}

	def setTransferAndDelete( transferAndDelete: ArrayBuffer[Status]) 	={
		 this.transferAndDelete = transferAndDelete
		 this.keyModified("transfer_and_delete") = 1
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