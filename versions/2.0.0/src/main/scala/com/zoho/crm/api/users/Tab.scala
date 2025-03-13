package com.zoho.crm.api.users

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Tab extends Model	{
	private var fontColor:Choice[String] = _
	private var background:Choice[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFontColor() :Choice[String]	={
		return  this.fontColor
	}

	def setFontColor( fontColor: Choice[String]) 	={
		 this.fontColor = fontColor
		 this.keyModified("font_color") = 1
	}

	def getBackground() :Choice[String]	={
		return  this.background
	}

	def setBackground( background: Choice[String]) 	={
		 this.background = background
		 this.keyModified("background") = 1
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