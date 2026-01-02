package com.zoho.crm.api.timelines

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class PathFinder extends Model	{
	private var processEntry:Option[Boolean] = None
	private var processExit:Option[Boolean] = None
	private var state:Option[State] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getProcessEntry() :Option[Boolean]	={
		return  this.processEntry
	}

	def setProcessEntry( processEntry: Option[Boolean]) 	={
		 this.processEntry = processEntry
		 this.keyModified("process_entry") = 1
	}

	def getProcessExit() :Option[Boolean]	={
		return  this.processExit
	}

	def setProcessExit( processExit: Option[Boolean]) 	={
		 this.processExit = processExit
		 this.keyModified("process_exit") = 1
	}

	def getState() :Option[State]	={
		return  this.state
	}

	def setState( state: Option[State]) 	={
		 this.state = state
		 this.keyModified("state") = 1
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