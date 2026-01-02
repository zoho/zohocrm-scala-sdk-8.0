package com.zoho.crm.api.bulkread

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class BodyWrapper extends Model	{
	private var callback:Option[CallBack] = None
	private var query:Option[Query] = None
	private var fileType:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCallback() :Option[CallBack]	={
		return  this.callback
	}

	def setCallback( callback: Option[CallBack]) 	={
		 this.callback = callback
		 this.keyModified("callback") = 1
	}

	def getQuery() :Option[Query]	={
		return  this.query
	}

	def setQuery( query: Option[Query]) 	={
		 this.query = query
		 this.keyModified("query") = 1
	}

	def getFileType() :Option[String]	={
		return  this.fileType
	}

	def setFileType( fileType: Option[String]) 	={
		 this.fileType = fileType
		 this.keyModified("file_type") = 1
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