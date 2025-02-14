package com.zoho.crm.api.apis

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class OperationTypes extends Model	{
	private var method:Option[String] = None
	private var oauthScope:Option[String] = None
	private var maxCredits:Option[Int] = None
	private var minCredits:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMethod() :Option[String]	={
		return  this.method
	}

	def setMethod( method: Option[String]) 	={
		 this.method = method
		 this.keyModified("method") = 1
	}

	def getOauthScope() :Option[String]	={
		return  this.oauthScope
	}

	def setOauthScope( oauthScope: Option[String]) 	={
		 this.oauthScope = oauthScope
		 this.keyModified("oauth_scope") = 1
	}

	def getMaxCredits() :Option[Int]	={
		return  this.maxCredits
	}

	def setMaxCredits( maxCredits: Option[Int]) 	={
		 this.maxCredits = maxCredits
		 this.keyModified("max_credits") = 1
	}

	def getMinCredits() :Option[Int]	={
		return  this.minCredits
	}

	def setMinCredits( minCredits: Option[Int]) 	={
		 this.minCredits = minCredits
		 this.keyModified("min_credits") = 1
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