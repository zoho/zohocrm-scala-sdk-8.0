package com.zoho.crm.api.emaildrafts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Attachments extends Model	{
	private var serviceName:Option[String] = None
	private var fileSize:Option[String] = None
	private var id:Option[String] = None
	private var fileName:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getServiceName() :Option[String]	={
		return  this.serviceName
	}

	def setServiceName( serviceName: Option[String]) 	={
		 this.serviceName = serviceName
		 this.keyModified("service_name") = 1
	}

	def getFileSize() :Option[String]	={
		return  this.fileSize
	}

	def setFileSize( fileSize: Option[String]) 	={
		 this.fileSize = fileSize
		 this.keyModified("file_size") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getFileName() :Option[String]	={
		return  this.fileName
	}

	def setFileName( fileName: Option[String]) 	={
		 this.fileName = fileName
		 this.keyModified("file_name") = 1
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