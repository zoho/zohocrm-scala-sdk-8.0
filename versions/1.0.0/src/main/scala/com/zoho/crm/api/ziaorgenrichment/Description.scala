package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Description extends Model	{
	private var title:Option[String] = None
	private var description:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTitle() :Option[String]	={
		return  this.title
	}

	def setTitle( title: Option[String]) 	={
		 this.title = title
		 this.keyModified("title") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
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