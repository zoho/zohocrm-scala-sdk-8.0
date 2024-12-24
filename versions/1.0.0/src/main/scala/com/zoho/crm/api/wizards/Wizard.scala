package com.zoho.crm.api.wizards

import com.zoho.crm.api.modules.Modules
import com.zoho.crm.api.profiles.Profile
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Wizard extends Model	{
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var module:Option[Modules] = None
	private var name:Option[String] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var profiles:ArrayBuffer[Profile] = _
	private var active:Option[Boolean] = None
	private var containers:ArrayBuffer[Container] = _
	private var id:Option[Long] = None
	private var createdBy:Option[MinifiedUser] = None
	private var portalUserTypes:ArrayBuffer[PortalUserType] = _
	private var exemptedPortalUserTypes:ArrayBuffer[ExemptedPortalUserType] = _
	private var parentWizard:Option[Wizard] = None
	private var draft:Option[Boolean] = None
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

	def getModule() :Option[Modules]	={
		return  this.module
	}

	def setModule( module: Option[Modules]) 	={
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

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getProfiles() :ArrayBuffer[Profile]	={
		return  this.profiles
	}

	def setProfiles( profiles: ArrayBuffer[Profile]) 	={
		 this.profiles = profiles
		 this.keyModified("profiles") = 1
	}

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	def getContainers() :ArrayBuffer[Container]	={
		return  this.containers
	}

	def setContainers( containers: ArrayBuffer[Container]) 	={
		 this.containers = containers
		 this.keyModified("containers") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getPortalUserTypes() :ArrayBuffer[PortalUserType]	={
		return  this.portalUserTypes
	}

	def setPortalUserTypes( portalUserTypes: ArrayBuffer[PortalUserType]) 	={
		 this.portalUserTypes = portalUserTypes
		 this.keyModified("portal_user_types") = 1
	}

	def getExemptedPortalUserTypes() :ArrayBuffer[ExemptedPortalUserType]	={
		return  this.exemptedPortalUserTypes
	}

	def setExemptedPortalUserTypes( exemptedPortalUserTypes: ArrayBuffer[ExemptedPortalUserType]) 	={
		 this.exemptedPortalUserTypes = exemptedPortalUserTypes
		 this.keyModified("exempted_portal_user_types") = 1
	}

	def getParentWizard() :Option[Wizard]	={
		return  this.parentWizard
	}

	def setParentWizard( parentWizard: Option[Wizard]) 	={
		 this.parentWizard = parentWizard
		 this.keyModified("parent_wizard") = 1
	}

	def getDraft() :Option[Boolean]	={
		return  this.draft
	}

	def setDraft( draft: Option[Boolean]) 	={
		 this.draft = draft
		 this.keyModified("draft") = 1
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