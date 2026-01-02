package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AcknowledgeVisitor extends Model	{
	private var replyToAddress:Option[FromAddress] = None
	private var templateName:Option[String] = None
	private var autoResponseRule:Option[AutoResponseRule] = None
	private var templateId:Option[String] = None
	private var fromAddress:Option[FromAddress] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getReplyToAddress() :Option[FromAddress]	={
		return  this.replyToAddress
	}

	def setReplyToAddress( replyToAddress: Option[FromAddress]) 	={
		 this.replyToAddress = replyToAddress
		 this.keyModified("reply_to_address") = 1
	}

	def getTemplateName() :Option[String]	={
		return  this.templateName
	}

	def setTemplateName( templateName: Option[String]) 	={
		 this.templateName = templateName
		 this.keyModified("template_name") = 1
	}

	def getAutoResponseRule() :Option[AutoResponseRule]	={
		return  this.autoResponseRule
	}

	def setAutoResponseRule( autoResponseRule: Option[AutoResponseRule]) 	={
		 this.autoResponseRule = autoResponseRule
		 this.keyModified("auto_response_rule") = 1
	}

	def getTemplateId() :Option[String]	={
		return  this.templateId
	}

	def setTemplateId( templateId: Option[String]) 	={
		 this.templateId = templateId
		 this.keyModified("template_id") = 1
	}

	def getFromAddress() :Option[FromAddress]	={
		return  this.fromAddress
	}

	def setFromAddress( fromAddress: Option[FromAddress]) 	={
		 this.fromAddress = fromAddress
		 this.keyModified("from_address") = 1
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