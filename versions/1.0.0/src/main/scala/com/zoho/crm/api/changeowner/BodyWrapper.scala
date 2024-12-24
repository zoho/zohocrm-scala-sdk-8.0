package com.zoho.crm.api.changeowner

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var owner:Option[Owner] = None
	private var notify1:Option[Boolean] = None
	private var relatedModules:ArrayBuffer[RelatedModules] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOwner() :Option[Owner]	={
		return  this.owner
	}

	def setOwner( owner: Option[Owner]) 	={
		 this.owner = owner
		 this.keyModified("owner") = 1
	}

	def getNotify() :Option[Boolean]	={
		return  this.notify1
	}

	def setNotify( notify1: Option[Boolean]) 	={
		 this.notify1 = notify1
		 this.keyModified("notify") = 1
	}

	def getRelatedModules() :ArrayBuffer[RelatedModules]	={
		return  this.relatedModules
	}

	def setRelatedModules( relatedModules: ArrayBuffer[RelatedModules]) 	={
		 this.relatedModules = relatedModules
		 this.keyModified("related_modules") = 1
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