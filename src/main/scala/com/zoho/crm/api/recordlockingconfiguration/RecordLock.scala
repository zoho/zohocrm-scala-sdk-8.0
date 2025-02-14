package com.zoho.crm.api.recordlockingconfiguration

import com.zoho.crm.api.fields.MinifiedField
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class RecordLock extends Model	{
	private var createdTime:Option[OffsetDateTime] = None
	private var lockedFor:Option[String] = None
	private var excludedFields:ArrayBuffer[MinifiedField] = _
	private var createdBy:Option[MinifiedUser] = None
	private var featureType:Option[String] = None
	private var lockingRules:ArrayBuffer[LockingRules] = _
	private var restrictedActions:ArrayBuffer[String] = _
	private var lockForPortalUsers:Option[Boolean] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var restrictedCommunications:ArrayBuffer[String] = _
	private var systemDefined:Option[Boolean] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var id:Option[Long] = None
	private var lockType:Choice[String] = _
	private var restrictedCustomButtons:ArrayBuffer[RestrictedCustomButton] = _
	private var lockExcludedProfiles:ArrayBuffer[LockExcludedProfile] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getLockedFor() :Option[String]	={
		return  this.lockedFor
	}

	def setLockedFor( lockedFor: Option[String]) 	={
		 this.lockedFor = lockedFor
		 this.keyModified("locked_for") = 1
	}

	def getExcludedFields() :ArrayBuffer[MinifiedField]	={
		return  this.excludedFields
	}

	def setExcludedFields( excludedFields: ArrayBuffer[MinifiedField]) 	={
		 this.excludedFields = excludedFields
		 this.keyModified("excluded_fields") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getFeatureType() :Option[String]	={
		return  this.featureType
	}

	def setFeatureType( featureType: Option[String]) 	={
		 this.featureType = featureType
		 this.keyModified("feature_type") = 1
	}

	def getLockingRules() :ArrayBuffer[LockingRules]	={
		return  this.lockingRules
	}

	def setLockingRules( lockingRules: ArrayBuffer[LockingRules]) 	={
		 this.lockingRules = lockingRules
		 this.keyModified("locking_rules") = 1
	}

	def getRestrictedActions() :ArrayBuffer[String]	={
		return  this.restrictedActions
	}

	def setRestrictedActions( restrictedActions: ArrayBuffer[String]) 	={
		 this.restrictedActions = restrictedActions
		 this.keyModified("restricted_actions") = 1
	}

	def getLockForPortalUsers() :Option[Boolean]	={
		return  this.lockForPortalUsers
	}

	def setLockForPortalUsers( lockForPortalUsers: Option[Boolean]) 	={
		 this.lockForPortalUsers = lockForPortalUsers
		 this.keyModified("lock_for_portal_users") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getRestrictedCommunications() :ArrayBuffer[String]	={
		return  this.restrictedCommunications
	}

	def setRestrictedCommunications( restrictedCommunications: ArrayBuffer[String]) 	={
		 this.restrictedCommunications = restrictedCommunications
		 this.keyModified("restricted_communications") = 1
	}

	def getSystemDefined() :Option[Boolean]	={
		return  this.systemDefined
	}

	def setSystemDefined( systemDefined: Option[Boolean]) 	={
		 this.systemDefined = systemDefined
		 this.keyModified("system_defined") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getLockType() :Choice[String]	={
		return  this.lockType
	}

	def setLockType( lockType: Choice[String]) 	={
		 this.lockType = lockType
		 this.keyModified("lock_type") = 1
	}

	def getRestrictedCustomButtons() :ArrayBuffer[RestrictedCustomButton]	={
		return  this.restrictedCustomButtons
	}

	def setRestrictedCustomButtons( restrictedCustomButtons: ArrayBuffer[RestrictedCustomButton]) 	={
		 this.restrictedCustomButtons = restrictedCustomButtons
		 this.keyModified("restricted_custom_buttons") = 1
	}

	def getLockExcludedProfiles() :ArrayBuffer[LockExcludedProfile]	={
		return  this.lockExcludedProfiles
	}

	def setLockExcludedProfiles( lockExcludedProfiles: ArrayBuffer[LockExcludedProfile]) 	={
		 this.lockExcludedProfiles = lockExcludedProfiles
		 this.keyModified("lock_excluded_profiles") = 1
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