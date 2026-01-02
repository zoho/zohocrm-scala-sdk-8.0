package com.zoho.crm.api.pipeline

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Stages extends Model	{
	private var from:Option[Long] = None
	private var to:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFrom() :Option[Long]	={
		return  this.from
	}

	def setFrom( from: Option[Long]) 	={
		 this.from = from
		 this.keyModified("from") = 1
	}

	def getTo() :Option[Long]	={
		return  this.to
	}

	def setTo( to: Option[Long]) 	={
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