package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Profiles extends Model	{
	private var default1:Option[Boolean] = None
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var defaultview:Option[DefaultView] = None
	private var defaultassignmentview:Option[DefaultAssignmentView] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDefault() :Option[Boolean]	={
		return  this.default1
	}

	def setDefault( default1: Option[Boolean]) 	={
		 this.default1 = default1
		 this.keyModified("default") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getDefaultview() :Option[DefaultView]	={
		return  this.defaultview
	}

	def setDefaultview( defaultview: Option[DefaultView]) 	={
		 this.defaultview = defaultview
		 this.keyModified("_default_view") = 1
	}

	def getDefaultassignmentview() :Option[DefaultAssignmentView]	={
		return  this.defaultassignmentview
	}

	def setDefaultassignmentview( defaultassignmentview: Option[DefaultAssignmentView]) 	={
		 this.defaultassignmentview = defaultassignmentview
		 this.keyModified("_default_assignment_view") = 1
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