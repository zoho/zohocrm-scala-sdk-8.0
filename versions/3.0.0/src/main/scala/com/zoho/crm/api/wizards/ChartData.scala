package com.zoho.crm.api.wizards

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class ChartData extends Model	{
	private var nodes:ArrayBuffer[Node] = _
	private var connections:ArrayBuffer[Connection] = _
	private var colorPalette:Option[ButtonBackground] = None
	private var canvasWidth:Option[Int] = None
	private var canvasHeight:Option[Int] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getNodes() :ArrayBuffer[Node]	={
		return  this.nodes
	}

	def setNodes( nodes: ArrayBuffer[Node]) 	={
		 this.nodes = nodes
		 this.keyModified("nodes") = 1
	}

	def getConnections() :ArrayBuffer[Connection]	={
		return  this.connections
	}

	def setConnections( connections: ArrayBuffer[Connection]) 	={
		 this.connections = connections
		 this.keyModified("connections") = 1
	}

	def getColorPalette() :Option[ButtonBackground]	={
		return  this.colorPalette
	}

	def setColorPalette( colorPalette: Option[ButtonBackground]) 	={
		 this.colorPalette = colorPalette
		 this.keyModified("color_palette") = 1
	}

	def getCanvasWidth() :Option[Int]	={
		return  this.canvasWidth
	}

	def setCanvasWidth( canvasWidth: Option[Int]) 	={
		 this.canvasWidth = canvasWidth
		 this.keyModified("canvas_width") = 1
	}

	def getCanvasHeight() :Option[Int]	={
		return  this.canvasHeight
	}

	def setCanvasHeight( canvasHeight: Option[Int]) 	={
		 this.canvasHeight = canvasHeight
		 this.keyModified("canvas_height") = 1
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