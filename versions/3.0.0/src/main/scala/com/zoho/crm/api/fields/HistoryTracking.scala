package com.zoho.crm.api.fields

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class HistoryTracking extends Model	{
	private var relatedListName:Option[String] = None
	private var durationConfiguration:Choice[String] = _
	private var followedFields:ArrayBuffer[MinifiedField] = _
	private var module:Option[HistoryTrackingModule] = None
	private var durationConfiguredField:Option[MinifiedModule] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRelatedListName() :Option[String]	={
		return  this.relatedListName
	}

	def setRelatedListName( relatedListName: Option[String]) 	={
		 this.relatedListName = relatedListName
		 this.keyModified("related_list_name") = 1
	}

	def getDurationConfiguration() :Choice[String]	={
		return  this.durationConfiguration
	}

	def setDurationConfiguration( durationConfiguration: Choice[String]) 	={
		 this.durationConfiguration = durationConfiguration
		 this.keyModified("duration_configuration") = 1
	}

	def getFollowedFields() :ArrayBuffer[MinifiedField]	={
		return  this.followedFields
	}

	def setFollowedFields( followedFields: ArrayBuffer[MinifiedField]) 	={
		 this.followedFields = followedFields
		 this.keyModified("followed_fields") = 1
	}

	def getModule() :Option[HistoryTrackingModule]	={
		return  this.module
	}

	def setModule( module: Option[HistoryTrackingModule]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getDurationConfiguredField() :Option[MinifiedModule]	={
		return  this.durationConfiguredField
	}

	def setDurationConfiguredField( durationConfiguredField: Option[MinifiedModule]) 	={
		 this.durationConfiguredField = durationConfiguredField
		 this.keyModified("duration_configured_field") = 1
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