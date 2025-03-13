package com.zoho.crm.api.hipaacompliance

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class HipaaCompliance extends Model	{
	private var enabled:Option[Boolean] = None
	private var enabledForModules:ArrayBuffer[Modules] = _
	private var restrictToZohoApps:Option[Boolean] = None
	private var restrictDataAccessThroughAPI:Option[Boolean] = None
	private var restrictDataInExport:Option[Boolean] = None
	private var restrictToThirdPartyApps:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEnabled() :Option[Boolean]	={
		return  this.enabled
	}

	def setEnabled( enabled: Option[Boolean]) 	={
		 this.enabled = enabled
		 this.keyModified("enabled") = 1
	}

	def getEnabledForModules() :ArrayBuffer[Modules]	={
		return  this.enabledForModules
	}

	def setEnabledForModules( enabledForModules: ArrayBuffer[Modules]) 	={
		 this.enabledForModules = enabledForModules
		 this.keyModified("enabled_for_modules") = 1
	}

	def getRestrictToZohoApps() :Option[Boolean]	={
		return  this.restrictToZohoApps
	}

	def setRestrictToZohoApps( restrictToZohoApps: Option[Boolean]) 	={
		 this.restrictToZohoApps = restrictToZohoApps
		 this.keyModified("restrict_to_zoho_apps") = 1
	}

	def getRestrictDataAccessThroughAPI() :Option[Boolean]	={
		return  this.restrictDataAccessThroughAPI
	}

	def setRestrictDataAccessThroughAPI( restrictDataAccessThroughAPI: Option[Boolean]) 	={
		 this.restrictDataAccessThroughAPI = restrictDataAccessThroughAPI
		 this.keyModified("restrict_data_access_through_api") = 1
	}

	def getRestrictDataInExport() :Option[Boolean]	={
		return  this.restrictDataInExport
	}

	def setRestrictDataInExport( restrictDataInExport: Option[Boolean]) 	={
		 this.restrictDataInExport = restrictDataInExport
		 this.keyModified("restrict_data_in_export") = 1
	}

	def getRestrictToThirdPartyApps() :ArrayBuffer[String]	={
		return  this.restrictToThirdPartyApps
	}

	def setRestrictToThirdPartyApps( restrictToThirdPartyApps: ArrayBuffer[String]) 	={
		 this.restrictToThirdPartyApps = restrictToThirdPartyApps
		 this.keyModified("restrict_to_third_party_apps") = 1
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