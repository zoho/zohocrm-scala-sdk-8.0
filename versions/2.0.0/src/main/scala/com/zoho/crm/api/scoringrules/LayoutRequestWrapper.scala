package com.zoho.crm.api.scoringrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class LayoutRequestWrapper extends Model	{
	private var layout:Option[Layout] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLayout() :Option[Layout]	={
		return  this.layout
	}

	def setLayout( layout: Option[Layout]) 	={
		 this.layout = layout
		 this.keyModified("layout") = 1
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