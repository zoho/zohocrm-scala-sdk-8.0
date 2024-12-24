package com.zoho.crm.api.timelines

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class FieldHistory extends Model	{
	private var dataType:Option[String] = None
	private var enableColourCode:Option[Boolean] = None
	private var pickListValues:ArrayBuffer[PicklistDetail] = _
	private var fieldLabel:Option[String] = None
	private var apiName:Option[String] = None
	private var id:Option[Long] = None
	private var value:Option[FieldHistoryValue] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDataType() :Option[String]	={
		return  this.dataType
	}

	def setDataType( dataType: Option[String]) 	={
		 this.dataType = dataType
		 this.keyModified("data_type") = 1
	}

	def getEnableColourCode() :Option[Boolean]	={
		return  this.enableColourCode
	}

	def setEnableColourCode( enableColourCode: Option[Boolean]) 	={
		 this.enableColourCode = enableColourCode
		 this.keyModified("enable_colour_code") = 1
	}

	def getPickListValues() :ArrayBuffer[PicklistDetail]	={
		return  this.pickListValues
	}

	def setPickListValues( pickListValues: ArrayBuffer[PicklistDetail]) 	={
		 this.pickListValues = pickListValues
		 this.keyModified("pick_list_values") = 1
	}

	def getFieldLabel() :Option[String]	={
		return  this.fieldLabel
	}

	def setFieldLabel( fieldLabel: Option[String]) 	={
		 this.fieldLabel = fieldLabel
		 this.keyModified("field_label") = 1
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

	def getValue() :Option[FieldHistoryValue]	={
		return  this.value
	}

	def setValue( value: Option[FieldHistoryValue]) 	={
		 this.value = value
		 this.keyModified("_value") = 1
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