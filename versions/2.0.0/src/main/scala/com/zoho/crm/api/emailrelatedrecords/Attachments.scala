package com.zoho.crm.api.emailrelatedrecords

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Attachments extends Model	{
	private var size:Option[String] = None
	private var name:Option[String] = None
	private var id:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSize() :Option[String]	={
		return  this.size
	}

	def setSize( size: Option[String]) 	={
		 this.size = size
		 this.keyModified("size") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
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