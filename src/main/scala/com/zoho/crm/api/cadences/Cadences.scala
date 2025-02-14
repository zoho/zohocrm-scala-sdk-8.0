package com.zoho.crm.api.cadences

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Cadences extends Model	{
	private var summary:Option[Summary] = None
	private var createdTime:Option[String] = None
	private var module:Option[Module] = None
	private var active:Option[Boolean] = None
	private var executionDetails:Option[ExecutionDetail] = None
	private var published:Option[Boolean] = None
	private var type1:Option[String] = None
	private var createdBy:Option[User] = None
	private var modifiedTime:Option[String] = None
	private var name:Option[String] = None
	private var modifiedBy:Option[User] = None
	private var id:Option[Long] = None
	private var customView:Option[CustomView] = None
	private var status:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSummary() :Option[Summary]	={
		return  this.summary
	}

	def setSummary( summary: Option[Summary]) 	={
		 this.summary = summary
		 this.keyModified("summary") = 1
	}

	def getCreatedTime() :Option[String]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[String]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	def getExecutionDetails() :Option[ExecutionDetail]	={
		return  this.executionDetails
	}

	def setExecutionDetails( executionDetails: Option[ExecutionDetail]) 	={
		 this.executionDetails = executionDetails
		 this.keyModified("execution_details") = 1
	}

	def getPublished() :Option[Boolean]	={
		return  this.published
	}

	def setPublished( published: Option[Boolean]) 	={
		 this.published = published
		 this.keyModified("published") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getModifiedTime() :Option[String]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[String]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getModifiedBy() :Option[User]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[User]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getCustomView() :Option[CustomView]	={
		return  this.customView
	}

	def setCustomView( customView: Option[CustomView]) 	={
		 this.customView = customView
		 this.keyModified("custom_view") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
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