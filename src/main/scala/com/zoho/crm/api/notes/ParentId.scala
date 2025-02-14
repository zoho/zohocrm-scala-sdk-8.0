package com.zoho.crm.api.notes

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ParentId extends Model	{
	private var module:Option[MinifiedModule] = None
	private var id:Option[Long] = None
	private var name:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[MinifiedModule]	={
		return  this.module
	}

	def setModule( module: Option[MinifiedModule]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
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