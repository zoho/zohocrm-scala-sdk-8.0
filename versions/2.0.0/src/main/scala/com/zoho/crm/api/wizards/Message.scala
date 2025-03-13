package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Message extends Model	{
	private var title:Option[String] = None
	private var content:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTitle() :Option[String]	={
		return  this.title
	}

	def setTitle( title: Option[String]) 	={
		 this.title = title
		 this.keyModified("title") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
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