package com.zoho.crm.api.cadencesexecution

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class CadencesAnalyticsGet extends Model	{
	private var module:Option[Module] = None
	private var name:Option[String] = None
	private var followUps:ArrayBuffer[Analytics] = _
	private var id:Option[Long] = None
	private var createdBy:Option[User] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getFollowUps() :ArrayBuffer[Analytics]	={
		return  this.followUps
	}

	def setFollowUps( followUps: ArrayBuffer[Analytics]) 	={
		 this.followUps = followUps
		 this.keyModified("follow_ups") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
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