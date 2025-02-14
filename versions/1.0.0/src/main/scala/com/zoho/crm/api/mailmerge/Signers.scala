package com.zoho.crm.api.mailmerge

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Signers extends Model	{
	private var recipientName:Option[String] = None
	private var actionType:Choice[String] = _
	private var recipient:Option[Address] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRecipientName() :Option[String]	={
		return  this.recipientName
	}

	def setRecipientName( recipientName: Option[String]) 	={
		 this.recipientName = recipientName
		 this.keyModified("recipient_name") = 1
	}

	def getActionType() :Choice[String]	={
		return  this.actionType
	}

	def setActionType( actionType: Choice[String]) 	={
		 this.actionType = actionType
		 this.keyModified("action_type") = 1
	}

	def getRecipient() :Option[Address]	={
		return  this.recipient
	}

	def setRecipient( recipient: Option[Address]) 	={
		 this.recipient = recipient
		 this.keyModified("recipient") = 1
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