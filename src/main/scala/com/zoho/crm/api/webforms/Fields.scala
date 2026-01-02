package com.zoho.crm.api.webforms

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap

class Fields extends Model	{
	private var layout:Option[Layout] = None
	private var help:Option[String] = None
	private var field:Option[Fields] = None
	private var hidden:Option[Boolean] = None
	private var advanced:Option[Boolean] = None
	private var module:Option[Module] = None
	private var dateFormat:Option[String] = None
	private var required:Option[Boolean] = None
	private var properties:Any = None
	private var fieldName:Option[String] = None
	private var apiName:Option[String] = None
	private var fieldLabel:Option[String] = None
	private var id:Option[String] = None
	private var secretKey:Option[String] = None
	private var recaptchaLabel:Option[String] = None
	private var siteKey:Option[String] = None
	private var theme:Option[String] = None
	private var defaultValue:Any = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getLayout() :Option[Layout]	={
		return  this.layout
	}

	def setLayout( layout: Option[Layout]) 	={
		 this.layout = layout
		 this.keyModified("layout") = 1
	}

	def getHelp() :Option[String]	={
		return  this.help
	}

	def setHelp( help: Option[String]) 	={
		 this.help = help
		 this.keyModified("help") = 1
	}

	def getField() :Option[Fields]	={
		return  this.field
	}

	def setField( field: Option[Fields]) 	={
		 this.field = field
		 this.keyModified("field") = 1
	}

	def getHidden() :Option[Boolean]	={
		return  this.hidden
	}

	def setHidden( hidden: Option[Boolean]) 	={
		 this.hidden = hidden
		 this.keyModified("hidden") = 1
	}

	def getAdvanced() :Option[Boolean]	={
		return  this.advanced
	}

	def setAdvanced( advanced: Option[Boolean]) 	={
		 this.advanced = advanced
		 this.keyModified("advanced") = 1
	}

	def getModule() :Option[Module]	={
		return  this.module
	}

	def setModule( module: Option[Module]) 	={
		 this.module = module
		 this.keyModified("module") = 1
	}

	def getDateFormat() :Option[String]	={
		return  this.dateFormat
	}

	def setDateFormat( dateFormat: Option[String]) 	={
		 this.dateFormat = dateFormat
		 this.keyModified("date_format") = 1
	}

	def getRequired() :Option[Boolean]	={
		return  this.required
	}

	def setRequired( required: Option[Boolean]) 	={
		 this.required = required
		 this.keyModified("required") = 1
	}

	def getProperties() :Any	={
		return  this.properties
	}

	def setProperties( properties: Any) 	={
		 this.properties = properties
		 this.keyModified("properties") = 1
	}

	def getFieldName() :Option[String]	={
		return  this.fieldName
	}

	def setFieldName( fieldName: Option[String]) 	={
		 this.fieldName = fieldName
		 this.keyModified("field_name") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getFieldLabel() :Option[String]	={
		return  this.fieldLabel
	}

	def setFieldLabel( fieldLabel: Option[String]) 	={
		 this.fieldLabel = fieldLabel
		 this.keyModified("field_label") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getSecretKey() :Option[String]	={
		return  this.secretKey
	}

	def setSecretKey( secretKey: Option[String]) 	={
		 this.secretKey = secretKey
		 this.keyModified("secret_key") = 1
	}

	def getRecaptchaLabel() :Option[String]	={
		return  this.recaptchaLabel
	}

	def setRecaptchaLabel( recaptchaLabel: Option[String]) 	={
		 this.recaptchaLabel = recaptchaLabel
		 this.keyModified("recaptcha_label") = 1
	}

	def getSiteKey() :Option[String]	={
		return  this.siteKey
	}

	def setSiteKey( siteKey: Option[String]) 	={
		 this.siteKey = siteKey
		 this.keyModified("site_key") = 1
	}

	def getTheme() :Option[String]	={
		return  this.theme
	}

	def setTheme( theme: Option[String]) 	={
		 this.theme = theme
		 this.keyModified("theme") = 1
	}

	def getDefaultValue() :Any	={
		return  this.defaultValue
	}

	def setDefaultValue( defaultValue: Any) 	={
		 this.defaultValue = defaultValue
		 this.keyModified("default_value") = 1
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