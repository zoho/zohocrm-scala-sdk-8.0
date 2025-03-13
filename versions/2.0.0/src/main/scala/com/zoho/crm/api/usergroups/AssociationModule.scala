package com.zoho.crm.api.usergroups

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AssociationModule extends Model	{
	private var module:Option[MinifiedModule] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[MinifiedModule]	={
		return  this.module
	}

	def setModule( module: Option[MinifiedModule]) 	={
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