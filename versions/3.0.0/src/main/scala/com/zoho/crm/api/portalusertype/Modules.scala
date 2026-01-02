package com.zoho.crm.api.portalusertype

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Modules extends Model	{
	private var id:Option[Long] = None
	private var pluralLabel:Option[String] = None
	private var sharedType:Option[String] = None
	private var apiName:Option[String] = None
	private var filters:ArrayBuffer[Filters] = _
	private var fields:ArrayBuffer[Fields] = _
	private var layouts:ArrayBuffer[Layouts] = _
	private var views:Option[Views] = None
	private var permissions:Option[Permissions] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getPluralLabel() :Option[String]	={
		return  this.pluralLabel
	}

	def setPluralLabel( pluralLabel: Option[String]) 	={
		 this.pluralLabel = pluralLabel
		 this.keyModified("plural_label") = 1
	}

	def getSharedType() :Option[String]	={
		return  this.sharedType
	}

	def setSharedType( sharedType: Option[String]) 	={
		 this.sharedType = sharedType
		 this.keyModified("shared_type") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getFilters() :ArrayBuffer[Filters]	={
		return  this.filters
	}

	def setFilters( filters: ArrayBuffer[Filters]) 	={
		 this.filters = filters
		 this.keyModified("filters") = 1
	}

	def getFields() :ArrayBuffer[Fields]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[Fields]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	def getLayouts() :ArrayBuffer[Layouts]	={
		return  this.layouts
	}

	def setLayouts( layouts: ArrayBuffer[Layouts]) 	={
		 this.layouts = layouts
		 this.keyModified("layouts") = 1
	}

	def getViews() :Option[Views]	={
		return  this.views
	}

	def setViews( views: Option[Views]) 	={
		 this.views = views
		 this.keyModified("views") = 1
	}

	def getPermissions() :Option[Permissions]	={
		return  this.permissions
	}

	def setPermissions( permissions: Option[Permissions]) 	={
		 this.permissions = permissions
		 this.keyModified("permissions") = 1
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