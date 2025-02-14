package com.zoho.crm.api.shifthours

import com.zoho.crm.api.util.Model
import java.time.LocalTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BreakCustomTiming extends Model	{
	private var days:Option[String] = None
	private var breakTiming:ArrayBuffer[LocalTime] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDays() :Option[String]	={
		return  this.days
	}

	def setDays( days: Option[String]) 	={
		 this.days = days
		 this.keyModified("days") = 1
	}

	def getBreakTiming() :ArrayBuffer[LocalTime]	={
		return  this.breakTiming
	}

	def setBreakTiming( breakTiming: ArrayBuffer[LocalTime]) 	={
		 this.breakTiming = breakTiming
		 this.keyModified("break_timing") = 1
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