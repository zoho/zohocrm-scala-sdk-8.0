package com.zoho.crm.api.inventorymassconvert

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var convertTo:ArrayBuffer[ConvertTo] = _
	private var assignTo:Option[User] = None
	private var relatedModules:ArrayBuffer[RelatedModules] = _
	private var ids:ArrayBuffer[Long] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getConvertTo() :ArrayBuffer[ConvertTo]	={
		return  this.convertTo
	}

	def setConvertTo( convertTo: ArrayBuffer[ConvertTo]) 	={
		 this.convertTo = convertTo
		 this.keyModified("convert_to") = 1
	}

	def getAssignTo() :Option[User]	={
		return  this.assignTo
	}

	def setAssignTo( assignTo: Option[User]) 	={
		 this.assignTo = assignTo
		 this.keyModified("assign_to") = 1
	}

	def getRelatedModules() :ArrayBuffer[RelatedModules]	={
		return  this.relatedModules
	}

	def setRelatedModules( relatedModules: ArrayBuffer[RelatedModules]) 	={
		 this.relatedModules = relatedModules
		 this.keyModified("related_modules") = 1
	}

	def getIds() :ArrayBuffer[Long]	={
		return  this.ids
	}

	def setIds( ids: ArrayBuffer[Long]) 	={
		 this.ids = ids
		 this.keyModified("ids") = 1
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