package com.zoho.crm.api.contactroles

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var contactRoles:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getContactRoles() :ArrayBuffer[ActionResponse]	={
		return  this.contactRoles
	}

	def setContactRoles( contactRoles: ArrayBuffer[ActionResponse]) 	={
		 this.contactRoles = contactRoles
		 this.keyModified("contact_roles") = 1
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