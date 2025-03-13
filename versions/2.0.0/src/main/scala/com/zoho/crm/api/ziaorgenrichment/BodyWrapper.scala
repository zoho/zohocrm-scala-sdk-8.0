package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var ziaOrgEnrichment:ArrayBuffer[ZiaOrgEnrichment] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getZiaOrgEnrichment() :ArrayBuffer[ZiaOrgEnrichment]	={
		return  this.ziaOrgEnrichment
	}

	def setZiaOrgEnrichment( ziaOrgEnrichment: ArrayBuffer[ZiaOrgEnrichment]) 	={
		 this.ziaOrgEnrichment = ziaOrgEnrichment
		 this.keyModified("__zia_org_enrichment") = 1
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