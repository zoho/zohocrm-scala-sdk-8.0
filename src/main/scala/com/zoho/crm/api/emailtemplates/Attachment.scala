package com.zoho.crm.api.emailtemplates

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Attachment extends Model	{
	private var size:Option[Long] = None
	private var fileName:Option[String] = None
	private var fileId:Option[String] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSize() :Option[Long]	={
		return  this.size
	}

	def setSize( size: Option[Long]) 	={
		 this.size = size
		 this.keyModified("size") = 1
	}

	def getFileName() :Option[String]	={
		return  this.fileName
	}

	def setFileName( fileName: Option[String]) 	={
		 this.fileName = fileName
		 this.keyModified("file_name") = 1
	}

	def getFileId() :Option[String]	={
		return  this.fileId
	}

	def setFileId( fileId: Option[String]) 	={
		 this.fileId = fileId
		 this.keyModified("file_id") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
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