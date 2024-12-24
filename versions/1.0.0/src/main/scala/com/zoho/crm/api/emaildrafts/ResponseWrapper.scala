package com.zoho.crm.api.emaildrafts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model	{
	private var emaildrafts:ArrayBuffer[EmailDrafts] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmaildrafts() :ArrayBuffer[EmailDrafts]	={
		return  this.emaildrafts
	}

	def setEmaildrafts( emaildrafts: ArrayBuffer[EmailDrafts]) 	={
		 this.emaildrafts = emaildrafts
		 this.keyModified("__email_drafts") = 1
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