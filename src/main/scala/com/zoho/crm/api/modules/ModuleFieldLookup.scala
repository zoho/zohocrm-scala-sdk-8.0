package com.zoho.crm.api.modules

import com.zoho.crm.api.fields.Lookup
import com.zoho.crm.api.fields.QueryDetails
import com.zoho.crm.api.fields.ShowFields
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ModuleFieldLookup extends Lookup with Model	{
	private var queryDetails:Option[QueryDetails] = None
	private var module:Option[MinifiedModule] = None
	private var displayLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var id:Option[Long] = None
	private var revalidateFilterDuringEdit:Option[Boolean] = None
	private var showFields:ArrayBuffer[ShowFields] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	override def getQueryDetails() :Option[QueryDetails]	={
		return  this.queryDetails
	}

	override def setQueryDetails( queryDetails: Option[QueryDetails]) 	={
		 this.queryDetails = queryDetails
		 this.keyModified("query_details") = 1
	}

	override def getModule() :Option[MinifiedModule]	={
		return  this.module
	}

	override def setModule( module: Option[MinifiedModule]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	override def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	override def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	override def getAPIName() :Option[String]	={
		return  this.apiName
	}

	override def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	override def getId() :Option[Long]	={
		return  this.id
	}

	override def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	override def getRevalidateFilterDuringEdit() :Option[Boolean]	={
		return  this.revalidateFilterDuringEdit
	}

	override def setRevalidateFilterDuringEdit( revalidateFilterDuringEdit: Option[Boolean]) 	={
		 this.revalidateFilterDuringEdit = revalidateFilterDuringEdit
		 this.keyModified("revalidate_filter_during_edit") = 1
	}

	override def getShowFields() :ArrayBuffer[ShowFields]	={
		return  this.showFields
	}

	override def setShowFields( showFields: ArrayBuffer[ShowFields]) 	={
		 this.showFields = showFields
		 this.keyModified("show_fields") = 1
	}

	override def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	override def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}