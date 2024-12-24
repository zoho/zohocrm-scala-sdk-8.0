package com.zoho.crm.api.ziaallowedfieldmappings

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ResponseWrapper extends Model	{
	private var allowedFieldMappings:Option[AllowedFieldMap] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAllowedFieldMappings() :Option[AllowedFieldMap]	={
		return  this.allowedFieldMappings
	}

	def setAllowedFieldMappings( allowedFieldMappings: Option[AllowedFieldMap]) 	={
		 this.allowedFieldMappings = allowedFieldMappings
		 this.keyModified("allowed_field_mappings") = 1
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