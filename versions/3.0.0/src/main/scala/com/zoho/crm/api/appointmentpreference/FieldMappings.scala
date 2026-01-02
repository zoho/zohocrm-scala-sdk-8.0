package com.zoho.crm.api.appointmentpreference

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FieldMappings extends Model	{
	private var type1:Choice[String] = _
	private var value:Option[String] = None
	private var field:Option[Field] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getValue() :Option[String]	={
		return  this.value
	}

	def setValue( value: Option[String]) 	={
		 this.value = value
		 this.keyModified("value") = 1
	}

	def getField() :Option[Field]	={
		return  this.field
	}

	def setField( field: Option[Field]) 	={
		 this.field = field
		 this.keyModified("field") = 1
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