package com.zoho.crm.api.hipaacompliance

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ActionWrapper extends Model	{
	private var hipaaCompliance:Option[ActionResponse] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getHipaaCompliance() :Option[ActionResponse]	={
		return  this.hipaaCompliance
	}

	def setHipaaCompliance( hipaaCompliance: Option[ActionResponse]) 	={
		 this.hipaaCompliance = hipaaCompliance
		 this.keyModified("hipaa_compliance") = 1
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