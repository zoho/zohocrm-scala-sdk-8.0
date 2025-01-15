package com.zoho.crm.api.fields

import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.relatedlists.RelatedList
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class RollupSummary extends Model	{
	private var returnType:Option[String] = None
	private var expression:Option[Expression] = None
	private var basedOnModule:Option[MinifiedModule] = None
	private var relatedList:Option[RelatedList] = None
	private var rollupBasedOn:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getReturnType() :Option[String]	={
		return  this.returnType
	}

	def setReturnType( returnType: Option[String]) 	={
		 this.returnType = returnType
		 this.keyModified("return_type") = 1
	}

	def getExpression() :Option[Expression]	={
		return  this.expression
	}

	def setExpression( expression: Option[Expression]) 	={
		 this.expression = expression
		 this.keyModified("expression") = 1
	}

	def getBasedOnModule() :Option[MinifiedModule]	={
		return  this.basedOnModule
	}

	def setBasedOnModule( basedOnModule: Option[MinifiedModule]) 	={
		 this.basedOnModule = basedOnModule
		 this.keyModified("based_on_module") = 1
	}

	def getRelatedList() :Option[RelatedList]	={
		return  this.relatedList
	}

	def setRelatedList( relatedList: Option[RelatedList]) 	={
		 this.relatedList = relatedList
		 this.keyModified("related_list") = 1
	}

	def getRollupBasedOn() :Option[String]	={
		return  this.rollupBasedOn
	}

	def setRollupBasedOn( rollupBasedOn: Option[String]) 	={
		 this.rollupBasedOn = rollupBasedOn
		 this.keyModified("rollup_based_on") = 1
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