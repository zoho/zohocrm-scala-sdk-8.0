package com.zoho.crm.api.layouts

import com.zoho.crm.api.fields.AssociationDetails
import com.zoho.crm.api.fields.AutoNumber
import com.zoho.crm.api.fields.ConvertMapping
import com.zoho.crm.api.fields.Crypt
import com.zoho.crm.api.fields.Currency
import com.zoho.crm.api.fields.EmailParser
import com.zoho.crm.api.fields.External
import com.zoho.crm.api.fields.Fields
import com.zoho.crm.api.fields.FileUpoladOption
import com.zoho.crm.api.fields.Formula
import com.zoho.crm.api.fields.HipaaCompliance
import com.zoho.crm.api.fields.HistoryTracking
import com.zoho.crm.api.fields.LayoutAssociation
import com.zoho.crm.api.fields.Lookup
import com.zoho.crm.api.fields.MultiModuleLookup
import com.zoho.crm.api.fields.Multiselectlookup
import com.zoho.crm.api.fields.OperationType
import com.zoho.crm.api.fields.PickListValue
import com.zoho.crm.api.fields.Private
import com.zoho.crm.api.fields.Profile
import com.zoho.crm.api.fields.ReferFromField
import com.zoho.crm.api.fields.RollupSummary
import com.zoho.crm.api.fields.Subform
import com.zoho.crm.api.fields.Textarea
import com.zoho.crm.api.fields.Tooltip
import com.zoho.crm.api.fields.Unique
import com.zoho.crm.api.fields.ViewType
import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.modules.SharingProperties
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class SectionField extends Fields with Model	{
	private var required:Option[Boolean] = None
	private var validationRule:Option[HashMap[String, Any]] = _
	private var defaultValue:Option[String] = None
	private var sequenceNumber:Option[Int] = None
	private var sectionId:Option[Int] = None
	private var blueprintSupported:Option[Boolean] = None
	private var jsonType:Option[String] = None
	private var length:Option[Int] = None
	private var decimalPlace:Option[Int] = None
	private var multiModuleLookup:Option[MultiModuleLookup] = None
	private var sharingProperties:Option[SharingProperties] = None
	private var currency:Option[Currency] = None
	private var fileUpoladOptionlist:ArrayBuffer[FileUpoladOption] = _
	private var lookup:Option[Lookup] = None
	private var subform:Option[Subform] = None
	private var formula:Option[Formula] = None
	private var multiselectlookup:Option[Multiselectlookup] = None
	private var multiuserlookup:Option[Multiselectlookup] = None
	private var pickListValues:ArrayBuffer[PickListValue] = _
	private var allowedModules:ArrayBuffer[MinifiedModule] = _
	private var hipaaComplianceEnabled:Option[Boolean] = None
	private var hipaaCompliance:Option[HipaaCompliance] = None
	private var staticValues:ArrayBuffer[StaticValues] = _
	private var staticField:Option[Boolean] = None
	private var layoutAssociations:ArrayBuffer[LayoutAssociation] = _
	private var delete:Option[Delete1] = None
	private var associatedModule:Option[MinifiedModule] = None
	private var dataType:Option[String] = None
	private var operationType:Option[OperationType] = None
	private var systemMandatory:Option[Boolean] = None
	private var webhook:Option[Boolean] = None
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
	private var separator:Option[Boolean] = None
	private var searchable:Option[Boolean] = None
	private var enableColourCode:Option[Boolean] = None
	private var massUpdate:Option[Boolean] = None
	private var createdSource:Option[String] = None
	private var type1:Option[String] = None
	private var displayLabel:Option[String] = None
	private var columnName:Option[String] = None
	private var apiName:Option[String] = None
	private var displayType:Option[Int] = None
	private var uiType:Option[Int] = None
	private var colourCodeEnabledBySystem:Option[Boolean] = None
	private var quickSequenceNumber:Option[String] = None
	private var emailParser:Option[EmailParser] = None
	private var rollupSummary:Option[RollupSummary] = None
	private var referFromField:Option[ReferFromField] = None
	private var createdTime:Option[OffsetDateTime] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var showType:Option[Int] = None
	private var category:Option[Int] = None
	private var id:Option[Long] = None
	private var profiles:ArrayBuffer[Profile] = _
	private var viewType:Option[ViewType] = None
	private var unique:Option[Unique] = None
	private var subModule:Option[MinifiedModule] = None
	private var external:Option[External] = None
	private var private1:Option[Private] = None
	private var convertMapping:Option[ConvertMapping] = None
	private var autonumber:Option[AutoNumber] = None
	private var autoNumber71:Option[AutoNumber] = None
	private var crypt:Option[Crypt] = None
	private var tooltip:Option[Tooltip] = None
	private var historyTracking:Option[HistoryTracking] = None
	private var associationDetails:Option[AssociationDetails] = None
	private var additionalColumn:Option[String] = None
	private var fieldLabel:Option[String] = None
	private var globalPicklist:Any = None
	private var updateexistingrecords:Option[Boolean] = None
	private var numberSeparator:Option[Boolean] = None
	private var textarea:Option[Textarea] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getRequired() :Option[Boolean]	={
		return  this.required
	}

	def setRequired( required: Option[Boolean]) 	={
		 this.required = required
		 this.keyModified("required") = 1
	}

	def getValidationRule() :Option[HashMap[String, Any]]	={
		return  this.validationRule
	}

	def setValidationRule( validationRule: Option[HashMap[String, Any]]) 	={
		 this.validationRule = validationRule
		 this.keyModified("validation_rule") = 1
	}

	override def getDefaultValue() :Option[String]	={
		return  this.defaultValue
	}

	override def setDefaultValue( defaultValue: Option[String]) 	={
		 this.defaultValue = defaultValue
		 this.keyModified("default_value") = 1
	}

	override def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	override def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getSectionId() :Option[Int]	={
		return  this.sectionId
	}

	def setSectionId( sectionId: Option[Int]) 	={
		 this.sectionId = sectionId
		 this.keyModified("section_id") = 1
	}

	override def getBlueprintSupported() :Option[Boolean]	={
		return  this.blueprintSupported
	}

	override def setBlueprintSupported( blueprintSupported: Option[Boolean]) 	={
		 this.blueprintSupported = blueprintSupported
		 this.keyModified("blueprint_supported") = 1
	}

	override def getJsonType() :Option[String]	={
		return  this.jsonType
	}

	override def setJsonType( jsonType: Option[String]) 	={
		 this.jsonType = jsonType
		 this.keyModified("json_type") = 1
	}

	override def getLength() :Option[Int]	={
		return  this.length
	}

	override def setLength( length: Option[Int]) 	={
		 this.length = length
		 this.keyModified("length") = 1
	}

	override def getDecimalPlace() :Option[Int]	={
		return  this.decimalPlace
	}

	override def setDecimalPlace( decimalPlace: Option[Int]) 	={
		 this.decimalPlace = decimalPlace
		 this.keyModified("decimal_place") = 1
	}

	override def getMultiModuleLookup() :Option[MultiModuleLookup]	={
		return  this.multiModuleLookup
	}

	override def setMultiModuleLookup( multiModuleLookup: Option[MultiModuleLookup]) 	={
		 this.multiModuleLookup = multiModuleLookup
		 this.keyModified("multi_module_lookup") = 1
	}

	override def getSharingProperties() :Option[SharingProperties]	={
		return  this.sharingProperties
	}

	override def setSharingProperties( sharingProperties: Option[SharingProperties]) 	={
		 this.sharingProperties = sharingProperties
		 this.keyModified("sharing_properties") = 1
	}

	override def getCurrency() :Option[Currency]	={
		return  this.currency
	}

	override def setCurrency( currency: Option[Currency]) 	={
		 this.currency = currency
		 this.keyModified("currency") = 1
	}

	override def getFileUpoladOptionlist() :ArrayBuffer[FileUpoladOption]	={
		return  this.fileUpoladOptionlist
	}

	override def setFileUpoladOptionlist( fileUpoladOptionlist: ArrayBuffer[FileUpoladOption]) 	={
		 this.fileUpoladOptionlist = fileUpoladOptionlist
		 this.keyModified("file_upolad_optionlist") = 1
	}

	override def getLookup() :Option[Lookup]	={
		return  this.lookup
	}

	override def setLookup( lookup: Option[Lookup]) 	={
		 this.lookup = lookup
		 this.keyModified("lookup") = 1
	}

	override def getSubform() :Option[Subform]	={
		return  this.subform
	}

	override def setSubform( subform: Option[Subform]) 	={
		 this.subform = subform
		 this.keyModified("subform") = 1
	}

	override def getFormula() :Option[Formula]	={
		return  this.formula
	}

	override def setFormula( formula: Option[Formula]) 	={
		 this.formula = formula
		 this.keyModified("formula") = 1
	}

	override def getMultiselectlookup() :Option[Multiselectlookup]	={
		return  this.multiselectlookup
	}

	override def setMultiselectlookup( multiselectlookup: Option[Multiselectlookup]) 	={
		 this.multiselectlookup = multiselectlookup
		 this.keyModified("multiselectlookup") = 1
	}

	override def getMultiuserlookup() :Option[Multiselectlookup]	={
		return  this.multiuserlookup
	}

	override def setMultiuserlookup( multiuserlookup: Option[Multiselectlookup]) 	={
		 this.multiuserlookup = multiuserlookup
		 this.keyModified("multiuserlookup") = 1
	}

	override def getPickListValues() :ArrayBuffer[PickListValue]	={
		return  this.pickListValues
	}

	override def setPickListValues( pickListValues: ArrayBuffer[PickListValue]) 	={
		 this.pickListValues = pickListValues
		 this.keyModified("pick_list_values") = 1
	}

	override def getAllowedModules() :ArrayBuffer[MinifiedModule]	={
		return  this.allowedModules
	}

	override def setAllowedModules( allowedModules: ArrayBuffer[MinifiedModule]) 	={
		 this.allowedModules = allowedModules
		 this.keyModified("allowed_modules") = 1
	}

	override def getHipaaComplianceEnabled() :Option[Boolean]	={
		return  this.hipaaComplianceEnabled
	}

	override def setHipaaComplianceEnabled( hipaaComplianceEnabled: Option[Boolean]) 	={
		 this.hipaaComplianceEnabled = hipaaComplianceEnabled
		 this.keyModified("hipaa_compliance_enabled") = 1
	}

	override def getHipaaCompliance() :Option[HipaaCompliance]	={
		return  this.hipaaCompliance
	}

	override def setHipaaCompliance( hipaaCompliance: Option[HipaaCompliance]) 	={
		 this.hipaaCompliance = hipaaCompliance
		 this.keyModified("hipaa_compliance") = 1
	}

	def getStaticValues() :ArrayBuffer[StaticValues]	={
		return  this.staticValues
	}

	def setStaticValues( staticValues: ArrayBuffer[StaticValues]) 	={
		 this.staticValues = staticValues
		 this.keyModified("static_values") = 1
	}

	override def getStaticField() :Option[Boolean]	={
		return  this.staticField
	}

	override def setStaticField( staticField: Option[Boolean]) 	={
		 this.staticField = staticField
		 this.keyModified("static_field") = 1
	}

	override def getLayoutAssociations() :ArrayBuffer[LayoutAssociation]	={
		return  this.layoutAssociations
	}

	override def setLayoutAssociations( layoutAssociations: ArrayBuffer[LayoutAssociation]) 	={
		 this.layoutAssociations = layoutAssociations
		 this.keyModified("layout_associations") = 1
	}

	def getDelete() :Option[Delete1]	={
		return  this.delete
	}

	def setDelete( delete: Option[Delete1]) 	={
		 this.delete = delete
		 this.keyModified("_delete") = 1
	}

	override def getAssociatedModule() :Option[MinifiedModule]	={
		return  this.associatedModule
	}

	override def setAssociatedModule( associatedModule: Option[MinifiedModule]) 	={
		 this.associatedModule = associatedModule
		 this.keyModified("associated_module") = 1
	}

	override def getDataType() :Option[String]	={
		return  this.dataType
	}

	override def setDataType( dataType: Option[String]) 	={
		 this.dataType = dataType
		 this.keyModified("data_type") = 1
	}

	override def getOperationType() :Option[OperationType]	={
		return  this.operationType
	}

	override def setOperationType( operationType: Option[OperationType]) 	={
		 this.operationType = operationType
		 this.keyModified("operation_type") = 1
	}

	override def getSystemMandatory() :Option[Boolean]	={
		return  this.systemMandatory
	}

	override def setSystemMandatory( systemMandatory: Option[Boolean]) 	={
		 this.systemMandatory = systemMandatory
		 this.keyModified("system_mandatory") = 1
	}

	override def getWebhook() :Option[Boolean]	={
		return  this.webhook
	}

	override def setWebhook( webhook: Option[Boolean]) 	={
		 this.webhook = webhook
		 this.keyModified("webhook") = 1
	}

	override def getVirtualField() :Option[Boolean]	={
		return  this.virtualField
	}

	override def setVirtualField( virtualField: Option[Boolean]) 	={
		 this.virtualField = virtualField
		 this.keyModified("virtual_field") = 1
	}

	override def getFieldReadOnly() :Option[Boolean]	={
		return  this.fieldReadOnly
	}

	override def setFieldReadOnly( fieldReadOnly: Option[Boolean]) 	={
		 this.fieldReadOnly = fieldReadOnly
		 this.keyModified("field_read_only") = 1
	}

	override def getCustomizableProperties() :ArrayBuffer[String]	={
		return  this.customizableProperties
	}

	override def setCustomizableProperties( customizableProperties: ArrayBuffer[String]) 	={
		 this.customizableProperties = customizableProperties
		 this.keyModified("customizable_properties") = 1
	}

	override def getReadOnly() :Option[Boolean]	={
		return  this.readOnly
	}

	override def setReadOnly( readOnly: Option[Boolean]) 	={
		 this.readOnly = readOnly
		 this.keyModified("read_only") = 1
	}

	override def getCustomField() :Option[Boolean]	={
		return  this.customField
	}

	override def setCustomField( customField: Option[Boolean]) 	={
		 this.customField = customField
		 this.keyModified("custom_field") = 1
	}

	override def getBusinesscardSupported() :Option[Boolean]	={
		return  this.businesscardSupported
	}

	override def setBusinesscardSupported( businesscardSupported: Option[Boolean]) 	={
		 this.businesscardSupported = businesscardSupported
		 this.keyModified("businesscard_supported") = 1
	}

	override def getFilterable() :Option[Boolean]	={
		return  this.filterable
	}

	override def setFilterable( filterable: Option[Boolean]) 	={
		 this.filterable = filterable
		 this.keyModified("filterable") = 1
	}

	override def getVisible() :Option[Boolean]	={
		return  this.visible
	}

	override def setVisible( visible: Option[Boolean]) 	={
		 this.visible = visible
		 this.keyModified("visible") = 1
	}

	override def getAvailableInUserLayout() :Option[Boolean]	={
		return  this.availableInUserLayout
	}

	override def setAvailableInUserLayout( availableInUserLayout: Option[Boolean]) 	={
		 this.availableInUserLayout = availableInUserLayout
		 this.keyModified("available_in_user_layout") = 1
	}

	override def getDisplayField() :Option[Boolean]	={
		return  this.displayField
	}

	override def setDisplayField( displayField: Option[Boolean]) 	={
		 this.displayField = displayField
		 this.keyModified("display_field") = 1
	}

	override def getPickListValuesSortedLexically() :Option[Boolean]	={
		return  this.pickListValuesSortedLexically
	}

	override def setPickListValuesSortedLexically( pickListValuesSortedLexically: Option[Boolean]) 	={
		 this.pickListValuesSortedLexically = pickListValuesSortedLexically
		 this.keyModified("pick_list_values_sorted_lexically") = 1
	}

	override def getSortable() :Option[Boolean]	={
		return  this.sortable
	}

	override def setSortable( sortable: Option[Boolean]) 	={
		 this.sortable = sortable
		 this.keyModified("sortable") = 1
	}

	override def getSeparator() :Option[Boolean]	={
		return  this.separator
	}

	override def setSeparator( separator: Option[Boolean]) 	={
		 this.separator = separator
		 this.keyModified("separator") = 1
	}

	override def getSearchable() :Option[Boolean]	={
		return  this.searchable
	}

	override def setSearchable( searchable: Option[Boolean]) 	={
		 this.searchable = searchable
		 this.keyModified("searchable") = 1
	}

	override def getEnableColourCode() :Option[Boolean]	={
		return  this.enableColourCode
	}

	override def setEnableColourCode( enableColourCode: Option[Boolean]) 	={
		 this.enableColourCode = enableColourCode
		 this.keyModified("enable_colour_code") = 1
	}

	override def getMassUpdate() :Option[Boolean]	={
		return  this.massUpdate
	}

	override def setMassUpdate( massUpdate: Option[Boolean]) 	={
		 this.massUpdate = massUpdate
		 this.keyModified("mass_update") = 1
	}

	override def getCreatedSource() :Option[String]	={
		return  this.createdSource
	}

	override def setCreatedSource( createdSource: Option[String]) 	={
		 this.createdSource = createdSource
		 this.keyModified("created_source") = 1
	}

	override def getType() :Option[String]	={
		return  this.type1
	}

	override def setType( type1: Option[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	override def getDisplayLabel() :Option[String]	={
		return  this.displayLabel
	}

	override def setDisplayLabel( displayLabel: Option[String]) 	={
		 this.displayLabel = displayLabel
		 this.keyModified("display_label") = 1
	}

	override def getColumnName() :Option[String]	={
		return  this.columnName
	}

	override def setColumnName( columnName: Option[String]) 	={
		 this.columnName = columnName
		 this.keyModified("column_name") = 1
	}

	override def getAPIName() :Option[String]	={
		return  this.apiName
	}

	override def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	override def getDisplayType() :Option[Int]	={
		return  this.displayType
	}

	override def setDisplayType( displayType: Option[Int]) 	={
		 this.displayType = displayType
		 this.keyModified("display_type") = 1
	}

	override def getUiType() :Option[Int]	={
		return  this.uiType
	}

	override def setUiType( uiType: Option[Int]) 	={
		 this.uiType = uiType
		 this.keyModified("ui_type") = 1
	}

	override def getColourCodeEnabledBySystem() :Option[Boolean]	={
		return  this.colourCodeEnabledBySystem
	}

	override def setColourCodeEnabledBySystem( colourCodeEnabledBySystem: Option[Boolean]) 	={
		 this.colourCodeEnabledBySystem = colourCodeEnabledBySystem
		 this.keyModified("colour_code_enabled_by_system") = 1
	}

	override def getQuickSequenceNumber() :Option[String]	={
		return  this.quickSequenceNumber
	}

	override def setQuickSequenceNumber( quickSequenceNumber: Option[String]) 	={
		 this.quickSequenceNumber = quickSequenceNumber
		 this.keyModified("quick_sequence_number") = 1
	}

	override def getEmailParser() :Option[EmailParser]	={
		return  this.emailParser
	}

	override def setEmailParser( emailParser: Option[EmailParser]) 	={
		 this.emailParser = emailParser
		 this.keyModified("email_parser") = 1
	}

	override def getRollupSummary() :Option[RollupSummary]	={
		return  this.rollupSummary
	}

	override def setRollupSummary( rollupSummary: Option[RollupSummary]) 	={
		 this.rollupSummary = rollupSummary
		 this.keyModified("rollup_summary") = 1
	}

	override def getReferFromField() :Option[ReferFromField]	={
		return  this.referFromField
	}

	override def setReferFromField( referFromField: Option[ReferFromField]) 	={
		 this.referFromField = referFromField
		 this.keyModified("refer_from_field") = 1
	}

	override def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	override def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
	}

	override def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	override def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	override def getShowType() :Option[Int]	={
		return  this.showType
	}

	override def setShowType( showType: Option[Int]) 	={
		 this.showType = showType
		 this.keyModified("show_type") = 1
	}

	override def getCategory() :Option[Int]	={
		return  this.category
	}

	override def setCategory( category: Option[Int]) 	={
		 this.category = category
		 this.keyModified("category") = 1
	}

	override def getId() :Option[Long]	={
		return  this.id
	}

	override def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	override def getProfiles() :ArrayBuffer[Profile]	={
		return  this.profiles
	}

	override def setProfiles( profiles: ArrayBuffer[Profile]) 	={
		 this.profiles = profiles
		 this.keyModified("profiles") = 1
	}

	override def getViewType() :Option[ViewType]	={
		return  this.viewType
	}

	override def setViewType( viewType: Option[ViewType]) 	={
		 this.viewType = viewType
		 this.keyModified("view_type") = 1
	}

	override def getUnique() :Option[Unique]	={
		return  this.unique
	}

	override def setUnique( unique: Option[Unique]) 	={
		 this.unique = unique
		 this.keyModified("unique") = 1
	}

	override def getSubModule() :Option[MinifiedModule]	={
		return  this.subModule
	}

	override def setSubModule( subModule: Option[MinifiedModule]) 	={
		 this.subModule = subModule
		 this.keyModified("sub_module") = 1
	}

	override def getExternal() :Option[External]	={
		return  this.external
	}

	override def setExternal( external: Option[External]) 	={
		 this.external = external
		 this.keyModified("external") = 1
	}

	override def getPrivate() :Option[Private]	={
		return  this.private1
	}

	override def setPrivate( private1: Option[Private]) 	={
		 this.private1 = private1
		 this.keyModified("private") = 1
	}

	override def getConvertMapping() :Option[ConvertMapping]	={
		return  this.convertMapping
	}

	override def setConvertMapping( convertMapping: Option[ConvertMapping]) 	={
		 this.convertMapping = convertMapping
		 this.keyModified("convert_mapping") = 1
	}

	override def getAutonumber() :Option[AutoNumber]	={
		return  this.autonumber
	}

	override def setAutonumber( autonumber: Option[AutoNumber]) 	={
		 this.autonumber = autonumber
		 this.keyModified("autonumber") = 1
	}

	def getAutoNumber71() :Option[AutoNumber]	={
		return  this.autoNumber71
	}

	def setAutoNumber71( autoNumber71: Option[AutoNumber]) 	={
		 this.autoNumber71 = autoNumber71
		 this.keyModified("auto_number") = 1
	}

	override def getCrypt() :Option[Crypt]	={
		return  this.crypt
	}

	override def setCrypt( crypt: Option[Crypt]) 	={
		 this.crypt = crypt
		 this.keyModified("crypt") = 1
	}

	override def getTooltip() :Option[Tooltip]	={
		return  this.tooltip
	}

	override def setTooltip( tooltip: Option[Tooltip]) 	={
		 this.tooltip = tooltip
		 this.keyModified("tooltip") = 1
	}

	override def getHistoryTracking() :Option[HistoryTracking]	={
		return  this.historyTracking
	}

	override def setHistoryTracking( historyTracking: Option[HistoryTracking]) 	={
		 this.historyTracking = historyTracking
		 this.keyModified("history_tracking") = 1
	}

	override def getAssociationDetails() :Option[AssociationDetails]	={
		return  this.associationDetails
	}

	override def setAssociationDetails( associationDetails: Option[AssociationDetails]) 	={
		 this.associationDetails = associationDetails
		 this.keyModified("association_details") = 1
	}

	override def getAdditionalColumn() :Option[String]	={
		return  this.additionalColumn
	}

	override def setAdditionalColumn( additionalColumn: Option[String]) 	={
		 this.additionalColumn = additionalColumn
		 this.keyModified("additional_column") = 1
	}

	override def getFieldLabel() :Option[String]	={
		return  this.fieldLabel
	}

	override def setFieldLabel( fieldLabel: Option[String]) 	={
		 this.fieldLabel = fieldLabel
		 this.keyModified("field_label") = 1
	}

	override def getGlobalPicklist() :Any	={
		return  this.globalPicklist
	}

	override def setGlobalPicklist( globalPicklist: Any) 	={
		 this.globalPicklist = globalPicklist
		 this.keyModified("global_picklist") = 1
	}

	override def getUpdateexistingrecords() :Option[Boolean]	={
		return  this.updateexistingrecords
	}

	override def setUpdateexistingrecords( updateexistingrecords: Option[Boolean]) 	={
		 this.updateexistingrecords = updateexistingrecords
		 this.keyModified("_update_existing_records") = 1
	}

	override def getNumberSeparator() :Option[Boolean]	={
		return  this.numberSeparator
	}

	override def setNumberSeparator( numberSeparator: Option[Boolean]) 	={
		 this.numberSeparator = numberSeparator
		 this.keyModified("number_separator") = 1
	}

	override def getTextarea() :Option[Textarea]	={
		return  this.textarea
	}

	override def setTextarea( textarea: Option[Textarea]) 	={
		 this.textarea = textarea
		 this.keyModified("textarea") = 1
	}

	override def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	override def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}