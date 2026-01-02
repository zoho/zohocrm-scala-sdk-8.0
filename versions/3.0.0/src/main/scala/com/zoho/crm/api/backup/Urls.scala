package com.zoho.crm.api.backup

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Urls extends Model	{
	private var dataLinks:ArrayBuffer[String] = _
	private var attachmentLinks:ArrayBuffer[String] = _
	private var expiryDate:Option[OffsetDateTime] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDataLinks() :ArrayBuffer[String]	={
		return  this.dataLinks
	}

	def setDataLinks( dataLinks: ArrayBuffer[String]) 	={
		 this.dataLinks = dataLinks
		 this.keyModified("data_links") = 1
	}

	def getAttachmentLinks() :ArrayBuffer[String]	={
		return  this.attachmentLinks
	}

	def setAttachmentLinks( attachmentLinks: ArrayBuffer[String]) 	={
		 this.attachmentLinks = attachmentLinks
		 this.keyModified("attachment_links") = 1
	}

	def getExpiryDate() :Option[OffsetDateTime]	={
		return  this.expiryDate
	}

	def setExpiryDate( expiryDate: Option[OffsetDateTime]) 	={
		 this.expiryDate = expiryDate
		 this.keyModified("expiry_date") = 1
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