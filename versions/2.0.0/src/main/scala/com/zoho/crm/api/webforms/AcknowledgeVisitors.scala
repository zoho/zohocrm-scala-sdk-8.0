package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AcknowledgeVisitors extends Model	{
	private var templateName:Option[String] = None
	private var templateId:Option[Long] = None
	private var fromAddress:Option[FromAddress] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTemplateName() :Option[String]	={
		return  this.templateName
	}

	def setTemplateName( templateName: Option[String]) 	={
		 this.templateName = templateName
		 this.keyModified("template_name") = 1
	}

	def getTemplateId() :Option[Long]	={
		return  this.templateId
	}

	def setTemplateId( templateId: Option[Long]) 	={
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