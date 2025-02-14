package com.zoho.crm.api.notes

import com.zoho.crm.api.attachments.Attachment
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Note extends Model	{
	private var modifiedTime:Option[OffsetDateTime] = None
	private var attachments:ArrayBuffer[Attachment] = _
	private var owner:Option[MinifiedUser] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var parentId:Option[ParentId] = None
	private var editable:Option[Boolean] = None
	private var isSharedToClient:Option[Boolean] = None
	private var sharingPermission:Option[String] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var size:Option[String] = None
	private var state:Option[String] = None
	private var voiceNote:Option[Boolean] = None
	private var id:Option[Long] = None
	private var createdBy:Option[MinifiedUser] = None
	private var noteTitle:Option[String] = None
	private var noteContent:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("Modified_Time") = 1
	}

	def getattachments() :ArrayBuffer[Attachment]	={
		return  this.attachments
	}

	def setattachments( attachments: ArrayBuffer[Attachment]) 	={
		 this.attachments = attachments
		 this.keyModified("$attachments") = 1
	}

	def getOwner() :Option[MinifiedUser]	={
		return  this.owner
	}

	def setOwner( owner: Option[MinifiedUser]) 	={
		 this.owner = owner
		 this.keyModified("Owner") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("Created_Time") = 1
	}

	def getParentId() :Option[ParentId]	={
		return  this.parentId
	}

	def setParentId( parentId: Option[ParentId]) 	={
		 this.parentId = parentId
		 this.keyModified("Parent_Id") = 1
	}

	def geteditable() :Option[Boolean]	={
		return  this.editable
	}

	def seteditable( editable: Option[Boolean]) 	={
		 this.editable = editable
		 this.keyModified("$editable") = 1
	}

	def getisSharedToClient() :Option[Boolean]	={
		return  this.isSharedToClient
	}

	def setisSharedToClient( isSharedToClient: Option[Boolean]) 	={
		 this.isSharedToClient = isSharedToClient
		 this.keyModified("$is_shared_to_client") = 1
	}

	def getsharingPermission() :Option[String]	={
		return  this.sharingPermission
	}

	def setsharingPermission( sharingPermission: Option[String]) 	={
		 this.sharingPermission = sharingPermission
		 this.keyModified("$sharing_permission") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("Modified_By") = 1
	}

	def getsize() :Option[String]	={
		return  this.size
	}

	def setsize( size: Option[String]) 	={
		 this.size = size
		 this.keyModified("$size") = 1
	}

	def getstate() :Option[String]	={
		return  this.state
	}

	def setstate( state: Option[String]) 	={
		 this.state = state
		 this.keyModified("$state") = 1
	}

	def getvoiceNote() :Option[Boolean]	={
		return  this.voiceNote
	}

	def setvoiceNote( voiceNote: Option[Boolean]) 	={
		 this.voiceNote = voiceNote
		 this.keyModified("$voice_note") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("Created_By") = 1
	}

	def getNoteTitle() :Option[String]	={
		return  this.noteTitle
	}

	def setNoteTitle( noteTitle: Option[String]) 	={
		 this.noteTitle = noteTitle
		 this.keyModified("Note_Title") = 1
	}

	def getNoteContent() :Option[String]	={
		return  this.noteContent
	}

	def setNoteContent( noteContent: Option[String]) 	={
		 this.noteContent = noteContent
		 this.keyModified("Note_Content") = 1
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