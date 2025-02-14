package com.zoho.crm.api.recyclebin

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class RestoreAllRecords extends Model	{
	private var restoreAllRecords:Choice[Boolean] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRestoreAllRecords() :Choice[Boolean]	={
		return  this.restoreAllRecords
	}

	def setRestoreAllRecords( restoreAllRecords: Choice[Boolean]) 	={
		 this.restoreAllRecords = restoreAllRecords
		 this.keyModified("restore_all_records") = 1
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