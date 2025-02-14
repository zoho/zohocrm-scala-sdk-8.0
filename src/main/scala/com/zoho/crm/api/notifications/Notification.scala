package com.zoho.crm.api.notifications

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Notification extends Event with Model	{
	private var channelId:Option[String] = None
	private var notifyUrl:Option[String] = None
	private var events:ArrayBuffer[String] = _
	private var token:Option[String] = None
	private var fields:Option[HashMap[String, Any]] = _
	private var notifyOnRelatedAction:Option[Boolean] = None
	private var returnAffectedFieldValues:Option[Boolean] = None
	private var deleteEvents:Choice[Boolean] = _
	private var resourceName:Option[String] = None
	private var channelExpiry:Option[OffsetDateTime] = None
	private var resourceId:Option[Long] = None
	private var resourceUri:Option[String] = None
	private var notificationCondition:ArrayBuffer[NotificationCondition] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	override def getChannelId() :Option[String]	={
		return  this.channelId
	}

	override def setChannelId( channelId: Option[String]) 	={
		 this.channelId = channelId
		 this.keyModified("channel_id") = 1
	}

	def getNotifyUrl() :Option[String]	={
		return  this.notifyUrl
	}

	def setNotifyUrl( notifyUrl: Option[String]) 	={
		 this.notifyUrl = notifyUrl
		 this.keyModified("notify_url") = 1
	}

	def getEvents() :ArrayBuffer[String]	={
		return  this.events
	}

	def setEvents( events: ArrayBuffer[String]) 	={
		 this.events = events
		 this.keyModified("events") = 1
	}

	def getToken() :Option[String]	={
		return  this.token
	}

	def setToken( token: Option[String]) 	={
		 this.token = token
		 this.keyModified("token") = 1
	}

	def getFields() :Option[HashMap[String, Any]]	={
		return  this.fields
	}

	def setFields( fields: Option[HashMap[String, Any]]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	def getNotifyOnRelatedAction() :Option[Boolean]	={
		return  this.notifyOnRelatedAction
	}

	def setNotifyOnRelatedAction( notifyOnRelatedAction: Option[Boolean]) 	={
		 this.notifyOnRelatedAction = notifyOnRelatedAction
		 this.keyModified("notify_on_related_action") = 1
	}

	def getReturnAffectedFieldValues() :Option[Boolean]	={
		return  this.returnAffectedFieldValues
	}

	def setReturnAffectedFieldValues( returnAffectedFieldValues: Option[Boolean]) 	={
		 this.returnAffectedFieldValues = returnAffectedFieldValues
		 this.keyModified("return_affected_field_values") = 1
	}

	def getDeleteEvents() :Choice[Boolean]	={
		return  this.deleteEvents
	}

	def setDeleteEvents( deleteEvents: Choice[Boolean]) 	={
		 this.deleteEvents = deleteEvents
		 this.keyModified("_delete_events") = 1
	}

	override def getResourceName() :Option[String]	={
		return  this.resourceName
	}

	override def setResourceName( resourceName: Option[String]) 	={
		 this.resourceName = resourceName
		 this.keyModified("resource_name") = 1
	}

	override def getChannelExpiry() :Option[OffsetDateTime]	={
		return  this.channelExpiry
	}

	override def setChannelExpiry( channelExpiry: Option[OffsetDateTime]) 	={
		 this.channelExpiry = channelExpiry
		 this.keyModified("channel_expiry") = 1
	}

	override def getResourceId() :Option[Long]	={
		return  this.resourceId
	}

	override def setResourceId( resourceId: Option[Long]) 	={
		 this.resourceId = resourceId
		 this.keyModified("resource_id") = 1
	}

	override def getResourceUri() :Option[String]	={
		return  this.resourceUri
	}

	override def setResourceUri( resourceUri: Option[String]) 	={
		 this.resourceUri = resourceUri
		 this.keyModified("resource_uri") = 1
	}

	override def getNotificationCondition() :ArrayBuffer[NotificationCondition]	={
		return  this.notificationCondition
	}

	override def setNotificationCondition( notificationCondition: ArrayBuffer[NotificationCondition]) 	={
		 this.notificationCondition = notificationCondition
		 this.keyModified("notification_condition") = 1
	}

	override def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	override def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}