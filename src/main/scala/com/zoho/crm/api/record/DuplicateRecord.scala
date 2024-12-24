package com.zoho.crm.api.record

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DuplicateRecord extends Model	{
	private var owner:Option[MinifiedUser] = None
	private var module:Option[MinifiedModule] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOwner() :Option[MinifiedUser]	={
		return  this.owner
	}

	def setOwner( owner: Option[MinifiedUser]) 	={
		 this.owner = owner
		 this.keyModified("Owner") = 1
	}

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