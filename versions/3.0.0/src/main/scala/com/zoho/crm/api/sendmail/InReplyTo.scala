package com.zoho.crm.api.sendmail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class InReplyTo extends Model	{
	private var messageId:Option[String] = None
	private var owner:Option[Owner] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMessageId() :Option[String]	={
		return  this.messageId
	}

	def setMessageId( messageId: Option[String]) 	={
		 this.messageId = messageId
		 this.keyModified("message_id") = 1
	}

	def getOwner() :Option[Owner]	={
		return  this.owner
	}

	def setOwner( owner: Option[Owner]) 	={
		 this.owner = owner
		 this.keyModified("owner") = 1
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