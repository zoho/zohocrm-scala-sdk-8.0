package com.zoho.crm.api.portals

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var portals:ArrayBuffer[Portals] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPortals() :ArrayBuffer[Portals]	={
		return  this.portals
	}

	def setPortals( portals: ArrayBuffer[Portals]) 	={
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