package com.zoho.crm.api.conversionoption

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ResponseWrapper extends Model with ResponseHandler	{
	private var conversionOptions:Option[ConversionOptions] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getConversionOptions() :Option[ConversionOptions]	={
		return  this.conversionOptions
	}

	def setConversionOptions( conversionOptions: Option[ConversionOptions]) 	={
		 this.conversionOptions = conversionOptions
		 this.keyModified("__conversion_options") = 1
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