package com.zoho.crm.api.fiscalyear

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class BodyWrapper extends Model	{
	private var fiscalYear:Option[Year] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFiscalYear() :Option[Year]	={
		return  this.fiscalYear
	}

	def setFiscalYear( fiscalYear: Option[Year]) 	={
		 this.fiscalYear = fiscalYear
		 this.keyModified("fiscal_year") = 1
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