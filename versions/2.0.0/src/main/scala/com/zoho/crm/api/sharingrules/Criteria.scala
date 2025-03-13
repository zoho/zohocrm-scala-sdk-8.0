package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Criteria extends Model	{
	private var groupOperator:Option[String] = None
	private var group:ArrayBuffer[Criteria] = _
	private var comparator:Option[String] = None
	private var field:Option[Field] = None
	private var value:Any = None
	private var type1:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getGroupOperator() :Option[String]	={
		return  this.groupOperator
	}

	def setGroupOperator( groupOperator: Option[String]) 	={
		 this.groupOperator = groupOperator
		 this.keyModified("group_operator") = 1
	}

	def getGroup() :ArrayBuffer[Criteria]	={
		return  this.group
	}

	def setGroup( group: ArrayBuffer[Criteria]) 	={
		 this.group = group
		 this.keyModified("group") = 1
	}

	def getComparator() :Option[String]	={
		return  this.comparator
	}

	def setComparator( comparator: Option[String]) 	={
		 this.comparator = comparator
		 this.keyModified("comparator") = 1
	}

	def getField() :Option[Field]	={
		return  this.field
	}

	def setField( field: Option[Field]) 	={
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

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
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