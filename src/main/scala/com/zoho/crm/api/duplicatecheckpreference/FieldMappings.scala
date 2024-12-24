package com.zoho.crm.api.duplicatecheckpreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FieldMappings extends Model	{
	private var currentField:Option[CurrentField] = None
	private var mappedField:Option[MappedField] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCurrentField() :Option[CurrentField]	={
		return  this.currentField
	}

	def setCurrentField( currentField: Option[CurrentField]) 	={
		 this.currentField = currentField
		 this.keyModified("current_field") = 1
	}

	def getMappedField() :Option[MappedField]	={
		return  this.mappedField
	}

	def setMappedField( mappedField: Option[MappedField]) 	={
		 this.mappedField = mappedField
		 this.keyModified("mapped_field") = 1
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