package com.zoho.crm.api.inventorymassconvert

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ConvertTo extends Model	{
	private var module:Option[Module] = None
	private var carryOverTags:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getCarryOverTags() :Option[Boolean]	={
		return  this.carryOverTags
	}

	def setCarryOverTags( carryOverTags: Option[Boolean]) 	={
		 this.carryOverTags = carryOverTags
		 this.keyModified("carry_over_tags") = 1
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