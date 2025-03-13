package com.zoho.crm.api.reschedulehistory

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Approval extends Model	{
	private var delegate:Option[Boolean] = None
	private var approve:Option[Boolean] = None
	private var reject:Option[Boolean] = None
	private var resubmit:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDelegate() :Option[Boolean]	={
		return  this.delegate
	}

	def setDelegate( delegate: Option[Boolean]) 	={
		 this.delegate = delegate
		 this.keyModified("delegate") = 1
	}

	def getApprove() :Option[Boolean]	={
		return  this.approve
	}

	def setApprove( approve: Option[Boolean]) 	={
		 this.approve = approve
		 this.keyModified("approve") = 1
	}

	def getReject() :Option[Boolean]	={
		return  this.reject
	}

	def setReject( reject: Option[Boolean]) 	={
		 this.reject = reject
		 this.keyModified("reject") = 1
	}

	def getResubmit() :Option[Boolean]	={
		return  this.resubmit
	}

	def setResubmit( resubmit: Option[Boolean]) 	={
		 this.resubmit = resubmit
		 this.keyModified("resubmit") = 1
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