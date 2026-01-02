package com.zoho.crm.api.recyclebin

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class RecycleBin extends Model	{
	private var displayName:Option[String] = None
	private var deletedTime:Option[OffsetDateTime] = None
	private var owner:Option[MinifiedUser] = None
	private var module:Option[MinifiedModule] = None
	private var deletedBy:Option[MinifiedUser] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayName() :Option[String]	={
		return  this.displayName
	}

	def setDisplayName( displayName: Option[String]) 	={
		 this.displayName = displayName
		 this.keyModified("display_name") = 1
	}

	def getDeletedTime() :Option[OffsetDateTime]	={
		return  this.deletedTime
	}

	def setDeletedTime( deletedTime: Option[OffsetDateTime]) 	={
		 this.deletedTime = deletedTime
		 this.keyModified("deleted_time") = 1
	}

	def getOwner() :Option[MinifiedUser]	={
		return  this.owner
	}

	def setOwner( owner: Option[MinifiedUser]) 	={
		 this.owner = owner
		 this.keyModified("owner") = 1
	}

	def getModule() :Option[MinifiedModule]	={
		return  this.module
	}

	def setModule( module: Option[MinifiedModule]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getDeletedBy() :Option[MinifiedUser]	={
		return  this.deletedBy
	}

	def setDeletedBy( deletedBy: Option[MinifiedUser]) 	={
		 this.deletedBy = deletedBy
		 this.keyModified("deleted_by") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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