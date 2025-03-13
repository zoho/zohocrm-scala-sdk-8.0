package com.zoho.crm.api.wizards

import com.zoho.crm.api.fields.Fields
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Segment extends Model	{
	private var sequenceNumber:Option[Int] = None
	private var displayLabel:Option[String] = None
	private var columnCount:Option[Int] = None
	private var id:Option[Long] = None
	private var type1:Option[String] = None
	private var fields:ArrayBuffer[Fields] = _
	private var buttons:ArrayBuffer[Button] = _
	private var elements:ArrayBuffer[Element] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getColumnCount() :Option[Int]	={
		return  this.columnCount
	}

	def setColumnCount( columnCount: Option[Int]) 	={
		 this.columnCount = columnCount
		 this.keyModified("column_count") = 1
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

	def getFields() :ArrayBuffer[Fields]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[Fields]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	def getButtons() :ArrayBuffer[Button]	={
		return  this.buttons
	}

	def setButtons( buttons: ArrayBuffer[Button]) 	={
		 this.buttons = buttons
		 this.keyModified("buttons") = 1
	}

	def getElements() :ArrayBuffer[Element]	={
		return  this.elements
	}

	def setElements( elements: ArrayBuffer[Element]) 	={
		 this.elements = elements
		 this.keyModified("elements") = 1
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