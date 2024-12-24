package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ButtonBackground extends Model	{
	private var buttonBackground:ArrayBuffer[String] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getButtonBackground() :ArrayBuffer[String]	={
		return  this.buttonBackground
	}

	def setButtonBackground( buttonBackground: ArrayBuffer[String]) 	={
		 this.buttonBackground = buttonBackground
		 this.keyModified("button_background") = 1
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