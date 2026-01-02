package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Owner extends Model	{
	private var name:Option[String] = None
	private var id:Option[String] = None
	private var systemMail:Option[Boolean] = None
	private var emailTemplate:Option[HashMap[String, Any]] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getSystemMail() :Option[Boolean]	={
		return  this.systemMail
	}

	def setSystemMail( systemMail: Option[Boolean]) 	={
		 this.systemMail = systemMail
		 this.keyModified("system_mail") = 1
	}

	def getEmailTemplate() :Option[HashMap[String, Any]]	={
		return  this.emailTemplate
	}

	def setEmailTemplate( emailTemplate: Option[HashMap[String, Any]]) 	={
		 this.emailTemplate = emailTemplate
		 this.keyModified("email_template") = 1
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