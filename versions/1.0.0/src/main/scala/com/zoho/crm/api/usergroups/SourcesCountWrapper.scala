package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class SourcesCountWrapper extends Model with ResponseHandler	{
	private var sourcesCount:ArrayBuffer[SourcesCount] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSourcesCount() :ArrayBuffer[SourcesCount]	={
		return  this.sourcesCount
	}

	def setSourcesCount( sourcesCount: ArrayBuffer[SourcesCount]) 	={
		 this.sourcesCount = sourcesCount
		 this.keyModified("sources_count") = 1
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