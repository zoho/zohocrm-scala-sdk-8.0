package com.zoho.crm.api.businesshours

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Features extends Model	{
	private var name:Option[String] = None
	private var resources:ArrayBuffer[Resources] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getResources() :ArrayBuffer[Resources]	={
		return  this.resources
	}

	def setResources( resources: ArrayBuffer[Resources]) 	={
		 this.resources = resources
		 this.keyModified("resources") = 1
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