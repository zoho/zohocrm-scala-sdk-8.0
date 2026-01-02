package com.zoho.crm.api.datasharing

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DataSharing extends Model	{
	private var shareType:Choice[String] = _
	private var publicInPortals:Option[Boolean] = None
	private var module:Option[Module] = None
	private var ruleComputationRunning:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShareType() :Choice[String]	={
		return  this.shareType
	}

	def setShareType( shareType: Choice[String]) 	={
		 this.shareType = shareType
		 this.keyModified("share_type") = 1
	}

	def getPublicInPortals() :Option[Boolean]	={
		return  this.publicInPortals
	}

	def setPublicInPortals( publicInPortals: Option[Boolean]) 	={
		 this.publicInPortals = publicInPortals
		 this.keyModified("public_in_portals") = 1
	}

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getRuleComputationRunning() :Option[Boolean]	={
		return  this.ruleComputationRunning
	}

	def setRuleComputationRunning( ruleComputationRunning: Option[Boolean]) 	={
		 this.ruleComputationRunning = ruleComputationRunning
		 this.keyModified("rule_computation_running") = 1
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