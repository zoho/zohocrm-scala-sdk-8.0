package com.zoho.crm.api.cadences

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Summary extends Model	{
	private var taskFollowUpCount:Option[Int] = None
	private var callFollowUpCount:Option[Int] = None
	private var emailFollowUpCount:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTaskFollowUpCount() :Option[Int]	={
		return  this.taskFollowUpCount
	}

	def setTaskFollowUpCount( taskFollowUpCount: Option[Int]) 	={
		 this.taskFollowUpCount = taskFollowUpCount
		 this.keyModified("task_follow_up_count") = 1
	}

	def getCallFollowUpCount() :Option[Int]	={
		return  this.callFollowUpCount
	}

	def setCallFollowUpCount( callFollowUpCount: Option[Int]) 	={
		 this.callFollowUpCount = callFollowUpCount
		 this.keyModified("call_follow_up_count") = 1
	}

	def getEmailFollowUpCount() :Option[Int]	={
		return  this.emailFollowUpCount
	}

	def setEmailFollowUpCount( emailFollowUpCount: Option[Int]) 	={
		 this.emailFollowUpCount = emailFollowUpCount
		 this.keyModified("email_follow_up_count") = 1
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