package com.zoho.crm.api.users

import com.zoho.crm.api.record.Record
import com.zoho.crm.api.tags.Tag
import com.zoho.crm.api.util.Choice
import com.zoho.crm.api.util.Model
import java.time.LocalDate
import java.time.OffsetDateTime
import scala.collection.mutable.ArrayBuffer
import java.util.TimeZone

class Users extends Record with Model	{

	def getCountry() :Option[String]	={
		return  this.getKeyValue("country").asInstanceOf[Option[String]]
	}

	def setCountry( country: Option[String]) 	={
		 this.addKeyValue("country", country)
	}

	def getLanguage() :Option[String]	={
		return  this.getKeyValue("language").asInstanceOf[Option[String]]
	}

	def setLanguage( language: Option[String]) 	={
		 this.addKeyValue("language", language)
	}

	def getMicrosoft() :Option[Boolean]	={
		return  this.getKeyValue("microsoft").asInstanceOf[Option[Boolean]]
	}

	def setMicrosoft( microsoft: Option[Boolean]) 	={
		 this.addKeyValue("microsoft", microsoft)
	}

	def getshiftEffectiveFrom() :Any	={
		return  this.getKeyValue("$shift_effective_from").asInstanceOf[Any]
	}

	def setshiftEffectiveFrom( shiftEffectiveFrom: Any) 	={
		 this.addKeyValue("$shift_effective_from", shiftEffectiveFrom)
	}

	override def getId() :Option[Long]	={
		return  this.getKeyValue("id").asInstanceOf[Option[Long]]
	}

	override def setId( id: Option[Long]) 	={
		 this.addKeyValue("id", id)
	}

	def getState() :Option[String]	={
		return  this.getKeyValue("state").asInstanceOf[Option[String]]
	}

	def setState( state: Option[String]) 	={
		 this.addKeyValue("state", state)
	}

	def getFax() :Option[String]	={
		return  this.getKeyValue("fax").asInstanceOf[Option[String]]
	}

	def setFax( fax: Option[String]) 	={
		 this.addKeyValue("fax", fax)
	}

	def getCountryLocale() :Option[String]	={
		return  this.getKeyValue("country_locale").asInstanceOf[Option[String]]
	}

	def setCountryLocale( countryLocale: Option[String]) 	={
		 this.addKeyValue("country_locale", countryLocale)
	}

	def getZip() :Option[String]	={
		return  this.getKeyValue("zip").asInstanceOf[Option[String]]
	}

	def setZip( zip: Option[String]) 	={
		 this.addKeyValue("zip", zip)
	}

	override def getCreatedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("created_time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setCreatedTime( createdTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("created_time", createdTime)
	}

	def getTimeFormat() :Choice[String]	={
		return  this.getKeyValue("time_format").asInstanceOf[Choice[String]]
	}

	def setTimeFormat( timeFormat: Choice[String]) 	={
		 this.addKeyValue("time_format", timeFormat)
	}

	def getOffset() :Option[Int]	={
		return  this.getKeyValue("offset").asInstanceOf[Option[Int]]
	}

	def setOffset( offset: Option[Int]) 	={
		 this.addKeyValue("offset", offset)
	}

	def getImapStatus() :Option[Boolean]	={
		return  this.getKeyValue("imap_status").asInstanceOf[Option[Boolean]]
	}

	def setImapStatus( imapStatus: Option[Boolean]) 	={
		 this.addKeyValue("imap_status", imapStatus)
	}

	def getImageLink() :Option[String]	={
		return  this.getKeyValue("image_link").asInstanceOf[Option[String]]
	}

	def setImageLink( imageLink: Option[String]) 	={
		 this.addKeyValue("image_link", imageLink)
	}

	def getEzuid() :Option[String]	={
		return  this.getKeyValue("ezuid").asInstanceOf[Option[String]]
	}

	def setEzuid( ezuid: Option[String]) 	={
		 this.addKeyValue("ezuid", ezuid)
	}

	def getProfile() :Option[Profile]	={
		return  this.getKeyValue("profile").asInstanceOf[Option[Profile]]
	}

	def setProfile( profile: Option[Profile]) 	={
		 this.addKeyValue("profile", profile)
	}

	def getRole() :Option[Role]	={
		return  this.getKeyValue("role").asInstanceOf[Option[Role]]
	}

	def setRole( role: Option[Role]) 	={
		 this.addKeyValue("role", role)
	}

	override def getCreatedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("created_by").asInstanceOf[Option[MinifiedUser]]
	}

	override def setCreatedBy( createdBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("created_by", createdBy)
	}

	def getFullName() :Option[String]	={
		return  this.getKeyValue("full_name").asInstanceOf[Option[String]]
	}

	def setFullName( fullName: Option[String]) 	={
		 this.addKeyValue("full_name", fullName)
	}

	def getZuid() :Option[String]	={
		return  this.getKeyValue("zuid").asInstanceOf[Option[String]]
	}

	def setZuid( zuid: Option[String]) 	={
		 this.addKeyValue("zuid", zuid)
	}

	def getPhone() :Option[String]	={
		return  this.getKeyValue("phone").asInstanceOf[Option[String]]
	}

	def setPhone( phone: Option[String]) 	={
		 this.addKeyValue("phone", phone)
	}

	def getDob() :Option[LocalDate]	={
		return  this.getKeyValue("dob").asInstanceOf[Option[LocalDate]]
	}

	def setDob( dob: Option[LocalDate]) 	={
		 this.addKeyValue("dob", dob)
	}

	def getStatus() :Option[String]	={
		return  this.getKeyValue("status").asInstanceOf[Option[String]]
	}

	def setStatus( status: Option[String]) 	={
		 this.addKeyValue("status", status)
	}

	def getCustomizeInfo() :Option[CustomizeInfo]	={
		return  this.getKeyValue("customize_info").asInstanceOf[Option[CustomizeInfo]]
	}

	def setCustomizeInfo( customizeInfo: Option[CustomizeInfo]) 	={
		 this.addKeyValue("customize_info", customizeInfo)
	}

	def getCity() :Option[String]	={
		return  this.getKeyValue("city").asInstanceOf[Option[String]]
	}

	def setCity( city: Option[String]) 	={
		 this.addKeyValue("city", city)
	}

	def getSignature() :Option[String]	={
		return  this.getKeyValue("signature").asInstanceOf[Option[String]]
	}

	def setSignature( signature: Option[String]) 	={
		 this.addKeyValue("signature", signature)
	}

	def getSortOrderPreferenceS() :Option[String]	={
		return  this.getKeyValue("sort_order_preference__s").asInstanceOf[Option[String]]
	}

	def setSortOrderPreferenceS( sortOrderPreferenceS: Option[String]) 	={
		 this.addKeyValue("sort_order_preference__s", sortOrderPreferenceS)
	}

	def getCategory() :Option[String]	={
		return  this.getKeyValue("category").asInstanceOf[Option[String]]
	}

	def setCategory( category: Option[String]) 	={
		 this.addKeyValue("category", category)
	}

	def getDateFormat() :Choice[String]	={
		return  this.getKeyValue("date_format").asInstanceOf[Choice[String]]
	}

	def setDateFormat( dateFormat: Choice[String]) 	={
		 this.addKeyValue("date_format", dateFormat)
	}

	def getConfirm() :Option[Boolean]	={
		return  this.getKeyValue("confirm").asInstanceOf[Option[Boolean]]
	}

	def setConfirm( confirm: Option[Boolean]) 	={
		 this.addKeyValue("confirm", confirm)
	}

	def getDecimalSeparator() :Choice[String]	={
		return  this.getKeyValue("decimal_separator").asInstanceOf[Choice[String]]
	}

	def setDecimalSeparator( decimalSeparator: Choice[String]) 	={
		 this.addKeyValue("decimal_separator", decimalSeparator)
	}

	def getNumberSeparator() :Choice[String]	={
		return  this.getKeyValue("number_separator").asInstanceOf[Choice[String]]
	}

	def setNumberSeparator( numberSeparator: Choice[String]) 	={
		 this.addKeyValue("number_separator", numberSeparator)
	}

	def getTimeZone() :Option[TimeZone]	={
		return  this.getKeyValue("time_zone").asInstanceOf[Option[TimeZone]]
	}

	def setTimeZone( timeZone: Option[TimeZone]) 	={
		 this.addKeyValue("time_zone", timeZone)
	}

	def getLastName() :Option[String]	={
		return  this.getKeyValue("last_name").asInstanceOf[Option[String]]
	}

	def setLastName( lastName: Option[String]) 	={
		 this.addKeyValue("last_name", lastName)
	}

	def getMobile() :Option[String]	={
		return  this.getKeyValue("mobile").asInstanceOf[Option[String]]
	}

	def setMobile( mobile: Option[String]) 	={
		 this.addKeyValue("mobile", mobile)
	}

	def getcurrentShift() :Option[Shift]	={
		return  this.getKeyValue("$current_shift").asInstanceOf[Option[Shift]]
	}

	def setcurrentShift( currentShift: Option[Shift]) 	={
		 this.addKeyValue("$current_shift", currentShift)
	}

	def getReportingTo() :Option[MinifiedUser]	={
		return  this.getKeyValue("Reporting_To").asInstanceOf[Option[MinifiedUser]]
	}

	def setReportingTo( reportingTo: Option[MinifiedUser]) 	={
		 this.addKeyValue("Reporting_To", reportingTo)
	}

	def getCurrency() :Option[String]	={
		return  this.getKeyValue("Currency").asInstanceOf[Option[String]]
	}

	def setCurrency( currency: Option[String]) 	={
		 this.addKeyValue("Currency", currency)
	}

	def getnextShift() :Option[Shift]	={
		return  this.getKeyValue("$next_shift").asInstanceOf[Option[Shift]]
	}

	def setnextShift( nextShift: Option[Shift]) 	={
		 this.addKeyValue("$next_shift", nextShift)
	}

	override def getModifiedTime() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Modified_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	override def setModifiedTime( modifiedTime: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Modified_Time", modifiedTime)
	}

	def getWebsite() :Option[String]	={
		return  this.getKeyValue("website").asInstanceOf[Option[String]]
	}

	def setWebsite( website: Option[String]) 	={
		 this.addKeyValue("website", website)
	}

	def getStatusReasonS() :Option[String]	={
		return  this.getKeyValue("status_reason__s").asInstanceOf[Option[String]]
	}

	def setStatusReasonS( statusReasonS: Option[String]) 	={
		 this.addKeyValue("status_reason__s", statusReasonS)
	}

	def getEmail() :Option[String]	={
		return  this.getKeyValue("email").asInstanceOf[Option[String]]
	}

	def setEmail( email: Option[String]) 	={
		 this.addKeyValue("email", email)
	}

	def getFirstName() :Option[String]	={
		return  this.getKeyValue("first_name").asInstanceOf[Option[String]]
	}

	def setFirstName( firstName: Option[String]) 	={
		 this.addKeyValue("first_name", firstName)
	}

	def getSandboxdeveloper() :Option[Boolean]	={
		return  this.getKeyValue("sandboxDeveloper").asInstanceOf[Option[Boolean]]
	}

	def setSandboxdeveloper( sandboxdeveloper: Option[Boolean]) 	={
		 this.addKeyValue("sandboxDeveloper", sandboxdeveloper)
	}

	def getAlias() :Option[String]	={
		return  this.getKeyValue("alias").asInstanceOf[Option[String]]
	}

	def setAlias( alias: Option[String]) 	={
		 this.addKeyValue("alias", alias)
	}

	def getStreet() :Option[String]	={
		return  this.getKeyValue("street").asInstanceOf[Option[String]]
	}

	def setStreet( street: Option[String]) 	={
		 this.addKeyValue("street", street)
	}

	override def getModifiedBy() :Option[MinifiedUser]	={
		return  this.getKeyValue("Modified_By").asInstanceOf[Option[MinifiedUser]]
	}

	override def setModifiedBy( modifiedBy: Option[MinifiedUser]) 	={
		 this.addKeyValue("Modified_By", modifiedBy)
	}

	def getIsonline() :Option[Boolean]	={
		return  this.getKeyValue("Isonline").asInstanceOf[Option[Boolean]]
	}

	def setIsonline( isonline: Option[Boolean]) 	={
		 this.addKeyValue("Isonline", isonline)
	}

	def getLocale() :Option[String]	={
		return  this.getKeyValue("locale").asInstanceOf[Option[String]]
	}

	def setLocale( locale: Option[String]) 	={
		 this.addKeyValue("locale", locale)
	}

	def getNameFormatS() :Choice[String]	={
		return  this.getKeyValue("name_format__s").asInstanceOf[Choice[String]]
	}

	def setNameFormatS( nameFormatS: Choice[String]) 	={
		 this.addKeyValue("name_format__s", nameFormatS)
	}

	def getPersonalAccount() :Option[Boolean]	={
		return  this.getKeyValue("personal_account").asInstanceOf[Option[Boolean]]
	}

	def setPersonalAccount( personalAccount: Option[Boolean]) 	={
		 this.addKeyValue("personal_account", personalAccount)
	}

	def getDefaultTabGroup() :Option[String]	={
		return  this.getKeyValue("default_tab_group").asInstanceOf[Option[String]]
	}

	def setDefaultTabGroup( defaultTabGroup: Option[String]) 	={
		 this.addKeyValue("default_tab_group", defaultTabGroup)
	}

	def getTheme() :Option[Theme]	={
		return  this.getKeyValue("theme").asInstanceOf[Option[Theme]]
	}

	def setTheme( theme: Option[Theme]) 	={
		 this.addKeyValue("theme", theme)
	}

	def getNtcNotificationType() :ArrayBuffer[Long]	={
		return  this.getKeyValue("ntc_notification_type").asInstanceOf[ArrayBuffer[Long]]
	}

	def setNtcNotificationType( ntcNotificationType: ArrayBuffer[Long]) 	={
		 this.addKeyValue("ntc_notification_type", ntcNotificationType)
	}

	def getNtcEnabled() :Option[Boolean]	={
		return  this.getKeyValue("ntc_enabled").asInstanceOf[Option[Boolean]]
	}

	def setNtcEnabled( ntcEnabled: Option[Boolean]) 	={
		 this.addKeyValue("ntc_enabled", ntcEnabled)
	}

	def getRtlEnabled() :Option[Boolean]	={
		return  this.getKeyValue("rtl_enabled").asInstanceOf[Option[Boolean]]
	}

	def setRtlEnabled( rtlEnabled: Option[Boolean]) 	={
		 this.addKeyValue("rtl_enabled", rtlEnabled)
	}

	def getTelephonyEnabled() :Option[Boolean]	={
		return  this.getKeyValue("telephony_enabled").asInstanceOf[Option[Boolean]]
	}

	def setTelephonyEnabled( telephonyEnabled: Option[Boolean]) 	={
		 this.addKeyValue("telephony_enabled", telephonyEnabled)
	}

	def getSortOrderPreference() :Option[String]	={
		return  this.getKeyValue("sort_order_preference").asInstanceOf[Option[String]]
	}

	def setSortOrderPreference( sortOrderPreference: Option[String]) 	={
		 this.addKeyValue("sort_order_preference", sortOrderPreference)
	}

	def getCreatedBy17() :Option[MinifiedUser]	={
		return  this.getKeyValue("Created_By").asInstanceOf[Option[MinifiedUser]]
	}

	def setCreatedBy17( createdBy17: Option[MinifiedUser]) 	={
		 this.addKeyValue("Created_By", createdBy17)
	}

	def getCreatedTime9() :Option[OffsetDateTime]	={
		return  this.getKeyValue("Created_Time").asInstanceOf[Option[OffsetDateTime]]
	}

	def setCreatedTime9( createdTime9: Option[OffsetDateTime]) 	={
		 this.addKeyValue("Created_Time", createdTime9)
	}

	override def getTag() :ArrayBuffer[Tag]	={
		return  this.getKeyValue("Tag").asInstanceOf[ArrayBuffer[Tag]]
	}

	override def setTag( tag: ArrayBuffer[Tag]) 	={
		 this.addKeyValue("Tag", tag)
	}

	override def getName() :Option[String]	={
		return  this.getKeyValue("name").asInstanceOf[Option[String]]
	}

	override def setName( name: Option[String]) 	={
		 this.addKeyValue("name", name)
	}}