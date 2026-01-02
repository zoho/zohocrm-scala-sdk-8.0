package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class SourcesCount extends Model	{
	private var territories:Option[Int] = None
	private var roles:Option[Int] = None
	private var groups:Option[Int] = None
	private var users:Option[Users] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTerritories() :Option[Int]	={
		return  this.territories
	}

	def setTerritories( territories: Option[Int]) 	={
		 this.territories = territories
		 this.keyModified("territories") = 1
	}

	def getRoles() :Option[Int]	={
		return  this.roles
	}

	def setRoles( roles: Option[Int]) 	={
		 this.roles = roles
		 this.keyModified("roles") = 1
	}

	def getGroups() :Option[Int]	={
		return  this.groups
	}

	def setGroups( groups: Option[Int]) 	={
		 this.groups = groups
		 this.keyModified("groups") = 1
	}

	def getUsers() :Option[Users]	={
		return  this.users
	}

	def setUsers( users: Option[Users]) 	={
		 this.users = users
		 this.keyModified("users") = 1
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