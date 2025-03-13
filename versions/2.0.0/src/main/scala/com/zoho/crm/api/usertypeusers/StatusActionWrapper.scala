package com.zoho.crm.api.usertypeusers

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class StatusActionWrapper extends Model with StatusActionHandler	{
	private var changeStatus:ArrayBuffer[StatusActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getChangeStatus() :ArrayBuffer[StatusActionResponse]	={
		return  this.changeStatus
	}

	def setChangeStatus( changeStatus: ArrayBuffer[StatusActionResponse]) 	={
		 this.changeStatus = changeStatus
		 this.keyModified("change_status") = 1
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