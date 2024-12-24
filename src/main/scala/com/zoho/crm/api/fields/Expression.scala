package com.zoho.crm.api.fields

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Expression extends Model	{
	private var functionParameters:ArrayBuffer[FunctionParameter] = _
	private var criteria:Option[RollupCriteria] = None
	private var function:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFunctionParameters() :ArrayBuffer[FunctionParameter]	={
		return  this.functionParameters
	}

	def setFunctionParameters( functionParameters: ArrayBuffer[FunctionParameter]) 	={
		 this.functionParameters = functionParameters
		 this.keyModified("function_parameters") = 1
	}

	def getCriteria() :Option[RollupCriteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[RollupCriteria]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
	}

	def getFunction() :Option[String]	={
		return  this.function
	}

	def setFunction( function: Option[String]) 	={
		 this.function = function
		 this.keyModified("function") = 1
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