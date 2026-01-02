package com.zoho.crm.api.users

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AssociatedGroupsWrapper extends Model with ResponseHandler	{
	private var userGroups:ArrayBuffer[AssociatedGroup] = _
	private var info:Option[Info] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUserGroups() :ArrayBuffer[AssociatedGroup]	={
		return  this.userGroups
	}

	def setUserGroups( userGroups: ArrayBuffer[AssociatedGroup]) 	={
		 this.userGroups = userGroups
		 this.keyModified("user_groups") = 1
	}

	def getInfo() :Option[Info]	={
		return  this.info
	}

	def setInfo( info: Option[Info]) 	={
		 this.info = info
		 this.keyModified("info") = 1
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