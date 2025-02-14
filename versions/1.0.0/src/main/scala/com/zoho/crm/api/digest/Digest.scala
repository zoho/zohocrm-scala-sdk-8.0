package com.zoho.crm.api.digest

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Digest extends Model	{
	private var recordId:Option[Long] = None
	private var type1:Option[String] = None
	private var module:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRecordId() :Option[Long]	={
		return  this.recordId
	}

	def setRecordId( recordId: Option[Long]) 	={
		 this.recordId = recordId
		 this.keyModified("record_id") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
		 this.module = module
		 this.keyModified("module") = 1
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