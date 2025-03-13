package com.zoho.crm.api.timelines

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class State extends Model	{
	private var triggerType:Option[String] = None
	private var name:Option[String] = None
	private var isLastState:Option[Boolean] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTriggerType() :Option[String]	={
		return  this.triggerType
	}

	def setTriggerType( triggerType: Option[String]) 	={
		 this.triggerType = triggerType
		 this.keyModified("trigger_type") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getIsLastState() :Option[Boolean]	={
		return  this.isLastState
	}

	def setIsLastState( isLastState: Option[Boolean]) 	={
		 this.isLastState = isLastState
		 this.keyModified("is_last_state") = 1
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