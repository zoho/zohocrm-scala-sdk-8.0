package com.zoho.crm.api.profiles

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Info extends Model	{
	private var licenseLimit:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLicenseLimit() :Option[Int]	={
		return  this.licenseLimit
	}

	def setLicenseLimit( licenseLimit: Option[Int]) 	={
		 this.licenseLimit = licenseLimit
		 this.keyModified("license_limit") = 1
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