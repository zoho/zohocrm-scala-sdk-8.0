package com.zoho.crm.api.fieldmapdependency

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class MapDependency extends Model	{
	private var parent:Option[Parent] = None
	private var child:Option[Child] = None
	private var pickListValues:ArrayBuffer[PickListMapping] = _
	private var internal:Option[Boolean] = None
	private var active:Option[Boolean] = None
	private var id:Option[Long] = None
	private var source:Option[Int] = None
	private var category:Option[Int] = None
	private var subModule:Option[SubModule] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getParent() :Option[Parent]	={
		return  this.parent
	}

	def setParent( parent: Option[Parent]) 	={
		 this.parent = parent
		 this.keyModified("parent") = 1
	}

	def getChild() :Option[Child]	={
		return  this.child
	}

	def setChild( child: Option[Child]) 	={
		 this.child = child
		 this.keyModified("child") = 1
	}

	def getPickListValues() :ArrayBuffer[PickListMapping]	={
		return  this.pickListValues
	}

	def setPickListValues( pickListValues: ArrayBuffer[PickListMapping]) 	={
		 this.pickListValues = pickListValues
		 this.keyModified("pick_list_values") = 1
	}

	def getInternal() :Option[Boolean]	={
		return  this.internal
	}

	def setInternal( internal: Option[Boolean]) 	={
		 this.internal = internal
		 this.keyModified("internal") = 1
	}

	def getActive() :Option[Boolean]	={
		return  this.active
	}

	def setActive( active: Option[Boolean]) 	={
		 this.active = active
		 this.keyModified("active") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getSource() :Option[Int]	={
		return  this.source
	}

	def setSource( source: Option[Int]) 	={
		 this.source = source
		 this.keyModified("source") = 1
	}

	def getCategory() :Option[Int]	={
		return  this.category
	}

	def setCategory( category: Option[Int]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	def getSubModule() :Option[SubModule]	={
		return  this.subModule
	}

	def setSubModule( subModule: Option[SubModule]) 	={
		 this.subModule = subModule
		 this.keyModified("sub_module") = 1
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