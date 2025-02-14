package com.zoho.crm.api.sendmail

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class InventoryDetails extends Model	{
	private var inventoryTemplate:Option[InventoryTemplate] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getInventoryTemplate() :Option[InventoryTemplate]	={
		return  this.inventoryTemplate
	}

	def setInventoryTemplate( inventoryTemplate: Option[InventoryTemplate]) 	={
		 this.inventoryTemplate = inventoryTemplate
		 this.keyModified("inventory_template") = 1
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