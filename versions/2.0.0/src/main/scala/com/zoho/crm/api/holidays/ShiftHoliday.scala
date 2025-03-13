package com.zoho.crm.api.holidays

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.LocalDate
import scala.collection.mutable.HashMap

class ShiftHoliday extends Model	{
	private var name:Option[String] = None
	private var date:Option[LocalDate] = None
	private var type1:Choice[String] = _
	private var shiftHour:Option[ShiftHour] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getDate() :Option[LocalDate]	={
		return  this.date
	}

	def setDate( date: Option[LocalDate]) 	={
		 this.date = date
		 this.keyModified("date") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getShiftHour() :Option[ShiftHour]	={
		return  this.shiftHour
	}

	def setShiftHour( shiftHour: Option[ShiftHour]) 	={
		 this.shiftHour = shiftHour
		 this.keyModified("shift_hour") = 1
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