package com.zoho.crm.api.emaildrafts

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class EmailDrafts extends Model	{
	private var id:Option[String] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var from:Option[String] = None
	private var to:ArrayBuffer[To] = _
	private var replyTo:Option[String] = None
	private var cc:ArrayBuffer[To] = _
	private var bcc:ArrayBuffer[To] = _
	private var template:Option[Template] = None
	private var inventoryDetails:Option[InventoryDetails] = None
	private var attachments:ArrayBuffer[Attachments] = _
	private var scheduleDetails:Option[ScheduleDetails] = None
	private var richText:Option[Boolean] = None
	private var emailOptOut:Option[Boolean] = None
	private var subject:Option[String] = None
	private var content:Option[String] = None
	private var summary:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getFrom() :Option[String]	={
		return  this.from
	}

	def setFrom( from: Option[String]) 	={
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

	def getReplyTo() :Option[String]	={
		return  this.replyTo
	}

	def setReplyTo( replyTo: Option[String]) 	={
		 this.replyTo = replyTo
		 this.keyModified("reply_to") = 1
	}

	def getCc() :ArrayBuffer[To]	={
		return  this.cc
	}

	def setCc( cc: ArrayBuffer[To]) 	={
		 this.cc = cc
		 this.keyModified("cc") = 1
	}

	def getBcc() :ArrayBuffer[To]	={
		return  this.bcc
	}

	def setBcc( bcc: ArrayBuffer[To]) 	={
		 this.bcc = bcc
		 this.keyModified("bcc") = 1
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

	def getAttachments() :ArrayBuffer[Attachments]	={
		return  this.attachments
	}

	def setAttachments( attachments: ArrayBuffer[Attachments]) 	={
		 this.attachments = attachments
		 this.keyModified("attachments") = 1
	}

	def getScheduleDetails() :Option[ScheduleDetails]	={
		return  this.scheduleDetails
	}

	def setScheduleDetails( scheduleDetails: Option[ScheduleDetails]) 	={
		 this.scheduleDetails = scheduleDetails
		 this.keyModified("schedule_details") = 1
	}

	def getRichText() :Option[Boolean]	={
		return  this.richText
	}

	def setRichText( richText: Option[Boolean]) 	={
		 this.richText = richText
		 this.keyModified("rich_text") = 1
	}

	def getEmailOptOut() :Option[Boolean]	={
		return  this.emailOptOut
	}

	def setEmailOptOut( emailOptOut: Option[Boolean]) 	={
		 this.emailOptOut = emailOptOut
		 this.keyModified("email_opt_out") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
	}

	def getSummary() :Option[String]	={
		return  this.summary
	}

	def setSummary( summary: Option[String]) 	={
		 this.summary = summary
		 this.keyModified("summary") = 1
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