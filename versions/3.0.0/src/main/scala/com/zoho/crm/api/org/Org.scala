package com.zoho.crm.api.org

import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class Org extends Model	{
	private var country:Option[String] = None
	private var photoId:Option[String] = None
	private var city:Option[String] = None
	private var description:Option[String] = None
	private var mcStatus:Option[Boolean] = None
	private var gappsEnabled:Option[Boolean] = None
	private var translationEnabled:Option[Boolean] = None
	private var street:Option[String] = None
	private var domainName:Option[String] = None
	private var alias:Option[String] = None
	private var currency:Option[String] = None
	private var id:Option[String] = None
	private var state:Option[String] = None
	private var fax:Option[String] = None
	private var zip:Option[String] = None
	private var employeeCount:Option[String] = None
	private var website:Option[String] = None
	private var currencySymbol:Option[String] = None
	private var mobile:Option[String] = None
	private var currencyLocale:Option[String] = None
	private var primaryZuid:Option[String] = None
	private var ziaPortalId:Option[String] = None
	private var timeZone:Option[String] = None
	private var zgid:Option[String] = None
	private var countryCode:Option[String] = None
	private var deletableOrgAccount:Option[Boolean] = None
	private var licenseDetails:Option[LicenseDetails] = None
	private var hierarchyPreferences:Option[HierarchyPreferences] = None
	private var phone:Option[String] = None
	private var companyName:Option[String] = None
	private var privacySettings:Option[Boolean] = None
	private var primaryEmail:Option[String] = None
	private var isoCode:Option[String] = None
	private var hipaaComplianceEnabled:Option[Boolean] = None
	private var liteUsersEnabled:Option[Boolean] = None
	private var maxPerPage:Option[Int] = None
	private var ezgid:Option[String] = None
	private var callIcon:Option[String] = None
	private var oauthPresence:Option[Boolean] = None
	private var ziaZgid:Option[Int] = None
	private var checkinPreferences:Option[CheckinPreferences] = None
	private var type1:Choice[String] = _
	private var createdTime:Option[OffsetDateTime] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getCountry() :Option[String]	={
		return  this.country
	}

	def setCountry( country: Option[String]) 	={
		 this.country = country
		 this.keyModified("country") = 1
	}

	def getPhotoId() :Option[String]	={
		return  this.photoId
	}

	def setPhotoId( photoId: Option[String]) 	={
		 this.photoId = photoId
		 this.keyModified("photo_id") = 1
	}

	def getCity() :Option[String]	={
		return  this.city
	}

	def setCity( city: Option[String]) 	={
		 this.city = city
		 this.keyModified("city") = 1
	}

	def getDescription() :Option[String]	={
		return  this.description
	}

	def setDescription( description: Option[String]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getMcStatus() :Option[Boolean]	={
		return  this.mcStatus
	}

	def setMcStatus( mcStatus: Option[Boolean]) 	={
		 this.mcStatus = mcStatus
		 this.keyModified("mc_status") = 1
	}

	def getGappsEnabled() :Option[Boolean]	={
		return  this.gappsEnabled
	}

	def setGappsEnabled( gappsEnabled: Option[Boolean]) 	={
		 this.gappsEnabled = gappsEnabled
		 this.keyModified("gapps_enabled") = 1
	}

	def getTranslationEnabled() :Option[Boolean]	={
		return  this.translationEnabled
	}

	def setTranslationEnabled( translationEnabled: Option[Boolean]) 	={
		 this.translationEnabled = translationEnabled
		 this.keyModified("translation_enabled") = 1
	}

	def getStreet() :Option[String]	={
		return  this.street
	}

	def setStreet( street: Option[String]) 	={
		 this.street = street
		 this.keyModified("street") = 1
	}

	def getDomainName() :Option[String]	={
		return  this.domainName
	}

	def setDomainName( domainName: Option[String]) 	={
		 this.domainName = domainName
		 this.keyModified("domain_name") = 1
	}

	def getAlias() :Option[String]	={
		return  this.alias
	}

	def setAlias( alias: Option[String]) 	={
		 this.alias = alias
		 this.keyModified("alias") = 1
	}

	def getCurrency() :Option[String]	={
		return  this.currency
	}

	def setCurrency( currency: Option[String]) 	={
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

	def getState() :Option[String]	={
		return  this.state
	}

	def setState( state: Option[String]) 	={
		 this.state = state
		 this.keyModified("state") = 1
	}

	def getFax() :Option[String]	={
		return  this.fax
	}

	def setFax( fax: Option[String]) 	={
		 this.fax = fax
		 this.keyModified("fax") = 1
	}

	def getZip() :Option[String]	={
		return  this.zip
	}

	def setZip( zip: Option[String]) 	={
		 this.zip = zip
		 this.keyModified("zip") = 1
	}

	def getEmployeeCount() :Option[String]	={
		return  this.employeeCount
	}

	def setEmployeeCount( employeeCount: Option[String]) 	={
		 this.employeeCount = employeeCount
		 this.keyModified("employee_count") = 1
	}

	def getWebsite() :Option[String]	={
		return  this.website
	}

	def setWebsite( website: Option[String]) 	={
		 this.website = website
		 this.keyModified("website") = 1
	}

	def getCurrencySymbol() :Option[String]	={
		return  this.currencySymbol
	}

	def setCurrencySymbol( currencySymbol: Option[String]) 	={
		 this.currencySymbol = currencySymbol
		 this.keyModified("currency_symbol") = 1
	}

	def getMobile() :Option[String]	={
		return  this.mobile
	}

	def setMobile( mobile: Option[String]) 	={
		 this.mobile = mobile
		 this.keyModified("mobile") = 1
	}

	def getCurrencyLocale() :Option[String]	={
		return  this.currencyLocale
	}

	def setCurrencyLocale( currencyLocale: Option[String]) 	={
		 this.currencyLocale = currencyLocale
		 this.keyModified("currency_locale") = 1
	}

	def getPrimaryZuid() :Option[String]	={
		return  this.primaryZuid
	}

	def setPrimaryZuid( primaryZuid: Option[String]) 	={
		 this.primaryZuid = primaryZuid
		 this.keyModified("primary_zuid") = 1
	}

	def getZiaPortalId() :Option[String]	={
		return  this.ziaPortalId
	}

	def setZiaPortalId( ziaPortalId: Option[String]) 	={
		 this.ziaPortalId = ziaPortalId
		 this.keyModified("zia_portal_id") = 1
	}

	def getTimeZone() :Option[String]	={
		return  this.timeZone
	}

	def setTimeZone( timeZone: Option[String]) 	={
		 this.timeZone = timeZone
		 this.keyModified("time_zone") = 1
	}

	def getZgid() :Option[String]	={
		return  this.zgid
	}

	def setZgid( zgid: Option[String]) 	={
		 this.zgid = zgid
		 this.keyModified("zgid") = 1
	}

	def getCountryCode() :Option[String]	={
		return  this.countryCode
	}

	def setCountryCode( countryCode: Option[String]) 	={
		 this.countryCode = countryCode
		 this.keyModified("country_code") = 1
	}

	def getDeletableOrgAccount() :Option[Boolean]	={
		return  this.deletableOrgAccount
	}

	def setDeletableOrgAccount( deletableOrgAccount: Option[Boolean]) 	={
		 this.deletableOrgAccount = deletableOrgAccount
		 this.keyModified("deletable_org_account") = 1
	}

	def getLicenseDetails() :Option[LicenseDetails]	={
		return  this.licenseDetails
	}

	def setLicenseDetails( licenseDetails: Option[LicenseDetails]) 	={
		 this.licenseDetails = licenseDetails
		 this.keyModified("license_details") = 1
	}

	def getHierarchyPreferences() :Option[HierarchyPreferences]	={
		return  this.hierarchyPreferences
	}

	def setHierarchyPreferences( hierarchyPreferences: Option[HierarchyPreferences]) 	={
		 this.hierarchyPreferences = hierarchyPreferences
		 this.keyModified("hierarchy_preferences") = 1
	}

	def getPhone() :Option[String]	={
		return  this.phone
	}

	def setPhone( phone: Option[String]) 	={
		 this.phone = phone
		 this.keyModified("phone") = 1
	}

	def getCompanyName() :Option[String]	={
		return  this.companyName
	}

	def setCompanyName( companyName: Option[String]) 	={
		 this.companyName = companyName
		 this.keyModified("company_name") = 1
	}

	def getPrivacySettings() :Option[Boolean]	={
		return  this.privacySettings
	}

	def setPrivacySettings( privacySettings: Option[Boolean]) 	={
		 this.privacySettings = privacySettings
		 this.keyModified("privacy_settings") = 1
	}

	def getPrimaryEmail() :Option[String]	={
		return  this.primaryEmail
	}

	def setPrimaryEmail( primaryEmail: Option[String]) 	={
		 this.primaryEmail = primaryEmail
		 this.keyModified("primary_email") = 1
	}

	def getIsoCode() :Option[String]	={
		return  this.isoCode
	}

	def setIsoCode( isoCode: Option[String]) 	={
		 this.isoCode = isoCode
		 this.keyModified("iso_code") = 1
	}

	def getHipaaComplianceEnabled() :Option[Boolean]	={
		return  this.hipaaComplianceEnabled
	}

	def setHipaaComplianceEnabled( hipaaComplianceEnabled: Option[Boolean]) 	={
		 this.hipaaComplianceEnabled = hipaaComplianceEnabled
		 this.keyModified("hipaa_compliance_enabled") = 1
	}

	def getLiteUsersEnabled() :Option[Boolean]	={
		return  this.liteUsersEnabled
	}

	def setLiteUsersEnabled( liteUsersEnabled: Option[Boolean]) 	={
		 this.liteUsersEnabled = liteUsersEnabled
		 this.keyModified("lite_users_enabled") = 1
	}

	def getMaxPerPage() :Option[Int]	={
		return  this.maxPerPage
	}

	def setMaxPerPage( maxPerPage: Option[Int]) 	={
		 this.maxPerPage = maxPerPage
		 this.keyModified("max_per_page") = 1
	}

	def getEzgid() :Option[String]	={
		return  this.ezgid
	}

	def setEzgid( ezgid: Option[String]) 	={
		 this.ezgid = ezgid
		 this.keyModified("ezgid") = 1
	}

	def getCallIcon() :Option[String]	={
		return  this.callIcon
	}

	def setCallIcon( callIcon: Option[String]) 	={
		 this.callIcon = callIcon
		 this.keyModified("call_icon") = 1
	}

	def getOauthPresence() :Option[Boolean]	={
		return  this.oauthPresence
	}

	def setOauthPresence( oauthPresence: Option[Boolean]) 	={
		 this.oauthPresence = oauthPresence
		 this.keyModified("oauth_presence") = 1
	}

	def getZiaZgid() :Option[Int]	={
		return  this.ziaZgid
	}

	def setZiaZgid( ziaZgid: Option[Int]) 	={
		 this.ziaZgid = ziaZgid
		 this.keyModified("zia_zgid") = 1
	}

	def getCheckinPreferences() :Option[CheckinPreferences]	={
		return  this.checkinPreferences
	}

	def setCheckinPreferences( checkinPreferences: Option[CheckinPreferences]) 	={
		 this.checkinPreferences = checkinPreferences
		 this.keyModified("checkin_preferences") = 1
	}

	def getType() :Choice[String]	={
		return  this.type1
	}

	def setType( type1: Choice[String]) 	={
		 this.type1 = type1
		 this.keyModified("type") = 1
	}

	def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.createdTime
	}

	def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.createdTime = createdTime
		 this.keyModified("created_time") = 1
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