package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class FormSection extends Model	{
	private var formFields:ArrayBuffer[Fields] = _
	private var name:Option[String] = None
	private var description:Option[String] = None
	private var helpMessage:Option[String] = None
	private var id:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFormFields() :ArrayBuffer[Fields]	={
		return  this.formFields
	}

	def setFormFields( formFields: ArrayBuffer[Fields]) 	={
		 this.formFields = formFields
		 this.keyModified("form_fields") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getHelpMessage() :Option[String]	={
		return  this.helpMessage
	}

	def setHelpMessage( helpMessage: Option[String]) 	={
		 this.helpMessage = helpMessage
		 this.keyModified("help_message") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
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