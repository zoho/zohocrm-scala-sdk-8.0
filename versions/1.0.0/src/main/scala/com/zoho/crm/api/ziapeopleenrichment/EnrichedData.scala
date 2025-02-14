package com.zoho.crm.api.ziapeopleenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class EnrichedData extends Model	{
	private var website:Option[String] = None
	private var emailInfos:ArrayBuffer[EmailInfo] = _
	private var gender:Option[String] = None
	private var companyInfo:Option[CompanyInfo] = None
	private var lastName:Option[String] = None
	private var educations:ArrayBuffer[Any] = _
	private var middleName:Option[String] = None
	private var skills:ArrayBuffer[Any] = _
	private var otherContacts:ArrayBuffer[String] = _
	private var addressListInfo:ArrayBuffer[Address] = _
	private var primaryAddressInfo:Option[Address] = None
	private var name:Option[String] = None
	private var secondaryContact:Option[String] = None
	private var primaryEmail:Option[String] = None
	private var designation:Option[String] = None
	private var id:Option[String] = None
	private var interests:ArrayBuffer[Any] = _
	private var firstName:Option[String] = None
	private var primaryContact:Option[String] = None
	private var socialMedia:ArrayBuffer[SocialMedia] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getWebsite() :Option[String]	={
		return  this.website
	}

	def setWebsite( website: Option[String]) 	={
		 this.website = website
		 this.keyModified("website") = 1
	}

	def getEmailInfos() :ArrayBuffer[EmailInfo]	={
		return  this.emailInfos
	}

	def setEmailInfos( emailInfos: ArrayBuffer[EmailInfo]) 	={
		 this.emailInfos = emailInfos
		 this.keyModified("email_infos") = 1
	}

	def getGender() :Option[String]	={
		return  this.gender
	}

	def setGender( gender: Option[String]) 	={
		 this.gender = gender
		 this.keyModified("gender") = 1
	}

	def getCompanyInfo() :Option[CompanyInfo]	={
		return  this.companyInfo
	}

	def setCompanyInfo( companyInfo: Option[CompanyInfo]) 	={
		 this.companyInfo = companyInfo
		 this.keyModified("company_info") = 1
	}

	def getLastName() :Option[String]	={
		return  this.lastName
	}

	def setLastName( lastName: Option[String]) 	={
		 this.lastName = lastName
		 this.keyModified("last_name") = 1
	}

	def getEducations() :ArrayBuffer[Any]	={
		return  this.educations
	}

	def setEducations( educations: ArrayBuffer[Any]) 	={
		 this.educations = educations
		 this.keyModified("educations") = 1
	}

	def getMiddleName() :Option[String]	={
		return  this.middleName
	}

	def setMiddleName( middleName: Option[String]) 	={
		 this.middleName = middleName
		 this.keyModified("middle_name") = 1
	}

	def getSkills() :ArrayBuffer[Any]	={
		return  this.skills
	}

	def setSkills( skills: ArrayBuffer[Any]) 	={
		 this.skills = skills
		 this.keyModified("skills") = 1
	}

	def getOtherContacts() :ArrayBuffer[String]	={
		return  this.otherContacts
	}

	def setOtherContacts( otherContacts: ArrayBuffer[String]) 	={
		 this.otherContacts = otherContacts
		 this.keyModified("other_contacts") = 1
	}

	def getAddressListInfo() :ArrayBuffer[Address]	={
		return  this.addressListInfo
	}

	def setAddressListInfo( addressListInfo: ArrayBuffer[Address]) 	={
		 this.addressListInfo = addressListInfo
		 this.keyModified("address_list_info") = 1
	}

	def getPrimaryAddressInfo() :Option[Address]	={
		return  this.primaryAddressInfo
	}

	def setPrimaryAddressInfo( primaryAddressInfo: Option[Address]) 	={
		 this.primaryAddressInfo = primaryAddressInfo
		 this.keyModified("primary_address_info") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getSecondaryContact() :Option[String]	={
		return  this.secondaryContact
	}

	def setSecondaryContact( secondaryContact: Option[String]) 	={
		 this.secondaryContact = secondaryContact
		 this.keyModified("secondary_contact") = 1
	}

	def getPrimaryEmail() :Option[String]	={
		return  this.primaryEmail
	}

	def setPrimaryEmail( primaryEmail: Option[String]) 	={
		 this.primaryEmail = primaryEmail
		 this.keyModified("primary_email") = 1
	}

	def getDesignation() :Option[String]	={
		return  this.designation
	}

	def setDesignation( designation: Option[String]) 	={
		 this.designation = designation
		 this.keyModified("designation") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getInterests() :ArrayBuffer[Any]	={
		return  this.interests
	}

	def setInterests( interests: ArrayBuffer[Any]) 	={
		 this.interests = interests
		 this.keyModified("interests") = 1
	}

	def getFirstName() :Option[String]	={
		return  this.firstName
	}

	def setFirstName( firstName: Option[String]) 	={
		 this.firstName = firstName
		 this.keyModified("first_name") = 1
	}

	def getPrimaryContact() :Option[String]	={
		return  this.primaryContact
	}

	def setPrimaryContact( primaryContact: Option[String]) 	={
		 this.primaryContact = primaryContact
		 this.keyModified("primary_contact") = 1
	}

	def getSocialMedia() :ArrayBuffer[SocialMedia]	={
		return  this.socialMedia
	}

	def setSocialMedia( socialMedia: ArrayBuffer[SocialMedia]) 	={
		 this.socialMedia = socialMedia
		 this.keyModified("social_media") = 1
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