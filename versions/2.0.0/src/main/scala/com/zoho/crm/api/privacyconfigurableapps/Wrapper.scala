package com.zoho.crm.api.privacyconfigurableapps

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Wrapper extends Model	{
	private var privacyConfigurableApps:ArrayBuffer[Apps] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPrivacyConfigurableApps() :ArrayBuffer[Apps]	={
		return  this.privacyConfigurableApps
	}

	def setPrivacyConfigurableApps( privacyConfigurableApps: ArrayBuffer[Apps]) 	={
		 this.privacyConfigurableApps = privacyConfigurableApps
		 this.keyModified("privacy_configurable_apps") = 1
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