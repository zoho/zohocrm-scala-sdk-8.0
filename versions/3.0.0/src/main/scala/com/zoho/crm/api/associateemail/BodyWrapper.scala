package com.zoho.crm.api.associateemail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var emails:ArrayBuffer[AssociateEmail] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmails() :ArrayBuffer[AssociateEmail]	={
		return  this.emails
	}

	def setEmails( emails: ArrayBuffer[AssociateEmail]) 	={
		 this.emails = emails
		 this.keyModified("Emails") = 1
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