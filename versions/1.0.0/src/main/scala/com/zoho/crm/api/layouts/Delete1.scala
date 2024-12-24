package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Delete1 extends Model	{
	private var permanent:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPermanent() :Option[Boolean]	={
		return  this.permanent
	}

	def setPermanent( permanent: Option[Boolean]) 	={
		 this.permanent = permanent
		 this.keyModified("permanent") = 1
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