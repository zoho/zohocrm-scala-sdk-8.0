package com.zoho.crm.api.fieldmapdependency

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var mapDependency:ArrayBuffer[MapDependency] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMapDependency() :ArrayBuffer[MapDependency]	={
		return  this.mapDependency
	}

	def setMapDependency( mapDependency: ArrayBuffer[MapDependency]) 	={
		 this.mapDependency = mapDependency
		 this.keyModified("map_dependency") = 1
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