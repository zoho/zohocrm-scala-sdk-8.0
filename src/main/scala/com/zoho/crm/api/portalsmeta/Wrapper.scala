package com.zoho.crm.api.portalsmeta

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Wrapper extends Model	{
	private var relatedLists:ArrayBuffer[RelatedLists] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRelatedLists() :ArrayBuffer[RelatedLists]	={
		return  this.relatedLists
	}

	def setRelatedLists( relatedLists: ArrayBuffer[RelatedLists]) 	={
		 this.relatedLists = relatedLists
		 this.keyModified("related_lists") = 1
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