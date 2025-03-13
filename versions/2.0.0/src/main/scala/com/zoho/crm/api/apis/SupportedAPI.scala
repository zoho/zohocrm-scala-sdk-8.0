package com.zoho.crm.api.apis

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class SupportedAPI extends Model	{
	private var path:Option[String] = None
	private var operationTypes:ArrayBuffer[OperationTypes] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPath() :Option[String]	={
		return  this.path
	}

	def setPath( path: Option[String]) 	={
		 this.path = path
		 this.keyModified("path") = 1
	}

	def getOperationTypes() :ArrayBuffer[OperationTypes]	={
		return  this.operationTypes
	}

	def setOperationTypes( operationTypes: ArrayBuffer[OperationTypes]) 	={
		 this.operationTypes = operationTypes
		 this.keyModified("operation_types") = 1
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