package com.zoho.crm.api.notes

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var data:ArrayBuffer[Note] = _
	private var trigger:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getData() :ArrayBuffer[Note]	={
		return  this.data
	}

	def setData( data: ArrayBuffer[Note]) 	={
		 this.data = data
		 this.keyModified("data") = 1
	}

	def getTrigger() :ArrayBuffer[String]	={
		return  this.trigger
	}

	def setTrigger( trigger: ArrayBuffer[String]) 	={
		 this.trigger = trigger
		 this.keyModified("trigger") = 1
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