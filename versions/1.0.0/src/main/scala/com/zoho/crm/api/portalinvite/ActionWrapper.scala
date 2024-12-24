package com.zoho.crm.api.portalinvite

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var portalInvite:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPortalInvite() :ArrayBuffer[ActionResponse]	={
		return  this.portalInvite
	}

	def setPortalInvite( portalInvite: ArrayBuffer[ActionResponse]) 	={
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