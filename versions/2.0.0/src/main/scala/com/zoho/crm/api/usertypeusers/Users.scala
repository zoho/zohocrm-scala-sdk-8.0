package com.zoho.crm.api.usertypeusers

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Users extends Model	{
	private var personalityId:Option[Long] = None
	private var confirm:Option[Boolean] = None
	private var statusReasonS:Option[String] = None
	private var invitedTime:Option[OffsetDateTime] = None
	private var module:Option[String] = None
	private var name:Option[String] = None
	private var active:Option[Boolean] = None
	private var email:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPersonalityId() :Option[Long]	={
		return  this.personalityId
	}

	def setPersonalityId( personalityId: Option[Long]) 	={
		 this.personalityId = personalityId
		 this.keyModified("personality_id") = 1
	}

	def getConfirm() :Option[Boolean]	={
		return  this.confirm
	}

	def setConfirm( confirm: Option[Boolean]) 	={
		 this.confirm = confirm
		 this.keyModified("confirm") = 1
	}

	def getStatusReasonS() :Option[String]	={
		return  this.statusReasonS
	}

	def setStatusReasonS( statusReasonS: Option[String]) 	={
		 this.statusReasonS = statusReasonS
		 this.keyModified("status_reason__s") = 1
	}

	def getInvitedTime() :Option[OffsetDateTime]	={
		return  this.invitedTime
	}

	def setInvitedTime( invitedTime: Option[OffsetDateTime]) 	={
		 this.invitedTime = invitedTime
		 this.keyModified("invited_time") = 1
	}

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
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

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
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