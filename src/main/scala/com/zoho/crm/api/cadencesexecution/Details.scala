package com.zoho.crm.api.cadencesexecution

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Details extends Model	{
	private var name:Option[String] = None
	private var template:Option[Template] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getTemplate() :Option[Template]	={
		return  this.template
	}

	def setTemplate( template: Option[Template]) 	={
		 this.template = template
		 this.keyModified("template") = 1
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