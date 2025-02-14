package com.zoho.crm.api.massdeletecvid

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Status extends Model	{
	private var status:Choice[String] = _
	private var failedCount:Option[Int] = None
	private var deletedCount:Option[Int] = None
	private var totalCount:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getStatus() :Choice[String]	={
		return  this.status
	}

	def setStatus( status: Choice[String]) 	={
		 this.status = status
		 this.keyModified("Status") = 1
	}

	def getFailedCount() :Option[Int]	={
		return  this.failedCount
	}

	def setFailedCount( failedCount: Option[Int]) 	={
		 this.failedCount = failedCount
		 this.keyModified("Failed_Count") = 1
	}

	def getDeletedCount() :Option[Int]	={
		return  this.deletedCount
	}

	def setDeletedCount( deletedCount: Option[Int]) 	={
		 this.deletedCount = deletedCount
		 this.keyModified("Deleted_Count") = 1
	}

	def getTotalCount() :Option[Int]	={
		return  this.totalCount
	}

	def setTotalCount( totalCount: Option[Int]) 	={
		 this.totalCount = totalCount
		 this.keyModified("Total_Count") = 1
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