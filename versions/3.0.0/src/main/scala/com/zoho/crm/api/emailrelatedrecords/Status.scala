package com.zoho.crm.api.emailrelatedrecords

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Status extends Model	{
	private var firstOpen:Option[OffsetDateTime] = None
	private var count:Option[String] = None
	private var type1:Option[String] = None
	private var lastOpen:Option[OffsetDateTime] = None
	private var bouncedTime:Option[OffsetDateTime] = None
	private var bouncedReason:Option[String] = None
	private var category:Option[String] = None
	private var subCategory:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFirstOpen() :Option[OffsetDateTime]	={
		return  this.firstOpen
	}

	def setFirstOpen( firstOpen: Option[OffsetDateTime]) 	={
		 this.firstOpen = firstOpen
		 this.keyModified("first_open") = 1
	}

	def getCount() :Option[String]	={
		return  this.count
	}

	def setCount( count: Option[String]) 	={
		 this.count = count
		 this.keyModified("count") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getLastOpen() :Option[OffsetDateTime]	={
		return  this.lastOpen
	}

	def setLastOpen( lastOpen: Option[OffsetDateTime]) 	={
		 this.lastOpen = lastOpen
		 this.keyModified("last_open") = 1
	}

	def getBouncedTime() :Option[OffsetDateTime]	={
		return  this.bouncedTime
	}

	def setBouncedTime( bouncedTime: Option[OffsetDateTime]) 	={
		 this.bouncedTime = bouncedTime
		 this.keyModified("bounced_time") = 1
	}

	def getBouncedReason() :Option[String]	={
		return  this.bouncedReason
	}

	def setBouncedReason( bouncedReason: Option[String]) 	={
		 this.bouncedReason = bouncedReason
		 this.keyModified("bounced_reason") = 1
	}

	def getCategory() :Option[String]	={
		return  this.category
	}

	def setCategory( category: Option[String]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	def getSubCategory() :Option[String]	={
		return  this.subCategory
	}

	def setSubCategory( subCategory: Option[String]) 	={
		 this.subCategory = subCategory
		 this.keyModified("sub_category") = 1
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