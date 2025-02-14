package com.zoho.crm.api.cancelmeetings

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Notify extends Model	{
	private var sendCancellingMail:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSendCancellingMail() :Option[Boolean]	={
		return  this.sendCancellingMail
	}

	def setSendCancellingMail( sendCancellingMail: Option[Boolean]) 	={
		 this.sendCancellingMail = sendCancellingMail
		 this.keyModified("send_cancelling_mail") = 1
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