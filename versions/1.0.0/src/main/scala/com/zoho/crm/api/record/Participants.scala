package com.zoho.crm.api.record

import com.zoho.crm.api.tags.Tag
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.ArrayBuffer

class Participants extends Record with Model	{

	override def getName() :Option[String]	={
		return  this.getKeyValue("name").asInstanceOf[Option[String]]
	}

	override def setName( name: Option[String]) 	={
		 this.addKeyValue("name", name)
	}

	def getEmail() :Option[String]	={
		return  this.getKeyValue("Email").asInstanceOf[Option[String]]
	}

	def setEmail( email: Option[String]) 	={
		 this.addKeyValue("Email", email)
	}

	def getInvited() :Option[Boolean]	={
		return  this.getKeyValue("invited").asInstanceOf[Option[Boolean]]
	}

	def setInvited( invited: Option[Boolean]) 	={
		 this.addKeyValue("invited", invited)
	}

	def getType() :Option[String]	={
		return  this.getKeyValue("type").asInstanceOf[Option[String]]
	}

	def setType( type1: Option[String]) 	={
		 this.addKeyValue("type", type1)
	}

	def getParticipant() :Option[String]	={
		return  this.getKeyValue("participant").asInstanceOf[Option[String]]
	}

	def setParticipant( participant: Option[String]) 	={
		 this.addKeyValue("participant", participant)
	}

	def getStatus() :Option[String]	={
		return  this.getKeyValue("status").asInstanceOf[Option[String]]
	}

	def setStatus( status: Option[String]) 	={
		 this.addKeyValue("status", status)
	}

	override def getId() :Option[Long]	={
		return  this.getKeyValue("id").asInstanceOf[Option[Long]]
	}

	override def setId( id: Option[Long]) 	={
		 this.addKeyValue("id", id)
	}

	override def getCreatedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("Created_By").asInstanceOf[Option[MinifiedUser]]
	}

	override def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("Created_By", createdBy)
	}

	override def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Created_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Created_Time", createdTime)
	}

	override def getModifiedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("Modified_By").asInstanceOf[Option[MinifiedUser]]
	}

	override def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("Modified_By", modifiedBy)
	}

	override def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Modified_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Modified_Time", modifiedTime)
	}

	override def getTag() :ArrayBuffer[Tag]	={
		return  this.getKeyValue("Tag").asInstanceOf[ArrayBuffer[Tag]]
	}

	override def setTag( tag: ArrayBuffer[Tag]) 	={
		 this.addKeyValue("Tag", tag)
	}}