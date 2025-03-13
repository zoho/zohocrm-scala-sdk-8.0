package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Formula extends Model	{
	private var returnType:Option[String] = None
	private var assumeDefault:Option[Boolean] = None
	private var expression:Option[String] = None
	private var dynamic:Option[Boolean] = None
	private var stopComputeConditionally:Option[Boolean] = None
	private var stopComputeExpression:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getReturnType() :Option[String]	={
		return  this.returnType
	}

	def setReturnType( returnType: Option[String]) 	={
		 this.returnType = returnType
		 this.keyModified("return_type") = 1
	}

	def getAssumeDefault() :Option[Boolean]	={
		return  this.assumeDefault
	}

	def setAssumeDefault( assumeDefault: Option[Boolean]) 	={
		 this.assumeDefault = assumeDefault
		 this.keyModified("assume_default") = 1
	}

	def getExpression() :Option[String]	={
		return  this.expression
	}

	def setExpression( expression: Option[String]) 	={
		 this.expression = expression
		 this.keyModified("expression") = 1
	}

	def getDynamic() :Option[Boolean]	={
		return  this.dynamic
	}

	def setDynamic( dynamic: Option[Boolean]) 	={
		 this.dynamic = dynamic
		 this.keyModified("dynamic") = 1
	}

	def getStopComputeConditionally() :Option[Boolean]	={
		return  this.stopComputeConditionally
	}

	def setStopComputeConditionally( stopComputeConditionally: Option[Boolean]) 	={
		 this.stopComputeConditionally = stopComputeConditionally
		 this.keyModified("stop_compute_conditionally") = 1
	}

	def getStopComputeExpression() :Option[String]	={
		return  this.stopComputeExpression
	}

	def setStopComputeExpression( stopComputeExpression: Option[String]) 	={
		 this.stopComputeExpression = stopComputeExpression
		 this.keyModified("stop_compute_expression") = 1
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