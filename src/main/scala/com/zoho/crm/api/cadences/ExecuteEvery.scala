package com.zoho.crm.api.cadences

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ExecuteEvery extends Model	{
	private var unit:Option[Int] = None
	private var period:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUnit() :Option[Int]	={
		return  this.unit
	}

	def setUnit( unit: Option[Int]) 	={
		 this.unit = unit
		 this.keyModified("unit") = 1
	}

	def getPeriod() :Option[String]	={
		return  this.period
	}

	def setPeriod( period: Option[String]) 	={
		 this.period = period
		 this.keyModified("period") = 1
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