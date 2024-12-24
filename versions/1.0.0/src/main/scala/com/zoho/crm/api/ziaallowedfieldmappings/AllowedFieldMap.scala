package com.zoho.crm.api.ziaallowedfieldmappings

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class AllowedFieldMap extends Model	{
	private var outputDataFieldMapping:ArrayBuffer[AllowedOutputData] = _
	private var inputDataFieldMapping:ArrayBuffer[AllowedOutputData] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOutputDataFieldMapping() :ArrayBuffer[AllowedOutputData]	={
		return  this.outputDataFieldMapping
	}

	def setOutputDataFieldMapping( outputDataFieldMapping: ArrayBuffer[AllowedOutputData]) 	={
		 this.outputDataFieldMapping = outputDataFieldMapping
		 this.keyModified("output_data_field_mapping") = 1
	}

	def getInputDataFieldMapping() :ArrayBuffer[AllowedOutputData]	={
		return  this.inputDataFieldMapping
	}

	def setInputDataFieldMapping( inputDataFieldMapping: ArrayBuffer[AllowedOutputData]) 	={
		 this.inputDataFieldMapping = inputDataFieldMapping
		 this.keyModified("input_data_field_mapping") = 1
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