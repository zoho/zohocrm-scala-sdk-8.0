package com.zoho.crm.api.users

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class AssociatedGroup extends Model	{
	private var id:Option[Long] = None
	private var name:Option[String] = None
	private var description:Option[String] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var createdBy:Option[MinifiedUser] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

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

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
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