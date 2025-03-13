package com.zoho.crm.api.shifthours

import com.zoho.crm.api.util.Model
import java.time.LocalTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BreakHours extends Model	{
	private var breakDays:ArrayBuffer[String] = _
	private var sameAsEveryday:Option[Boolean] = None
	private var dailyTiming:ArrayBuffer[LocalTime] = _
	private var customTiming:ArrayBuffer[BreakCustomTiming] = _
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getBreakDays() :ArrayBuffer[String]	={
		return  this.breakDays
	}

	def setBreakDays( breakDays: ArrayBuffer[String]) 	={
		 this.breakDays = breakDays
		 this.keyModified("break_days") = 1
	}

	def getSameAsEveryday() :Option[Boolean]	={
		return  this.sameAsEveryday
	}

	def setSameAsEveryday( sameAsEveryday: Option[Boolean]) 	={
		 this.sameAsEveryday = sameAsEveryday
		 this.keyModified("same_as_everyday") = 1
	}

	def getDailyTiming() :ArrayBuffer[LocalTime]	={
		return  this.dailyTiming
	}

	def setDailyTiming( dailyTiming: ArrayBuffer[LocalTime]) 	={
		 this.dailyTiming = dailyTiming
		 this.keyModified("daily_timing") = 1
	}

	def getCustomTiming() :ArrayBuffer[BreakCustomTiming]	={
		return  this.customTiming
	}

	def setCustomTiming( customTiming: ArrayBuffer[BreakCustomTiming]) 	={
		 this.customTiming = customTiming
		 this.keyModified("custom_timing") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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