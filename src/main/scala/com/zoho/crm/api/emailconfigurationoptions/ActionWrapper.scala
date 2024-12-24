package com.zoho.crm.api.emailconfigurationoptions

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var configurationOptions:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getConfigurationOptions() :ArrayBuffer[ActionResponse]	={
		return  this.configurationOptions
	}

	def setConfigurationOptions( configurationOptions: ArrayBuffer[ActionResponse]) 	={
		 this.configurationOptions = configurationOptions
		 this.keyModified("configuration_options") = 1
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