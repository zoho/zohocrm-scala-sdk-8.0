package com.zoho.crm.api.mailmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MailMergeWrapper extends Model	{
	private var sendMailMerge:ArrayBuffer[MailMerge] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSendMailMerge() :ArrayBuffer[MailMerge]	={
		return  this.sendMailMerge
	}

	def setSendMailMerge( sendMailMerge: ArrayBuffer[MailMerge]) 	={
		 this.sendMailMerge = sendMailMerge
		 this.keyModified("send_mail_merge") = 1
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