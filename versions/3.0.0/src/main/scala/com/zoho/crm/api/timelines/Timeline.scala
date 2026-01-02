package com.zoho.crm.api.timelines

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Timeline extends Model	{
	private var auditedTime:Option[OffsetDateTime] = None
	private var action:Option[String] = None
	private var id:Option[Long] = None
	private var source:Option[String] = None
	private var extension:Option[String] = None
	private var type1:Option[String] = None
	private var doneBy:Option[NameIdStructure] = None
	private var relatedRecord:Option[RelatedRecord] = None
	private var automationDetails:Option[AutomationDetail] = None
	private var record:Option[Record] = None
	private var fieldHistory:ArrayBuffer[FieldHistory] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAuditedTime() :Option[OffsetDateTime]	={
		return  this.auditedTime
	}

	def setAuditedTime( auditedTime: Option[OffsetDateTime]) 	={
		 this.auditedTime = auditedTime
		 this.keyModified("audited_time") = 1
	}

	def getAction() :Option[String]	={
		return  this.action
	}

	def setAction( action: Option[String]) 	={
		 this.action = action
		 this.keyModified("action") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getSource() :Option[String]	={
		return  this.source
	}

	def setSource( source: Option[String]) 	={
		 this.source = source
		 this.keyModified("source") = 1
	}

	def getExtension() :Option[String]	={
		return  this.extension
	}

	def setExtension( extension: Option[String]) 	={
		 this.extension = extension
		 this.keyModified("extension") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getDoneBy() :Option[NameIdStructure]	={
		return  this.doneBy
	}

	def setDoneBy( doneBy: Option[NameIdStructure]) 	={
		 this.doneBy = doneBy
		 this.keyModified("done_by") = 1
	}

	def getRelatedRecord() :Option[RelatedRecord]	={
		return  this.relatedRecord
	}

	def setRelatedRecord( relatedRecord: Option[RelatedRecord]) 	={
		 this.relatedRecord = relatedRecord
		 this.keyModified("related_record") = 1
	}

	def getAutomationDetails() :Option[AutomationDetail]	={
		return  this.automationDetails
	}

	def setAutomationDetails( automationDetails: Option[AutomationDetail]) 	={
		 this.automationDetails = automationDetails
		 this.keyModified("automation_details") = 1
	}

	def getRecord() :Option[Record]	={
		return  this.record
	}

	def setRecord( record: Option[Record]) 	={
		 this.record = record
		 this.keyModified("record") = 1
	}

	def getFieldHistory() :ArrayBuffer[FieldHistory]	={
		return  this.fieldHistory
	}

	def setFieldHistory( fieldHistory: ArrayBuffer[FieldHistory]) 	={
		 this.fieldHistory = fieldHistory
		 this.keyModified("field_history") = 1
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