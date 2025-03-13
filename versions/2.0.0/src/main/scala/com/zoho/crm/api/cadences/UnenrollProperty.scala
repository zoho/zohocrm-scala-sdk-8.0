package com.zoho.crm.api.cadences

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class UnenrollProperty extends Model	{
	private var endDate:Option[String] = None
	private var type1:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEndDate() :Option[String]	={
		return  this.endDate
	}

	def setEndDate( endDate: Option[String]) 	={
		 this.endDate = endDate
		 this.keyModified("end_date") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
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