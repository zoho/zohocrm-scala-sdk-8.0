package com.zoho.crm.api.backup

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class History extends Model	{
	private var id:Option[Long] = None
	private var logTime:Option[OffsetDateTime] = None
	private var action:Option[String] = None
	private var repeatType:Option[String] = None
	private var count:Option[Int] = None
	private var fileName:Option[String] = None
	private var state:Option[String] = None
	private var doneBy:Option[Requester] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getLogTime() :Option[OffsetDateTime]	={
		return  this.logTime
	}

	def setLogTime( logTime: Option[OffsetDateTime]) 	={
		 this.logTime = logTime
		 this.keyModified("log_time") = 1
	}

	def getAction() :Option[String]	={
		return  this.action
	}

	def setAction( action: Option[String]) 	={
		 this.action = action
		 this.keyModified("action") = 1
	}

	def getRepeatType() :Option[String]	={
		return  this.repeatType
	}

	def setRepeatType( repeatType: Option[String]) 	={
		 this.repeatType = repeatType
		 this.keyModified("repeat_type") = 1
	}

	def getCount() :Option[Int]	={
		return  this.count
	}

	def setCount( count: Option[Int]) 	={
		 this.count = count
		 this.keyModified("count") = 1
	}

	def getFileName() :Option[String]	={
		return  this.fileName
	}

	def setFileName( fileName: Option[String]) 	={
		 this.fileName = fileName
		 this.keyModified("file_name") = 1
	}

	def getState() :Option[String]	={
		return  this.state
	}

	def setState( state: Option[String]) 	={
		 this.state = state
		 this.keyModified("state") = 1
	}

	def getDoneBy() :Option[Requester]	={
		return  this.doneBy
	}

	def setDoneBy( doneBy: Option[Requester]) 	={
		 this.doneBy = doneBy
		 this.keyModified("done_by") = 1
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