package com.zoho.crm.api.ziaenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ScrapyBodyWrapper extends Model	{
	private var scrapyFeedback:Option[ScrapyFeedback] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getScrapyFeedback() :Option[ScrapyFeedback]	={
		return  this.scrapyFeedback
	}

	def setScrapyFeedback( scrapyFeedback: Option[ScrapyFeedback]) 	={
		 this.scrapyFeedback = scrapyFeedback
		 this.keyModified("scrapy_feedback") = 1
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