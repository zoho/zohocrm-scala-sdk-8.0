package com.zoho.crm.api.conversionoption

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PreferenceFieldMatchedValue extends Model	{
	private var contacts:ArrayBuffer[PreferenceFieldMatch] = _
	private var accounts:ArrayBuffer[PreferenceFieldMatch] = _
	private var deals:ArrayBuffer[PreferenceFieldMatch] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getContacts() :ArrayBuffer[PreferenceFieldMatch]	={
		return  this.contacts
	}

	def setContacts( contacts: ArrayBuffer[PreferenceFieldMatch]) 	={
		 this.contacts = contacts
		 this.keyModified("Contacts") = 1
	}

	def getAccounts() :ArrayBuffer[PreferenceFieldMatch]	={
		return  this.accounts
	}

	def setAccounts( accounts: ArrayBuffer[PreferenceFieldMatch]) 	={
		 this.accounts = accounts
		 this.keyModified("Accounts") = 1
	}

	def getDeals() :ArrayBuffer[PreferenceFieldMatch]	={
		return  this.deals
	}

	def setDeals( deals: ArrayBuffer[PreferenceFieldMatch]) 	={
		 this.deals = deals
		 this.keyModified("Deals") = 1
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