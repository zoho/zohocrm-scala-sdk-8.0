package com.zoho.crm.api.scoringrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FieldRule extends Model	{
	private var score:Option[Int] = None
	private var criteria:Option[Criteria] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getScore() :Option[Int]	={
		return  this.score
	}

	def setScore( score: Option[Int]) 	={
		 this.score = score
		 this.keyModified("score") = 1
	}

	def getCriteria() :Option[Criteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Criteria]) 	={
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