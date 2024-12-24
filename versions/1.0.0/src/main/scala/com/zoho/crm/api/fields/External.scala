package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class External extends Model	{
	private var show:Option[Boolean] = None
	private var type1:Option[String] = None
	private var allowMultipleConfig:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShow() :Option[Boolean]	={
		return  this.show
	}

	def setShow( show: Option[Boolean]) 	={
		 this.show = show
		 this.keyModified("show") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getAllowMultipleConfig() :Option[Boolean]	={
		return  this.allowMultipleConfig
	}

	def setAllowMultipleConfig( allowMultipleConfig: Option[Boolean]) 	={
		 this.allowMultipleConfig = allowMultipleConfig
		 this.keyModified("allow_multiple_config") = 1
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