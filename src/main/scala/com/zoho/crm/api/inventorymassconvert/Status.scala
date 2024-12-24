package com.zoho.crm.api.inventorymassconvert

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Status extends Model with ResponseHandler	{
	private var totalCount:Option[Int] = None
	private var convertedCount:Option[Int] = None
	private var notConvertedCount:Option[Int] = None
	private var failedCount:Option[Int] = None
	private var status:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTotalCount() :Option[Int]	={
		return  this.totalCount
	}

	def setTotalCount( totalCount: Option[Int]) 	={
		 this.totalCount = totalCount
		 this.keyModified("total_count") = 1
	}

	def getConvertedCount() :Option[Int]	={
		return  this.convertedCount
	}

	def setConvertedCount( convertedCount: Option[Int]) 	={
		 this.convertedCount = convertedCount
		 this.keyModified("converted_count") = 1
	}

	def getNotConvertedCount() :Option[Int]	={
		return  this.notConvertedCount
	}

	def setNotConvertedCount( notConvertedCount: Option[Int]) 	={
		 this.notConvertedCount = notConvertedCount
		 this.keyModified("not_converted_count") = 1
	}

	def getFailedCount() :Option[Int]	={
		return  this.failedCount
	}

	def setFailedCount( failedCount: Option[Int]) 	={
		 this.failedCount = failedCount
		 this.keyModified("failed_count") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
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