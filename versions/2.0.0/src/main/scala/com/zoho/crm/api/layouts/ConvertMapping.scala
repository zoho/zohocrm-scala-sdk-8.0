package com.zoho.crm.api.layouts

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class ConvertMapping extends Model	{
	private var contacts:Option[MinifiedLayout] = None
	private var deals:Option[DealLayoutMapping] = None
	private var accounts:Option[MinifiedLayout] = None
	private var invoices:Option[MinifiedLayout] = None
	private var salesorders:Option[MinifiedLayout] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getContacts() :Option[MinifiedLayout]	={
		return  this.contacts
	}

	def setContacts( contacts: Option[MinifiedLayout]) 	={
		 this.contacts = contacts
		 this.keyModified("Contacts") = 1
	}

	def getDeals() :Option[DealLayoutMapping]	={
		return  this.deals
	}

	def setDeals( deals: Option[DealLayoutMapping]) 	={
		 this.deals = deals
		 this.keyModified("Deals") = 1
	}

	def getAccounts() :Option[MinifiedLayout]	={
		return  this.accounts
	}

	def setAccounts( accounts: Option[MinifiedLayout]) 	={
		 this.accounts = accounts
		 this.keyModified("Accounts") = 1
	}

	def getInvoices() :Option[MinifiedLayout]	={
		return  this.invoices
	}

	def setInvoices( invoices: Option[MinifiedLayout]) 	={
		 this.invoices = invoices
		 this.keyModified("Invoices") = 1
	}

	def getSalesorders() :Option[MinifiedLayout]	={
		return  this.salesorders
	}

	def setSalesorders( salesorders: Option[MinifiedLayout]) 	={
		 this.salesorders = salesorders
		 this.keyModified("SalesOrders") = 1
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