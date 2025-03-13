package com.zoho.crm.api.conversionoption

import com.zoho.crm.api.modules.Modules
import com.zoho.crm.api.record.Record
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ConversionOptions extends Model	{
	private var modulePreference:Option[Modules] = None
	private var contacts:ArrayBuffer[Record] = _
	private var deals:ArrayBuffer[Record] = _
	private var accounts:ArrayBuffer[Record] = _
	private var preferenceFieldMatchedValue:Option[PreferenceFieldMatchedValue] = None
	private var modulesWithMultipleLayouts:ArrayBuffer[Modules] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModulePreference() :Option[Modules]	={
		return  this.modulePreference
	}

	def setModulePreference( modulePreference: Option[Modules]) 	={
		 this.modulePreference = modulePreference
		 this.keyModified("module_preference") = 1
	}

	def getContacts() :ArrayBuffer[Record]	={
		return  this.contacts
	}

	def setContacts( contacts: ArrayBuffer[Record]) 	={
		 this.contacts = contacts
		 this.keyModified("Contacts") = 1
	}

	def getDeals() :ArrayBuffer[Record]	={
		return  this.deals
	}

	def setDeals( deals: ArrayBuffer[Record]) 	={
		 this.deals = deals
		 this.keyModified("Deals") = 1
	}

	def getAccounts() :ArrayBuffer[Record]	={
		return  this.accounts
	}

	def setAccounts( accounts: ArrayBuffer[Record]) 	={
		 this.accounts = accounts
		 this.keyModified("Accounts") = 1
	}

	def getPreferenceFieldMatchedValue() :Option[PreferenceFieldMatchedValue]	={
		return  this.preferenceFieldMatchedValue
	}

	def setPreferenceFieldMatchedValue( preferenceFieldMatchedValue: Option[PreferenceFieldMatchedValue]) 	={
		 this.preferenceFieldMatchedValue = preferenceFieldMatchedValue
		 this.keyModified("preference_field_matched_value") = 1
	}

	def getModulesWithMultipleLayouts() :ArrayBuffer[Modules]	={
		return  this.modulesWithMultipleLayouts
	}

	def setModulesWithMultipleLayouts( modulesWithMultipleLayouts: ArrayBuffer[Modules]) 	={
		 this.modulesWithMultipleLayouts = modulesWithMultipleLayouts
		 this.keyModified("modules_with_multiple_layouts") = 1
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