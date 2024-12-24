package com.zoho.crm.api.blueprint

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Crypt extends Model	{
	private var mode:Option[String] = None
	private var column:Option[String] = None
	private var table:Option[String] = None
	private var status:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getMode() :Option[String]	={
		return  this.mode
	}

	def setMode( mode: Option[String]) 	={
		 this.mode = mode
		 this.keyModified("mode") = 1
	}

	def getColumn() :Option[String]	={
		return  this.column
	}

	def setColumn( column: Option[String]) 	={
		 this.column = column
		 this.keyModified("column") = 1
	}

	def getTable() :Option[String]	={
		return  this.table
	}

	def setTable( table: Option[String]) 	={
		 this.table = table
		 this.keyModified("table") = 1
	}

	def getStatus() :Option[Int]	={
		return  this.status
	}

	def setStatus( status: Option[Int]) 	={
		 this.status = status
		 this.keyModified("status") = 1
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