package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AssociatedUserCount extends Model with ResponseHandler	{
	private var associatedUsersCount:ArrayBuffer[AssociatedUser] = _
	private var info:Option[Info] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAssociatedUsersCount() :ArrayBuffer[AssociatedUser]	={
		return  this.associatedUsersCount
	}

	def setAssociatedUsersCount( associatedUsersCount: ArrayBuffer[AssociatedUser]) 	={
		 this.associatedUsersCount = associatedUsersCount
		 this.keyModified("associated_users_count") = 1
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