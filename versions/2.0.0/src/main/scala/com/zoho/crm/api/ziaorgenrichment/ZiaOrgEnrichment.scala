package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ZiaOrgEnrichment extends Model	{
	private var enrichedData:Option[EnrichedData] = None
	private var createdTime:Option[String] = None
	private var id:Option[Long] = None
	private var createdBy:Option[User] = None
	private var status:Option[String] = None
	private var enrichBasedOn:Option[EnrichBasedOn] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEnrichedData() :Option[EnrichedData]	={
		return  this.enrichedData
	}

	def setEnrichedData( enrichedData: Option[EnrichedData]) 	={
		 this.enrichedData = enrichedData
		 this.keyModified("enriched_data") = 1
	}

	def getCreatedTime() :Option[String]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[String]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getEnrichBasedOn() :Option[EnrichBasedOn]	={
		return  this.enrichBasedOn
	}

	def setEnrichBasedOn( enrichBasedOn: Option[EnrichBasedOn]) 	={
		 this.enrichBasedOn = enrichBasedOn
		 this.keyModified("enrich_based_on") = 1
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