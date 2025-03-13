package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var sharingRules:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSharingRules() :ArrayBuffer[ActionResponse]	={
		return  this.sharingRules
	}

	def setSharingRules( sharingRules: ArrayBuffer[ActionResponse]) 	={
		 this.sharingRules = sharingRules
		 this.keyModified("sharing_rules") = 1
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