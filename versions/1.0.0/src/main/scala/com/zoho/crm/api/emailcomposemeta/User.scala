package com.zoho.crm.api.emailcomposemeta

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class User extends Model	{
	private var fullName:Option[String] = None
	private var email:Option[String] = None
	private var zuid:Option[String] = None
	private var zgid:Option[String] = None
	private var signature:Option[Signature] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFullName() :Option[String]	={
		return  this.fullName
	}

	def setFullName( fullName: Option[String]) 	={
		 this.fullName = fullName
		 this.keyModified("full_name") = 1
	}

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
	}

	def getZuid() :Option[String]	={
		return  this.zuid
	}

	def setZuid( zuid: Option[String]) 	={
		 this.zuid = zuid
		 this.keyModified("zuid") = 1
	}

	def getZgid() :Option[String]	={
		return  this.zgid
	}

	def setZgid( zgid: Option[String]) 	={
		 this.zgid = zgid
		 this.keyModified("zgid") = 1
	}

	def getSignature() :Option[Signature]	={
		return  this.signature
	}

	def setSignature( signature: Option[Signature]) 	={
		 this.signature = signature
		 this.keyModified("signature") = 1
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