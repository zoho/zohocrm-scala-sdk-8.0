package com.zoho.crm.api.emailconfigurationoptions

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class RangeStructure extends Model	{
	private var from:Option[String] = None
	private var to:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFrom() :Option[String]	={
		return  this.from
	}

	def setFrom( from: Option[String]) 	={
		 this.from = from
		 this.keyModified("from") = 1
	}

	def getTo() :Option[String]	={
		return  this.to
	}

	def setTo( to: Option[String]) 	={
		 this.to = to
		 this.keyModified("to") = 1
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