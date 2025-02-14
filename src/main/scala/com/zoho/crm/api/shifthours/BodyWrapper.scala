package com.zoho.crm.api.shifthours

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var shiftHours:ArrayBuffer[ShiftHours] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShiftHours() :ArrayBuffer[ShiftHours]	={
		return  this.shiftHours
	}

	def setShiftHours( shiftHours: ArrayBuffer[ShiftHours]) 	={
		 this.shiftHours = shiftHours
		 this.keyModified("shift_hours") = 1
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