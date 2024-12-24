package com.zoho.crm.api.timelines

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FieldHistoryValue extends Model	{
	private var new1:Option[String] = None
	private var old:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getNew() :Option[String]	={
		return  this.new1
	}

	def setNew( new1: Option[String]) 	={
		 this.new1 = new1
		 this.keyModified("new") = 1
	}

	def getOld() :Option[String]	={
		return  this.old
	}

	def setOld( old: Option[String]) 	={
		 this.old = old
		 this.keyModified("old") = 1
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