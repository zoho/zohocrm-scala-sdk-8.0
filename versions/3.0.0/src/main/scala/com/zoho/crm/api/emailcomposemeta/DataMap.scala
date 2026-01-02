package com.zoho.crm.api.emailcomposemeta

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class DataMap extends Model	{
	private var user:Option[User] = None
	private var featuresAvailable:Option[FeaturesAvailable] = None
	private var fromAddress:ArrayBuffer[FromAddress] = _
	private var relayDomains:ArrayBuffer[String] = _
	private var mergefieldsdata:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUser() :Option[User]	={
		return  this.user
	}

	def setUser( user: Option[User]) 	={
		 this.user = user
		 this.keyModified("user") = 1
	}

	def getFeaturesAvailable() :Option[FeaturesAvailable]	={
		return  this.featuresAvailable
	}

	def setFeaturesAvailable( featuresAvailable: Option[FeaturesAvailable]) 	={
		 this.featuresAvailable = featuresAvailable
		 this.keyModified("features_available") = 1
	}

	def getFromAddress() :ArrayBuffer[FromAddress]	={
		return  this.fromAddress
	}

	def setFromAddress( fromAddress: ArrayBuffer[FromAddress]) 	={
		 this.fromAddress = fromAddress
		 this.keyModified("from_address") = 1
	}

	def getRelayDomains() :ArrayBuffer[String]	={
		return  this.relayDomains
	}

	def setRelayDomains( relayDomains: ArrayBuffer[String]) 	={
		 this.relayDomains = relayDomains
		 this.keyModified("relay_domains") = 1
	}

	def getMergefieldsdata() :Option[String]	={
		return  this.mergefieldsdata
	}

	def setMergefieldsdata( mergefieldsdata: Option[String]) 	={
		 this.mergefieldsdata = mergefieldsdata
		 this.keyModified("mergeFieldsData") = 1
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