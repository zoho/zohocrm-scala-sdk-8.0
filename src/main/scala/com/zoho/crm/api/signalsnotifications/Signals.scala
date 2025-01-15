package com.zoho.crm.api.signalsnotifications

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Signals extends Model	{
	private var signalNamespace:Option[String] = None
	private var email:Option[String] = None
	private var subject:Option[String] = None
	private var message:Option[String] = None
	private var module:Option[String] = None
	private var id:Option[Long] = None
	private var actions:ArrayBuffer[Action] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSignalNamespace() :Option[String]	={
		return  this.signalNamespace
	}

	def setSignalNamespace( signalNamespace: Option[String]) 	={
		 this.signalNamespace = signalNamespace
		 this.keyModified("signal_namespace") = 1
	}

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
	}

	def getSubject() :Option[String]	={
		return  this.subject
	}

	def setSubject( subject: Option[String]) 	={
		 this.subject = subject
		 this.keyModified("subject") = 1
	}

	def getMessage() :Option[String]	={
		return  this.message
	}

	def setMessage( message: Option[String]) 	={
		 this.message = message
		 this.keyModified("message") = 1
	}

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getActions() :ArrayBuffer[Action]	={
		return  this.actions
	}

	def setActions( actions: ArrayBuffer[Action]) 	={
		 this.actions = actions
		 this.keyModified("actions") = 1
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