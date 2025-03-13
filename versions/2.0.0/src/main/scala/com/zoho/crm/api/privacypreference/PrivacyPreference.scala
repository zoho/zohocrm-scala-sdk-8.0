package com.zoho.crm.api.privacypreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class PrivacyPreference extends Model	{
	private var preference:Option[Preference] = None
	private var config:Option[Config] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPreference() :Option[Preference]	={
		return  this.preference
	}

	def setPreference( preference: Option[Preference]) 	={
		 this.preference = preference
		 this.keyModified("preference") = 1
	}

	def getConfig() :Option[Config]	={
		return  this.config
	}

	def setConfig( config: Option[Config]) 	={
		 this.config = config
		 this.keyModified("config") = 1
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