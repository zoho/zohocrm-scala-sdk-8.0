package com.zoho.crm.api.emailtemplates

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class LastVersionStatistics extends Model	{
	private var tracked:Option[Int] = None
	private var delivered:Option[Int] = None
	private var opened:Option[Int] = None
	private var bounced:Option[Int] = None
	private var sent:Option[Int] = None
	private var clicked:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTracked() :Option[Int]	={
		return  this.tracked
	}

	def setTracked( tracked: Option[Int]) 	={
		 this.tracked = tracked
		 this.keyModified("tracked") = 1
	}

	def getDelivered() :Option[Int]	={
		return  this.delivered
	}

	def setDelivered( delivered: Option[Int]) 	={
		 this.delivered = delivered
		 this.keyModified("delivered") = 1
	}

	def getOpened() :Option[Int]	={
		return  this.opened
	}

	def setOpened( opened: Option[Int]) 	={
		 this.opened = opened
		 this.keyModified("opened") = 1
	}

	def getBounced() :Option[Int]	={
		return  this.bounced
	}

	def setBounced( bounced: Option[Int]) 	={
		 this.bounced = bounced
		 this.keyModified("bounced") = 1
	}

	def getSent() :Option[Int]	={
		return  this.sent
	}

	def setSent( sent: Option[Int]) 	={
		 this.sent = sent
		 this.keyModified("sent") = 1
	}

	def getClicked() :Option[Int]	={
		return  this.clicked
	}

	def setClicked( clicked: Option[Int]) 	={
		 this.clicked = clicked
		 this.keyModified("clicked") = 1
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