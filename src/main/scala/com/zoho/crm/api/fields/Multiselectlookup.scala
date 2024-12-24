package com.zoho.crm.api.fields

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Multiselectlookup extends Model	{
	private var displayLabel:Option[String] = None
	private var linkingModule:Option[MinifiedModule] = None
	private var connectedModule:Option[MinifiedModule] = None
	private var lookupApiname:Option[String] = None
	private var apiName:Option[String] = None
	private var connectedfieldApiname:Option[String] = None
	private var connectedlookupApiname:Option[String] = None
	private var id:Option[Long] = None
	private var recordAccess:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getLinkingModule() :Option[MinifiedModule]	={
		return  this.linkingModule
	}

	def setLinkingModule( linkingModule: Option[MinifiedModule]) 	={
		 this.linkingModule = linkingModule
		 this.keyModified("linking_module") = 1
	}

	def getConnectedModule() :Option[MinifiedModule]	={
		return  this.connectedModule
	}

	def setConnectedModule( connectedModule: Option[MinifiedModule]) 	={
		 this.connectedModule = connectedModule
		 this.keyModified("connected_module") = 1
	}

	def getLookupApiname() :Option[String]	={
		return  this.lookupApiname
	}

	def setLookupApiname( lookupApiname: Option[String]) 	={
		 this.lookupApiname = lookupApiname
		 this.keyModified("lookup_apiname") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getConnectedfieldApiname() :Option[String]	={
		return  this.connectedfieldApiname
	}

	def setConnectedfieldApiname( connectedfieldApiname: Option[String]) 	={
		 this.connectedfieldApiname = connectedfieldApiname
		 this.keyModified("connectedfield_apiname") = 1
	}

	def getConnectedlookupApiname() :Option[String]	={
		return  this.connectedlookupApiname
	}

	def setConnectedlookupApiname( connectedlookupApiname: Option[String]) 	={
		 this.connectedlookupApiname = connectedlookupApiname
		 this.keyModified("connectedlookup_apiname") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getRecordAccess() :Option[Boolean]	={
		return  this.recordAccess
	}

	def setRecordAccess( recordAccess: Option[Boolean]) 	={
		 this.recordAccess = recordAccess
		 this.keyModified("record_access") = 1
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