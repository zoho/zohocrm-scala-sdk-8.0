package com.zoho.crm.api.recordlocking

import com.zoho.crm.api.record.Record
import com.zoho.crm.api.tags.Tag
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.ArrayBuffer

class RecordLock extends Record with Model	{

	def getLockSourceS() :Choice[String]	={
		return  this.getKeyValue("lock_source__s").asInstanceOf[Choice[String]]
	}

	def setLockSourceS( lockSourceS: Choice[String]) 	={
		 this.addKeyValue("lock_source__s", lockSourceS)
	}

	def getLockedByS() :Option[MinifiedUser]	={
		return  this.getKeyValue("locked_by__s").asInstanceOf[Option[MinifiedUser]]
	}

	def setLockedByS( lockedByS: Option[MinifiedUser]) 	={
		 this.addKeyValue("locked_by__s", lockedByS)
	}

	def getLockedForS() :Option[LockedForS]	={
		return  this.getKeyValue("locked_for_s").asInstanceOf[Option[LockedForS]]
	}

	def setLockedForS( lockedForS: Option[LockedForS]) 	={
		 this.addKeyValue("locked_for_s", lockedForS)
	}

	def getLockedReasonS() :Option[String]	={
		return  this.getKeyValue("locked_reason__s").asInstanceOf[Option[String]]
	}

	def setLockedReasonS( lockedReasonS: Option[String]) 	={
		 this.addKeyValue("locked_reason__s", lockedReasonS)
	}

	def getLockedTimeS() :Option[String]	={
		return  this.getKeyValue("Locked_time__s").asInstanceOf[Option[String]]
	}

	def setLockedTimeS( lockedTimeS: Option[String]) 	={
		 this.addKeyValue("Locked_time__s", lockedTimeS)
	}

	def getRecordLockingConfigurationIdS() :Option[Long]	={
		return  this.getKeyValue("record_locking_configuration_id__s").asInstanceOf[Option[Long]]
	}

	def setRecordLockingConfigurationIdS( recordLockingConfigurationIdS: Option[Long]) 	={
		 this.addKeyValue("record_locking_configuration_id__s", recordLockingConfigurationIdS)
	}

	def getRecordLockingRuleIdS() :Option[Long]	={
		return  this.getKeyValue("record_locking_rule_id__s").asInstanceOf[Option[Long]]
	}

	def setRecordLockingRuleIdS( recordLockingRuleIdS: Option[Long]) 	={
		 this.addKeyValue("record_locking_rule_id__s", recordLockingRuleIdS)
	}

	override def getId() :Option[Long]	={
		return  this.getKeyValue("id").asInstanceOf[Option[Long]]
	}

	override def setId( id: Option[Long]) 	={
		 this.addKeyValue("id", id)
	}

	override def getCreatedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("Created_By").asInstanceOf[Option[MinifiedUser]]
	}

	override def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("Created_By", createdBy)
	}

	override def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Created_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Created_Time", createdTime)
	}

	override def getModifiedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("Modified_By").asInstanceOf[Option[MinifiedUser]]
	}

	override def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("Modified_By", modifiedBy)
	}

	override def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Modified_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Modified_Time", modifiedTime)
	}

	override def getTag() :ArrayBuffer[Tag]	={
		return  this.getKeyValue("Tag").asInstanceOf[ArrayBuffer[Tag]]
	}

	override def setTag( tag: ArrayBuffer[Tag]) 	={
		 this.addKeyValue("Tag", tag)
	}

	override def getName() :Option[String]	={
		return  this.getKeyValue("name").asInstanceOf[Option[String]]
	}

	override def setName( name: Option[String]) 	={
		 this.addKeyValue("name", name)
	}}