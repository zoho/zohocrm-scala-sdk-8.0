package com.zoho.crm.api.emaildrafts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model	{
	private var emailDrafts:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailDrafts() :ArrayBuffer[ActionResponse]	={
		return  this.emailDrafts
	}

	def setEmailDrafts( emailDrafts: ArrayBuffer[ActionResponse]) 	={
		 this.emailDrafts = emailDrafts
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