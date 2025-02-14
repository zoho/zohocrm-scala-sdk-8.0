package com.zoho.crm.api.portalinvite

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Portal extends Model	{
	private var id:Option[Long] = None
	private var userTypeId:Option[Long] = None
	private var type1:Choice[String] = _
	private var language:Choice[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getUserTypeId() :Option[Long]	={
		return  this.userTypeId
	}

	def setUserTypeId( userTypeId: Option[Long]) 	={
		 this.userTypeId = userTypeId
		 this.keyModified("user_type_id") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getLanguage() :Choice[String]	={
		return  this.language
	}

	def setLanguage( language: Choice[String]) 	={
		 this.language = language
		 this.keyModified("language") = 1
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