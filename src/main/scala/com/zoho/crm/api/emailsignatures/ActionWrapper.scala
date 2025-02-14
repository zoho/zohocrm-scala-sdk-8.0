package com.zoho.crm.api.emailsignatures

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var emailSignatures:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailSignatures() :ArrayBuffer[ActionResponse]	={
		return  this.emailSignatures
	}

	def setEmailSignatures( emailSignatures: ArrayBuffer[ActionResponse]) 	={
		 this.emailSignatures = emailSignatures
		 this.keyModified("email_signatures") = 1
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