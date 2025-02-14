package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class RulesSummary extends Model	{
	private var module:Option[Module] = None
	private var ruleComputationStatus:Option[Boolean] = None
	private var ruleCount:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getRuleComputationStatus() :Option[Boolean]	={
		return  this.ruleComputationStatus
	}

	def setRuleComputationStatus( ruleComputationStatus: Option[Boolean]) 	={
		 this.ruleComputationStatus = ruleComputationStatus
		 this.keyModified("rule_computation_status") = 1
	}

	def getRuleCount() :Option[Int]	={
		return  this.ruleCount
	}

	def setRuleCount( ruleCount: Option[Int]) 	={
		 this.ruleCount = ruleCount
		 this.keyModified("rule_count") = 1
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