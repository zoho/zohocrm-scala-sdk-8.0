package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class GroupedCountWrapper extends Model with ResponseHandler	{
	private var groupedCounts:ArrayBuffer[GroupedCount] = _
	private var info:Option[Info] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getGroupedCounts() :ArrayBuffer[GroupedCount]	={
		return  this.groupedCounts
	}

	def setGroupedCounts( groupedCounts: ArrayBuffer[GroupedCount]) 	={
		 this.groupedCounts = groupedCounts
		 this.keyModified("grouped_counts") = 1
	}

	def getInfo() :Option[Info]	={
		return  this.info
	}

	def setInfo( info: Option[Info]) 	={
		 this.info = info
		 this.keyModified("info") = 1
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