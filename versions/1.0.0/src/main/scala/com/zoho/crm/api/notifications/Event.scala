package com.zoho.crm.api.notifications

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Event extends Model	{
	private var resourceName:Option[String] = None
	private var channelExpiry:Option[OffsetDateTime] = None
	private var resourceId:Option[Long] = None
	private var resourceUri:Option[String] = None
	private var channelId:Option[String] = None
	private var notificationCondition:ArrayBuffer[NotificationCondition] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getResourceName() :Option[String]	={
		return  this.resourceName
	}

	def setResourceName( resourceName: Option[String]) 	={
		 this.resourceName = resourceName
		 this.keyModified("resource_name") = 1
	}

	def getChannelExpiry() :Option[OffsetDateTime]	={
		return  this.channelExpiry
	}

	def setChannelExpiry( channelExpiry: Option[OffsetDateTime]) 	={
		 this.channelExpiry = channelExpiry
		 this.keyModified("channel_expiry") = 1
	}

	def getResourceId() :Option[Long]	={
		return  this.resourceId
	}

	def setResourceId( resourceId: Option[Long]) 	={
		 this.resourceId = resourceId
		 this.keyModified("resource_id") = 1
	}

	def getResourceUri() :Option[String]	={
		return  this.resourceUri
	}

	def setResourceUri( resourceUri: Option[String]) 	={
		 this.resourceUri = resourceUri
		 this.keyModified("resource_uri") = 1
	}

	def getChannelId() :Option[String]	={
		return  this.channelId
	}

	def setChannelId( channelId: Option[String]) 	={
		 this.channelId = channelId
		 this.keyModified("channel_id") = 1
	}

	def getNotificationCondition() :ArrayBuffer[NotificationCondition]	={
		return  this.notificationCondition
	}

	def setNotificationCondition( notificationCondition: ArrayBuffer[NotificationCondition]) 	={
		 this.notificationCondition = notificationCondition
		 this.keyModified("notification_condition") = 1
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