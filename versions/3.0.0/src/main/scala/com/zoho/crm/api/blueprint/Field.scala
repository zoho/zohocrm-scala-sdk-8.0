package com.zoho.crm.api.blueprint

import com.zoho.crm.api.fields.External
import com.zoho.crm.api.fields.MultiModuleLookup
import com.zoho.crm.api.fields.PickListValue
import com.zoho.crm.api.fields.Private
import com.zoho.crm.api.fields.Unique
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Field extends Model	{
	private var external:Option[External] = None
	private var displayType:Choice[Int] = _
	private var filterable:Option[Boolean] = None
	private var pickListValuesSortedLexically:Option[Boolean] = None
	private var sortable:Option[Boolean] = None
	private var uiType:Option[Int] = None
	private var private1:Option[Private] = None
	private var systemMandatory:Option[Boolean] = None
	private var webhook:Option[Boolean] = None
	private var jsonType:Option[String] = None
	private var crypt:Option[Crypt] = None
	private var fieldLabel:Option[String] = None
	private var tooltip:Option[ToolTip] = None
	private var createdSource:Option[String] = None
	private var layouts:Option[Layout] = None
	private var fieldReadOnly:Option[Boolean] = None
	private var content:Option[String] = None
	private var displayLabel:Option[String] = None
	private var validationRule:Any = None
	private var readOnly:Option[Boolean] = None
	private var associationDetails:Option[AssociationDetails] = None
	private var multiModuleLookup:Option[MultiModuleLookup] = None
	private var currency:Option[Currency] = None
	private var id:Option[String] = None
	private var customField:Option[Boolean] = None
	private var lookup:Option[Module] = None
	private var convertMapping:Option[HashMap[String, Any]] = _
	private var visible:Option[Boolean] = None
	private var length:Option[Int] = None
	private var columnName:Option[String] = None
	private var type1:Option[String] = None
	private var viewType:Option[ViewType] = None
	private var transitionSequence:Option[Int] = None
	private var apiName:Option[String] = None
	private var unique:Option[Unique] = None
	private var historyTracking:Option[Boolean] = None
	private var dataType:Option[String] = None
	private var formula:Option[Formula] = None
	private var decimalPlace:Option[String] = None
	private var multiselectlookup:Option[MultiSelectLookup] = None
	private var pickListValues:ArrayBuffer[PickListValue] = _
	private var autoNumber:Option[AutoNumber] = None
	private var personalityName:Option[String] = None
	private var mandatory:Option[Boolean] = None
	private var quickSequenceNumber:Option[Long] = None
	private var profiles:ArrayBuffer[Profile] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getExternal() :Option[External]	={
		return  this.external
	}

	def setExternal( external: Option[External]) 	={
		 this.external = external
		 this.keyModified("external") = 1
	}

	def getDisplayType() :Choice[Int]	={
		return  this.displayType
	}

	def setDisplayType( displayType: Choice[Int]) 	={
		 this.displayType = displayType
		 this.keyModified("display_type") = 1
	}

	def getFilterable() :Option[Boolean]	={
		return  this.filterable
	}

	def setFilterable( filterable: Option[Boolean]) 	={
		 this.filterable = filterable
		 this.keyModified("filterable") = 1
	}

	def getPickListValuesSortedLexically() :Option[Boolean]	={
		return  this.pickListValuesSortedLexically
	}

	def setPickListValuesSortedLexically( pickListValuesSortedLexically: Option[Boolean]) 	={
		 this.pickListValuesSortedLexically = pickListValuesSortedLexically
		 this.keyModified("pick_list_values_sorted_lexically") = 1
	}

	def getSortable() :Option[Boolean]	={
		return  this.sortable
	}

	def setSortable( sortable: Option[Boolean]) 	={
		 this.sortable = sortable
		 this.keyModified("sortable") = 1
	}

	def getUiType() :Option[Int]	={
		return  this.uiType
	}

	def setUiType( uiType: Option[Int]) 	={
		 this.uiType = uiType
		 this.keyModified("ui_type") = 1
	}

	def getPrivate() :Option[Private]	={
		return  this.private1
	}

	def setPrivate( private1: Option[Private]) 	={
		 this.private1 = private1
		 this.keyModified("private") = 1
	}

	def getSystemMandatory() :Option[Boolean]	={
		return  this.systemMandatory
	}

	def setSystemMandatory( systemMandatory: Option[Boolean]) 	={
		 this.systemMandatory = systemMandatory
		 this.keyModified("system_mandatory") = 1
	}

	def getWebhook() :Option[Boolean]	={
		return  this.webhook
	}

	def setWebhook( webhook: Option[Boolean]) 	={
		 this.webhook = webhook
		 this.keyModified("webhook") = 1
	}

	def getJsonType() :Option[String]	={
		return  this.jsonType
	}

	def setJsonType( jsonType: Option[String]) 	={
		 this.jsonType = jsonType
		 this.keyModified("json_type") = 1
	}

	def getCrypt() :Option[Crypt]	={
		return  this.crypt
	}

	def setCrypt( crypt: Option[Crypt]) 	={
		 this.crypt = crypt
		 this.keyModified("crypt") = 1
	}

	def getFieldLabel() :Option[String]	={
		return  this.fieldLabel
	}

	def setFieldLabel( fieldLabel: Option[String]) 	={
		 this.fieldLabel = fieldLabel
		 this.keyModified("field_label") = 1
	}

	def getTooltip() :Option[ToolTip]	={
		return  this.tooltip
	}

	def setTooltip( tooltip: Option[ToolTip]) 	={
		 this.tooltip = tooltip
		 this.keyModified("tooltip") = 1
	}

	def getCreatedSource() :Option[String]	={
		return  this.createdSource
	}

	def setCreatedSource( createdSource: Option[String]) 	={
		 this.createdSource = createdSource
		 this.keyModified("created_source") = 1
	}

	def getLayouts() :Option[Layout]	={
		return  this.layouts
	}

	def setLayouts( layouts: Option[Layout]) 	={
		 this.layouts = layouts
		 this.keyModified("layouts") = 1
	}

	def getFieldReadOnly() :Option[Boolean]	={
		return  this.fieldReadOnly
	}

	def setFieldReadOnly( fieldReadOnly: Option[Boolean]) 	={
		 this.fieldReadOnly = fieldReadOnly
		 this.keyModified("field_read_only") = 1
	}

	def getContent() :Option[String]	={
		return  this.content
	}

	def setContent( content: Option[String]) 	={
		 this.content = content
		 this.keyModified("content") = 1
	}

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getValidationRule() :Any	={
		return  this.validationRule
	}

	def setValidationRule( validationRule: Any) 	={
		 this.validationRule = validationRule
		 this.keyModified("validation_rule") = 1
	}

	def getReadOnly() :Option[Boolean]	={
		return  this.readOnly
	}

	def setReadOnly( readOnly: Option[Boolean]) 	={
		 this.readOnly = readOnly
		 this.keyModified("read_only") = 1
	}

	def getAssociationDetails() :Option[AssociationDetails]	={
		return  this.associationDetails
	}

	def setAssociationDetails( associationDetails: Option[AssociationDetails]) 	={
		 this.associationDetails = associationDetails
		 this.keyModified("association_details") = 1
	}

	def getMultiModuleLookup() :Option[MultiModuleLookup]	={
		return  this.multiModuleLookup
	}

	def setMultiModuleLookup( multiModuleLookup: Option[MultiModuleLookup]) 	={
		 this.multiModuleLookup = multiModuleLookup
		 this.keyModified("multi_module_lookup") = 1
	}

	def getCurrency() :Option[Currency]	={
		return  this.currency
	}

	def setCurrency( currency: Option[Currency]) 	={
		 this.currency = currency
		 this.keyModified("currency") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getCustomField() :Option[Boolean]	={
		return  this.customField
	}

	def setCustomField( customField: Option[Boolean]) 	={
		 this.customField = customField
		 this.keyModified("custom_field") = 1
	}

	def getLookup() :Option[Module]	={
		return  this.lookup
	}

	def setLookup( lookup: Option[Module]) 	={
		 this.lookup = lookup
		 this.keyModified("lookup") = 1
	}

	def getConvertMapping() :Option[HashMap[String, Any]]	={
		return  this.convertMapping
	}

	def setConvertMapping( convertMapping: Option[HashMap[String, Any]]) 	={
		 this.convertMapping = convertMapping
		 this.keyModified("convert_mapping") = 1
	}

	def getVisible() :Option[Boolean]	={
		return  this.visible
	}

	def setVisible( visible: Option[Boolean]) 	={
		 this.visible = visible
		 this.keyModified("visible") = 1
	}

	def getLength() :Option[Int]	={
		return  this.length
	}

	def setLength( length: Option[Int]) 	={
		 this.length = length
		 this.keyModified("length") = 1
	}

	def getColumnName() :Option[String]	={
		return  this.columnName
	}

	def setColumnName( columnName: Option[String]) 	={
		 this.columnName = columnName
		 this.keyModified("column_name") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("_type") = 1
	}

	def getViewType() :Option[ViewType]	={
		return  this.viewType
	}

	def setViewType( viewType: Option[ViewType]) 	={
		 this.viewType = viewType
		 this.keyModified("view_type") = 1
	}

	def getTransitionSequence() :Option[Int]	={
		return  this.transitionSequence
	}

	def setTransitionSequence( transitionSequence: Option[Int]) 	={
		 this.transitionSequence = transitionSequence
		 this.keyModified("transition_sequence") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getUnique() :Option[Unique]	={
		return  this.unique
	}

	def setUnique( unique: Option[Unique]) 	={
		 this.unique = unique
		 this.keyModified("unique") = 1
	}

	def getHistoryTracking() :Option[Boolean]	={
		return  this.historyTracking
	}

	def setHistoryTracking( historyTracking: Option[Boolean]) 	={
		 this.historyTracking = historyTracking
		 this.keyModified("history_tracking") = 1
	}

	def getDataType() :Option[String]	={
		return  this.dataType
	}

	def setDataType( dataType: Option[String]) 	={
		 this.dataType = dataType
		 this.keyModified("data_type") = 1
	}

	def getFormula() :Option[Formula]	={
		return  this.formula
	}

	def setFormula( formula: Option[Formula]) 	={
		 this.formula = formula
		 this.keyModified("formula") = 1
	}

	def getDecimalPlace() :Option[String]	={
		return  this.decimalPlace
	}

	def setDecimalPlace( decimalPlace: Option[String]) 	={
		 this.decimalPlace = decimalPlace
		 this.keyModified("decimal_place") = 1
	}

	def getMultiselectlookup() :Option[MultiSelectLookup]	={
		return  this.multiselectlookup
	}

	def setMultiselectlookup( multiselectlookup: Option[MultiSelectLookup]) 	={
		 this.multiselectlookup = multiselectlookup
		 this.keyModified("multiselectlookup") = 1
	}

	def getPickListValues() :ArrayBuffer[PickListValue]	={
		return  this.pickListValues
	}

	def setPickListValues( pickListValues: ArrayBuffer[PickListValue]) 	={
		 this.pickListValues = pickListValues
		 this.keyModified("pick_list_values") = 1
	}

	def getAutoNumber() :Option[AutoNumber]	={
		return  this.autoNumber
	}

	def setAutoNumber( autoNumber: Option[AutoNumber]) 	={
		 this.autoNumber = autoNumber
		 this.keyModified("auto_number") = 1
	}

	def getPersonalityName() :Option[String]	={
		return  this.personalityName
	}

	def setPersonalityName( personalityName: Option[String]) 	={
		 this.personalityName = personalityName
		 this.keyModified("personality_name") = 1
	}

	def getMandatory() :Option[Boolean]	={
		return  this.mandatory
	}

	def setMandatory( mandatory: Option[Boolean]) 	={
		 this.mandatory = mandatory
		 this.keyModified("mandatory") = 1
	}

	def getQuickSequenceNumber() :Option[Long]	={
		return  this.quickSequenceNumber
	}

	def setQuickSequenceNumber( quickSequenceNumber: Option[Long]) 	={
		 this.quickSequenceNumber = quickSequenceNumber
		 this.keyModified("quick_sequence_number") = 1
	}

	def getProfiles() :ArrayBuffer[Profile]	={
		return  this.profiles
	}

	def setProfiles( profiles: ArrayBuffer[Profile]) 	={
		 this.profiles = profiles
		 this.keyModified("profiles") = 1
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