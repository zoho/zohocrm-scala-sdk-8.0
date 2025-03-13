package com.zoho.crm.api.org

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class CheckinPreferences extends Model	{
	private var restrictedEventTypes:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRestrictedEventTypes() :Option[String]	={
		return  this.restrictedEventTypes
	}

	def setRestrictedEventTypes( restrictedEventTypes: Option[String]) 	={
		 this.restrictedEventTypes = restrictedEventTypes
		 this.keyModified("restricted_event_types") = 1
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