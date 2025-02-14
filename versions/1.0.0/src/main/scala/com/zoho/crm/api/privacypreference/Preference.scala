package com.zoho.crm.api.privacypreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Preference extends Model	{
	private var consentModules:Option[String] = None
	private var restrictTptFields:Option[String] = None
	private var excludeAPIZoho:Option[String] = None
	private var awaitingPeriod:Option[String] = None
	private var consentMailSend:Option[String] = None
	private var excludeExportFields:Option[String] = None
	private var limitActions:Option[String] = None
	private var excludeExport:Option[String] = None
	private var restrictZohoInteg:Option[String] = None
	private var excludeAPIZohoFields:Option[String] = None
	private var durationTiming:Option[String] = None
	private var dataProcessingDuration:Option[String] = None
	private var restrictTptServices:Option[String] = None
	private var excludeAPITptFields:Option[String] = None
	private var restrictZohoIntegServices:Option[String] = None
	private var privacySettingStatus:Option[String] = None
	private var doubleOptIn:Option[String] = None
	private var restrictZohoIntegFields:Option[String] = None
	private var excludeAPITpt:Option[String] = None
	private var blockList:Option[String] = None
	private var restrictTpt:Option[String] = None
	private var actionsWhileAwaiting:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getConsentModules() :Option[String]	={
		return  this.consentModules
	}

	def setConsentModules( consentModules: Option[String]) 	={
		 this.consentModules = consentModules
		 this.keyModified("consent_modules") = 1
	}

	def getRestrictTptFields() :Option[String]	={
		return  this.restrictTptFields
	}

	def setRestrictTptFields( restrictTptFields: Option[String]) 	={
		 this.restrictTptFields = restrictTptFields
		 this.keyModified("restrict_tpt_fields") = 1
	}

	def getExcludeAPIZoho() :Option[String]	={
		return  this.excludeAPIZoho
	}

	def setExcludeAPIZoho( excludeAPIZoho: Option[String]) 	={
		 this.excludeAPIZoho = excludeAPIZoho
		 this.keyModified("exclude_api_zoho") = 1
	}

	def getAwaitingPeriod() :Option[String]	={
		return  this.awaitingPeriod
	}

	def setAwaitingPeriod( awaitingPeriod: Option[String]) 	={
		 this.awaitingPeriod = awaitingPeriod
		 this.keyModified("awaiting_period") = 1
	}

	def getConsentMailSend() :Option[String]	={
		return  this.consentMailSend
	}

	def setConsentMailSend( consentMailSend: Option[String]) 	={
		 this.consentMailSend = consentMailSend
		 this.keyModified("consent_mail_send") = 1
	}

	def getExcludeExportFields() :Option[String]	={
		return  this.excludeExportFields
	}

	def setExcludeExportFields( excludeExportFields: Option[String]) 	={
		 this.excludeExportFields = excludeExportFields
		 this.keyModified("exclude_export_fields") = 1
	}

	def getLimitActions() :Option[String]	={
		return  this.limitActions
	}

	def setLimitActions( limitActions: Option[String]) 	={
		 this.limitActions = limitActions
		 this.keyModified("limit_actions") = 1
	}

	def getExcludeExport() :Option[String]	={
		return  this.excludeExport
	}

	def setExcludeExport( excludeExport: Option[String]) 	={
		 this.excludeExport = excludeExport
		 this.keyModified("exclude_export") = 1
	}

	def getRestrictZohoInteg() :Option[String]	={
		return  this.restrictZohoInteg
	}

	def setRestrictZohoInteg( restrictZohoInteg: Option[String]) 	={
		 this.restrictZohoInteg = restrictZohoInteg
		 this.keyModified("restrict_zoho_integ") = 1
	}

	def getExcludeAPIZohoFields() :Option[String]	={
		return  this.excludeAPIZohoFields
	}

	def setExcludeAPIZohoFields( excludeAPIZohoFields: Option[String]) 	={
		 this.excludeAPIZohoFields = excludeAPIZohoFields
		 this.keyModified("exclude_api_zoho_fields") = 1
	}

	def getDurationTiming() :Option[String]	={
		return  this.durationTiming
	}

	def setDurationTiming( durationTiming: Option[String]) 	={
		 this.durationTiming = durationTiming
		 this.keyModified("duration_timing") = 1
	}

	def getDataProcessingDuration() :Option[String]	={
		return  this.dataProcessingDuration
	}

	def setDataProcessingDuration( dataProcessingDuration: Option[String]) 	={
		 this.dataProcessingDuration = dataProcessingDuration
		 this.keyModified("data_processing_duration") = 1
	}

	def getRestrictTptServices() :Option[String]	={
		return  this.restrictTptServices
	}

	def setRestrictTptServices( restrictTptServices: Option[String]) 	={
		 this.restrictTptServices = restrictTptServices
		 this.keyModified("restrict_tpt_services") = 1
	}

	def getExcludeAPITptFields() :Option[String]	={
		return  this.excludeAPITptFields
	}

	def setExcludeAPITptFields( excludeAPITptFields: Option[String]) 	={
		 this.excludeAPITptFields = excludeAPITptFields
		 this.keyModified("exclude_api_tpt_fields") = 1
	}

	def getRestrictZohoIntegServices() :Option[String]	={
		return  this.restrictZohoIntegServices
	}

	def setRestrictZohoIntegServices( restrictZohoIntegServices: Option[String]) 	={
		 this.restrictZohoIntegServices = restrictZohoIntegServices
		 this.keyModified("restrict_zoho_integ_services") = 1
	}

	def getPrivacySettingStatus() :Option[String]	={
		return  this.privacySettingStatus
	}

	def setPrivacySettingStatus( privacySettingStatus: Option[String]) 	={
		 this.privacySettingStatus = privacySettingStatus
		 this.keyModified("privacy_setting_status") = 1
	}

	def getDoubleOptIn() :Option[String]	={
		return  this.doubleOptIn
	}

	def setDoubleOptIn( doubleOptIn: Option[String]) 	={
		 this.doubleOptIn = doubleOptIn
		 this.keyModified("double_opt_in") = 1
	}

	def getRestrictZohoIntegFields() :Option[String]	={
		return  this.restrictZohoIntegFields
	}

	def setRestrictZohoIntegFields( restrictZohoIntegFields: Option[String]) 	={
		 this.restrictZohoIntegFields = restrictZohoIntegFields
		 this.keyModified("restrict_zoho_integ_fields") = 1
	}

	def getExcludeAPITpt() :Option[String]	={
		return  this.excludeAPITpt
	}

	def setExcludeAPITpt( excludeAPITpt: Option[String]) 	={
		 this.excludeAPITpt = excludeAPITpt
		 this.keyModified("exclude_api_tpt") = 1
	}

	def getBlockList() :Option[String]	={
		return  this.blockList
	}

	def setBlockList( blockList: Option[String]) 	={
		 this.blockList = blockList
		 this.keyModified("block_list") = 1
	}

	def getRestrictTpt() :Option[String]	={
		return  this.restrictTpt
	}

	def setRestrictTpt( restrictTpt: Option[String]) 	={
		 this.restrictTpt = restrictTpt
		 this.keyModified("restrict_tpt") = 1
	}

	def getActionsWhileAwaiting() :Option[String]	={
		return  this.actionsWhileAwaiting
	}

	def setActionsWhileAwaiting( actionsWhileAwaiting: Option[String]) 	={
		 this.actionsWhileAwaiting = actionsWhileAwaiting
		 this.keyModified("actions_while_awaiting") = 1
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