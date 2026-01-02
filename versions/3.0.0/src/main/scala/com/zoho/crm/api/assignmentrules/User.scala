package com.zoho.crm.api.assignmentrules

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class User extends MinifiedUser with Model	{
	private var zuid:Option[Int] = None
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var email:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getZuid() :Option[Int]	={
		return  this.zuid
	}

	def setZuid( zuid: Option[Int]) 	={
		 this.zuid = zuid
		 this.keyModified("zuid") = 1
	}

	override def getName() :Option[String]	={
		return  this.name
	}

	override def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	override def getId() :Option[Long]	={
		return  this.id
	}

	override def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	override def getEmail() :Option[String]	={
		return  this.email
	}

	override def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
	}

	override def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	override def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}