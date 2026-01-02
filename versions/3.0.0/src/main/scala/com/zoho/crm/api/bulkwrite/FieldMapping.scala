package com.zoho.crm.api.bulkwrite

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class FieldMapping extends Model	{
	private var apiName:Option[String] = None
	private var index:Option[Int] = None
	private var format:Option[String] = None
	private var findBy:Option[String] = None
	private var defaultValue:Option[DefaultValue] = None
	private var module:Option[String] = None
	private var parentColumnIndex:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getIndex() :Option[Int]	={
		return  this.index
	}

	def setIndex( index: Option[Int]) 	={
		 this.index = index
		 this.keyModified("index") = 1
	}

	def getFormat() :Option[String]	={
		return  this.format
	}

	def setFormat( format: Option[String]) 	={
		 this.format = format
		 this.keyModified("format") = 1
	}

	def getFindBy() :Option[String]	={
		return  this.findBy
	}

	def setFindBy( findBy: Option[String]) 	={
		 this.findBy = findBy
		 this.keyModified("find_by") = 1
	}

	def getDefaultValue() :Option[DefaultValue]	={
		return  this.defaultValue
	}

	def setDefaultValue( defaultValue: Option[DefaultValue]) 	={
		 this.defaultValue = defaultValue
		 this.keyModified("default_value") = 1
	}

	def getModule() :Option[String]	={
		return  this.module
	}

	def setModule( module: Option[String]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getParentColumnIndex() :Option[Int]	={
		return  this.parentColumnIndex
	}

	def setParentColumnIndex( parentColumnIndex: Option[Int]) 	={
		 this.parentColumnIndex = parentColumnIndex
		 this.keyModified("parent_column_index") = 1
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