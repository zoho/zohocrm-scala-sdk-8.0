package com.zoho.crm.api.features

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Limit extends Model	{
	private var total:Option[Int] = None
	private var editionLimit:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTotal() :Option[Int]	={
		return  this.total
	}

	def setTotal( total: Option[Int]) 	={
		 this.total = total
		 this.keyModified("total") = 1
	}

	def getEditionLimit() :Option[Int]	={
		return  this.editionLimit
	}

	def setEditionLimit( editionLimit: Option[Int]) 	={
		 this.editionLimit = editionLimit
		 this.keyModified("edition_limit") = 1
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