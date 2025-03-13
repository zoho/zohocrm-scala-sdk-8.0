package com.zoho.crm.api.cadencesexecution

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class AnalyticsAlert extends Model	{
	private var emailCount:Option[Int] = None
	private var clikedEmailCount:Option[Int] = None
	private var bouncedEmailCount:Option[Int] = None
	private var repliedEmailCount:Option[Int] = None
	private var emailSpamCount:Option[Int] = None
	private var sentEmailCount:Option[Int] = None
	private var unsentEmailCount:Option[Int] = None
	private var openedEmailCount:Option[Int] = None
	private var unsubscribedEmailCount:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEmailCount() :Option[Int]	={
		return  this.emailCount
	}

	def setEmailCount( emailCount: Option[Int]) 	={
		 this.emailCount = emailCount
		 this.keyModified("email_count") = 1
	}

	def getClikedEmailCount() :Option[Int]	={
		return  this.clikedEmailCount
	}

	def setClikedEmailCount( clikedEmailCount: Option[Int]) 	={
		 this.clikedEmailCount = clikedEmailCount
		 this.keyModified("cliked_email_count") = 1
	}

	def getBouncedEmailCount() :Option[Int]	={
		return  this.bouncedEmailCount
	}

	def setBouncedEmailCount( bouncedEmailCount: Option[Int]) 	={
		 this.bouncedEmailCount = bouncedEmailCount
		 this.keyModified("bounced_email_count") = 1
	}

	def getRepliedEmailCount() :Option[Int]	={
		return  this.repliedEmailCount
	}

	def setRepliedEmailCount( repliedEmailCount: Option[Int]) 	={
		 this.repliedEmailCount = repliedEmailCount
		 this.keyModified("replied_email_count") = 1
	}

	def getEmailSpamCount() :Option[Int]	={
		return  this.emailSpamCount
	}

	def setEmailSpamCount( emailSpamCount: Option[Int]) 	={
		 this.emailSpamCount = emailSpamCount
		 this.keyModified("email_spam_count") = 1
	}

	def getSentEmailCount() :Option[Int]	={
		return  this.sentEmailCount
	}

	def setSentEmailCount( sentEmailCount: Option[Int]) 	={
		 this.sentEmailCount = sentEmailCount
		 this.keyModified("sent_email_count") = 1
	}

	def getUnsentEmailCount() :Option[Int]	={
		return  this.unsentEmailCount
	}

	def setUnsentEmailCount( unsentEmailCount: Option[Int]) 	={
		 this.unsentEmailCount = unsentEmailCount
		 this.keyModified("unsent_email_count") = 1
	}

	def getOpenedEmailCount() :Option[Int]	={
		return  this.openedEmailCount
	}

	def setOpenedEmailCount( openedEmailCount: Option[Int]) 	={
		 this.openedEmailCount = openedEmailCount
		 this.keyModified("opened_email_count") = 1
	}

	def getUnsubscribedEmailCount() :Option[Int]	={
		return  this.unsubscribedEmailCount
	}

	def setUnsubscribedEmailCount( unsubscribedEmailCount: Option[Int]) 	={
		 this.unsubscribedEmailCount = unsubscribedEmailCount
		 this.keyModified("unsubscribed_email_count") = 1
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