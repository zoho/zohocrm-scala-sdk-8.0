package com.zoho.crm.api.territories

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class TransferTerritory extends Model	{
	private var id:Option[Long] = None
	private var transferToId:Option[Long] = None
	private var deletePreviousForecasts:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getTransferToId() :Option[Long]	={
		return  this.transferToId
	}

	def setTransferToId( transferToId: Option[Long]) 	={
		 this.transferToId = transferToId
		 this.keyModified("transfer_to_id") = 1
	}

	def getDeletePreviousForecasts() :Option[Boolean]	={
		return  this.deletePreviousForecasts
	}

	def setDeletePreviousForecasts( deletePreviousForecasts: Option[Boolean]) 	={
		 this.deletePreviousForecasts = deletePreviousForecasts
		 this.keyModified("delete_previous_forecasts") = 1
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