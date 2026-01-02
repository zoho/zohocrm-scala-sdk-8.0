package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Private extends Model	{
	private var restricted:Option[Boolean] = None
	private var type1:Option[String] = None
	private var export1:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRestricted() :Option[Boolean]	={
		return  this.restricted
	}

	def setRestricted( restricted: Option[Boolean]) 	={
		 this.restricted = restricted
		 this.keyModified("restricted") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getExport() :Option[Boolean]	={
		return  this.export1
	}

	def setExport( export1: Option[Boolean]) 	={
		 this.export1 = export1
		 this.keyModified("export") = 1
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