package com.zoho.crm.api.massdeletecvid

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class RecordIdBodyWrapper extends Model	{
	private var ids:ArrayBuffer[Long] = _
	private var territory:Option[Territory] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getIds() :ArrayBuffer[Long]	={
		return  this.ids
	}

	def setIds( ids: ArrayBuffer[Long]) 	={
		 this.ids = ids
		 this.keyModified("ids") = 1
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