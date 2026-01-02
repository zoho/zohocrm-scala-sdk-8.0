package com.zoho.crm.api.recordlocking

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class LockedForS extends Model	{
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var module:Option[HashMap[String, Any]] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getModule() :Option[HashMap[String, Any]]	={
		return  this.module
	}

	def setModule( module: Option[HashMap[String, Any]]) 	={
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