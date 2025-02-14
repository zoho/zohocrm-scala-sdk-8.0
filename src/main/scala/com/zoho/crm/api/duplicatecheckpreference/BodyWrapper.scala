package com.zoho.crm.api.duplicatecheckpreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class BodyWrapper extends Model	{
	private var duplicateCheckPreference:Option[DuplicateCheckPreference] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDuplicateCheckPreference() :Option[DuplicateCheckPreference]	={
		return  this.duplicateCheckPreference
	}

	def setDuplicateCheckPreference( duplicateCheckPreference: Option[DuplicateCheckPreference]) 	={
		 this.duplicateCheckPreference = duplicateCheckPreference
		 this.keyModified("duplicate_check_preference") = 1
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