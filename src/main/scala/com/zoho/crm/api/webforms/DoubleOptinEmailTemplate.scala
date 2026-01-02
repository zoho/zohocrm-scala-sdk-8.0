package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DoubleOptinEmailTemplate extends Model	{
	private var fromAddress:Option[FromAddress] = None
	private var content:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFromAddress() :Option[FromAddress]	={
		return  this.fromAddress
	}

	def setFromAddress( fromAddress: Option[FromAddress]) 	={
		 this.fromAddress = fromAddress
		 this.keyModified("from_address") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
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