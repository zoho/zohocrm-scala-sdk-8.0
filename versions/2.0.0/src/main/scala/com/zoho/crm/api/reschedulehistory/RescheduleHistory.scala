package com.zoho.crm.api.reschedulehistory

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class RescheduleHistory extends Model	{
	private var currencySymbol:Option[String] = None
	private var rescheduledTo:Option[OffsetDateTime] = None
	private var reviewProcess:Option[Boolean] = None
	private var rescheduleReason:Option[String] = None
	private var sharingPermission:Option[String] = None
	private var name:Option[String] = None
	private var modifiedBy:Option[User] = None
	private var review:Option[Boolean] = None
	private var rescheduledBy:Option[User] = None
	private var state:Option[String] = None
	private var canvasId:Option[String] = None
	private var processFlow:Option[Boolean] = None
	private var id:Option[Long] = None
	private var rescheduledTime:Option[OffsetDateTime] = None
	private var ziaVisions:Option[Boolean] = None
	private var approved:Option[Boolean] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var approval:Option[Approval] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var rescheduledFrom:Option[OffsetDateTime] = None
	private var appointmentName:Option[AppointmentName] = None
	private var editable:Option[Boolean] = None
	private var orchestration:Option[Boolean] = None
	private var inMerge:Option[Boolean] = None
	private var createdBy:Option[User] = None
	private var approvalState:Option[String] = None
	private var rescheduleNote:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getcurrencySymbol() :Option[String]	={
		return  this.currencySymbol
	}

	def setcurrencySymbol( currencySymbol: Option[String]) 	={
		 this.currencySymbol = currencySymbol
		 this.keyModified("$currency_symbol") = 1
	}

	def getRescheduledTo() :Option[OffsetDateTime]	={
		return  this.rescheduledTo
	}

	def setRescheduledTo( rescheduledTo: Option[OffsetDateTime]) 	={
		 this.rescheduledTo = rescheduledTo
		 this.keyModified("Rescheduled_To") = 1
	}

	def getreviewProcess() :Option[Boolean]	={
		return  this.reviewProcess
	}

	def setreviewProcess( reviewProcess: Option[Boolean]) 	={
		 this.reviewProcess = reviewProcess
		 this.keyModified("$review_process") = 1
	}

	def getRescheduleReason() :Option[String]	={
		return  this.rescheduleReason
	}

	def setRescheduleReason( rescheduleReason: Option[String]) 	={
		 this.rescheduleReason = rescheduleReason
		 this.keyModified("Reschedule_Reason") = 1
	}

	def getsharingPermission() :Option[String]	={
		return  this.sharingPermission
	}

	def setsharingPermission( sharingPermission: Option[String]) 	={
		 this.sharingPermission = sharingPermission
		 this.keyModified("$sharing_permission") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("Name") = 1
	}

	def getModifiedBy() :Option[User]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[User]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("Modified_By") = 1
	}

	def getreview() :Option[Boolean]	={
		return  this.review
	}

	def setreview( review: Option[Boolean]) 	={
		 this.review = review
		 this.keyModified("$review") = 1
	}

	def getRescheduledBy() :Option[User]	={
		return  this.rescheduledBy
	}

	def setRescheduledBy( rescheduledBy: Option[User]) 	={
		 this.rescheduledBy = rescheduledBy
		 this.keyModified("Rescheduled_By") = 1
	}

	def getstate() :Option[String]	={
		return  this.state
	}

	def setstate( state: Option[String]) 	={
		 this.state = state
		 this.keyModified("$state") = 1
	}

	def getcanvasId() :Option[String]	={
		return  this.canvasId
	}

	def setcanvasId( canvasId: Option[String]) 	={
		 this.canvasId = canvasId
		 this.keyModified("$canvas_id") = 1
	}

	def getprocessFlow() :Option[Boolean]	={
		return  this.processFlow
	}

	def setprocessFlow( processFlow: Option[Boolean]) 	={
		 this.processFlow = processFlow
		 this.keyModified("$process_flow") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getRescheduledTime() :Option[OffsetDateTime]	={
		return  this.rescheduledTime
	}

	def setRescheduledTime( rescheduledTime: Option[OffsetDateTime]) 	={
		 this.rescheduledTime = rescheduledTime
		 this.keyModified("Rescheduled_Time") = 1
	}

	def getziaVisions() :Option[Boolean]	={
		return  this.ziaVisions
	}

	def setziaVisions( ziaVisions: Option[Boolean]) 	={
		 this.ziaVisions = ziaVisions
		 this.keyModified("$zia_visions") = 1
	}

	def getapproved() :Option[Boolean]	={
		return  this.approved
	}

	def setapproved( approved: Option[Boolean]) 	={
		 this.approved = approved
		 this.keyModified("$approved") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("Modified_Time") = 1
	}

	def getapproval() :Option[Approval]	={
		return  this.approval
	}

	def setapproval( approval: Option[Approval]) 	={
		 this.approval = approval
		 this.keyModified("$approval") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("Created_Time") = 1
	}

	def getRescheduledFrom() :Option[OffsetDateTime]	={
		return  this.rescheduledFrom
	}

	def setRescheduledFrom( rescheduledFrom: Option[OffsetDateTime]) 	={
		 this.rescheduledFrom = rescheduledFrom
		 this.keyModified("Rescheduled_From") = 1
	}

	def getAppointmentName() :Option[AppointmentName]	={
		return  this.appointmentName
	}

	def setAppointmentName( appointmentName: Option[AppointmentName]) 	={
		 this.appointmentName = appointmentName
		 this.keyModified("Appointment_Name") = 1
	}

	def geteditable() :Option[Boolean]	={
		return  this.editable
	}

	def seteditable( editable: Option[Boolean]) 	={
		 this.editable = editable
		 this.keyModified("$editable") = 1
	}

	def getorchestration() :Option[Boolean]	={
		return  this.orchestration
	}

	def setorchestration( orchestration: Option[Boolean]) 	={
		 this.orchestration = orchestration
		 this.keyModified("$orchestration") = 1
	}

	def getinMerge() :Option[Boolean]	={
		return  this.inMerge
	}

	def setinMerge( inMerge: Option[Boolean]) 	={
		 this.inMerge = inMerge
		 this.keyModified("$in_merge") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("Created_By") = 1
	}

	def getapprovalState() :Option[String]	={
		return  this.approvalState
	}

	def setapprovalState( approvalState: Option[String]) 	={
		 this.approvalState = approvalState
		 this.keyModified("$approval_state") = 1
	}

	def getRescheduleNote() :Option[String]	={
		return  this.rescheduleNote
	}

	def setRescheduleNote( rescheduleNote: Option[String]) 	={
		 this.rescheduleNote = rescheduleNote
		 this.keyModified("Reschedule_Note") = 1
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