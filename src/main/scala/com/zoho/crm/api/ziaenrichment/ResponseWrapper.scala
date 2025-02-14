package com.zoho.crm.api.ziaenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var dataEnrichment:ArrayBuffer[DataEnrichment] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDataEnrichment() :ArrayBuffer[DataEnrichment]	={
		return  this.dataEnrichment
	}

	def setDataEnrichment( dataEnrichment: ArrayBuffer[DataEnrichment]) 	={
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