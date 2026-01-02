package com.zoho.crm.api.usertypeusers

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class APIException extends Model with ResponseHandler with ActionHandler with ActionResponse with StatusActionHandler with StatusActionResponse	{
	private var code:Choice[String] = _
	private var message:Option[String] = None
	private var status:Choice[String] = _
	private var details:Option[HashMap[String, Any]] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCode() :Choice[String]	={
		return  this.code
	}

	def setCode( code: Choice[String]) 	={
		 this.code = code
		 this.keyModified("code") = 1
	}

	def getMessage() :Option[String]	={
		return  this.message
	}

	def setMessage( message: Option[String]) 	={
		 this.message = message
		 this.keyModified("message") = 1
	}

	def getStatus() :Choice[String]	={
		return  this.status
	}

	def setStatus( status: Choice[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getDetails() :Option[HashMap[String, Any]]	={
		return  this.details
	}

	def setDetails( details: Option[HashMap[String, Any]]) 	={
		 this.details = details
		 this.keyModified("details") = 1
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