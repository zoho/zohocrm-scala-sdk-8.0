package com.zoho.crm.api.profiles

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var profiles:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getProfiles() :ArrayBuffer[ActionResponse]	={
		return  this.profiles
	}

	def setProfiles( profiles: ArrayBuffer[ActionResponse]) 	={
		 this.profiles = profiles
		 this.keyModified("profiles") = 1
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