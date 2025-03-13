package com.zoho.crm.api.mailmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class SignMailMerge extends Model	{
	private var mailMergeTemplate:Option[MailMergeTemplate] = None
	private var signInOrder:Option[Boolean] = None
	private var fileName:Option[String] = None
	private var signers:ArrayBuffer[Signers] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMailMergeTemplate() :Option[MailMergeTemplate]	={
		return  this.mailMergeTemplate
	}

	def setMailMergeTemplate( mailMergeTemplate: Option[MailMergeTemplate]) 	={
		 this.mailMergeTemplate = mailMergeTemplate
		 this.keyModified("mail_merge_template") = 1
	}

	def getSignInOrder() :Option[Boolean]	={
		return  this.signInOrder
	}

	def setSignInOrder( signInOrder: Option[Boolean]) 	={
		 this.signInOrder = signInOrder
		 this.keyModified("sign_in_order") = 1
	}

	def getFileName() :Option[String]	={
		return  this.fileName
	}

	def setFileName( fileName: Option[String]) 	={
		 this.fileName = fileName
		 this.keyModified("file_name") = 1
	}

	def getSigners() :ArrayBuffer[Signers]	={
		return  this.signers
	}

	def setSigners( signers: ArrayBuffer[Signers]) 	={
		 this.signers = signers
		 this.keyModified("signers") = 1
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