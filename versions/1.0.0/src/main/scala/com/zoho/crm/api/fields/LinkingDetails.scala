package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class LinkingDetails extends Model	{
	private var module:Option[LinkingModule] = None
	private var lookupField:Option[LookupField] = None
	private var connectedLookupField:Option[LookupField] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[LinkingModule]	={
		return  this.module
	}

	def setModule( module: Option[LinkingModule]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getLookupField() :Option[LookupField]	={
		return  this.lookupField
	}

	def setLookupField( lookupField: Option[LookupField]) 	={
		 this.lookupField = lookupField
		 this.keyModified("lookup_field") = 1
	}

	def getConnectedLookupField() :Option[LookupField]	={
		return  this.connectedLookupField
	}

	def setConnectedLookupField( connectedLookupField: Option[LookupField]) 	={
		 this.connectedLookupField = connectedLookupField
		 this.keyModified("connected_lookup_field") = 1
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