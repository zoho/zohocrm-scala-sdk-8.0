package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AcknowledgeVisitor extends Model	{
	private var autoResponseRule:Option[AutoResponseRule] = None
	private var templateId:Option[Long] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAutoResponseRule() :Option[AutoResponseRule]	={
		return  this.autoResponseRule
	}

	def setAutoResponseRule( autoResponseRule: Option[AutoResponseRule]) 	={
		 this.autoResponseRule = autoResponseRule
		 this.keyModified("auto_response_rule") = 1
	}

	def getTemplateId() :Option[Long]	={
		return  this.templateId
	}

	def setTemplateId( templateId: Option[Long]) 	={
		 this.templateId = templateId
		 this.keyModified("template_id") = 1
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