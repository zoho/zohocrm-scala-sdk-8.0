package com.zoho.crm.api.roles

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Role extends Model	{
	private var displayLabel:Option[String] = None
	private var forecastManager:Option[ReportingTo] = None
	private var reportingTo:Option[ReportingTo] = None
	private var shareWithPeers:Option[Boolean] = None
	private var description:Option[String] = None
	private var id:Option[Long] = None
	private var name:Option[String] = None
	private var createdByS:Option[MinifiedUser] = None
	private var modifiedByS:Option[MinifiedUser] = None
	private var modifiedTimeS:Option[OffsetDateTime] = None
	private var createdTimeS:Option[OffsetDateTime] = None
	private var adminUser:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getForecastManager() :Option[ReportingTo]	={
		return  this.forecastManager
	}

	def setForecastManager( forecastManager: Option[ReportingTo]) 	={
		 this.forecastManager = forecastManager
		 this.keyModified("forecast_manager") = 1
	}

	def getReportingTo() :Option[ReportingTo]	={
		return  this.reportingTo
	}

	def setReportingTo( reportingTo: Option[ReportingTo]) 	={
		 this.reportingTo = reportingTo
		 this.keyModified("reporting_to") = 1
	}

	def getShareWithPeers() :Option[Boolean]	={
		return  this.shareWithPeers
	}

	def setShareWithPeers( shareWithPeers: Option[Boolean]) 	={
		 this.shareWithPeers = shareWithPeers
		 this.keyModified("share_with_peers") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getCreatedByS() :Option[MinifiedUser]	={
		return  this.createdByS
	}

	def setCreatedByS( createdByS: Option[MinifiedUser]) 	={
		 this.createdByS = createdByS
		 this.keyModified("created_by__s") = 1
	}

	def getModifiedByS() :Option[MinifiedUser]	={
		return  this.modifiedByS
	}

	def setModifiedByS( modifiedByS: Option[MinifiedUser]) 	={
		 this.modifiedByS = modifiedByS
		 this.keyModified("modified_by__s") = 1
	}

	def getModifiedTimeS() :Option[OffsetDateTime]	={
		return  this.modifiedTimeS
	}

	def setModifiedTimeS( modifiedTimeS: Option[OffsetDateTime]) 	={
		 this.modifiedTimeS = modifiedTimeS
		 this.keyModified("modified_time__s") = 1
	}

	def getCreatedTimeS() :Option[OffsetDateTime]	={
		return  this.createdTimeS
	}

	def setCreatedTimeS( createdTimeS: Option[OffsetDateTime]) 	={
		 this.createdTimeS = createdTimeS
		 this.keyModified("created_time__s") = 1
	}

	def getAdminUser() :Option[Boolean]	={
		return  this.adminUser
	}

	def setAdminUser( adminUser: Option[Boolean]) 	={
		 this.adminUser = adminUser
		 this.keyModified("admin_user") = 1
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