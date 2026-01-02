package com.zoho.crm.api.sharerecords

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var share:ArrayBuffer[ShareRecord] = _
	private var notifyOnCompletion:Option[Boolean] = None
	private var notify1:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShare() :ArrayBuffer[ShareRecord]	={
		return  this.share
	}

	def setShare( share: ArrayBuffer[ShareRecord]) 	={
		 this.share = share
		 this.keyModified("share") = 1
	}

	def getNotifyOnCompletion() :Option[Boolean]	={
		return  this.notifyOnCompletion
	}

	def setNotifyOnCompletion( notifyOnCompletion: Option[Boolean]) 	={
		 this.notifyOnCompletion = notifyOnCompletion
		 this.keyModified("notify_on_completion") = 1
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