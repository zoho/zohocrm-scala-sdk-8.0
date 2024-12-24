package com.zoho.crm.api.availablecurrencies

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var availableCurrencies:ArrayBuffer[Currency] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAvailableCurrencies() :ArrayBuffer[Currency]	={
		return  this.availableCurrencies
	}

	def setAvailableCurrencies( availableCurrencies: ArrayBuffer[Currency]) 	={
		 this.availableCurrencies = availableCurrencies
		 this.keyModified("available_currencies") = 1
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