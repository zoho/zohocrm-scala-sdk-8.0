package com.zoho.crm.api.businesshours

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BusinessHours extends Model	{
	private var weekStartsOn:Choice[String] = _
	private var type1:Choice[String] = _
	private var id:Option[Long] = None
	private var businessDays:ArrayBuffer[Choice[String]] = _
	private var sameAsEveryday:Option[Boolean] = None
	private var dailyTiming:ArrayBuffer[String] = _
	private var customTiming:ArrayBuffer[BreakHoursCustomTiming] = _
	private var timezone:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getWeekStartsOn() :Choice[String]	={
		return  this.weekStartsOn
	}

	def setWeekStartsOn( weekStartsOn: Choice[String]) 	={
		 this.weekStartsOn = weekStartsOn
		 this.keyModified("week_starts_on") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getBusinessDays() :ArrayBuffer[Choice[String]]	={
		return  this.businessDays
	}

	def setBusinessDays( businessDays: ArrayBuffer[Choice[String]]) 	={
		 this.businessDays = businessDays
		 this.keyModified("business_days") = 1
	}

	def getSameAsEveryday() :Option[Boolean]	={
		return  this.sameAsEveryday
	}

	def setSameAsEveryday( sameAsEveryday: Option[Boolean]) 	={
		 this.sameAsEveryday = sameAsEveryday
		 this.keyModified("same_as_everyday") = 1
	}

	def getDailyTiming() :ArrayBuffer[String]	={
		return  this.dailyTiming
	}

	def setDailyTiming( dailyTiming: ArrayBuffer[String]) 	={
		 this.dailyTiming = dailyTiming
		 this.keyModified("daily_timing") = 1
	}

	def getCustomTiming() :ArrayBuffer[BreakHoursCustomTiming]	={
		return  this.customTiming
	}

	def setCustomTiming( customTiming: ArrayBuffer[BreakHoursCustomTiming]) 	={
		 this.customTiming = customTiming
		 this.keyModified("custom_timing") = 1
	}

	def getTimezone() :Option[String]	={
		return  this.timezone
	}

	def setTimezone( timezone: Option[String]) 	={
		 this.timezone = timezone
		 this.keyModified("timezone") = 1
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