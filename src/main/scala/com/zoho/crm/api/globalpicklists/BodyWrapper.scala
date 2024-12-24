package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var globalPicklists:ArrayBuffer[Picklist] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getGlobalPicklists() :ArrayBuffer[Picklist]	={
		return  this.globalPicklists
	}

	def setGlobalPicklists( globalPicklists: ArrayBuffer[Picklist]) 	={
		 this.globalPicklists = globalPicklists
		 this.keyModified("global_picklists") = 1
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