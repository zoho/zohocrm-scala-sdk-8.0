package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ReplacedResponseWrapper extends Model with ReplacedResponseHandler	{
	private var replacedValues:ArrayBuffer[ReplacedValue] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getReplacedValues() :ArrayBuffer[ReplacedValue]	={
		return  this.replacedValues
	}

	def setReplacedValues( replacedValues: ArrayBuffer[ReplacedValue]) 	={
		 this.replacedValues = replacedValues
		 this.keyModified("replaced_values") = 1
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