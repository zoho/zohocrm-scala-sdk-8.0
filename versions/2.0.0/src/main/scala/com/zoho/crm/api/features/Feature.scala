package com.zoho.crm.api.features

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Feature extends Model	{
	private var apiName:Option[String] = None
	private var parentFeature:Option[Feature] = None
	private var moduleSupported:Option[Boolean] = None
	private var details:Option[Detail] = None
	private var featureLabel:Option[String] = None
	private var components:ArrayBuffer[Component] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getParentFeature() :Option[Feature]	={
		return  this.parentFeature
	}

	def setParentFeature( parentFeature: Option[Feature]) 	={
		 this.parentFeature = parentFeature
		 this.keyModified("parent_feature") = 1
	}

	def getModuleSupported() :Option[Boolean]	={
		return  this.moduleSupported
	}

	def setModuleSupported( moduleSupported: Option[Boolean]) 	={
		 this.moduleSupported = moduleSupported
		 this.keyModified("module_supported") = 1
	}

	def getDetails() :Option[Detail]	={
		return  this.details
	}

	def setDetails( details: Option[Detail]) 	={
		 this.details = details
		 this.keyModified("details") = 1
	}

	def getFeatureLabel() :Option[String]	={
		return  this.featureLabel
	}

	def setFeatureLabel( featureLabel: Option[String]) 	={
		 this.featureLabel = featureLabel
		 this.keyModified("feature_label") = 1
	}

	def getComponents() :ArrayBuffer[Component]	={
		return  this.components
	}

	def setComponents( components: ArrayBuffer[Component]) 	={
		 this.components = components
		 this.keyModified("components") = 1
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