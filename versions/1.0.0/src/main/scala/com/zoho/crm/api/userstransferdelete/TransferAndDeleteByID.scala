package com.zoho.crm.api.userstransferdelete

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class TransferAndDeleteByID extends Model	{
	private var transfer:Option[Transfer] = None
	private var moveSubordinate:Option[MoveSubordinate] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTransfer() :Option[Transfer]	={
		return  this.transfer
	}

	def setTransfer( transfer: Option[Transfer]) 	={
		 this.transfer = transfer
		 this.keyModified("transfer") = 1
	}

	def getMoveSubordinate() :Option[MoveSubordinate]	={
		return  this.moveSubordinate
	}

	def setMoveSubordinate( moveSubordinate: Option[MoveSubordinate]) 	={
		 this.moveSubordinate = moveSubordinate
		 this.keyModified("move_subordinate") = 1
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