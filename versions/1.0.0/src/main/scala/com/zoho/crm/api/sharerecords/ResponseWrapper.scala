package com.zoho.crm.api.sharerecords

import com.zoho.crm.api.users.Users
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var share:ArrayBuffer[ShareRecord] = _
	private var shareableUser:ArrayBuffer[Users] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShare() :ArrayBuffer[ShareRecord]	={
		return  this.share
	}

	def setShare( share: ArrayBuffer[ShareRecord]) 	={
		 this.share = share
		 this.keyModified("share") = 1
	}

	def getShareableUser() :ArrayBuffer[Users]	={
		return  this.shareableUser
	}

	def setShareableUser( shareableUser: ArrayBuffer[Users]) 	={
		 this.shareableUser = shareableUser
		 this.keyModified("shareable_user") = 1
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