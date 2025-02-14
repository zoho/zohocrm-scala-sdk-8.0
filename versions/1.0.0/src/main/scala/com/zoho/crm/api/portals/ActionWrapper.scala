package com.zoho.crm.api.portals

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var portals:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPortals() :ArrayBuffer[ActionResponse]	={
		return  this.portals
	}

	def setPortals( portals: ArrayBuffer[ActionResponse]) 	={
		 this.portals = portals
		 this.keyModified("portals") = 1
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