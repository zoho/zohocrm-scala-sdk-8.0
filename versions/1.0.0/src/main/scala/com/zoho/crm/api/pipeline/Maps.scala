package com.zoho.crm.api.pipeline

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Maps extends Model	{
	private var displayValue:Option[String] = None
	private var sequenceNumber:Option[Int] = None
	private var forecastCategory:Option[ForecastCategory] = None
	private var delete:Option[Boolean] = None
	private var actualValue:Option[String] = None
	private var id:Option[Long] = None
	private var colourCode:Option[String] = None
	private var forecastType:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayValue() :Option[String]	={
		return  this.displayValue
	}

	def setDisplayValue( displayValue: Option[String]) 	={
		 this.displayValue = displayValue
		 this.keyModified("display_value") = 1
	}

	def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getForecastCategory() :Option[ForecastCategory]	={
		return  this.forecastCategory
	}

	def setForecastCategory( forecastCategory: Option[ForecastCategory]) 	={
		 this.forecastCategory = forecastCategory
		 this.keyModified("forecast_category") = 1
	}

	def getDelete() :Option[Boolean]	={
		return  this.delete
	}

	def setDelete( delete: Option[Boolean]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
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

	def getColourCode() :Option[String]	={
		return  this.colourCode
	}

	def setColourCode( colourCode: Option[String]) 	={
		 this.colourCode = colourCode
		 this.keyModified("colour_code") = 1
	}

	def getForecastType() :Option[String]	={
		return  this.forecastType
	}

	def setForecastType( forecastType: Option[String]) 	={
		 this.forecastType = forecastType
		 this.keyModified("forecast_type") = 1
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