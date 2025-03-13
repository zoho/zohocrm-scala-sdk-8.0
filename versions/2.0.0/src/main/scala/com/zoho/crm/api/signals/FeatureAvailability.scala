package com.zoho.crm.api.signals

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FeatureAvailability extends Model	{
	private var scoring:Option[Boolean] = None
	private var signals:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getScoring() :Option[Boolean]	={
		return  this.scoring
	}

	def setScoring( scoring: Option[Boolean]) 	={
		 this.scoring = scoring
		 this.keyModified("scoring") = 1
	}

	def getSignals() :Option[Boolean]	={
		return  this.signals
	}

	def setSignals( signals: Option[Boolean]) 	={
		 this.signals = signals
		 this.keyModified("signals") = 1
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