package com.zoho.crm.api.profiles

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class MinifiedProfile extends Model	{
	private var id:Option[Long] = None
	private var name:Option[String] = None
	private var delete:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

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

	def getDelete() :Option[Boolean]	={
		return  this.delete
	}

	def setDelete( delete: Option[Boolean]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
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