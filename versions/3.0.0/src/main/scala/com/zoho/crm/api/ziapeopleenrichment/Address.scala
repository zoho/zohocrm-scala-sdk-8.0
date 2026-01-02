package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Address extends Model	{
	private var continent:Option[String] = None
	private var country:Option[String] = None
	private var name:Option[String] = None
	private var region:Option[String] = None
	private var primary:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getContinent() :Option[String]	={
		return  this.continent
	}

	def setContinent( continent: Option[String]) 	={
		 this.continent = continent
		 this.keyModified("continent") = 1
	}

	def getCountry() :Option[String]	={
		return  this.country
	}

	def setCountry( country: Option[String]) 	={
		 this.country = country
		 this.keyModified("country") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getRegion() :Option[String]	={
		return  this.region
	}

	def setRegion( region: Option[String]) 	={
		 this.region = region
		 this.keyModified("region") = 1
	}

	def getPrimary() :Option[Boolean]	={
		return  this.primary
	}

	def setPrimary( primary: Option[Boolean]) 	={
		 this.primary = primary
		 this.keyModified("primary") = 1
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