package com.zoho.crm.api.emaildrafts

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import java.util.TimeZone

class ScheduleDetails extends Model	{
	private var time:Option[OffsetDateTime] = None
	private var timezone:Option[TimeZone] = None
	private var source:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTime() :Option[OffsetDateTime]	={
		return  this.time
	}

	def setTime( time: Option[OffsetDateTime]) 	={
		 this.time = time
		 this.keyModified("time") = 1
	}

	def getTimezone() :Option[TimeZone]	={
		return  this.timezone
	}

	def setTimezone( timezone: Option[TimeZone]) 	={
		 this.timezone = timezone
		 this.keyModified("timezone") = 1
	}

	def getSource() :Option[String]	={
		return  this.source
	}

	def setSource( source: Option[String]) 	={
		 this.source = source
		 this.keyModified("source") = 1
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