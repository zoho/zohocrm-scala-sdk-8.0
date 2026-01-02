package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class EnrichBasedOn extends Model	{
	private var social:Option[Social] = None
	private var name:Option[String] = None
	private var company:Option[Company] = None
	private var email:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSocial() :Option[Social]	={
		return  this.social
	}

	def setSocial( social: Option[Social]) 	={
		 this.social = social
		 this.keyModified("social") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getCompany() :Option[Company]	={
		return  this.company
	}

	def setCompany( company: Option[Company]) 	={
		 this.company = company
		 this.keyModified("company") = 1
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