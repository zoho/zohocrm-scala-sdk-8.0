package com.zoho.crm.api.emailrelatedrecords

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Info extends Model	{
	private var count:Option[Int] = None
	private var nextIndex:Option[String] = None
	private var prevIndex:Option[String] = None
	private var perPage:Option[Int] = None
	private var moreRecords:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCount() :Option[Int]	={
		return  this.count
	}

	def setCount( count: Option[Int]) 	={
		 this.count = count
		 this.keyModified("count") = 1
	}

	def getNextIndex() :Option[String]	={
		return  this.nextIndex
	}

	def setNextIndex( nextIndex: Option[String]) 	={
		 this.nextIndex = nextIndex
		 this.keyModified("next_index") = 1
	}

	def getPrevIndex() :Option[String]	={
		return  this.prevIndex
	}

	def setPrevIndex( prevIndex: Option[String]) 	={
		 this.prevIndex = prevIndex
		 this.keyModified("prev_index") = 1
	}

	def getPerPage() :Option[Int]	={
		return  this.perPage
	}

	def setPerPage( perPage: Option[Int]) 	={
		 this.perPage = perPage
		 this.keyModified("per_page") = 1
	}

	def getMoreRecords() :Option[Boolean]	={
		return  this.moreRecords
	}

	def setMoreRecords( moreRecords: Option[Boolean]) 	={
		 this.moreRecords = moreRecords
		 this.keyModified("more_records") = 1
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