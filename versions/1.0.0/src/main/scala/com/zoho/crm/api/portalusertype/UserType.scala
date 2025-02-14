package com.zoho.crm.api.portalusertype

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class UserType extends Model	{
	private var personalityModule:Option[PersonalityModule] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var modifiedBy:Option[Owner] = None
	private var createdBy:Option[Owner] = None
	private var name:Option[String] = None
	private var active:Option[Boolean] = None
	private var default1:Option[Boolean] = None
	private var noOfUsers:Option[Int] = None
	private var id:Option[Long] = None
	private var modules:ArrayBuffer[Modules] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPersonalityModule() :Option[PersonalityModule]	={
		return  this.personalityModule
	}

	def setPersonalityModule( personalityModule: Option[PersonalityModule]) 	={
		 this.personalityModule = personalityModule
		 this.keyModified("personality_module") = 1
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

	def getDefault() :Option[Boolean]	={
		return  this.default1
	}

	def setDefault( default1: Option[Boolean]) 	={
		 this.default1 = default1
		 this.keyModified("default") = 1
	}

	def getNoOfUsers() :Option[Int]	={
		return  this.noOfUsers
	}

	def setNoOfUsers( noOfUsers: Option[Int]) 	={
		 this.noOfUsers = noOfUsers
		 this.keyModified("no_of_users") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getModules() :ArrayBuffer[Modules]	={
		return  this.modules
	}

	def setModules( modules: ArrayBuffer[Modules]) 	={
		 this.modules = modules
		 this.keyModified("modules") = 1
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