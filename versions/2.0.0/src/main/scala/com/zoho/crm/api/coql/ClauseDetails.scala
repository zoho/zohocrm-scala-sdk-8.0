package com.zoho.crm.api.coql

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ClauseDetails extends Model with DetailsWrapper	{
	private var clause:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getClause() :Option[String]	={
		return  this.clause
	}

	def setClause( clause: Option[String]) 	={
		 this.clause = clause
		 this.keyModified("clause") = 1
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