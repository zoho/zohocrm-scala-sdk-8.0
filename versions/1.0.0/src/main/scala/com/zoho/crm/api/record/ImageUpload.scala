package com.zoho.crm.api.record

import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class ImageUpload extends Model	{
	private var previewIdS:Option[String] = None
	private var fileNameS:Option[String] = None
	private var descriptionS:Option[String] = None
	private var sizeS:Option[String] = None
	private var id:Option[String] = None
	private var sequenceNumberS:Option[Long] = None
	private var stateS:Option[String] = None
	private var fileIdS:Option[String] = None
	private var delete:Option[String] = None
	private var createdTimeS:Option[OffsetDateTime] = None
	private var modifiedTimeS:Option[OffsetDateTime] = None
	private var createdByS:Option[MinifiedUser] = None
	private var ownerS:Option[MinifiedUser] = None
	private var modifiedByS:Option[MinifiedUser] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPreviewIdS() :Option[String]	={
		return  this.previewIdS
	}

	def setPreviewIdS( previewIdS: Option[String]) 	={
		 this.previewIdS = previewIdS
		 this.keyModified("Preview_Id__s") = 1
	}

	def getFileNameS() :Option[String]	={
		return  this.fileNameS
	}

	def setFileNameS( fileNameS: Option[String]) 	={
		 this.fileNameS = fileNameS
		 this.keyModified("File_Name__s") = 1
	}

	def getDescriptionS() :Option[String]	={
		return  this.descriptionS
	}

	def setDescriptionS( descriptionS: Option[String]) 	={
		 this.descriptionS = descriptionS
		 this.keyModified("Description__s") = 1
	}

	def getSizeS() :Option[String]	={
		return  this.sizeS
	}

	def setSizeS( sizeS: Option[String]) 	={
		 this.sizeS = sizeS
		 this.keyModified("Size__s") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getSequenceNumberS() :Option[Long]	={
		return  this.sequenceNumberS
	}

	def setSequenceNumberS( sequenceNumberS: Option[Long]) 	={
		 this.sequenceNumberS = sequenceNumberS
		 this.keyModified("Sequence_Number__s") = 1
	}

	def getStateS() :Option[String]	={
		return  this.stateS
	}

	def setStateS( stateS: Option[String]) 	={
		 this.stateS = stateS
		 this.keyModified("State__s") = 1
	}

	def getFileIdS() :Option[String]	={
		return  this.fileIdS
	}

	def setFileIdS( fileIdS: Option[String]) 	={
		 this.fileIdS = fileIdS
		 this.keyModified("File_Id__s") = 1
	}

	def getDelete() :Option[String]	={
		return  this.delete
	}

	def setDelete( delete: Option[String]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
	}

	def getCreatedTimeS() :Option[OffsetDateTime]	={
		return  this.createdTimeS
	}

	def setCreatedTimeS( createdTimeS: Option[OffsetDateTime]) 	={
		 this.createdTimeS = createdTimeS
		 this.keyModified("Created_Time__s") = 1
	}

	def getModifiedTimeS() :Option[OffsetDateTime]	={
		return  this.modifiedTimeS
	}

	def setModifiedTimeS( modifiedTimeS: Option[OffsetDateTime]) 	={
		 this.modifiedTimeS = modifiedTimeS
		 this.keyModified("Modified_Time__s") = 1
	}

	def getCreatedByS() :Option[MinifiedUser]	={
		return  this.createdByS
	}

	def setCreatedByS( createdByS: Option[MinifiedUser]) 	={
		 this.createdByS = createdByS
		 this.keyModified("Created_By__s") = 1
	}

	def getOwnerS() :Option[MinifiedUser]	={
		return  this.ownerS
	}

	def setOwnerS( ownerS: Option[MinifiedUser]) 	={
		 this.ownerS = ownerS
		 this.keyModified("Owner__s") = 1
	}

	def getModifiedByS() :Option[MinifiedUser]	={
		return  this.modifiedByS
	}

	def setModifiedByS( modifiedByS: Option[MinifiedUser]) 	={
		 this.modifiedByS = modifiedByS
		 this.keyModified("Modified_By__s") = 1
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