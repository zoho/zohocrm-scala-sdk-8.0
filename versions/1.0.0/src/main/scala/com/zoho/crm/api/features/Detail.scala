package com.zoho.crm.api.features

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Detail extends Model	{
	private var availableCount:Option[Limit] = None
	private var limits:Option[Limit] = None
	private var usedCount:Option[Limit] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAvailableCount() :Option[Limit]	={
		return  this.availableCount
	}

	def setAvailableCount( availableCount: Option[Limit]) 	={
		 this.availableCount = availableCount
		 this.keyModified("available_count") = 1
	}

	def getLimits() :Option[Limit]	={
		return  this.limits
	}

	def setLimits( limits: Option[Limit]) 	={
		 this.limits = limits
		 this.keyModified("limits") = 1
	}

	def getUsedCount() :Option[Limit]	={
		return  this.usedCount
	}

	def setUsedCount( usedCount: Option[Limit]) 	={
		 this.usedCount = usedCount
		 this.keyModified("used_count") = 1
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