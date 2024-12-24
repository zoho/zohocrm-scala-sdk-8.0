package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class OperationType extends Model	{
	private var webUpdate:Option[Boolean] = None
	private var apiCreate:Option[Boolean] = None
	private var webCreate:Option[Boolean] = None
	private var apiUpdate:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getWebUpdate() :Option[Boolean]	={
		return  this.webUpdate
	}

	def setWebUpdate( webUpdate: Option[Boolean]) 	={
		 this.webUpdate = webUpdate
		 this.keyModified("web_update") = 1
	}

	def getAPICreate() :Option[Boolean]	={
		return  this.apiCreate
	}

	def setAPICreate( apiCreate: Option[Boolean]) 	={
		 this.apiCreate = apiCreate
		 this.keyModified("api_create") = 1
	}

	def getWebCreate() :Option[Boolean]	={
		return  this.webCreate
	}

	def setWebCreate( webCreate: Option[Boolean]) 	={
		 this.webCreate = webCreate
		 this.keyModified("web_create") = 1
	}

	def getAPIUpdate() :Option[Boolean]	={
		return  this.apiUpdate
	}

	def setAPIUpdate( apiUpdate: Option[Boolean]) 	={
		 this.apiUpdate = apiUpdate
		 this.keyModified("api_update") = 1
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