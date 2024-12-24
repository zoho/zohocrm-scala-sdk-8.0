package com.zoho.crm.api.usersterritories

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Territory extends Model	{
	private var id:Option[Long] = None
	private var manager:Option[Manager] = None
	private var reportingTo:Option[Manager] = None
	private var name:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getManager() :Option[Manager]	={
		return  this.manager
	}

	def setManager( manager: Option[Manager]) 	={
		 this.manager = manager
		 this.keyModified("Manager") = 1
	}

	def getReportingTo() :Option[Manager]	={
		return  this.reportingTo
	}

	def setReportingTo( reportingTo: Option[Manager]) 	={
		 this.reportingTo = reportingTo
		 this.keyModified("Reporting_To") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("Name") = 1
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