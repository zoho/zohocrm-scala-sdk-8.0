package com.zoho.crm.api.servicepreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ServicePreference extends Model	{
	private var jobSheetEnabled:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getJobSheetEnabled() :Option[Boolean]	={
		return  this.jobSheetEnabled
	}

	def setJobSheetEnabled( jobSheetEnabled: Option[Boolean]) 	={
		 this.jobSheetEnabled = jobSheetEnabled
		 this.keyModified("job_sheet_enabled") = 1
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