package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ShowFields extends Model	{
	private var showData:Option[Boolean] = None
	private var field:Option[MinifiedField] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShowData() :Option[Boolean]	={
		return  this.showData
	}

	def setShowData( showData: Option[Boolean]) 	={
		 this.showData = showData
		 this.keyModified("show_data") = 1
	}

	def getField() :Option[MinifiedField]	={
		return  this.field
	}

	def setField( field: Option[MinifiedField]) 	={
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