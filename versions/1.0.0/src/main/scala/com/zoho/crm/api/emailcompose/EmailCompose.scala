package com.zoho.crm.api.emailcompose

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class EmailCompose extends Model	{
	private var defaultFromAddress:Option[DefaultFromAddress] = None
	private var defaultReplytoAddress:Option[DefaultReplytoAddress] = None
	private var font:Option[Font] = None
	private var type1:Choice[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDefaultFromAddress() :Option[DefaultFromAddress]	={
		return  this.defaultFromAddress
	}

	def setDefaultFromAddress( defaultFromAddress: Option[DefaultFromAddress]) 	={
		 this.defaultFromAddress = defaultFromAddress
		 this.keyModified("default_from_address") = 1
	}

	def getDefaultReplytoAddress() :Option[DefaultReplytoAddress]	={
		return  this.defaultReplytoAddress
	}

	def setDefaultReplytoAddress( defaultReplytoAddress: Option[DefaultReplytoAddress]) 	={
		 this.defaultReplytoAddress = defaultReplytoAddress
		 this.keyModified("default_replyto_address") = 1
	}

	def getFont() :Option[Font]	={
		return  this.font
	}

	def setFont( font: Option[Font]) 	={
		 this.font = font
		 this.keyModified("font") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
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