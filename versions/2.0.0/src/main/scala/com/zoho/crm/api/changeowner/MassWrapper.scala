package com.zoho.crm.api.changeowner

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MassWrapper extends BodyWrapper with Model	{
	private var ids:ArrayBuffer[Long] = _
	private var owner:Option[Owner] = None
	private var notify1:Option[Boolean] = None
	private var relatedModules:ArrayBuffer[RelatedModules] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getIds() :ArrayBuffer[Long]	={
		return  this.ids
	}

	def setIds( ids: ArrayBuffer[Long]) 	={
		 this.ids = ids
		 this.keyModified("ids") = 1
	}

	override def getOwner() :Option[Owner]	={
		return  this.owner
	}

	override def setOwner( owner: Option[Owner]) 	={
		 this.owner = owner
		 this.keyModified("owner") = 1
	}

	override def getNotify() :Option[Boolean]	={
		return  this.notify1
	}

	override def setNotify( notify1: Option[Boolean]) 	={
		 this.notify1 = notify1
		 this.keyModified("notify") = 1
	}

	override def getRelatedModules() :ArrayBuffer[RelatedModules]	={
		return  this.relatedModules
	}

	override def setRelatedModules( relatedModules: ArrayBuffer[RelatedModules]) 	={
		 this.relatedModules = relatedModules
		 this.keyModified("related_modules") = 1
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