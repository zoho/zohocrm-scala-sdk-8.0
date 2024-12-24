package com.zoho.crm.api.coql

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ParseErrorDetails extends Model with DetailsWrapper	{
	private var line:Option[Int] = None
	private var column:Option[Int] = None
	private var near:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLine() :Option[Int]	={
		return  this.line
	}

	def setLine( line: Option[Int]) 	={
		 this.line = line
		 this.keyModified("line") = 1
	}

	def getColumn() :Option[Int]	={
		return  this.column
	}

	def setColumn( column: Option[Int]) 	={
		 this.column = column
		 this.keyModified("column") = 1
	}

	def getNear() :Option[String]	={
		return  this.near
	}

	def setNear( near: Option[String]) 	={
		 this.near = near
		 this.keyModified("near") = 1
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