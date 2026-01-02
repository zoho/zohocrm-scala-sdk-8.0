package com.zoho.crm.api.servicepreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionWrapper extends Model with ActionHandler	{
	private var servicePreferences:Option[ActionResponse] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getServicePreferences() :Option[ActionResponse]	={
		return  this.servicePreferences
	}

	def setServicePreferences( servicePreferences: Option[ActionResponse]) 	={
		 this.servicePreferences = servicePreferences
		 this.keyModified("service_preferences") = 1
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