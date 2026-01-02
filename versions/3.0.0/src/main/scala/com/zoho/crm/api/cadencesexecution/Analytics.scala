package com.zoho.crm.api.cadencesexecution

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Analytics extends Model	{
	private var analytics:Option[HashMap[String, Any]] = _
	private var parentFollowUp:Option[ParentFollowUp] = None
	private var action:Option[Action] = None
	private var id:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAnalytics() :Option[HashMap[String, Any]]	={
		return  this.analytics
	}

	def setAnalytics( analytics: Option[HashMap[String, Any]]) 	={
		 this.analytics = analytics
		 this.keyModified("analytics") = 1
	}

	def getParentFollowUp() :Option[ParentFollowUp]	={
		return  this.parentFollowUp
	}

	def setParentFollowUp( parentFollowUp: Option[ParentFollowUp]) 	={
		 this.parentFollowUp = parentFollowUp
		 this.keyModified("parent_follow_up") = 1
	}

	def getAction() :Option[Action]	={
		return  this.action
	}

	def setAction( action: Option[Action]) 	={
		 this.action = action
		 this.keyModified("action") = 1
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