package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class FiltersBody extends Model	{
	private var filters:ArrayBuffer[Criteria] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFilters() :ArrayBuffer[Criteria]	={
		return  this.filters
	}

	def setFilters( filters: ArrayBuffer[Criteria]) 	={
		 this.filters = filters
		 this.keyModified("filters") = 1
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