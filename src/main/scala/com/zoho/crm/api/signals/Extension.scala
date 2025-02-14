package com.zoho.crm.api.signals

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Extension extends Model	{
	private var displayLabel:Option[String] = None
	private var namespace:Option[String] = None
	private var id:Option[Long] = None
	private var type1:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getNamespace() :Option[String]	={
		return  this.namespace
	}

	def setNamespace( namespace: Option[String]) 	={
		 this.namespace = namespace
		 this.keyModified("namespace") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getType() :Option[Int]	={
		return  this.type1
	}

	def setType( type1: Option[Int]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
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