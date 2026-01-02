package com.zoho.crm.api.shifthours

import com.zoho.crm.api.util.Model
import java.time.LocalDate
import scala.collection.mutable.HashMap

class Users extends Model	{
	private var role:Option[Role] = None
	private var name:Option[String] = None
	private var id:Option[Long] = None
	private var email:Option[String] = None
	private var zuid:Option[String] = None
	private var effectiveFrom:Option[LocalDate] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRole() :Option[Role]	={
		return  this.role
	}

	def setRole( role: Option[Role]) 	={
		 this.role = role
		 this.keyModified("role") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getEmail() :Option[String]	={
		return  this.email
	}

	def setEmail( email: Option[String]) 	={
		 this.email = email
		 this.keyModified("email") = 1
	}

	def getZuid() :Option[String]	={
		return  this.zuid
	}

	def setZuid( zuid: Option[String]) 	={
		 this.zuid = zuid
		 this.keyModified("zuid") = 1
	}

	def getEffectiveFrom() :Option[LocalDate]	={
		return  this.effectiveFrom
	}

	def setEffectiveFrom( effectiveFrom: Option[LocalDate]) 	={
		 this.effectiveFrom = effectiveFrom
		 this.keyModified("effective_from") = 1
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