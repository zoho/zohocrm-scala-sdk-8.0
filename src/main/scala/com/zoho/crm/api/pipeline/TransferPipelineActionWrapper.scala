package com.zoho.crm.api.pipeline

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class TransferPipelineActionWrapper extends Model with TransferPipelineActionHandler	{
	private var transferPipeline:ArrayBuffer[TransferPipelineActionResponse] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getTransferPipeline() :ArrayBuffer[TransferPipelineActionResponse]	={
		return  this.transferPipeline
	}

	def setTransferPipeline( transferPipeline: ArrayBuffer[TransferPipelineActionResponse]) 	={
		 this.transferPipeline = transferPipeline
		 this.keyModified("transfer_pipeline") = 1
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