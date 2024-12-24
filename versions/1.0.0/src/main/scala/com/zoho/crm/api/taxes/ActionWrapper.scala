package com.zoho.crm.api.taxes

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionWrapper extends Model with ActionHandler	{
	private var orgTaxes:Option[ActionResponse] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOrgTaxes() :Option[ActionResponse]	={
		return  this.orgTaxes
	}

	def setOrgTaxes( orgTaxes: Option[ActionResponse]) 	={
		 this.orgTaxes = orgTaxes
		 this.keyModified("org_taxes") = 1
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