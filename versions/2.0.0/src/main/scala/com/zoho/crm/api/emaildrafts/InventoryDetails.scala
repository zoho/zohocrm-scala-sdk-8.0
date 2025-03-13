package com.zoho.crm.api.emaildrafts

import com.zoho.crm.api.record.Record
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class InventoryDetails extends Model	{
	private var inventoryTemplate:Option[InventoryTemplate] = None
	private var record:Option[Record] = None
	private var paperType:Option[String] = None
	private var viewType:Option[String] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getInventoryTemplate() :Option[InventoryTemplate]	={
		return  this.inventoryTemplate
	}

	def setInventoryTemplate( inventoryTemplate: Option[InventoryTemplate]) 	={
		 this.inventoryTemplate = inventoryTemplate
		 this.keyModified("inventory_template") = 1
	}

	def getRecord() :Option[Record]	={
		return  this.record
	}

	def setRecord( record: Option[Record]) 	={
		 this.record = record
		 this.keyModified("record") = 1
	}

	def getPaperType() :Option[String]	={
		return  this.paperType
	}

	def setPaperType( paperType: Option[String]) 	={
		 this.paperType = paperType
		 this.keyModified("paper_type") = 1
	}

	def getViewType() :Option[String]	={
		return  this.viewType
	}

	def setViewType( viewType: Option[String]) 	={
		 this.viewType = viewType
		 this.keyModified("view_type") = 1
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