package com.zoho.crm.api.appointmentpreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionWrapper extends Model with ActionHandler	{
	private var appointmentPreferences:Option[ActionResponse] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAppointmentPreferences() :Option[ActionResponse]	={
		return  this.appointmentPreferences
	}

	def setAppointmentPreferences( appointmentPreferences: Option[ActionResponse]) 	={
		 this.appointmentPreferences = appointmentPreferences
		 this.keyModified("appointment_preferences") = 1
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