package com.zoho.crm.api.dealcontactroles

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Info extends Model	{
	private var count:Option[Int] = None
	private var page:Option[Int] = None
	private var perPage:Option[Int] = None
	private var moreRecords:Option[Boolean] = None
	private var previousPageToken:Option[String] = None
	private var pageTokenExpiry:Option[String] = None
	private var nextPageToken:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCount() :Option[Int]	={
		return  this.count
	}

	def setCount( count: Option[Int]) 	={
		 this.count = count
		 this.keyModified("count") = 1
	}

	def getPage() :Option[Int]	={
		return  this.page
	}

	def setPage( page: Option[Int]) 	={
		 this.page = page
		 this.keyModified("page") = 1
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

	def getPreviousPageToken() :Option[String]	={
		return  this.previousPageToken
	}

	def setPreviousPageToken( previousPageToken: Option[String]) 	={
		 this.previousPageToken = previousPageToken
		 this.keyModified("previous_page_token") = 1
	}

	def getPageTokenExpiry() :Option[String]	={
		return  this.pageTokenExpiry
	}

	def setPageTokenExpiry( pageTokenExpiry: Option[String]) 	={
		 this.pageTokenExpiry = pageTokenExpiry
		 this.keyModified("page_token_expiry") = 1
	}

	def getNextPageToken() :Option[String]	={
		return  this.nextPageToken
	}

	def setNextPageToken( nextPageToken: Option[String]) 	={
		 this.nextPageToken = nextPageToken
		 this.keyModified("next_page_token") = 1
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