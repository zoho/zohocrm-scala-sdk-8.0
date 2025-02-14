package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Screen extends Model	{
	private var displayLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var id:Option[Long] = None
	private var referenceId:Option[String] = None
	private var conditionalRules:ArrayBuffer[ConditionalRules] = _
	private var segments:ArrayBuffer[Segment] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getReferenceId() :Option[String]	={
		return  this.referenceId
	}

	def setReferenceId( referenceId: Option[String]) 	={
		 this.referenceId = referenceId
		 this.keyModified("reference_id") = 1
	}

	def getConditionalRules() :ArrayBuffer[ConditionalRules]	={
		return  this.conditionalRules
	}

	def setConditionalRules( conditionalRules: ArrayBuffer[ConditionalRules]) 	={
		 this.conditionalRules = conditionalRules
		 this.keyModified("conditional_rules") = 1
	}

	def getSegments() :ArrayBuffer[Segment]	={
		return  this.segments
	}

	def setSegments( segments: ArrayBuffer[Segment]) 	={
		 this.segments = segments
		 this.keyModified("segments") = 1
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