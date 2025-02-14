package com.zoho.crm.api.wizards

import com.zoho.crm.api.fields.Fields
import com.zoho.crm.api.profiles.Profile
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Actions extends Model	{
	private var id:Option[Long] = None
	private var type1:Option[String] = None
	private var segment:Option[Segment] = None
	private var fields:Option[Fields] = None
	private var field:Option[Fields] = None
	private var value:Any = None
	private var exemptedProfiles:ArrayBuffer[Profile] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getSegment() :Option[Segment]	={
		return  this.segment
	}

	def setSegment( segment: Option[Segment]) 	={
		 this.segment = segment
		 this.keyModified("segment") = 1
	}

	def getFields() :Option[Fields]	={
		return  this.fields
	}

	def setFields( fields: Option[Fields]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	def getField() :Option[Fields]	={
		return  this.field
	}

	def setField( field: Option[Fields]) 	={
		 this.field = field
		 this.keyModified("field") = 1
	}

	def getValue() :Any	={
		return  this.value
	}

	def setValue( value: Any) 	={
		 this.value = value
		 this.keyModified("value") = 1
	}

	def getExemptedProfiles() :ArrayBuffer[Profile]	={
		return  this.exemptedProfiles
	}

	def setExemptedProfiles( exemptedProfiles: ArrayBuffer[Profile]) 	={
		 this.exemptedProfiles = exemptedProfiles
		 this.keyModified("exempted_profiles") = 1
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