package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Multiselectlookup extends Model	{
	private var linkingDetails:Option[LinkingDetails] = None
	private var connectedDetails:Option[ConnectedDetails] = None
	private var relatedList:Option[LookupRelatedList] = None
	private var recordAccess:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLinkingDetails() :Option[LinkingDetails]	={
		return  this.linkingDetails
	}

	def setLinkingDetails( linkingDetails: Option[LinkingDetails]) 	={
		 this.linkingDetails = linkingDetails
		 this.keyModified("linking_details") = 1
	}

	def getConnectedDetails() :Option[ConnectedDetails]	={
		return  this.connectedDetails
	}

	def setConnectedDetails( connectedDetails: Option[ConnectedDetails]) 	={
		 this.connectedDetails = connectedDetails
		 this.keyModified("connected_details") = 1
	}

	def getRelatedList() :Option[LookupRelatedList]	={
		return  this.relatedList
	}

	def setRelatedList( relatedList: Option[LookupRelatedList]) 	={
		 this.relatedList = relatedList
		 this.keyModified("related_list") = 1
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