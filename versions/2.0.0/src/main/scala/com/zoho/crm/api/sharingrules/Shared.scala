package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Shared extends Model	{
	private var resource:Option[Resource] = None
	private var subordinates:Option[Boolean] = None
	private var type1:Choice[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getResource() :Option[Resource]	={
		return  this.resource
	}

	def setResource( resource: Option[Resource]) 	={
		 this.resource = resource
		 this.keyModified("resource") = 1
	}

	def getSubordinates() :Option[Boolean]	={
		return  this.subordinates
	}

	def setSubordinates( subordinates: Option[Boolean]) 	={
		 this.subordinates = subordinates
		 this.keyModified("subordinates") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
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