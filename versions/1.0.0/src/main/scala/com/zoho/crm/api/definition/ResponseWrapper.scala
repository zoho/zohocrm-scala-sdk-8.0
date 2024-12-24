package com.zoho.crm.api.definition

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ResponseWrapper extends Model	{
	private var definition:Option[Definition] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDefinition() :Option[Definition]	={
		return  this.definition
	}

	def setDefinition( definition: Option[Definition]) 	={
		 this.definition = definition
		 this.keyModified("definition") = 1
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