package com.zoho.crm.api.sendmail

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Data extends Model	{
	private var from:Option[From] = None
	private var to:ArrayBuffer[To] = _
	private var cc:ArrayBuffer[Cc] = _
	private var bcc:ArrayBuffer[Cc] = _
	private var replyTo:Option[To] = None
	private var orgEmail:Option[Boolean] = None
	private var scheduledTime:Option[OffsetDateTime] = None
	private var mailFormat:Choice[String] = _
	private var consentEmail:Option[Boolean] = None
	private var content:Option[String] = None
	private var subject:Option[String] = None
	private var inReplyTo:Option[InReplyTo] = None
	private var template:Option[Template] = None
	private var inventoryDetails:Option[InventoryDetails] = None
	private var dataSubjectRequest:Option[DataSubjectRequest] = None
	private var attachments:ArrayBuffer[Attachment] = _
	private var linkedRecord:Option[LinkedRecord] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFrom() :Option[From]	={
		return  this.from
	}

	def setFrom( from: Option[From]) 	={
		 this.from = from
		 this.keyModified("from") = 1
	}

	def getTo() :ArrayBuffer[To]	={
		return  this.to
	}

	def setTo( to: ArrayBuffer[To]) 	={
		 this.to = to
		 this.keyModified("to") = 1
	}

	def getCc() :ArrayBuffer[Cc]	={
		return  this.cc
	}

	def setCc( cc: ArrayBuffer[Cc]) 	={
		 this.cc = cc
		 this.keyModified("cc") = 1
	}

	def getBcc() :ArrayBuffer[Cc]	={
		return  this.bcc
	}

	def setBcc( bcc: ArrayBuffer[Cc]) 	={
		 this.bcc = bcc
		 this.keyModified("bcc") = 1
	}

	def getReplyTo() :Option[To]	={
		return  this.replyTo
	}

	def setReplyTo( replyTo: Option[To]) 	={
		 this.replyTo = replyTo
		 this.keyModified("reply_to") = 1
	}

	def getOrgEmail() :Option[Boolean]	={
		return  this.orgEmail
	}

	def setOrgEmail( orgEmail: Option[Boolean]) 	={
		 this.orgEmail = orgEmail
		 this.keyModified("org_email") = 1
	}

	def getScheduledTime() :Option[OffsetDateTime]	={
		return  this.scheduledTime
	}

	def setScheduledTime( scheduledTime: Option[OffsetDateTime]) 	={
		 this.scheduledTime = scheduledTime
		 this.keyModified("scheduled_time") = 1
	}

	def getMailFormat() :Choice[String]	={
		return  this.mailFormat
	}

	def setMailFormat( mailFormat: Choice[String]) 	={
		 this.mailFormat = mailFormat
		 this.keyModified("mail_format") = 1
	}

	def getConsentEmail() :Option[Boolean]	={
		return  this.consentEmail
	}

	def setConsentEmail( consentEmail: Option[Boolean]) 	={
		 this.consentEmail = consentEmail
		 this.keyModified("consent_email") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getInReplyTo() :Option[InReplyTo]	={
		return  this.inReplyTo
	}

	def setInReplyTo( inReplyTo: Option[InReplyTo]) 	={
		 this.inReplyTo = inReplyTo
		 this.keyModified("in_reply_to") = 1
	}

	def getTemplate() :Option[Template]	={
		return  this.template
	}

	def setTemplate( template: Option[Template]) 	={
		 this.template = template
		 this.keyModified("template") = 1
	}

	def getInventoryDetails() :Option[InventoryDetails]	={
		return  this.inventoryDetails
	}

	def setInventoryDetails( inventoryDetails: Option[InventoryDetails]) 	={
		 this.inventoryDetails = inventoryDetails
		 this.keyModified("inventory_details") = 1
	}

	def getDataSubjectRequest() :Option[DataSubjectRequest]	={
		return  this.dataSubjectRequest
	}

	def setDataSubjectRequest( dataSubjectRequest: Option[DataSubjectRequest]) 	={
		 this.dataSubjectRequest = dataSubjectRequest
		 this.keyModified("data_subject_request") = 1
	}

	def getAttachments() :ArrayBuffer[Attachment]	={
		return  this.attachments
	}

	def setAttachments( attachments: ArrayBuffer[Attachment]) 	={
		 this.attachments = attachments
		 this.keyModified("attachments") = 1
	}

	def getLinkedRecord() :Option[LinkedRecord]	={
		return  this.linkedRecord
	}

	def setLinkedRecord( linkedRecord: Option[LinkedRecord]) 	={
		 this.linkedRecord = linkedRecord
		 this.keyModified("linked_record") = 1
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