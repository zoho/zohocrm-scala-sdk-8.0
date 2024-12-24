package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class RollupCriteria extends Model	{
	private var comparator:Option[String] = None
	private var field:Option[MinifiedField] = None
	private var value:Any = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getComparator() :Option[String]	={
		return  this.comparator
	}

	def setComparator( comparator: Option[String]) 	={
		 this.comparator = comparator
		 this.keyModified("comparator") = 1
	}

	def getField() :Option[MinifiedField]	={
		return  this.field
	}

	def setField( field: Option[MinifiedField]) 	={
		 this.field = field
		 this.keyModified("field") = 1
	}

	def getValue() :Any	={
		return  this.value
	}

	def setValue( value: Any) 	={
		 this.value = value
		 this.keyModified("value") = 1
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