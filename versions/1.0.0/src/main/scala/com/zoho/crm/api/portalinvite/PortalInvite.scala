package com.zoho.crm.api.portalinvite

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PortalInvite extends Model	{
	private var data:ArrayBuffer[Portal] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getData() :ArrayBuffer[Portal]	={
		return  this.data
	}

	def setData( data: ArrayBuffer[Portal]) 	={
		 this.data = data
		 this.keyModified("data") = 1
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