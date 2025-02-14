package com.zoho.crm.api.emailsignatures

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class EmailSignatures extends Model	{
	private var name:Option[String] = None
	private var from:ArrayBuffer[FromAddress] = _
	private var editorMode:Choice[String] = _
	private var id:Option[Long] = None
	private var content:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getFrom() :ArrayBuffer[FromAddress]	={
		return  this.from
	}

	def setFrom( from: ArrayBuffer[FromAddress]) 	={
		 this.from = from
		 this.keyModified("from") = 1
	}

	def getEditorMode() :Choice[String]	={
		return  this.editorMode
	}

	def setEditorMode( editorMode: Choice[String]) 	={
		 this.editorMode = editorMode
		 this.keyModified("editor_mode") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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