package com.zoho.crm.api.userstransferdelete

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var transferAndDelete:ArrayBuffer[TransferAndDelete] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTransferAndDelete() :ArrayBuffer[TransferAndDelete]	={
		return  this.transferAndDelete
	}

	def setTransferAndDelete( transferAndDelete: ArrayBuffer[TransferAndDelete]) 	={
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