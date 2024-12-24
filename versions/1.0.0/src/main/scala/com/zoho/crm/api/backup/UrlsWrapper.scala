package com.zoho.crm.api.backup

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class UrlsWrapper extends Model with ResponseHandler	{
	private var urls:Option[Urls] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUrls() :Option[Urls]	={
		return  this.urls
	}

	def setUrls( urls: Option[Urls]) 	={
		 this.urls = urls
		 this.keyModified("urls") = 1
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