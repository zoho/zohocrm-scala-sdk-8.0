package com.zoho.crm.api.picklistvalues

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PickListValues extends Model	{
	private var sequenceNumber:Option[Int] = None
	private var displayValue:Option[String] = None
	private var referenceValue:Option[String] = None
	private var colourCode:Option[String] = None
	private var actualValue:Option[String] = None
	private var id:Option[Long] = None
	private var type1:Option[String] = None
	private var layoutAssociations:ArrayBuffer[LayoutAssociation] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getDisplayValue() :Option[String]	={
		return  this.displayValue
	}

	def setDisplayValue( displayValue: Option[String]) 	={
		 this.displayValue = displayValue
		 this.keyModified("display_value") = 1
	}

	def getReferenceValue() :Option[String]	={
		return  this.referenceValue
	}

	def setReferenceValue( referenceValue: Option[String]) 	={
		 this.referenceValue = referenceValue
		 this.keyModified("reference_value") = 1
	}

	def getColourCode() :Option[String]	={
		return  this.colourCode
	}

	def setColourCode( colourCode: Option[String]) 	={
		 this.colourCode = colourCode
		 this.keyModified("colour_code") = 1
	}

	def getActualValue() :Option[String]	={
		return  this.actualValue
	}

	def setActualValue( actualValue: Option[String]) 	={
		 this.actualValue = actualValue
		 this.keyModified("actual_value") = 1
	}

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

	def getLayoutAssociations() :ArrayBuffer[LayoutAssociation]	={
		return  this.layoutAssociations
	}

	def setLayoutAssociations( layoutAssociations: ArrayBuffer[LayoutAssociation]) 	={
		 this.layoutAssociations = layoutAssociations
		 this.keyModified("layout_associations") = 1
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