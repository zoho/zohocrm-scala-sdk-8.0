package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Connection extends Model	{
	private var sourceButton:Option[Button] = None
	private var targetScreen:Option[Screen] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSourceButton() :Option[Button]	={
		return  this.sourceButton
	}

	def setSourceButton( sourceButton: Option[Button]) 	={
		 this.sourceButton = sourceButton
		 this.keyModified("source_button") = 1
	}

	def getTargetScreen() :Option[Screen]	={
		return  this.targetScreen
	}

	def setTargetScreen( targetScreen: Option[Screen]) 	={
		 this.targetScreen = targetScreen
		 this.keyModified("target_screen") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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