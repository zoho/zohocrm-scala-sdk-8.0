package com.zoho.crm.api.emailsharingdetails

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var emailsSharingDetails:ArrayBuffer[EmailSharings] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailsSharingDetails() :ArrayBuffer[EmailSharings]	={
		return  this.emailsSharingDetails
	}

	def setEmailsSharingDetails( emailsSharingDetails: ArrayBuffer[EmailSharings]) 	={
		 this.emailsSharingDetails = emailsSharingDetails
		 this.keyModified("__emails_sharing_details") = 1
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