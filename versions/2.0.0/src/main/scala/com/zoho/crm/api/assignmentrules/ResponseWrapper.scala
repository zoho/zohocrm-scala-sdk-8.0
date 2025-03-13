package com.zoho.crm.api.assignmentrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var assignmentRules:ArrayBuffer[AssignmentRules] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAssignmentRules() :ArrayBuffer[AssignmentRules]	={
		return  this.assignmentRules
	}

	def setAssignmentRules( assignmentRules: ArrayBuffer[AssignmentRules]) 	={
		 this.assignmentRules = assignmentRules
		 this.keyModified("assignment_rules") = 1
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