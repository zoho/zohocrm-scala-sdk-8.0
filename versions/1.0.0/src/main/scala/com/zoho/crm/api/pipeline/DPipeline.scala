package com.zoho.crm.api.pipeline

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DPipeline extends Model	{
	private var delete:Option[Delete] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDelete() :Option[Delete]	={
		return  this.delete
	}

	def setDelete( delete: Option[Delete]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
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