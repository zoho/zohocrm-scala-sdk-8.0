package com.zoho.crm.api.signalsnotifications

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Action extends Model	{
	private var type1:Option[String] = None
	private var openIn:Option[String] = None
	private var displayName:Option[String] = None
	private var url:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getOpenIn() :Option[String]	={
		return  this.openIn
	}

	def setOpenIn( openIn: Option[String]) 	={
		 this.openIn = openIn
		 this.keyModified("open_in") = 1
	}

	def getDisplayName() :Option[String]	={
		return  this.displayName
	}

	def setDisplayName( displayName: Option[String]) 	={
		 this.displayName = displayName
		 this.keyModified("display_name") = 1
	}

	def getUrl() :Option[String]	={
		return  this.url
	}

	def setUrl( url: Option[String]) 	={
		 this.url = url
		 this.keyModified("url") = 1
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