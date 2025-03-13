package com.zoho.crm.api.customviews

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var customViews:ArrayBuffer[CustomViews] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCustomViews() :ArrayBuffer[CustomViews]	={
		return  this.customViews
	}

	def setCustomViews( customViews: ArrayBuffer[CustomViews]) 	={
		 this.customViews = customViews
		 this.keyModified("custom_views") = 1
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