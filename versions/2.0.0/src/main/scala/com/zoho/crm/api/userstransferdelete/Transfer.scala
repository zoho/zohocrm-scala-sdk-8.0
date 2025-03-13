package com.zoho.crm.api.userstransferdelete

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Transfer extends Model	{
	private var records:Option[Boolean] = None
	private var assignment:Option[Boolean] = None
	private var criteria:Option[Boolean] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRecords() :Option[Boolean]	={
		return  this.records
	}

	def setRecords( records: Option[Boolean]) 	={
		 this.records = records
		 this.keyModified("records") = 1
	}

	def getAssignment() :Option[Boolean]	={
		return  this.assignment
	}

	def setAssignment( assignment: Option[Boolean]) 	={
		 this.assignment = assignment
		 this.keyModified("assignment") = 1
	}

	def getCriteria() :Option[Boolean]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Boolean]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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