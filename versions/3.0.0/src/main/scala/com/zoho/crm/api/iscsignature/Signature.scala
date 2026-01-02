package com.zoho.crm.api.iscsignature

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Signature extends Model	{
	private var iscSignature:Any = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getIscSignature() :Any	={
		return  this.iscSignature
	}

	def setIscSignature( iscSignature: Any) 	={
		 this.iscSignature = iscSignature
		 this.keyModified("isc_signature") = 1
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