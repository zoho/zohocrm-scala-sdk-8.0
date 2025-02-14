package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FormAttributes extends Model	{
	private var color:Option[String] = None
	private var width:Option[Int] = None
	private var fontAttributes:Option[FontAttributes] = None
	private var align:Option[String] = None
	private var displayFormName:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getColor() :Option[String]	={
		return  this.color
	}

	def setColor( color: Option[String]) 	={
		 this.color = color
		 this.keyModified("color") = 1
	}

	def getWidth() :Option[Int]	={
		return  this.width
	}

	def setWidth( width: Option[Int]) 	={
		 this.width = width
		 this.keyModified("width") = 1
	}

	def getFontAttributes() :Option[FontAttributes]	={
		return  this.fontAttributes
	}

	def setFontAttributes( fontAttributes: Option[FontAttributes]) 	={
		 this.fontAttributes = fontAttributes
		 this.keyModified("font_attributes") = 1
	}

	def getAlign() :Option[String]	={
		return  this.align
	}

	def setAlign( align: Option[String]) 	={
		 this.align = align
		 this.keyModified("align") = 1
	}

	def getDisplayFormName() :Option[String]	={
		return  this.displayFormName
	}

	def setDisplayFormName( displayFormName: Option[String]) 	={
		 this.displayFormName = displayFormName
		 this.keyModified("display_form_name") = 1
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