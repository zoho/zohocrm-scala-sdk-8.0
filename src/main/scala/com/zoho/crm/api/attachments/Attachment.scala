package com.zoho.crm.api.attachments

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Attachment extends Model	{
	private var owner:Option[MinifiedUser] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var createdBy:Option[MinifiedUser] = None
	private var parentId:Option[ParentId] = None
	private var sharingPermission:Option[String] = None
	private var recordStatusS:Option[String] = None
	private var attachmentType:Option[Int] = None
	private var id:Option[Long] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var fileName:Option[String] = None
	private var size:Option[String] = None
	private var editable:Option[Boolean] = None
	private var fileId:Option[String] = None
	private var type1:Option[String] = None
	private var seModule:Option[String] = None
	private var state:Option[String] = None
	private var linkUrl:Option[String] = None
	private var attachmentSourceS:Option[String] = None
	private var fileIdS:Option[String] = None
	private var fieldStates:Option[String] = None
	private var ziaVisions:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOwner() :Option[MinifiedUser]	={
		return  this.owner
	}

	def setOwner( owner: Option[MinifiedUser]) 	={
		 this.owner = owner
		 this.keyModified("Owner") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("Modified_By") = 1
	}

	def getCreatedBy() :Option[MinifiedUser]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.createdBy = createdBy
		 this.keyModified("Created_By") = 1
	}

	def getParentId() :Option[ParentId]	={
		return  this.parentId
	}

	def setParentId( parentId: Option[ParentId]) 	={
		 this.parentId = parentId
		 this.keyModified("Parent_Id") = 1
	}

	def getsharingPermission() :Option[String]	={
		return  this.sharingPermission
	}

	def setsharingPermission( sharingPermission: Option[String]) 	={
		 this.sharingPermission = sharingPermission
		 this.keyModified("$sharing_permission") = 1
	}

	def getRecordStatusS() :Option[String]	={
		return  this.recordStatusS
	}

	def setRecordStatusS( recordStatusS: Option[String]) 	={
		 this.recordStatusS = recordStatusS
		 this.keyModified("Record_Status__s") = 1
	}

	def getattachmentType() :Option[Int]	={
		return  this.attachmentType
	}

	def setattachmentType( attachmentType: Option[Int]) 	={
		 this.attachmentType = attachmentType
		 this.keyModified("$attachment_type") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("Modified_Time") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("Created_Time") = 1
	}

	def getFileName() :Option[String]	={
		return  this.fileName
	}

	def setFileName( fileName: Option[String]) 	={
		 this.fileName = fileName
		 this.keyModified("File_Name") = 1
	}

	def getSize() :Option[String]	={
		return  this.size
	}

	def setSize( size: Option[String]) 	={
		 this.size = size
		 this.keyModified("Size") = 1
	}

	def geteditable() :Option[Boolean]	={
		return  this.editable
	}

	def seteditable( editable: Option[Boolean]) 	={
		 this.editable = editable
		 this.keyModified("$editable") = 1
	}

	def getfileId() :Option[String]	={
		return  this.fileId
	}

	def setfileId( fileId: Option[String]) 	={
		 this.fileId = fileId
		 this.keyModified("$file_id") = 1
	}

	def gettype() :Option[String]	={
		return  this.type1
	}

	def settype( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("$type") = 1
	}

	def getseModule() :Option[String]	={
		return  this.seModule
	}

	def setseModule( seModule: Option[String]) 	={
		 this.seModule = seModule
		 this.keyModified("$se_module") = 1
	}

	def getstate() :Option[String]	={
		return  this.state
	}

	def setstate( state: Option[String]) 	={
		 this.state = state
		 this.keyModified("$state") = 1
	}

	def getlinkUrl() :Option[String]	={
		return  this.linkUrl
	}

	def setlinkUrl( linkUrl: Option[String]) 	={
		 this.linkUrl = linkUrl
		 this.keyModified("$link_url") = 1
	}

	def getAttachmentSourceS() :Option[String]	={
		return  this.attachmentSourceS
	}

	def setAttachmentSourceS( attachmentSourceS: Option[String]) 	={
		 this.attachmentSourceS = attachmentSourceS
		 this.keyModified("Attachment_Source__s") = 1
	}

	def getFileIdS() :Option[String]	={
		return  this.fileIdS
	}

	def setFileIdS( fileIdS: Option[String]) 	={
		 this.fileIdS = fileIdS
		 this.keyModified("File_Id__s") = 1
	}

	def getfieldStates() :Option[String]	={
		return  this.fieldStates
	}

	def setfieldStates( fieldStates: Option[String]) 	={
		 this.fieldStates = fieldStates
		 this.keyModified("$field_states") = 1
	}

	def getziaVisions() :Option[String]	={
		return  this.ziaVisions
	}

	def setziaVisions( ziaVisions: Option[String]) 	={
		 this.ziaVisions = ziaVisions
		 this.keyModified("$zia_visions") = 1
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