package com.zoho.crm.api.shifthours

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var shiftHours:ArrayBuffer[ShiftHours] = _
	private var shiftCount:Option[ShiftCount] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShiftHours() :ArrayBuffer[ShiftHours]	={
		return  this.shiftHours
	}

	def setShiftHours( shiftHours: ArrayBuffer[ShiftHours]) 	={
		 this.shiftHours = shiftHours
		 this.keyModified("shift_hours") = 1
	}

	def getShiftCount() :Option[ShiftCount]	={
		return  this.shiftCount
	}

	def setShiftCount( shiftCount: Option[ShiftCount]) 	={
		 this.shiftCount = shiftCount
		 this.keyModified("shift_count") = 1
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