package com.zoho.crm.api.modules

import com.zoho.crm.api.fields.MinifiedField
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class LookupField extends MinifiedField with Model	{
	private var sequenceNumber:Option[Int] = None
	private var apiName:Option[String] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	override def getAPIName() :Option[String]	={
		return  this.apiName
	}

	override def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	override def getId() :Option[Long]	={
		return  this.id
	}

	override def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	override def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	override def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}