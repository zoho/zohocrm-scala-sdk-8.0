package com.zoho.crm.api.associateemail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Attachments extends Model	{
	private var id:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
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