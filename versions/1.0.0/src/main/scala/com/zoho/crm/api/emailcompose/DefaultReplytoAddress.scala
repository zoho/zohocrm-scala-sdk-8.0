package com.zoho.crm.api.emailcompose

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DefaultReplytoAddress extends Model	{
	private var type1:Choice[String] = _
	private var userName:Option[String] = None
	private var email:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getUserName() :Option[String]	={
		return  this.userName
	}

	def setUserName( userName: Option[String]) 	={
		 this.userName = userName
		 this.keyModified("user_name") = 1
	}

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
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