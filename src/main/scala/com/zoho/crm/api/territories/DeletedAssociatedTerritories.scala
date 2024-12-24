package com.zoho.crm.api.territories

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class DeletedAssociatedTerritories extends Model	{
	private var name:Option[String] = None
	private var id:Option[String] = None
	private var deletedTime:Option[OffsetDateTime] = None
	private var deletedBy:Option[MinifiedUser] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getDeletedTime() :Option[OffsetDateTime]	={
		return  this.deletedTime
	}

	def setDeletedTime( deletedTime: Option[OffsetDateTime]) 	={
		 this.deletedTime = deletedTime
		 this.keyModified("deleted_time") = 1
	}

	def getDeletedBy() :Option[MinifiedUser]	={
		return  this.deletedBy
	}

	def setDeletedBy( deletedBy: Option[MinifiedUser]) 	={
		 this.deletedBy = deletedBy
		 this.keyModified("deleted_by") = 1
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