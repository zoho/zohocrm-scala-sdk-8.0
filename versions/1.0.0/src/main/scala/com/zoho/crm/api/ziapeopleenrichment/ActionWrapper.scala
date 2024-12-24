package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var ziapeopleenrichment:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getZiapeopleenrichment() :ArrayBuffer[ActionResponse]	={
		return  this.ziapeopleenrichment
	}

	def setZiapeopleenrichment( ziapeopleenrichment: ArrayBuffer[ActionResponse]) 	={
		 this.ziapeopleenrichment = ziapeopleenrichment
		 this.keyModified("__zia_people_enrichment") = 1
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