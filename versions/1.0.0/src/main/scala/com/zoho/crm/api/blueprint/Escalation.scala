package com.zoho.crm.api.blueprint

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Escalation extends Model	{
	private var days:Option[Int] = None
	private var status:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDays() :Option[Int]	={
		return  this.days
	}

	def setDays( days: Option[Int]) 	={
		 this.days = days
		 this.keyModified("days") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
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