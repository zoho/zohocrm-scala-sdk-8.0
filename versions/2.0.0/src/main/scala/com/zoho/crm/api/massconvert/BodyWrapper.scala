package com.zoho.crm.api.massconvert

import com.zoho.crm.api.record.Record
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class BodyWrapper extends Model	{
	private var deals:Option[Record] = None
	private var moveAttachmentsTo:Option[MoveAttachmentsTo] = None
	private var assignTo:Option[AssignTo] = None
	private var carryOverTags:ArrayBuffer[MoveAttachmentsTo] = _
	private var relatedModules:ArrayBuffer[RelatedModule] = _
	private var portalUserType:Option[PortalUserType] = None
	private var ids:ArrayBuffer[Long] = _
	private var applyAssignmentThreshold:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDeals() :Option[Record]	={
		return  this.deals
	}

	def setDeals( deals: Option[Record]) 	={
		 this.deals = deals
		 this.keyModified("Deals") = 1
	}

	def getMoveAttachmentsTo() :Option[MoveAttachmentsTo]	={
		return  this.moveAttachmentsTo
	}

	def setMoveAttachmentsTo( moveAttachmentsTo: Option[MoveAttachmentsTo]) 	={
		 this.moveAttachmentsTo = moveAttachmentsTo
		 this.keyModified("move_attachments_to") = 1
	}

	def getAssignTo() :Option[AssignTo]	={
		return  this.assignTo
	}

	def setAssignTo( assignTo: Option[AssignTo]) 	={
		 this.assignTo = assignTo
		 this.keyModified("assign_to") = 1
	}

	def getCarryOverTags() :ArrayBuffer[MoveAttachmentsTo]	={
		return  this.carryOverTags
	}

	def setCarryOverTags( carryOverTags: ArrayBuffer[MoveAttachmentsTo]) 	={
		 this.carryOverTags = carryOverTags
		 this.keyModified("carry_over_tags") = 1
	}

	def getRelatedModules() :ArrayBuffer[RelatedModule]	={
		return  this.relatedModules
	}

	def setRelatedModules( relatedModules: ArrayBuffer[RelatedModule]) 	={
		 this.relatedModules = relatedModules
		 this.keyModified("related_modules") = 1
	}

	def getPortalUserType() :Option[PortalUserType]	={
		return  this.portalUserType
	}

	def setPortalUserType( portalUserType: Option[PortalUserType]) 	={
		 this.portalUserType = portalUserType
		 this.keyModified("portal_user_type") = 1
	}

	def getIds() :ArrayBuffer[Long]	={
		return  this.ids
	}

	def setIds( ids: ArrayBuffer[Long]) 	={
		 this.ids = ids
		 this.keyModified("ids") = 1
	}

	def getApplyAssignmentThreshold() :Option[Boolean]	={
		return  this.applyAssignmentThreshold
	}

	def setApplyAssignmentThreshold( applyAssignmentThreshold: Option[Boolean]) 	={
		 this.applyAssignmentThreshold = applyAssignmentThreshold
		 this.keyModified("apply_assignment_threshold") = 1
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