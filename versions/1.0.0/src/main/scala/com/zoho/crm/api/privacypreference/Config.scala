package com.zoho.crm.api.privacypreference

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Config extends Model	{
	private var tpt:ArrayBuffer[Tpt] = _
	private var section:ArrayBuffer[Section] = _
	private var zohoInteg:ArrayBuffer[Tpt] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTpt() :ArrayBuffer[Tpt]	={
		return  this.tpt
	}

	def setTpt( tpt: ArrayBuffer[Tpt]) 	={
		 this.tpt = tpt
		 this.keyModified("tpt") = 1
	}

	def getSection() :ArrayBuffer[Section]	={
		return  this.section
	}

	def setSection( section: ArrayBuffer[Section]) 	={
		 this.section = section
		 this.keyModified("section") = 1
	}

	def getZohoInteg() :ArrayBuffer[Tpt]	={
		return  this.zohoInteg
	}

	def setZohoInteg( zohoInteg: ArrayBuffer[Tpt]) 	={
		 this.zohoInteg = zohoInteg
		 this.keyModified("zoho_integ") = 1
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