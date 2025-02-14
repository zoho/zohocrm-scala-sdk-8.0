package com.zoho.crm.api.businesshours

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BreakHoursCustomTiming extends Model	{
	private var days:Choice[String] = _
	private var businessTiming:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDays() :Choice[String]	={
		return  this.days
	}

	def setDays( days: Choice[String]) 	={
		 this.days = days
		 this.keyModified("days") = 1
	}

	def getBusinessTiming() :ArrayBuffer[String]	={
		return  this.businessTiming
	}

	def setBusinessTiming( businessTiming: ArrayBuffer[String]) 	={
		 this.businessTiming = businessTiming
		 this.keyModified("business_timing") = 1
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