package com.zoho.crm.api.shifthours

import com.zoho.crm.api.util.Model
import java.time.LocalTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import java.util.TimeZone

class ShiftHours extends Model	{
	private var sameAsEveryday:Option[Boolean] = None
	private var shiftDays:ArrayBuffer[String] = _
	private var dailyTiming:ArrayBuffer[LocalTime] = _
	private var customTiming:ArrayBuffer[ShiftCustomTiming] = _
	private var id:Option[Long] = None
	private var breakHours:ArrayBuffer[BreakHours] = _
	private var users:ArrayBuffer[Users] = _
	private var holidays:ArrayBuffer[Holidays] = _
	private var usersCount:Option[Int] = None
	private var timezone:Option[TimeZone] = None
	private var name:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSameAsEveryday() :Option[Boolean]	={
		return  this.sameAsEveryday
	}

	def setSameAsEveryday( sameAsEveryday: Option[Boolean]) 	={
		 this.sameAsEveryday = sameAsEveryday
		 this.keyModified("same_as_everyday") = 1
	}

	def getShiftDays() :ArrayBuffer[String]	={
		return  this.shiftDays
	}

	def setShiftDays( shiftDays: ArrayBuffer[String]) 	={
		 this.shiftDays = shiftDays
		 this.keyModified("shift_days") = 1
	}

	def getDailyTiming() :ArrayBuffer[LocalTime]	={
		return  this.dailyTiming
	}

	def setDailyTiming( dailyTiming: ArrayBuffer[LocalTime]) 	={
		 this.dailyTiming = dailyTiming
		 this.keyModified("daily_timing") = 1
	}

	def getCustomTiming() :ArrayBuffer[ShiftCustomTiming]	={
		return  this.customTiming
	}

	def setCustomTiming( customTiming: ArrayBuffer[ShiftCustomTiming]) 	={
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

	def getBreakHours() :ArrayBuffer[BreakHours]	={
		return  this.breakHours
	}

	def setBreakHours( breakHours: ArrayBuffer[BreakHours]) 	={
		 this.breakHours = breakHours
		 this.keyModified("break_hours") = 1
	}

	def getUsers() :ArrayBuffer[Users]	={
		return  this.users
	}

	def setUsers( users: ArrayBuffer[Users]) 	={
		 this.users = users
		 this.keyModified("users") = 1
	}

	def getHolidays() :ArrayBuffer[Holidays]	={
		return  this.holidays
	}

	def setHolidays( holidays: ArrayBuffer[Holidays]) 	={
		 this.holidays = holidays
		 this.keyModified("holidays") = 1
	}

	def getUsersCount() :Option[Int]	={
		return  this.usersCount
	}

	def setUsersCount( usersCount: Option[Int]) 	={
		 this.usersCount = usersCount
		 this.keyModified("users_count") = 1
	}

	def getTimezone() :Option[TimeZone]	={
		return  this.timezone
	}

	def setTimezone( timezone: Option[TimeZone]) 	={
		 this.timezone = timezone
		 this.keyModified("timezone") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
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