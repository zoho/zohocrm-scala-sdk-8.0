package com.zoho.crm.api.auditlogexport

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AuditLogExport extends Model	{
	private var criteria:Option[Criteria] = None
	private var id:Option[Long] = None
	private var status:Option[String] = None
	private var createdBy:Option[User] = None
	private var downloadLinks:ArrayBuffer[String] = _
	private var jobStartTime:Option[OffsetDateTime] = None
	private var jobEndTime:Option[OffsetDateTime] = None
	private var expiryDate:Option[OffsetDateTime] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCriteria() :Option[Criteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Criteria]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getDownloadLinks() :ArrayBuffer[String]	={
		return  this.downloadLinks
	}

	def setDownloadLinks( downloadLinks: ArrayBuffer[String]) 	={
		 this.downloadLinks = downloadLinks
		 this.keyModified("download_links") = 1
	}

	def getJobStartTime() :Option[OffsetDateTime]	={
		return  this.jobStartTime
	}

	def setJobStartTime( jobStartTime: Option[OffsetDateTime]) 	={
		 this.jobStartTime = jobStartTime
		 this.keyModified("job_start_time") = 1
	}

	def getJobEndTime() :Option[OffsetDateTime]	={
		return  this.jobEndTime
	}

	def setJobEndTime( jobEndTime: Option[OffsetDateTime]) 	={
		 this.jobEndTime = jobEndTime
		 this.keyModified("job_end_time") = 1
	}

	def getExpiryDate() :Option[OffsetDateTime]	={
		return  this.expiryDate
	}

	def setExpiryDate( expiryDate: Option[OffsetDateTime]) 	={
		 this.expiryDate = expiryDate
		 this.keyModified("expiry_date") = 1
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