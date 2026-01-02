package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Element extends Model	{
	private var type1:Option[String] = None
	private var resource:Option[Resource] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getResource() :Option[Resource]	={
		return  this.resource
	}

	def setResource( resource: Option[Resource]) 	={
		 this.resource = resource
		 this.keyModified("resource") = 1
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