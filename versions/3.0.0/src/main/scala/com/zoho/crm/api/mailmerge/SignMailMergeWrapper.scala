package com.zoho.crm.api.mailmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class SignMailMergeWrapper extends Model	{
	private var signMailMerge:ArrayBuffer[SignMailMerge] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSignMailMerge() :ArrayBuffer[SignMailMerge]	={
		return  this.signMailMerge
	}

	def setSignMailMerge( signMailMerge: ArrayBuffer[SignMailMerge]) 	={
		 this.signMailMerge = signMailMerge
		 this.keyModified("sign_mail_merge") = 1
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