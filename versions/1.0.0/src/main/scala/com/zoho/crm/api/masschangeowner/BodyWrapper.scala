package com.zoho.crm.api.masschangeowner

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class BodyWrapper extends Model	{
	private var cvid:Option[Long] = None
	private var owner:Option[Owner] = None
	private var criteria:Option[Criteria] = None
	private var territory:Option[Territory] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCvid() :Option[Long]	={
		return  this.cvid
	}

	def setCvid( cvid: Option[Long]) 	={
		 this.cvid = cvid
		 this.keyModified("cvid") = 1
	}

	def getOwner() :Option[Owner]	={
		return  this.owner
	}

	def setOwner( owner: Option[Owner]) 	={
		 this.owner = owner
		 this.keyModified("owner") = 1
	}

	def getCriteria() :Option[Criteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Criteria]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
	}

	def getTerritory() :Option[Territory]	={
		return  this.territory
	}

	def setTerritory( territory: Option[Territory]) 	={
		 this.territory = territory
		 this.keyModified("territory") = 1
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