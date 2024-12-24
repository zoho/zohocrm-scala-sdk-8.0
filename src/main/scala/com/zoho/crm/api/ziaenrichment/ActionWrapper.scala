package com.zoho.crm.api.ziaenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model	{
	private var dataEnrichment:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDataEnrichment() :ArrayBuffer[ActionResponse]	={
		return  this.dataEnrichment
	}

	def setDataEnrichment( dataEnrichment: ArrayBuffer[ActionResponse]) 	={
		 this.dataEnrichment = dataEnrichment
		 this.keyModified("data_enrichment") = 1
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