package com.zoho.crm.api.portalusertype

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Layouts extends Model	{
	private var displayLabel:Option[String] = None
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var defaultview:Option[Views] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getDefaultview() :Option[Views]	={
		return  this.defaultview
	}

	def setDefaultview( defaultview: Option[Views]) 	={
		 this.defaultview = defaultview
		 this.keyModified("_default_view") = 1
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