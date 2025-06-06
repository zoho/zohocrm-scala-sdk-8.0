package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var sharingRules:ArrayBuffer[SharingRules] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSharingRules() :ArrayBuffer[SharingRules]	={
		return  this.sharingRules
	}

	def setSharingRules( sharingRules: ArrayBuffer[SharingRules]) 	={
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