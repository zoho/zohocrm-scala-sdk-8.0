package com.zoho.crm.api.sendmail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class BlockedEmailAddress extends Model	{
	private var email:Option[String] = None
	private var reason:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
	}

	def getReason() :Option[String]	={
		return  this.reason
	}

	def setReason( reason: Option[String]) 	={
		 this.reason = reason
		 this.keyModified("reason") = 1
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