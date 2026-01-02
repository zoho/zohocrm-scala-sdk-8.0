package com.zoho.crm.api.portalinvite

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class JobResponse extends Model	{
	private var data:ArrayBuffer[Data] = _
	private var jobId:Option[Long] = None
	private var status:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getData() :ArrayBuffer[Data]	={
		return  this.data
	}

	def setData( data: ArrayBuffer[Data]) 	={
		 this.data = data
		 this.keyModified("data") = 1
	}

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