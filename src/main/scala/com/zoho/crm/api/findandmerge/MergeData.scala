package com.zoho.crm.api.findandmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MergeData extends Model	{
	private var fields:ArrayBuffer[DataFields] = _
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFields() :ArrayBuffer[DataFields]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[DataFields]) 	={
		 this.fields = fields
		 this.keyModified("_fields") = 1
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