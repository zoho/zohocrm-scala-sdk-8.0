package com.zoho.crm.api.emailcompose

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Font extends Model	{
	private var size:Option[Int] = None
	private var family:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getSize() :Option[Int]	={
		return  this.size
	}

	def setSize( size: Option[Int]) 	={
		 this.size = size
		 this.keyModified("size") = 1
	}

	def getFamily() :Option[String]	={
		return  this.family
	}

	def setFamily( family: Option[String]) 	={
		 this.family = family
		 this.keyModified("family") = 1
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