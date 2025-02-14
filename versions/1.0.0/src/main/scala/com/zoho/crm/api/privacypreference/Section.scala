package com.zoho.crm.api.privacypreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Section extends Model	{
	private var name:Option[String] = None
	private var tooltip:Option[String] = None
	private var showType:Option[String] = None
	private var title:Option[String] = None
	private var options:ArrayBuffer[Option1] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getTooltip() :Option[String]	={
		return  this.tooltip
	}

	def setTooltip( tooltip: Option[String]) 	={
		 this.tooltip = tooltip
		 this.keyModified("tooltip") = 1
	}

	def getShowType() :Option[String]	={
		return  this.showType
	}

	def setShowType( showType: Option[String]) 	={
		 this.showType = showType
		 this.keyModified("show_type") = 1
	}

	def getTitle() :Option[String]	={
		return  this.title
	}

	def setTitle( title: Option[String]) 	={
		 this.title = title
		 this.keyModified("title") = 1
	}

	def getOptions() :ArrayBuffer[Option1]	={
		return  this.options
	}

	def setOptions( options: ArrayBuffer[Option1]) 	={
		 this.options = options
		 this.keyModified("options") = 1
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