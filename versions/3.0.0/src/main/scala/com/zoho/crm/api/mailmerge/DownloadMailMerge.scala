package com.zoho.crm.api.mailmerge

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class DownloadMailMerge extends Model	{
	private var mailMergeTemplate:Option[MailMergeTemplate] = None
	private var outputFormat:Choice[String] = _
	private var fileName:Option[String] = None
	private var password:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMailMergeTemplate() :Option[MailMergeTemplate]	={
		return  this.mailMergeTemplate
	}

	def setMailMergeTemplate( mailMergeTemplate: Option[MailMergeTemplate]) 	={
		 this.mailMergeTemplate = mailMergeTemplate
		 this.keyModified("mail_merge_template") = 1
	}

	def getOutputFormat() :Choice[String]	={
		return  this.outputFormat
	}

	def setOutputFormat( outputFormat: Choice[String]) 	={
		 this.outputFormat = outputFormat
		 this.keyModified("output_format") = 1
	}

	def getFileName() :Option[String]	={
		return  this.fileName
	}

	def setFileName( fileName: Option[String]) 	={
		 this.fileName = fileName
		 this.keyModified("file_name") = 1
	}

	def getPassword() :Option[String]	={
		return  this.password
	}

	def setPassword( password: Option[String]) 	={
		 this.password = password
		 this.keyModified("password") = 1
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