package com.zoho.crm.api.findandmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Merge extends Model	{
	private var jobId:Option[Long] = None
	private var status:Option[String] = None
	private var data:ArrayBuffer[MergeData] = _
	private var masterRecordFields:ArrayBuffer[MasterRecordFields] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getJobId() :Option[Long]	={
		return  this.jobId
	}

	def setJobId( jobId: Option[Long]) 	={
		 this.jobId = jobId
		 this.keyModified("job_id") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getData() :ArrayBuffer[MergeData]	={
		return  this.data
	}

	def setData( data: ArrayBuffer[MergeData]) 	={
		 this.data = data
		 this.keyModified("data") = 1
	}

	def getMasterRecordFields() :ArrayBuffer[MasterRecordFields]	={
		return  this.masterRecordFields
	}

	def setMasterRecordFields( masterRecordFields: ArrayBuffer[MasterRecordFields]) 	={
		 this.masterRecordFields = masterRecordFields
		 this.keyModified("master_record_fields") = 1
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