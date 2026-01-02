package com.zoho.crm.api.auditlogexport

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var auditLogExport:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAuditLogExport() :ArrayBuffer[ActionResponse]	={
		return  this.auditLogExport
	}

	def setAuditLogExport( auditLogExport: ArrayBuffer[ActionResponse]) 	={
		 this.auditLogExport = auditLogExport
		 this.keyModified("audit_log_export") = 1
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