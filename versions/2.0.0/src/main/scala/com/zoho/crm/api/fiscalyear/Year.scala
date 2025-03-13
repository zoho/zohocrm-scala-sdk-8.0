package com.zoho.crm.api.fiscalyear

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Year extends Model	{
	private var startMonth:Choice[String] = _
	private var displayBasedOn:Choice[String] = _
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getStartMonth() :Choice[String]	={
		return  this.startMonth
	}

	def setStartMonth( startMonth: Choice[String]) 	={
		 this.startMonth = startMonth
		 this.keyModified("start_month") = 1
	}

	def getDisplayBasedOn() :Choice[String]	={
		return  this.displayBasedOn
	}

	def setDisplayBasedOn( displayBasedOn: Choice[String]) 	={
		 this.displayBasedOn = displayBasedOn
		 this.keyModified("display_based_on") = 1
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