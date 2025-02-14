package com.zoho.crm.api.associateemail

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AssociateEmail extends Model	{
	private var from:Option[From] = None
	private var to:ArrayBuffer[To] = _
	private var cc:ArrayBuffer[To] = _
	private var bcc:ArrayBuffer[To] = _
	private var attachments:ArrayBuffer[Attachments] = _
	private var content:Option[String] = None
	private var mailFormat:Choice[String] = _
	private var subject:Option[String] = None
	private var originalMessageId:Option[String] = None
	private var sent:Option[Boolean] = None
	private var dateTime:Option[OffsetDateTime] = None
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

	def getAttachments() :ArrayBuffer[Attachments]	={
		return  this.attachments
	}

	def setAttachments( attachments: ArrayBuffer[Attachments]) 	={
		 this.attachments = attachments
		 this.keyModified("attachments") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
	}

	def getMailFormat() :Choice[String]	={
		return  this.mailFormat
	}

	def setMailFormat( mailFormat: Choice[String]) 	={
		 this.mailFormat = mailFormat
		 this.keyModified("mail_format") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getOriginalMessageId() :Option[String]	={
		return  this.originalMessageId
	}

	def setOriginalMessageId( originalMessageId: Option[String]) 	={
		 this.originalMessageId = originalMessageId
		 this.keyModified("original_message_id") = 1
	}

	def getSent() :Option[Boolean]	={
		return  this.sent
	}

	def setSent( sent: Option[Boolean]) 	={
		 this.sent = sent
		 this.keyModified("sent") = 1
	}

	def getDateTime() :Option[OffsetDateTime]	={
		return  this.dateTime
	}

	def setDateTime( dateTime: Option[OffsetDateTime]) 	={
		 this.dateTime = dateTime
		 this.keyModified("date_time") = 1
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