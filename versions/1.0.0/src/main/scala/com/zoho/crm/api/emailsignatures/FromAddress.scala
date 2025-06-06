package com.zoho.crm.api.emailsignatures

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FromAddress extends Model	{
	private var email:Option[String] = None
	private var userName:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
	}

	def getUserName() :Option[String]	={
		return  this.userName
	}

	def setUserName( userName: Option[String]) 	={
		 this.userName = userName
		 this.keyModified("user_name") = 1
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