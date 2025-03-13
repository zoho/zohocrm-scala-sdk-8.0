package com.zoho.crm.api.emailsharingdetails

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class EmailSharings extends Model	{
	private var shareFromUsers:ArrayBuffer[ShareFromUser] = _
	private var availableTypes:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShareFromUsers() :ArrayBuffer[ShareFromUser]	={
		return  this.shareFromUsers
	}

	def setShareFromUsers( shareFromUsers: ArrayBuffer[ShareFromUser]) 	={
		 this.shareFromUsers = shareFromUsers
		 this.keyModified("share_from_users") = 1
	}

	def getAvailableTypes() :ArrayBuffer[String]	={
		return  this.availableTypes
	}

	def setAvailableTypes( availableTypes: ArrayBuffer[String]) 	={
		 this.availableTypes = availableTypes
		 this.keyModified("available_types") = 1
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