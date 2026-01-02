package com.zoho.crm.api.globalpicklists

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PickListValuesAssociationsResponseWrapper extends Model with PickListValuesAssociationsResponseHandler	{
	private var pickListValuesAssociations:ArrayBuffer[PickListValuesAssociation] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPickListValuesAssociations() :ArrayBuffer[PickListValuesAssociation]	={
		return  this.pickListValuesAssociations
	}

	def setPickListValuesAssociations( pickListValuesAssociations: ArrayBuffer[PickListValuesAssociation]) 	={
		 this.pickListValuesAssociations = pickListValuesAssociations
		 this.keyModified("pick_list_values_associations") = 1
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