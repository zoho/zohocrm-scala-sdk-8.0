package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DoubleOptinDetails extends Model	{
	private var emailTemplate:Option[DoubleOptinEmailTemplate] = None
	private var confirmPageContent:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailTemplate() :Option[DoubleOptinEmailTemplate]	={
		return  this.emailTemplate
	}

	def setEmailTemplate( emailTemplate: Option[DoubleOptinEmailTemplate]) 	={
		 this.emailTemplate = emailTemplate
		 this.keyModified("email_template") = 1
	}

	def getConfirmPageContent() :Option[String]	={
		return  this.confirmPageContent
	}

	def setConfirmPageContent( confirmPageContent: Option[String]) 	={
		 this.confirmPageContent = confirmPageContent
		 this.keyModified("confirm_page_content") = 1
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