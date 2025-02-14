package com.zoho.crm.api.emailcomposemeta

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Signature extends Model	{
	private var mode:Option[Int] = None
	private var sign:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMode() :Option[Int]	={
		return  this.mode
	}

	def setMode( mode: Option[Int]) 	={
		 this.mode = mode
		 this.keyModified("mode") = 1
	}

	def getSign() :Option[String]	={
		return  this.sign
	}

	def setSign( sign: Option[String]) 	={
		 this.sign = sign
		 this.keyModified("sign") = 1
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