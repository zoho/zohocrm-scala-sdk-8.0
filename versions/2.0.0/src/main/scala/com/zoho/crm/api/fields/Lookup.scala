package com.zoho.crm.api.fields

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Lookup extends Model	{
	private var displayLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var queryDetails:Option[QueryDetails] = None
	private var module:Option[MinifiedModule] = None
	private var id:Option[Long] = None
	private var revalidateFilterDuringEdit:Option[Boolean] = None
	private var showFields:ArrayBuffer[ShowFields] = _
	private var keyModified:HashMap[String, Int] = HashMap()

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

	def getQueryDetails() :Option[QueryDetails]	={
		return  this.queryDetails
	}

	def setQueryDetails( queryDetails: Option[QueryDetails]) 	={
		 this.queryDetails = queryDetails
		 this.keyModified("query_details") = 1
	}

	def getModule() :Option[MinifiedModule]	={
		return  this.module
	}

	def setModule( module: Option[MinifiedModule]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getRevalidateFilterDuringEdit() :Option[Boolean]	={
		return  this.revalidateFilterDuringEdit
	}

	def setRevalidateFilterDuringEdit( revalidateFilterDuringEdit: Option[Boolean]) 	={
		 this.revalidateFilterDuringEdit = revalidateFilterDuringEdit
		 this.keyModified("revalidate_filter_during_edit") = 1
	}

	def getShowFields() :ArrayBuffer[ShowFields]	={
		return  this.showFields
	}

	def setShowFields( showFields: ArrayBuffer[ShowFields]) 	={
		 this.showFields = showFields
		 this.keyModified("show_fields") = 1
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