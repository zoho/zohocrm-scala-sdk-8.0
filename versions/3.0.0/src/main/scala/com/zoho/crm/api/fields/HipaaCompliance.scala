package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class HipaaCompliance extends Model	{
	private var restrictedInExport:Option[Boolean] = None
	private var restricted:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRestrictedInExport() :Option[Boolean]	={
		return  this.restrictedInExport
	}

	def setRestrictedInExport( restrictedInExport: Option[Boolean]) 	={
		 this.restrictedInExport = restrictedInExport
		 this.keyModified("restricted_in_export") = 1
	}

	def getRestricted() :Option[Boolean]	={
		return  this.restricted
	}

	def setRestricted( restricted: Option[Boolean]) 	={
		 this.restricted = restricted
		 this.keyModified("restricted") = 1
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