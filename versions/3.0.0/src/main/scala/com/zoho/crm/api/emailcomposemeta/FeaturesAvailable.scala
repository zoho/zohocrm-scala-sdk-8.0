package com.zoho.crm.api.emailcomposemeta

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FeaturesAvailable extends Model	{
	private var zsurveyEnabled:Choice[Boolean] = _
	private var inlineComposeWindow:Choice[Boolean] = _
	private var scheduleMail:Choice[Boolean] = _
	private var emailCloudPicker:Choice[Boolean] = _
	private var formIntegrationEnabled:Choice[Boolean] = _
	private var isprivacyenabled:Choice[Boolean] = _
	private var autoSuggestion:Choice[Boolean] = _
	private var unsubscribeLink:Choice[Boolean] = _
	private var bestTimeToContact:Choice[Boolean] = _
	private var attachTeamdrive:Choice[Boolean] = _
	private var islivedeskenabled:Choice[Boolean] = _
	private var subjectLineSuggestion:Option[Boolean] = None
	private var emailPreference:Option[Boolean] = None
	private var attachment:Option[Boolean] = None
	private var mandateunsublink:Option[Boolean] = None
	private var oldComposeRevert:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getZsurveyEnabled() :Choice[Boolean]	={
		return  this.zsurveyEnabled
	}

	def setZsurveyEnabled( zsurveyEnabled: Choice[Boolean]) 	={
		 this.zsurveyEnabled = zsurveyEnabled
		 this.keyModified("zsurvey_enabled") = 1
	}

	def getInlineComposeWindow() :Choice[Boolean]	={
		return  this.inlineComposeWindow
	}

	def setInlineComposeWindow( inlineComposeWindow: Choice[Boolean]) 	={
		 this.inlineComposeWindow = inlineComposeWindow
		 this.keyModified("inline_compose_window") = 1
	}

	def getScheduleMail() :Choice[Boolean]	={
		return  this.scheduleMail
	}

	def setScheduleMail( scheduleMail: Choice[Boolean]) 	={
		 this.scheduleMail = scheduleMail
		 this.keyModified("Schedule_Mail") = 1
	}

	def getEmailCloudPicker() :Choice[Boolean]	={
		return  this.emailCloudPicker
	}

	def setEmailCloudPicker( emailCloudPicker: Choice[Boolean]) 	={
		 this.emailCloudPicker = emailCloudPicker
		 this.keyModified("EMAIL_CLOUD_PICKER") = 1
	}

	def getFormIntegrationEnabled() :Choice[Boolean]	={
		return  this.formIntegrationEnabled
	}

	def setFormIntegrationEnabled( formIntegrationEnabled: Choice[Boolean]) 	={
		 this.formIntegrationEnabled = formIntegrationEnabled
		 this.keyModified("form_integration_enabled") = 1
	}

	def getIsprivacyenabled() :Choice[Boolean]	={
		return  this.isprivacyenabled
	}

	def setIsprivacyenabled( isprivacyenabled: Choice[Boolean]) 	={
		 this.isprivacyenabled = isprivacyenabled
		 this.keyModified("isPrivacyEnabled") = 1
	}

	def getAutoSuggestion() :Choice[Boolean]	={
		return  this.autoSuggestion
	}

	def setAutoSuggestion( autoSuggestion: Choice[Boolean]) 	={
		 this.autoSuggestion = autoSuggestion
		 this.keyModified("auto_suggestion") = 1
	}

	def getUnsubscribeLink() :Choice[Boolean]	={
		return  this.unsubscribeLink
	}

	def setUnsubscribeLink( unsubscribeLink: Choice[Boolean]) 	={
		 this.unsubscribeLink = unsubscribeLink
		 this.keyModified("UNSUBSCRIBE_LINK") = 1
	}

	def getBestTimeToContact() :Choice[Boolean]	={
		return  this.bestTimeToContact
	}

	def setBestTimeToContact( bestTimeToContact: Choice[Boolean]) 	={
		 this.bestTimeToContact = bestTimeToContact
		 this.keyModified("best_time_to_contact") = 1
	}

	def getAttachTeamdrive() :Choice[Boolean]	={
		return  this.attachTeamdrive
	}

	def setAttachTeamdrive( attachTeamdrive: Choice[Boolean]) 	={
		 this.attachTeamdrive = attachTeamdrive
		 this.keyModified("attach_teamdrive") = 1
	}

	def getIslivedeskenabled() :Choice[Boolean]	={
		return  this.islivedeskenabled
	}

	def setIslivedeskenabled( islivedeskenabled: Choice[Boolean]) 	={
		 this.islivedeskenabled = islivedeskenabled
		 this.keyModified("isLiveDeskEnabled") = 1
	}

	def getSubjectLineSuggestion() :Option[Boolean]	={
		return  this.subjectLineSuggestion
	}

	def setSubjectLineSuggestion( subjectLineSuggestion: Option[Boolean]) 	={
		 this.subjectLineSuggestion = subjectLineSuggestion
		 this.keyModified("subject_line_suggestion") = 1
	}

	def getEmailPreference() :Option[Boolean]	={
		return  this.emailPreference
	}

	def setEmailPreference( emailPreference: Option[Boolean]) 	={
		 this.emailPreference = emailPreference
		 this.keyModified("EMAIL_PREFERENCE") = 1
	}

	def getAttachment() :Option[Boolean]	={
		return  this.attachment
	}

	def setAttachment( attachment: Option[Boolean]) 	={
		 this.attachment = attachment
		 this.keyModified("ATTACHMENT") = 1
	}

	def getMandateunsublink() :Option[Boolean]	={
		return  this.mandateunsublink
	}

	def setMandateunsublink( mandateunsublink: Option[Boolean]) 	={
		 this.mandateunsublink = mandateunsublink
		 this.keyModified("mandateUnsubLink") = 1
	}

	def getOldComposeRevert() :Option[Boolean]	={
		return  this.oldComposeRevert
	}

	def setOldComposeRevert( oldComposeRevert: Option[Boolean]) 	={
		 this.oldComposeRevert = oldComposeRevert
		 this.keyModified("OLD_COMPOSE_REVERT") = 1
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