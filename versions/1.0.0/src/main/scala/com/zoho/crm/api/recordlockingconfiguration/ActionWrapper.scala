package com.zoho.crm.api.recordlockingconfiguration

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var recordLockingConfigurations:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRecordLockingConfigurations() :ArrayBuffer[ActionResponse]	={
		return  this.recordLockingConfigurations
	}

	def setRecordLockingConfigurations( recordLockingConfigurations: ArrayBuffer[ActionResponse]) 	={
		 this.recordLockingConfigurations = recordLockingConfigurations
		 this.keyModified("record_locking_configurations") = 1
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