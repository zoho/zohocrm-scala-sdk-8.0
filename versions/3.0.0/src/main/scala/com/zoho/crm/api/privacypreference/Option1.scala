package com.zoho.crm.api.privacypreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Option1 extends Model	{
	private var name:Option[String] = None
	private var tooltip:Option[String] = None
	private var type1:Option[String] = None
	private var suboptions:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getTooltip() :Option[String]	={
		return  this.tooltip
	}

	def setTooltip( tooltip: Option[String]) 	={
		 this.tooltip = tooltip
		 this.keyModified("tooltip") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getSuboptions() :ArrayBuffer[String]	={
		return  this.suboptions
	}

	def setSuboptions( suboptions: ArrayBuffer[String]) 	={
		 this.suboptions = suboptions
		 this.keyModified("suboptions") = 1
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