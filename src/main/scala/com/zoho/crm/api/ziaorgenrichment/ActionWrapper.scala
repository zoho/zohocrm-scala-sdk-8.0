package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var ziaOrgEnrichment:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getZiaOrgEnrichment() :ArrayBuffer[ActionResponse]	={
		return  this.ziaOrgEnrichment
	}

	def setZiaOrgEnrichment( ziaOrgEnrichment: ArrayBuffer[ActionResponse]) 	={
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