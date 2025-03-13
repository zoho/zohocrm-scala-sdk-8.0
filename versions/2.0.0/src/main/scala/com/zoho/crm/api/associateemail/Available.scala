package com.zoho.crm.api.associateemail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Available extends Model	{
	private var available:Option[Boolean] = None
	private var record:Option[Record] = None
	private var linkedRecord:Option[LinkedRecord] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAvailable() :Option[Boolean]	={
		return  this.available
	}

	def setAvailable( available: Option[Boolean]) 	={
		 this.available = available
		 this.keyModified("available") = 1
	}

	def getRecord() :Option[Record]	={
		return  this.record
	}

	def setRecord( record: Option[Record]) 	={
		 this.record = record
		 this.keyModified("record") = 1
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