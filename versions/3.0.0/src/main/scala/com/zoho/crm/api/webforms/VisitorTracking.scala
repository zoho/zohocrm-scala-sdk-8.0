package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class VisitorTracking extends Model	{
	private var portalName:Option[String] = None
	private var trackingCode:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPortalName() :Option[String]	={
		return  this.portalName
	}

	def setPortalName( portalName: Option[String]) 	={
		 this.portalName = portalName
		 this.keyModified("portal_name") = 1
	}

	def getTrackingCode() :Option[String]	={
		return  this.trackingCode
	}

	def setTrackingCode( trackingCode: Option[String]) 	={
		 this.trackingCode = trackingCode
		 this.keyModified("tracking_code") = 1
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