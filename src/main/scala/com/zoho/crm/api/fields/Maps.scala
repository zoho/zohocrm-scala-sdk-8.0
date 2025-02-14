package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Maps extends Model	{
	private var apiName:Option[String] = None
	private var pickListValues:ArrayBuffer[PickListValue] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getPickListValues() :ArrayBuffer[PickListValue]	={
		return  this.pickListValues
	}

	def setPickListValues( pickListValues: ArrayBuffer[PickListValue]) 	={
		 this.pickListValues = pickListValues
		 this.keyModified("pick_list_values") = 1
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