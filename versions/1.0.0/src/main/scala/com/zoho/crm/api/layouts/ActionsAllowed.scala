package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionsAllowed extends Model	{
	private var edit:Option[Boolean] = None
	private var rename:Option[Boolean] = None
	private var clone1:Option[Boolean] = None
	private var downgrade:Option[Boolean] = None
	private var delete:Option[Boolean] = None
	private var deactivate:Option[Boolean] = None
	private var setLayoutPermissions:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEdit() :Option[Boolean]	={
		return  this.edit
	}

	def setEdit( edit: Option[Boolean]) 	={
		 this.edit = edit
		 this.keyModified("edit") = 1
	}

	def getRename() :Option[Boolean]	={
		return  this.rename
	}

	def setRename( rename: Option[Boolean]) 	={
		 this.rename = rename
		 this.keyModified("rename") = 1
	}

	def getClone() :Option[Boolean]	={
		return  this.clone1
	}

	def setClone( clone1: Option[Boolean]) 	={
		 this.clone1 = clone1
		 this.keyModified("clone") = 1
	}

	def getDowngrade() :Option[Boolean]	={
		return  this.downgrade
	}

	def setDowngrade( downgrade: Option[Boolean]) 	={
		 this.downgrade = downgrade
		 this.keyModified("downgrade") = 1
	}

	def getDelete() :Option[Boolean]	={
		return  this.delete
	}

	def setDelete( delete: Option[Boolean]) 	={
		 this.delete = delete
		 this.keyModified("delete") = 1
	}

	def getDeactivate() :Option[Boolean]	={
		return  this.deactivate
	}

	def setDeactivate( deactivate: Option[Boolean]) 	={
		 this.deactivate = deactivate
		 this.keyModified("deactivate") = 1
	}

	def getSetLayoutPermissions() :Option[Boolean]	={
		return  this.setLayoutPermissions
	}

	def setSetLayoutPermissions( setLayoutPermissions: Option[Boolean]) 	={
		 this.setLayoutPermissions = setLayoutPermissions
		 this.keyModified("set_layout_permissions") = 1
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