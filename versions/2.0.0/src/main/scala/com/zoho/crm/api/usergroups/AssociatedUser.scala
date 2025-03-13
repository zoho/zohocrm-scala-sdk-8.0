package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AssociatedUser extends Model	{
	private var userGroup:Option[UserGroup] = None
	private var count:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getUserGroup() :Option[UserGroup]	={
		return  this.userGroup
	}

	def setUserGroup( userGroup: Option[UserGroup]) 	={
		 this.userGroup = userGroup
		 this.keyModified("user_group") = 1
	}

	def getCount() :Option[Int]	={
		return  this.count
	}

	def setCount( count: Option[Int]) 	={
		 this.count = count
		 this.keyModified("count") = 1
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