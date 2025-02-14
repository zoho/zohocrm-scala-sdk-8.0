package com.zoho.crm.api.org

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class HierarchyPreferences extends Model	{
	private var type1:Choice[String] = _
	private var strictlyReporting:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getStrictlyReporting() :Option[Boolean]	={
		return  this.strictlyReporting
	}

	def setStrictlyReporting( strictlyReporting: Option[Boolean]) 	={
		 this.strictlyReporting = strictlyReporting
		 this.keyModified("strictly_reporting") = 1
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