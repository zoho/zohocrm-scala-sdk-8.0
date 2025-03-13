package com.zoho.crm.api.templates

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Templates extends Model	{
	private var folder:Option[Folder] = None
	private var modifiedBy:Option[Folder] = None
	private var module:Option[String] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var subject:Option[String] = None
	private var name:Option[String] = None
	private var consentLinked:Option[Boolean] = None
	private var favourite:Option[Boolean] = None
	private var attachmentPresent:Option[Boolean] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFolder() :Option[Folder]	={
		return  this.folder
	}

	def setFolder( folder: Option[Folder]) 	={
		 this.folder = folder
		 this.keyModified("folder") = 1
	}

	def getModifiedBy() :Option[Folder]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[Folder]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getConsentLinked() :Option[Boolean]	={
		return  this.consentLinked
	}

	def setConsentLinked( consentLinked: Option[Boolean]) 	={
		 this.consentLinked = consentLinked
		 this.keyModified("consent_linked") = 1
	}

	def getFavourite() :Option[Boolean]	={
		return  this.favourite
	}

	def setFavourite( favourite: Option[Boolean]) 	={
		 this.favourite = favourite
		 this.keyModified("favourite") = 1
	}

	def getAttachmentPresent() :Option[Boolean]	={
		return  this.attachmentPresent
	}

	def setAttachmentPresent( attachmentPresent: Option[Boolean]) 	={
		 this.attachmentPresent = attachmentPresent
		 this.keyModified("attachment_present") = 1
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