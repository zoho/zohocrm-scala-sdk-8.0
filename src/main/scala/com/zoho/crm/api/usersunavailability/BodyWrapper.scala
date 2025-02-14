package com.zoho.crm.api.usersunavailability

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var usersUnavailability:ArrayBuffer[UsersUnavailability] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUsersUnavailability() :ArrayBuffer[UsersUnavailability]	={
		return  this.usersUnavailability
	}

	def setUsersUnavailability( usersUnavailability: ArrayBuffer[UsersUnavailability]) 	={
		 this.usersUnavailability = usersUnavailability
		 this.keyModified("users_unavailability") = 1
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