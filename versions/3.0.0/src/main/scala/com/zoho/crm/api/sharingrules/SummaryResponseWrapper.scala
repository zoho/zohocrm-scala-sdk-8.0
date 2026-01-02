package com.zoho.crm.api.sharingrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class SummaryResponseWrapper extends Model with SummaryResponseHandler	{
	private var sharingRulesSummary:ArrayBuffer[RulesSummary] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSharingRulesSummary() :ArrayBuffer[RulesSummary]	={
		return  this.sharingRulesSummary
	}

	def setSharingRulesSummary( sharingRulesSummary: ArrayBuffer[RulesSummary]) 	={
		 this.sharingRulesSummary = sharingRulesSummary
		 this.keyModified("sharing_rules_summary") = 1
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