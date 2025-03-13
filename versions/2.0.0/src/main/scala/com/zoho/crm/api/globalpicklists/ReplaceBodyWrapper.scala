package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ReplaceBodyWrapper extends Model	{
	private var replacePicklistValues:ArrayBuffer[ReplacePicklistValues] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getReplacePicklistValues() :ArrayBuffer[ReplacePicklistValues]	={
		return  this.replacePicklistValues
	}

	def setReplacePicklistValues( replacePicklistValues: ArrayBuffer[ReplacePicklistValues]) 	={
		 this.replacePicklistValues = replacePicklistValues
		 this.keyModified("replace_picklist_values") = 1
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