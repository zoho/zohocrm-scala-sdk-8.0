package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Button extends Model	{
	private var id:Option[Long] = None
	private var sequenceNumber:Option[Int] = None
	private var displayLabel:Option[String] = None
	private var criteria:Option[Criteria] = None
	private var targetScreen:Option[Screen] = None
	private var type1:Option[String] = None
	private var message:Option[Message] = None
	private var color:Option[String] = None
	private var shape:Option[String] = None
	private var backgroundColor:Option[String] = None
	private var visibility:Option[String] = None
	private var resource:Any = None
	private var transition:Option[Transition] = None
	private var category:Option[String] = None
	private var referenceId:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getCriteria() :Option[Criteria]	={
		return  this.criteria
	}

	def setCriteria( criteria: Option[Criteria]) 	={
		 this.criteria = criteria
		 this.keyModified("criteria") = 1
	}

	def getTargetScreen() :Option[Screen]	={
		return  this.targetScreen
	}

	def setTargetScreen( targetScreen: Option[Screen]) 	={
		 this.targetScreen = targetScreen
		 this.keyModified("target_screen") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getMessage() :Option[Message]	={
		return  this.message
	}

	def setMessage( message: Option[Message]) 	={
		 this.message = message
		 this.keyModified("message") = 1
	}

	def getColor() :Option[String]	={
		return  this.color
	}

	def setColor( color: Option[String]) 	={
		 this.color = color
		 this.keyModified("color") = 1
	}

	def getShape() :Option[String]	={
		return  this.shape
	}

	def setShape( shape: Option[String]) 	={
		 this.shape = shape
		 this.keyModified("shape") = 1
	}

	def getBackgroundColor() :Option[String]	={
		return  this.backgroundColor
	}

	def setBackgroundColor( backgroundColor: Option[String]) 	={
		 this.backgroundColor = backgroundColor
		 this.keyModified("background_color") = 1
	}

	def getVisibility() :Option[String]	={
		return  this.visibility
	}

	def setVisibility( visibility: Option[String]) 	={
		 this.visibility = visibility
		 this.keyModified("visibility") = 1
	}

	def getResource() :Any	={
		return  this.resource
	}

	def setResource( resource: Any) 	={
		 this.resource = resource
		 this.keyModified("resource") = 1
	}

	def getTransition() :Option[Transition]	={
		return  this.transition
	}

	def setTransition( transition: Option[Transition]) 	={
		 this.transition = transition
		 this.keyModified("transition") = 1
	}

	def getCategory() :Option[String]	={
		return  this.category
	}

	def setCategory( category: Option[String]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	def getReferenceId() :Option[String]	={
		return  this.referenceId
	}

	def setReferenceId( referenceId: Option[String]) 	={
		 this.referenceId = referenceId
		 this.keyModified("reference_id") = 1
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