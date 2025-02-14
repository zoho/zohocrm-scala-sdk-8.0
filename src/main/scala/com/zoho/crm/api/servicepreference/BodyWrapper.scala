package com.zoho.crm.api.servicepreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class BodyWrapper extends Model	{
	private var servicePreferences:Option[ServicePreference] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getServicePreferences() :Option[ServicePreference]	={
		return  this.servicePreferences
	}

	def setServicePreferences( servicePreferences: Option[ServicePreference]) 	={
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