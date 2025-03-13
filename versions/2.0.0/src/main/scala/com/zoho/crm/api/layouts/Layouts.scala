package com.zoho.crm.api.layouts

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Layouts extends Model	{
	private var displayType:Option[Int] = None
	private var apiName:Option[String] = None
	private var hasMoreProfiles:Option[Boolean] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var visible:Option[Boolean] = None
	private var source:Option[String] = None
	private var id:Option[Long] = None
	private var name:Option[String] = None
	private var displayLabel:Option[String] = None
	private var mode:Option[String] = None
	private var subformProperties:Option[SubformProperty] = None
	private var status:Option[String] = None
	private var showBusinessCard:Option[Boolean] = None
	private var generatedType:Option[String] = None
	private var createdFor:Option[MinifiedUser] = None
	private var convertMapping:Option[ConvertMapping] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var profiles:ArrayBuffer[Profiles] = _
	private var createdBy:Option[MinifiedUser] = None
	private var sections:ArrayBuffer[Sections] = _
	private var actionsAllowed:Option[ActionsAllowed] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayType() :Option[Int]	={
		return  this.displayType
	}

	def setDisplayType( displayType: Option[Int]) 	={
		 this.displayType = displayType
		 this.keyModified("display_type") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getHasMoreProfiles() :Option[Boolean]	={
		return  this.hasMoreProfiles
	}

	def setHasMoreProfiles( hasMoreProfiles: Option[Boolean]) 	={
		 this.hasMoreProfiles = hasMoreProfiles
		 this.keyModified("has_more_profiles") = 1
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

	def getVisible() :Option[Boolean]	={
		return  this.visible
	}

	def setVisible( visible: Option[Boolean]) 	={
		 this.visible = visible
		 this.keyModified("visible") = 1
	}

	def getSource() :Option[String]	={
		return  this.source
	}

	def setSource( source: Option[String]) 	={
		 this.source = source
		 this.keyModified("source") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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

	def getMode() :Option[String]	={
		return  this.mode
	}

	def setMode( mode: Option[String]) 	={
		 this.mode = mode
		 this.keyModified("mode") = 1
	}

	def getSubformProperties() :Option[SubformProperty]	={
		return  this.subformProperties
	}

	def setSubformProperties( subformProperties: Option[SubformProperty]) 	={
		 this.subformProperties = subformProperties
		 this.keyModified("subform_properties") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getShowBusinessCard() :Option[Boolean]	={
		return  this.showBusinessCard
	}

	def setShowBusinessCard( showBusinessCard: Option[Boolean]) 	={
		 this.showBusinessCard = showBusinessCard
		 this.keyModified("show_business_card") = 1
	}

	def getGeneratedType() :Option[String]	={
		return  this.generatedType
	}

	def setGeneratedType( generatedType: Option[String]) 	={
		 this.generatedType = generatedType
		 this.keyModified("generated_type") = 1
	}

	def getCreatedFor() :Option[MinifiedUser]	={
		return  this.createdFor
	}

	def setCreatedFor( createdFor: Option[MinifiedUser]) 	={
		 this.createdFor = createdFor
		 this.keyModified("created_for") = 1
	}

	def getConvertMapping() :Option[ConvertMapping]	={
		return  this.convertMapping
	}

	def setConvertMapping( convertMapping: Option[ConvertMapping]) 	={
		 this.convertMapping = convertMapping
		 this.keyModified("convert_mapping") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getProfiles() :ArrayBuffer[Profiles]	={
		return  this.profiles
	}

	def setProfiles( profiles: ArrayBuffer[Profiles]) 	={
		 this.profiles = profiles
		 this.keyModified("profiles") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getSections() :ArrayBuffer[Sections]	={
		return  this.sections
	}

	def setSections( sections: ArrayBuffer[Sections]) 	={
		 this.sections = sections
		 this.keyModified("sections") = 1
	}

	def getActionsAllowed() :Option[ActionsAllowed]	={
		return  this.actionsAllowed
	}

	def setActionsAllowed( actionsAllowed: Option[ActionsAllowed]) 	={
		 this.actionsAllowed = actionsAllowed
		 this.keyModified("actions_allowed") = 1
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