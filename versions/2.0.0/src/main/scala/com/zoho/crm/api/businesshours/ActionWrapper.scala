package com.zoho.crm.api.businesshours

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionWrapper extends Model with ActionHandler	{
	private var businessHours:Option[ActionResponse] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getBusinessHours() :Option[ActionResponse]	={
		return  this.businessHours
	}

	def setBusinessHours( businessHours: Option[ActionResponse]) 	={
		 this.businessHours = businessHours
		 this.keyModified("business_hours") = 1
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