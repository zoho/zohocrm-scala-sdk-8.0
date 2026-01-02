package com.zoho.crm.api.timelines

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AutomationDetail extends Model	{
	private var type1:Option[String] = None
	private var rule:Option[NameIdStructure] = None
	private var pathfinder:Option[PathFinder] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getRule() :Option[NameIdStructure]	={
		return  this.rule
	}

	def setRule( rule: Option[NameIdStructure]) 	={
		 this.rule = rule
		 this.keyModified("rule") = 1
	}

	def getPathfinder() :Option[PathFinder]	={
		return  this.pathfinder
	}

	def setPathfinder( pathfinder: Option[PathFinder]) 	={
		 this.pathfinder = pathfinder
		 this.keyModified("pathfinder") = 1
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