package com.zoho.crm.api.privacypreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Wrapper extends Model	{
	private var privacypreference:ArrayBuffer[PrivacyPreference] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPrivacypreference() :ArrayBuffer[PrivacyPreference]	={
		return  this.privacypreference
	}

	def setPrivacypreference( privacypreference: ArrayBuffer[PrivacyPreference]) 	={
		 this.privacypreference = privacypreference
		 this.keyModified("privacyPreference") = 1
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