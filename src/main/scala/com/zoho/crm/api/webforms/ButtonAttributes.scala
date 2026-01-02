package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ButtonAttributes extends Model	{
	private var color:Option[String] = None
	private var name:Option[String] = None
	private var align:Option[String] = None
	private var borderRadiusPx:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getColor() :Option[String]	={
		return  this.color
	}

	def setColor( color: Option[String]) 	={
		 this.color = color
		 this.keyModified("color") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getAlign() :Option[String]	={
		return  this.align
	}

	def setAlign( align: Option[String]) 	={
		 this.align = align
		 this.keyModified("align") = 1
	}

	def getBorderRadiusPx() :Option[String]	={
		return  this.borderRadiusPx
	}

	def setBorderRadiusPx( borderRadiusPx: Option[String]) 	={
		 this.borderRadiusPx = borderRadiusPx
		 this.keyModified("border_radius_px") = 1
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