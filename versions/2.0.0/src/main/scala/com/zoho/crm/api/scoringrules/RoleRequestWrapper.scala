package com.zoho.crm.api.scoringrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class RoleRequestWrapper extends Model	{
	private var scoringRules:ArrayBuffer[Long] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getScoringRules() :ArrayBuffer[Long]	={
		return  this.scoringRules
	}

	def setScoringRules( scoringRules: ArrayBuffer[Long]) 	={
		 this.scoringRules = scoringRules
		 this.keyModified("scoring_rules") = 1
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