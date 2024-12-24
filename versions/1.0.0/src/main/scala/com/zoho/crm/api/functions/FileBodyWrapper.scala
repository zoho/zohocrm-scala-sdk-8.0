package com.zoho.crm.api.functions

import com.zoho.crm.api.util.StreamWrapper
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FileBodyWrapper extends Model	{
	private var inputfile:Option[StreamWrapper] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getInputfile() :Option[StreamWrapper]	={
		return  this.inputfile
	}

	def setInputfile( inputfile: Option[StreamWrapper]) 	={
		 this.inputfile = inputfile
		 this.keyModified("inputFile") = 1
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