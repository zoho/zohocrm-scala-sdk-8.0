package com.zoho.crm.api.conversionoption

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class PreferenceFieldMatch extends Model	{
	private var field:Option[Field] = None
	private var matchedLeadValue:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getField() :Option[Field]	={
		return  this.field
	}

	def setField( field: Option[Field]) 	={
		 this.field = field
		 this.keyModified("field") = 1
	}

	def getMatchedLeadValue() :Option[String]	={
		return  this.matchedLeadValue
	}

	def setMatchedLeadValue( matchedLeadValue: Option[String]) 	={
		 this.matchedLeadValue = matchedLeadValue
		 this.keyModified("matched_lead_value") = 1
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