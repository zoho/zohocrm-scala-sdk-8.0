package com.zoho.crm.api.inventoryconvert

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class InventoryConverter extends Model	{
	private var convertTo:ArrayBuffer[ConvertTo] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getConvertTo() :ArrayBuffer[ConvertTo]	={
		return  this.convertTo
	}

	def setConvertTo( convertTo: ArrayBuffer[ConvertTo]) 	={
		 this.convertTo = convertTo
		 this.keyModified("convert_to") = 1
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