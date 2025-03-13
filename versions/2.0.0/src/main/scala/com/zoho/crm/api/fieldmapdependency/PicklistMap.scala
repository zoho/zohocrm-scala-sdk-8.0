package com.zoho.crm.api.fieldmapdependency

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class PicklistMap extends Model	{
	private var id:Option[Long] = None
	private var actualValue:Option[String] = None
	private var displayValue:Option[String] = None
	private var delete:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getActualValue() :Option[String]	={
		return  this.actualValue
	}

	def setActualValue( actualValue: Option[String]) 	={
		 this.actualValue = actualValue
		 this.keyModified("actual_value") = 1
	}

	def getDisplayValue() :Option[String]	={
		return  this.displayValue
	}

	def setDisplayValue( displayValue: Option[String]) 	={
		 this.displayValue = displayValue
		 this.keyModified("display_value") = 1
	}

	def getDelete() :Option[Boolean]	={
		return  this.delete
	}

	def setDelete( delete: Option[Boolean]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
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