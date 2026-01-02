package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ResponseWrapper extends Model with ResponseHandler	{
	private var wizards:ArrayBuffer[Wizard] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getWizards() :ArrayBuffer[Wizard]	={
		return  this.wizards
	}

	def setWizards( wizards: ArrayBuffer[Wizard]) 	={
		 this.wizards = wizards
		 this.keyModified("wizards") = 1
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