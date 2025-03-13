package com.zoho.crm.api.scoringrules

import com.zoho.crm.api.modules.Modules
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ScoringRule extends Model	{
	private var name:Option[String] = None
	private var description:Option[String] = None
	private var id:Option[String] = None
	private var layout:Option[Layout] = None
	private var createdTime:Option[String] = None
	private var modifiedTime:Option[String] = None
	private var module:Option[Modules] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var active:Option[Boolean] = None
	private var createdBy:Option[MinifiedUser] = None
	private var fieldRules:ArrayBuffer[FieldRule] = _
	private var signalRules:ArrayBuffer[SignalRule] = _
	private var keyModified:HashMap[String, Int] = HashMap()

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

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getLayout() :Option[Layout]	={
		return  this.layout
	}

	def setLayout( layout: Option[Layout]) 	={
		 this.layout = layout
		 this.keyModified("layout") = 1
	}

	def getCreatedTime() :Option[String]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[String]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getModifiedTime() :Option[String]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[String]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getModule() :Option[Modules]	={
		return  this.module
	}

	def setModule( module: Option[Modules]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getFieldRules() :ArrayBuffer[FieldRule]	={
		return  this.fieldRules
	}

	def setFieldRules( fieldRules: ArrayBuffer[FieldRule]) 	={
		 this.fieldRules = fieldRules
		 this.keyModified("field_rules") = 1
	}

	def getSignalRules() :ArrayBuffer[SignalRule]	={
		return  this.signalRules
	}

	def setSignalRules( signalRules: ArrayBuffer[SignalRule]) 	={
		 this.signalRules = signalRules
		 this.keyModified("signal_rules") = 1
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