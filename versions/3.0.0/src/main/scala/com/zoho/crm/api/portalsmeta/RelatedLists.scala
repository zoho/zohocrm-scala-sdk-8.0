package com.zoho.crm.api.portalsmeta

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class RelatedLists extends Model	{
	private var module:Option[Modules] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[Modules]	={
		return  this.module
	}

	def setModule( module: Option[Modules]) 	={
		 this.module = module
		 this.keyModified("module") = 1
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