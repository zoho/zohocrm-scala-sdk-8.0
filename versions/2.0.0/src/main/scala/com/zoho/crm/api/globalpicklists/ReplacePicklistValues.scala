package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ReplacePicklistValues extends Model	{
	private var newValue:Option[ReplacePicklistValue] = None
	private var oldValue:Option[ReplacePicklistValue] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getNewValue() :Option[ReplacePicklistValue]	={
		return  this.newValue
	}

	def setNewValue( newValue: Option[ReplacePicklistValue]) 	={
		 this.newValue = newValue
		 this.keyModified("new_value") = 1
	}

	def getOldValue() :Option[ReplacePicklistValue]	={
		return  this.oldValue
	}

	def setOldValue( oldValue: Option[ReplacePicklistValue]) 	={
		 this.oldValue = oldValue
		 this.keyModified("old_value") = 1
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