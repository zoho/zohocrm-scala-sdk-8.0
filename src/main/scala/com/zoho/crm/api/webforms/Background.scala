package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Background extends Model	{
	private var imageName:Option[String] = None
	private var color:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getImageName() :Option[String]	={
		return  this.imageName
	}

	def setImageName( imageName: Option[String]) 	={
		 this.imageName = imageName
		 this.keyModified("image_name") = 1
	}

	def getColor() :Option[String]	={
		return  this.color
	}

	def setColor( color: Option[String]) 	={
		 this.color = color
		 this.keyModified("color") = 1
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