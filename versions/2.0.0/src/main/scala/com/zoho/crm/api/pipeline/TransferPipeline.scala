package com.zoho.crm.api.pipeline

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class TransferPipeline extends Model	{
	private var pipeline:Option[TPipeline] = None
	private var stages:ArrayBuffer[Stages] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPipeline() :Option[TPipeline]	={
		return  this.pipeline
	}

	def setPipeline( pipeline: Option[TPipeline]) 	={
		 this.pipeline = pipeline
		 this.keyModified("pipeline") = 1
	}

	def getStages() :ArrayBuffer[Stages]	={
		return  this.stages
	}

	def setStages( stages: ArrayBuffer[Stages]) 	={
		 this.stages = stages
		 this.keyModified("stages") = 1
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