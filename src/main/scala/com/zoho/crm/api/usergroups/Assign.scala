package com.zoho.crm.api.usergroups

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Assign extends Model	{
	private var feature:Choice[String] = _
	private var relatedEntityId:Option[Long] = None
	private var page:Option[Int] = None
	private var perPage:Option[Int] = None
	private var id:Option[Long] = None
	private var filters:Option[Criteria] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getFeature() :Choice[String]	={
		return  this.feature
	}

	def setFeature( feature: Choice[String]) 	={
		 this.feature = feature
		 this.keyModified("feature") = 1
	}

	def getRelatedEntityId() :Option[Long]	={
		return  this.relatedEntityId
	}

	def setRelatedEntityId( relatedEntityId: Option[Long]) 	={
		 this.relatedEntityId = relatedEntityId
		 this.keyModified("related_entity_id") = 1
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

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getFilters() :Option[Criteria]	={
		return  this.filters
	}

	def setFilters( filters: Option[Criteria]) 	={
		 this.filters = filters
		 this.keyModified("filters") = 1
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