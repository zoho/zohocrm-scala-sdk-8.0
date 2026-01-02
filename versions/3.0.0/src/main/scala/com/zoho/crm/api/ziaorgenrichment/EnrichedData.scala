package com.zoho.crm.api.ziaorgenrichment

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class EnrichedData extends Model	{
	private var orgStatus:Option[String] = None
	private var description:ArrayBuffer[Description] = _
	private var ceo:Option[String] = None
	private var secondaryEmail:Option[String] = None
	private var revenue:Option[String] = None
	private var yearsInIndustry:Option[String] = None
	private var otherContacts:ArrayBuffer[String] = _
	private var technoGraphicData:Option[String] = None
	private var logo:Option[String] = None
	private var secondaryContact:Option[String] = None
	private var id:Option[String] = None
	private var otherEmails:ArrayBuffer[String] = _
	private var signIn:Option[String] = None
	private var website:Option[String] = None
	private var address:ArrayBuffer[Address] = _
	private var signUp:Option[String] = None
	private var orgType:Option[String] = None
	private var headQuarters:ArrayBuffer[Address] = _
	private var noOfEmployees:Option[String] = None
	private var territoryList:ArrayBuffer[String] = _
	private var foundingYear:Option[String] = None
	private var industries:ArrayBuffer[Industry] = _
	private var name:Option[String] = None
	private var primaryEmail:Option[String] = None
	private var businessModel:ArrayBuffer[String] = _
	private var primaryContact:Option[String] = None
	private var socialMedia:ArrayBuffer[SocialMedia] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getOrgStatus() :Option[String]	={
		return  this.orgStatus
	}

	def setOrgStatus( orgStatus: Option[String]) 	={
		 this.orgStatus = orgStatus
		 this.keyModified("org_status") = 1
	}

	def getDescription() :ArrayBuffer[Description]	={
		return  this.description
	}

	def setDescription( description: ArrayBuffer[Description]) 	={
		 this.description = description
		 this.keyModified("description") = 1
	}

	def getCeo() :Option[String]	={
		return  this.ceo
	}

	def setCeo( ceo: Option[String]) 	={
		 this.ceo = ceo
		 this.keyModified("ceo") = 1
	}

	def getSecondaryEmail() :Option[String]	={
		return  this.secondaryEmail
	}

	def setSecondaryEmail( secondaryEmail: Option[String]) 	={
		 this.secondaryEmail = secondaryEmail
		 this.keyModified("secondary_email") = 1
	}

	def getRevenue() :Option[String]	={
		return  this.revenue
	}

	def setRevenue( revenue: Option[String]) 	={
		 this.revenue = revenue
		 this.keyModified("revenue") = 1
	}

	def getYearsInIndustry() :Option[String]	={
		return  this.yearsInIndustry
	}

	def setYearsInIndustry( yearsInIndustry: Option[String]) 	={
		 this.yearsInIndustry = yearsInIndustry
		 this.keyModified("years_in_industry") = 1
	}

	def getOtherContacts() :ArrayBuffer[String]	={
		return  this.otherContacts
	}

	def setOtherContacts( otherContacts: ArrayBuffer[String]) 	={
		 this.otherContacts = otherContacts
		 this.keyModified("other_contacts") = 1
	}

	def getTechnoGraphicData() :Option[String]	={
		return  this.technoGraphicData
	}

	def setTechnoGraphicData( technoGraphicData: Option[String]) 	={
		 this.technoGraphicData = technoGraphicData
		 this.keyModified("techno_graphic_data") = 1
	}

	def getLogo() :Option[String]	={
		return  this.logo
	}

	def setLogo( logo: Option[String]) 	={
		 this.logo = logo
		 this.keyModified("logo") = 1
	}

	def getSecondaryContact() :Option[String]	={
		return  this.secondaryContact
	}

	def setSecondaryContact( secondaryContact: Option[String]) 	={
		 this.secondaryContact = secondaryContact
		 this.keyModified("secondary_contact") = 1
	}

	def getId() :Option[String]	={
		return  this.id
	}

	def setId( id: Option[String]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getOtherEmails() :ArrayBuffer[String]	={
		return  this.otherEmails
	}

	def setOtherEmails( otherEmails: ArrayBuffer[String]) 	={
		 this.otherEmails = otherEmails
		 this.keyModified("other_emails") = 1
	}

	def getSignIn() :Option[String]	={
		return  this.signIn
	}

	def setSignIn( signIn: Option[String]) 	={
		 this.signIn = signIn
		 this.keyModified("sign_in") = 1
	}

	def getWebsite() :Option[String]	={
		return  this.website
	}

	def setWebsite( website: Option[String]) 	={
		 this.website = website
		 this.keyModified("website") = 1
	}

	def getAddress() :ArrayBuffer[Address]	={
		return  this.address
	}

	def setAddress( address: ArrayBuffer[Address]) 	={
		 this.address = address
		 this.keyModified("address") = 1
	}

	def getSignUp() :Option[String]	={
		return  this.signUp
	}

	def setSignUp( signUp: Option[String]) 	={
		 this.signUp = signUp
		 this.keyModified("sign_up") = 1
	}

	def getOrgType() :Option[String]	={
		return  this.orgType
	}

	def setOrgType( orgType: Option[String]) 	={
		 this.orgType = orgType
		 this.keyModified("org_type") = 1
	}

	def getHeadQuarters() :ArrayBuffer[Address]	={
		return  this.headQuarters
	}

	def setHeadQuarters( headQuarters: ArrayBuffer[Address]) 	={
		 this.headQuarters = headQuarters
		 this.keyModified("head_quarters") = 1
	}

	def getNoOfEmployees() :Option[String]	={
		return  this.noOfEmployees
	}

	def setNoOfEmployees( noOfEmployees: Option[String]) 	={
		 this.noOfEmployees = noOfEmployees
		 this.keyModified("no_of_employees") = 1
	}

	def getTerritoryList() :ArrayBuffer[String]	={
		return  this.territoryList
	}

	def setTerritoryList( territoryList: ArrayBuffer[String]) 	={
		 this.territoryList = territoryList
		 this.keyModified("territory_list") = 1
	}

	def getFoundingYear() :Option[String]	={
		return  this.foundingYear
	}

	def setFoundingYear( foundingYear: Option[String]) 	={
		 this.foundingYear = foundingYear
		 this.keyModified("founding_year") = 1
	}

	def getIndustries() :ArrayBuffer[Industry]	={
		return  this.industries
	}

	def setIndustries( industries: ArrayBuffer[Industry]) 	={
		 this.industries = industries
		 this.keyModified("industries") = 1
	}

	def getName() :Option[String]	={
		return  this.name
	}

	def setName( name: Option[String]) 	={
		 this.name = name
		 this.keyModified("name") = 1
	}

	def getPrimaryEmail() :Option[String]	={
		return  this.primaryEmail
	}

	def setPrimaryEmail( primaryEmail: Option[String]) 	={
		 this.primaryEmail = primaryEmail
		 this.keyModified("primary_email") = 1
	}

	def getBusinessModel() :ArrayBuffer[String]	={
		return  this.businessModel
	}

	def setBusinessModel( businessModel: ArrayBuffer[String]) 	={
		 this.businessModel = businessModel
		 this.keyModified("business_model") = 1
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