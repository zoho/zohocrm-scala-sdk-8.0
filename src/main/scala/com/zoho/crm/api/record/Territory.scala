package com.zoho.crm.api.record

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Territory extends Model	{
	private var assigned:Option[String] = None
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var assignedTime:Option[OffsetDateTime] = None
	private var assignedBy:Option[MinifiedUser] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getassigned() :Option[String]	={
		return  this.assigned
	}

	def setassigned( assigned: Option[String]) 	={
		 this.assigned = assigned
		 this.keyModified("$assigned") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("Name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getassignedTime() :Option[OffsetDateTime]	={
		return  this.assignedTime
	}

	def setassignedTime( assignedTime: Option[OffsetDateTime]) 	={
		 this.assignedTime = assignedTime
		 this.keyModified("$assigned_time") = 1
	}

	def getassignedBy() :Option[MinifiedUser]	={
		return  this.assignedBy
	}

	def setassignedBy( assignedBy: Option[MinifiedUser]) 	={
		 this.assignedBy = assignedBy
		 this.keyModified("$assigned_by") = 1
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