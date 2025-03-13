package com.zoho.crm.api.massdeletetags

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var massDelete:ArrayBuffer[MassDelete] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMassDelete() :ArrayBuffer[MassDelete]	={
		return  this.massDelete
	}

	def setMassDelete( massDelete: ArrayBuffer[MassDelete]) 	={
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