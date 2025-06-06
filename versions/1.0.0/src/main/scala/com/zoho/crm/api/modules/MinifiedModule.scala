package com.zoho.crm.api.modules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class MinifiedModule extends Model	{
	private var apiName:Option[String] = None
	private var id:Option[Long] = None
	private var moduleName:Option[String] = None
	private var module:Option[String] = None
	private var crypt:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getModuleName() :Option[String]	={
		return  this.moduleName
	}

	def setModuleName( moduleName: Option[String]) 	={
		 this.moduleName = moduleName
		 this.keyModified("module_name") = 1
	}

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getCrypt() :Option[Boolean]	={
		return  this.crypt
	}

	def setCrypt( crypt: Option[Boolean]) 	={
		 this.crypt = crypt
		 this.keyModified("crypt") = 1
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