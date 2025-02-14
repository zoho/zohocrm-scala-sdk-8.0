package com.zoho.crm.api.appointmentpreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class DealRecordConfiguration extends Model	{
	private var layout:Option[Layout] = None
	private var fieldMappings:ArrayBuffer[FieldMappings] = _
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLayout() :Option[Layout]	={
		return  this.layout
	}

	def setLayout( layout: Option[Layout]) 	={
		 this.layout = layout
		 this.keyModified("layout") = 1
	}

	def getFieldMappings() :ArrayBuffer[FieldMappings]	={
		return  this.fieldMappings
	}

	def setFieldMappings( fieldMappings: ArrayBuffer[FieldMappings]) 	={
		 this.fieldMappings = fieldMappings
		 this.keyModified("field_mappings") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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