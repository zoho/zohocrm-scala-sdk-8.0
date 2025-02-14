package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class CompanyInfo extends Model	{
	private var name:Option[String] = None
	private var industries:ArrayBuffer[Industry] = _
	private var experiences:ArrayBuffer[Experience] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getIndustries() :ArrayBuffer[Industry]	={
		return  this.industries
	}

	def setIndustries( industries: ArrayBuffer[Industry]) 	={
		 this.industries = industries
		 this.keyModified("industries") = 1
	}

	def getExperiences() :ArrayBuffer[Experience]	={
		return  this.experiences
	}

	def setExperiences( experiences: ArrayBuffer[Experience]) 	={
		 this.experiences = experiences
		 this.keyModified("experiences") = 1
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