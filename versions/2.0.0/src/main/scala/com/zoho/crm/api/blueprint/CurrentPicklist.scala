package com.zoho.crm.api.blueprint

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class CurrentPicklist extends Model	{
	private var colourCode:Option[String] = None
	private var id:Option[String] = None
	private var value:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getColourCode() :Option[String]	={
		return  this.colourCode
	}

	def setColourCode( colourCode: Option[String]) 	={
		 this.colourCode = colourCode
		 this.keyModified("colour_code") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getValue() :Option[String]	={
		return  this.value
	}

	def setValue( value: Option[String]) 	={
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