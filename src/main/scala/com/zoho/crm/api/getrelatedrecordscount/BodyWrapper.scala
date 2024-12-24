package com.zoho.crm.api.getrelatedrecordscount

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var getRelatedRecordsCount:ArrayBuffer[GetRelatedRecordCount] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getGetRelatedRecordsCount() :ArrayBuffer[GetRelatedRecordCount]	={
		return  this.getRelatedRecordsCount
	}

	def setGetRelatedRecordsCount( getRelatedRecordsCount: ArrayBuffer[GetRelatedRecordCount]) 	={
		 this.getRelatedRecordsCount = getRelatedRecordsCount
		 this.keyModified("get_related_records_count") = 1
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