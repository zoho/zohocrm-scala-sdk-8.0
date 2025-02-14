package com.zoho.crm.api.privacypreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Tpt extends Model	{
	private var isenabled:Option[String] = None
	private var name:Option[String] = None
	private var issupported:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getIsenabled() :Option[String]	={
		return  this.isenabled
	}

	def setIsenabled( isenabled: Option[String]) 	={
		 this.isenabled = isenabled
		 this.keyModified("isEnabled") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getIssupported() :Option[String]	={
		return  this.issupported
	}

	def setIssupported( issupported: Option[String]) 	={
		 this.issupported = issupported
		 this.keyModified("isSupported") = 1
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