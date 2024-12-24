package com.zoho.crm.api.entityscores

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class EntityScores extends Model	{
	private var entity:Option[Entity] = None
	private var positiveScore:Option[Int] = None
	private var touchPointScore:Option[Int] = None
	private var score:Option[Int] = None
	private var negativeScore:Option[Int] = None
	private var touchPointNegativeScore:Option[Int] = None
	private var scoringRule:Option[ScoringRule] = None
	private var fieldStates:ArrayBuffer[String] = _
	private var id:Option[Long] = None
	private var ziaVisions:Option[Boolean] = None
	private var touchPointPositiveScore:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getEntity() :Option[Entity]	={
		return  this.entity
	}

	def setEntity( entity: Option[Entity]) 	={
		 this.entity = entity
		 this.keyModified("Entity") = 1
	}

	def getPositiveScore() :Option[Int]	={
		return  this.positiveScore
	}

	def setPositiveScore( positiveScore: Option[Int]) 	={
		 this.positiveScore = positiveScore
		 this.keyModified("Positive_Score") = 1
	}

	def getTouchPointScore() :Option[Int]	={
		return  this.touchPointScore
	}

	def setTouchPointScore( touchPointScore: Option[Int]) 	={
		 this.touchPointScore = touchPointScore
		 this.keyModified("Touch_Point_Score") = 1
	}

	def getScore() :Option[Int]	={
		return  this.score
	}

	def setScore( score: Option[Int]) 	={
		 this.score = score
		 this.keyModified("Score") = 1
	}

	def getNegativeScore() :Option[Int]	={
		return  this.negativeScore
	}

	def setNegativeScore( negativeScore: Option[Int]) 	={
		 this.negativeScore = negativeScore
		 this.keyModified("Negative_Score") = 1
	}

	def getTouchPointNegativeScore() :Option[Int]	={
		return  this.touchPointNegativeScore
	}

	def setTouchPointNegativeScore( touchPointNegativeScore: Option[Int]) 	={
		 this.touchPointNegativeScore = touchPointNegativeScore
		 this.keyModified("Touch_Point_Negative_Score") = 1
	}

	def getScoringRule() :Option[ScoringRule]	={
		return  this.scoringRule
	}

	def setScoringRule( scoringRule: Option[ScoringRule]) 	={
		 this.scoringRule = scoringRule
		 this.keyModified("Scoring_Rule") = 1
	}

	def getfieldStates() :ArrayBuffer[String]	={
		return  this.fieldStates
	}

	def setfieldStates( fieldStates: ArrayBuffer[String]) 	={
		 this.fieldStates = fieldStates
		 this.keyModified("$field_states") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getziaVisions() :Option[Boolean]	={
		return  this.ziaVisions
	}

	def setziaVisions( ziaVisions: Option[Boolean]) 	={
		 this.ziaVisions = ziaVisions
		 this.keyModified("$zia_visions") = 1
	}

	def getTouchPointPositiveScore() :Option[Int]	={
		return  this.touchPointPositiveScore
	}

	def setTouchPointPositiveScore( touchPointPositiveScore: Option[Int]) 	={
		 this.touchPointPositiveScore = touchPointPositiveScore
		 this.keyModified("Touch_Point_Positive_Score") = 1
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