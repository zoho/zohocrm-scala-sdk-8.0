package com.zoho.crm.api.appointmentpreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class BodyWrapper extends Model	{
	private var appointmentPreferences:Option[AppointmentPreference] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAppointmentPreferences() :Option[AppointmentPreference]	={
		return  this.appointmentPreferences
	}

	def setAppointmentPreferences( appointmentPreferences: Option[AppointmentPreference]) 	={
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