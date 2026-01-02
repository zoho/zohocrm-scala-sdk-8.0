package samples.ziapeopleenrichment

import java.lang.reflect.Field
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import com.zoho.crm.api.util.{APIResponse, Model}
import com.zoho.crm.api.ziapeopleenrichment.{ResponseWrapper, APIException, ResponseHandler, ZiaPeopleEnrichmentOperations}

object GetZiaPeopleEnrichment {

  def getZiaPeopleEnrichment(ziapeopleenrichmentId: Long): Unit = {
    val ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations()
    val response: Option[APIResponse[ResponseHandler]] = ziaPeopleEnrichmentOperations.getZiaPeopleEnrichment(ziapeopleenrichmentId)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case responseWrapper: ResponseWrapper =>
                val ziaPeopleEnrichments = responseWrapper.getZiaPeopleEnrichment()
                for (ziapeopleenrichment <- ziaPeopleEnrichments) {
                  val enrichedData = ziapeopleenrichment.getEnrichedData()

                  if (enrichedData != null) {
                    enrichedData match {
                      case Some(enrichedData_1) =>
                        println(s"ZiaPeopleEnrichment EnrichedData Website : ${enrichedData_1.getWebsite()}")

                        val emailInfos = enrichedData_1.getEmailInfos()
                        if (emailInfos != null) {
                          for (emailInfo <- emailInfos) {
                            println(s"ZiaPeopleEnrichment EnrichedData EmailInfo Type : ${emailInfo.getType()}")
                            println(s"ZiaPeopleEnrichment EnrichedData EmailInfo Email : ${emailInfo.getEmail()}")
                          }
                        }

                        println(s"ZiaPeopleEnrichment EnrichedData Gender : ${enrichedData_1.getGender()}")

                        val companyInfo = enrichedData_1.getCompanyInfo()
                        if (companyInfo != null) {
                          companyInfo match {
                            case Some(companyInfo_1) =>
                              println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Name : ${companyInfo_1.getName()}")

                              val industries = companyInfo_1.getIndustries()
                              for (industry <- industries) {
                                println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Industries Name : ${industry.getName()}")
                                println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Industries Description : ${industry.getDescription()}")
                              }

                              val experiences = companyInfo_1.getExperiences()
                              if (experiences != null) {
                                for (experience <- experiences) {
                                  println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Experience EndDate : ${experience.getEndDate()}")
                                  println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Experience CompanyName : ${experience.getCompanyName()}")
                                  println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Experience Title : ${experience.getTitle()}")
                                  println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Experience StartDate : ${experience.getStartDate()}")
                                  println(s"ZiaPeopleEnrichment EnrichedData CompanyInfo Experience Primary : ${experience.getPrimary()}")
                                }
                              }
                            case None =>

                          }
                        }

                        println(s"ZiaPeopleEnrichment EnrichedData LastName : ${enrichedData_1.getLastName()}")

                        val educations = enrichedData_1.getEducations()
                        if (educations != null) {
                          println("ZiaPeopleEnrichment EnrichedData Educations : ")
                          println(educations.mkString(", "))
                        }

                        println(s"ZiaPeopleEnrichment EnrichedData MiddleName : ${enrichedData_1.getMiddleName()}")

                        val skills = enrichedData_1.getSkills()
                        if (skills != null) {
                          println("ZiaPeopleEnrichment EnrichedData Skills : ")
                          println(skills.mkString(", "))
                        }

                        val otherContacts = enrichedData_1.getOtherContacts()
                        if (otherContacts != null) {
                          for (otherContact <- otherContacts) {
                            println(s"ZiaPeopleEnrichment EnrichedData OtherContacts : $otherContact")
                          }
                        }

                        val addressListInfo = enrichedData_1.getAddressListInfo()
                        if (addressListInfo != null) {
                          for (address <- addressListInfo) {
                            println(s"ZiaPeopleEnrichment EnrichedData AddressListInfo Continent : ${address.getContinent()}")
                            println(s"ZiaPeopleEnrichment EnrichedData AddressListInfo Country : ${address.getCountry()}")
                            println(s"ZiaPeopleEnrichment EnrichedData AddressListInfo Name : ${address.getName()}")
                            println(s"ZiaPeopleEnrichment EnrichedData AddressListInfo Region : ${address.getRegion()}")
                            println(s"ZiaPeopleEnrichment EnrichedData AddressListInfo Primary : ${address.getPrimary()}")
                          }
                        }

                        val primaryAddressInfo = enrichedData_1.getPrimaryAddressInfo()
                        if (primaryAddressInfo != null) {
                          primaryAddressInfo match {
                            case Some(primaryAddressInfo_1) =>
                              println(s"ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Continent : ${primaryAddressInfo_1.getContinent()}")
                              println(s"ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Country : ${primaryAddressInfo_1.getCountry()}")
                              println(s"ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Name : ${primaryAddressInfo_1.getName()}")
                              println(s"ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Region : ${primaryAddressInfo_1.getRegion()}")
                              println(s"ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Primary : ${primaryAddressInfo_1.getPrimary()}")
                          }
                        }

                        println(s"ZiaPeopleEnrichment EnrichedData Name : ${enrichedData_1.getName()}")
                        println(s"ZiaPeopleEnrichment EnrichedData SecondaryContact : ${enrichedData_1.getSecondaryContact()}")
                        println(s"ZiaPeopleEnrichment EnrichedData PrimaryEmail : ${enrichedData_1.getPrimaryEmail()}")
                        println(s"ZiaPeopleEnrichment EnrichedData Designation : ${enrichedData_1.getDesignation()}")
                        println(s"ZiaPeopleEnrichment EnrichedData Id : ${enrichedData_1.getId()}")

                        val interests = enrichedData_1.getInterests()
                        if (interests != null) {
                          println("ZiaPeopleEnrichment EnrichedData Interests : ")
                          println(interests.mkString(", "))
                        }

                        println(s"ZiaPeopleEnrichment EnrichedData FirstName : ${enrichedData_1.getFirstName()}")
                        println(s"ZiaPeopleEnrichment EnrichedData PrimaryContact : ${enrichedData_1.getPrimaryContact()}")

                        val socialMedia = enrichedData_1.getSocialMedia()
                        if (socialMedia != null) {
                          for (socialMediaItem <- socialMedia) {
                            println(s"ZiaPeopleEnrichment EnrichedData SocialMedia MediaType : ${socialMediaItem.getMediaType()}")
                            val mediaUrls = socialMediaItem.getMediaUrl()
                            for (mediaUrl <- mediaUrls) {
                              println(s"ZiaPeopleEnrichment EnrichedData SocialMedia MediaUrl: $mediaUrl")
                            }
                          }
                        }
                    }

                    val enrichBasedOn = ziapeopleenrichment.getEnrichBasedOn()
                    if (enrichBasedOn != null) {
                      enrichBasedOn match {
                        case Some(enrichBasedOn) =>
                          val social = enrichBasedOn.getSocial()
                          if (social != null) {
                            social match {
                              case Some(social_1)=>
                                println(s"ZiaPeopleEnrichment EnrichBasedOn Social Facebook : ${social_1.getFacebook()}")
                                println(s"ZiaPeopleEnrichment EnrichBasedOn Social Linkedin : ${social_1.getLinkedin()}")
                                println(s"ZiaPeopleEnrichment EnrichBasedOn Social Twitter : ${social_1.getTwitter()}")
                              case None =>
                            }
                          }

                          println(s"ZiaPeopleEnrichment EnrichBasedOn Name : ${enrichBasedOn.getName()}")

                          val company = enrichBasedOn.getCompany()
                          if (company != null) {
                            company match {
                              case Some(company_1)=>
                                println(s"ZiaPeopleEnrichment EnrichBasedOn Company Website : ${company_1.getWebsite()}")
                                println(s"ZiaPeopleEnrichment EnrichBasedOn Company Name : ${company_1.getName()}")
                            }
                          }

                          println(s"ZiaPeopleEnrichment EnrichBasedOn Email : ${enrichBasedOn.getEmail()}")
                      }
                    }

                    println(s"ZiaPeopleEnrichment Id : ${ziapeopleenrichment.getId()}")
                    println(s"ZiaPeopleEnrichment Status : ${ziapeopleenrichment.getStatus()}")
                  }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")
            }
          } else if (apiResponse.getStatusCode != 204) {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()
      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val ziaPeopleEnrichmentId: Long = 753470346009L
      getZiaPeopleEnrichment(ziaPeopleEnrichmentId)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}
