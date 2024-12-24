package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Sources extends Model	{
	private var type1:Choice[String] = _
	private var source:Option[Source] = None
	private var subordinates:Option[Boolean] = None
	private var subTerritories:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getSource() :Option[Source]	={
		return  this.source
	}

	def setSource( source: Option[Source]) 	={
		 this.source = source
		 this.keyModified("source") = 1
	}

	def getSubordinates() :Option[Boolean]	={
		return  this.subordinates
	}

	def setSubordinates( subordinates: Option[Boolean]) 	={
		 this.subordinates = subordinates
		 this.keyModified("subordinates") = 1
	}

	def getSubTerritories() :Option[Boolean]	={
		return  this.subTerritories
	}

	def setSubTerritories( subTerritories: Option[Boolean]) 	={
		 this.subTerritories = subTerritories
		 this.keyModified("sub_territories") = 1
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