package com.zoho.crm.api.unsubscribelinks

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var unsubscribeLinks:ArrayBuffer[UnsubscribeLinks] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUnsubscribeLinks() :ArrayBuffer[UnsubscribeLinks]	={
		return  this.unsubscribeLinks
	}

	def setUnsubscribeLinks( unsubscribeLinks: ArrayBuffer[UnsubscribeLinks]) 	={
		 this.unsubscribeLinks = unsubscribeLinks
		 this.keyModified("unsubscribe_links") = 1
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