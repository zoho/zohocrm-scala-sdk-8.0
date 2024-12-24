package com.zoho.crm.api.callpreferences

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionWrapper extends Model with ActionHandler	{
	private var callPreferences:Option[ActionResponse] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCallPreferences() :Option[ActionResponse]	={
		return  this.callPreferences
	}

	def setCallPreferences( callPreferences: Option[ActionResponse]) 	={
		 this.callPreferences = callPreferences
		 this.keyModified("call_preferences") = 1
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