package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Social extends Model	{
	private var twitter:Option[String] = None
	private var facebook:Option[String] = None
	private var linkedin:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTwitter() :Option[String]	={
		return  this.twitter
	}

	def setTwitter( twitter: Option[String]) 	={
		 this.twitter = twitter
		 this.keyModified("twitter") = 1
	}

	def getFacebook() :Option[String]	={
		return  this.facebook
	}

	def setFacebook( facebook: Option[String]) 	={
		 this.facebook = facebook
		 this.keyModified("facebook") = 1
	}

	def getLinkedin() :Option[String]	={
		return  this.linkedin
	}

	def setLinkedin( linkedin: Option[String]) 	={
		 this.linkedin = linkedin
		 this.keyModified("linkedin") = 1
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