package com.zoho.crm.api.getrelatedrecordscount

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Params extends Model	{
	private var approved:Option[Boolean] = None
	private var converted:Option[Boolean] = None
	private var associated:Option[Boolean] = None
	private var category:Choice[String] = _
	private var approvalState:Choice[String] = _
	private var filters:Option[Filters] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getApproved() :Option[Boolean]	={
		return  this.approved
	}

	def setApproved( approved: Option[Boolean]) 	={
		 this.approved = approved
		 this.keyModified("approved") = 1
	}

	def getConverted() :Option[Boolean]	={
		return  this.converted
	}

	def setConverted( converted: Option[Boolean]) 	={
		 this.converted = converted
		 this.keyModified("converted") = 1
	}

	def getAssociated() :Option[Boolean]	={
		return  this.associated
	}

	def setAssociated( associated: Option[Boolean]) 	={
		 this.associated = associated
		 this.keyModified("associated") = 1
	}

	def getCategory() :Choice[String]	={
		return  this.category
	}

	def setCategory( category: Choice[String]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	def getApprovalState() :Choice[String]	={
		return  this.approvalState
	}

	def setApprovalState( approvalState: Choice[String]) 	={
		 this.approvalState = approvalState
		 this.keyModified("approval_state") = 1
	}

	def getFilters() :Option[Filters]	={
		return  this.filters
	}

	def setFilters( filters: Option[Filters]) 	={
		 this.filters = filters
		 this.keyModified("filters") = 1
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