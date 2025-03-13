package com.zoho.crm.api.holidays

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class CreateShiftHoliday extends Model with BodyWrapper	{
	private var holidays:ArrayBuffer[ShiftHoliday] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getHolidays() :ArrayBuffer[ShiftHoliday]	={
		return  this.holidays
	}

	def setHolidays( holidays: ArrayBuffer[ShiftHoliday]) 	={
		 this.holidays = holidays
		 this.keyModified("holidays") = 1
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