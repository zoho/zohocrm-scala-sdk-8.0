package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class JobsWrapper extends Model	{
	private var deletionJobs:ArrayBuffer[Jobs] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDeletionJobs() :ArrayBuffer[Jobs]	={
		return  this.deletionJobs
	}

	def setDeletionJobs( deletionJobs: ArrayBuffer[Jobs]) 	={
		 this.deletionJobs = deletionJobs
		 this.keyModified("deletion_jobs") = 1
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