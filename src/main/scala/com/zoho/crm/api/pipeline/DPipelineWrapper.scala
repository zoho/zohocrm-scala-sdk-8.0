package com.zoho.crm.api.pipeline

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class DPipelineWrapper extends Model	{
	private var pipeline:ArrayBuffer[DPipeline] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getPipeline() :ArrayBuffer[DPipeline]	={
		return  this.pipeline
	}

	def setPipeline( pipeline: ArrayBuffer[DPipeline]) 	={
		 this.pipeline = pipeline
		 this.keyModified("pipeline") = 1
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