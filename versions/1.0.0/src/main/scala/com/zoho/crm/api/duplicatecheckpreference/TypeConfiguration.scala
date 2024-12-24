package com.zoho.crm.api.duplicatecheckpreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class TypeConfiguration extends Model	{
	private var fieldMappings:ArrayBuffer[FieldMappings] = _
	private var mappedModule:Option[MappedModule] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFieldMappings() :ArrayBuffer[FieldMappings]	={
		return  this.fieldMappings
	}

	def setFieldMappings( fieldMappings: ArrayBuffer[FieldMappings]) 	={
		 this.fieldMappings = fieldMappings
		 this.keyModified("field_mappings") = 1
	}

	def getMappedModule() :Option[MappedModule]	={
		return  this.mappedModule
	}

	def setMappedModule( mappedModule: Option[MappedModule]) 	={
		 this.mappedModule = mappedModule
		 this.keyModified("mapped_module") = 1
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