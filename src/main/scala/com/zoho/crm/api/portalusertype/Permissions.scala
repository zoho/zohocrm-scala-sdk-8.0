package com.zoho.crm.api.portalusertype

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Permissions extends Model	{
	private var view:Option[Boolean] = None
	private var edit:Option[Boolean] = None
	private var editSharedRecords:Option[Boolean] = None
	private var create:Option[Boolean] = None
	private var delete:Option[Boolean] = None
	private var deleteAttachment:Option[Boolean] = None
	private var createAttachment:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getView() :Option[Boolean]	={
		return  this.view
	}

	def setView( view: Option[Boolean]) 	={
		 this.view = view
		 this.keyModified("view") = 1
	}

	def getEdit() :Option[Boolean]	={
		return  this.edit
	}

	def setEdit( edit: Option[Boolean]) 	={
		 this.edit = edit
		 this.keyModified("edit") = 1
	}

	def getEditSharedRecords() :Option[Boolean]	={
		return  this.editSharedRecords
	}

	def setEditSharedRecords( editSharedRecords: Option[Boolean]) 	={
		 this.editSharedRecords = editSharedRecords
		 this.keyModified("edit_shared_records") = 1
	}

	def getCreate() :Option[Boolean]	={
		return  this.create
	}

	def setCreate( create: Option[Boolean]) 	={
		 this.create = create
		 this.keyModified("create") = 1
	}

	def getDelete() :Option[Boolean]	={
		return  this.delete
	}

	def setDelete( delete: Option[Boolean]) 	={
		 this.delete = delete
		 this.keyModified("delete") = 1
	}

	def getDeleteAttachment() :Option[Boolean]	={
		return  this.deleteAttachment
	}

	def setDeleteAttachment( deleteAttachment: Option[Boolean]) 	={
		 this.deleteAttachment = deleteAttachment
		 this.keyModified("delete_attachment") = 1
	}

	def getCreateAttachment() :Option[Boolean]	={
		return  this.createAttachment
	}

	def setCreateAttachment( createAttachment: Option[Boolean]) 	={
		 this.createAttachment = createAttachment
		 this.keyModified("create_attachment") = 1
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