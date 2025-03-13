package com.zoho.crm.api.portalinvite

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model	{
	private var portalInvite:ArrayBuffer[JobResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPortalInvite() :ArrayBuffer[JobResponse]	={
		return  this.portalInvite
	}

	def setPortalInvite( portalInvite: ArrayBuffer[JobResponse]) 	={
		 this.portalInvite = portalInvite
		 this.keyModified("portal_invite") = 1
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