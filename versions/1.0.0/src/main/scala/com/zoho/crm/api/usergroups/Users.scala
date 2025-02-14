package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Users extends Model	{
	private var inactive:Option[Int] = None
	private var deleted:Option[Int] = None
	private var active:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getInactive() :Option[Int]	={
		return  this.inactive
	}

	def setInactive( inactive: Option[Int]) 	={
		 this.inactive = inactive
		 this.keyModified("inactive") = 1
	}

	def getDeleted() :Option[Int]	={
		return  this.deleted
	}

	def setDeleted( deleted: Option[Int]) 	={
		 this.deleted = deleted
		 this.keyModified("deleted") = 1
	}

	def getActive() :Option[Int]	={
		return  this.active
	}

	def setActive( active: Option[Int]) 	={
		 this.active = active
		 this.keyModified("active") = 1
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