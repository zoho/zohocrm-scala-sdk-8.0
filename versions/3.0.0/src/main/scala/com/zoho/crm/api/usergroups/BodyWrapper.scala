package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var userGroups:ArrayBuffer[Groups] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUserGroups() :ArrayBuffer[Groups]	={
		return  this.userGroups
	}

	def setUserGroups( userGroups: ArrayBuffer[Groups]) 	={
		 this.userGroups = userGroups
		 this.keyModified("user_groups") = 1
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