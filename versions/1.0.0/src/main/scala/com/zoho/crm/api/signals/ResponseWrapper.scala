package com.zoho.crm.api.signals

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var signals:ArrayBuffer[Signals] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSignals() :ArrayBuffer[Signals]	={
		return  this.signals
	}

	def setSignals( signals: ArrayBuffer[Signals]) 	={
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