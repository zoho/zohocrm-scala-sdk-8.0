package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Address extends Model	{
	private var country:Option[String] = None
	private var city:Option[String] = None
	private var pinCode:Option[String] = None
	private var state:Option[String] = None
	private var fillAddress:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCountry() :Option[String]	={
		return  this.country
	}

	def setCountry( country: Option[String]) 	={
		 this.country = country
		 this.keyModified("country") = 1
	}

	def getCity() :Option[String]	={
		return  this.city
	}

	def setCity( city: Option[String]) 	={
		 this.city = city
		 this.keyModified("city") = 1
	}

	def getPinCode() :Option[String]	={
		return  this.pinCode
	}

	def setPinCode( pinCode: Option[String]) 	={
		 this.pinCode = pinCode
		 this.keyModified("pin_code") = 1
	}

	def getState() :Option[String]	={
		return  this.state
	}

	def setState( state: Option[String]) 	={
		 this.state = state
		 this.keyModified("state") = 1
	}

	def getFillAddress() :Option[String]	={
		return  this.fillAddress
	}

	def setFillAddress( fillAddress: Option[String]) 	={
		 this.fillAddress = fillAddress
		 this.keyModified("fill_address") = 1
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