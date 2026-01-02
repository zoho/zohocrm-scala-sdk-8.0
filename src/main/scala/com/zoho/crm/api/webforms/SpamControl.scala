package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class SpamControl extends Model	{
	private var status:Option[String] = None
	private var excludeScore:Option[String] = None
	private var spamPossibilityThreshold:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getExcludeScore() :Option[String]	={
		return  this.excludeScore
	}

	def setExcludeScore( excludeScore: Option[String]) 	={
		 this.excludeScore = excludeScore
		 this.keyModified("exclude_score") = 1
	}

	def getSpamPossibilityThreshold() :Option[Int]	={
		return  this.spamPossibilityThreshold
	}

	def setSpamPossibilityThreshold( spamPossibilityThreshold: Option[Int]) 	={
		 this.spamPossibilityThreshold = spamPossibilityThreshold
		 this.keyModified("spam_possibility_threshold") = 1
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