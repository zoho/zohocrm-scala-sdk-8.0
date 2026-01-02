package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Logo extends Model	{
	private var imageName:Option[String] = None
	private var align:Option[String] = None
	private var size:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getImageName() :Option[String]	={
		return  this.imageName
	}

	def setImageName( imageName: Option[String]) 	={
		 this.imageName = imageName
		 this.keyModified("image_name") = 1
	}

	def getAlign() :Option[String]	={
		return  this.align
	}

	def setAlign( align: Option[String]) 	={
		 this.align = align
		 this.keyModified("align") = 1
	}

	def getSize() :Option[String]	={
		return  this.size
	}

	def setSize( size: Option[String]) 	={
		 this.size = size
		 this.keyModified("size") = 1
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