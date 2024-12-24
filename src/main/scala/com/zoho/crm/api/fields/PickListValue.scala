package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class PickListValue extends Model	{
	private var colourCode:Option[String] = None
	private var actualValue:Option[String] = None
	private var type1:Choice[String] = _
	private var id:Option[Long] = None
	private var sequenceNumber:Option[Int] = None
	private var displayValue:Option[String] = None
	private var referenceValue:Option[String] = None
	private var dealCategory:Option[String] = None
	private var probability:Option[Int] = None
	private var forecastCategory:Option[ForecastCategory] = None
	private var expectedDataType:Option[String] = None
	private var sysRefName:Option[String] = None
	private var forecastType:Option[String] = None
	private var maps:ArrayBuffer[Maps] = _
	private var delete:Option[Boolean] = None
	private var showValue:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

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

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

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

	def getDealCategory() :Option[String]	={
		return  this.dealCategory
	}

	def setDealCategory( dealCategory: Option[String]) 	={
		 this.dealCategory = dealCategory
		 this.keyModified("deal_category") = 1
	}

	def getProbability() :Option[Int]	={
		return  this.probability
	}

	def setProbability( probability: Option[Int]) 	={
		 this.probability = probability
		 this.keyModified("probability") = 1
	}

	def getForecastCategory() :Option[ForecastCategory]	={
		return  this.forecastCategory
	}

	def setForecastCategory( forecastCategory: Option[ForecastCategory]) 	={
		 this.forecastCategory = forecastCategory
		 this.keyModified("forecast_category") = 1
	}

	def getExpectedDataType() :Option[String]	={
		return  this.expectedDataType
	}

	def setExpectedDataType( expectedDataType: Option[String]) 	={
		 this.expectedDataType = expectedDataType
		 this.keyModified("expected_data_type") = 1
	}

	def getSysRefName() :Option[String]	={
		return  this.sysRefName
	}

	def setSysRefName( sysRefName: Option[String]) 	={
		 this.sysRefName = sysRefName
		 this.keyModified("sys_ref_name") = 1
	}

	def getForecastType() :Option[String]	={
		return  this.forecastType
	}

	def setForecastType( forecastType: Option[String]) 	={
		 this.forecastType = forecastType
		 this.keyModified("forecast_type") = 1
	}

	def getMaps() :ArrayBuffer[Maps]	={
		return  this.maps
	}

	def setMaps( maps: ArrayBuffer[Maps]) 	={
		 this.maps = maps
		 this.keyModified("maps") = 1
	}

	def getDelete() :Option[Boolean]	={
		return  this.delete
	}

	def setDelete( delete: Option[Boolean]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
	}

	def getShowValue() :Option[Boolean]	={
		return  this.showValue
	}

	def setShowValue( showValue: Option[Boolean]) 	={
		 this.showValue = showValue
		 this.keyModified("show_value") = 1
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