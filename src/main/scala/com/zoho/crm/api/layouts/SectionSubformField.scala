package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class SectionSubformField extends Model	{
	private var module:Option[String] = None
	private var id:Option[String] = None
	private var layout:Option[MinifiedLayout] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getLayout() :Option[MinifiedLayout]	={
		return  this.layout
	}

	def setLayout( layout: Option[MinifiedLayout]) 	={
		 this.layout = layout
		 this.keyModified("layout") = 1
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