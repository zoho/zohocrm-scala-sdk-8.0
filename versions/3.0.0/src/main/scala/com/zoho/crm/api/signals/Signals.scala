package com.zoho.crm.api.signals

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Signals extends Model	{
	private var displayLabel:Option[String] = None
	private var namespace:Option[String] = None
	private var chatEnabled:Option[Boolean] = None
	private var enabled:Option[Boolean] = None
	private var id:Option[Long] = None
	private var featureAvailability:Option[FeatureAvailability] = None
	private var extension:Option[Extension] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getNamespace() :Option[String]	={
		return  this.namespace
	}

	def setNamespace( namespace: Option[String]) 	={
		 this.namespace = namespace
		 this.keyModified("namespace") = 1
	}

	def getChatEnabled() :Option[Boolean]	={
		return  this.chatEnabled
	}

	def setChatEnabled( chatEnabled: Option[Boolean]) 	={
		 this.chatEnabled = chatEnabled
		 this.keyModified("chat_enabled") = 1
	}

	def getEnabled() :Option[Boolean]	={
		return  this.enabled
	}

	def setEnabled( enabled: Option[Boolean]) 	={
		 this.enabled = enabled
		 this.keyModified("enabled") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getFeatureAvailability() :Option[FeatureAvailability]	={
		return  this.featureAvailability
	}

	def setFeatureAvailability( featureAvailability: Option[FeatureAvailability]) 	={
		 this.featureAvailability = featureAvailability
		 this.keyModified("feature_availability") = 1
	}

	def getExtension() :Option[Extension]	={
		return  this.extension
	}

	def setExtension( extension: Option[Extension]) 	={
		 this.extension = extension
		 this.keyModified("extension") = 1
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