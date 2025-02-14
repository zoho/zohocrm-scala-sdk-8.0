package com.zoho.crm.api.emailrelatedrecords

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Email extends Model	{
	private var attachments:ArrayBuffer[Attachments] = _
	private var threadId:Option[String] = None
	private var cc:ArrayBuffer[UserDetails] = _
	private var summary:Option[String] = None
	private var owner:Option[MinifiedUser] = None
	private var read:Option[Boolean] = None
	private var content:Option[String] = None
	private var sent:Option[Boolean] = None
	private var subject:Option[String] = None
	private var activityInfo:Any = None
	private var intent:Choice[String] = _
	private var sentimentInfo:Choice[String] = _
	private var messageId:Option[String] = None
	private var source:Option[String] = None
	private var linkedRecord:Option[LinkedRecord] = None
	private var sentTime:Option[String] = None
	private var emotion:Option[String] = None
	private var from:Option[UserDetails] = None
	private var to:ArrayBuffer[UserDetails] = _
	private var time:Option[OffsetDateTime] = None
	private var status:ArrayBuffer[Status] = _
	private var hasAttachment:Option[Boolean] = None
	private var hasThreadAttachment:Option[Boolean] = None
	private var editable:Option[Boolean] = None
	private var mailFormat:Option[String] = None
	private var replyTo:Option[UserDetails] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAttachments() :ArrayBuffer[Attachments]	={
		return  this.attachments
	}

	def setAttachments( attachments: ArrayBuffer[Attachments]) 	={
		 this.attachments = attachments
		 this.keyModified("attachments") = 1
	}

	def getThreadId() :Option[String]	={
		return  this.threadId
	}

	def setThreadId( threadId: Option[String]) 	={
		 this.threadId = threadId
		 this.keyModified("thread_id") = 1
	}

	def getCc() :ArrayBuffer[UserDetails]	={
		return  this.cc
	}

	def setCc( cc: ArrayBuffer[UserDetails]) 	={
		 this.cc = cc
		 this.keyModified("cc") = 1
	}

	def getSummary() :Option[String]	={
		return  this.summary
	}

	def setSummary( summary: Option[String]) 	={
		 this.summary = summary
		 this.keyModified("summary") = 1
	}

	def getOwner() :Option[MinifiedUser]	={
		return  this.owner
	}

	def setOwner( owner: Option[MinifiedUser]) 	={
		 this.owner = owner
		 this.keyModified("owner") = 1
	}

	def getRead() :Option[Boolean]	={
		return  this.read
	}

	def setRead( read: Option[Boolean]) 	={
		 this.read = read
		 this.keyModified("read") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
	}

	def getSent() :Option[Boolean]	={
		return  this.sent
	}

	def setSent( sent: Option[Boolean]) 	={
		 this.sent = sent
		 this.keyModified("sent") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getActivityInfo() :Any	={
		return  this.activityInfo
	}

	def setActivityInfo( activityInfo: Any) 	={
		 this.activityInfo = activityInfo
		 this.keyModified("activity_info") = 1
	}

	def getIntent() :Choice[String]	={
		return  this.intent
	}

	def setIntent( intent: Choice[String]) 	={
		 this.intent = intent
		 this.keyModified("intent") = 1
	}

	def getSentimentInfo() :Choice[String]	={
		return  this.sentimentInfo
	}

	def setSentimentInfo( sentimentInfo: Choice[String]) 	={
		 this.sentimentInfo = sentimentInfo
		 this.keyModified("sentiment_info") = 1
	}

	def getMessageId() :Option[String]	={
		return  this.messageId
	}

	def setMessageId( messageId: Option[String]) 	={
		 this.messageId = messageId
		 this.keyModified("message_id") = 1
	}

	def getSource() :Option[String]	={
		return  this.source
	}

	def setSource( source: Option[String]) 	={
		 this.source = source
		 this.keyModified("source") = 1
	}

	def getLinkedRecord() :Option[LinkedRecord]	={
		return  this.linkedRecord
	}

	def setLinkedRecord( linkedRecord: Option[LinkedRecord]) 	={
		 this.linkedRecord = linkedRecord
		 this.keyModified("linked_record") = 1
	}

	def getSentTime() :Option[String]	={
		return  this.sentTime
	}

	def setSentTime( sentTime: Option[String]) 	={
		 this.sentTime = sentTime
		 this.keyModified("sent_time") = 1
	}

	def getEmotion() :Option[String]	={
		return  this.emotion
	}

	def setEmotion( emotion: Option[String]) 	={
		 this.emotion = emotion
		 this.keyModified("emotion") = 1
	}

	def getFrom() :Option[UserDetails]	={
		return  this.from
	}

	def setFrom( from: Option[UserDetails]) 	={
		 this.from = from
		 this.keyModified("from") = 1
	}

	def getTo() :ArrayBuffer[UserDetails]	={
		return  this.to
	}

	def setTo( to: ArrayBuffer[UserDetails]) 	={
		 this.to = to
		 this.keyModified("to") = 1
	}

	def getTime() :Option[OffsetDateTime]	={
		return  this.time
	}

	def setTime( time: Option[OffsetDateTime]) 	={
		 this.time = time
		 this.keyModified("time") = 1
	}

	def getStatus() :ArrayBuffer[Status]	={
		return  this.status
	}

	def setStatus( status: ArrayBuffer[Status]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getHasAttachment() :Option[Boolean]	={
		return  this.hasAttachment
	}

	def setHasAttachment( hasAttachment: Option[Boolean]) 	={
		 this.hasAttachment = hasAttachment
		 this.keyModified("has_attachment") = 1
	}

	def getHasThreadAttachment() :Option[Boolean]	={
		return  this.hasThreadAttachment
	}

	def setHasThreadAttachment( hasThreadAttachment: Option[Boolean]) 	={
		 this.hasThreadAttachment = hasThreadAttachment
		 this.keyModified("has_thread_attachment") = 1
	}

	def getEditable() :Option[Boolean]	={
		return  this.editable
	}

	def setEditable( editable: Option[Boolean]) 	={
		 this.editable = editable
		 this.keyModified("editable") = 1
	}

	def getMailFormat() :Option[String]	={
		return  this.mailFormat
	}

	def setMailFormat( mailFormat: Option[String]) 	={
		 this.mailFormat = mailFormat
		 this.keyModified("mail_format") = 1
	}

	def getReplyTo() :Option[UserDetails]	={
		return  this.replyTo
	}

	def setReplyTo( replyTo: Option[UserDetails]) 	={
		 this.replyTo = replyTo
		 this.keyModified("reply_to") = 1
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