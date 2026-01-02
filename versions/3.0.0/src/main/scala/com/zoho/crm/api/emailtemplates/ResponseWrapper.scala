package com.zoho.crm.api.emailtemplates

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var emailTemplates:ArrayBuffer[EmailTemplate] = _
	private var info:Option[Info] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailTemplates() :ArrayBuffer[EmailTemplate]	={
		return  this.emailTemplates
	}

	def setEmailTemplates( emailTemplates: ArrayBuffer[EmailTemplate]) 	={
		 this.emailTemplates = emailTemplates
		 this.keyModified("email_templates") = 1
	}

	def getInfo() :Option[Info]	={
		return  this.info
	}

	def setInfo( info: Option[Info]) 	={
		 this.info = info
		 this.keyModified("info") = 1
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