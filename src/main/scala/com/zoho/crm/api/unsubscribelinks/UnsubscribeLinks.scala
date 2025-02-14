package com.zoho.crm.api.unsubscribelinks

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class UnsubscribeLinks extends Model	{
	private var id:Option[Long] = None
	private var name:Option[String] = None
	private var pageType:Choice[String] = _
	private var customLocationUrl:Option[String] = None
	private var standardPageMessage:Option[String] = None
	private var submissionActionType:Choice[String] = _
	private var submissionMessage:Option[String] = None
	private var submissionRedirectUrl:Option[String] = None
	private var locationUrlType:Option[String] = None
	private var actionOnUnsubscribe:Option[String] = None
	private var createdBy:Option[User] = None
	private var modifiedBy:Option[User] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var landingUrl:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

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

	def getPageType() :Choice[String]	={
		return  this.pageType
	}

	def setPageType( pageType: Choice[String]) 	={
		 this.pageType = pageType
		 this.keyModified("page_type") = 1
	}

	def getCustomLocationUrl() :Option[String]	={
		return  this.customLocationUrl
	}

	def setCustomLocationUrl( customLocationUrl: Option[String]) 	={
		 this.customLocationUrl = customLocationUrl
		 this.keyModified("custom_location_url") = 1
	}

	def getStandardPageMessage() :Option[String]	={
		return  this.standardPageMessage
	}

	def setStandardPageMessage( standardPageMessage: Option[String]) 	={
		 this.standardPageMessage = standardPageMessage
		 this.keyModified("standard_page_message") = 1
	}

	def getSubmissionActionType() :Choice[String]	={
		return  this.submissionActionType
	}

	def setSubmissionActionType( submissionActionType: Choice[String]) 	={
		 this.submissionActionType = submissionActionType
		 this.keyModified("submission_action_type") = 1
	}

	def getSubmissionMessage() :Option[String]	={
		return  this.submissionMessage
	}

	def setSubmissionMessage( submissionMessage: Option[String]) 	={
		 this.submissionMessage = submissionMessage
		 this.keyModified("submission_message") = 1
	}

	def getSubmissionRedirectUrl() :Option[String]	={
		return  this.submissionRedirectUrl
	}

	def setSubmissionRedirectUrl( submissionRedirectUrl: Option[String]) 	={
		 this.submissionRedirectUrl = submissionRedirectUrl
		 this.keyModified("submission_redirect_url") = 1
	}

	def getLocationUrlType() :Option[String]	={
		return  this.locationUrlType
	}

	def setLocationUrlType( locationUrlType: Option[String]) 	={
		 this.locationUrlType = locationUrlType
		 this.keyModified("location_url_type") = 1
	}

	def getActionOnUnsubscribe() :Option[String]	={
		return  this.actionOnUnsubscribe
	}

	def setActionOnUnsubscribe( actionOnUnsubscribe: Option[String]) 	={
		 this.actionOnUnsubscribe = actionOnUnsubscribe
		 this.keyModified("action_on_unsubscribe") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getModifiedBy() :Option[User]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[User]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getLandingUrl() :Option[String]	={
		return  this.landingUrl
	}

	def setLandingUrl( landingUrl: Option[String]) 	={
		 this.landingUrl = landingUrl
		 this.keyModified("landing_url") = 1
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