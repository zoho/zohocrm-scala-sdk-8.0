package com.zoho.crm.api.record

import com.zoho.crm.api.tags.Tag
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Model
import java.time.LocalDate
import java.time.OffsetDateTime
import scala.collection.mutable.ArrayBuffer

class Consent extends Record with Model	{

	def getOwner() :Option[MinifiedUser]	={
		return  this.getKeyValue("Owner").asInstanceOf[Option[MinifiedUser]]
	}

	def setOwner( owner: Option[MinifiedUser]) 	={
		 this.addKeyValue("Owner", owner)
	}

	def getContactThroughEmail() :Option[Boolean]	={
		return  this.getKeyValue("Contact_Through_Email").asInstanceOf[Option[Boolean]]
	}

	def setContactThroughEmail( contactThroughEmail: Option[Boolean]) 	={
		 this.addKeyValue("Contact_Through_Email", contactThroughEmail)
	}

	def getContactThroughSocial() :Option[Boolean]	={
		return  this.getKeyValue("Contact_Through_Social").asInstanceOf[Option[Boolean]]
	}

	def setContactThroughSocial( contactThroughSocial: Option[Boolean]) 	={
		 this.addKeyValue("Contact_Through_Social", contactThroughSocial)
	}

	def getContactThroughSurvey() :Option[Boolean]	={
		return  this.getKeyValue("Contact_Through_Survey").asInstanceOf[Option[Boolean]]
	}

	def setContactThroughSurvey( contactThroughSurvey: Option[Boolean]) 	={
		 this.addKeyValue("Contact_Through_Survey", contactThroughSurvey)
	}

	def getContactThroughPhone() :Option[Boolean]	={
		return  this.getKeyValue("Contact_Through_Phone").asInstanceOf[Option[Boolean]]
	}

	def setContactThroughPhone( contactThroughPhone: Option[Boolean]) 	={
		 this.addKeyValue("Contact_Through_Phone", contactThroughPhone)
	}

	def getMailSentTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Mail_Sent_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	def setMailSentTime( mailSentTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Mail_Sent_Time", mailSentTime)
	}

	def getConsentDate() :Option[LocalDate]	={
		return  this.getKeyValue("Consent_Date").asInstanceOf[Option[LocalDate]]
	}

	def setConsentDate( consentDate: Option[LocalDate]) 	={
		 this.addKeyValue("Consent_Date", consentDate)
	}

	def getConsentRemarks() :Option[String]	={
		return  this.getKeyValue("Consent_Remarks").asInstanceOf[Option[String]]
	}

	def setConsentRemarks( consentRemarks: Option[String]) 	={
		 this.addKeyValue("Consent_Remarks", consentRemarks)
	}

	def getConsentThrough() :Option[String]	={
		return  this.getKeyValue("Consent_Through").asInstanceOf[Option[String]]
	}

	def setConsentThrough( consentThrough: Option[String]) 	={
		 this.addKeyValue("Consent_Through", consentThrough)
	}

	def getDataProcessingBasis() :Option[String]	={
		return  this.getKeyValue("Data_Processing_Basis").asInstanceOf[Option[String]]
	}

	def setDataProcessingBasis( dataProcessingBasis: Option[String]) 	={
		 this.addKeyValue("Data_Processing_Basis", dataProcessingBasis)
	}

	override def getId() :Option[Long]	={
		return  this.getKeyValue("id").asInstanceOf[Option[Long]]
	}

	override def setId( id: Option[Long]) 	={
		 this.addKeyValue("id", id)
	}

	override def getCreatedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("Created_By").asInstanceOf[Option[MinifiedUser]]
	}

	override def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("Created_By", createdBy)
	}

	override def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Created_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Created_Time", createdTime)
	}

	override def getModifiedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("Modified_By").asInstanceOf[Option[MinifiedUser]]
	}

	override def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("Modified_By", modifiedBy)
	}

	override def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Modified_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Modified_Time", modifiedTime)
	}

	override def getTag() :ArrayBuffer[Tag]	={
		return  this.getKeyValue("Tag").asInstanceOf[ArrayBuffer[Tag]]
	}

	override def setTag( tag: ArrayBuffer[Tag]) 	={
		 this.addKeyValue("Tag", tag)
	}

	override def getName() :Option[String]	={
		return  this.getKeyValue("name").asInstanceOf[Option[String]]
	}

	override def setName( name: Option[String]) 	={
		 this.addKeyValue("name", name)
	}}