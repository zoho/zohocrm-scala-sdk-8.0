package com.zoho.crm.api.cadences

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ExecutionDetail extends Model	{
	private var unenrollProperties:Option[UnenrollProperty] = None
	private var endDate:Option[String] = None
	private var automaticUnenroll:Option[Boolean] = None
	private var type1:Option[String] = None
	private var executeEvery:Option[ExecuteEvery] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUnenrollProperties() :Option[UnenrollProperty]	={
		return  this.unenrollProperties
	}

	def setUnenrollProperties( unenrollProperties: Option[UnenrollProperty]) 	={
		 this.unenrollProperties = unenrollProperties
		 this.keyModified("unenroll_properties") = 1
	}

	def getEndDate() :Option[String]	={
		return  this.endDate
	}

	def setEndDate( endDate: Option[String]) 	={
		 this.endDate = endDate
		 this.keyModified("end_date") = 1
	}

	def getAutomaticUnenroll() :Option[Boolean]	={
		return  this.automaticUnenroll
	}

	def setAutomaticUnenroll( automaticUnenroll: Option[Boolean]) 	={
		 this.automaticUnenroll = automaticUnenroll
		 this.keyModified("automatic_unenroll") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getExecuteEvery() :Option[ExecuteEvery]	={
		return  this.executeEvery
	}

	def setExecuteEvery( executeEvery: Option[ExecuteEvery]) 	={
		 this.executeEvery = executeEvery
		 this.keyModified("execute_every") = 1
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