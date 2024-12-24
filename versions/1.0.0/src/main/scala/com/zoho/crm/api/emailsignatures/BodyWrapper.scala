package com.zoho.crm.api.emailsignatures

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var emailSignatures:ArrayBuffer[EmailSignatures] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailSignatures() :ArrayBuffer[EmailSignatures]	={
		return  this.emailSignatures
	}

	def setEmailSignatures( emailSignatures: ArrayBuffer[EmailSignatures]) 	={
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