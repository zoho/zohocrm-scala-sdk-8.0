package com.zoho.crm.api.backup

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Backup extends Model	{
	private var rrule:Option[String] = None
	private var id:Option[Long] = None
	private var startDate:Option[OffsetDateTime] = None
	private var scheduledDate:Option[OffsetDateTime] = None
	private var status:Option[String] = None
	private var requester:Option[Requester] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRrule() :Option[String]	={
		return  this.rrule
	}

	def setRrule( rrule: Option[String]) 	={
		 this.rrule = rrule
		 this.keyModified("rrule") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getStartDate() :Option[OffsetDateTime]	={
		return  this.startDate
	}

	def setStartDate( startDate: Option[OffsetDateTime]) 	={
		 this.startDate = startDate
		 this.keyModified("start_date") = 1
	}

	def getScheduledDate() :Option[OffsetDateTime]	={
		return  this.scheduledDate
	}

	def setScheduledDate( scheduledDate: Option[OffsetDateTime]) 	={
		 this.scheduledDate = scheduledDate
		 this.keyModified("scheduled_date") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getRequester() :Option[Requester]	={
		return  this.requester
	}

	def setRequester( requester: Option[Requester]) 	={
		 this.requester = requester
		 this.keyModified("requester") = 1
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