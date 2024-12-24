package com.zoho.crm.api.cadencesexecution

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AnalyticsCall extends Model	{
	private var createdCallsCount:Option[Int] = None
	private var cancelledCallsCount:Option[Int] = None
	private var failedCallsCount:Option[Int] = None
	private var completedCallsCount:Option[Int] = None
	private var scheduledCallsCount:Option[Int] = None
	private var callsCount:Option[Int] = None
	private var overdueCallsCount:Option[Int] = None
	private var missedCallsCount:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCreatedCallsCount() :Option[Int]	={
		return  this.createdCallsCount
	}

	def setCreatedCallsCount( createdCallsCount: Option[Int]) 	={
		 this.createdCallsCount = createdCallsCount
		 this.keyModified("created_calls_count") = 1
	}

	def getCancelledCallsCount() :Option[Int]	={
		return  this.cancelledCallsCount
	}

	def setCancelledCallsCount( cancelledCallsCount: Option[Int]) 	={
		 this.cancelledCallsCount = cancelledCallsCount
		 this.keyModified("cancelled_calls_count") = 1
	}

	def getFailedCallsCount() :Option[Int]	={
		return  this.failedCallsCount
	}

	def setFailedCallsCount( failedCallsCount: Option[Int]) 	={
		 this.failedCallsCount = failedCallsCount
		 this.keyModified("failed_calls_count") = 1
	}

	def getCompletedCallsCount() :Option[Int]	={
		return  this.completedCallsCount
	}

	def setCompletedCallsCount( completedCallsCount: Option[Int]) 	={
		 this.completedCallsCount = completedCallsCount
		 this.keyModified("completed_calls_count") = 1
	}

	def getScheduledCallsCount() :Option[Int]	={
		return  this.scheduledCallsCount
	}

	def setScheduledCallsCount( scheduledCallsCount: Option[Int]) 	={
		 this.scheduledCallsCount = scheduledCallsCount
		 this.keyModified("scheduled_calls_count") = 1
	}

	def getCallsCount() :Option[Int]	={
		return  this.callsCount
	}

	def setCallsCount( callsCount: Option[Int]) 	={
		 this.callsCount = callsCount
		 this.keyModified("calls_count") = 1
	}

	def getOverdueCallsCount() :Option[Int]	={
		return  this.overdueCallsCount
	}

	def setOverdueCallsCount( overdueCallsCount: Option[Int]) 	={
		 this.overdueCallsCount = overdueCallsCount
		 this.keyModified("overdue_calls_count") = 1
	}

	def getMissedCallsCount() :Option[Int]	={
		return  this.missedCallsCount
	}

	def setMissedCallsCount( missedCallsCount: Option[Int]) 	={
		 this.missedCallsCount = missedCallsCount
		 this.keyModified("missed_calls_count") = 1
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