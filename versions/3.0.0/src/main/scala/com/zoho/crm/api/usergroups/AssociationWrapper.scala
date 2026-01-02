package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AssociationWrapper extends Model with ResponseHandler	{
	private var associations:ArrayBuffer[AssociationResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAssociations() :ArrayBuffer[AssociationResponse]	={
		return  this.associations
	}

	def setAssociations( associations: ArrayBuffer[AssociationResponse]) 	={
		 this.associations = associations
		 this.keyModified("associations") = 1
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