package com.zoho.crm.api.massdeletetags

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class StatusResponseWrapper extends Model with StatusResponseHandler	{
	private var massDelete:ArrayBuffer[StatusActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMassDelete() :ArrayBuffer[StatusActionResponse]	={
		return  this.massDelete
	}

	def setMassDelete( massDelete: ArrayBuffer[StatusActionResponse]) 	={
		 this.massDelete = massDelete
		 this.keyModified("mass_delete") = 1
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