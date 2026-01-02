package samples.ziaorgenrichment

import java.lang.reflect.Field
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.util.{APIResponse, Model}
import com.zoho.crm.api.ziaorgenrichment.{ResponseWrapper, APIException, ResponseHandler, ZiaOrgEnrichmentOperations}

object GetZiaOrgEnrichment {

  def getZiaOrgEnrichment(ziaOrgEnrichmentId: Long): Unit = {
    val ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations()
    val response: Option[APIResponse[ResponseHandler]] = ziaOrgEnrichmentOperations.getZiaOrgEnrichment(ziaOrgEnrichmentId)

    if (response != null) {
      response match {
        case Some(apiResponse)=>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case responseWrapper: ResponseWrapper =>
                val ziaOrgEnrichments = responseWrapper.getZiaOrgEnrichment()
                for (ziaOrgEnrichment <- ziaOrgEnrichments) {
                  val enrichedData = ziaOrgEnrichment.getEnrichedData()

                  if (enrichedData != null) {
                    enrichedData match {
                      case Some(enrichedData_1) =>
                        println(s"ZiaOrgEnrichment EnrichedData OrgStatus : ${enrichedData_1.getOrgStatus()}")
                        val descriptions = enrichedData_1.getDescription()
                        for (description <- descriptions) {
                          println(s"ZiaOrgEnrichment EnrichedData Title : ${description.getTitle()}")
                          println(s"ZiaOrgEnrichment EnrichedData Description : ${description.getDescription()}")
                        }

                        println(s"ZiaOrgEnrichment EnrichedData CEO : ${enrichedData_1.getCeo()}")
                        println(s"ZiaOrgEnrichment EnrichedData SecondaryEmail : ${enrichedData_1.getSecondaryEmail()}")
                        println(s"ZiaOrgEnrichment EnrichedData Revenue : ${enrichedData_1.getRevenue()}")
                        println(s"ZiaOrgEnrichment EnrichedData YearsInIndustry : ${enrichedData_1.getYearsInIndustry()}")

                        val otherContacts = enrichedData_1.getOtherContacts()
                        if (otherContacts != null) {
                          for (contact <- otherContacts) {
                            println(s"ZiaOrgEnrichment EnrichedData OtherContacts : $contact")
                          }
                        }

                        println(s"ZiaOrgEnrichment EnrichedData TechnoGraphicData : ${enrichedData_1.getTechnoGraphicData()}")
                        println(s"ZiaOrgEnrichment EnrichedData Logo : ${enrichedData_1.getLogo()}")
                        println(s"ZiaOrgEnrichment EnrichedData SecondaryContact : ${enrichedData_1.getSecondaryContact()}")
                        println(s"ZiaOrgEnrichment EnrichedData Id: ${enrichedData_1.getId()}")

                        val otherEmails = enrichedData_1.getOtherEmails()
                        if (otherEmails != null) {
                          for (email <- otherEmails) {
                            println(s"ZiaOrgEnrichment EnrichedData OtherEmails : $email")
                          }
                        }

                        println(s"ZiaOrgEnrichment EnrichedData SignIn : ${enrichedData_1.getSignIn()}")
                        println(s"ZiaOrgEnrichment EnrichedData Website : ${enrichedData_1.getWebsite()}")

                        val addresses = enrichedData_1.getAddress()
                        for (address <- addresses) {
                          println(s"ZiaOrgEnrichment EnrichedData Address Country : ${address.getCountry()}")
                          println(s"ZiaOrgEnrichment EnrichedData Address City : ${address.getCity()}")
                          println(s"ZiaOrgEnrichment EnrichedData Address PinCode : ${address.getPinCode()}")
                          println(s"ZiaOrgEnrichment EnrichedData Address State : ${address.getState()}")
                          println(s"ZiaOrgEnrichment EnrichedData Address FillAddress : ${address.getFillAddress()}")
                        }

                        println(s"ZiaOrgEnrichment EnrichedData SignUp : ${enrichedData_1.getSignUp()}")
                        println(s"ZiaOrgEnrichment EnrichedData OrgType : ${enrichedData_1.getOrgType()}")

                        val headQuarters = enrichedData_1.getHeadQuarters()
                        if (headQuarters != null) {
                          for (hq <- headQuarters) {
                            println(s"ZiaOrgEnrichment EnrichedData HeadQuarters Country : ${hq.getCountry()}")
                            println(s"ZiaOrgEnrichment EnrichedData HeadQuarters City : ${hq.getCity()}")
                            println(s"ZiaOrgEnrichment EnrichedData HeadQuarters PinCode : ${hq.getPinCode()}")
                            println(s"ZiaOrgEnrichment EnrichedData HeadQuarters State : ${hq.getState()}")
                            println(s"ZiaOrgEnrichment EnrichedData HeadQuarters FillAddress : ${hq.getFillAddress()}")
                          }
                        }

                        println(s"ZiaOrgEnrichment EnrichedData NoOfEmployees : ${enrichedData_1.getNoOfEmployees()}")

                        val territoryList = enrichedData_1.getTerritoryList()
                        if (territoryList != null) {
                          for (territory <- territoryList) {
                            println(s"ZiaOrgEnrichment EnrichedData TerritoryList : $territory")
                          }
                        }

                        println(s"ZiaOrgEnrichment EnrichedData FoundingYear : ${enrichedData_1.getFoundingYear()}")

                        val industries = enrichedData_1.getIndustries()
                        for (industry <- industries) {
                          println(s"ZiaOrgEnrichment EnrichedData Industries Name : ${industry.getName()}")
                          println(s"ZiaOrgEnrichment EnrichedData Industries Description : ${industry.getDescription()}")
                        }

                        println(s"ZiaOrgEnrichment EnrichedData Name : ${enrichedData_1.getName()}")
                        println(s"ZiaOrgEnrichment EnrichedData PrimaryEmail : ${enrichedData_1.getPrimaryEmail()}")

                        val businessModels = enrichedData_1.getBusinessModel()
                        if (businessModels != null) {
                          for (businessModel <- businessModels) {
                            println(s"ZiaOrgEnrichment EnrichedData BusinessModel : $businessModel")
                          }
                        }

                        println(s"ZiaOrgEnrichment EnrichedData PrimaryContact : ${enrichedData_1.getPrimaryContact()}")

                        val socialMedia = enrichedData_1.getSocialMedia()
                        for (media <- socialMedia) {
                          println(s"ZiaOrgEnrichment EnrichedData SocialMedia MediaType : ${media.getMediaType()}")
                          val mediaUrls = media.getMediaUrl()
                          for (url <- mediaUrls) {
                            println(s"ZiaOrgEnrichment EnrichedData SocialMedia MediaUrl : $url")
                          }
                        }
                    }

                    val enrichBasedOn = ziaOrgEnrichment.getEnrichBasedOn()
                    if (enrichBasedOn != null) {
                      enrichBasedOn match {
                        case Some(enrichBasedOn_1) =>
                          println(s"ZiaOrgEnrichment EnrichBasedOn Name : ${enrichBasedOn_1.getName()}")
                          println(s"ZiaOrgEnrichment EnrichBasedOn Email : ${enrichBasedOn_1.getEmail()}")
                          println(s"ZiaOrgEnrichment EnrichBasedOn Website : ${enrichBasedOn_1.getWebsite()}")
                      }
                    }

                    println(s"ZiaOrgEnrichment Id : ${ziaOrgEnrichment.getId()}")
                    println(s"ZiaOrgEnrichment Status : ${ziaOrgEnrichment.getStatus()}")
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

      val ziaOrgEnrichmentId: Long = 753470353001L
      getZiaOrgEnrichment(ziaOrgEnrichmentId)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}
