package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Picklist extends Model	{
	private var displayLabel:Option[String] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var id:Option[Long] = None
	private var apiName:Option[String] = None
	private var actualLabel:Option[String] = None
	private var description:Option[String] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var createdBy:Option[MinifiedUser] = None
	private var presence:Option[Boolean] = None
	private var pickListValuesSortedLexically:Option[Boolean] = None
	private var pickListValues:ArrayBuffer[PickListValues] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
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

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getActualLabel() :Option[String]	={
		return  this.actualLabel
	}

	def setActualLabel( actualLabel: Option[String]) 	={
		 this.actualLabel = actualLabel
		 this.keyModified("actual_label") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getPresence() :Option[Boolean]	={
		return  this.presence
	}

	def setPresence( presence: Option[Boolean]) 	={
		 this.presence = presence
		 this.keyModified("presence") = 1
	}

	def getPickListValuesSortedLexically() :Option[Boolean]	={
		return  this.pickListValuesSortedLexically
	}

	def setPickListValuesSortedLexically( pickListValuesSortedLexically: Option[Boolean]) 	={
		 this.pickListValuesSortedLexically = pickListValuesSortedLexically
		 this.keyModified("pick_list_values_sorted_lexically") = 1
	}

	def getPickListValues() :ArrayBuffer[PickListValues]	={
		return  this.pickListValues
	}

	def setPickListValues( pickListValues: ArrayBuffer[PickListValues]) 	={
		 this.pickListValues = pickListValues
		 this.keyModified("pick_list_values") = 1
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