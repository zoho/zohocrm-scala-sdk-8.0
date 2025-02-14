package com.zoho.crm.api.mailmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MailMerge extends Model	{
	private var mailMergeTemplate:Option[MailMergeTemplate] = None
	private var fromAddress:Option[Address] = None
	private var toAddress:ArrayBuffer[Address] = _
	private var ccEmail:ArrayBuffer[Address] = _
	private var bccEmail:ArrayBuffer[Address] = _
	private var subject:Option[String] = None
	private var message:Option[String] = None
	private var type1:Option[String] = None
	private var attachmentName:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMailMergeTemplate() :Option[MailMergeTemplate]	={
		return  this.mailMergeTemplate
	}

	def setMailMergeTemplate( mailMergeTemplate: Option[MailMergeTemplate]) 	={
		 this.mailMergeTemplate = mailMergeTemplate
		 this.keyModified("mail_merge_template") = 1
	}

	def getFromAddress() :Option[Address]	={
		return  this.fromAddress
	}

	def setFromAddress( fromAddress: Option[Address]) 	={
		 this.fromAddress = fromAddress
		 this.keyModified("from_address") = 1
	}

	def getToAddress() :ArrayBuffer[Address]	={
		return  this.toAddress
	}

	def setToAddress( toAddress: ArrayBuffer[Address]) 	={
		 this.toAddress = toAddress
		 this.keyModified("to_address") = 1
	}

	def getCcEmail() :ArrayBuffer[Address]	={
		return  this.ccEmail
	}

	def setCcEmail( ccEmail: ArrayBuffer[Address]) 	={
		 this.ccEmail = ccEmail
		 this.keyModified("cc_email") = 1
	}

	def getBccEmail() :ArrayBuffer[Address]	={
		return  this.bccEmail
	}

	def setBccEmail( bccEmail: ArrayBuffer[Address]) 	={
		 this.bccEmail = bccEmail
		 this.keyModified("bcc_email") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getMessage() :Option[String]	={
		return  this.message
	}

	def setMessage( message: Option[String]) 	={
		 this.message = message
		 this.keyModified("message") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getAttachmentName() :Option[String]	={
		return  this.attachmentName
	}

	def setAttachmentName( attachmentName: Option[String]) 	={
		 this.attachmentName = attachmentName
		 this.keyModified("attachment_name") = 1
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