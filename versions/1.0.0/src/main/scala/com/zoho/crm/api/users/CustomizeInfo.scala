package com.zoho.crm.api.users

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class CustomizeInfo extends Model	{
	private var notesDesc:Any = None
	private var showRightPanel:Any = None
	private var bcView:Any = None
	private var unpinRecentItem:Any = None
	private var showHome:Option[Boolean] = None
	private var showDetailView:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getNotesDesc() :Any	={
		return  this.notesDesc
	}

	def setNotesDesc( notesDesc: Any) 	={
		 this.notesDesc = notesDesc
		 this.keyModified("notes_desc") = 1
	}

	def getShowRightPanel() :Any	={
		return  this.showRightPanel
	}

	def setShowRightPanel( showRightPanel: Any) 	={
		 this.showRightPanel = showRightPanel
		 this.keyModified("show_right_panel") = 1
	}

	def getBcView() :Any	={
		return  this.bcView
	}

	def setBcView( bcView: Any) 	={
		 this.bcView = bcView
		 this.keyModified("bc_view") = 1
	}

	def getUnpinRecentItem() :Any	={
		return  this.unpinRecentItem
	}

	def setUnpinRecentItem( unpinRecentItem: Any) 	={
		 this.unpinRecentItem = unpinRecentItem
		 this.keyModified("unpin_recent_item") = 1
	}

	def getShowHome() :Option[Boolean]	={
		return  this.showHome
	}

	def setShowHome( showHome: Option[Boolean]) 	={
		 this.showHome = showHome
		 this.keyModified("show_home") = 1
	}

	def getShowDetailView() :Option[Boolean]	={
		return  this.showDetailView
	}

	def setShowDetailView( showDetailView: Option[Boolean]) 	={
		 this.showDetailView = showDetailView
		 this.keyModified("show_detail_view") = 1
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