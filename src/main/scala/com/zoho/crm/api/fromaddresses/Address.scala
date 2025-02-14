package com.zoho.crm.api.fromaddresses

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Address extends Model	{
	private var email:Option[String] = None
	private var type1:Option[String] = None
	private var id:Option[Long] = None
	private var userName:Option[String] = None
	private var default1:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getUserName() :Option[String]	={
		return  this.userName
	}

	def setUserName( userName: Option[String]) 	={
		 this.userName = userName
		 this.keyModified("user_name") = 1
	}

	def getDefault() :Option[Boolean]	={
		return  this.default1
	}

	def setDefault( default1: Option[Boolean]) 	={
		 this.default1 = default1
		 this.keyModified("default") = 1
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