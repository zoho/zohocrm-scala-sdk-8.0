package com.zoho.crm.api.ziaenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class OutputData extends Model	{
	private var enrichField:Option[EnrichField] = None
	private var crmField:Option[CrmField] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEnrichField() :Option[EnrichField]	={
		return  this.enrichField
	}

	def setEnrichField( enrichField: Option[EnrichField]) 	={
		 this.enrichField = enrichField
		 this.keyModified("enrich_field") = 1
	}

	def getCrmField() :Option[CrmField]	={
		return  this.crmField
	}

	def setCrmField( crmField: Option[CrmField]) 	={
		 this.crmField = crmField
		 this.keyModified("crm_field") = 1
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