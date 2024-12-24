package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class SubformProperty extends Model	{
	private var pinnedColumn:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPinnedColumn() :Option[Boolean]	={
		return  this.pinnedColumn
	}

	def setPinnedColumn( pinnedColumn: Option[Boolean]) 	={
		 this.pinnedColumn = pinnedColumn
		 this.keyModified("pinned_column") = 1
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