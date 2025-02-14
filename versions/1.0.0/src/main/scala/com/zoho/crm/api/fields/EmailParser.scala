package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class EmailParser extends Model	{
	private var fieldsUpdateSupported:Option[Boolean] = None
	private var recordOperationsSupported:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFieldsUpdateSupported() :Option[Boolean]	={
		return  this.fieldsUpdateSupported
	}

	def setFieldsUpdateSupported( fieldsUpdateSupported: Option[Boolean]) 	={
		 this.fieldsUpdateSupported = fieldsUpdateSupported
		 this.keyModified("fields_update_supported") = 1
	}

	def getRecordOperationsSupported() :Option[Boolean]	={
		return  this.recordOperationsSupported
	}

	def setRecordOperationsSupported( recordOperationsSupported: Option[Boolean]) 	={
		 this.recordOperationsSupported = recordOperationsSupported
		 this.keyModified("record_operations_supported") = 1
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