package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class SocialMedia extends Model	{
	private var mediaType:Option[String] = None
	private var mediaUrl:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMediaType() :Option[String]	={
		return  this.mediaType
	}

	def setMediaType( mediaType: Option[String]) 	={
		 this.mediaType = mediaType
		 this.keyModified("media_type") = 1
	}

	def getMediaUrl() :ArrayBuffer[String]	={
		return  this.mediaUrl
	}

	def setMediaUrl( mediaUrl: ArrayBuffer[String]) 	={
		 this.mediaUrl = mediaUrl
		 this.keyModified("media_url") = 1
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