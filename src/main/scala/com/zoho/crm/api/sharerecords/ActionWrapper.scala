package com.zoho.crm.api.sharerecords

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var share:ArrayBuffer[ActionResponse] = _
	private var notify1:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShare() :ArrayBuffer[ActionResponse]	={
		return  this.share
	}

	def setShare( share: ArrayBuffer[ActionResponse]) 	={
		 this.share = share
		 this.keyModified("share") = 1
	}

	def getNotify() :Option[Boolean]	={
		return  this.notify1
	}

	def setNotify( notify1: Option[Boolean]) 	={
		 this.notify1 = notify1
		 this.keyModified("notify") = 1
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