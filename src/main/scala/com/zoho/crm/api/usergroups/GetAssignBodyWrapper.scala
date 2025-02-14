package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class GetAssignBodyWrapper extends Model	{
	private var getAssigned:Option[Assign] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getGetAssigned() :Option[Assign]	={
		return  this.getAssigned
	}

	def setGetAssigned( getAssigned: Option[Assign]) 	={
		 this.getAssigned = getAssigned
		 this.keyModified("get_assigned") = 1
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