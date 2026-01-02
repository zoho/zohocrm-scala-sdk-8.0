package com.zoho.crm.api.emailcompose

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var emailCompose:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailCompose() :ArrayBuffer[ActionResponse]	={
		return  this.emailCompose
	}

	def setEmailCompose( emailCompose: ArrayBuffer[ActionResponse]) 	={
		 this.emailCompose = emailCompose
		 this.keyModified("email_compose") = 1
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