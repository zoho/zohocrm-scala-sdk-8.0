package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var ziaPeopleEnrichment:ArrayBuffer[ZiaPeopleEnrichment] = _
	private var info:Option[Info] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getZiaPeopleEnrichment() :ArrayBuffer[ZiaPeopleEnrichment]	={
		return  this.ziaPeopleEnrichment
	}

	def setZiaPeopleEnrichment( ziaPeopleEnrichment: ArrayBuffer[ZiaPeopleEnrichment]) 	={
		 this.ziaPeopleEnrichment = ziaPeopleEnrichment
		 this.keyModified("__zia_people_enrichment") = 1
	}

	def getInfo() :Option[Info]	={
		return  this.info
	}

	def setInfo( info: Option[Info]) 	={
		 this.info = info
		 this.keyModified("info") = 1
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