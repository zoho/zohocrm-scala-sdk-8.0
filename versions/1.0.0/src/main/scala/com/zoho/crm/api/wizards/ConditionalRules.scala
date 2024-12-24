package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ConditionalRules extends Model	{
	private var queryId:Option[Long] = None
	private var executeOn:Choice[String] = _
	private var criteria:Option[Criteria] = None
	private var actions:ArrayBuffer[Actions] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getQueryId() :Option[Long]	={
		return  this.queryId
	}

	def setQueryId( queryId: Option[Long]) 	={
		 this.queryId = queryId
		 this.keyModified("query_id") = 1
	}

	def getExecuteOn() :Choice[String]	={
		return  this.executeOn
	}

	def setExecuteOn( executeOn: Choice[String]) 	={
		 this.executeOn = executeOn
		 this.keyModified("execute_on") = 1
	}

	def getCriteria() :Option[Criteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Criteria]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
	}

	def getActions() :ArrayBuffer[Actions]	={
		return  this.actions
	}

	def setActions( actions: ArrayBuffer[Actions]) 	={
		 this.actions = actions
		 this.keyModified("actions") = 1
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