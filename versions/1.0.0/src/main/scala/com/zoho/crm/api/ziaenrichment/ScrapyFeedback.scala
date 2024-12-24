package com.zoho.crm.api.ziaenrichment

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ScrapyFeedback extends Model	{
	private var enrichId:Choice[String] = _
	private var type1:Choice[String] = _
	private var feedback:Choice[String] = _
	private var comment:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEnrichId() :Choice[String]	={
		return  this.enrichId
	}

	def setEnrichId( enrichId: Choice[String]) 	={
		 this.enrichId = enrichId
		 this.keyModified("enrich_id") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getFeedback() :Choice[String]	={
		return  this.feedback
	}

	def setFeedback( feedback: Choice[String]) 	={
		 this.feedback = feedback
		 this.keyModified("feedback") = 1
	}

	def getComment() :Option[String]	={
		return  this.comment
	}

	def setComment( comment: Option[String]) 	={
		 this.comment = comment
		 this.keyModified("comment") = 1
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