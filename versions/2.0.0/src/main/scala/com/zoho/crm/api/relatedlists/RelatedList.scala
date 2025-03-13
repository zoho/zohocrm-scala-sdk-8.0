package com.zoho.crm.api.relatedlists

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class RelatedList extends Model	{
	private var id:Option[Long] = None
	private var sequenceNumber:Option[String] = None
	private var displayLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var module:Option[ModuleMap] = None
	private var name:Option[String] = None
	private var action:Option[String] = None
	private var href:Option[String] = None
	private var type1:Option[String] = None
	private var connectedmodule:Option[String] = None
	private var linkingmodule:Option[String] = None
	private var visible:Option[Boolean] = None
	private var customizeSort:Option[Boolean] = None
	private var customizeFields:Option[Boolean] = None
	private var customizeDisplayLabel:Option[Boolean] = None
	private var sortBy:Option[Field] = None
	private var sortOrder:Option[String] = None
	private var fields:ArrayBuffer[Field] = _
	private var status:Choice[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getSequenceNumber() :Option[String]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[String]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getModule() :Option[ModuleMap]	={
		return  this.module
	}

	def setModule( module: Option[ModuleMap]) 	={
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

	def getAction() :Option[String]	={
		return  this.action
	}

	def setAction( action: Option[String]) 	={
		 this.action = action
		 this.keyModified("action") = 1
	}

	def getHref() :Option[String]	={
		return  this.href
	}

	def setHref( href: Option[String]) 	={
		 this.href = href
		 this.keyModified("href") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getConnectedmodule() :Option[String]	={
		return  this.connectedmodule
	}

	def setConnectedmodule( connectedmodule: Option[String]) 	={
		 this.connectedmodule = connectedmodule
		 this.keyModified("connectedmodule") = 1
	}

	def getLinkingmodule() :Option[String]	={
		return  this.linkingmodule
	}

	def setLinkingmodule( linkingmodule: Option[String]) 	={
		 this.linkingmodule = linkingmodule
		 this.keyModified("linkingmodule") = 1
	}

	def getVisible() :Option[Boolean]	={
		return  this.visible
	}

	def setVisible( visible: Option[Boolean]) 	={
		 this.visible = visible
		 this.keyModified("visible") = 1
	}

	def getCustomizeSort() :Option[Boolean]	={
		return  this.customizeSort
	}

	def setCustomizeSort( customizeSort: Option[Boolean]) 	={
		 this.customizeSort = customizeSort
		 this.keyModified("customize_sort") = 1
	}

	def getCustomizeFields() :Option[Boolean]	={
		return  this.customizeFields
	}

	def setCustomizeFields( customizeFields: Option[Boolean]) 	={
		 this.customizeFields = customizeFields
		 this.keyModified("customize_fields") = 1
	}

	def getCustomizeDisplayLabel() :Option[Boolean]	={
		return  this.customizeDisplayLabel
	}

	def setCustomizeDisplayLabel( customizeDisplayLabel: Option[Boolean]) 	={
		 this.customizeDisplayLabel = customizeDisplayLabel
		 this.keyModified("customize_display_label") = 1
	}

	def getSortBy() :Option[Field]	={
		return  this.sortBy
	}

	def setSortBy( sortBy: Option[Field]) 	={
		 this.sortBy = sortBy
		 this.keyModified("sort_by") = 1
	}

	def getSortOrder() :Option[String]	={
		return  this.sortOrder
	}

	def setSortOrder( sortOrder: Option[String]) 	={
		 this.sortOrder = sortOrder
		 this.keyModified("sort_order") = 1
	}

	def getFields() :ArrayBuffer[Field]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[Field]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	def getStatus() :Choice[String]	={
		return  this.status
	}

	def setStatus( status: Choice[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
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