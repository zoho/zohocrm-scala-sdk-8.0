package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class WebForm extends Model	{
	private var googleSite:Option[String] = None
	private var encryptedFormId:Option[String] = None
	private var owner:Option[Owner] = None
	private var userType:Option[User] = None
	private var acknowledgeVisitor:Option[AcknowledgeVisitors] = None
	private var buttonAttributes:ArrayBuffer[ButtonAttributes] = _
	private var encryptedZgid:Option[String] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var analyticsData:Option[AnalyticsData] = None
	private var module:Option[Module] = None
	private var encryptedModule:Option[String] = None
	private var active:Option[Boolean] = None
	private var adwordEnabled:Option[Boolean] = None
	private var notifyOwner:Option[Owner] = None
	private var createdBy:Option[User] = None
	private var formAttributes:Option[FormAttributes] = None
	private var locationUrl:ArrayBuffer[String] = _
	private var landingUrl:Option[String] = None
	private var doubleOptinEnabled:Option[Boolean] = None
	private var layout:Option[Layout] = None
	private var tags:ArrayBuffer[Tags] = _
	private var approvalRequest:Option[Boolean] = None
	private var type1:Option[String] = None
	private var createContact:Option[Boolean] = None
	private var assignmentRule:Option[AssignmentRule] = None
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var spamControl:Option[SpamControll] = None
	private var fields:ArrayBuffer[Fields] = _
	private var formFields:ArrayBuffer[Fields] = _
	private var abtesting:ArrayBuffer[Abtesting] = _
	private var visitorTracking:Option[String] = None
	private var lastSubmittedTime:Option[OffsetDateTime] = None
	private var actionOnSubmit:Option[String] = None
	private var actionValue:Option[String] = None
	private var suggestion:Option[Suggestion] = None
	private var embedCode:Option[String] = None
	private var codeFormats:ArrayBuffer[String] = _
	private var sourceCode:Option[String] = None
	private var iframeCode:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getGoogleSite() :Option[String]	={
		return  this.googleSite
	}

	def setGoogleSite( googleSite: Option[String]) 	={
		 this.googleSite = googleSite
		 this.keyModified("google_site") = 1
	}

	def getEncryptedFormId() :Option[String]	={
		return  this.encryptedFormId
	}

	def setEncryptedFormId( encryptedFormId: Option[String]) 	={
		 this.encryptedFormId = encryptedFormId
		 this.keyModified("encrypted_form_id") = 1
	}

	def getOwner() :Option[Owner]	={
		return  this.owner
	}

	def setOwner( owner: Option[Owner]) 	={
		 this.owner = owner
		 this.keyModified("owner") = 1
	}

	def getUserType() :Option[User]	={
		return  this.userType
	}

	def setUserType( userType: Option[User]) 	={
		 this.userType = userType
		 this.keyModified("user_type") = 1
	}

	def getAcknowledgeVisitor() :Option[AcknowledgeVisitors]	={
		return  this.acknowledgeVisitor
	}

	def setAcknowledgeVisitor( acknowledgeVisitor: Option[AcknowledgeVisitors]) 	={
		 this.acknowledgeVisitor = acknowledgeVisitor
		 this.keyModified("acknowledge_visitor") = 1
	}

	def getButtonAttributes() :ArrayBuffer[ButtonAttributes]	={
		return  this.buttonAttributes
	}

	def setButtonAttributes( buttonAttributes: ArrayBuffer[ButtonAttributes]) 	={
		 this.buttonAttributes = buttonAttributes
		 this.keyModified("button_attributes") = 1
	}

	def getEncryptedZgid() :Option[String]	={
		return  this.encryptedZgid
	}

	def setEncryptedZgid( encryptedZgid: Option[String]) 	={
		 this.encryptedZgid = encryptedZgid
		 this.keyModified("encrypted_zgid") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getAnalyticsData() :Option[AnalyticsData]	={
		return  this.analyticsData
	}

	def setAnalyticsData( analyticsData: Option[AnalyticsData]) 	={
		 this.analyticsData = analyticsData
		 this.keyModified("analytics_data") = 1
	}

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getEncryptedModule() :Option[String]	={
		return  this.encryptedModule
	}

	def setEncryptedModule( encryptedModule: Option[String]) 	={
		 this.encryptedModule = encryptedModule
		 this.keyModified("encrypted_module") = 1
	}

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	def getAdwordEnabled() :Option[Boolean]	={
		return  this.adwordEnabled
	}

	def setAdwordEnabled( adwordEnabled: Option[Boolean]) 	={
		 this.adwordEnabled = adwordEnabled
		 this.keyModified("adword_enabled") = 1
	}

	def getNotifyOwner() :Option[Owner]	={
		return  this.notifyOwner
	}

	def setNotifyOwner( notifyOwner: Option[Owner]) 	={
		 this.notifyOwner = notifyOwner
		 this.keyModified("notify_owner") = 1
	}

	def getCreatedBy() :Option[User]	={
		return  this.createdBy
	}

	def setCreatedBy( createdBy: Option[User]) 	={
		 this.createdBy = createdBy
		 this.keyModified("created_by") = 1
	}

	def getFormAttributes() :Option[FormAttributes]	={
		return  this.formAttributes
	}

	def setFormAttributes( formAttributes: Option[FormAttributes]) 	={
		 this.formAttributes = formAttributes
		 this.keyModified("form_attributes") = 1
	}

	def getLocationUrl() :ArrayBuffer[String]	={
		return  this.locationUrl
	}

	def setLocationUrl( locationUrl: ArrayBuffer[String]) 	={
		 this.locationUrl = locationUrl
		 this.keyModified("location_url") = 1
	}

	def getLandingUrl() :Option[String]	={
		return  this.landingUrl
	}

	def setLandingUrl( landingUrl: Option[String]) 	={
		 this.landingUrl = landingUrl
		 this.keyModified("landing_url") = 1
	}

	def getDoubleOptinEnabled() :Option[Boolean]	={
		return  this.doubleOptinEnabled
	}

	def setDoubleOptinEnabled( doubleOptinEnabled: Option[Boolean]) 	={
		 this.doubleOptinEnabled = doubleOptinEnabled
		 this.keyModified("double_optin_enabled") = 1
	}

	def getLayout() :Option[Layout]	={
		return  this.layout
	}

	def setLayout( layout: Option[Layout]) 	={
		 this.layout = layout
		 this.keyModified("layout") = 1
	}

	def getTags() :ArrayBuffer[Tags]	={
		return  this.tags
	}

	def setTags( tags: ArrayBuffer[Tags]) 	={
		 this.tags = tags
		 this.keyModified("tags") = 1
	}

	def getApprovalRequest() :Option[Boolean]	={
		return  this.approvalRequest
	}

	def setApprovalRequest( approvalRequest: Option[Boolean]) 	={
		 this.approvalRequest = approvalRequest
		 this.keyModified("approval_request") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getCreateContact() :Option[Boolean]	={
		return  this.createContact
	}

	def setCreateContact( createContact: Option[Boolean]) 	={
		 this.createContact = createContact
		 this.keyModified("create_contact") = 1
	}

	def getAssignmentRule() :Option[AssignmentRule]	={
		return  this.assignmentRule
	}

	def setAssignmentRule( assignmentRule: Option[AssignmentRule]) 	={
		 this.assignmentRule = assignmentRule
		 this.keyModified("assignment_rule") = 1
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

	def getSpamControl() :Option[SpamControll]	={
		return  this.spamControl
	}

	def setSpamControl( spamControl: Option[SpamControll]) 	={
		 this.spamControl = spamControl
		 this.keyModified("spam_control") = 1
	}

	def getFields() :ArrayBuffer[Fields]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[Fields]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	def getFormFields() :ArrayBuffer[Fields]	={
		return  this.formFields
	}

	def setFormFields( formFields: ArrayBuffer[Fields]) 	={
		 this.formFields = formFields
		 this.keyModified("form_fields") = 1
	}

	def getAbtesting() :ArrayBuffer[Abtesting]	={
		return  this.abtesting
	}

	def setAbtesting( abtesting: ArrayBuffer[Abtesting]) 	={
		 this.abtesting = abtesting
		 this.keyModified("abtesting") = 1
	}

	def getVisitorTracking() :Option[String]	={
		return  this.visitorTracking
	}

	def setVisitorTracking( visitorTracking: Option[String]) 	={
		 this.visitorTracking = visitorTracking
		 this.keyModified("visitor_tracking") = 1
	}

	def getLastSubmittedTime() :Option[OffsetDateTime]	={
		return  this.lastSubmittedTime
	}

	def setLastSubmittedTime( lastSubmittedTime: Option[OffsetDateTime]) 	={
		 this.lastSubmittedTime = lastSubmittedTime
		 this.keyModified("last_submitted_time") = 1
	}

	def getActionOnSubmit() :Option[String]	={
		return  this.actionOnSubmit
	}

	def setActionOnSubmit( actionOnSubmit: Option[String]) 	={
		 this.actionOnSubmit = actionOnSubmit
		 this.keyModified("action_on_submit") = 1
	}

	def getActionValue() :Option[String]	={
		return  this.actionValue
	}

	def setActionValue( actionValue: Option[String]) 	={
		 this.actionValue = actionValue
		 this.keyModified("action_value") = 1
	}

	def getSuggestion() :Option[Suggestion]	={
		return  this.suggestion
	}

	def setSuggestion( suggestion: Option[Suggestion]) 	={
		 this.suggestion = suggestion
		 this.keyModified("suggestion") = 1
	}

	def getEmbedCode() :Option[String]	={
		return  this.embedCode
	}

	def setEmbedCode( embedCode: Option[String]) 	={
		 this.embedCode = embedCode
		 this.keyModified("embed_code") = 1
	}

	def getCodeFormats() :ArrayBuffer[String]	={
		return  this.codeFormats
	}

	def setCodeFormats( codeFormats: ArrayBuffer[String]) 	={
		 this.codeFormats = codeFormats
		 this.keyModified("code_formats") = 1
	}

	def getSourceCode() :Option[String]	={
		return  this.sourceCode
	}

	def setSourceCode( sourceCode: Option[String]) 	={
		 this.sourceCode = sourceCode
		 this.keyModified("source_code") = 1
	}

	def getIframeCode() :Option[String]	={
		return  this.iframeCode
	}

	def setIframeCode( iframeCode: Option[String]) 	={
		 this.iframeCode = iframeCode
		 this.keyModified("iframe_code") = 1
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