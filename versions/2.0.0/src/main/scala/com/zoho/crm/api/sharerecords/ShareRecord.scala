package com.zoho.crm.api.sharerecords

import com.zoho.crm.api.users.Users
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class ShareRecord extends Model	{
	private var sharedWith:Option[Users] = None
	private var shareRelatedRecords:Option[Boolean] = None
	private var sharedThrough:Option[SharedThrough] = None
	private var sharedTime:Option[OffsetDateTime] = None
	private var permission:Option[String] = None
	private var sharedBy:Option[Users] = None
	private var user:Option[Users] = None
	private var type1:Choice[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSharedWith() :Option[Users]	={
		return  this.sharedWith
	}

	def setSharedWith( sharedWith: Option[Users]) 	={
		 this.sharedWith = sharedWith
		 this.keyModified("shared_with") = 1
	}

	def getShareRelatedRecords() :Option[Boolean]	={
		return  this.shareRelatedRecords
	}

	def setShareRelatedRecords( shareRelatedRecords: Option[Boolean]) 	={
		 this.shareRelatedRecords = shareRelatedRecords
		 this.keyModified("share_related_records") = 1
	}

	def getSharedThrough() :Option[SharedThrough]	={
		return  this.sharedThrough
	}

	def setSharedThrough( sharedThrough: Option[SharedThrough]) 	={
		 this.sharedThrough = sharedThrough
		 this.keyModified("shared_through") = 1
	}

	def getSharedTime() :Option[OffsetDateTime]	={
		return  this.sharedTime
	}

	def setSharedTime( sharedTime: Option[OffsetDateTime]) 	={
		 this.sharedTime = sharedTime
		 this.keyModified("shared_time") = 1
	}

	def getPermission() :Option[String]	={
		return  this.permission
	}

	def setPermission( permission: Option[String]) 	={
		 this.permission = permission
		 this.keyModified("permission") = 1
	}

	def getSharedBy() :Option[Users]	={
		return  this.sharedBy
	}

	def setSharedBy( sharedBy: Option[Users]) 	={
		 this.sharedBy = sharedBy
		 this.keyModified("shared_by") = 1
	}

	def getUser() :Option[Users]	={
		return  this.user
	}

	def setUser( user: Option[Users]) 	={
		 this.user = user
		 this.keyModified("user") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
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