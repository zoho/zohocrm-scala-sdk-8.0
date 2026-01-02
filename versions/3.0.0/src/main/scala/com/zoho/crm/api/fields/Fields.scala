package com.zoho.crm.api.fields

import com.zoho.crm.api.globalpicklists.Picklist
import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.modules.SharingProperties
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Fields extends Model	{
	private var associatedModule:Option[MinifiedModule] = None
	private var dataType:Option[String] = None
	private var operationType:Option[OperationType] = None
	private var systemMandatory:Option[Boolean] = None
	private var webhook:Option[Boolean] = None
	private var sequenceNumber:Option[Int] = None
	private var defaultValue:Option[String] = None
	private var blueprintSupported:Option[Boolean] = None
	private var virtualField:Option[Boolean] = None
	private var fieldReadOnly:Option[Boolean] = None
	private var customizableProperties:ArrayBuffer[String] = _
	private var readOnly:Option[Boolean] = None
	private var customField:Option[Boolean] = None
	private var businesscardSupported:Option[Boolean] = None
	private var filterable:Option[Boolean] = None
	private var visible:Option[Boolean] = None
	private var availableInUserLayout:Option[Boolean] = None
	private var displayField:Option[Boolean] = None
	private var pickListValuesSortedLexically:Option[Boolean] = None
	private var sortable:Option[Boolean] = None
	private var layoutAssociations:ArrayBuffer[LayoutAssociation] = _
	private var separator:Option[Boolean] = None
	private var searchable:Option[Boolean] = None
	private var enableColourCode:Option[Boolean] = None
	private var massUpdate:Option[Boolean] = None
	private var jsonType:Option[String] = None
	private var createdSource:Option[String] = None
	private var type1:Option[String] = None
	private var displayLabel:Option[String] = None
	private var columnName:Option[String] = None
	private var apiName:Option[String] = None
	private var displayType:Option[Int] = None
	private var uiType:Option[Int] = None
	private var colourCodeEnabledBySystem:Option[Boolean] = None
	private var length:Option[Int] = None
	private var decimalPlace:Option[Int] = None
	private var quickSequenceNumber:Option[String] = None
	private var emailParser:Option[EmailParser] = None
	private var rollupSummary:Option[RollupSummary] = None
	private var referFromField:Option[ReferFromField] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var showType:Option[Int] = None
	private var category:Option[Int] = None
	private var id:Option[Long] = None
	private var multiModuleLookup:Option[MultiModuleLookup] = None
	private var sharingProperties:Option[SharingProperties] = None
	private var currency:Option[Currency] = None
	private var fileUploadOptionlist:ArrayBuffer[FileUploadOption] = _
	private var lookup:Option[Lookup] = None
	private var profiles:ArrayBuffer[Profile] = _
	private var viewType:Option[ViewType] = None
	private var unique:Option[Unique] = None
	private var subModule:Option[MinifiedModule] = None
	private var subform:Option[Subform] = None
	private var external:Option[External] = None
	private var formula:Option[Formula] = None
	private var private1:Option[Private] = None
	private var convertMapping:Option[ConvertMapping] = None
	private var multiselectlookup:Option[Multiselectlookup] = None
	private var multiuserlookup:Option[Multiselectlookup] = None
	private var autonumber:Option[AutoNumber] = None
	private var autoNumber61:Option[AutoNumber] = None
	private var pickListValues:ArrayBuffer[PickListValue] = _
	private var crypt:Option[Crypt] = None
	private var tooltip:Option[Tooltip] = None
	private var historyTrackingEnabled:Option[Boolean] = None
	private var historyTracking:Option[HistoryTracking] = None
	private var associationDetails:Option[AssociationDetails] = None
	private var allowedModules:ArrayBuffer[MinifiedModule] = _
	private var additionalColumn:Option[String] = None
	private var fieldLabel:Option[String] = None
	private var globalPicklist:Option[Picklist] = None
	private var hipaaComplianceEnabled:Option[Boolean] = None
	private var hipaaCompliance:Option[HipaaCompliance] = None
	private var updateExistingRecords:Option[Boolean] = None
	private var numberSeparator:Option[Boolean] = None
	private var textarea:Option[Textarea] = None
	private var staticField:Option[Boolean] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getAssociatedModule() :Option[MinifiedModule]	={
		return  this.associatedModule
	}

	def setAssociatedModule( associatedModule: Option[MinifiedModule]) 	={
		 this.associatedModule = associatedModule
		 this.keyModified("associated_module") = 1
	}

	def getDataType() :Option[String]	={
		return  this.dataType
	}

	def setDataType( dataType: Option[String]) 	={
		 this.dataType = dataType
		 this.keyModified("data_type") = 1
	}

	def getOperationType() :Option[OperationType]	={
		return  this.operationType
	}

	def setOperationType( operationType: Option[OperationType]) 	={
		 this.operationType = operationType
		 this.keyModified("operation_type") = 1
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

	def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getDefaultValue() :Option[String]	={
		return  this.defaultValue
	}

	def setDefaultValue( defaultValue: Option[String]) 	={
		 this.defaultValue = defaultValue
		 this.keyModified("default_value") = 1
	}

	def getBlueprintSupported() :Option[Boolean]	={
		return  this.blueprintSupported
	}

	def setBlueprintSupported( blueprintSupported: Option[Boolean]) 	={
		 this.blueprintSupported = blueprintSupported
		 this.keyModified("blueprint_supported") = 1
	}

	def getVirtualField() :Option[Boolean]	={
		return  this.virtualField
	}

	def setVirtualField( virtualField: Option[Boolean]) 	={
		 this.virtualField = virtualField
		 this.keyModified("virtual_field") = 1
	}

	def getFieldReadOnly() :Option[Boolean]	={
		return  this.fieldReadOnly
	}

	def setFieldReadOnly( fieldReadOnly: Option[Boolean]) 	={
		 this.fieldReadOnly = fieldReadOnly
		 this.keyModified("field_read_only") = 1
	}

	def getCustomizableProperties() :ArrayBuffer[String]	={
		return  this.customizableProperties
	}

	def setCustomizableProperties( customizableProperties: ArrayBuffer[String]) 	={
		 this.customizableProperties = customizableProperties
		 this.keyModified("customizable_properties") = 1
	}

	def getReadOnly() :Option[Boolean]	={
		return  this.readOnly
	}

	def setReadOnly( readOnly: Option[Boolean]) 	={
		 this.readOnly = readOnly
		 this.keyModified("read_only") = 1
	}

	def getCustomField() :Option[Boolean]	={
		return  this.customField
	}

	def setCustomField( customField: Option[Boolean]) 	={
		 this.customField = customField
		 this.keyModified("custom_field") = 1
	}

	def getBusinesscardSupported() :Option[Boolean]	={
		return  this.businesscardSupported
	}

	def setBusinesscardSupported( businesscardSupported: Option[Boolean]) 	={
		 this.businesscardSupported = businesscardSupported
		 this.keyModified("businesscard_supported") = 1
	}

	def getFilterable() :Option[Boolean]	={
		return  this.filterable
	}

	def setFilterable( filterable: Option[Boolean]) 	={
		 this.filterable = filterable
		 this.keyModified("filterable") = 1
	}

	def getVisible() :Option[Boolean]	={
		return  this.visible
	}

	def setVisible( visible: Option[Boolean]) 	={
		 this.visible = visible
		 this.keyModified("visible") = 1
	}

	def getAvailableInUserLayout() :Option[Boolean]	={
		return  this.availableInUserLayout
	}

	def setAvailableInUserLayout( availableInUserLayout: Option[Boolean]) 	={
		 this.availableInUserLayout = availableInUserLayout
		 this.keyModified("available_in_user_layout") = 1
	}

	def getDisplayField() :Option[Boolean]	={
		return  this.displayField
	}

	def setDisplayField( displayField: Option[Boolean]) 	={
		 this.displayField = displayField
		 this.keyModified("display_field") = 1
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

	def getLayoutAssociations() :ArrayBuffer[LayoutAssociation]	={
		return  this.layoutAssociations
	}

	def setLayoutAssociations( layoutAssociations: ArrayBuffer[LayoutAssociation]) 	={
		 this.layoutAssociations = layoutAssociations
		 this.keyModified("layout_associations") = 1
	}

	def getSeparator() :Option[Boolean]	={
		return  this.separator
	}

	def setSeparator( separator: Option[Boolean]) 	={
		 this.separator = separator
		 this.keyModified("separator") = 1
	}

	def getSearchable() :Option[Boolean]	={
		return  this.searchable
	}

	def setSearchable( searchable: Option[Boolean]) 	={
		 this.searchable = searchable
		 this.keyModified("searchable") = 1
	}

	def getEnableColourCode() :Option[Boolean]	={
		return  this.enableColourCode
	}

	def setEnableColourCode( enableColourCode: Option[Boolean]) 	={
		 this.enableColourCode = enableColourCode
		 this.keyModified("enable_colour_code") = 1
	}

	def getMassUpdate() :Option[Boolean]	={
		return  this.massUpdate
	}

	def setMassUpdate( massUpdate: Option[Boolean]) 	={
		 this.massUpdate = massUpdate
		 this.keyModified("mass_update") = 1
	}

	def getJsonType() :Option[String]	={
		return  this.jsonType
	}

	def setJsonType( jsonType: Option[String]) 	={
		 this.jsonType = jsonType
		 this.keyModified("json_type") = 1
	}

	def getCreatedSource() :Option[String]	={
		return  this.createdSource
	}

	def setCreatedSource( createdSource: Option[String]) 	={
		 this.createdSource = createdSource
		 this.keyModified("created_source") = 1
	}

	def getType() :Option[String]	={
		return  this.type1
	}

	def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	def getColumnName() :Option[String]	={
		return  this.columnName
	}

	def setColumnName( columnName: Option[String]) 	={
		 this.columnName = columnName
		 this.keyModified("column_name") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getDisplayType() :Option[Int]	={
		return  this.displayType
	}

	def setDisplayType( displayType: Option[Int]) 	={
		 this.displayType = displayType
		 this.keyModified("display_type") = 1
	}

	def getUiType() :Option[Int]	={
		return  this.uiType
	}

	def setUiType( uiType: Option[Int]) 	={
		 this.uiType = uiType
		 this.keyModified("ui_type") = 1
	}

	def getColourCodeEnabledBySystem() :Option[Boolean]	={
		return  this.colourCodeEnabledBySystem
	}

	def setColourCodeEnabledBySystem( colourCodeEnabledBySystem: Option[Boolean]) 	={
		 this.colourCodeEnabledBySystem = colourCodeEnabledBySystem
		 this.keyModified("colour_code_enabled_by_system") = 1
	}

	def getLength() :Option[Int]	={
		return  this.length
	}

	def setLength( length: Option[Int]) 	={
		 this.length = length
		 this.keyModified("length") = 1
	}

	def getDecimalPlace() :Option[Int]	={
		return  this.decimalPlace
	}

	def setDecimalPlace( decimalPlace: Option[Int]) 	={
		 this.decimalPlace = decimalPlace
		 this.keyModified("decimal_place") = 1
	}

	def getQuickSequenceNumber() :Option[String]	={
		return  this.quickSequenceNumber
	}

	def setQuickSequenceNumber( quickSequenceNumber: Option[String]) 	={
		 this.quickSequenceNumber = quickSequenceNumber
		 this.keyModified("quick_sequence_number") = 1
	}

	def getEmailParser() :Option[EmailParser]	={
		return  this.emailParser
	}

	def setEmailParser( emailParser: Option[EmailParser]) 	={
		 this.emailParser = emailParser
		 this.keyModified("email_parser") = 1
	}

	def getRollupSummary() :Option[RollupSummary]	={
		return  this.rollupSummary
	}

	def setRollupSummary( rollupSummary: Option[RollupSummary]) 	={
		 this.rollupSummary = rollupSummary
		 this.keyModified("rollup_summary") = 1
	}

	def getReferFromField() :Option[ReferFromField]	={
		return  this.referFromField
	}

	def setReferFromField( referFromField: Option[ReferFromField]) 	={
		 this.referFromField = referFromField
		 this.keyModified("refer_from_field") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getShowType() :Option[Int]	={
		return  this.showType
	}

	def setShowType( showType: Option[Int]) 	={
		 this.showType = showType
		 this.keyModified("show_type") = 1
	}

	def getCategory() :Option[Int]	={
		return  this.category
	}

	def setCategory( category: Option[Int]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getMultiModuleLookup() :Option[MultiModuleLookup]	={
		return  this.multiModuleLookup
	}

	def setMultiModuleLookup( multiModuleLookup: Option[MultiModuleLookup]) 	={
		 this.multiModuleLookup = multiModuleLookup
		 this.keyModified("multi_module_lookup") = 1
	}

	def getSharingProperties() :Option[SharingProperties]	={
		return  this.sharingProperties
	}

	def setSharingProperties( sharingProperties: Option[SharingProperties]) 	={
		 this.sharingProperties = sharingProperties
		 this.keyModified("sharing_properties") = 1
	}

	def getCurrency() :Option[Currency]	={
		return  this.currency
	}

	def setCurrency( currency: Option[Currency]) 	={
		 this.currency = currency
		 this.keyModified("currency") = 1
	}

	def getFileUploadOptionlist() :ArrayBuffer[FileUploadOption]	={
		return  this.fileUploadOptionlist
	}

	def setFileUploadOptionlist( fileUploadOptionlist: ArrayBuffer[FileUploadOption]) 	={
		 this.fileUploadOptionlist = fileUploadOptionlist
		 this.keyModified("file_upload_optionlist") = 1
	}

	def getLookup() :Option[Lookup]	={
		return  this.lookup
	}

	def setLookup( lookup: Option[Lookup]) 	={
		 this.lookup = lookup
		 this.keyModified("lookup") = 1
	}

	def getProfiles() :ArrayBuffer[Profile]	={
		return  this.profiles
	}

	def setProfiles( profiles: ArrayBuffer[Profile]) 	={
		 this.profiles = profiles
		 this.keyModified("profiles") = 1
	}

	def getViewType() :Option[ViewType]	={
		return  this.viewType
	}

	def setViewType( viewType: Option[ViewType]) 	={
		 this.viewType = viewType
		 this.keyModified("view_type") = 1
	}

	def getUnique() :Option[Unique]	={
		return  this.unique
	}

	def setUnique( unique: Option[Unique]) 	={
		 this.unique = unique
		 this.keyModified("unique") = 1
	}

	def getSubModule() :Option[MinifiedModule]	={
		return  this.subModule
	}

	def setSubModule( subModule: Option[MinifiedModule]) 	={
		 this.subModule = subModule
		 this.keyModified("sub_module") = 1
	}

	def getSubform() :Option[Subform]	={
		return  this.subform
	}

	def setSubform( subform: Option[Subform]) 	={
		 this.subform = subform
		 this.keyModified("subform") = 1
	}

	def getExternal() :Option[External]	={
		return  this.external
	}

	def setExternal( external: Option[External]) 	={
		 this.external = external
		 this.keyModified("external") = 1
	}

	def getFormula() :Option[Formula]	={
		return  this.formula
	}

	def setFormula( formula: Option[Formula]) 	={
		 this.formula = formula
		 this.keyModified("formula") = 1
	}

	def getPrivate() :Option[Private]	={
		return  this.private1
	}

	def setPrivate( private1: Option[Private]) 	={
		 this.private1 = private1
		 this.keyModified("private") = 1
	}

	def getConvertMapping() :Option[ConvertMapping]	={
		return  this.convertMapping
	}

	def setConvertMapping( convertMapping: Option[ConvertMapping]) 	={
		 this.convertMapping = convertMapping
		 this.keyModified("convert_mapping") = 1
	}

	def getMultiselectlookup() :Option[Multiselectlookup]	={
		return  this.multiselectlookup
	}

	def setMultiselectlookup( multiselectlookup: Option[Multiselectlookup]) 	={
		 this.multiselectlookup = multiselectlookup
		 this.keyModified("multiselectlookup") = 1
	}

	def getMultiuserlookup() :Option[Multiselectlookup]	={
		return  this.multiuserlookup
	}

	def setMultiuserlookup( multiuserlookup: Option[Multiselectlookup]) 	={
		 this.multiuserlookup = multiuserlookup
		 this.keyModified("multiuserlookup") = 1
	}

	def getAutonumber() :Option[AutoNumber]	={
		return  this.autonumber
	}

	def setAutonumber( autonumber: Option[AutoNumber]) 	={
		 this.autonumber = autonumber
		 this.keyModified("autonumber") = 1
	}

	def getAutoNumber61() :Option[AutoNumber]	={
		return  this.autoNumber61
	}

	def setAutoNumber61( autoNumber61: Option[AutoNumber]) 	={
		 this.autoNumber61 = autoNumber61
		 this.keyModified("auto_number") = 1
	}

	def getPickListValues() :ArrayBuffer[PickListValue]	={
		return  this.pickListValues
	}

	def setPickListValues( pickListValues: ArrayBuffer[PickListValue]) 	={
		 this.pickListValues = pickListValues
		 this.keyModified("pick_list_values") = 1
	}

	def getCrypt() :Option[Crypt]	={
		return  this.crypt
	}

	def setCrypt( crypt: Option[Crypt]) 	={
		 this.crypt = crypt
		 this.keyModified("crypt") = 1
	}

	def getTooltip() :Option[Tooltip]	={
		return  this.tooltip
	}

	def setTooltip( tooltip: Option[Tooltip]) 	={
		 this.tooltip = tooltip
		 this.keyModified("tooltip") = 1
	}

	def getHistoryTrackingEnabled() :Option[Boolean]	={
		return  this.historyTrackingEnabled
	}

	def setHistoryTrackingEnabled( historyTrackingEnabled: Option[Boolean]) 	={
		 this.historyTrackingEnabled = historyTrackingEnabled
		 this.keyModified("history_tracking_enabled") = 1
	}

	def getHistoryTracking() :Option[HistoryTracking]	={
		return  this.historyTracking
	}

	def setHistoryTracking( historyTracking: Option[HistoryTracking]) 	={
		 this.historyTracking = historyTracking
		 this.keyModified("history_tracking") = 1
	}

	def getAssociationDetails() :Option[AssociationDetails]	={
		return  this.associationDetails
	}

	def setAssociationDetails( associationDetails: Option[AssociationDetails]) 	={
		 this.associationDetails = associationDetails
		 this.keyModified("association_details") = 1
	}

	def getAllowedModules() :ArrayBuffer[MinifiedModule]	={
		return  this.allowedModules
	}

	def setAllowedModules( allowedModules: ArrayBuffer[MinifiedModule]) 	={
		 this.allowedModules = allowedModules
		 this.keyModified("allowed_modules") = 1
	}

	def getAdditionalColumn() :Option[String]	={
		return  this.additionalColumn
	}

	def setAdditionalColumn( additionalColumn: Option[String]) 	={
		 this.additionalColumn = additionalColumn
		 this.keyModified("additional_column") = 1
	}

	def getFieldLabel() :Option[String]	={
		return  this.fieldLabel
	}

	def setFieldLabel( fieldLabel: Option[String]) 	={
		 this.fieldLabel = fieldLabel
		 this.keyModified("field_label") = 1
	}

	def getGlobalPicklist() :Option[Picklist]	={
		return  this.globalPicklist
	}

	def setGlobalPicklist( globalPicklist: Option[Picklist]) 	={
		 this.globalPicklist = globalPicklist
		 this.keyModified("global_picklist") = 1
	}

	def getHipaaComplianceEnabled() :Option[Boolean]	={
		return  this.hipaaComplianceEnabled
	}

	def setHipaaComplianceEnabled( hipaaComplianceEnabled: Option[Boolean]) 	={
		 this.hipaaComplianceEnabled = hipaaComplianceEnabled
		 this.keyModified("hipaa_compliance_enabled") = 1
	}

	def getHipaaCompliance() :Option[HipaaCompliance]	={
		return  this.hipaaCompliance
	}

	def setHipaaCompliance( hipaaCompliance: Option[HipaaCompliance]) 	={
		 this.hipaaCompliance = hipaaCompliance
		 this.keyModified("hipaa_compliance") = 1
	}

	def getUpdateExistingRecords() :Option[Boolean]	={
		return  this.updateExistingRecords
	}

	def setUpdateExistingRecords( updateExistingRecords: Option[Boolean]) 	={
		 this.updateExistingRecords = updateExistingRecords
		 this.keyModified("_update_existing_records") = 1
	}

	def getNumberSeparator() :Option[Boolean]	={
		return  this.numberSeparator
	}

	def setNumberSeparator( numberSeparator: Option[Boolean]) 	={
		 this.numberSeparator = numberSeparator
		 this.keyModified("number_separator") = 1
	}

	def getTextarea() :Option[Textarea]	={
		return  this.textarea
	}

	def setTextarea( textarea: Option[Textarea]) 	={
		 this.textarea = textarea
		 this.keyModified("textarea") = 1
	}

	def getStaticField() :Option[Boolean]	={
		return  this.staticField
	}

	def setStaticField( staticField: Option[Boolean]) 	={
		 this.staticField = staticField
		 this.keyModified("static_field") = 1
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