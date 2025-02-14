package com.zoho.crm.api.holidays

import com.zoho.crm.api.util.Model
import java.time.LocalDate
import scala.collection.mutable.HashMap

class Holiday extends Model	{
	private var year:Option[Int] = None
	private var name:Option[String] = None
	private var date:Option[LocalDate] = None
	private var type1:Option[String] = None
	private var id:Option[Long] = None
	private var shiftHour:Option[ShiftHour] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getYear() :Option[Int]	={
		return  this.year
	}

	def setYear( year: Option[Int]) 	={
		 this.year = year
		 this.keyModified("year") = 1
	}

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

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
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