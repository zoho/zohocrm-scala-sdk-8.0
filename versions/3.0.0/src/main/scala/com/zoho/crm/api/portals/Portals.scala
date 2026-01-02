package com.zoho.crm.api.portals

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Portals extends Model	{
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var modifiedBy:Option[Owner] = None
	private var createdBy:Option[Owner] = None
	private var zaid:Option[String] = None
	private var name:Option[String] = None
	private var active:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getModifiedBy() :Option[Owner]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[Owner]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getCreatedBy() :Option[Owner]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[Owner]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getZaid() :Option[String]	={
		return  this.zaid
	}

	def setZaid( zaid: Option[String]) 	={
		 this.zaid = zaid
		 this.keyModified("zaid") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
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