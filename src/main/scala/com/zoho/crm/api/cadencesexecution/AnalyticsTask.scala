package com.zoho.crm.api.cadencesexecution

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AnalyticsTask extends Model	{
	private var openTasksCount:Option[Int] = None
	private var failedTasksCount:Option[Int] = None
	private var subject:Option[String] = None
	private var completedTasksCount:Option[Int] = None
	private var createdTasksCount:Option[Int] = None
	private var tasksCount:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOpenTasksCount() :Option[Int]	={
		return  this.openTasksCount
	}

	def setOpenTasksCount( openTasksCount: Option[Int]) 	={
		 this.openTasksCount = openTasksCount
		 this.keyModified("open_tasks_count") = 1
	}

	def getFailedTasksCount() :Option[Int]	={
		return  this.failedTasksCount
	}

	def setFailedTasksCount( failedTasksCount: Option[Int]) 	={
		 this.failedTasksCount = failedTasksCount
		 this.keyModified("failed_tasks_count") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getCompletedTasksCount() :Option[Int]	={
		return  this.completedTasksCount
	}

	def setCompletedTasksCount( completedTasksCount: Option[Int]) 	={
		 this.completedTasksCount = completedTasksCount
		 this.keyModified("completed_tasks_count") = 1
	}

	def getCreatedTasksCount() :Option[Int]	={
		return  this.createdTasksCount
	}

	def setCreatedTasksCount( createdTasksCount: Option[Int]) 	={
		 this.createdTasksCount = createdTasksCount
		 this.keyModified("created_tasks_count") = 1
	}

	def getTasksCount() :Option[Int]	={
		return  this.tasksCount
	}

	def setTasksCount( tasksCount: Option[Int]) 	={
		 this.tasksCount = tasksCount
		 this.keyModified("tasks_count") = 1
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