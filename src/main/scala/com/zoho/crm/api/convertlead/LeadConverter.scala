package com.zoho.crm.api.convertlead

import com.zoho.crm.api.record.Record
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class LeadConverter extends Model	{
	private var overwrite:Option[Boolean] = None
	private var notifyLeadOwner:Option[Boolean] = None
	private var notifyNewEntityOwner:Option[Boolean] = None
	private var moveAttachmentsTo:Option[MoveAttachmentsTo] = None
	private var accounts:Option[Record] = None
	private var contacts:Option[Record] = None
	private var assignTo:Option[MinifiedUser] = None
	private var deals:Option[Record] = None
	private var addToExistingRecord:Choice[Boolean] = _
	private var carryOverTags:Option[CarryOverTags] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOverwrite() :Option[Boolean]	={
		return  this.overwrite
	}

	def setOverwrite( overwrite: Option[Boolean]) 	={
		 this.overwrite = overwrite
		 this.keyModified("overwrite") = 1
	}

	def getNotifyLeadOwner() :Option[Boolean]	={
		return  this.notifyLeadOwner
	}

	def setNotifyLeadOwner( notifyLeadOwner: Option[Boolean]) 	={
		 this.notifyLeadOwner = notifyLeadOwner
		 this.keyModified("notify_lead_owner") = 1
	}

	def getNotifyNewEntityOwner() :Option[Boolean]	={
		return  this.notifyNewEntityOwner
	}

	def setNotifyNewEntityOwner( notifyNewEntityOwner: Option[Boolean]) 	={
		 this.notifyNewEntityOwner = notifyNewEntityOwner
		 this.keyModified("notify_new_entity_owner") = 1
	}

	def getMoveAttachmentsTo() :Option[MoveAttachmentsTo]	={
		return  this.moveAttachmentsTo
	}

	def setMoveAttachmentsTo( moveAttachmentsTo: Option[MoveAttachmentsTo]) 	={
		 this.moveAttachmentsTo = moveAttachmentsTo
		 this.keyModified("move_attachments_to") = 1
	}

	def getAccounts() :Option[Record]	={
		return  this.accounts
	}

	def setAccounts( accounts: Option[Record]) 	={
		 this.accounts = accounts
		 this.keyModified("Accounts") = 1
	}

	def getContacts() :Option[Record]	={
		return  this.contacts
	}

	def setContacts( contacts: Option[Record]) 	={
		 this.contacts = contacts
		 this.keyModified("Contacts") = 1
	}

	def getAssignTo() :Option[MinifiedUser]	={
		return  this.assignTo
	}

	def setAssignTo( assignTo: Option[MinifiedUser]) 	={
		 this.assignTo = assignTo
		 this.keyModified("assign_to") = 1
	}

	def getDeals() :Option[Record]	={
		return  this.deals
	}

	def setDeals( deals: Option[Record]) 	={
		 this.deals = deals
		 this.keyModified("Deals") = 1
	}

	def getAddToExistingRecord() :Choice[Boolean]	={
		return  this.addToExistingRecord
	}

	def setAddToExistingRecord( addToExistingRecord: Choice[Boolean]) 	={
		 this.addToExistingRecord = addToExistingRecord
		 this.keyModified("add_to_existing_record") = 1
	}

	def getCarryOverTags() :Option[CarryOverTags]	={
		return  this.carryOverTags
	}

	def setCarryOverTags( carryOverTags: Option[CarryOverTags]) 	={
		 this.carryOverTags = carryOverTags
		 this.keyModified("carry_over_tags") = 1
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