package com.zoho.crm.api.profiles

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PermissionDetail extends Model	{
	private var id:Option[String] = None
	private var enabled:Option[Boolean] = None
	private var name:Option[String] = None
	private var displayLabel:Option[String] = None
	private var customizable:Option[Boolean] = None
	private var parentPermissions:ArrayBuffer[Long] = _
	private var module:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getEnabled() :Option[Boolean]	={
		return  this.enabled
	}

	def setEnabled( enabled: Option[Boolean]) 	={
		 this.enabled = enabled
		 this.keyModified("enabled") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getCustomizable() :Option[Boolean]	={
		return  this.customizable
	}

	def setCustomizable( customizable: Option[Boolean]) 	={
		 this.customizable = customizable
		 this.keyModified("customizable") = 1
	}

	def getParentPermissions() :ArrayBuffer[Long]	={
		return  this.parentPermissions
	}

	def setParentPermissions( parentPermissions: ArrayBuffer[Long]) 	={
		 this.parentPermissions = parentPermissions
		 this.keyModified("parent_permissions") = 1
	}

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
		 this.module = module
		 this.keyModified("module") = 1
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