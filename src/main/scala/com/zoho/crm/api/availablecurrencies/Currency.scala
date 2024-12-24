package com.zoho.crm.api.availablecurrencies

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Currency extends Model	{
	private var displayValue:Option[String] = None
	private var decimalSeparator:Option[String] = None
	private var symbol:Option[String] = None
	private var thousandSeparator:Option[String] = None
	private var displayName:Option[String] = None
	private var isoCode:Option[String] = None
	private var decimalPlaces:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayValue() :Option[String]	={
		return  this.displayValue
	}

	def setDisplayValue( displayValue: Option[String]) 	={
		 this.displayValue = displayValue
		 this.keyModified("display_value") = 1
	}

	def getDecimalSeparator() :Option[String]	={
		return  this.decimalSeparator
	}

	def setDecimalSeparator( decimalSeparator: Option[String]) 	={
		 this.decimalSeparator = decimalSeparator
		 this.keyModified("decimal_separator") = 1
	}

	def getSymbol() :Option[String]	={
		return  this.symbol
	}

	def setSymbol( symbol: Option[String]) 	={
		 this.symbol = symbol
		 this.keyModified("symbol") = 1
	}

	def getThousandSeparator() :Option[String]	={
		return  this.thousandSeparator
	}

	def setThousandSeparator( thousandSeparator: Option[String]) 	={
		 this.thousandSeparator = thousandSeparator
		 this.keyModified("thousand_separator") = 1
	}

	def getDisplayName() :Option[String]	={
		return  this.displayName
	}

	def setDisplayName( displayName: Option[String]) 	={
		 this.displayName = displayName
		 this.keyModified("display_name") = 1
	}

	def getIsoCode() :Option[String]	={
		return  this.isoCode
	}

	def setIsoCode( isoCode: Option[String]) 	={
		 this.isoCode = isoCode
		 this.keyModified("iso_code") = 1
	}

	def getDecimalPlaces() :Option[String]	={
		return  this.decimalPlaces
	}

	def setDecimalPlaces( decimalPlaces: Option[String]) 	={
		 this.decimalPlaces = decimalPlaces
		 this.keyModified("decimal_places") = 1
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