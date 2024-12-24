package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class EmailInfo extends Model	{
	private var type1:Option[String] = None
	private var email:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
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