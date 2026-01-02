package com.zoho.crm.api.emailtemplates

import com.zoho.crm.api.inventorytemplates.Folder
import com.zoho.crm.api.inventorytemplates.InventoryTemplates
import com.zoho.crm.api.inventorytemplates.ModuleMap
import com.zoho.crm.api.inventorytemplates.User
import com.zoho.crm.api.sendmail.Template
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class EmailTemplate extends InventoryTemplates with Template with Model	{
	private var attachments:ArrayBuffer[Attachment] = _
	private var subject:Option[String] = None
	private var associated:Option[Boolean] = None
	private var consentLinked:Option[Boolean] = None
	private var description:Option[String] = None
	private var lastVersionStatistics:Option[LastVersionStatistics] = None
	private var category:Option[String] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var lastUsageTime:Option[OffsetDateTime] = None
	private var folder:Option[Folder] = None
	private var module:Option[ModuleMap] = None
	private var createdBy:Option[User] = None
	private var modifiedBy:Option[User] = None
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var editorMode:Option[String] = None
	private var favorite:Option[Boolean] = None
	private var content:Option[String] = None
	private var active:Option[Boolean] = None
	private var mailContent:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAttachments() :ArrayBuffer[Attachment]	={
		return  this.attachments
	}

	def setAttachments( attachments: ArrayBuffer[Attachment]) 	={
		 this.attachments = attachments
		 this.keyModified("attachments") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getAssociated() :Option[Boolean]	={
		return  this.associated
	}

	def setAssociated( associated: Option[Boolean]) 	={
		 this.associated = associated
		 this.keyModified("associated") = 1
	}

	def getConsentLinked() :Option[Boolean]	={
		return  this.consentLinked
	}

	def setConsentLinked( consentLinked: Option[Boolean]) 	={
		 this.consentLinked = consentLinked
		 this.keyModified("consent_linked") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getLastVersionStatistics() :Option[LastVersionStatistics]	={
		return  this.lastVersionStatistics
	}

	def setLastVersionStatistics( lastVersionStatistics: Option[LastVersionStatistics]) 	={
		 this.lastVersionStatistics = lastVersionStatistics
		 this.keyModified("last_version_statistics") = 1
	}

	override def getCategory() :Option[String]	={
		return  this.category
	}

	override def setCategory( category: Option[String]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	override def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	override def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	override def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	override def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	override def getLastUsageTime() :Option[OffsetDateTime]	={
		return  this.lastUsageTime
	}

	override def setLastUsageTime( lastUsageTime: Option[OffsetDateTime]) 	={
		 this.lastUsageTime = lastUsageTime
		 this.keyModified("last_usage_time") = 1
	}

	override def getFolder() :Option[Folder]	={
		return  this.folder
	}

	override def setFolder( folder: Option[Folder]) 	={
		 this.folder = folder
		 this.keyModified("folder") = 1
	}

	override def getModule() :Option[ModuleMap]	={
		return  this.module
	}

	override def setModule( module: Option[ModuleMap]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	override def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	override def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	override def getModifiedBy() :Option[User]	={
		return  this.modifiedBy
	}

	override def setModifiedBy( modifiedBy: Option[User]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	override def getName() :Option[String]	={
		return  this.name
	}

	override def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	override def getId() :Option[Long]	={
		return  this.id
	}

	override def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	override def getEditorMode() :Option[String]	={
		return  this.editorMode
	}

	override def setEditorMode( editorMode: Option[String]) 	={
		 this.editorMode = editorMode
		 this.keyModified("editor_mode") = 1
	}

	override def getFavorite() :Option[Boolean]	={
		return  this.favorite
	}

	override def setFavorite( favorite: Option[Boolean]) 	={
		 this.favorite = favorite
		 this.keyModified("favorite") = 1
	}

	override def getContent() :Option[String]	={
		return  this.content
	}

	override def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
	}

	override def getActive() :Option[Boolean]	={
		return  this.active
	}

	override def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	override def getMailContent() :Option[String]	={
		return  this.mailContent
	}

	override def setMailContent( mailContent: Option[String]) 	={
		 this.mailContent = mailContent
		 this.keyModified("mail_content") = 1
	}

	override def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	override def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}