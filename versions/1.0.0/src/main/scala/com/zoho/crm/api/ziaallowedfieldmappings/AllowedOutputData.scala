package com.zoho.crm.api.ziaallowedfieldmappings

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AllowedOutputData extends Model	{
	private var enrichField:Option[EnrichField] = None
	private var crmFields:ArrayBuffer[CrmField] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEnrichField() :Option[EnrichField]	={
		return  this.enrichField
	}

	def setEnrichField( enrichField: Option[EnrichField]) 	={
		 this.enrichField = enrichField
		 this.keyModified("enrich_field") = 1
	}

	def getCrmFields() :ArrayBuffer[CrmField]	={
		return  this.crmFields
	}

	def setCrmFields( crmFields: ArrayBuffer[CrmField]) 	={
		 this.crmFields = crmFields
		 this.keyModified("crm_fields") = 1
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