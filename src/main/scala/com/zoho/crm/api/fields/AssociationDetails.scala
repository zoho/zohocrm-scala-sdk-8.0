package com.zoho.crm.api.fields

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AssociationDetails extends Model	{
	private var relatedField:Option[MinifiedModule] = None
	private var lookupField:Option[MinifiedModule] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRelatedField() :Option[MinifiedModule]	={
		return  this.relatedField
	}

	def setRelatedField( relatedField: Option[MinifiedModule]) 	={
		 this.relatedField = relatedField
		 this.keyModified("related_field") = 1
	}

	def getLookupField() :Option[MinifiedModule]	={
		return  this.lookupField
	}

	def setLookupField( lookupField: Option[MinifiedModule]) 	={
		 this.lookupField = lookupField
		 this.keyModified("lookup_field") = 1
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