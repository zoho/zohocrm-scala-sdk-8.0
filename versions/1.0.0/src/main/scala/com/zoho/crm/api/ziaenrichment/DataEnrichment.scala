package com.zoho.crm.api.ziaenrichment

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class DataEnrichment extends Model	{
	private var module:Option[Module] = None
	private var type1:Option[String] = None
	private var outputDataFieldMapping:ArrayBuffer[OutputData] = _
	private var inputDataFieldMapping:ArrayBuffer[InputData] = _
	private var id:Option[Long] = None
	private var status:Option[Boolean] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var createdBy:Option[User] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var modifiedBy:Option[User] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getOutputDataFieldMapping() :ArrayBuffer[OutputData]	={
		return  this.outputDataFieldMapping
	}

	def setOutputDataFieldMapping( outputDataFieldMapping: ArrayBuffer[OutputData]) 	={
		 this.outputDataFieldMapping = outputDataFieldMapping
		 this.keyModified("output_data_field_mapping") = 1
	}

	def getInputDataFieldMapping() :ArrayBuffer[InputData]	={
		return  this.inputDataFieldMapping
	}

	def setInputDataFieldMapping( inputDataFieldMapping: ArrayBuffer[InputData]) 	={
		 this.inputDataFieldMapping = inputDataFieldMapping
		 this.keyModified("input_data_field_mapping") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getStatus() :Option[Boolean]	={
		return  this.status
	}

	def setStatus( status: Option[Boolean]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getModifiedBy() :Option[User]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[User]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
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