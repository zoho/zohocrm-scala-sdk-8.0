package com.zoho.crm.api.users

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Owner extends Model	{
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var lastName:Option[String] = None
	private var firstName:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getLastName() :Option[String]	={
		return  this.lastName
	}

	def setLastName( lastName: Option[String]) 	={
		 this.lastName = lastName
		 this.keyModified("last_name") = 1
	}

	def getFirstName() :Option[String]	={
		return  this.firstName
	}

	def setFirstName( firstName: Option[String]) 	={
		 this.firstName = firstName
		 this.keyModified("first_name") = 1
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