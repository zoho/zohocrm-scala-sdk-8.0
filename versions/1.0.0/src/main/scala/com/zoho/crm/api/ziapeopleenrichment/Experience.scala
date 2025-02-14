package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Experience extends Model	{
	private var endDate:Option[String] = None
	private var companyName:Option[String] = None
	private var title:Option[String] = None
	private var startDate:Option[String] = None
	private var primary:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEndDate() :Option[String]	={
		return  this.endDate
	}

	def setEndDate( endDate: Option[String]) 	={
		 this.endDate = endDate
		 this.keyModified("end_date") = 1
	}

	def getCompanyName() :Option[String]	={
		return  this.companyName
	}

	def setCompanyName( companyName: Option[String]) 	={
		 this.companyName = companyName
		 this.keyModified("company_name") = 1
	}

	def getTitle() :Option[String]	={
		return  this.title
	}

	def setTitle( title: Option[String]) 	={
		 this.title = title
		 this.keyModified("title") = 1
	}

	def getStartDate() :Option[String]	={
		return  this.startDate
	}

	def setStartDate( startDate: Option[String]) 	={
		 this.startDate = startDate
		 this.keyModified("start_date") = 1
	}

	def getPrimary() :Option[Boolean]	={
		return  this.primary
	}

	def setPrimary( primary: Option[Boolean]) 	={
		 this.primary = primary
		 this.keyModified("primary") = 1
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