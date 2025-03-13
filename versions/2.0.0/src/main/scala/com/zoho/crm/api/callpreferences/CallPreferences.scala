package com.zoho.crm.api.callpreferences

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class CallPreferences extends Model	{
	private var showFromNumber:Option[Boolean] = None
	private var showToNumber:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getShowFromNumber() :Option[Boolean]	={
		return  this.showFromNumber
	}

	def setShowFromNumber( showFromNumber: Option[Boolean]) 	={
		 this.showFromNumber = showFromNumber
		 this.keyModified("show_from_number") = 1
	}

	def getShowToNumber() :Option[Boolean]	={
		return  this.showToNumber
	}

	def setShowToNumber( showToNumber: Option[Boolean]) 	={
		 this.showToNumber = showToNumber
		 this.keyModified("show_to_number") = 1
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