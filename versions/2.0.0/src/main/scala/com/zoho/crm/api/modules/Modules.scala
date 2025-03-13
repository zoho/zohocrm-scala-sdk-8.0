package com.zoho.crm.api.modules

import com.zoho.crm.api.customviews.CustomViews
import com.zoho.crm.api.fields.LayoutAssociation
import com.zoho.crm.api.fields.MinifiedField
import com.zoho.crm.api.profiles.MinifiedProfile
import com.zoho.crm.api.relatedlists.RelatedList
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class Modules extends Model	{
	private var hasMoreProfiles:Option[Boolean] = None
	private var subMenuAvailable:Option[Boolean] = None
	private var globalSearchSupported:Option[Boolean] = None
	private var deletable:Option[Boolean] = None
	private var description:Option[String] = None
	private var creatable:Option[Boolean] = None
	private var recycleBinOnDelete:Option[Boolean] = None
	private var inventoryTemplateSupported:Option[Boolean] = None
	private var modifiedTime:Option[OffsetDateTime] = None
	private var pluralLabel:Option[String] = None
	private var presenceSubMenu:Option[Boolean] = None
	private var triggersSupported:Option[Boolean] = None
	private var id:Option[Long] = None
	private var chartView:Option[Boolean] = None
	private var isblueprintsupported:Option[Boolean] = None
	private var visibility:Option[Int] = None
	private var visible:Option[Boolean] = None
	private var convertable:Option[Boolean] = None
	private var editable:Option[Boolean] = None
	private var emailtemplateSupport:Option[Boolean] = None
	private var emailParserSupported:Option[Boolean] = None
	private var filterSupported:Option[Boolean] = None
	private var showAsTab:Option[Boolean] = None
	private var webLink:Option[String] = None
	private var sequenceNumber:Option[Int] = None
	private var singularLabel:Option[String] = None
	private var viewable:Option[Boolean] = None
	private var apiSupported:Option[Boolean] = None
	private var apiName:Option[String] = None
	private var quickCreate:Option[Boolean] = None
	private var generatedType:Choice[String] = _
	private var feedsRequired:Option[Boolean] = None
	private var scoringSupported:Option[Boolean] = None
	private var webformSupported:Option[Boolean] = None
	private var territory:Option[Territory] = None
	private var arguments:ArrayBuffer[Argument] = _
	private var moduleName:Option[String] = None
	private var chartViewSupported:Option[Boolean] = None
	private var profileCount:Option[Int] = None
	private var businessCardFieldLimit:Option[Int] = None
	private var trackCurrentData:Option[Boolean] = None
	private var modifiedBy:Option[MinifiedUser] = None
	private var profiles:ArrayBuffer[MinifiedProfile] = _
	private var parentModule:Option[MinifiedModule] = None
	private var activityBadge:Choice[String] = _
	private var fieldStates:ArrayBuffer[String] = _
	private var businessCardFields:ArrayBuffer[String] = _
	private var perPage:Option[Int] = None
	private var properties:ArrayBuffer[String] = _
	private var onDemandProperties:ArrayBuffer[String] = _
	private var searchLayoutFields:ArrayBuffer[String] = _
	private var kanbanViewSupported:Option[Boolean] = None
	private var lookupFieldProperties:Option[LookupFieldProperties] = None
	private var kanbanView:Option[Boolean] = None
	private var relatedLists:ArrayBuffer[RelatedList] = _
	private var filterStatus:Option[Boolean] = None
	private var relatedListProperties:Option[RelatedListProperties] = None
	private var displayField:Any = None
	private var layouts:ArrayBuffer[Any] = _
	private var fields:ArrayBuffer[ModuleFields] = _
	private var customView:Option[CustomViews] = None
	private var ziaView:Option[Boolean] = None
	private var defaultMappingFields:ArrayBuffer[MinifiedField] = _
	private var status:Option[String] = None
	private var staticSubformProperties:Option[StaticSubformProperties] = None
	private var layoutAssociations:ArrayBuffer[LayoutAssociation] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getHasMoreProfiles() :Option[Boolean]	={
		return  this.hasMoreProfiles
	}

	def setHasMoreProfiles( hasMoreProfiles: Option[Boolean]) 	={
		 this.hasMoreProfiles = hasMoreProfiles
		 this.keyModified("has_more_profiles") = 1
	}

	def getSubMenuAvailable() :Option[Boolean]	={
		return  this.subMenuAvailable
	}

	def setSubMenuAvailable( subMenuAvailable: Option[Boolean]) 	={
		 this.subMenuAvailable = subMenuAvailable
		 this.keyModified("sub_menu_available") = 1
	}

	def getGlobalSearchSupported() :Option[Boolean]	={
		return  this.globalSearchSupported
	}

	def setGlobalSearchSupported( globalSearchSupported: Option[Boolean]) 	={
		 this.globalSearchSupported = globalSearchSupported
		 this.keyModified("global_search_supported") = 1
	}

	def getDeletable() :Option[Boolean]	={
		return  this.deletable
	}

	def setDeletable( deletable: Option[Boolean]) 	={
		 this.deletable = deletable
		 this.keyModified("deletable") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getCreatable() :Option[Boolean]	={
		return  this.creatable
	}

	def setCreatable( creatable: Option[Boolean]) 	={
		 this.creatable = creatable
		 this.keyModified("creatable") = 1
	}

	def getRecycleBinOnDelete() :Option[Boolean]	={
		return  this.recycleBinOnDelete
	}

	def setRecycleBinOnDelete( recycleBinOnDelete: Option[Boolean]) 	={
		 this.recycleBinOnDelete = recycleBinOnDelete
		 this.keyModified("recycle_bin_on_delete") = 1
	}

	def getInventoryTemplateSupported() :Option[Boolean]	={
		return  this.inventoryTemplateSupported
	}

	def setInventoryTemplateSupported( inventoryTemplateSupported: Option[Boolean]) 	={
		 this.inventoryTemplateSupported = inventoryTemplateSupported
		 this.keyModified("inventory_template_supported") = 1
	}

	def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.modifiedTime
	}

	def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.modifiedTime = modifiedTime
		 this.keyModified("modified_time") = 1
	}

	def getPluralLabel() :Option[String]	={
		return  this.pluralLabel
	}

	def setPluralLabel( pluralLabel: Option[String]) 	={
		 this.pluralLabel = pluralLabel
		 this.keyModified("plural_label") = 1
	}

	def getPresenceSubMenu() :Option[Boolean]	={
		return  this.presenceSubMenu
	}

	def setPresenceSubMenu( presenceSubMenu: Option[Boolean]) 	={
		 this.presenceSubMenu = presenceSubMenu
		 this.keyModified("presence_sub_menu") = 1
	}

	def getTriggersSupported() :Option[Boolean]	={
		return  this.triggersSupported
	}

	def setTriggersSupported( triggersSupported: Option[Boolean]) 	={
		 this.triggersSupported = triggersSupported
		 this.keyModified("triggers_supported") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getChartView() :Option[Boolean]	={
		return  this.chartView
	}

	def setChartView( chartView: Option[Boolean]) 	={
		 this.chartView = chartView
		 this.keyModified("chart_view") = 1
	}

	def getIsblueprintsupported() :Option[Boolean]	={
		return  this.isblueprintsupported
	}

	def setIsblueprintsupported( isblueprintsupported: Option[Boolean]) 	={
		 this.isblueprintsupported = isblueprintsupported
		 this.keyModified("isBlueprintSupported") = 1
	}

	def getVisibility() :Option[Int]	={
		return  this.visibility
	}

	def setVisibility( visibility: Option[Int]) 	={
		 this.visibility = visibility
		 this.keyModified("visibility") = 1
	}

	def getVisible() :Option[Boolean]	={
		return  this.visible
	}

	def setVisible( visible: Option[Boolean]) 	={
		 this.visible = visible
		 this.keyModified("visible") = 1
	}

	def getConvertable() :Option[Boolean]	={
		return  this.convertable
	}

	def setConvertable( convertable: Option[Boolean]) 	={
		 this.convertable = convertable
		 this.keyModified("convertable") = 1
	}

	def getEditable() :Option[Boolean]	={
		return  this.editable
	}

	def setEditable( editable: Option[Boolean]) 	={
		 this.editable = editable
		 this.keyModified("editable") = 1
	}

	def getEmailtemplateSupport() :Option[Boolean]	={
		return  this.emailtemplateSupport
	}

	def setEmailtemplateSupport( emailtemplateSupport: Option[Boolean]) 	={
		 this.emailtemplateSupport = emailtemplateSupport
		 this.keyModified("emailTemplate_support") = 1
	}

	def getEmailParserSupported() :Option[Boolean]	={
		return  this.emailParserSupported
	}

	def setEmailParserSupported( emailParserSupported: Option[Boolean]) 	={
		 this.emailParserSupported = emailParserSupported
		 this.keyModified("email_parser_supported") = 1
	}

	def getFilterSupported() :Option[Boolean]	={
		return  this.filterSupported
	}

	def setFilterSupported( filterSupported: Option[Boolean]) 	={
		 this.filterSupported = filterSupported
		 this.keyModified("filter_supported") = 1
	}

	def getShowAsTab() :Option[Boolean]	={
		return  this.showAsTab
	}

	def setShowAsTab( showAsTab: Option[Boolean]) 	={
		 this.showAsTab = showAsTab
		 this.keyModified("show_as_tab") = 1
	}

	def getWebLink() :Option[String]	={
		return  this.webLink
	}

	def setWebLink( webLink: Option[String]) 	={
		 this.webLink = webLink
		 this.keyModified("web_link") = 1
	}

	def getSequenceNumber() :Option[Int]	={
		return  this.sequenceNumber
	}

	def setSequenceNumber( sequenceNumber: Option[Int]) 	={
		 this.sequenceNumber = sequenceNumber
		 this.keyModified("sequence_number") = 1
	}

	def getSingularLabel() :Option[String]	={
		return  this.singularLabel
	}

	def setSingularLabel( singularLabel: Option[String]) 	={
		 this.singularLabel = singularLabel
		 this.keyModified("singular_label") = 1
	}

	def getViewable() :Option[Boolean]	={
		return  this.viewable
	}

	def setViewable( viewable: Option[Boolean]) 	={
		 this.viewable = viewable
		 this.keyModified("viewable") = 1
	}

	def getAPISupported() :Option[Boolean]	={
		return  this.apiSupported
	}

	def setAPISupported( apiSupported: Option[Boolean]) 	={
		 this.apiSupported = apiSupported
		 this.keyModified("api_supported") = 1
	}

	def getAPIName() :Option[String]	={
		return  this.apiName
	}

	def setAPIName( apiName: Option[String]) 	={
		 this.apiName = apiName
		 this.keyModified("api_name") = 1
	}

	def getQuickCreate() :Option[Boolean]	={
		return  this.quickCreate
	}

	def setQuickCreate( quickCreate: Option[Boolean]) 	={
		 this.quickCreate = quickCreate
		 this.keyModified("quick_create") = 1
	}

	def getGeneratedType() :Choice[String]	={
		return  this.generatedType
	}

	def setGeneratedType( generatedType: Choice[String]) 	={
		 this.generatedType = generatedType
		 this.keyModified("generated_type") = 1
	}

	def getFeedsRequired() :Option[Boolean]	={
		return  this.feedsRequired
	}

	def setFeedsRequired( feedsRequired: Option[Boolean]) 	={
		 this.feedsRequired = feedsRequired
		 this.keyModified("feeds_required") = 1
	}

	def getScoringSupported() :Option[Boolean]	={
		return  this.scoringSupported
	}

	def setScoringSupported( scoringSupported: Option[Boolean]) 	={
		 this.scoringSupported = scoringSupported
		 this.keyModified("scoring_supported") = 1
	}

	def getWebformSupported() :Option[Boolean]	={
		return  this.webformSupported
	}

	def setWebformSupported( webformSupported: Option[Boolean]) 	={
		 this.webformSupported = webformSupported
		 this.keyModified("webform_supported") = 1
	}

	def getTerritory() :Option[Territory]	={
		return  this.territory
	}

	def setTerritory( territory: Option[Territory]) 	={
		 this.territory = territory
		 this.keyModified("territory") = 1
	}

	def getArguments() :ArrayBuffer[Argument]	={
		return  this.arguments
	}

	def setArguments( arguments: ArrayBuffer[Argument]) 	={
		 this.arguments = arguments
		 this.keyModified("arguments") = 1
	}

	def getModuleName() :Option[String]	={
		return  this.moduleName
	}

	def setModuleName( moduleName: Option[String]) 	={
		 this.moduleName = moduleName
		 this.keyModified("module_name") = 1
	}

	def getChartViewSupported() :Option[Boolean]	={
		return  this.chartViewSupported
	}

	def setChartViewSupported( chartViewSupported: Option[Boolean]) 	={
		 this.chartViewSupported = chartViewSupported
		 this.keyModified("chart_view_supported") = 1
	}

	def getProfileCount() :Option[Int]	={
		return  this.profileCount
	}

	def setProfileCount( profileCount: Option[Int]) 	={
		 this.profileCount = profileCount
		 this.keyModified("profile_count") = 1
	}

	def getBusinessCardFieldLimit() :Option[Int]	={
		return  this.businessCardFieldLimit
	}

	def setBusinessCardFieldLimit( businessCardFieldLimit: Option[Int]) 	={
		 this.businessCardFieldLimit = businessCardFieldLimit
		 this.keyModified("business_card_field_limit") = 1
	}

	def getTrackCurrentData() :Option[Boolean]	={
		return  this.trackCurrentData
	}

	def setTrackCurrentData( trackCurrentData: Option[Boolean]) 	={
		 this.trackCurrentData = trackCurrentData
		 this.keyModified("track_current_data") = 1
	}

	def getModifiedBy() :Option[MinifiedUser]	={
		return  this.modifiedBy
	}

	def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.modifiedBy = modifiedBy
		 this.keyModified("modified_by") = 1
	}

	def getProfiles() :ArrayBuffer[MinifiedProfile]	={
		return  this.profiles
	}

	def setProfiles( profiles: ArrayBuffer[MinifiedProfile]) 	={
		 this.profiles = profiles
		 this.keyModified("profiles") = 1
	}

	def getParentModule() :Option[MinifiedModule]	={
		return  this.parentModule
	}

	def setParentModule( parentModule: Option[MinifiedModule]) 	={
		 this.parentModule = parentModule
		 this.keyModified("parent_module") = 1
	}

	def getActivityBadge() :Choice[String]	={
		return  this.activityBadge
	}

	def setActivityBadge( activityBadge: Choice[String]) 	={
		 this.activityBadge = activityBadge
		 this.keyModified("activity_badge") = 1
	}

	def getfieldStates() :ArrayBuffer[String]	={
		return  this.fieldStates
	}

	def setfieldStates( fieldStates: ArrayBuffer[String]) 	={
		 this.fieldStates = fieldStates
		 this.keyModified("$field_states") = 1
	}

	def getBusinessCardFields() :ArrayBuffer[String]	={
		return  this.businessCardFields
	}

	def setBusinessCardFields( businessCardFields: ArrayBuffer[String]) 	={
		 this.businessCardFields = businessCardFields
		 this.keyModified("business_card_fields") = 1
	}

	def getPerPage() :Option[Int]	={
		return  this.perPage
	}

	def setPerPage( perPage: Option[Int]) 	={
		 this.perPage = perPage
		 this.keyModified("per_page") = 1
	}

	def getproperties() :ArrayBuffer[String]	={
		return  this.properties
	}

	def setproperties( properties: ArrayBuffer[String]) 	={
		 this.properties = properties
		 this.keyModified("$properties") = 1
	}

	def getonDemandProperties() :ArrayBuffer[String]	={
		return  this.onDemandProperties
	}

	def setonDemandProperties( onDemandProperties: ArrayBuffer[String]) 	={
		 this.onDemandProperties = onDemandProperties
		 this.keyModified("$on_demand_properties") = 1
	}

	def getSearchLayoutFields() :ArrayBuffer[String]	={
		return  this.searchLayoutFields
	}

	def setSearchLayoutFields( searchLayoutFields: ArrayBuffer[String]) 	={
		 this.searchLayoutFields = searchLayoutFields
		 this.keyModified("search_layout_fields") = 1
	}

	def getKanbanViewSupported() :Option[Boolean]	={
		return  this.kanbanViewSupported
	}

	def setKanbanViewSupported( kanbanViewSupported: Option[Boolean]) 	={
		 this.kanbanViewSupported = kanbanViewSupported
		 this.keyModified("kanban_view_supported") = 1
	}

	def getLookupFieldProperties() :Option[LookupFieldProperties]	={
		return  this.lookupFieldProperties
	}

	def setLookupFieldProperties( lookupFieldProperties: Option[LookupFieldProperties]) 	={
		 this.lookupFieldProperties = lookupFieldProperties
		 this.keyModified("lookup_field_properties") = 1
	}

	def getKanbanView() :Option[Boolean]	={
		return  this.kanbanView
	}

	def setKanbanView( kanbanView: Option[Boolean]) 	={
		 this.kanbanView = kanbanView
		 this.keyModified("kanban_view") = 1
	}

	def getRelatedLists() :ArrayBuffer[RelatedList]	={
		return  this.relatedLists
	}

	def setRelatedLists( relatedLists: ArrayBuffer[RelatedList]) 	={
		 this.relatedLists = relatedLists
		 this.keyModified("related_lists") = 1
	}

	def getFilterStatus() :Option[Boolean]	={
		return  this.filterStatus
	}

	def setFilterStatus( filterStatus: Option[Boolean]) 	={
		 this.filterStatus = filterStatus
		 this.keyModified("filter_status") = 1
	}

	def getRelatedListProperties() :Option[RelatedListProperties]	={
		return  this.relatedListProperties
	}

	def setRelatedListProperties( relatedListProperties: Option[RelatedListProperties]) 	={
		 this.relatedListProperties = relatedListProperties
		 this.keyModified("related_list_properties") = 1
	}

	def getDisplayField() :Any	={
		return  this.displayField
	}

	def setDisplayField( displayField: Any) 	={
		 this.displayField = displayField
		 this.keyModified("display_field") = 1
	}

	def getLayouts() :ArrayBuffer[Any]	={
		return  this.layouts
	}

	def setLayouts( layouts: ArrayBuffer[Any]) 	={
		 this.layouts = layouts
		 this.keyModified("layouts") = 1
	}

	def getFields() :ArrayBuffer[ModuleFields]	={
		return  this.fields
	}

	def setFields( fields: ArrayBuffer[ModuleFields]) 	={
		 this.fields = fields
		 this.keyModified("fields") = 1
	}

	def getCustomView() :Option[CustomViews]	={
		return  this.customView
	}

	def setCustomView( customView: Option[CustomViews]) 	={
		 this.customView = customView
		 this.keyModified("custom_view") = 1
	}

	def getZiaView() :Option[Boolean]	={
		return  this.ziaView
	}

	def setZiaView( ziaView: Option[Boolean]) 	={
		 this.ziaView = ziaView
		 this.keyModified("zia_view") = 1
	}

	def getDefaultMappingFields() :ArrayBuffer[MinifiedField]	={
		return  this.defaultMappingFields
	}

	def setDefaultMappingFields( defaultMappingFields: ArrayBuffer[MinifiedField]) 	={
		 this.defaultMappingFields = defaultMappingFields
		 this.keyModified("default_mapping_fields") = 1
	}

	def getStatus() :Option[String]	={
		return  this.status
	}

	def setStatus( status: Option[String]) 	={
		 this.status = status
		 this.keyModified("status") = 1
	}

	def getStaticSubformProperties() :Option[StaticSubformProperties]	={
		return  this.staticSubformProperties
	}

	def setStaticSubformProperties( staticSubformProperties: Option[StaticSubformProperties]) 	={
		 this.staticSubformProperties = staticSubformProperties
		 this.keyModified("static_subform_properties") = 1
	}

	def getLayoutAssociations() :ArrayBuffer[LayoutAssociation]	={
		return  this.layoutAssociations
	}

	def setLayoutAssociations( layoutAssociations: ArrayBuffer[LayoutAssociation]) 	={
		 this.layoutAssociations = layoutAssociations
		 this.keyModified("layout_associations") = 1
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