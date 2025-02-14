package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Module extends Model	{
	private var pluralLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPluralLabel() :Option[String]	={
		return  this.pluralLabel
	}

	def setPluralLabel( pluralLabel: Option[String]) 	={
		 this.pluralLabel = pluralLabel
		 this.keyModified("plural_label") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
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