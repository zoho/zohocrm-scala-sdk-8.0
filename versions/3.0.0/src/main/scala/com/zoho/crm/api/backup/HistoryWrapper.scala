package com.zoho.crm.api.backup

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class HistoryWrapper extends Model with ResponseHandler	{
	private var history:ArrayBuffer[History] = _
	private var info:Option[Info] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getHistory() :ArrayBuffer[History]	={
		return  this.history
	}

	def setHistory( history: ArrayBuffer[History]) 	={
		 this.history = history
		 this.keyModified("history") = 1
	}

	def getInfo() :Option[Info]	={
		return  this.info
	}

	def setInfo( info: Option[Info]) 	={
		 this.info = info
		 this.keyModified("info") = 1
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