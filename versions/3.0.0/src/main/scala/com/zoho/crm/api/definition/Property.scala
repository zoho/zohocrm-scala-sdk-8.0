package com.zoho.crm.api.definition

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Property extends Model	{
	private var displayLabel:Option[String] = None
	private var allowedValues:ArrayBuffer[Any] = _
	private var uiType:Option[Int] = None
	private var regex:Option[String] = None
	private var readOnly:Option[Boolean] = None
	private var apiName:Option[String] = None
	private var fieldLabel:Option[String] = None
	private var dataType:Option[String] = None
	private var length:Option[Int] = None
	private var availableInUserLayout:Option[Boolean] = None
	private var required:Option[Boolean] = None
	private var properties:ArrayBuffer[MinifiedProperty] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getAllowedValues() :ArrayBuffer[Any]	={
		return  this.allowedValues
	}

	def setAllowedValues( allowedValues: ArrayBuffer[Any]) 	={
		 this.allowedValues = allowedValues
		 this.keyModified("allowed_values") = 1
	}

	def getUiType() :Option[Int]	={
		return  this.uiType
	}

	def setUiType( uiType: Option[Int]) 	={
		 this.uiType = uiType
		 this.keyModified("ui_type") = 1
	}

	def getRegex() :Option[String]	={
		return  this.regex
	}

	def setRegex( regex: Option[String]) 	={
		 this.regex = regex
		 this.keyModified("regex") = 1
	}

	def getReadOnly() :Option[Boolean]	={
		return  this.readOnly
	}

	def setReadOnly( readOnly: Option[Boolean]) 	={
		 this.readOnly = readOnly
		 this.keyModified("read_only") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getFieldLabel() :Option[String]	={
		return  this.fieldLabel
	}

	def setFieldLabel( fieldLabel: Option[String]) 	={
		 this.fieldLabel = fieldLabel
		 this.keyModified("field_label") = 1
	}

	def getDataType() :Option[String]	={
		return  this.dataType
	}

	def setDataType( dataType: Option[String]) 	={
		 this.dataType = dataType
		 this.keyModified("data_type") = 1
	}

	def getLength() :Option[Int]	={
		return  this.length
	}

	def setLength( length: Option[Int]) 	={
		 this.length = length
		 this.keyModified("length") = 1
	}

	def getAvailableInUserLayout() :Option[Boolean]	={
		return  this.availableInUserLayout
	}

	def setAvailableInUserLayout( availableInUserLayout: Option[Boolean]) 	={
		 this.availableInUserLayout = availableInUserLayout
		 this.keyModified("available_in_user_layout") = 1
	}

	def getRequired() :Option[Boolean]	={
		return  this.required
	}

	def setRequired( required: Option[Boolean]) 	={
		 this.required = required
		 this.keyModified("required") = 1
	}

	def getProperties() :ArrayBuffer[MinifiedProperty]	={
		return  this.properties
	}

	def setProperties( properties: ArrayBuffer[MinifiedProperty]) 	={
		 this.properties = properties
		 this.keyModified("properties") = 1
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