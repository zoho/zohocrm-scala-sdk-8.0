package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class DealLayoutMapping extends MinifiedLayout with Model	{
	private var fields:ArrayBuffer[DealField] = _
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFields() :ArrayBuffer[DealField]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[DealField]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	override def getName() :Option[String]	={
		return  this.name
	}

	override def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	override def getId() :Option[Long]	={
		return  this.id
	}

	override def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	override def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	override def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}