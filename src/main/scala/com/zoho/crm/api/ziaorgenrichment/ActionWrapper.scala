package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var ziaorgenrichment:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getZiaorgenrichment() :ArrayBuffer[ActionResponse]	={
		return  this.ziaorgenrichment
	}

	def setZiaorgenrichment( ziaorgenrichment: ArrayBuffer[ActionResponse]) 	={
		 this.ziaorgenrichment = ziaorgenrichment
		 this.keyModified("__zia_org_enrichment") = 1
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