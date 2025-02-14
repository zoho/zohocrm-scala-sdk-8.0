package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class GetUnassignBodyWrapper extends Model	{
	private var getUnassigned:Option[Assign] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getGetUnassigned() :Option[Assign]	={
		return  this.getUnassigned
	}

	def setGetUnassigned( getUnassigned: Option[Assign]) 	={
		 this.getUnassigned = getUnassigned
		 this.keyModified("get_unassigned") = 1
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