package com.zoho.crm.api.associateemail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Record extends Model	{
	private var module:Option[ModuleMap] = None
	private var id:Option[Long] = None
	private var linkedRecord:Option[LinkedRecord] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[ModuleMap]	={
		return  this.module
	}

	def setModule( module: Option[ModuleMap]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getLinkedRecord() :Option[LinkedRecord]	={
		return  this.linkedRecord
	}

	def setLinkedRecord( linkedRecord: Option[LinkedRecord]) 	={
		 this.linkedRecord = linkedRecord
		 this.keyModified("linked_record") = 1
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