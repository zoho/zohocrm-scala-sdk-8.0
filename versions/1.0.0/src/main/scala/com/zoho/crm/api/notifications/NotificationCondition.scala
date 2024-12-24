package com.zoho.crm.api.notifications

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class NotificationCondition extends Model	{
	private var type1:Option[String] = None
	private var module:Option[Module] = None
	private var fieldSelection:Option[Criteria] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getFieldSelection() :Option[Criteria]	={
		return  this.fieldSelection
	}

	def setFieldSelection( fieldSelection: Option[Criteria]) 	={
		 this.fieldSelection = fieldSelection
		 this.keyModified("field_selection") = 1
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