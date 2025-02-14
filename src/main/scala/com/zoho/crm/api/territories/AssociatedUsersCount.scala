package com.zoho.crm.api.territories

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AssociatedUsersCount extends Model	{
	private var count:Option[String] = None
	private var territory:Option[MinifiedTerritory] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCount() :Option[String]	={
		return  this.count
	}

	def setCount( count: Option[String]) 	={
		 this.count = count
		 this.keyModified("count") = 1
	}

	def getTerritory() :Option[MinifiedTerritory]	={
		return  this.territory
	}

	def setTerritory( territory: Option[MinifiedTerritory]) 	={
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