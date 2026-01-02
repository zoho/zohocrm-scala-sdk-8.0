package com.zoho.crm.api.fields

import com.zoho.crm.api.layouts.Layouts
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class HistoryTrackingModule extends Model	{
	private var layout:Option[Layouts] = None
	private var displayLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var module:Option[HistoryTrackingModule] = None
	private var id:Option[Long] = None
	private var moduleName:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLayout() :Option[Layouts]	={
		return  this.layout
	}

	def setLayout( layout: Option[Layouts]) 	={
		 this.layout = layout
		 this.keyModified("layout") = 1
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

	def getModule() :Option[HistoryTrackingModule]	={
		return  this.module
	}

	def setModule( module: Option[HistoryTrackingModule]) 	={
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

	def getModuleName() :Option[String]	={
		return  this.moduleName
	}

	def setModuleName( moduleName: Option[String]) 	={
		 this.moduleName = moduleName
		 this.keyModified("module_name") = 1
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