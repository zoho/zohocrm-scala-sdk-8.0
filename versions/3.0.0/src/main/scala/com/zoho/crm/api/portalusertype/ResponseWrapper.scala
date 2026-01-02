package com.zoho.crm.api.portalusertype

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var userType:ArrayBuffer[UserType] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUserType() :ArrayBuffer[UserType]	={
		return  this.userType
	}

	def setUserType( userType: ArrayBuffer[UserType]) 	={
		 this.userType = userType
		 this.keyModified("user_type") = 1
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