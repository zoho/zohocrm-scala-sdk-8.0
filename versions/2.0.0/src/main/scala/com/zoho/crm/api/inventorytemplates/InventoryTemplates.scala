package com.zoho.crm.api.inventorytemplates

import com.zoho.crm.api.sendmail.Template
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class InventoryTemplates extends Model with Template	{
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
	private var category:Option[String] = None
	private var favorite:Option[Boolean] = None
	private var content:Option[String] = None
	private var active:Option[Boolean] = None
	private var mailContent:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

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

	def getLastUsageTime() :Option[OffsetDateTime]	={
		return  this.lastUsageTime
	}

	def setLastUsageTime( lastUsageTime: Option[OffsetDateTime]) 	={
		 this.lastUsageTime = lastUsageTime
		 this.keyModified("last_usage_time") = 1
	}

	def getFolder() :Option[Folder]	={
		return  this.folder
	}

	def setFolder( folder: Option[Folder]) 	={
		 this.folder = folder
		 this.keyModified("folder") = 1
	}

	def getModule() :Option[ModuleMap]	={
		return  this.module
	}

	def setModule( module: Option[ModuleMap]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getModifiedBy() :Option[User]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[User]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getEditorMode() :Option[String]	={
		return  this.editorMode
	}

	def setEditorMode( editorMode: Option[String]) 	={
		 this.editorMode = editorMode
		 this.keyModified("editor_mode") = 1
	}

	def getCategory() :Option[String]	={
		return  this.category
	}

	def setCategory( category: Option[String]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	def getFavorite() :Option[Boolean]	={
		return  this.favorite
	}

	def setFavorite( favorite: Option[Boolean]) 	={
		 this.favorite = favorite
		 this.keyModified("favorite") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
	}

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	def getMailContent() :Option[String]	={
		return  this.mailContent
	}

	def setMailContent( mailContent: Option[String]) 	={
		 this.mailContent = mailContent
		 this.keyModified("mail_content") = 1
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