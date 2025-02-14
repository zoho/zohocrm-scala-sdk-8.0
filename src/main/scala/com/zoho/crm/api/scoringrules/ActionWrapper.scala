package com.zoho.crm.api.scoringrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ActionWrapper extends Model with ActionHandler	{
	private var scoringRules:ArrayBuffer[ActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getScoringRules() :ArrayBuffer[ActionResponse]	={
		return  this.scoringRules
	}

	def setScoringRules( scoringRules: ArrayBuffer[ActionResponse]) 	={
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