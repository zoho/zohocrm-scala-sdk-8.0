package com.zoho.crm.api.appointmentpreference

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AppointmentPreference extends Model	{
	private var showJobSheet:Option[Boolean] = None
	private var whenDurationExceeds:Option[String] = None
	private var whenAppointmentCompleted:Choice[String] = _
	private var allowBookingOutsideServiceAvailability:Option[Boolean] = None
	private var allowBookingOutsideBusinesshours:Option[Boolean] = None
	private var dealRecordConfiguration:Option[DealRecordConfiguration] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShowJobSheet() :Option[Boolean]	={
		return  this.showJobSheet
	}

	def setShowJobSheet( showJobSheet: Option[Boolean]) 	={
		 this.showJobSheet = showJobSheet
		 this.keyModified("show_job_sheet") = 1
	}

	def getWhenDurationExceeds() :Option[String]	={
		return  this.whenDurationExceeds
	}

	def setWhenDurationExceeds( whenDurationExceeds: Option[String]) 	={
		 this.whenDurationExceeds = whenDurationExceeds
		 this.keyModified("when_duration_exceeds") = 1
	}

	def getWhenAppointmentCompleted() :Choice[String]	={
		return  this.whenAppointmentCompleted
	}

	def setWhenAppointmentCompleted( whenAppointmentCompleted: Choice[String]) 	={
		 this.whenAppointmentCompleted = whenAppointmentCompleted
		 this.keyModified("when_appointment_completed") = 1
	}

	def getAllowBookingOutsideServiceAvailability() :Option[Boolean]	={
		return  this.allowBookingOutsideServiceAvailability
	}

	def setAllowBookingOutsideServiceAvailability( allowBookingOutsideServiceAvailability: Option[Boolean]) 	={
		 this.allowBookingOutsideServiceAvailability = allowBookingOutsideServiceAvailability
		 this.keyModified("allow_booking_outside_service_availability") = 1
	}

	def getAllowBookingOutsideBusinesshours() :Option[Boolean]	={
		return  this.allowBookingOutsideBusinesshours
	}

	def setAllowBookingOutsideBusinesshours( allowBookingOutsideBusinesshours: Option[Boolean]) 	={
		 this.allowBookingOutsideBusinesshours = allowBookingOutsideBusinesshours
		 this.keyModified("allow_booking_outside_businesshours") = 1
	}

	def getDealRecordConfiguration() :Option[DealRecordConfiguration]	={
		return  this.dealRecordConfiguration
	}

	def setDealRecordConfiguration( dealRecordConfiguration: Option[DealRecordConfiguration]) 	={
		 this.dealRecordConfiguration = dealRecordConfiguration
		 this.keyModified("deal_record_configuration") = 1
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