package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DealField extends Model	{
	private var apiName:Option[String] = None
	private var fieldLabel:Option[String] = None
	private var id:Option[Long] = None
	private var required:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getFieldLabel() :Option[String]	={
		return  this.fieldLabel
	}

	def setFieldLabel( fieldLabel: Option[String]) 	={
		 this.fieldLabel = fieldLabel
		 this.keyModified("field_label") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getRequired() :Option[Boolean]	={
		return  this.required
	}

	def setRequired( required: Option[Boolean]) 	={
		 this.required = required
		 this.keyModified("required") = 1
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