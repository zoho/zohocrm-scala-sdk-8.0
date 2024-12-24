package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class SharingRules extends Model	{
	private var id:Option[Long] = None
	private var permissionType:Choice[String] = _
	private var superiorsAllowed:Option[Boolean] = None
	private var name:Option[String] = None
	private var type1:Choice[String] = _
	private var sharedFrom:Option[Shared] = None
	private var sharedTo:Option[Shared] = None
	private var criteria:Option[Criteria] = None
	private var module:Option[Module] = None
	private var status:Choice[String] = _
	private var matchLimitExceeded:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getPermissionType() :Choice[String]	={
		return  this.permissionType
	}

	def setPermissionType( permissionType: Choice[String]) 	={
		 this.permissionType = permissionType
		 this.keyModified("permission_type") = 1
	}

	def getSuperiorsAllowed() :Option[Boolean]	={
		return  this.superiorsAllowed
	}

	def setSuperiorsAllowed( superiorsAllowed: Option[Boolean]) 	={
		 this.superiorsAllowed = superiorsAllowed
		 this.keyModified("superiors_allowed") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getSharedFrom() :Option[Shared]	={
		return  this.sharedFrom
	}

	def setSharedFrom( sharedFrom: Option[Shared]) 	={
		 this.sharedFrom = sharedFrom
		 this.keyModified("shared_from") = 1
	}

	def getSharedTo() :Option[Shared]	={
		return  this.sharedTo
	}

	def setSharedTo( sharedTo: Option[Shared]) 	={
		 this.sharedTo = sharedTo
		 this.keyModified("shared_to") = 1
	}

	def getCriteria() :Option[Criteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Criteria]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
	}

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getStatus() :Choice[String]	={
		return  this.status
	}

	def setStatus( status: Choice[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getMatchLimitExceeded() :Option[Boolean]	={
		return  this.matchLimitExceeded
	}

	def setMatchLimitExceeded( matchLimitExceeded: Option[Boolean]) 	={
		 this.matchLimitExceeded = matchLimitExceeded
		 this.keyModified("match_limit_exceeded") = 1
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