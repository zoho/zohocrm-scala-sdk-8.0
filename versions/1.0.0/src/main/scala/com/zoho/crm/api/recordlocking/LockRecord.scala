package com.zoho.crm.api.recordlocking

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class LockRecord extends Model	{
	private var lockedReasonS:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLockedReasonS() :Option[String]	={
		return  this.lockedReasonS
	}

	def setLockedReasonS( lockedReasonS: Option[String]) 	={
		 this.lockedReasonS = lockedReasonS
		 this.keyModified("Locked_Reason__s") = 1
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