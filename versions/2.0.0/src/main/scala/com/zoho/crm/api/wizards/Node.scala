package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Node extends Model	{
	private var posY:Option[Int] = None
	private var posX:Option[Int] = None
	private var startNode:Option[Boolean] = None
	private var screen:Option[Screen] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPosY() :Option[Int]	={
		return  this.posY
	}

	def setPosY( posY: Option[Int]) 	={
		 this.posY = posY
		 this.keyModified("pos_y") = 1
	}

	def getPosX() :Option[Int]	={
		return  this.posX
	}

	def setPosX( posX: Option[Int]) 	={
		 this.posX = posX
		 this.keyModified("pos_x") = 1
	}

	def getStartNode() :Option[Boolean]	={
		return  this.startNode
	}

	def setStartNode( startNode: Option[Boolean]) 	={
		 this.startNode = startNode
		 this.keyModified("start_node") = 1
	}

	def getScreen() :Option[Screen]	={
		return  this.screen
	}

	def setScreen( screen: Option[Screen]) 	={
		 this.screen = screen
		 this.keyModified("screen") = 1
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