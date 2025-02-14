package com.zoho.crm.api.users

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Theme extends Model	{
	private var normalTab:Option[Tab] = None
	private var selectedTab:Option[Tab] = None
	private var newBackground:Option[String] = None
	private var background:Choice[String] = _
	private var screen:Choice[String] = _
	private var type1:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getNormalTab() :Option[Tab]	={
		return  this.normalTab
	}

	def setNormalTab( normalTab: Option[Tab]) 	={
		 this.normalTab = normalTab
		 this.keyModified("normal_tab") = 1
	}

	def getSelectedTab() :Option[Tab]	={
		return  this.selectedTab
	}

	def setSelectedTab( selectedTab: Option[Tab]) 	={
		 this.selectedTab = selectedTab
		 this.keyModified("selected_tab") = 1
	}

	def getNewBackground() :Option[String]	={
		return  this.newBackground
	}

	def setNewBackground( newBackground: Option[String]) 	={
		 this.newBackground = newBackground
		 this.keyModified("new_background") = 1
	}

	def getBackground() :Choice[String]	={
		return  this.background
	}

	def setBackground( background: Choice[String]) 	={
		 this.background = background
		 this.keyModified("background") = 1
	}

	def getScreen() :Choice[String]	={
		return  this.screen
	}

	def setScreen( screen: Choice[String]) 	={
		 this.screen = screen
		 this.keyModified("screen") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
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