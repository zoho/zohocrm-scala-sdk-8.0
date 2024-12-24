package com.zoho.crm.api.backup

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionWrapper extends Model with ActionHandler	{
	private var backup:Option[ActionResponse] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getBackup() :Option[ActionResponse]	={
		return  this.backup
	}

	def setBackup( backup: Option[ActionResponse]) 	={
		 this.backup = backup
		 this.keyModified("backup") = 1
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