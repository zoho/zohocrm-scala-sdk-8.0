package com.zoho.crm.api.shifthours

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ShiftCount extends Model	{
	private var totalShiftWithUser:Option[Int] = None
	private var totalShift:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTotalShiftWithUser() :Option[Int]	={
		return  this.totalShiftWithUser
	}

	def setTotalShiftWithUser( totalShiftWithUser: Option[Int]) 	={
		 this.totalShiftWithUser = totalShiftWithUser
		 this.keyModified("total_shift_with_user") = 1
	}

	def getTotalShift() :Option[Int]	={
		return  this.totalShift
	}

	def setTotalShift( totalShift: Option[Int]) 	={
		 this.totalShift = totalShift
		 this.keyModified("total_shift") = 1
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