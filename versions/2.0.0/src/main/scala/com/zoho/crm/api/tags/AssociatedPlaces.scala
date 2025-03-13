package com.zoho.crm.api.tags

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AssociatedPlaces extends Model	{
	private var type1:Option[String] = None
	private var resources:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getResources() :ArrayBuffer[String]	={
		return  this.resources
	}

	def setResources( resources: ArrayBuffer[String]) 	={
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