package com.zoho.crm.api.scoringrules

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class SignalRule extends Model	{
	private var score:Option[Int] = None
	private var signal:Option[Signal] = None
	private var id:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getScore() :Option[Int]	={
		return  this.score
	}

	def setScore( score: Option[Int]) 	={
		 this.score = score
		 this.keyModified("score") = 1
	}

	def getSignal() :Option[Signal]	={
		return  this.signal
	}

	def setSignal( signal: Option[Signal]) 	={
		 this.signal = signal
		 this.keyModified("signal") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
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