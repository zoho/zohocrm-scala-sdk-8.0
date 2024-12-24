package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class AnalyticsData extends Model	{
	private var iframeUrlTrackingCode:Option[String] = None
	private var urlAnalyticsEnabled:Option[Boolean] = None
	private var analyticsEnabled:Option[Boolean] = None
	private var analyticsEnabledTime:Option[OffsetDateTime] = None
	private var trackingCode:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getIframeUrlTrackingCode() :Option[String]	={
		return  this.iframeUrlTrackingCode
	}

	def setIframeUrlTrackingCode( iframeUrlTrackingCode: Option[String]) 	={
		 this.iframeUrlTrackingCode = iframeUrlTrackingCode
		 this.keyModified("iframe_url_tracking_code") = 1
	}

	def getUrlAnalyticsEnabled() :Option[Boolean]	={
		return  this.urlAnalyticsEnabled
	}

	def setUrlAnalyticsEnabled( urlAnalyticsEnabled: Option[Boolean]) 	={
		 this.urlAnalyticsEnabled = urlAnalyticsEnabled
		 this.keyModified("url_analytics_enabled") = 1
	}

	def getAnalyticsEnabled() :Option[Boolean]	={
		return  this.analyticsEnabled
	}

	def setAnalyticsEnabled( analyticsEnabled: Option[Boolean]) 	={
		 this.analyticsEnabled = analyticsEnabled
		 this.keyModified("analytics_enabled") = 1
	}

	def getAnalyticsEnabledTime() :Option[OffsetDateTime]	={
		return  this.analyticsEnabledTime
	}

	def setAnalyticsEnabledTime( analyticsEnabledTime: Option[OffsetDateTime]) 	={
		 this.analyticsEnabledTime = analyticsEnabledTime
		 this.keyModified("analytics_enabled_time") = 1
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