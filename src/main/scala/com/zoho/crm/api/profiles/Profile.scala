package com.zoho.crm.api.profiles

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Profile extends Model	{
	private var defaultView:Option[DefaultView] = None
	private var name:Option[String] = None
	private var description:Option[String] = None
	private var id:Option[Long] = None
	private var default1:Option[Boolean] = None
	private var delete:Option[Boolean] = None
	private var permissionType:Option[String] = None
	private var custom:Option[Boolean] = None
	private var displayLabel:Option[String] = None
	private var type1:Choice[String] = _
	private var permissionsDetails:ArrayBuffer[PermissionDetail] = _
	private var sections:ArrayBuffer[Section] = _
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var category:Option[Boolean] = None
	private var createdBy:Option[MinifiedUser] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDefaultView() :Option[DefaultView]	={
		return  this.defaultView
	}

	def setDefaultView( defaultView: Option[DefaultView]) 	={
		 this.defaultView = defaultView
		 this.keyModified("_default_view") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getDefault() :Option[Boolean]	={
		return  this.default1
	}

	def setDefault( default1: Option[Boolean]) 	={
		 this.default1 = default1
		 this.keyModified("default") = 1
	}

	def getDelete() :Option[Boolean]	={
		return  this.delete
	}

	def setDelete( delete: Option[Boolean]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
	}

	def getPermissionType() :Option[String]	={
		return  this.permissionType
	}

	def setPermissionType( permissionType: Option[String]) 	={
		 this.permissionType = permissionType
		 this.keyModified("permission_type") = 1
	}

	def getCustom() :Option[Boolean]	={
		return  this.custom
	}

	def setCustom( custom: Option[Boolean]) 	={
		 this.custom = custom
		 this.keyModified("custom") = 1
	}

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getPermissionsDetails() :ArrayBuffer[PermissionDetail]	={
		return  this.permissionsDetails
	}

	def setPermissionsDetails( permissionsDetails: ArrayBuffer[PermissionDetail]) 	={
		 this.permissionsDetails = permissionsDetails
		 this.keyModified("permissions_details") = 1
	}

	def getSections() :ArrayBuffer[Section]	={
		return  this.sections
	}

	def setSections( sections: ArrayBuffer[Section]) 	={
		 this.sections = sections
		 this.keyModified("sections") = 1
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

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getCategory() :Option[Boolean]	={
		return  this.category
	}

	def setCategory( category: Option[Boolean]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
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