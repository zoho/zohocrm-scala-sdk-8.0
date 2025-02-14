package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class QueryDetails extends Model	{
	private var queryId:Option[Long] = None
	private var criteria:Option[Criteria] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getQueryId() :Option[Long]	={
		return  this.queryId
	}

	def setQueryId( queryId: Option[Long]) 	={
		 this.queryId = queryId
		 this.keyModified("query_id") = 1
	}

	def getCriteria() :Option[Criteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Criteria]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
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