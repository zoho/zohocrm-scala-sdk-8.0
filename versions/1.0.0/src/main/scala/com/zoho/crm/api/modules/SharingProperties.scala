package com.zoho.crm.api.modules

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class SharingProperties extends Model	{
	private var schedulerStatus:Option[String] = None
	private var sharePreferenceEnabled:Option[Boolean] = None
	private var sharePermission:Choice[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSchedulerStatus() :Option[String]	={
		return  this.schedulerStatus
	}

	def setSchedulerStatus( schedulerStatus: Option[String]) 	={
		 this.schedulerStatus = schedulerStatus
		 this.keyModified("scheduler_status") = 1
	}

	def getSharePreferenceEnabled() :Option[Boolean]	={
		return  this.sharePreferenceEnabled
	}

	def setSharePreferenceEnabled( sharePreferenceEnabled: Option[Boolean]) 	={
		 this.sharePreferenceEnabled = sharePreferenceEnabled
		 this.keyModified("share_preference_enabled") = 1
	}

	def getSharePermission() :Choice[String]	={
		return  this.sharePermission
	}

	def setSharePermission( sharePermission: Choice[String]) 	={
		 this.sharePermission = sharePermission
		 this.keyModified("share_permission") = 1
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